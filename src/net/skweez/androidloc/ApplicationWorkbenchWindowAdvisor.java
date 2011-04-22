/*-----------------------------------------------------------------------+
 | net.skweez.androidloc
 |                                                                       |
 | $Id$            
 +-----------------------------------------------------------------------*/
package net.skweez.androidloc;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * 
 * @author mks
 * @author $Author: mks $
 * @version $Rev$
 * @levd.rating RED Hash:
 */
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	/**
	 * @param configurer
	 */
	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	@Override
	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(800, 600));
		configurer.setShowCoolBar(false);
		configurer.setShowStatusLine(false);
		configurer.setTitle("AndroidLoc");
	}

}
