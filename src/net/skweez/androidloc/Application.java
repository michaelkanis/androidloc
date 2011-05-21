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

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * @author "Michael Kanis"
 */
public class Application implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		Display display = PlatformUI.createDisplay();

		try {
			PlatformUI.createAndRunWorkbench(display,
					new ApplicationWorkbenchAdvisor());
		} finally {
			display.dispose();
		}

		return IApplication.EXIT_OK;
	}

	@Override
	public void stop() {
		// Do nothing
	}

}
