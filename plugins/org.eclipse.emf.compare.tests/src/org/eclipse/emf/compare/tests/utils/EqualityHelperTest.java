/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.tests.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.compare.utils.EqualityHelper;
import org.junit.Test;

/**
 * We will use this to test the utility methods exposed by the {@link EqualityHelper}.
 * 
 * @author <a href="mailto:axel.richard@obeo.fr">Axel Richard</a>
 */
@SuppressWarnings("all")
public class EqualityHelperTest {

	@Test
	public void matchingValues() {
		final EqualityHelper helper = new EqualityHelper(null);
		final Object o1 = new Object();
		final Object o2 = new Object();

		assertFalse(helper.matchingValues(o1, o2));
		assertTrue(helper.matchingValues(o1, o1));

		assertTrue(helper.matchingValues("", null));
		assertTrue(helper.matchingValues(null, ""));
		assertTrue(helper.matchingValues("a", "a"));
		assertTrue(helper.matchingValues(new Integer(42), new Integer(42)));
		assertTrue(helper.matchingValues(new Boolean(true), new Boolean(true)));

		final String[] array1 = {"a", "b", "c" };
		final String[] array2 = {"d", "e", "f" };
		final String[] array3 = {"a", "b", "c", "d" };
		final String[] array4 = {"d", "c", "b", "a" };

		assertTrue(helper.matchingValues(array1, array1));
		assertFalse(helper.matchingValues(array1, array2));
		assertFalse(helper.matchingValues(array1, array3));
		assertFalse(helper.matchingValues(array3, array4));

	}
}
