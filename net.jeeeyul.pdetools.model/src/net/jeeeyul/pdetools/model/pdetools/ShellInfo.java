/**
 */
package net.jeeeyul.pdetools.model.pdetools;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.swt.graphics.ImageData;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shell Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo#getIcon <em>Icon</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo#getShellStyle <em>Shell Style</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo#getShellTitle <em>Shell Title</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getShellInfo()
 * @model
 * @generated
 */
public interface ShellInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(ImageData)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getShellInfo_Icon()
	 * @model unique="false" dataType="net.jeeeyul.pdetools.model.pdetools.ImageData"
	 * @generated
	 */
	ImageData getIcon();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(ImageData value);

	/**
	 * Returns the value of the '<em><b>Shell Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shell Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shell Style</em>' attribute.
	 * @see #setShellStyle(int)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getShellInfo_ShellStyle()
	 * @model unique="false"
	 * @generated
	 */
	int getShellStyle();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo#getShellStyle <em>Shell Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shell Style</em>' attribute.
	 * @see #getShellStyle()
	 * @generated
	 */
	void setShellStyle(int value);

	/**
	 * Returns the value of the '<em><b>Shell Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shell Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shell Title</em>' attribute.
	 * @see #setShellTitle(String)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getShellInfo_ShellTitle()
	 * @model unique="false"
	 * @generated
	 */
	String getShellTitle();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ShellInfo#getShellTitle <em>Shell Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shell Title</em>' attribute.
	 * @see #getShellTitle()
	 * @generated
	 */
	void setShellTitle(String value);

} // ShellInfo
