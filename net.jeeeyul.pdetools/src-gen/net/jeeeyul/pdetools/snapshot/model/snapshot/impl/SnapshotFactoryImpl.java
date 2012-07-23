/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot.impl;

import net.jeeeyul.pdetools.snapshot.model.snapshot.*;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotFactory;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SnapshotFactoryImpl extends EFactoryImpl implements SnapshotFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SnapshotFactory init()
  {
    try
    {
      SnapshotFactory theSnapshotFactory = (SnapshotFactory)EPackage.Registry.INSTANCE.getEFactory("http://jeeeyul.net/pde-tools/snapshot"); 
      if (theSnapshotFactory != null)
      {
        return theSnapshotFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SnapshotFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnapshotFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SnapshotPackage.SNAPSHOT_REPOSITORY: return createSnapshotRepository();
      case SnapshotPackage.SNAPSHOT_GROUP: return createSnapshotGroup();
      case SnapshotPackage.SNAPSHOT_ENTRY: return createSnapshotEntry();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnapshotRepository createSnapshotRepository()
  {
    SnapshotRepositoryImpl snapshotRepository = new SnapshotRepositoryImpl();
    return snapshotRepository;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnapshotGroup createSnapshotGroup()
  {
    SnapshotGroupImpl snapshotGroup = new SnapshotGroupImpl();
    return snapshotGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnapshotEntry createSnapshotEntry()
  {
    SnapshotEntryImpl snapshotEntry = new SnapshotEntryImpl();
    return snapshotEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnapshotPackage getSnapshotPackage()
  {
    return (SnapshotPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SnapshotPackage getPackage()
  {
    return SnapshotPackage.eINSTANCE;
  }

} //SnapshotFactoryImpl
