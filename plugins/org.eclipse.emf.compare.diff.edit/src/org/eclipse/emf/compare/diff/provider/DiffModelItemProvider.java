/*******************************************************************************
 * Copyright (c) 2006, 2007 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.compare.diff.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.compare.diff.metamodel.DiffModel} object. <!-- begin-user-doc --> <!-- end-user-doc
 * -->
 * 
 * @generated
 */
@SuppressWarnings("nls")
public class DiffModelItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DiffModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addRightPropertyDescriptor(object);
			addLeftPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Right feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	protected void addRightPropertyDescriptor(@SuppressWarnings("unused")
	Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DiffModel_right_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiffModel_right_feature", "_UI_DiffModel_type"), DiffPackage.Literals.DIFF_MODEL__RIGHT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Left feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	protected void addLeftPropertyDescriptor(@SuppressWarnings("unused")
	Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_DiffModel_left_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DiffModel_left_feature", "_UI_DiffModel_type"), DiffPackage.Literals.DIFF_MODEL__LEFT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS);
		}
		return childrenFeatures;
	}

	/**
	 * This returns DiffModel.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DiffModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DiffModel)object).getRight();
		return label == null || label.length() == 0 ? getString("_UI_DiffModel_type") : getString("_UI_DiffModel_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DiffModel.class)) {
			case DiffPackage.DIFF_MODEL__RIGHT:
			case DiffPackage.DIFF_MODEL__LEFT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DiffPackage.DIFF_MODEL__OWNED_ELEMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds to the collection of {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing all of the children that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void collectNewChildDescriptors(Collection newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createConflictingDiffElement()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createDiffGroup()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createModelElementChange()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createModelElementChangeLeftTarget()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createModelElementChangeRightTarget()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createAddModelElement()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoteAddModelElement()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoveModelElement()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoteRemoveModelElement()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createUpdateModelElement()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createMoveModelElement()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoteMoveModelElement()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createAttributeChange()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createAttributeChangeLeftTarget()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createAttributeChangeRightTarget()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createAddAttribute()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoteAddAttribute()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoveAttribute()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoteRemoveAttribute()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createUpdateAttribute()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoteUpdateAttribute()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createReferenceChange()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createReferenceChangeLeftTarget()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createReferenceChangeRightTarget()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createAddReferenceValue()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoteAddReferenceValue()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoveReferenceValue()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoteRemoveReferenceValue()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createUpdateReference()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createUpdateUniqueReferenceValue()));

		newChildDescriptors.add(createChildParameter(DiffPackage.Literals.DIFF_MODEL__OWNED_ELEMENTS, DiffFactory.eINSTANCE.createRemoteUpdateUniqueReferenceValue()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DiffEditPlugin.INSTANCE;
	}

}
