/**
 */
package net.jeeeyul.pdetools.model.pdetools;

import java.util.Date;

import org.eclipse.core.resources.IFile;

import org.eclipse.swt.dnd.Clipboard;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clipboard Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getUsingCount <em>Using Count</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getLastUsedTime <em>Last Used Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTextContent <em>Text Content</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getRtfContent <em>Rtf Content</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTakenTime <em>Taken Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getPartId <em>Part Id</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getReleatedFile <em>Releated File</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getParent <em>Parent</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTextRange <em>Text Range</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getJavaInfo <em>Java Info</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#isActive <em>Active</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry()
 * @model annotation="http://www.eclipse.org/emf/2002/GenModel labelFeature='textContent'"
 * @generated
 */
public interface ClipboardEntry extends ClipboardElement {
	/**
	 * Returns the value of the '<em><b>Using Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Using Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Using Count</em>' attribute.
	 * @see #setUsingCount(int)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_UsingCount()
	 * @model unique="false"
	 * @generated
	 */
	int getUsingCount();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getUsingCount <em>Using Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Using Count</em>' attribute.
	 * @see #getUsingCount()
	 * @generated
	 */
	void setUsingCount(int value);

	/**
	 * Returns the value of the '<em><b>Last Used Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Used Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Used Time</em>' attribute.
	 * @see #setLastUsedTime(Date)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_LastUsedTime()
	 * @model unique="false"
	 * @generated
	 */
	Date getLastUsedTime();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getLastUsedTime <em>Last Used Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Used Time</em>' attribute.
	 * @see #getLastUsedTime()
	 * @generated
	 */
	void setLastUsedTime(Date value);

	/**
	 * Returns the value of the '<em><b>Text Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Content</em>' attribute.
	 * @see #setTextContent(String)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_TextContent()
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyMultiLine='true' propertyCategory='Content'"
	 * @generated
	 */
	String getTextContent();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTextContent <em>Text Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Content</em>' attribute.
	 * @see #getTextContent()
	 * @generated
	 */
	void setTextContent(String value);

	/**
	 * Returns the value of the '<em><b>Rtf Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rtf Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rtf Content</em>' attribute.
	 * @see #setRtfContent(String)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_RtfContent()
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyMultiLine='true' propertyCategory='Content'"
	 * @generated
	 */
	String getRtfContent();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getRtfContent <em>Rtf Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rtf Content</em>' attribute.
	 * @see #getRtfContent()
	 * @generated
	 */
	void setRtfContent(String value);

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
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_TakenTime()
	 * @model unique="false"
	 * @generated
	 */
	Date getTakenTime();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTakenTime <em>Taken Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Taken Time</em>' attribute.
	 * @see #getTakenTime()
	 * @generated
	 */
	void setTakenTime(Date value);

	/**
	 * Returns the value of the '<em><b>Part Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Id</em>' attribute.
	 * @see #setPartId(String)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_PartId()
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel property='None'"
	 * @generated
	 */
	String getPartId();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getPartId <em>Part Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Id</em>' attribute.
	 * @see #getPartId()
	 * @generated
	 */
	void setPartId(String value);

	/**
	 * Returns the value of the '<em><b>Releated File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Releated File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Releated File</em>' attribute.
	 * @see #setReleatedFile(IFile)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_ReleatedFile()
	 * @model unique="false" dataType="net.jeeeyul.pdetools.model.pdetools.IFile"
	 * @generated
	 */
	IFile getReleatedFile();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getReleatedFile <em>Releated File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Releated File</em>' attribute.
	 * @see #getReleatedFile()
	 * @generated
	 */
	void setReleatedFile(IFile value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.jeeeyul.pdetools.model.pdetools.ClipHistory#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(ClipHistory)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_Parent()
	 * @see net.jeeeyul.pdetools.model.pdetools.ClipHistory#getEntries
	 * @model opposite="entries" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel property='None'"
	 * @generated
	 */
	ClipHistory getParent();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ClipHistory value);

	/**
	 * Returns the value of the '<em><b>Text Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Range</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Range</em>' containment reference.
	 * @see #setTextRange(TextRange)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_TextRange()
	 * @model containment="true"
	 * @generated
	 */
	TextRange getTextRange();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getTextRange <em>Text Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Range</em>' containment reference.
	 * @see #getTextRange()
	 * @generated
	 */
	void setTextRange(TextRange value);

	/**
	 * Returns the value of the '<em><b>Java Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Info</em>' containment reference.
	 * @see #setJavaInfo(JavaInfo)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_JavaInfo()
	 * @model containment="true"
	 * @generated
	 */
	JavaInfo getJavaInfo();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ClipboardEntry#getJavaInfo <em>Java Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Info</em>' containment reference.
	 * @see #getJavaInfo()
	 * @generated
	 */
	void setJavaInfo(JavaInfo value);

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 현재 시스템 클립보드의 클립보드 컨텐츠인지 여부.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipboardEntry_Active()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='Whether it is current content of clipboard.'"
	 * @generated
	 */
	boolean isActive();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model clipboardDataType="net.jeeeyul.pdetools.model.pdetools.Clipboard" clipboardUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void transferTo(Clipboard clipboard);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void increaseUsing();

} // ClipboardEntry
