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
package org.eclipse.emf.compare.internal.ide.ui.structuremergeviewer.provider;

import org.eclipse.compare.ITypedElement;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.internal.ide.ui.contentmergeviewer.provider.EObjectNode;
import org.eclipse.emf.compare.internal.ide.ui.structuremergeviewer.EDiffNode;
import org.eclipse.emf.ecore.EObject;

/**
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikael Barbero</a>
 */
public class MatchNode extends EDiffNode {

	/**
	 * @param adapterFactory
	 */
	public MatchNode(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * @{inheritDoc
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#getTarget()
	 */
	@Override
	public Match getTarget() {
		return (Match)super.getTarget();
	}

	/**
	 * @{inheritDoc
	 * @see org.eclipse.compare.structuremergeviewer.ICompareInput#getAncestor()
	 */
	@Override
	public ITypedElement getAncestor() {
		EObject o = getTarget().getOrigin();
		if (o != null) {
			return new EObjectNode(o);
		}
		return null;
	}

	/**
	 * @{inheritDoc
	 * @see org.eclipse.compare.structuremergeviewer.ICompareInput#getLeft()
	 */
	@Override
	public ITypedElement getLeft() {
		EObject o = getTarget().getLeft();
		if (o != null) {
			return new EObjectNode(o);
		}
		return null;
	}

	/**
	 * @{inheritDoc
	 * @see org.eclipse.compare.structuremergeviewer.ICompareInput#getRight()
	 */
	@Override
	public ITypedElement getRight() {
		EObject o = getTarget().getRight();
		if (o != null) {
			return new EObjectNode(o);
		}
		return null;
	}

}