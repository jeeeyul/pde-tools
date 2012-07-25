/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage
 * @generated
 */
public interface SnapshotFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SnapshotFactory eINSTANCE = net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Repository</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Repository</em>'.
   * @generated
   */
  SnapshotRepository createSnapshotRepository();

  /**
   * Returns a new object of class '<em>Group</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Group</em>'.
   * @generated
   */
  SnapshotGroup createSnapshotGroup();

  /**
   * Returns a new object of class '<em>Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry</em>'.
   * @generated
   */
  SnapshotEntry createSnapshotEntry();

  /**
   * Returns a new object of class '<em>Shell Info</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shell Info</em>'.
   * @generated
   */
  ShellInfo createShellInfo();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SnapshotPackage getSnapshotPackage();

} //SnapshotFactory
