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

import net.skweez.geoclipse.map.MapView;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author "Michael Kanis"
 */
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
