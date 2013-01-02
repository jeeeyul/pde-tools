/**
 */
package net.jeeeyul.pdetools.model.pdetools.provider;

import java.util.Collection;
import java.util.List;

import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClipboardEntryItemProvider extends ClipboardElementItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClipboardEntryItemProvider(AdapterFactory adapterFactory) {
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

			addUsingCountPropertyDescriptor(object);
			addLastUsedTimePropertyDescriptor(object);
			addTextContentPropertyDescriptor(object);
			addRtfContentPropertyDescriptor(object);
			addTakenTimePropertyDescriptor(object);
			addReleatedFilePropertyDescriptor(object);
			addActivePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Using Count feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUsingCountPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ClipboardEntry_usingCount_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ClipboardEntry_usingCount_feature",
						"_UI_ClipboardEntry_type"),
				PdetoolsPackage.Literals.CLIPBOARD_ENTRY__USING_COUNT, true,
				false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Last Used Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastUsedTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ClipboardEntry_lastUsedTime_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ClipboardEntry_lastUsedTime_feature",
						"_UI_ClipboardEntry_type"),
				PdetoolsPackage.Literals.CLIPBOARD_ENTRY__LAST_USED_TIME, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Text Content feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTextContentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ClipboardEntry_textContent_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ClipboardEntry_textContent_feature",
						"_UI_ClipboardEntry_type"),
				PdetoolsPackage.Literals.CLIPBOARD_ENTRY__TEXT_CONTENT, true,
				true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				getString("_UI_ContentPropertyCategory"), null));
	}

	/**
	 * This adds a property descriptor for the Rtf Content feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRtfContentPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ClipboardEntry_rtfContent_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ClipboardEntry_rtfContent_feature",
						"_UI_ClipboardEntry_type"),
				PdetoolsPackage.Literals.CLIPBOARD_ENTRY__RTF_CONTENT, true,
				true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				getString("_UI_ContentPropertyCategory"), null));
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
				getString("_UI_ClipboardEntry_takenTime_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ClipboardEntry_takenTime_feature",
						"_UI_ClipboardEntry_type"),
				PdetoolsPackage.Literals.CLIPBOARD_ENTRY__TAKEN_TIME, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Releated File feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReleatedFilePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_ClipboardEntry_releatedFile_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_ClipboardEntry_releatedFile_feature",
						"_UI_ClipboardEntry_type"),
				PdetoolsPackage.Literals.CLIPBOARD_ENTRY__RELEATED_FILE, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				null));
	}

	/**
	 * This adds a property descriptor for the Active feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ClipboardEntry_active_feature"),
				getString("_UI_ClipboardEntry_active_description"),
				PdetoolsPackage.Literals.CLIPBOARD_ENTRY__ACTIVE, false, false,
				false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
					.add(PdetoolsPackage.Literals.CLIPBOARD_ENTRY__TEXT_RANGE);
			childrenFeatures
					.add(PdetoolsPackage.Literals.CLIPBOARD_ENTRY__JAVA_INFO);
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
	 * This returns ClipboardEntry.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator().getImage("full/obj16/ClipboardEntry"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = crop(((ClipboardEntry) object).getTextContent());
		return label == null || label.length() == 0 ? getString("_UI_ClipboardEntry_type")
				: getString("_UI_ClipboardEntry_type") + " " + label;
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

		switch (notification.getFeatureID(ClipboardEntry.class)) {
		case PdetoolsPackage.CLIPBOARD_ENTRY__USING_COUNT:
		case PdetoolsPackage.CLIPBOARD_ENTRY__LAST_USED_TIME:
		case PdetoolsPackage.CLIPBOARD_ENTRY__TEXT_CONTENT:
		case PdetoolsPackage.CLIPBOARD_ENTRY__RTF_CONTENT:
		case PdetoolsPackage.CLIPBOARD_ENTRY__TAKEN_TIME:
		case PdetoolsPackage.CLIPBOARD_ENTRY__PART_ID:
		case PdetoolsPackage.CLIPBOARD_ENTRY__RELEATED_FILE:
		case PdetoolsPackage.CLIPBOARD_ENTRY__ACTIVE:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
			return;
		case PdetoolsPackage.CLIPBOARD_ENTRY__TEXT_RANGE:
		case PdetoolsPackage.CLIPBOARD_ENTRY__JAVA_INFO:
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
				PdetoolsPackage.Literals.CLIPBOARD_ENTRY__TEXT_RANGE,
				PdetoolsFactory.eINSTANCE.createTextRange()));

		newChildDescriptors.add(createChildParameter(
				PdetoolsPackage.Literals.CLIPBOARD_ENTRY__JAVA_INFO,
				PdetoolsFactory.eINSTANCE.createJavaInfo()));
	}

}
