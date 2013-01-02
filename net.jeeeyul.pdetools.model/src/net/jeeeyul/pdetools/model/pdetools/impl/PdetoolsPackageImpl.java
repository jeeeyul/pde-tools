/**
 */
package net.jeeeyul.pdetools.model.pdetools.impl;

import net.jeeeyul.pdetools.model.pdetools.ClipHistory;
import net.jeeeyul.pdetools.model.pdetools.ClipItemSortOption;
import net.jeeeyul.pdetools.model.pdetools.ClipboardElement;
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;
import net.jeeeyul.pdetools.model.pdetools.CommandEvent;
import net.jeeeyul.pdetools.model.pdetools.CommandExecutionType;
import net.jeeeyul.pdetools.model.pdetools.CommandHistory;
import net.jeeeyul.pdetools.model.pdetools.FieldNameOwner;
import net.jeeeyul.pdetools.model.pdetools.ImageFile;
import net.jeeeyul.pdetools.model.pdetools.JavaInfo;
import net.jeeeyul.pdetools.model.pdetools.Palette;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;
import net.jeeeyul.pdetools.model.pdetools.ShellInfo;
import net.jeeeyul.pdetools.model.pdetools.SnapshotEntry;
import net.jeeeyul.pdetools.model.pdetools.SnapshotGroup;
import net.jeeeyul.pdetools.model.pdetools.SnapshotRepository;
import net.jeeeyul.pdetools.model.pdetools.TextRange;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.swt.dnd.Clipboard;

