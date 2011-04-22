package net.skweez.androidloc;

import net.skweez.geoclipse.map.MapView;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public static final String ID = "net.skweez.androidloc.perspective";

	@Override
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		layout.addStandaloneView(MapView.ID, false, IPageLayout.LEFT, 1.0f,
				layout.getEditorArea());
	}

}
