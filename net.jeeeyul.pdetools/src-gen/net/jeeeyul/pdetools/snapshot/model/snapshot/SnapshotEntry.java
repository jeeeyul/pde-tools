/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry#getParent <em>Parent</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry#getTakenTime <em>Taken Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry#getFileName <em>File Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage#getSnapshotEntry()
 * @model
 * @generated
 */
public interface SnapshotEntry extends EObject
{
  /**
   * Returns the value of the '<em><b>Parent</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent</em>' container reference.
   * @see #setParent(SnapshotGroup)
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage#getSnapshotEntry_Parent()
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup#getEntries
   * @model opposite="entries" transient="false"
   * @generated
   */
  SnapshotGroup getParent();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry#getParent <em>Parent</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent</em>' container reference.
   * @see #getParent()
   * @generated
   */
  void setParent(SnapshotGroup value);

  /**
   * Returns the value of the '<em><b>Taken Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Taken Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Taken Time</em>' attribute.
   * @see #setTakenTime(Date)
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage#getSnapshotEntry_TakenTime()
   * @model unique="false"
   * @generated
   */
  Date getTakenTime();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry#getTakenTime <em>Taken Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Taken Time</em>' attribute.
   * @see #getTakenTime()
   * @generated
   */
  void setTakenTime(Date value);

  /**
   * Returns the value of the '<em><b>File Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File Name</em>' attribute.
   * @see #setFileName(String)
   * @see net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage#getSnapshotEntry_FileName()
   * @model unique="false"
   * @generated
   */
  String getFileName();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry#getFileName <em>File Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File Name</em>' attribute.
   * @see #getFileName()
   * @generated
   */
  void setFileName(String value);

} // SnapshotEntry
