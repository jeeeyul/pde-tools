/**
 */
package net.jeeeyul.pdetools.icg.builder.model.palette.impl;

import net.jeeeyul.pdetools.icg.builder.model.palette.ImageFile;
import net.jeeeyul.pdetools.icg.builder.model.palette.Palette;
import net.jeeeyul.pdetools.icg.builder.model.palette.PalettePackage;

import org.eclipse.core.resources.IFile;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.icg.builder.model.palette.impl.ImageFileImpl#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.icg.builder.model.palette.impl.ImageFileImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.icg.builder.model.palette.impl.ImageFileImpl#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImageFileImpl extends MinimalEObjectImpl.Container implements ImageFile
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
   * The default value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected static final IFile FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected IFile file = FILE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImageFileImpl()
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
    return PalettePackage.Literals.IMAGE_FILE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, PalettePackage.IMAGE_FILE__FIELD_NAME, oldFieldName, fieldName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Palette getParent()
  {
    if (eContainerFeatureID() != PalettePackage.IMAGE_FILE__PARENT) return null;
    return (Palette)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(Palette newParent, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParent, PalettePackage.IMAGE_FILE__PARENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(Palette newParent)
  {
    if (newParent != eInternalContainer() || (eContainerFeatureID() != PalettePackage.IMAGE_FILE__PARENT && newParent != null))
    {
      if (EcoreUtil.isAncestor(this, newParent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, PalettePackage.PALETTE__IMAGE_FILES, Palette.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PalettePackage.IMAGE_FILE__PARENT, newParent, newParent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IFile getFile()
  {
    return file;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFile(IFile newFile)
  {
    IFile oldFile = file;
    file = newFile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PalettePackage.IMAGE_FILE__FILE, oldFile, file));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PalettePackage.IMAGE_FILE__PARENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParent((Palette)otherEnd, msgs);
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
      case PalettePackage.IMAGE_FILE__PARENT:
        return basicSetParent(null, msgs);
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
      case PalettePackage.IMAGE_FILE__PARENT:
        return eInternalContainer().eInverseRemove(this, PalettePackage.PALETTE__IMAGE_FILES, Palette.class, msgs);
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
      case PalettePackage.IMAGE_FILE__FIELD_NAME:
        return getFieldName();
      case PalettePackage.IMAGE_FILE__PARENT:
        return getParent();
      case PalettePackage.IMAGE_FILE__FILE:
        return getFile();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PalettePackage.IMAGE_FILE__FIELD_NAME:
        setFieldName((String)newValue);
        return;
      case PalettePackage.IMAGE_FILE__PARENT:
        setParent((Palette)newValue);
        return;
      case PalettePackage.IMAGE_FILE__FILE:
        setFile((IFile)newValue);
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
      case PalettePackage.IMAGE_FILE__FIELD_NAME:
        setFieldName(FIELD_NAME_EDEFAULT);
        return;
      case PalettePackage.IMAGE_FILE__PARENT:
        setParent((Palette)null);
        return;
      case PalettePackage.IMAGE_FILE__FILE:
        setFile(FILE_EDEFAULT);
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
      case PalettePackage.IMAGE_FILE__FIELD_NAME:
        return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
      case PalettePackage.IMAGE_FILE__PARENT:
        return getParent() != null;
      case PalettePackage.IMAGE_FILE__FILE:
        return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
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
    result.append(", file: ");
    result.append(file);
    result.append(')');
    return result.toString();
  }

} //ImageFileImpl
