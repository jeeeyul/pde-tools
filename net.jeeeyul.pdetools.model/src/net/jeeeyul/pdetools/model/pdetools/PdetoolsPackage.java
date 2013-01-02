/**
 */
package net.jeeeyul.pdetools.model.pdetools;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel editDirectory='/net.jeeeyul.pdetools.edit/src-gen' codeFormatting='true' basePackage='net.jeeeyul.pdetools.model'"
 * @generated
 */
public interface PdetoolsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pdetools";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://jeeeyul.net/pde-tools";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "p";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PdetoolsPackage eINSTANCE = net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl.init();

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.ClipboardElementImpl <em>Clipboard Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.ClipboardElementImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getClipboardElement()
	 * @generated
	 */
	int CLIPBOARD_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Clipboard Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Clipboard Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.ClipHistoryImpl <em>Clip History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.ClipHistoryImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getClipHistory()
	 * @generated
	 */
	int CLIP_HISTORY = 1;

	/**
	 * The feature id for the '<em><b>Active Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_HISTORY__ACTIVE_ENTRY = CLIPBOARD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_HISTORY__ENTRIES = CLIPBOARD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Clip History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_HISTORY_FEATURE_COUNT = CLIPBOARD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Clip History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIP_HISTORY_OPERATION_COUNT = CLIPBOARD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.ClipboardEntryImpl <em>Clipboard Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.ClipboardEntryImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getClipboardEntry()
	 * @generated
	 */
	int CLIPBOARD_ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Using Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__USING_COUNT = CLIPBOARD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last Used Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__LAST_USED_TIME = CLIPBOARD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__TEXT_CONTENT = CLIPBOARD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rtf Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__RTF_CONTENT = CLIPBOARD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Taken Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__TAKEN_TIME = CLIPBOARD_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__PART_ID = CLIPBOARD_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Releated File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__RELEATED_FILE = CLIPBOARD_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__PARENT = CLIPBOARD_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Text Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__TEXT_RANGE = CLIPBOARD_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Java Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__JAVA_INFO = CLIPBOARD_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY__ACTIVE = CLIPBOARD_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Clipboard Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY_FEATURE_COUNT = CLIPBOARD_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The operation id for the '<em>Transfer To</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY___TRANSFER_TO__CLIPBOARD = CLIPBOARD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Increase Using</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY___INCREASE_USING = CLIPBOARD_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Clipboard Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIPBOARD_ENTRY_OPERATION_COUNT = CLIPBOARD_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.TextRangeImpl <em>Text Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.TextRangeImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getTextRange()
	 * @generated
	 */
	int TEXT_RANGE = 3;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_RANGE__OFFSET = CLIPBOARD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_RANGE__LENGTH = CLIPBOARD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_RANGE__START_LINE = CLIPBOARD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_RANGE__END_LINE = CLIPBOARD_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Text Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_RANGE_FEATURE_COUNT = CLIPBOARD_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Text Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_RANGE_OPERATION_COUNT = CLIPBOARD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.JavaInfoImpl <em>Java Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.JavaInfoImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getJavaInfo()
	 * @generated
	 */
	int JAVA_INFO = 4;

	/**
	 * The feature id for the '<em><b>Qualified Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__QUALIFIED_TYPE_NAME = CLIPBOARD_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enclosing Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO__ENCLOSING_ELEMENT_NAME = CLIPBOARD_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Java Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO_FEATURE_COUNT = CLIPBOARD_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Java Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_INFO_OPERATION_COUNT = CLIPBOARD_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.FieldNameOwner <em>Field Name Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.FieldNameOwner
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getFieldNameOwner()
	 * @generated
	 */
	int FIELD_NAME_OWNER = 5;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_NAME_OWNER__FIELD_NAME = 0;

	/**
	 * The number of structural features of the '<em>Field Name Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_NAME_OWNER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Field Name Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_NAME_OWNER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.PaletteImpl <em>Palette</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PaletteImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getPalette()
	 * @generated
	 */
	int PALETTE = 6;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE__FIELD_NAME = FIELD_NAME_OWNER__FIELD_NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE__PARENT = FIELD_NAME_OWNER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE__FOLDER = FIELD_NAME_OWNER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Palettes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE__SUB_PALETTES = FIELD_NAME_OWNER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Image Files</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE__IMAGE_FILES = FIELD_NAME_OWNER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Palette</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_FEATURE_COUNT = FIELD_NAME_OWNER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Palette</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_OPERATION_COUNT = FIELD_NAME_OWNER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.ImageFileImpl <em>Image File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.ImageFileImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getImageFile()
	 * @generated
	 */
	int IMAGE_FILE = 7;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FILE__FIELD_NAME = FIELD_NAME_OWNER__FIELD_NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FILE__PARENT = FIELD_NAME_OWNER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FILE__FILE = FIELD_NAME_OWNER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Image File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FILE_FEATURE_COUNT = FIELD_NAME_OWNER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Image File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FILE_OPERATION_COUNT = FIELD_NAME_OWNER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.SnapshotRepositoryImpl <em>Snapshot Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.SnapshotRepositoryImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getSnapshotRepository()
	 * @generated
	 */
	int SNAPSHOT_REPOSITORY = 8;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_REPOSITORY__GROUPS = 0;

	/**
	 * The number of structural features of the '<em>Snapshot Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_REPOSITORY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Snapshot Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_REPOSITORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.SnapshotGroupImpl <em>Snapshot Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.SnapshotGroupImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getSnapshotGroup()
	 * @generated
	 */
	int SNAPSHOT_GROUP = 9;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_GROUP__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_GROUP__DATE = 1;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_GROUP__ENTRIES = 2;

	/**
	 * The number of structural features of the '<em>Snapshot Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_GROUP_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Snapshot Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_GROUP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.SnapshotEntryImpl <em>Snapshot Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.SnapshotEntryImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getSnapshotEntry()
	 * @generated
	 */
	int SNAPSHOT_ENTRY = 10;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_ENTRY__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Taken Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_ENTRY__TAKEN_TIME = 1;

	/**
	 * The feature id for the '<em><b>Original File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_ENTRY__ORIGINAL_FILE = 2;

	/**
	 * The feature id for the '<em><b>Rendered File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_ENTRY__RENDERED_FILE = 3;

	/**
	 * The feature id for the '<em><b>Control Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_ENTRY__CONTROL_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_ENTRY__NAME = 5;

	/**
	 * The feature id for the '<em><b>Shell Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_ENTRY__SHELL_INFO = 6;

	/**
	 * The feature id for the '<em><b>Absoulte Visible File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_ENTRY__ABSOULTE_VISIBLE_FILE_PATH = 7;

	/**
	 * The number of structural features of the '<em>Snapshot Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_ENTRY_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Snapshot Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.ShellInfoImpl <em>Shell Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.ShellInfoImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getShellInfo()
	 * @generated
	 */
	int SHELL_INFO = 11;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_INFO__ICON = 0;

	/**
	 * The feature id for the '<em><b>Shell Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_INFO__SHELL_STYLE = 1;

	/**
	 * The feature id for the '<em><b>Shell Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_INFO__SHELL_TITLE = 2;

	/**
	 * The number of structural features of the '<em>Shell Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_INFO_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Shell Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHELL_INFO_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandHistoryImpl <em>Command History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.CommandHistoryImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getCommandHistory()
	 * @generated
	 */
	int COMMAND_HISTORY = 12;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_HISTORY__EVENTS = 0;

	/**
	 * The number of structural features of the '<em>Command History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_HISTORY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Command History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_HISTORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl <em>Command Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getCommandEvent()
	 * @generated
	 */
	int COMMAND_EVENT = 13;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_EVENT__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Command Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_EVENT__COMMAND_ID = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_EVENT__NAME = 2;

	/**
	 * The feature id for the '<em><b>Image Descriptor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_EVENT__IMAGE_DESCRIPTOR = 3;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_EVENT__TIME = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_EVENT__TYPE = 5;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_EVENT__EXCEPTION = 6;

	/**
	 * The number of structural features of the '<em>Command Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_EVENT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Command Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.ClipItemSortOption <em>Clip Item Sort Option</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipItemSortOption
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getClipItemSortOption()
	 * @generated
	 */
	int CLIP_ITEM_SORT_OPTION = 14;

	/**
	 * The meta object id for the '{@link net.jeeeyul.pdetools.model.pdetools.CommandExecutionType <em>Command Execution Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandExecutionType
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getCommandExecutionType()
	 * @generated
	 */
	int COMMAND_EXECUTION_TYPE = 15;

	/**
	 * The meta object id for the '<em>IFile</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IFile
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getIFile()
	 * @generated
	 */
	int IFILE = 16;

	/**
	 * The meta object id for the '<em>IFolder</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.resources.IFolder
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getIFolder()
	 * @generated
	 */
	int IFOLDER = 17;

	/**
	 * The meta object id for the '<em>Image Data</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.graphics.ImageData
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getImageData()
	 * @generated
	 */
	int IMAGE_DATA = 18;

	/**
	 * The meta object id for the '<em>Clipboard</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.swt.dnd.Clipboard
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getClipboard()
	 * @generated
	 */
	int CLIPBOARD = 19;

	/**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Exception
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getException()
	 * @generated
	 */
	int EXCEPTION = 20;

	/**
	 * The meta object id for the '<em>Image Descriptor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jface.resource.ImageDescriptor
	 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getImageDescriptor()
	 * @generated
	 */
	int IMAGE_DESCRIPTOR = 21;

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardElement <em>Clipboard Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clipboard Element</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardElement
	 * @generated
	 */
	EClass getClipboardElement();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.ClipHistory <em>Clip History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clip History</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipHistory
	 * @generated
	 */
	EClass getClipHistory();

	/**
	 * Returns the meta object for the reference '{@link net.jeeeyul.pdetools.model.pdetools.ClipHistory#getActiveEntry <em>Active Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Active Entry</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipHistory#getActiveEntry()
	 * @see #getClipHistory()
	 * @generated
	 */
	EReference getClipHistory_ActiveEntry();

	/**
	 * Returns the meta object for the containment reference list '{@link net.jeeeyul.pdetools.model.pdetools.ClipHistory#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipHistory#getEntries()
	 * @see #getClipHistory()
	 * @generated
	 */
	EReference getClipHistory_Entries();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry <em>Clipboard Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clipboard Entry</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry
	 * @generated
	 */
	EClass getClipboardEntry();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getUsingCount <em>Using Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Using Count</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getUsingCount()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EAttribute getClipboardEntry_UsingCount();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getLastUsedTime <em>Last Used Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Used Time</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getLastUsedTime()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EAttribute getClipboardEntry_LastUsedTime();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTextContent <em>Text Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Content</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTextContent()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EAttribute getClipboardEntry_TextContent();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getRtfContent <em>Rtf Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rtf Content</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getRtfContent()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EAttribute getClipboardEntry_RtfContent();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTakenTime <em>Taken Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Taken Time</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTakenTime()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EAttribute getClipboardEntry_TakenTime();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getPartId <em>Part Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Id</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getPartId()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EAttribute getClipboardEntry_PartId();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getReleatedFile <em>Releated File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Releated File</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getReleatedFile()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EAttribute getClipboardEntry_ReleatedFile();

	/**
	 * Returns the meta object for the container reference '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getParent()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EReference getClipboardEntry_Parent();

	/**
	 * Returns the meta object for the containment reference '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTextRange <em>Text Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Text Range</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTextRange()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EReference getClipboardEntry_TextRange();

	/**
	 * Returns the meta object for the containment reference '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getJavaInfo <em>Java Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Java Info</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getJavaInfo()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EReference getClipboardEntry_JavaInfo();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#isActive()
	 * @see #getClipboardEntry()
	 * @generated
	 */
	EAttribute getClipboardEntry_Active();

	/**
	 * Returns the meta object for the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#transferTo(org.eclipse.swt.dnd.Clipboard) <em>Transfer To</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Transfer To</em>' operation.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#transferTo(org.eclipse.swt.dnd.Clipboard)
	 * @generated
	 */
	EOperation getClipboardEntry__TransferTo__Clipboard();

	/**
	 * Returns the meta object for the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#increaseUsing() <em>Increase Using</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Increase Using</em>' operation.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#increaseUsing()
	 * @generated
	 */
	EOperation getClipboardEntry__IncreaseUsing();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.TextRange <em>Text Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Range</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.TextRange
	 * @generated
	 */
	EClass getTextRange();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Offset</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.TextRange#getOffset()
	 * @see #getTextRange()
	 * @generated
	 */
	EAttribute getTextRange_Offset();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.TextRange#getLength()
	 * @see #getTextRange()
	 * @generated
	 */
	EAttribute getTextRange_Length();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getStartLine <em>Start Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Line</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.TextRange#getStartLine()
	 * @see #getTextRange()
	 * @generated
	 */
	EAttribute getTextRange_StartLine();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getEndLine <em>End Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Line</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.TextRange#getEndLine()
	 * @see #getTextRange()
	 * @generated
	 */
	EAttribute getTextRange_EndLine();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.JavaInfo <em>Java Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Info</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.JavaInfo
	 * @generated
	 */
	EClass getJavaInfo();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.JavaInfo#getQualifiedTypeName <em>Qualified Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Type Name</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.JavaInfo#getQualifiedTypeName()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_QualifiedTypeName();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.JavaInfo#getEnclosingElementName <em>Enclosing Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enclosing Element Name</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.JavaInfo#getEnclosingElementName()
	 * @see #getJavaInfo()
	 * @generated
	 */
	EAttribute getJavaInfo_EnclosingElementName();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.FieldNameOwner <em>Field Name Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field Name Owner</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.FieldNameOwner
	 * @generated
	 */
	EClass getFieldNameOwner();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.FieldNameOwner#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.FieldNameOwner#getFieldName()
	 * @see #getFieldNameOwner()
	 * @generated
	 */
	EAttribute getFieldNameOwner_FieldName();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.Palette <em>Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Palette</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.Palette
	 * @generated
	 */
	EClass getPalette();

	/**
	 * Returns the meta object for the container reference '{@link net.jeeeyul.pdetools.model.pdetools.Palette#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.Palette#getParent()
	 * @see #getPalette()
	 * @generated
	 */
	EReference getPalette_Parent();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.Palette#getFolder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Folder</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.Palette#getFolder()
	 * @see #getPalette()
	 * @generated
	 */
	EAttribute getPalette_Folder();

	/**
	 * Returns the meta object for the containment reference list '{@link net.jeeeyul.pdetools.model.pdetools.Palette#getSubPalettes <em>Sub Palettes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Palettes</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.Palette#getSubPalettes()
	 * @see #getPalette()
	 * @generated
	 */
	EReference getPalette_SubPalettes();

	/**
	 * Returns the meta object for the containment reference list '{@link net.jeeeyul.pdetools.model.pdetools.Palette#getImageFiles <em>Image Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Image Files</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.Palette#getImageFiles()
	 * @see #getPalette()
	 * @generated
	 */
	EReference getPalette_ImageFiles();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.ImageFile <em>Image File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image File</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ImageFile
	 * @generated
	 */
	EClass getImageFile();

	/**
	 * Returns the meta object for the container reference '{@link net.jeeeyul.pdetools.model.pdetools.ImageFile#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ImageFile#getParent()
	 * @see #getImageFile()
	 * @generated
	 */
	EReference getImageFile_Parent();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ImageFile#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ImageFile#getFile()
	 * @see #getImageFile()
	 * @generated
	 */
	EAttribute getImageFile_File();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotRepository <em>Snapshot Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot Repository</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotRepository
	 * @generated
	 */
	EClass getSnapshotRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotRepository#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotRepository#getGroups()
	 * @see #getSnapshotRepository()
	 * @generated
	 */
	EReference getSnapshotRepository_Groups();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup <em>Snapshot Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot Group</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotGroup
	 * @generated
	 */
	EClass getSnapshotGroup();

	/**
	 * Returns the meta object for the container reference '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getParent()
	 * @see #getSnapshotGroup()
	 * @generated
	 */
	EReference getSnapshotGroup_Parent();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getDate()
	 * @see #getSnapshotGroup()
	 * @generated
	 */
	EAttribute getSnapshotGroup_Date();

	/**
	 * Returns the meta object for the containment reference list '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getEntries()
	 * @see #getSnapshotGroup()
	 * @generated
	 */
	EReference getSnapshotGroup_Entries();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry <em>Snapshot Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot Entry</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry
	 * @generated
	 */
	EClass getSnapshotEntry();

	/**
	 * Returns the meta object for the container reference '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getParent()
	 * @see #getSnapshotEntry()
	 * @generated
	 */
	EReference getSnapshotEntry_Parent();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getTakenTime <em>Taken Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Taken Time</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getTakenTime()
	 * @see #getSnapshotEntry()
	 * @generated
	 */
	EAttribute getSnapshotEntry_TakenTime();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getOriginalFile <em>Original File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original File</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getOriginalFile()
	 * @see #getSnapshotEntry()
	 * @generated
	 */
	EAttribute getSnapshotEntry_OriginalFile();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getRenderedFile <em>Rendered File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rendered File</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getRenderedFile()
	 * @see #getSnapshotEntry()
	 * @generated
	 */
	EAttribute getSnapshotEntry_RenderedFile();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getControlType <em>Control Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Control Type</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getControlType()
	 * @see #getSnapshotEntry()
	 * @generated
	 */
	EAttribute getSnapshotEntry_ControlType();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getName()
	 * @see #getSnapshotEntry()
	 * @generated
	 */
	EAttribute getSnapshotEntry_Name();

	/**
	 * Returns the meta object for the containment reference '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getShellInfo <em>Shell Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Shell Info</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getShellInfo()
	 * @see #getSnapshotEntry()
	 * @generated
	 */
	EReference getSnapshotEntry_ShellInfo();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getAbsoulteVisibleFilePath <em>Absoulte Visible File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Absoulte Visible File Path</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getAbsoulteVisibleFilePath()
	 * @see #getSnapshotEntry()
	 * @generated
	 */
	EAttribute getSnapshotEntry_AbsoulteVisibleFilePath();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo <em>Shell Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shell Info</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ShellInfo
	 * @generated
	 */
	EClass getShellInfo();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ShellInfo#getIcon()
	 * @see #getShellInfo()
	 * @generated
	 */
	EAttribute getShellInfo_Icon();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo#getShellStyle <em>Shell Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shell Style</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ShellInfo#getShellStyle()
	 * @see #getShellInfo()
	 * @generated
	 */
	EAttribute getShellInfo_ShellStyle();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo#getShellTitle <em>Shell Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shell Title</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ShellInfo#getShellTitle()
	 * @see #getShellInfo()
	 * @generated
	 */
	EAttribute getShellInfo_ShellTitle();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.CommandHistory <em>Command History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command History</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandHistory
	 * @generated
	 */
	EClass getCommandHistory();

	/**
	 * Returns the meta object for the containment reference list '{@link net.jeeeyul.pdetools.model.pdetools.CommandHistory#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandHistory#getEvents()
	 * @see #getCommandHistory()
	 * @generated
	 */
	EReference getCommandHistory_Events();

	/**
	 * Returns the meta object for class '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent <em>Command Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command Event</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandEvent
	 * @generated
	 */
	EClass getCommandEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandEvent#getChildren()
	 * @see #getCommandEvent()
	 * @generated
	 */
	EReference getCommandEvent_Children();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getCommandId <em>Command Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command Id</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandEvent#getCommandId()
	 * @see #getCommandEvent()
	 * @generated
	 */
	EAttribute getCommandEvent_CommandId();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandEvent#getName()
	 * @see #getCommandEvent()
	 * @generated
	 */
	EAttribute getCommandEvent_Name();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getImageDescriptor <em>Image Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Descriptor</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandEvent#getImageDescriptor()
	 * @see #getCommandEvent()
	 * @generated
	 */
	EAttribute getCommandEvent_ImageDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandEvent#getTime()
	 * @see #getCommandEvent()
	 * @generated
	 */
	EAttribute getCommandEvent_Time();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandEvent#getType()
	 * @see #getCommandEvent()
	 * @generated
	 */
	EAttribute getCommandEvent_Type();

	/**
	 * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandEvent#getException()
	 * @see #getCommandEvent()
	 * @generated
	 */
	EAttribute getCommandEvent_Exception();

	/**
	 * Returns the meta object for enum '{@link net.jeeeyul.pdetools.model.pdetools.ClipItemSortOption <em>Clip Item Sort Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Clip Item Sort Option</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipItemSortOption
	 * @generated
	 */
	EEnum getClipItemSortOption();

	/**
	 * Returns the meta object for enum '{@link net.jeeeyul.pdetools.model.pdetools.CommandExecutionType <em>Command Execution Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Command Execution Type</em>'.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandExecutionType
	 * @generated
	 */
	EEnum getCommandExecutionType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IFile <em>IFile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IFile</em>'.
	 * @see org.eclipse.core.resources.IFile
	 * @model instanceClass="org.eclipse.core.resources.IFile"
	 * @generated
	 */
	EDataType getIFile();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.resources.IFolder <em>IFolder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IFolder</em>'.
	 * @see org.eclipse.core.resources.IFolder
	 * @model instanceClass="org.eclipse.core.resources.IFolder"
	 * @generated
	 */
	EDataType getIFolder();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.graphics.ImageData <em>Image Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Image Data</em>'.
	 * @see org.eclipse.swt.graphics.ImageData
	 * @model instanceClass="org.eclipse.swt.graphics.ImageData"
	 * @generated
	 */
	EDataType getImageData();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.swt.dnd.Clipboard <em>Clipboard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Clipboard</em>'.
	 * @see org.eclipse.swt.dnd.Clipboard
	 * @model instanceClass="org.eclipse.swt.dnd.Clipboard"
	 * @generated
	 */
	EDataType getClipboard();

	/**
	 * Returns the meta object for data type '{@link java.lang.Exception <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Exception</em>'.
	 * @see java.lang.Exception
	 * @model instanceClass="java.lang.Exception"
	 * @generated
	 */
	EDataType getException();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.jface.resource.ImageDescriptor <em>Image Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Image Descriptor</em>'.
	 * @see org.eclipse.jface.resource.ImageDescriptor
	 * @model instanceClass="org.eclipse.jface.resource.ImageDescriptor"
	 * @generated
	 */
	EDataType getImageDescriptor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PdetoolsFactory getPdetoolsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.ClipboardElementImpl <em>Clipboard Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.ClipboardElementImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getClipboardElement()
		 * @generated
		 */
		EClass CLIPBOARD_ELEMENT = eINSTANCE.getClipboardElement();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.ClipHistoryImpl <em>Clip History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.ClipHistoryImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getClipHistory()
		 * @generated
		 */
		EClass CLIP_HISTORY = eINSTANCE.getClipHistory();

		/**
		 * The meta object literal for the '<em><b>Active Entry</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIP_HISTORY__ACTIVE_ENTRY = eINSTANCE.getClipHistory_ActiveEntry();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIP_HISTORY__ENTRIES = eINSTANCE.getClipHistory_Entries();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.ClipboardEntryImpl <em>Clipboard Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.ClipboardEntryImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getClipboardEntry()
		 * @generated
		 */
		EClass CLIPBOARD_ENTRY = eINSTANCE.getClipboardEntry();

		/**
		 * The meta object literal for the '<em><b>Using Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIPBOARD_ENTRY__USING_COUNT = eINSTANCE.getClipboardEntry_UsingCount();

		/**
		 * The meta object literal for the '<em><b>Last Used Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIPBOARD_ENTRY__LAST_USED_TIME = eINSTANCE.getClipboardEntry_LastUsedTime();

		/**
		 * The meta object literal for the '<em><b>Text Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIPBOARD_ENTRY__TEXT_CONTENT = eINSTANCE.getClipboardEntry_TextContent();

		/**
		 * The meta object literal for the '<em><b>Rtf Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIPBOARD_ENTRY__RTF_CONTENT = eINSTANCE.getClipboardEntry_RtfContent();

		/**
		 * The meta object literal for the '<em><b>Taken Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIPBOARD_ENTRY__TAKEN_TIME = eINSTANCE.getClipboardEntry_TakenTime();

		/**
		 * The meta object literal for the '<em><b>Part Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIPBOARD_ENTRY__PART_ID = eINSTANCE.getClipboardEntry_PartId();

		/**
		 * The meta object literal for the '<em><b>Releated File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIPBOARD_ENTRY__RELEATED_FILE = eINSTANCE.getClipboardEntry_ReleatedFile();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIPBOARD_ENTRY__PARENT = eINSTANCE.getClipboardEntry_Parent();

		/**
		 * The meta object literal for the '<em><b>Text Range</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIPBOARD_ENTRY__TEXT_RANGE = eINSTANCE.getClipboardEntry_TextRange();

		/**
		 * The meta object literal for the '<em><b>Java Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIPBOARD_ENTRY__JAVA_INFO = eINSTANCE.getClipboardEntry_JavaInfo();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIPBOARD_ENTRY__ACTIVE = eINSTANCE.getClipboardEntry_Active();

		/**
		 * The meta object literal for the '<em><b>Transfer To</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLIPBOARD_ENTRY___TRANSFER_TO__CLIPBOARD = eINSTANCE.getClipboardEntry__TransferTo__Clipboard();

		/**
		 * The meta object literal for the '<em><b>Increase Using</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLIPBOARD_ENTRY___INCREASE_USING = eINSTANCE.getClipboardEntry__IncreaseUsing();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.TextRangeImpl <em>Text Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.TextRangeImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getTextRange()
		 * @generated
		 */
		EClass TEXT_RANGE = eINSTANCE.getTextRange();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_RANGE__OFFSET = eINSTANCE.getTextRange_Offset();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_RANGE__LENGTH = eINSTANCE.getTextRange_Length();

		/**
		 * The meta object literal for the '<em><b>Start Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_RANGE__START_LINE = eINSTANCE.getTextRange_StartLine();

		/**
		 * The meta object literal for the '<em><b>End Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_RANGE__END_LINE = eINSTANCE.getTextRange_EndLine();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.JavaInfoImpl <em>Java Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.JavaInfoImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getJavaInfo()
		 * @generated
		 */
		EClass JAVA_INFO = eINSTANCE.getJavaInfo();

		/**
		 * The meta object literal for the '<em><b>Qualified Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__QUALIFIED_TYPE_NAME = eINSTANCE.getJavaInfo_QualifiedTypeName();

		/**
		 * The meta object literal for the '<em><b>Enclosing Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_INFO__ENCLOSING_ELEMENT_NAME = eINSTANCE.getJavaInfo_EnclosingElementName();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.FieldNameOwner <em>Field Name Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.FieldNameOwner
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getFieldNameOwner()
		 * @generated
		 */
		EClass FIELD_NAME_OWNER = eINSTANCE.getFieldNameOwner();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_NAME_OWNER__FIELD_NAME = eINSTANCE.getFieldNameOwner_FieldName();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.PaletteImpl <em>Palette</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PaletteImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getPalette()
		 * @generated
		 */
		EClass PALETTE = eINSTANCE.getPalette();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PALETTE__PARENT = eINSTANCE.getPalette_Parent();

		/**
		 * The meta object literal for the '<em><b>Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PALETTE__FOLDER = eINSTANCE.getPalette_Folder();

		/**
		 * The meta object literal for the '<em><b>Sub Palettes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PALETTE__SUB_PALETTES = eINSTANCE.getPalette_SubPalettes();

		/**
		 * The meta object literal for the '<em><b>Image Files</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PALETTE__IMAGE_FILES = eINSTANCE.getPalette_ImageFiles();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.ImageFileImpl <em>Image File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.ImageFileImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getImageFile()
		 * @generated
		 */
		EClass IMAGE_FILE = eINSTANCE.getImageFile();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE_FILE__PARENT = eINSTANCE.getImageFile_Parent();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE_FILE__FILE = eINSTANCE.getImageFile_File();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.SnapshotRepositoryImpl <em>Snapshot Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.SnapshotRepositoryImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getSnapshotRepository()
		 * @generated
		 */
		EClass SNAPSHOT_REPOSITORY = eINSTANCE.getSnapshotRepository();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT_REPOSITORY__GROUPS = eINSTANCE.getSnapshotRepository_Groups();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.SnapshotGroupImpl <em>Snapshot Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.SnapshotGroupImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getSnapshotGroup()
		 * @generated
		 */
		EClass SNAPSHOT_GROUP = eINSTANCE.getSnapshotGroup();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT_GROUP__PARENT = eINSTANCE.getSnapshotGroup_Parent();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_GROUP__DATE = eINSTANCE.getSnapshotGroup_Date();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT_GROUP__ENTRIES = eINSTANCE.getSnapshotGroup_Entries();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.SnapshotEntryImpl <em>Snapshot Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.SnapshotEntryImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getSnapshotEntry()
		 * @generated
		 */
		EClass SNAPSHOT_ENTRY = eINSTANCE.getSnapshotEntry();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT_ENTRY__PARENT = eINSTANCE.getSnapshotEntry_Parent();

		/**
		 * The meta object literal for the '<em><b>Taken Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_ENTRY__TAKEN_TIME = eINSTANCE.getSnapshotEntry_TakenTime();

		/**
		 * The meta object literal for the '<em><b>Original File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_ENTRY__ORIGINAL_FILE = eINSTANCE.getSnapshotEntry_OriginalFile();

		/**
		 * The meta object literal for the '<em><b>Rendered File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_ENTRY__RENDERED_FILE = eINSTANCE.getSnapshotEntry_RenderedFile();

		/**
		 * The meta object literal for the '<em><b>Control Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_ENTRY__CONTROL_TYPE = eINSTANCE.getSnapshotEntry_ControlType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_ENTRY__NAME = eINSTANCE.getSnapshotEntry_Name();

		/**
		 * The meta object literal for the '<em><b>Shell Info</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT_ENTRY__SHELL_INFO = eINSTANCE.getSnapshotEntry_ShellInfo();

		/**
		 * The meta object literal for the '<em><b>Absoulte Visible File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_ENTRY__ABSOULTE_VISIBLE_FILE_PATH = eINSTANCE.getSnapshotEntry_AbsoulteVisibleFilePath();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.ShellInfoImpl <em>Shell Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.ShellInfoImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getShellInfo()
		 * @generated
		 */
		EClass SHELL_INFO = eINSTANCE.getShellInfo();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHELL_INFO__ICON = eINSTANCE.getShellInfo_Icon();

		/**
		 * The meta object literal for the '<em><b>Shell Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHELL_INFO__SHELL_STYLE = eINSTANCE.getShellInfo_ShellStyle();

		/**
		 * The meta object literal for the '<em><b>Shell Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHELL_INFO__SHELL_TITLE = eINSTANCE.getShellInfo_ShellTitle();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandHistoryImpl <em>Command History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.CommandHistoryImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getCommandHistory()
		 * @generated
		 */
		EClass COMMAND_HISTORY = eINSTANCE.getCommandHistory();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_HISTORY__EVENTS = eINSTANCE.getCommandHistory_Events();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl <em>Command Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getCommandEvent()
		 * @generated
		 */
		EClass COMMAND_EVENT = eINSTANCE.getCommandEvent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND_EVENT__CHILDREN = eINSTANCE.getCommandEvent_Children();

		/**
		 * The meta object literal for the '<em><b>Command Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_EVENT__COMMAND_ID = eINSTANCE.getCommandEvent_CommandId();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_EVENT__NAME = eINSTANCE.getCommandEvent_Name();

		/**
		 * The meta object literal for the '<em><b>Image Descriptor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_EVENT__IMAGE_DESCRIPTOR = eINSTANCE.getCommandEvent_ImageDescriptor();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_EVENT__TIME = eINSTANCE.getCommandEvent_Time();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_EVENT__TYPE = eINSTANCE.getCommandEvent_Type();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND_EVENT__EXCEPTION = eINSTANCE.getCommandEvent_Exception();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.ClipItemSortOption <em>Clip Item Sort Option</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.ClipItemSortOption
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getClipItemSortOption()
		 * @generated
		 */
		EEnum CLIP_ITEM_SORT_OPTION = eINSTANCE.getClipItemSortOption();

		/**
		 * The meta object literal for the '{@link net.jeeeyul.pdetools.model.pdetools.CommandExecutionType <em>Command Execution Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.jeeeyul.pdetools.model.pdetools.CommandExecutionType
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getCommandExecutionType()
		 * @generated
		 */
		EEnum COMMAND_EXECUTION_TYPE = eINSTANCE.getCommandExecutionType();

		/**
		 * The meta object literal for the '<em>IFile</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IFile
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getIFile()
		 * @generated
		 */
		EDataType IFILE = eINSTANCE.getIFile();

		/**
		 * The meta object literal for the '<em>IFolder</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.resources.IFolder
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getIFolder()
		 * @generated
		 */
		EDataType IFOLDER = eINSTANCE.getIFolder();

		/**
		 * The meta object literal for the '<em>Image Data</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.graphics.ImageData
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getImageData()
		 * @generated
		 */
		EDataType IMAGE_DATA = eINSTANCE.getImageData();

		/**
		 * The meta object literal for the '<em>Clipboard</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.swt.dnd.Clipboard
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getClipboard()
		 * @generated
		 */
		EDataType CLIPBOARD = eINSTANCE.getClipboard();

		/**
		 * The meta object literal for the '<em>Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Exception
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getException()
		 * @generated
		 */
		EDataType EXCEPTION = eINSTANCE.getException();

		/**
		 * The meta object literal for the '<em>Image Descriptor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jface.resource.ImageDescriptor
		 * @see net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsPackageImpl#getImageDescriptor()
		 * @generated
		 */
		EDataType IMAGE_DESCRIPTOR = eINSTANCE.getImageDescriptor();

	}

} //PdetoolsPackage
