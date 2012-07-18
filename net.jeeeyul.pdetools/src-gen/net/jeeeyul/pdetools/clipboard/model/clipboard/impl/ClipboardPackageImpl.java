/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard.impl;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardFactory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.swt.custom.StyleRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClipboardPackageImpl extends EPackageImpl implements ClipboardPackage
{
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
  private EDataType styleRangeEDataType = null;

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
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ClipboardPackageImpl()
  {
    super(eNS_URI, ClipboardFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ClipboardPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ClipboardPackage init()
  {
    if (isInited) return (ClipboardPackage)EPackage.Registry.INSTANCE.getEPackage(ClipboardPackage.eNS_URI);

    // Obtain or create and register package
    ClipboardPackageImpl theClipboardPackage = (ClipboardPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ClipboardPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ClipboardPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theClipboardPackage.createPackageContents();

    // Initialize created meta-data
    theClipboardPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theClipboardPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ClipboardPackage.eNS_URI, theClipboardPackage);
    return theClipboardPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClipHistory()
  {
    return clipHistoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClipHistory_Entries()
  {
    return (EReference)clipHistoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClipboardEntry()
  {
    return clipboardEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClipboardEntry_UsingCount()
  {
    return (EAttribute)clipboardEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClipboardEntry_TextContent()
  {
    return (EAttribute)clipboardEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClipboardEntry_RtfContent()
  {
    return (EAttribute)clipboardEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClipboardEntry_TakenTime()
  {
    return (EAttribute)clipboardEntryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClipboardEntry_Parent()
  {
    return (EReference)clipboardEntryEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getStyleRange()
  {
    return styleRangeEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClipboardFactory getClipboardFactory()
  {
    return (ClipboardFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    clipHistoryEClass = createEClass(CLIP_HISTORY);
    createEReference(clipHistoryEClass, CLIP_HISTORY__ENTRIES);

    clipboardEntryEClass = createEClass(CLIPBOARD_ENTRY);
    createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__USING_COUNT);
    createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__TEXT_CONTENT);
    createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__RTF_CONTENT);
    createEAttribute(clipboardEntryEClass, CLIPBOARD_ENTRY__TAKEN_TIME);
    createEReference(clipboardEntryEClass, CLIPBOARD_ENTRY__PARENT);

    // Create data types
    styleRangeEDataType = createEDataType(STYLE_RANGE);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(clipHistoryEClass, ClipHistory.class, "ClipHistory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClipHistory_Entries(), this.getClipboardEntry(), this.getClipboardEntry_Parent(), "entries", null, 0, -1, ClipHistory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(clipboardEntryEClass, ClipboardEntry.class, "ClipboardEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClipboardEntry_UsingCount(), theEcorePackage.getEInt(), "usingCount", null, 0, 1, ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClipboardEntry_TextContent(), theEcorePackage.getEString(), "textContent", null, 0, 1, ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClipboardEntry_RtfContent(), theEcorePackage.getEString(), "rtfContent", null, 0, 1, ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClipboardEntry_TakenTime(), theEcorePackage.getEDate(), "takenTime", null, 0, 1, ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClipboardEntry_Parent(), this.getClipHistory(), this.getClipHistory_Entries(), "parent", null, 0, 1, ClipboardEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(styleRangeEDataType, StyleRange.class, "StyleRange", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //ClipboardPackageImpl