import org.eclipse.swt.graphics.ImageData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PdetoolsPackageImpl extends EPackageImpl implements PdetoolsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clipboardElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clipHistoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clipboardEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fieldNameOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paletteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snapshotRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snapshotGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snapshotEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shellInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandHistoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum clipItemSortOptionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum commandExecutionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iFileEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iFolderEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType imageDataEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType clipboardEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType exceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType imageDescriptorEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PdetoolsPackageImpl() {
		super(eNS_URI, PdetoolsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PdetoolsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PdetoolsPackage init() {
		if (isInited)
			return (PdetoolsPackage) EPackage.Registry.INSTANCE.getEPackage(PdetoolsPackage.eNS_URI);

		// Obtain or create and register package
		PdetoolsPackageImpl thePdetoolsPackage = (PdetoolsPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PdetoolsPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new PdetoolsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePdetoolsPackage.createPackageContents();

		// Initialize created meta-data
		thePdetoolsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePdetoolsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PdetoolsPackage.eNS_URI, thePdetoolsPackage);
		return thePdetoolsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClipboardElement() {
		return clipboardElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClipHistory() {
		return clipHistoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClipHistory_ActiveEntry() {
		return (EReference) clipHistoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClipHistory_Entries() {
		return (EReference) clipHistoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClipboardEntry() {
		return clipboardEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipboardEntry_UsingCount() {
		return (EAttribute) clipboardEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipboardEntry_LastUsedTime() {
		return (EAttribute) clipboardEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipboardEntry_TextContent() {
		return (EAttribute) clipboardEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipboardEntry_RtfContent() {
		return (EAttribute) clipboardEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipboardEntry_TakenTime() {
		return (EAttribute) clipboardEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipboardEntry_PartId() {
		return (EAttribute) clipboardEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipboardEntry_ReleatedFile() {
		return (EAttribute) clipboardEntryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClipboardEntry_Parent() {
		return (EReference) clipboardEntryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClipboardEntry_TextRange() {
		return (EReference) clipboardEntryEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClipboardEntry_JavaInfo() {
		return (EReference) clipboardEntryEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClipboardEntry_Active() {
		return (EAttribute) clipboardEntryEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClipboardEntry__TransferTo__Clipboard() {
		return clipboardEntryEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClipboardEntry__IncreaseUsing() {
		return clipboardEntryEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextRange() {
		return textRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextRange_Offset() {
		return (EAttribute) textRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextRange_Length() {
		return (EAttribute) textRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextRange_StartLine() {
		return (EAttribute) textRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextRange_EndLine() {
		return (EAttribute) textRangeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaInfo() {
		return javaInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_QualifiedTypeName() {
		return (EAttribute) javaInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaInfo_EnclosingElementName() {
		return (EAttribute) javaInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFieldNameOwner() {
		return fieldNameOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFieldNameOwner_FieldName() {
		return (EAttribute) fieldNameOwnerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPalette() {
		return paletteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPalette_Parent() {
		return (EReference) paletteEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPalette_Folder() {
		return (EAttribute) paletteEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPalette_SubPalettes() {
		return (EReference) paletteEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPalette_ImageFiles() {
		return (EReference) paletteEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImageFile() {
		return imageFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImageFile_Parent() {
		return (EReference) imageFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageFile_File() {
		return (EAttribute) imageFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSnapshotRepository() {
		return snapshotRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSnapshotRepository_Groups() {
		return (EReference) snapshotRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSnapshotGroup() {
		return snapshotGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSnapshotGroup_Parent() {
		return (EReference) snapshotGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSnapshotGroup_Date() {
		return (EAttribute) snapshotGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSnapshotGroup_Entries() {
		return (EReference) snapshotGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSnapshotEntry() {
		return snapshotEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSnapshotEntry_Parent() {
		return (EReference) snapshotEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSnapshotEntry_TakenTime() {
		return (EAttribute) snapshotEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSnapshotEntry_OriginalFile() {
		return (EAttribute) snapshotEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSnapshotEntry_RenderedFile() {
		return (EAttribute) snapshotEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSnapshotEntry_ControlType() {
		return (EAttribute) snapshotEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSnapshotEntry_Name() {
		return (EAttribute) snapshotEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSnapshotEntry_ShellInfo() {
		return (EReference) snapshotEntryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSnapshotEntry_AbsoulteVisibleFilePath() {
		return (EAttribute) snapshotEntryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShellInfo() {
		return shellInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShellInfo_Icon() {
		return (EAttribute) shellInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShellInfo_ShellStyle() {
		return (EAttribute) shellInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShellInfo_ShellTitle() {
		return (EAttribute) shellInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandHistory() {
		return commandHistoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandHistory_Events() {
		return (EReference) commandHistoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommandEvent() {
		return commandEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommandEvent_Children() {
		return (EReference) commandEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandEvent_CommandId() {
		return (EAttribute) commandEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandEvent_Name() {
		return (EAttribute) commandEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandEvent_ImageDescriptor() {
		return (EAttribute) commandEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandEvent_Time() {
		return (EAttribute) commandEventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandEvent_Type() {
		return (EAttribute) commandEventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommandEvent_Exception() {
		return (EAttribute) commandEventEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClipItemSortOption() {
		return clipItemSortOptionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCommandExecutionType() {
		return commandExecutionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIFile() {
		return iFileEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIFolder() {
		return iFolderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImageData() {
		return imageDataEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getClipboard() {
		return clipboardEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getException() {
		return exceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImageDescriptor() {
		return imageDescriptorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PdetoolsFactory getPdetoolsFactory() {
		return (PdetoolsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		clipboardElementEClass = createEClass(CLIPBOARD_ELEMENT);

		clipHistoryEClass = createEClass(CLIP_HISTORY);
		createEReference(clipHistoryEClass, CLIP_HISTORY__ACTIVE_ENTRY);
		createEReference(clipHistoryEClass, CLIP_HISTORY__ENTRIES);

		clipboardEntryEClass = createEClass(CLIPBOARD_ENTRY);
		createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__USING_COUNT);
		createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__LAST_USED_TIME);
		createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__TEXT_CONTENT);
		createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__RTF_CONTENT);
		createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__TAKEN_TIME);
		createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__PART_ID);
		createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__RELEATED_FILE);
		createEReference(clipboardEntryEClass, CLIPBOARD_ENTRY__PARENT);
		createEReference(clipboardEntryEClass, CLIPBOARD_ENTRY__TEXT_RANGE);
		createEReference(clipboardEntryEClass, CLIPBOARD_ENTRY__JAVA_INFO);
		createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__ACTIVE);
		createEOperation(clipboardEntryEClass, CLIPBOARD_ENTRY___TRANSFER_TO__CLIPBOARD);
		createEOperation(clipboardEntryEClass, CLIPBOARD_ENTRY___INCREASE_USING);

		textRangeEClass = createEClass(TEXT_RANGE);
		createEAttribute(textRangeEClass, TEXT_RANGE__OFFSET);
		createEAttribute(textRangeEClass, TEXT_RANGE__LENGTH);
		createEAttribute(textRangeEClass, TEXT_RANGE__START_LINE);
		createEAttribute(textRangeEClass, TEXT_RANGE__END_LINE);

		javaInfoEClass = createEClass(JAVA_INFO);
		createEAttribute(javaInfoEClass, JAVA_INFO__QUALIFIED_TYPE_NAME);
		createEAttribute(javaInfoEClass, JAVA_INFO__ENCLOSING_ELEMENT_NAME);

		fieldNameOwnerEClass = createEClass(FIELD_NAME_OWNER);
		createEAttribute(fieldNameOwnerEClass, FIELD_NAME_OWNER__FIELD_NAME);

		paletteEClass = createEClass(PALETTE);
		createEReference(paletteEClass, PALETTE__PARENT);
		createEAttribute(paletteEClass, PALETTE__FOLDER);
		createEReference(paletteEClass, PALETTE__SUB_PALETTES);
		createEReference(paletteEClass, PALETTE__IMAGE_FILES);

		imageFileEClass = createEClass(IMAGE_FILE);
		createEReference(imageFileEClass, IMAGE_FILE__PARENT);
		createEAttribute(imageFileEClass, IMAGE_FILE__FILE);

		snapshotRepositoryEClass = createEClass(SNAPSHOT_REPOSITORY);
		createEReference(snapshotRepositoryEClass, SNAPSHOT_REPOSITORY__GROUPS);

		snapshotGroupEClass = createEClass(SNAPSHOT_GROUP);
		createEReference(snapshotGroupEClass, SNAPSHOT_GROUP__PARENT);
		createEAttribute(snapshotGroupEClass, SNAPSHOT_GROUP__DATE);
		createEReference(snapshotGroupEClass, SNAPSHOT_GROUP__ENTRIES);

		snapshotEntryEClass = createEClass(SNAPSHOT_ENTRY);
		createEReference(snapshotEntryEClass, SNAPSHOT_ENTRY__PARENT);
		createEAttribute(snapshotEntryEClass, SNAPSHOT_ENTRY__TAKEN_TIME);
		createEAttribute(snapshotEntryEClass, SNAPSHOT_ENTRY__ORIGINAL_FILE);
		createEAttribute(snapshotEntryEClass, SNAPSHOT_ENTRY__RENDERED_FILE);
		createEAttribute(snapshotEntryEClass, SNAPSHOT_ENTRY__CONTROL_TYPE);
		createEAttribute(snapshotEntryEClass, SNAPSHOT_ENTRY__NAME);
		createEReference(snapshotEntryEClass, SNAPSHOT_ENTRY__SHELL_INFO);
		createEAttribute(snapshotEntryEClass, SNAPSHOT_ENTRY__ABSOULTE_VISIBLE_FILE_PATH);

		shellInfoEClass = createEClass(SHELL_INFO);
		createEAttribute(shellInfoEClass, SHELL_INFO__ICON);
		createEAttribute(shellInfoEClass, SHELL_INFO__SHELL_STYLE);
		createEAttribute(shellInfoEClass, SHELL_INFO__SHELL_TITLE);

		commandHistoryEClass = createEClass(COMMAND_HISTORY);
		createEReference(commandHistoryEClass, COMMAND_HISTORY__EVENTS);

		commandEventEClass = createEClass(COMMAND_EVENT);
		createEReference(commandEventEClass, COMMAND_EVENT__CHILDREN);
		createEAttribute(commandEventEClass, COMMAND_EVENT__COMMAND_ID);
		createEAttribute(commandEventEClass, COMMAND_EVENT__NAME);
		createEAttribute(commandEventEClass, COMMAND_EVENT__IMAGE_DESCRIPTOR);
		createEAttribute(commandEventEClass, COMMAND_EVENT__TIME);
		createEAttribute(commandEventEClass, COMMAND_EVENT__TYPE);
		createEAttribute(commandEventEClass, COMMAND_EVENT__EXCEPTION);

		// Create enums
		clipItemSortOptionEEnum = createEEnum(CLIP_ITEM_SORT_OPTION);
		commandExecutionTypeEEnum = createEEnum(COMMAND_EXECUTION_TYPE);

		// Create data types
		iFileEDataType = createEDataType(IFILE);
		iFolderEDataType = createEDataType(IFOLDER);
		imageDataEDataType = createEDataType(IMAGE_DATA);
		clipboardEDataType = createEDataType(CLIPBOARD);
		exceptionEDataType = createEDataType(EXCEPTION);
		imageDescriptorEDataType = createEDataType(IMAGE_DESCRIPTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		clipHistoryEClass.getESuperTypes().add(this.getClipboardElement());
		clipboardEntryEClass.getESuperTypes().add(this.getClipboardElement());
		textRangeEClass.getESuperTypes().add(this.getClipboardElement());
		javaInfoEClass.getESuperTypes().add(this.getClipboardElement());
		paletteEClass.getESuperTypes().add(this.getFieldNameOwner());
		imageFileEClass.getESuperTypes().add(this.getFieldNameOwner());

		// Initialize classes, features, and operations; add parameters
		initEClass(clipboardElementEClass, ClipboardElement.class, "ClipboardElement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(clipHistoryEClass, ClipHistory.class, "ClipHistory", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClipHistory_ActiveEntry(), this.getClipboardEntry(), null, "activeEntry", null, 0, 1,
				ClipHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClipHistory_Entries(), this.getClipboardEntry(), this.getClipboardEntry_Parent(), "entries",
				null, 0, -1, ClipHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clipboardEntryEClass, ClipboardEntry.class, "ClipboardEntry", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClipboardEntry_UsingCount(), theEcorePackage.getEInt(), "usingCount", null, 0, 1,
				ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getClipboardEntry_LastUsedTime(), theEcorePackage.getEDate(), "lastUsedTime", null, 0, 1,
				ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getClipboardEntry_TextContent(), theEcorePackage.getEString(), "textContent", null, 0, 1,
				ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getClipboardEntry_RtfContent(), theEcorePackage.getEString(), "rtfContent", null, 0, 1,
				ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getClipboardEntry_TakenTime(), theEcorePackage.getEDate(), "takenTime", null, 0, 1,
				ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getClipboardEntry_PartId(), theEcorePackage.getEString(), "partId", null, 0, 1,
				ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getClipboardEntry_ReleatedFile(), this.getIFile(), "releatedFile", null, 0, 1,
				ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getClipboardEntry_Parent(), this.getClipHistory(), this.getClipHistory_Entries(), "parent",
				null, 0, 1, ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClipboardEntry_TextRange(), this.getTextRange(), null, "textRange", null, 0, 1,
				ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClipboardEntry_JavaInfo(), this.getJavaInfo(), null, "javaInfo", null, 0, 1,
				ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClipboardEntry_Active(), theEcorePackage.getEBoolean(), "active", null, 0, 1,
				ClipboardEntry.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getClipboardEntry__TransferTo__Clipboard(), null, "transferTo", 0, 1,
				!IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClipboard(), "clipboard", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClipboardEntry__IncreaseUsing(), null, "increaseUsing", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(textRangeEClass, TextRange.class, "TextRange", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTextRange_Offset(), theEcorePackage.getEInt(), "offset", null, 0, 1, TextRange.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextRange_Length(), theEcorePackage.getEInt(), "length", null, 0, 1, TextRange.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextRange_StartLine(), theEcorePackage.getEInt(), "startLine", null, 0, 1, TextRange.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextRange_EndLine(), theEcorePackage.getEInt(), "endLine", null, 0, 1, TextRange.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaInfoEClass, JavaInfo.class, "JavaInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaInfo_QualifiedTypeName(), theEcorePackage.getEString(), "qualifiedTypeName", null, 0, 1,
				JavaInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaInfo_EnclosingElementName(), theEcorePackage.getEString(), "enclosingElementName", null,
				0, 1, JavaInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(fieldNameOwnerEClass, FieldNameOwner.class, "FieldNameOwner", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFieldNameOwner_FieldName(), theEcorePackage.getEString(), "fieldName", null, 0, 1,
				FieldNameOwner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(paletteEClass, Palette.class, "Palette", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPalette_Parent(), this.getPalette(), this.getPalette_SubPalettes(), "parent", null, 0, 1,
				Palette.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPalette_Folder(), this.getIFolder(), "folder", null, 0, 1, Palette.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPalette_SubPalettes(), this.getPalette(), this.getPalette_Parent(), "subPalettes", null, 0,
				-1, Palette.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPalette_ImageFiles(), this.getImageFile(), this.getImageFile_Parent(), "imageFiles", null, 0,
				-1, Palette.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageFileEClass, ImageFile.class, "ImageFile", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImageFile_Parent(), this.getPalette(), this.getPalette_ImageFiles(), "parent", null, 0, 1,
				ImageFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImageFile_File(), this.getIFile(), "file", null, 0, 1, ImageFile.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(snapshotRepositoryEClass, SnapshotRepository.class, "SnapshotRepository", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSnapshotRepository_Groups(), this.getSnapshotGroup(), this.getSnapshotGroup_Parent(),
				"groups", null, 0, -1, SnapshotRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(snapshotGroupEClass, SnapshotGroup.class, "SnapshotGroup", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSnapshotGroup_Parent(), this.getSnapshotRepository(), this.getSnapshotRepository_Groups(),
				"parent", null, 0, 1, SnapshotGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotGroup_Date(), theEcorePackage.getEDate(), "date", null, 0, 1, SnapshotGroup.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSnapshotGroup_Entries(), this.getSnapshotEntry(), this.getSnapshotEntry_Parent(), "entries",
				null, 0, -1, SnapshotGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(snapshotEntryEClass, SnapshotEntry.class, "SnapshotEntry", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSnapshotEntry_Parent(), this.getSnapshotGroup(), this.getSnapshotGroup_Entries(), "parent",
				null, 0, 1, SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotEntry_TakenTime(), theEcorePackage.getEDate(), "takenTime", null, 0, 1,
				SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotEntry_OriginalFile(), theEcorePackage.getEString(), "originalFile", null, 0, 1,
				SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotEntry_RenderedFile(), theEcorePackage.getEString(), "renderedFile", null, 0, 1,
				SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotEntry_ControlType(), theEcorePackage.getEString(), "controlType", null, 0, 1,
				SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotEntry_Name(), theEcorePackage.getEString(), "name", null, 0, 1, SnapshotEntry.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSnapshotEntry_ShellInfo(), this.getShellInfo(), null, "shellInfo", null, 0, 1,
				SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotEntry_AbsoulteVisibleFilePath(), theEcorePackage.getEString(),
				"absoulteVisibleFilePath", null, 0, 1, SnapshotEntry.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(shellInfoEClass, ShellInfo.class, "ShellInfo", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShellInfo_Icon(), this.getImageData(), "icon", null, 0, 1, ShellInfo.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShellInfo_ShellStyle(), theEcorePackage.getEInt(), "shellStyle", null, 0, 1, ShellInfo.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShellInfo_ShellTitle(), theEcorePackage.getEString(), "shellTitle", null, 0, 1,
				ShellInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(commandHistoryEClass, CommandHistory.class, "CommandHistory", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommandHistory_Events(), this.getCommandEvent(), null, "events", null, 0, -1,
				CommandHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commandEventEClass, CommandEvent.class, "CommandEvent", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommandEvent_Children(), this.getCommandEvent(), null, "children", null, 0, -1,
				CommandEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandEvent_CommandId(), theEcorePackage.getEString(), "commandId", null, 0, 1,
				CommandEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandEvent_Name(), theEcorePackage.getEString(), "name", null, 0, 1, CommandEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandEvent_ImageDescriptor(), this.getImageDescriptor(), "imageDescriptor", null, 0, 1,
				CommandEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandEvent_Time(), theEcorePackage.getELong(), "time", null, 0, 1, CommandEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandEvent_Type(), this.getCommandExecutionType(), "type", null, 0, 1, CommandEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommandEvent_Exception(), this.getException(), "exception", null, 0, 1, CommandEvent.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(clipItemSortOptionEEnum, ClipItemSortOption.class, "ClipItemSortOption");
		addEEnumLiteral(clipItemSortOptionEEnum, ClipItemSortOption.CAPTURED_ORDER);
		addEEnumLiteral(clipItemSortOptionEEnum, ClipItemSortOption.LAST_USE);
		addEEnumLiteral(clipItemSortOptionEEnum, ClipItemSortOption.USING_COUNT);
		addEEnumLiteral(clipItemSortOptionEEnum, ClipItemSortOption.ACTIVE);

		initEEnum(commandExecutionTypeEEnum, CommandExecutionType.class, "CommandExecutionType");
		addEEnumLiteral(commandExecutionTypeEEnum, CommandExecutionType.EXECUTING);
		addEEnumLiteral(commandExecutionTypeEEnum, CommandExecutionType.SUCCEED);
		addEEnumLiteral(commandExecutionTypeEEnum, CommandExecutionType.FAILED);
		addEEnumLiteral(commandExecutionTypeEEnum, CommandExecutionType.NOT_HANDLED);

		// Initialize data types
		initEDataType(iFileEDataType, IFile.class, "IFile", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iFolderEDataType, IFolder.class, "IFolder", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(imageDataEDataType, ImageData.class, "ImageData", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(clipboardEDataType, Clipboard.class, "Clipboard", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(exceptionEDataType, Exception.class, "Exception", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(imageDescriptorEDataType, ImageDescriptor.class, "ImageDescriptor", IS_SERIALIZABLE,
				!IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PdetoolsPackageImpl
