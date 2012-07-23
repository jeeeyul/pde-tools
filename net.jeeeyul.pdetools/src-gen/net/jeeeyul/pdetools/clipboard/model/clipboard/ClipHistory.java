/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clip History</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipHistory()
 * @model
 * @generated
 */
public interface ClipHistory extends EObject
{
  /**
   * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
   * The list contents are of type {@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry}.
   * It is bidirectional and its opposite is '{@link net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entries</em>' containment reference list.
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getClipHistory_Entries()
   * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry#getParent
   * @model opposite="parent" containment="true"
   * @generated
   */
  EList<ClipboardEntry> getEntries();

} // ClipHistory
