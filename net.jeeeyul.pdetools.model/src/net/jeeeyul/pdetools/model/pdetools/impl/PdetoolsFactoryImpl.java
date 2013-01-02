/**
 */
package net.jeeeyul.pdetools.model.pdetools.impl;

import com.google.common.base.Objects;

import net.jeeeyul.pdetools.model.pdetools.*;

import net.jeeeyul.pdetools.shared.ImageDataSerializer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.swt.dnd.Clipboard;

import org.eclipse.swt.graphics.ImageData;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class PdetoolsFactoryImpl extends EFactoryImpl implements PdetoolsFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static PdetoolsFactory init() {
		try {
			PdetoolsFactory thePdetoolsFactory = (PdetoolsFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://jeeeyul.net/pde-tools");
			if (thePdetoolsFactory != null) {
				return thePdetoolsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PdetoolsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public PdetoolsFactoryImpl() {
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
			case PdetoolsPackage.CLIPBOARD_ELEMENT:
				return createClipboardElement();
			case PdetoolsPackage.CLIP_HISTORY:
				return createClipHistory();
			case PdetoolsPackage.CLIPBOARD_ENTRY:
				return createClipboardEntry();
			case PdetoolsPackage.TEXT_RANGE:
				return createTextRange();
			case PdetoolsPackage.JAVA_INFO:
				return createJavaInfo();
			case PdetoolsPackage.PALETTE:
				return createPalette();
			case PdetoolsPackage.IMAGE_FILE:
				return createImageFile();
			case PdetoolsPackage.SNAPSHOT_REPOSITORY:
				return createSnapshotRepository();
			case PdetoolsPackage.SNAPSHOT_GROUP:
				return createSnapshotGroup();
			case PdetoolsPackage.SNAPSHOT_ENTRY:
				return createSnapshotEntry();
			case PdetoolsPackage.SHELL_INFO:
				return createShellInfo();
			case PdetoolsPackage.COMMAND_HISTORY:
				return createCommandHistory();
			case PdetoolsPackage.COMMAND_EVENT:
				return createCommandEvent();
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
			case PdetoolsPackage.CLIP_ITEM_SORT_OPTION:
				return createClipItemSortOptionFromString(eDataType, initialValue);
			case PdetoolsPackage.COMMAND_EXECUTION_TYPE:
				return createCommandExecutionTypeFromString(eDataType, initialValue);
			case PdetoolsPackage.IFILE:
				return createIFileFromString(eDataType, initialValue);
			case PdetoolsPackage.IFOLDER:
				return createIFolderFromString(eDataType, initialValue);
			case PdetoolsPackage.IMAGE_DATA:
				return createImageDataFromString(eDataType, initialValue);
			case PdetoolsPackage.CLIPBOARD:
				return createClipboardFromString(eDataType, initialValue);
			case PdetoolsPackage.EXCEPTION:
				return createExceptionFromString(eDataType, initialValue);
			case PdetoolsPackage.IMAGE_DESCRIPTOR:
				return createImageDescriptorFromString(eDataType, initialValue);
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
			case PdetoolsPackage.CLIP_ITEM_SORT_OPTION:
				return convertClipItemSortOptionToString(eDataType, instanceValue);
			case PdetoolsPackage.COMMAND_EXECUTION_TYPE:
				return convertCommandExecutionTypeToString(eDataType, instanceValue);
			case PdetoolsPackage.IFILE:
				return convertIFileToString(eDataType, instanceValue);
			case PdetoolsPackage.IFOLDER:
				return convertIFolderToString(eDataType, instanceValue);
			case PdetoolsPackage.IMAGE_DATA:
				return convertImageDataToString(eDataType, instanceValue);
			case PdetoolsPackage.CLIPBOARD:
				return convertClipboardToString(eDataType, instanceValue);
			case PdetoolsPackage.EXCEPTION:
				return convertExceptionToString(eDataType, instanceValue);
			case PdetoolsPackage.IMAGE_DESCRIPTOR:
				return convertImageDescriptorToString(eDataType, instanceValue);
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
	public ClipboardElement createClipboardElement() {
		ClipboardElementImpl clipboardElement = new ClipboardElementImpl();
		return clipboardElement;
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
	public TextRange createTextRange() {
		TextRangeImpl textRange = new TextRangeImpl();
		return textRange;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JavaInfo createJavaInfo() {
		JavaInfoImpl javaInfo = new JavaInfoImpl();
		return javaInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Palette createPalette() {
		PaletteImpl palette = new PaletteImpl();
		return palette;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImageFile createImageFile() {
		ImageFileImpl imageFile = new ImageFileImpl();
		return imageFile;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SnapshotRepository createSnapshotRepository() {
		SnapshotRepositoryImpl snapshotRepository = new SnapshotRepositoryImpl();
		return snapshotRepository;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SnapshotGroup createSnapshotGroup() {
		SnapshotGroupImpl snapshotGroup = new SnapshotGroupImpl();
		return snapshotGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SnapshotEntry createSnapshotEntry() {
		SnapshotEntryImpl snapshotEntry = new SnapshotEntryImpl();
		return snapshotEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ShellInfo createShellInfo() {
		ShellInfoImpl shellInfo = new ShellInfoImpl();
		return shellInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommandHistory createCommandHistory() {
		CommandHistoryImpl commandHistory = new CommandHistoryImpl();
		return commandHistory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CommandEvent createCommandEvent() {
		CommandEventImpl commandEvent = new CommandEventImpl();
		return commandEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ClipItemSortOption createClipItemSortOptionFromString(EDataType eDataType, String initialValue) {
		ClipItemSortOption result = ClipItemSortOption.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
					+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertClipItemSortOptionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CommandExecutionType createCommandExecutionTypeFromString(EDataType eDataType, String initialValue) {
		CommandExecutionType result = CommandExecutionType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
					+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertCommandExecutionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public IFile createIFile(final String it) {
		IFile _xblockexpression = null;
		{
			boolean _or = false;
			boolean _equals = Objects.equal(it, null);
			if (_equals) {
				_or = true;
			} else {
				String _trim = it.trim();
				boolean _isEmpty = _trim.isEmpty();
				_or = (_equals || _isEmpty);
			}
			if (_or) {
				return null;
			}
			IWorkspace _workspace = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot _root = _workspace.getRoot();
			Path _path = new Path(it);
			IFile _file = _root.getFile(_path);
			_xblockexpression = (_file);
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public IFile createIFileFromString(EDataType eDataType, String initialValue) {
		return createIFile(initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertIFile(final IFile it) {
		String _xblockexpression = null;
		{
			boolean _equals = Objects.equal(it, null);
			if (_equals) {
				return "";
			}
			IPath _fullPath = it.getFullPath();
			String _portableString = _fullPath.toPortableString();
			_xblockexpression = (_portableString);
		}
		return _xblockexpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertIFileToString(EDataType eDataType, Object instanceValue) {
		return convertIFile((IFile) instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public IFolder createIFolder(final String it) {
		IWorkspace _workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot _root = _workspace.getRoot();
		Path _path = new Path(it);
		IFolder _folder = _root.getFolder(_path);
		return _folder;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public IFolder createIFolderFromString(EDataType eDataType, String initialValue) {
		return createIFolder(initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertIFolder(final IFolder it) {
		IPath _fullPath = it.getFullPath();
		String _portableString = _fullPath.toPortableString();
		return _portableString;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertIFolderToString(EDataType eDataType, Object instanceValue) {
		return convertIFolder((IFolder) instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ImageData createImageData(final String it) {
		ImageData _deserialize = ImageDataSerializer.deserialize(it);
		return _deserialize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ImageData createImageDataFromString(EDataType eDataType, String initialValue) {
		return createImageData(initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertImageData(final ImageData it) {
		String _serialize = ImageDataSerializer.serialize(it);
		return _serialize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertImageDataToString(EDataType eDataType, Object instanceValue) {
		return convertImageData((ImageData) instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Clipboard createClipboardFromString(EDataType eDataType, String initialValue) {
		return (Clipboard) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertClipboardToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Exception createExceptionFromString(EDataType eDataType, String initialValue) {
		return (Exception) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ImageDescriptor createImageDescriptorFromString(EDataType eDataType, String initialValue) {
		return (ImageDescriptor) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertImageDescriptorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PdetoolsPackage getPdetoolsPackage() {
		return (PdetoolsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PdetoolsPackage getPackage() {
		return PdetoolsPackage.eINSTANCE;
	}

} // PdetoolsFactoryImpl
