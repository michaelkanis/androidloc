package net.skweez.androidloc;

import java.awt.Dimension;
import java.awt.Point;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.List;

import net.skweez.geoclipse.map.MapView;
import net.skweez.geoclipse.map.Overlay;
import net.skweez.geoclipse.map.Projection;
import net.skweez.geoclipse.map.tilefactories.ITileFactory;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

public class AndroidLocOverlay extends Overlay {

	private List<Record> records;

	public AndroidLocOverlay() {
		FileDialog fileDialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.OPEN);

		fileDialog.open();

		LocationCacheParser parser = new LocationCacheParser();

		String fileName = fileDialog.getFileName();
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
	public void draw(GC gc, MapView mapView, boolean shadowLayer) {

		if (records == null) {
			return;
		}

		if (shadowLayer) {
			return;
		}

		for (Record record : records) {
			drawRecord(gc, mapView, record);
		}
	}

	private void drawRecord(GC gc, MapView mapView, Record record) {
		ITileFactory tileFactory = mapView.getTileFactory();
		Projection projection = mapView.getProjection();

		Dimension dim = tileFactory.getMapSizeInPixels(mapView.getZoomLevel());

		Point p = projection.geoToPixel(record.getLocation(), dim.width,
				dim.height);

		gc.setBackground(new Color(gc.getDevice(), 255, 100, 0));
		gc.setForeground(gc.getBackground());

		int diameter = record.getAccuracy();
		diameter /= tileFactory.getMaximumZoom() - mapView.getZoomLevel() + 1;

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
