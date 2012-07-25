/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage
 * @generated
 */
public interface ClipboardFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ClipboardFactory eINSTANCE = net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Clip History</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Clip History</em>'.
   * @generated
   */
  ClipHistory createClipHistory();

  /**
   * Returns a new object of class '<em>Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry</em>'.
   * @generated
   */
  ClipboardEntry createClipboardEntry();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ClipboardPackage getClipboardPackage();

} //ClipboardFactory
