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
package at.bestsolution.e4.extensions.lifecycle.impl;

import javax.inject.Inject;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.osgi.service.prefs.BackingStoreException;

import at.bestsolution.e4.extensions.core.services.RestartService;

@SuppressWarnings("restriction")
public class RestartServiceImpl implements RestartService {
	@Inject
	@Preference
	IEclipsePreferences prefNode;
	
	@Optional
	@Inject
	IWorkbench workbench;
	
	@Override
	public void scheduleClear() {
		prefNode.putBoolean("clearWorkspace", true);
		try {
			prefNode.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void unscheduleClear() {
		prefNode.remove("clearWorkspace");
		try {
			prefNode.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean isClear() {
		return prefNode.getBoolean("clearWorkspace", false);
	}

	@Override
	public boolean restart(boolean clear) {
		if( workbench != null ) {
			if( clear ) {
				scheduleClear();	
			}
			workbench.restart();
			return true;
		}
		
		return false;
	}
	
}