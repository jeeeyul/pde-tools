/**
 */
package net.jeeeyul.pdetools.icg.model.palette.impl;

import java.util.Collection;

import net.jeeeyul.pdetools.icg.model.palette.ImageFile;
import net.jeeeyul.pdetools.icg.model.palette.Palette;
import net.jeeeyul.pdetools.icg.model.palette.PalettePackage;

import org.eclipse.core.resources.IFolder;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Palette</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.icg.model.palette.impl.PaletteImpl#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.icg.model.palette.impl.PaletteImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.icg.model.palette.impl.PaletteImpl#getFolder <em>Folder</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.icg.model.palette.impl.PaletteImpl#getSubPalettes <em>Sub Palettes</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.icg.model.palette.impl.PaletteImpl#getImageFiles <em>Image Files</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PaletteImpl extends MinimalEObjectImpl.Container implements Palette
{
  /**
   * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldName()
   * @generated
   * @ordered
   */
  protected static final String FIELD_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldName()
   * @generated
   * @ordered
   */
  protected String fieldName = FIELD_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getFolder() <em>Folder</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFolder()
   * @generated
   * @ordered
   */
  protected static final IFolder FOLDER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFolder() <em>Folder</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFolder()
   * @generated
   * @ordered
   */
  protected IFolder folder = FOLDER_EDEFAULT;

  /**
   * The cached value of the '{@link #getSubPalettes() <em>Sub Palettes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubPalettes()
   * @generated
   * @ordered
   */
  protected EList<Palette> subPalettes;

  /**
   * The cached value of the '{@link #getImageFiles() <em>Image Files</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImageFiles()
   * @generated
   * @ordered
   */
  protected EList<ImageFile> imageFiles;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PaletteImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PalettePackage.Literals.PALETTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFieldName()
  {
    return fieldName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldName(String newFieldName)
  {
    String oldFieldName = fieldName;
    fieldName = newFieldName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PalettePackage.PALETTE__FIELD_NAME, oldFieldName, fieldName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Palette getParent()
  {
    if (eContainerFeatureID() != PalettePackage.PALETTE__PARENT) return null;
    return (Palette)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(Palette newParent, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParent, PalettePackage.PALETTE__PARENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(Palette newParent)
  {
    if (newParent != eInternalContainer() || (eContainerFeatureID() != PalettePackage.PALETTE__PARENT && newParent != null))
    {
      if (EcoreUtil.isAncestor(this, newParent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, PalettePackage.PALETTE__SUB_PALETTES, Palette.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PalettePackage.PALETTE__PARENT, newParent, newParent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IFolder getFolder()
  {
    return folder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFolder(IFolder newFolder)
  {
    IFolder oldFolder = folder;
    folder = newFolder;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PalettePackage.PALETTE__FOLDER, oldFolder, folder));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Palette> getSubPalettes()
  {
    if (subPalettes == null)
    {
      subPalettes = new EObjectContainmentWithInverseEList<Palette>(Palette.class, this, PalettePackage.PALETTE__SUB_PALETTES, PalettePackage.PALETTE__PARENT);
    }
    return subPalettes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ImageFile> getImageFiles()
  {
    if (imageFiles == null)
    {
      imageFiles = new EObjectContainmentWithInverseEList<ImageFile>(ImageFile.class, this, PalettePackage.PALETTE__IMAGE_FILES, PalettePackage.IMAGE_FILE__PARENT);
    }
    return imageFiles;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PalettePackage.PALETTE__PARENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParent((Palette)otherEnd, msgs);
      case PalettePackage.PALETTE__SUB_PALETTES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubPalettes()).basicAdd(otherEnd, msgs);
      case PalettePackage.PALETTE__IMAGE_FILES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getImageFiles()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PalettePackage.PALETTE__PARENT:
        return basicSetParent(null, msgs);
      case PalettePackage.PALETTE__SUB_PALETTES:
        return ((InternalEList<?>)getSubPalettes()).basicRemove(otherEnd, msgs);
      case PalettePackage.PALETTE__IMAGE_FILES:
        return ((InternalEList<?>)getImageFiles()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case PalettePackage.PALETTE__PARENT:
        return eInternalContainer().eInverseRemove(this, PalettePackage.PALETTE__SUB_PALETTES, Palette.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PalettePackage.PALETTE__FIELD_NAME:
        return getFieldName();
      case PalettePackage.PALETTE__PARENT:
        return getParent();
      case PalettePackage.PALETTE__FOLDER:
        return getFolder();
      case PalettePackage.PALETTE__SUB_PALETTES:
        return getSubPalettes();
      case PalettePackage.PALETTE__IMAGE_FILES:
        return getImageFiles();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PalettePackage.PALETTE__FIELD_NAME:
        setFieldName((String)newValue);
        return;
      case PalettePackage.PALETTE__PARENT:
        setParent((Palette)newValue);
        return;
      case PalettePackage.PALETTE__FOLDER:
        setFolder((IFolder)newValue);
        return;
      case PalettePackage.PALETTE__SUB_PALETTES:
        getSubPalettes().clear();
        getSubPalettes().addAll((Collection<? extends Palette>)newValue);
        return;
      case PalettePackage.PALETTE__IMAGE_FILES:
        getImageFiles().clear();
        getImageFiles().addAll((Collection<? extends ImageFile>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PalettePackage.PALETTE__FIELD_NAME:
        setFieldName(FIELD_NAME_EDEFAULT);
        return;
      case PalettePackage.PALETTE__PARENT:
        setParent((Palette)null);
        return;
      case PalettePackage.PALETTE__FOLDER:
        setFolder(FOLDER_EDEFAULT);
        return;
      case PalettePackage.PALETTE__SUB_PALETTES:
        getSubPalettes().clear();
        return;
      case PalettePackage.PALETTE__IMAGE_FILES:
        getImageFiles().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PalettePackage.PALETTE__FIELD_NAME:
        return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
      case PalettePackage.PALETTE__PARENT:
        return getParent() != null;
      case PalettePackage.PALETTE__FOLDER:
        return FOLDER_EDEFAULT == null ? folder != null : !FOLDER_EDEFAULT.equals(folder);
      case PalettePackage.PALETTE__SUB_PALETTES:
        return subPalettes != null && !subPalettes.isEmpty();
      case PalettePackage.PALETTE__IMAGE_FILES:
        return imageFiles != null && !imageFiles.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (fieldName: ");
    result.append(fieldName);
    result.append(", folder: ");
    result.append(folder);
    result.append(')');
    return result.toString();
  }

} //PaletteImpl
