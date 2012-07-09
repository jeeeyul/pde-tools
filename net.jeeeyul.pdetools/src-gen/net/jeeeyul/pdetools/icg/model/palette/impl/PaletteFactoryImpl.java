/**
 */
package net.jeeeyul.pdetools.icg.model.palette.impl;

import net.jeeeyul.pdetools.icg.model.palette.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class PaletteFactoryImpl extends EFactoryImpl implements PaletteFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PaletteFactory init()
  {
    try
    {
      PaletteFactory thePaletteFactory = (PaletteFactory)EPackage.Registry.INSTANCE.getEFactory("http://jeeeyul.net/pde-tools/icg/palette"); 
      if (thePaletteFactory != null)
      {
        return thePaletteFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PaletteFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PaletteFactoryImpl()
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
      case PalettePackage.PALETTE: return createPalette();
      case PalettePackage.IMAGE_FILE: return createImageFile();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case PalettePackage.FILE:
        return createFileFromString(eDataType, initialValue);
      case PalettePackage.FOLDER:
        return createFolderFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case PalettePackage.FILE:
        return convertFileToString(eDataType, instanceValue);
      case PalettePackage.FOLDER:
        return convertFolderToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Palette createPalette()
  {
    PaletteImpl palette = new PaletteImpl();
    return palette;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImageFile createImageFile()
  {
    ImageFileImpl imageFile = new ImageFileImpl();
    return imageFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IFile createFile(String it)
  {
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    IWorkspaceRoot _root = _workspace.getRoot();
    Path _path = new Path(it);
    IFile _file = _root.getFile(_path);
    return _file;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IFile createFileFromString(EDataType eDataType, String initialValue)
  {
    return createFile(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFile(IFile it)
  {
    IPath _fullPath = it.getFullPath();
    String _portableString = _fullPath.toPortableString();
    return _portableString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFileToString(EDataType eDataType, Object instanceValue)
  {
    return convertFile((IFile)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IFolder createFolder(String it)
  {
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    IWorkspaceRoot _root = _workspace.getRoot();
    Path _path = new Path(it);
    IFolder _folder = _root.getFolder(_path);
    return _folder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IFolder createFolderFromString(EDataType eDataType, String initialValue)
  {
    return createFolder(initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFolder(IFolder it)
  {
    IPath _fullPath = it.getFullPath();
    String _portableString = _fullPath.toPortableString();
    return _portableString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertFolderToString(EDataType eDataType, Object instanceValue)
  {
    return convertFolder((IFolder)instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PalettePackage getPalettePackage()
  {
    return (PalettePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PalettePackage getPackage()
  {
    return PalettePackage.eINSTANCE;
  }

} //PaletteFactoryImpl
