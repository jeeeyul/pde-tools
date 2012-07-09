/**
 */
package net.jeeeyul.pdetools.icg.builder.model.palette.util;

import net.jeeeyul.pdetools.icg.builder.model.palette.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.icg.builder.model.palette.PalettePackage
 * @generated
 */
public class PaletteAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PalettePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PaletteAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PalettePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PaletteSwitch<Adapter> modelSwitch =
    new PaletteSwitch<Adapter>()
    {
      @Override
      public Adapter caseFieldNameOwner(FieldNameOwner object)
      {
        return createFieldNameOwnerAdapter();
      }
      @Override
      public Adapter casePalette(Palette object)
      {
        return createPaletteAdapter();
      }
      @Override
      public Adapter caseImageFile(ImageFile object)
      {
        return createImageFileAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner <em>Field Name Owner</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner
   * @generated
   */
  public Adapter createFieldNameOwnerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.icg.builder.model.palette.Palette <em>Palette</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.Palette
   * @generated
   */
  public Adapter createPaletteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile <em>Image File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile
   * @generated
   */
  public Adapter createImageFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //PaletteAdapterFactory
