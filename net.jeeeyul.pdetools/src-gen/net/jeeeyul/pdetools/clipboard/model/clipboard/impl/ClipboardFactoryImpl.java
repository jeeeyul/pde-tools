/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard.impl;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardFactory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage;
import net.jeeeyul.pdetools.shared.ImageDataSerializer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.graphics.ImageData;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ClipboardFactoryImpl extends EFactoryImpl implements ClipboardFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static ClipboardFactory init() {
		try {
			ClipboardFactory theClipboardFactory = (ClipboardFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://jeeeyul.net/pde-tools/clipboard");
			if (theClipboardFactory != null) {
				return theClipboardFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClipboardFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ClipboardFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ClipboardPackage.CLIP_HISTORY:
				return createClipHistory();
			case ClipboardPackage.CLIPBOARD_ENTRY:
				return createClipboardEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ClipboardPackage.CLIPBOARD:
				return createClipboardFromString(eDataType, initialValue);
			case ClipboardPackage.IMAGE_DATA:
				return createImageDataFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName()
						+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ClipboardPackage.CLIPBOARD:
				return convertClipboardToString(eDataType, instanceValue);
			case ClipboardPackage.IMAGE_DATA:
				return convertImageDataToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName()
						+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClipHistory createClipHistory() {
		ClipHistoryImpl clipHistory = new ClipHistoryImpl();
		return clipHistory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClipboardEntry createClipboardEntry() {
		ClipboardEntryImpl clipboardEntry = new ClipboardEntryImpl();
		return clipboardEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Clipboard createClipboardFromString(EDataType eDataType, String initialValue) {
		return (Clipboard) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertClipboardToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImageData createImageData(String it) {
		ImageData _deserialize = ImageDataSerializer.deserialize(it);
		return _deserialize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImageData createImageDataFromString(EDataType eDataType, String initialValue) {
		return createImageData(initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertImageData(ImageData it) {
		String _serialize = ImageDataSerializer.serialize(it);
		return _serialize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertImageDataToString(EDataType eDataType, Object instanceValue) {
		return convertImageData((ImageData) instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClipboardPackage getClipboardPackage() {
		return (ClipboardPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ClipboardPackage getPackage() {
		return ClipboardPackage.eINSTANCE;
	}

} // ClipboardFactoryImpl
