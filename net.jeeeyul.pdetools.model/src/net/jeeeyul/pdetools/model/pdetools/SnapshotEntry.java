/**
 */
package net.jeeeyul.pdetools.model.pdetools;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getParent <em>Parent</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getTakenTime <em>Taken Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getOriginalFile <em>Original File</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getRenderedFile <em>Rendered File</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getControlType <em>Control Type</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getName <em>Name</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getShellInfo <em>Shell Info</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getAbsoulteVisibleFilePath <em>Absoulte Visible File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotEntry()
 * @model
 * @generated
 */
public interface SnapshotEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(SnapshotGroup)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotEntry_Parent()
	 * @see net.jeeeyul.pdetools.model.pdetools.SnapshotGroup#getEntries
	 * @model opposite="entries" transient="false"
	 * @generated
	 */
	SnapshotGroup getParent();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getParent <em>Parent</em>}' container reference.
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
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotEntry_TakenTime()
	 * @model unique="false"
	 * @generated
	 */
	Date getTakenTime();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getTakenTime <em>Taken Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Taken Time</em>' attribute.
	 * @see #getTakenTime()
	 * @generated
	 */
	void setTakenTime(Date value);

	/**
	 * Returns the value of the '<em><b>Original File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Original File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original File</em>' attribute.
	 * @see #setOriginalFile(String)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotEntry_OriginalFile()
	 * @model unique="false"
	 * @generated
	 */
	String getOriginalFile();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getOriginalFile <em>Original File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original File</em>' attribute.
	 * @see #getOriginalFile()
	 * @generated
	 */
	void setOriginalFile(String value);

	/**
	 * Returns the value of the '<em><b>Rendered File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rendered File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rendered File</em>' attribute.
	 * @see #setRenderedFile(String)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotEntry_RenderedFile()
	 * @model unique="false"
	 * @generated
	 */
	String getRenderedFile();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getRenderedFile <em>Rendered File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rendered File</em>' attribute.
	 * @see #getRenderedFile()
	 * @generated
	 */
	void setRenderedFile(String value);

	/**
	 * Returns the value of the '<em><b>Control Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Type</em>' attribute.
	 * @see #setControlType(String)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotEntry_ControlType()
	 * @model unique="false"
	 * @generated
	 */
	String getControlType();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getControlType <em>Control Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control Type</em>' attribute.
	 * @see #getControlType()
	 * @generated
	 */
	void setControlType(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotEntry_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Shell Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shell Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shell Info</em>' containment reference.
	 * @see #setShellInfo(ShellInfo)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotEntry_ShellInfo()
	 * @model containment="true"
	 * @generated
	 */
	ShellInfo getShellInfo();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.SnapshotEntry#getShellInfo <em>Shell Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shell Info</em>' containment reference.
	 * @see #getShellInfo()
	 * @generated
	 */
	void setShellInfo(ShellInfo value);

	/**
	 * Returns the value of the '<em><b>Absoulte Visible File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Absoulte Visible File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Absoulte Visible File Path</em>' attribute.
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getSnapshotEntry_AbsoulteVisibleFilePath()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getAbsoulteVisibleFilePath();

} // SnapshotEntry
