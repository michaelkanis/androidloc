package net.skweez.androidloc;

import net.skweez.geoclipse.map.MapView;
import net.skweez.geoclipse.map.Overlay;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;

public class AndroidLocOverlay extends Overlay {

	public AndroidLocOverlay() {
	}

	@Override
	public void draw(GC gc, MapView mapView, boolean shadow) {
		Rectangle clip = gc.getClipping();

		for (int i = 0; i < 1; i++) {
			gc.setBackground(new Color(gc.getDevice(), 255, 100, 0));
			gc.setAlpha(100);
			gc.fillOval(i * 3 + 100, 150, 50, 50);

			gc.setAlpha(255);
			gc.drawOval(i * 3 + 100, 150, 50, 50);
		}
	};
}
