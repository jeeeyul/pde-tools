/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='net.jeeeyul.pdetools.clipboard.model'"
 * @generated
 */
public interface ClipboardPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "clipboard";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://jeeeyul.net/pde-tools/clipboard";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "c";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ClipboardPackage eINSTANCE = net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl.init();

  /**
   * The meta object id for the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipHistoryImpl <em>Clip History</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipHistoryImpl
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl#getClipHistory()
   * @generated
   */
  int CLIP_HISTORY = 0;

  /**
   * The feature id for the '<em><b>Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIP_HISTORY__ENTRIES = 0;

  /**
   * The number of structural features of the '<em>Clip History</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIP_HISTORY_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Clip History</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIP_HISTORY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl <em>Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl#getClipboardEntry()
   * @generated
   */
  int CLIPBOARD_ENTRY = 1;

  /**
   * The feature id for the '<em><b>Using Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__USING_COUNT = 0;

  /**
   * The feature id for the '<em><b>Last Used Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__LAST_USED_TIME = 1;

  /**
   * The feature id for the '<em><b>Text Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__TEXT_CONTENT = 2;

  /**
   * The feature id for the '<em><b>Rtf Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__RTF_CONTENT = 3;

  /**
   * The feature id for the '<em><b>Taken Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__TAKEN_TIME = 4;

  /**
   * The feature id for the '<em><b>Image Data</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__IMAGE_DATA = 5;

  /**
   * The feature id for the '<em><b>Part Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__PART_ID = 6;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__PARENT = 7;

  /**
   * The number of structural features of the '<em>Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY_FEATURE_COUNT = 8;

  /**
   * The operation id for the '<em>Transfer To</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY___TRANSFER_TO__CLIPBOARD = 0;

  /**
   * The operation id for the '<em>Increase Using</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY___INCREASE_USING = 1;

  /**
   * The number of operations of the '<em>Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY_OPERATION_COUNT = 2;

  /**
   * The meta object id for the '<em>Clipboard</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.swt.dnd.Clipboard
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl#getClipboard()
   * @generated
   */
  int CLIPBOARD = 2;

  /**
   * The meta object id for the '<em>Image Data</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.swt.graphics.ImageData
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl#getImageData()
   * @generated
   */
  int IMAGE_DATA = 3;


  /**
   * Returns the meta object for class '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory <em>Clip History</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Clip History</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory
   * @generated
   */
  EClass getClipHistory();

  /**
   * Returns the meta object for the containment reference list '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entries</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory#getEntries()
   * @see #getClipHistory()
   * @generated
   */
  EReference getClipHistory_Entries();

  /**
   * Returns the meta object for class '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry
   * @generated
   */
  EClass getClipboardEntry();

  /**
   * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getUsingCount <em>Using Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Using Count</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getUsingCount()
   * @see #getClipboardEntry()
   * @generated
   */
  EAttribute getClipboardEntry_UsingCount();

  /**
   * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getLastUsedTime <em>Last Used Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Last Used Time</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getLastUsedTime()
   * @see #getClipboardEntry()
   * @generated
   */
  EAttribute getClipboardEntry_LastUsedTime();

  /**
   * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getTextContent <em>Text Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text Content</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getTextContent()
   * @see #getClipboardEntry()
   * @generated
   */
  EAttribute getClipboardEntry_TextContent();

  /**
   * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getRtfContent <em>Rtf Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rtf Content</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getRtfContent()
   * @see #getClipboardEntry()
   * @generated
   */
  EAttribute getClipboardEntry_RtfContent();

  /**
   * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getTakenTime <em>Taken Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Taken Time</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getTakenTime()
   * @see #getClipboardEntry()
   * @generated
   */
  EAttribute getClipboardEntry_TakenTime();

  /**
   * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getImageData <em>Image Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Image Data</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getImageData()
   * @see #getClipboardEntry()
   * @generated
   */
  EAttribute getClipboardEntry_ImageData();

  /**
   * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getPartId <em>Part Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Part Id</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getPartId()
   * @see #getClipboardEntry()
   * @generated
   */
  EAttribute getClipboardEntry_PartId();

  /**
   * Returns the meta object for the container reference '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parent</em>'.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getParent()
   * @see #getClipboardEntry()
   * @generated
   */
  EReference getClipboardEntry_Parent();

  /**
   * Returns the meta object for the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#transferTo(org.eclipse.swt.dnd.Clipboard) <em>Transfer To</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Transfer To</em>' operation.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#transferTo(org.eclipse.swt.dnd.Clipboard)
   * @generated
   */
  EOperation getClipboardEntry__TransferTo__Clipboard();

  /**
   * Returns the meta object for the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#increaseUsing() <em>Increase Using</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Increase Using</em>' operation.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#increaseUsing()
   * @generated
   */
  EOperation getClipboardEntry__IncreaseUsing();

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
   * Returns the meta object for data type '{@link org.eclipse.swt.graphics.ImageData <em>Image Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Image Data</em>'.
   * @see org.eclipse.swt.graphics.ImageData
   * @model instanceClass="org.eclipse.swt.graphics.ImageData"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel create='<%org.eclipse.swt.graphics.ImageData%> _deserialize = <%net.jeeeyul.pdetool.shared.ImageDataSerializer%>.deserialize(it);\nreturn _deserialize;' convert='<%java.lang.String%> _serialize = <%net.jeeeyul.pdetool.shared.ImageDataSerializer%>.serialize(it);\nreturn _serialize;'"
   * @generated
   */
  EDataType getImageData();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ClipboardFactory getClipboardFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipHistoryImpl <em>Clip History</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipHistoryImpl
     * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl#getClipHistory()
     * @generated
     */
    EClass CLIP_HISTORY = eINSTANCE.getClipHistory();

    /**
     * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLIP_HISTORY__ENTRIES = eINSTANCE.getClipHistory_Entries();

    /**
     * The meta object literal for the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl <em>Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl
     * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl#getClipboardEntry()
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
     * The meta object literal for the '<em><b>Image Data</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLIPBOARD_ENTRY__IMAGE_DATA = eINSTANCE.getClipboardEntry_ImageData();

    /**
     * The meta object literal for the '<em><b>Part Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLIPBOARD_ENTRY__PART_ID = eINSTANCE.getClipboardEntry_PartId();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLIPBOARD_ENTRY__PARENT = eINSTANCE.getClipboardEntry_Parent();

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
     * The meta object literal for the '<em>Clipboard</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.swt.dnd.Clipboard
     * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl#getClipboard()
     * @generated
     */
    EDataType CLIPBOARD = eINSTANCE.getClipboard();

    /**
     * The meta object literal for the '<em>Image Data</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.swt.graphics.ImageData
     * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl#getImageData()
     * @generated
     */
    EDataType IMAGE_DATA = eINSTANCE.getImageData();

  }

} //ClipboardPackage
