/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard.impl;

import net.jeeeyul.pdetools.clipboard.model.clipboard.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClipboardFactoryImpl extends EFactoryImpl implements ClipboardFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ClipboardFactory init()
  {
    try
    {
      ClipboardFactory theClipboardFactory = (ClipboardFactory)EPackage.Registry.INSTANCE.getEFactory("clipboard"); 
      if (theClipboardFactory != null)
      {
        return theClipboardFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ClipboardFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClipboardFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ClipboardPackage.CLIP_HISTORY: return createClipHistory();
      case ClipboardPackage.CLIPBOARD_ENTRY: return createClipboardEntry();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClipHistory createClipHistory()
  {
    ClipHistoryImpl clipHistory = new ClipHistoryImpl();
    return clipHistory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClipboardEntry createClipboardEntry()
  {
    ClipboardEntryImpl clipboardEntry = new ClipboardEntryImpl();
    return clipboardEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClipboardPackage getClipboardPackage()
  {
    return (ClipboardPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ClipboardPackage getPackage()
  {
    return ClipboardPackage.eINSTANCE;
  }

} //ClipboardFactoryImpl
