/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.merge;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.MatchResource;
import org.eclipse.emf.compare.ResourceLocationChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * This specific implementation of {@link AbstractMerger} will be used to merge resource location changes.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 */
public class ResourceLocationChangeMerger extends AbstractMerger {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.merge.IMerger#isMergerFor(org.eclipse.emf.compare.Diff)
	 */
	public boolean isMergerFor(Diff target) {
		return target instanceof ResourceLocationChange;
	}

	@Override
	protected void accept(Diff diff, boolean rightToLeft) {
		ResourceLocationChange resourceLocationChange = (ResourceLocationChange)diff;
		switch (diff.getKind()) {
			case CHANGE:
				change(resourceLocationChange, rightToLeft);
				break;
			default:
				// other cases are unknown at the time of writing
				break;
		}
	}

	@Override
	protected void reject(Diff diff, boolean rightToLeft) {
		ResourceLocationChange resourceLocationChange = (ResourceLocationChange)diff;
		switch (diff.getKind()) {
			case CHANGE:
				change(resourceLocationChange, rightToLeft);
				break;
			default:
				// other cases are unknown at the time of writing
				break;
		}
	}

	/**
	 * Handles resource location changes.
	 * 
	 * @param resourceLocationChange
	 *            The diff we are merging.
	 * @param rightToLeft
	 *            Tells us whether we are merging to the left or right side.
	 */
	private void change(ResourceLocationChange resourceLocationChange, boolean rightToLeft) {
		final Object container = resourceLocationChange.eContainer();
		if (!(container instanceof MatchResource)) {
			return;
		}
		final MatchResource matchResource = (MatchResource)container;
		final Resource baseResource = getResource(matchResource, resourceLocationChange.getBaseLocation());
		final Resource changedResource = getResource(matchResource, resourceLocationChange
				.getChangedLocation());

		if (rightToLeft && DifferenceSource.LEFT == resourceLocationChange.getSource()) {
			// Move content of changed resource in a new resource that has base resource name.
			final Resource newChangedResource = changedResource.getResourceSet().createResource(
					baseResource.getURI());
			final List<EObject> changedContents = changedResource.getContents();
			newChangedResource.getContents().addAll(changedContents);
			newChangedResource.getResourceSet().getResources().remove(changedResource);
			try {
				newChangedResource.save(Collections.emptyMap());
				// Then delete old base resource.
				changedResource.delete(Collections.emptyMap());
			} catch (IOException e) {
				// FIXME log exception.
			}
		} else if (rightToLeft && DifferenceSource.RIGHT == resourceLocationChange.getSource()) {
			// Move content of base resource in a new resource that has changed resource name.
			final Resource newBaseResource = baseResource.getResourceSet().createResource(
					changedResource.getURI());
			final List<EObject> baseContents = baseResource.getContents();
			newBaseResource.getContents().addAll(baseContents);
			newBaseResource.getResourceSet().getResources().remove(baseResource);
			try {
				newBaseResource.save(Collections.emptyMap());
				// Then delete old base resource.
				baseResource.delete(Collections.emptyMap());
			} catch (IOException e) {
				// FIXME log exception.
			}
		} else if (!rightToLeft) {
			// We can't modify the remote side of the comparison.
			// Nothing to do here.
		}
	}

	/**
	 * Get the corresponding Resource for the given URI.
	 * 
	 * @param matchResource
	 *            the matchResource referencing the Resource to find.
	 * @param uri
	 *            the given URI.
	 * @return a Resource if found, null otherwise.
	 */
	private Resource getResource(MatchResource matchResource, String uri) {
		final Resource resource;
		if (uri.equals(matchResource.getLeftURI())) {
			resource = matchResource.getLeft();
		} else if (uri.equals(matchResource.getRightURI())) {
			resource = matchResource.getRight();
		} else if (uri.equals(matchResource.getOriginURI())) {
			resource = matchResource.getOrigin();
		} else {
			resource = null;
		}
		return resource;
	}
}