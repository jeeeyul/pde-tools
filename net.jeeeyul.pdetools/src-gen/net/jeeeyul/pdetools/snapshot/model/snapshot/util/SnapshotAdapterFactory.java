/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot.util;

import net.jeeeyul.pdetools.snapshot.model.snapshot.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage
 * @generated
 */
public class SnapshotAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SnapshotPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnapshotAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = SnapshotPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SnapshotSwitch<Adapter> modelSwitch =
    new SnapshotSwitch<Adapter>()
    {
      @Override
      public Adapter caseSnapshotRepository(SnapshotRepository object)
      {
        return createSnapshotRepositoryAdapter();
      }
      @Override
      public Adapter caseSnapshotGroup(SnapshotGroup object)
      {
        return createSnapshotGroupAdapter();
      }
      @Override
      public Adapter caseSnapshotEntry(SnapshotEntry object)
      {
        return createSnapshotEntryAdapter();
      }
      @Override
      public Adapter caseShellInfo(ShellInfo object)
      {
        return createShellInfoAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository <em>Repository</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository
   * @generated
   */
  public Adapter createSnapshotRepositoryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup
   * @generated
   */
  public Adapter createSnapshotGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry
   * @generated
   */
  public Adapter createSnapshotEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.snapshot.model.snapshot.ShellInfo <em>Shell Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.ShellInfo
   * @generated
   */
  public Adapter createShellInfoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //SnapshotAdapterFactory
