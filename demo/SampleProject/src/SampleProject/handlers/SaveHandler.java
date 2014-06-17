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
package SampleProject.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.modeling.EPartService;

public class SaveHandler {

	@CanExecute
	public boolean canExecute(EPartService partService) {
		if (partService != null) {
			return !partService.getDirtyParts().isEmpty();
		}
		return false;
	}

	@Execute
	public void execute(EPartService partService) {
		partService.saveAll(false);
	}
}