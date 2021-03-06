/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.tests.postprocess.data;

import java.io.IOException;

import org.eclipse.emf.compare.tests.framework.AbstractInputData;
import org.eclipse.emf.ecore.resource.Resource;

public class PostProcessInputData extends AbstractInputData {
	public Resource getLeft() throws IOException {
		return loadFromClassLoader("left.nodes"); //$NON-NLS-1$
	}

	public Resource getRight() throws IOException {
		return loadFromClassLoader("right.nodes"); //$NON-NLS-1$
	}
}
