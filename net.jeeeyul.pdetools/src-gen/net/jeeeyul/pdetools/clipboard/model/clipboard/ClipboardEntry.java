/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard;

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
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getUsingCount <em>Using Count</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getTextContent <em>Text Content</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getRtfContent <em>Rtf Content</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getTakenTime <em>Taken Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipboardEntry()
 * @model
 * @generated
 */
public interface ClipboardEntry extends EObject
{

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
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipboardEntry_UsingCount()
   * @model unique="false"
   * @generated
   */
  int getUsingCount();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getUsingCount <em>Using Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Using Count</em>' attribute.
   * @see #getUsingCount()
   * @generated
   */
  void setUsingCount(int value);

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
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipboardEntry_TextContent()
   * @model unique="false"
   * @generated
   */
  String getTextContent();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getTextContent <em>Text Content</em>}' attribute.
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
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipboardEntry_RtfContent()
   * @model unique="false"
   * @generated
   */
  String getRtfContent();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getRtfContent <em>Rtf Content</em>}' attribute.
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
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipboardEntry_TakenTime()
   * @model unique="false"
   * @generated
   */
  Date getTakenTime();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getTakenTime <em>Taken Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Taken Time</em>' attribute.
   * @see #getTakenTime()
   * @generated
   */
  void setTakenTime(Date value);

  /**
   * Returns the value of the '<em><b>Parent</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent</em>' container reference.
   * @see #setParent(ClipHistory)
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipboardEntry_Parent()
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory#getEntries
   * @model opposite="entries" transient="false"
   * @generated
   */
  ClipHistory getParent();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getParent <em>Parent</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent</em>' container reference.
   * @see #getParent()
   * @generated
   */
  void setParent(ClipHistory value);
} // ClipboardEntry
