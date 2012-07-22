/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository#getRepositoryLocation <em>Repository Location</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage#getSnapshotRepository()
 * @model
 * @generated
 */
public interface SnapshotRepository extends EObject
{
  /**
   * Returns the value of the '<em><b>Repository Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Repository Location</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repository Location</em>' attribute.
   * @see #setRepositoryLocation(String)
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage#getSnapshotRepository_RepositoryLocation()
   * @model unique="false"
   * @generated
   */
  String getRepositoryLocation();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository#getRepositoryLocation <em>Repository Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Repository Location</em>' attribute.
   * @see #getRepositoryLocation()
   * @generated
   */
  void setRepositoryLocation(String value);

  /**
   * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
   * The list contents are of type {@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup}.
   * It is bidirectional and its opposite is '{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Groups</em>' containment reference list.
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage#getSnapshotRepository_Groups()
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup#getParent
   * @model opposite="parent" containment="true"
   * @generated
   */
  EList<SnapshotGroup> getGroups();

} // SnapshotRepository
