package net.skweez.androidloc;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

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
