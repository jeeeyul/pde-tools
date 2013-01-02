/**
 */
package net.jeeeyul.pdetools.model.pdetools.provider;

import java.util.Collection;
import java.util.List;


import net.jeeeyul.pdetools.model.pdetools.CommandEvent;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;

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
 * This is the item provider adapter for a {@link net.jeeeyul.pdetools.model.pdetools.CommandEvent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CommandEventItemProvider extends ItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandEventItemProvider(AdapterFactory adapterFactory) {
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

			addCommandIdPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addImageDescriptorPropertyDescriptor(object);
			addTimePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addExceptionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Command Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCommandIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_CommandEvent_commandId_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_CommandEvent_commandId_feature",
						"_UI_CommandEvent_type"),
				PdetoolsPackage.Literals.COMMAND_EVENT__COMMAND_ID, true,
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
				getString("_UI_CommandEvent_name_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_CommandEvent_name_feature",
						"_UI_CommandEvent_type"),
				PdetoolsPackage.Literals.COMMAND_EVENT__NAME, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Image Descriptor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImageDescriptorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_CommandEvent_imageDescriptor_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_CommandEvent_imageDescriptor_feature",
						"_UI_CommandEvent_type"),
				PdetoolsPackage.Literals.COMMAND_EVENT__IMAGE_DESCRIPTOR, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_CommandEvent_time_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_CommandEvent_time_feature",
								"_UI_CommandEvent_type"),
						PdetoolsPackage.Literals.COMMAND_EVENT__TIME, true,
						false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_CommandEvent_type_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_CommandEvent_type_feature",
						"_UI_CommandEvent_type"),
				PdetoolsPackage.Literals.COMMAND_EVENT__TYPE, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Exception feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExceptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_CommandEvent_exception_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_CommandEvent_exception_feature",
						"_UI_CommandEvent_type"),
				PdetoolsPackage.Literals.COMMAND_EVENT__EXCEPTION, true, false,
				false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
					.add(PdetoolsPackage.Literals.COMMAND_EVENT__CHILDREN);
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
	 * This returns CommandEvent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/CommandEvent"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((CommandEvent) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_CommandEvent_type")
				: getString("_UI_CommandEvent_type") + " " + label;
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

		switch (notification.getFeatureID(CommandEvent.class)) {
		case PdetoolsPackage.COMMAND_EVENT__COMMAND_ID:
		case PdetoolsPackage.COMMAND_EVENT__NAME:
		case PdetoolsPackage.COMMAND_EVENT__IMAGE_DESCRIPTOR:
		case PdetoolsPackage.COMMAND_EVENT__TIME:
		case PdetoolsPackage.COMMAND_EVENT__TYPE:
		case PdetoolsPackage.COMMAND_EVENT__EXCEPTION:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		case PdetoolsPackage.COMMAND_EVENT__CHILDREN:
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
				PdetoolsPackage.Literals.COMMAND_EVENT__CHILDREN,
				PdetoolsFactory.eINSTANCE.createCommandEvent()));
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
