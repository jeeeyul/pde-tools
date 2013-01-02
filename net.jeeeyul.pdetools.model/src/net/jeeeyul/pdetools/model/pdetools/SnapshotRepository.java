/**
 */
package net.jeeeyul.pdetools.model.pdetools;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotRepository#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotRepository()
 * @model
 * @generated
 */
public interface SnapshotRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup}.
	 * It is bidirectional and its opposite is '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotRepository_Groups()
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<SnapshotGroup> getGroups();

} // SnapshotRepository
