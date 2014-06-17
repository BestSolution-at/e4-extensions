/*******************************************************************************
 * Copyright (c) 2014 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.e4.extensions.lifecycle;

import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;

import at.bestsolution.e4.extensions.core.services.RestartService;

@SuppressWarnings("restriction")
public class ExtensibleLifecycle {
	
	@PostContextCreate
	public void init(RestartService service) {
		if( service.isClear() ) {
			service.unscheduleClear();
			System.getProperties().put(IWorkbench.CLEAR_PERSISTED_STATE, "true");
		} else {
			System.err.println("No clearance");
		}
	}
}
