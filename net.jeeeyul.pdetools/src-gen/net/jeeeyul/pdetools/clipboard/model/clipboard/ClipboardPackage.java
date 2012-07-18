/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
  String eNS_URI = "clipboard";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "clipboard";

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
   * The feature id for the '<em><b>Text Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__TEXT_CONTENT = 1;

  /**
   * The feature id for the '<em><b>Rtf Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__RTF_CONTENT = 2;

  /**
   * The feature id for the '<em><b>Taken Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__TAKEN_TIME = 3;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY__PARENT = 4;

  /**
   * The number of structural features of the '<em>Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY_FEATURE_COUNT = 5;

  /**
   * The number of operations of the '<em>Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLIPBOARD_ENTRY_OPERATION_COUNT = 0;


  /**
   * The meta object id for the '<em>Style Range</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.swt.custom.StyleRange
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl#getStyleRange()
   * @generated
   */
  int STYLE_RANGE = 2;


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
   * Returns the meta object for data type '{@link org.eclipse.swt.custom.StyleRange <em>Style Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Style Range</em>'.
   * @see org.eclipse.swt.custom.StyleRange
   * @model instanceClass="org.eclipse.swt.custom.StyleRange"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel create='return null;' convert='return null;'"
   * @generated
   */
  EDataType getStyleRange();

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
     * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLIPBOARD_ENTRY__PARENT = eINSTANCE.getClipboardEntry_Parent();
    /**
     * The meta object literal for the '<em>Style Range</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.swt.custom.StyleRange
     * @see net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardPackageImpl#getStyleRange()
     * @generated
     */
    EDataType STYLE_RANGE = eINSTANCE.getStyleRange();

  }

} //ClipboardPackage
