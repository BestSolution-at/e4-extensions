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
package at.bestsolution.e4.extensions.core.services;

public interface RestartService {
	public void scheduleClear();
	public void unscheduleClear();
	public boolean isClear();
	public boolean restart(boolean clear);
	public void evaluateClear();
}
