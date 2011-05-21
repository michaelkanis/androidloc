/*
 *  Copyright (C) 2011 Michael Kanis
 *  
 *  This file is part of AndroidLoc.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.skweez.androidloc;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.List;

import net.skweez.geoclipse.map.MapView;
import net.skweez.geoclipse.map.Overlay;
import net.skweez.geoclipse.map.Projection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

/**
 * @author "Michael Kanis"
 */
public class AndroidLocOverlay extends Overlay {

	private List<Record> records;

	// TODO Do data loading in a thread
	public AndroidLocOverlay() {
		FileDialog fileDialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.OPEN);

		String fileName = fileDialog.open();

		LocationCacheParser parser = new LocationCacheParser();

		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			DataInputStream inputStream = new DataInputStream(fileInputStream);
			records = parser.parse(inputStream);
		} catch (Exception e) {
			// TODO show an error dialog
			System.err.println(e.getMessage());
		}

	}

	/** {@inheritDoc} */
	@Override
	public void draw(GC gc, MapView mapView) {

		if (records == null) {
			return;
		}

		for (Record record : records) {
			drawRecord(gc, mapView, record);
		}
	}

	private void drawRecord(GC gc, MapView mapView, Record record) {
		// TODO Only draw records inside the clipping area

		Projection projection = mapView.getProjection();
		Point p = projection.geoToPixel(record.getLocation());

		gc.setBackground(new Color(gc.getDevice(), 255, 100, 0));
		gc.setForeground(gc.getBackground());

		int diameter = record.getAccuracy();
		diameter /= mapView.getMaxZoomLevel() - mapView.getZoomLevel() + 1;

		drawCircle(gc, p.x, p.y, Math.round(diameter));
	}

	private void drawCircle(GC gc, int x, int y, int diameter) {
		int left = x - diameter / 2;
		int top = y - diameter / 2;

		gc.setAlpha(100);
		gc.fillOval(left, top, diameter, diameter);

		gc.setAlpha(255);
		gc.drawOval(left, top, diameter, diameter);
	}
}
