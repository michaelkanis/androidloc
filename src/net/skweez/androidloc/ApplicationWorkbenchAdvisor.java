/*-----------------------------------------------------------------------+
 | net.skweez.androidloc
 |                                                                       |
 | $Id$            
 +-----------------------------------------------------------------------*/
package net.skweez.androidloc;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * 
 * @author mks
 * @author $Author: mks $
 * @version $Rev$
 * @levd.rating RED Hash:
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	/** {@inheritDoc} */
	@Override
	public String getInitialWindowPerspectiveId() {
		return Perspective.ID;
	}

	/** {@inheritDoc} */
	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {

		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

}
