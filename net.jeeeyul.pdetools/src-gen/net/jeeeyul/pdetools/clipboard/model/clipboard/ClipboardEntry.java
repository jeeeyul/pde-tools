/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard;

import java.util.Date;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.graphics.ImageData;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getUsingCount <em>Using Count</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getLastUsedTime <em>Last Used Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getTextContent <em>Text Content</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getRtfContent <em>Rtf Content</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getTakenTime <em>Taken Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getImageData <em>Image Data</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getPartId <em>Part Id</em>}</li>
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
   * Returns the value of the '<em><b>Last Used Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Used Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Used Time</em>' attribute.
   * @see #setLastUsedTime(Date)
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipboardEntry_LastUsedTime()
   * @model unique="false"
   * @generated
   */
  Date getLastUsedTime();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getLastUsedTime <em>Last Used Time</em>}' attribute.
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
   * Returns the value of the '<em><b>Image Data</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Image Data</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Image Data</em>' attribute.
   * @see #setImageData(ImageData)
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipboardEntry_ImageData()
   * @model unique="false" dataType="net.jeeeyul.pdetools.clipboard.model.clipboard.ImageData"
   * @generated
   */
  ImageData getImageData();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getImageData <em>Image Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Image Data</em>' attribute.
   * @see #getImageData()
   * @generated
   */
  void setImageData(ImageData value);

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
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipboardEntry_PartId()
   * @model unique="false"
   * @generated
   */
  String getPartId();

  /**
   * Sets the value of the '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getPartId <em>Part Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Part Id</em>' attribute.
   * @see #getPartId()
   * @generated
   */
  void setPartId(String value);

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

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model clipboardDataType="net.jeeeyul.pdetools.clipboard.model.clipboard.Clipboard" clipboardUnique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%java.util.ArrayList%><<%org.eclipse.swt.dnd.Transfer%>> _arrayList = new <%java.util.ArrayList%><<%org.eclipse.swt.dnd.Transfer%>>();\n<%java.util.ArrayList%><<%org.eclipse.swt.dnd.Transfer%>> transferList = _arrayList;\n<%java.util.ArrayList%><<%java.lang.Object%>> _arrayList_1 = new <%java.util.ArrayList%><<%java.lang.Object%>>();\n<%java.util.ArrayList%><<%java.lang.Object%>> dataList = _arrayList_1;\n<%net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry%> _this = this;\n<%java.lang.String%> _textContent = _this.getTextContent();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_textContent, null));\nif (_notEquals)\n{\n\t<%org.eclipse.swt.dnd.TextTransfer%> _instance = <%org.eclipse.swt.dnd.TextTransfer%>.getInstance();\n\ttransferList.add(_instance);\n\t<%net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry%> _this_1 = this;\n\t<%java.lang.String%> _textContent_1 = _this_1.getTextContent();\n\tdataList.add(_textContent_1);\n}\n<%net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry%> _this_2 = this;\n<%java.lang.String%> _rtfContent = _this_2.getRtfContent();\nboolean _notEquals_1 = (!<%com.google.common.base.Objects%>.equal(_rtfContent, null));\nif (_notEquals_1)\n{\n\t<%org.eclipse.swt.dnd.RTFTransfer%> _instance_1 = <%org.eclipse.swt.dnd.RTFTransfer%>.getInstance();\n\ttransferList.add(_instance_1);\n\t<%net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry%> _this_3 = this;\n\t<%java.lang.String%> _rtfContent_1 = _this_3.getRtfContent();\n\tdataList.add(_rtfContent_1);\n}\nfinal <%java.util.ArrayList%><<%java.lang.Object%>> _converted_dataList = (<%java.util.ArrayList%><<%java.lang.Object%>>)dataList;\nfinal <%java.util.ArrayList%><<%org.eclipse.swt.dnd.Transfer%>> _converted_transferList = (<%java.util.ArrayList%><<%org.eclipse.swt.dnd.Transfer%>>)transferList;\nclipboard.setContents(((<%java.lang.Object%>[])<%org.eclipse.xtext.xbase.lib.Conversions%>.unwrapArray(_converted_dataList, <%java.lang.Object%>.class)), ((<%org.eclipse.swt.dnd.Transfer%>[])<%org.eclipse.xtext.xbase.lib.Conversions%>.unwrapArray(_converted_transferList, <%org.eclipse.swt.dnd.Transfer%>.class)));'"
   * @generated
   */
  void transferTo(Clipboard clipboard);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry%> _this = this;\n<%net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry%> _this_1 = this;\nint _usingCount = _this_1.getUsingCount();\nint _plus = (_usingCount + 1);\n_this.setUsingCount(_plus);\n<%net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry%> _this_2 = this;\n<%java.util.Date%> _date = new <%java.util.Date%>();\n_this_2.setLastUsedTime(_date);'"
   * @generated
   */
  void increaseUsing();
} // ClipboardEntry
