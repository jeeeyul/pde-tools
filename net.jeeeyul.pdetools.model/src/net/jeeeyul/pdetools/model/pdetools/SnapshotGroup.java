/**
 */
package net.jeeeyul.pdetools.model.pdetools;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getParent <em>Parent</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getDate <em>Date</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotGroup()
 * @model
 * @generated
 */
public interface SnapshotGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotRepository#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(SnapshotRepository)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotGroup_Parent()
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotRepository#getGroups
	 * @model opposite="groups" transient="false"
	 * @generated
	 */
	SnapshotRepository getParent();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(SnapshotRepository value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotGroup_Date()
	 * @model unique="false"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry}.
	 * It is bidirectional and its opposite is '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotGroup_Entries()
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<SnapshotEntry> getEntries();

} // SnapshotGroup
