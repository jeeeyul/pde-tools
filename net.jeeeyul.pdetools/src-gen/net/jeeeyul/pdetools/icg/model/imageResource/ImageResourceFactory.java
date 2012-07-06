/**
 */
package net.jeeeyul.pdetools.icg.model.imageResource;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.icg.model.imageResource.ImageResourcePackage
 * @generated
 */
public interface ImageResourceFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ImageResourceFactory eINSTANCE = net.jeeeyul.pdetools.icg.model.imageResource.impl.ImageResourceFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Palette</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Palette</em>'.
   * @generated
   */
  Palette createPalette();

  /**
   * Returns a new object of class '<em>Image File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Image File</em>'.
   * @generated
   */
  ImageFile createImageFile();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ImageResourcePackage getImageResourcePackage();

} //ImageResourceFactory
