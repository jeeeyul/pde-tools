/**
 */
package net.jeeeyul.pdetools.model.pdetools;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getChildren <em>Children</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getCommandId <em>Command Id</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getName <em>Name</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getImageDescriptor <em>Image Descriptor</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getTime <em>Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getType <em>Type</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getException <em>Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getCommandEvent()
 * @model
 * @generated
 */
public interface CommandEvent extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link net.jeeeyul.pdetools.model.pdetools.CommandEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getCommandEvent_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<CommandEvent> getChildren();

	/**
	 * Returns the value of the '<em><b>Command Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Command Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Command Id</em>' attribute.
	 * @see #setCommandId(String)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getCommandEvent_CommandId()
	 * @model unique="false"
	 * @generated
	 */
	String getCommandId();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getCommandId <em>Command Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command Id</em>' attribute.
	 * @see #getCommandId()
	 * @generated
	 */
	void setCommandId(String value);

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
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getCommandEvent_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Image Descriptor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Descriptor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Descriptor</em>' attribute.
	 * @see #setImageDescriptor(ImageDescriptor)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getCommandEvent_ImageDescriptor()
	 * @model unique="false" dataType="net.jeeeyul.pdetools.model.pdetools.ImageDescriptor"
	 * @generated
	 */
	ImageDescriptor getImageDescriptor();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getImageDescriptor <em>Image Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Descriptor</em>' attribute.
	 * @see #getImageDescriptor()
	 * @generated
	 */
	void setImageDescriptor(ImageDescriptor value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(long)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getCommandEvent_Time()
	 * @model unique="false"
	 * @generated
	 */
	long getTime();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(long value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link net.jeeeyul.pdetools.model.pdetools.CommandExecutionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandExecutionType
	 * @see #setType(CommandExecutionType)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getCommandEvent_Type()
	 * @model unique="false"
	 * @generated
	 */
	CommandExecutionType getType();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see net.jeeeyul.pdetools.model.pdetools.CommandExecutionType
	 * @see #getType()
	 * @generated
	 */
	void setType(CommandExecutionType value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' attribute.
	 * @see #setException(Exception)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getCommandEvent_Exception()
	 * @model unique="false" dataType="net.jeeeyul.pdetools.model.pdetools.Exception"
	 * @generated
	 */
	Exception getException();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.CommandEvent#getException <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' attribute.
	 * @see #getException()
	 * @generated
	 */
	void setException(Exception value);

} // CommandEvent
