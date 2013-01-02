/**
 */
package net.jeeeyul.pdetools.model.pdetools.provider;

import java.util.Collection;
import java.util.List;


import net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;
import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SnapshotEntryItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SnapshotEntryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addParentPropertyDescriptor(object);
			addTakenTimePropertyDescriptor(object);
			addOriginalFilePropertyDescriptor(object);
			addRenderedFilePropertyDescriptor(object);
			addControlTypePropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addAbsoulteVisibleFilePathPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Parent feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SnapshotEntry_parent_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_SnapshotEntry_parent_feature",
						"_UI_SnapshotEntry_type"),
				PdetoolsPackage.Literals.SNAPSHOT_ENTRY__PARENT, true, false,
				true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Taken Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTakenTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SnapshotEntry_takenTime_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_SnapshotEntry_takenTime_feature",
						"_UI_SnapshotEntry_type"),
				PdetoolsPackage.Literals.SNAPSHOT_ENTRY__TAKEN_TIME, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Original File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOriginalFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SnapshotEntry_originalFile_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_SnapshotEntry_originalFile_feature",
						"_UI_SnapshotEntry_type"),
				PdetoolsPackage.Literals.SNAPSHOT_ENTRY__ORIGINAL_FILE, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Rendered File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRenderedFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SnapshotEntry_renderedFile_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_SnapshotEntry_renderedFile_feature",
						"_UI_SnapshotEntry_type"),
				PdetoolsPackage.Literals.SNAPSHOT_ENTRY__RENDERED_FILE, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Control Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addControlTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SnapshotEntry_controlType_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_SnapshotEntry_controlType_feature",
						"_UI_SnapshotEntry_type"),
				PdetoolsPackage.Literals.SNAPSHOT_ENTRY__CONTROL_TYPE, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_SnapshotEntry_name_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_SnapshotEntry_name_feature",
						"_UI_SnapshotEntry_type"),
				PdetoolsPackage.Literals.SNAPSHOT_ENTRY__NAME, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Absoulte Visible File Path feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbsoulteVisibleFilePathPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_SnapshotEntry_absoulteVisibleFilePath_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_SnapshotEntry_absoulteVisibleFilePath_feature",
								"_UI_SnapshotEntry_type"),
						PdetoolsPackage.Literals.SNAPSHOT_ENTRY__ABSOULTE_VISIBLE_FILE_PATH,
						false, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(PdetoolsPackage.Literals.SNAPSHOT_ENTRY__SHELL_INFO);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns SnapshotEntry.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/SnapshotEntry"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SnapshotEntry) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_SnapshotEntry_type")
				: getString("_UI_SnapshotEntry_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SnapshotEntry.class)) {
		case PdetoolsPackage.SNAPSHOT_ENTRY__TAKEN_TIME:
		case PdetoolsPackage.SNAPSHOT_ENTRY__ORIGINAL_FILE:
		case PdetoolsPackage.SNAPSHOT_ENTRY__RENDERED_FILE:
		case PdetoolsPackage.SNAPSHOT_ENTRY__CONTROL_TYPE:
		case PdetoolsPackage.SNAPSHOT_ENTRY__NAME:
		case PdetoolsPackage.SNAPSHOT_ENTRY__ABSOULTE_VISIBLE_FILE_PATH:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		case PdetoolsPackage.SNAPSHOT_ENTRY__SHELL_INFO:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				PdetoolsPackage.Literals.SNAPSHOT_ENTRY__SHELL_INFO,
				PdetoolsFactory.eINSTANCE.createShellInfo()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return net.jeeeyul.pdetools.model.PdetoolsEditPlugin.INSTANCE;
	}

}
