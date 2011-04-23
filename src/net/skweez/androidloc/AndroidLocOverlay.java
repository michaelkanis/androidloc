package net.skweez.androidloc;

import net.skweez.geoclipse.map.MapView;
import net.skweez.geoclipse.map.Overlay;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;

public class AndroidLocOverlay extends Overlay {

	private static final int DIAMETER = 20;

	@Override
	public void draw(GC gc, MapView mapView, boolean shadow) {
		for (int i = 0; i < 2; i++) {
			gc.setBackground(new Color(gc.getDevice(), 255, 100, 0));
			// gc.setAlpha(100);
			gc.fillOval(i * 30 + 300, i * 30 + 250, DIAMETER, DIAMETER);

			gc.setAlpha(255);
			gc.drawOval(i * 30 + 300, i * 30 + 250, DIAMETER, DIAMETER);
		}
	}
}
