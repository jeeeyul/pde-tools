/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot.impl;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage;

import net.jeeeyul.pdetools.snapshot.model.snapshot.ShellInfo;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotFactory;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SnapshotPackageImpl extends EPackageImpl implements SnapshotPackage
{
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
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SnapshotPackageImpl()
  {
    super(eNS_URI, SnapshotFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link SnapshotPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SnapshotPackage init()
  {
    if (isInited) return (SnapshotPackage)EPackage.Registry.INSTANCE.getEPackage(SnapshotPackage.eNS_URI);

    // Obtain or create and register package
    SnapshotPackageImpl theSnapshotPackage = (SnapshotPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SnapshotPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SnapshotPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    ClipboardPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theSnapshotPackage.createPackageContents();

    // Initialize created meta-data
    theSnapshotPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSnapshotPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SnapshotPackage.eNS_URI, theSnapshotPackage);
    return theSnapshotPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSnapshotRepository()
  {
    return snapshotRepositoryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSnapshotRepository_RepositoryLocation()
  {
    return (EAttribute)snapshotRepositoryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSnapshotRepository_Groups()
  {
    return (EReference)snapshotRepositoryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSnapshotGroup()
  {
    return snapshotGroupEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSnapshotGroup_Parent()
  {
    return (EReference)snapshotGroupEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSnapshotGroup_Date()
  {
    return (EAttribute)snapshotGroupEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSnapshotGroup_Entries()
  {
    return (EReference)snapshotGroupEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSnapshotEntry()
  {
    return snapshotEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSnapshotEntry_Parent()
  {
    return (EReference)snapshotEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSnapshotEntry_TakenTime()
  {
    return (EAttribute)snapshotEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSnapshotEntry_OriginalFile()
  {
    return (EAttribute)snapshotEntryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSnapshotEntry_RenderedFile()
  {
    return (EAttribute)snapshotEntryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSnapshotEntry_ControlType()
  {
    return (EAttribute)snapshotEntryEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSnapshotEntry_ShellInfo()
  {
    return (EReference)snapshotEntryEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSnapshotEntry_AbsoulteFilePath()
  {
    return (EAttribute)snapshotEntryEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShellInfo()
  {
    return shellInfoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShellInfo_Icon()
  {
    return (EAttribute)shellInfoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShellInfo_ShellStyle()
  {
    return (EAttribute)shellInfoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShellInfo_ShellTitle()
  {
    return (EAttribute)shellInfoEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnapshotFactory getSnapshotFactory()
  {
    return (SnapshotFactory)getEFactoryInstance();
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
    snapshotRepositoryEClass = createEClass(SNAPSHOT_REPOSITORY);
    createEAttribute(snapshotRepositoryEClass, SNAPSHOT_REPOSITORY__REPOSITORY_LOCATION);
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
    createEReference(snapshotEntryEClass, SNAPSHOT_ENTRY__SHELL_INFO);
    createEAttribute(snapshotEntryEClass, SNAPSHOT_ENTRY__ABSOULTE_FILE_PATH);

    shellInfoEClass = createEClass(SHELL_INFO);
    createEAttribute(shellInfoEClass, SHELL_INFO__ICON);
    createEAttribute(shellInfoEClass, SHELL_INFO__SHELL_STYLE);
    createEAttribute(shellInfoEClass, SHELL_INFO__SHELL_TITLE);
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
    ClipboardPackage theClipboardPackage = (ClipboardPackage)EPackage.Registry.INSTANCE.getEPackage(ClipboardPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(snapshotRepositoryEClass, SnapshotRepository.class, "SnapshotRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSnapshotRepository_RepositoryLocation(), theEcorePackage.getEString(), "repositoryLocation", null, 0, 1, SnapshotRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSnapshotRepository_Groups(), this.getSnapshotGroup(), this.getSnapshotGroup_Parent(), "groups", null, 0, -1, SnapshotRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(snapshotGroupEClass, SnapshotGroup.class, "SnapshotGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSnapshotGroup_Parent(), this.getSnapshotRepository(), this.getSnapshotRepository_Groups(), "parent", null, 0, 1, SnapshotGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSnapshotGroup_Date(), theEcorePackage.getEDate(), "date", null, 0, 1, SnapshotGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSnapshotGroup_Entries(), this.getSnapshotEntry(), this.getSnapshotEntry_Parent(), "entries", null, 0, -1, SnapshotGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(snapshotEntryEClass, SnapshotEntry.class, "SnapshotEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSnapshotEntry_Parent(), this.getSnapshotGroup(), this.getSnapshotGroup_Entries(), "parent", null, 0, 1, SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSnapshotEntry_TakenTime(), theEcorePackage.getEDate(), "takenTime", null, 0, 1, SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSnapshotEntry_OriginalFile(), theEcorePackage.getEString(), "originalFile", null, 0, 1, SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSnapshotEntry_RenderedFile(), theEcorePackage.getEString(), "renderedFile", null, 0, 1, SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSnapshotEntry_ControlType(), theEcorePackage.getEString(), "controlType", null, 0, 1, SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSnapshotEntry_ShellInfo(), this.getShellInfo(), null, "shellInfo", null, 0, 1, SnapshotEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSnapshotEntry_AbsoulteFilePath(), theEcorePackage.getEString(), "absoulteFilePath", null, 0, 1, SnapshotEntry.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

    initEClass(shellInfoEClass, ShellInfo.class, "ShellInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getShellInfo_Icon(), theClipboardPackage.getImageData(), "icon", null, 0, 1, ShellInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getShellInfo_ShellStyle(), theEcorePackage.getEInt(), "shellStyle", null, 0, 1, ShellInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getShellInfo_ShellTitle(), theEcorePackage.getEString(), "shellTitle", null, 0, 1, ShellInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //SnapshotPackageImpl
