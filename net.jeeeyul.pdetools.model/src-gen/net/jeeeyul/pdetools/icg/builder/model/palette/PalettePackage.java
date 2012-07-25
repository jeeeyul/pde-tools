/**
 */
package net.jeeeyul.pdetools.icg.builder.model.palette;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.icg.builder.model.palette.PaletteFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='net.jeeeyul.pdetools.icg.builder.model'"
 * @generated
 */
public interface PalettePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "palette";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://jeeeyul.net/pde-tools/icg/palette";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "p";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PalettePackage eINSTANCE = net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl.init();

  /**
   * The meta object id for the '{@link net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner <em>Field Name Owner</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl#getFieldNameOwner()
   * @generated
   */
  int FIELD_NAME_OWNER = 0;

  /**
   * The feature id for the '<em><b>Field Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_NAME_OWNER__FIELD_NAME = 0;

  /**
   * The number of structural features of the '<em>Field Name Owner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_NAME_OWNER_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Field Name Owner</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_NAME_OWNER_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link net.jeeeyul.pdetools.icg.builder.model.palette.impl.PaletteImpl <em>Palette</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PaletteImpl
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl#getPalette()
   * @generated
   */
  int PALETTE = 1;

  /**
   * The feature id for the '<em><b>Field Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PALETTE__FIELD_NAME = FIELD_NAME_OWNER__FIELD_NAME;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PALETTE__PARENT = FIELD_NAME_OWNER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Folder</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PALETTE__FOLDER = FIELD_NAME_OWNER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Sub Palettes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PALETTE__SUB_PALETTES = FIELD_NAME_OWNER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Image Files</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PALETTE__IMAGE_FILES = FIELD_NAME_OWNER_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Palette</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PALETTE_FEATURE_COUNT = FIELD_NAME_OWNER_FEATURE_COUNT + 4;

  /**
   * The number of operations of the '<em>Palette</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PALETTE_OPERATION_COUNT = FIELD_NAME_OWNER_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link net.jeeeyul.pdetools.icg.builder.model.palette.impl.ImageFileImpl <em>Image File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.ImageFileImpl
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl#getImageFile()
   * @generated
   */
  int IMAGE_FILE = 2;

  /**
   * The feature id for the '<em><b>Field Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_FILE__FIELD_NAME = FIELD_NAME_OWNER__FIELD_NAME;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_FILE__PARENT = FIELD_NAME_OWNER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_FILE__FILE = FIELD_NAME_OWNER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Image File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_FILE_FEATURE_COUNT = FIELD_NAME_OWNER_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Image File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_FILE_OPERATION_COUNT = FIELD_NAME_OWNER_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '<em>File</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.core.resources.IFile
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl#getFile()
   * @generated
   */
  int FILE = 3;

  /**
   * The meta object id for the '<em>Folder</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.core.resources.IFolder
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl#getFolder()
   * @generated
   */
  int FOLDER = 4;


  /**
   * Returns the meta object for class '{@link net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner <em>Field Name Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Name Owner</em>'.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner
   * @generated
   */
  EClass getFieldNameOwner();

  /**
   * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner#getFieldName <em>Field Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Field Name</em>'.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner#getFieldName()
   * @see #getFieldNameOwner()
   * @generated
   */
  EAttribute getFieldNameOwner_FieldName();

  /**
   * Returns the meta object for class '{@link net.jeeeyul.pdetools.icg.builder.model.palette.Palette <em>Palette</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Palette</em>'.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.Palette
   * @generated
   */
  EClass getPalette();

  /**
   * Returns the meta object for the container reference '{@link net.jeeeyul.pdetools.icg.builder.model.palette.Palette#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parent</em>'.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.Palette#getParent()
   * @see #getPalette()
   * @generated
   */
  EReference getPalette_Parent();

  /**
   * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.icg.builder.model.palette.Palette#getFolder <em>Folder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Folder</em>'.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.Palette#getFolder()
   * @see #getPalette()
   * @generated
   */
  EAttribute getPalette_Folder();

  /**
   * Returns the meta object for the containment reference list '{@link net.jeeeyul.pdetools.icg.builder.model.palette.Palette#getSubPalettes <em>Sub Palettes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub Palettes</em>'.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.Palette#getSubPalettes()
   * @see #getPalette()
   * @generated
   */
  EReference getPalette_SubPalettes();

  /**
   * Returns the meta object for the containment reference list '{@link net.jeeeyul.pdetools.icg.builder.model.palette.Palette#getImageFiles <em>Image Files</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Image Files</em>'.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.Palette#getImageFiles()
   * @see #getPalette()
   * @generated
   */
  EReference getPalette_ImageFiles();

  /**
   * Returns the meta object for class '{@link net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile <em>Image File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Image File</em>'.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile
   * @generated
   */
  EClass getImageFile();

  /**
   * Returns the meta object for the container reference '{@link net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parent</em>'.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile#getParent()
   * @see #getImageFile()
   * @generated
   */
  EReference getImageFile_Parent();

  /**
   * Returns the meta object for the attribute '{@link net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile#getFile()
   * @see #getImageFile()
   * @generated
   */
  EAttribute getImageFile_File();

  /**
   * Returns the meta object for data type '{@link org.eclipse.core.resources.IFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>File</em>'.
   * @see org.eclipse.core.resources.IFile
   * @model instanceClass="org.eclipse.core.resources.IFile"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel create='<%org.eclipse.core.resources.IWorkspace%> _workspace = <%org.eclipse.core.resources.ResourcesPlugin%>.getWorkspace();\n<%org.eclipse.core.resources.IWorkspaceRoot%> _root = _workspace.getRoot();\n<%org.eclipse.core.runtime.Path%> _path = new <%org.eclipse.core.runtime.Path%>(it);\n<%org.eclipse.core.resources.IFile%> _file = _root.getFile(_path);\nreturn _file;' convert='<%org.eclipse.core.runtime.IPath%> _fullPath = it.getFullPath();\n<%java.lang.String%> _portableString = _fullPath.toPortableString();\nreturn _portableString;'"
   * @generated
   */
  EDataType getFile();

  /**
   * Returns the meta object for data type '{@link org.eclipse.core.resources.IFolder <em>Folder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Folder</em>'.
   * @see org.eclipse.core.resources.IFolder
   * @model instanceClass="org.eclipse.core.resources.IFolder"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel create='<%org.eclipse.core.resources.IWorkspace%> _workspace = <%org.eclipse.core.resources.ResourcesPlugin%>.getWorkspace();\n<%org.eclipse.core.resources.IWorkspaceRoot%> _root = _workspace.getRoot();\n<%org.eclipse.core.runtime.Path%> _path = new <%org.eclipse.core.runtime.Path%>(it);\n<%org.eclipse.core.resources.IFolder%> _folder = _root.getFolder(_path);\nreturn _folder;' convert='<%org.eclipse.core.runtime.IPath%> _fullPath = it.getFullPath();\n<%java.lang.String%> _portableString = _fullPath.toPortableString();\nreturn _portableString;'"
   * @generated
   */
  EDataType getFolder();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PaletteFactory getPaletteFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner <em>Field Name Owner</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see net.jeeeyul.pdetools.icg.builder.model.palette.FieldNameOwner
     * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl#getFieldNameOwner()
     * @generated
     */
    EClass FIELD_NAME_OWNER = eINSTANCE.getFieldNameOwner();

    /**
     * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_NAME_OWNER__FIELD_NAME = eINSTANCE.getFieldNameOwner_FieldName();

    /**
     * The meta object literal for the '{@link net.jeeeyul.pdetools.icg.builder.model.palette.impl.PaletteImpl <em>Palette</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PaletteImpl
     * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl#getPalette()
     * @generated
     */
    EClass PALETTE = eINSTANCE.getPalette();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PALETTE__PARENT = eINSTANCE.getPalette_Parent();

    /**
     * The meta object literal for the '<em><b>Folder</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PALETTE__FOLDER = eINSTANCE.getPalette_Folder();

    /**
     * The meta object literal for the '<em><b>Sub Palettes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PALETTE__SUB_PALETTES = eINSTANCE.getPalette_SubPalettes();

    /**
     * The meta object literal for the '<em><b>Image Files</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PALETTE__IMAGE_FILES = eINSTANCE.getPalette_ImageFiles();

    /**
     * The meta object literal for the '{@link net.jeeeyul.pdetools.icg.builder.model.palette.impl.ImageFileImpl <em>Image File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.ImageFileImpl
     * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl#getImageFile()
     * @generated
     */
    EClass IMAGE_FILE = eINSTANCE.getImageFile();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IMAGE_FILE__PARENT = eINSTANCE.getImageFile_Parent();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMAGE_FILE__FILE = eINSTANCE.getImageFile_File();

    /**
     * The meta object literal for the '<em>File</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.core.resources.IFile
     * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl#getFile()
     * @generated
     */
    EDataType FILE = eINSTANCE.getFile();

    /**
     * The meta object literal for the '<em>Folder</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.core.resources.IFolder
     * @see net.jeeeyul.pdetools.icg.builder.model.palette.impl.PalettePackageImpl#getFolder()
     * @generated
     */
    EDataType FOLDER = eINSTANCE.getFolder();

  }

} //PalettePackage
