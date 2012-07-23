/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot.impl;

import java.io.File;
import java.util.Date;

import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotEntryImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotEntryImpl#getTakenTime <em>Taken Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotEntryImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotEntryImpl#getAbsoulteFilePath <em>Absoulte File Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SnapshotEntryImpl extends MinimalEObjectImpl.Container implements SnapshotEntry
{
  /**
   * The default value of the '{@link #getTakenTime() <em>Taken Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTakenTime()
   * @generated
   * @ordered
   */
  protected static final Date TAKEN_TIME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTakenTime() <em>Taken Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTakenTime()
   * @generated
   * @ordered
   */
  protected Date takenTime = TAKEN_TIME_EDEFAULT;

  /**
   * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFileName()
   * @generated
   * @ordered
   */
  protected static final String FILE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFileName()
   * @generated
   * @ordered
   */
  protected String fileName = FILE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getAbsoulteFilePath() <em>Absoulte File Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbsoulteFilePath()
   * @generated
   * @ordered
   */
  protected static final String ABSOULTE_FILE_PATH_EDEFAULT = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SnapshotEntryImpl()
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
    return SnapshotPackage.Literals.SNAPSHOT_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnapshotGroup getParent()
  {
    if (eContainerFeatureID() != SnapshotPackage.SNAPSHOT_ENTRY__PARENT) return null;
    return (SnapshotGroup)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(SnapshotGroup newParent, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParent, SnapshotPackage.SNAPSHOT_ENTRY__PARENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(SnapshotGroup newParent)
  {
    if (newParent != eInternalContainer() || (eContainerFeatureID() != SnapshotPackage.SNAPSHOT_ENTRY__PARENT && newParent != null))
    {
      if (EcoreUtil.isAncestor(this, newParent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, SnapshotPackage.SNAPSHOT_GROUP__ENTRIES, SnapshotGroup.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_ENTRY__PARENT, newParent, newParent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Date getTakenTime()
  {
    return takenTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTakenTime(Date newTakenTime)
  {
    Date oldTakenTime = takenTime;
    takenTime = newTakenTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_ENTRY__TAKEN_TIME, oldTakenTime, takenTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFileName()
  {
    return fileName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFileName(String newFileName)
  {
    String oldFileName = fileName;
    fileName = newFileName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_ENTRY__FILE_NAME, oldFileName, fileName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAbsoulteFilePath()
  {
    SnapshotGroup _parent = this.getParent();
    SnapshotRepository _parent_1 = _parent.getParent();
    String _repositoryLocation = _parent_1.getRepositoryLocation();
    Path _path = new Path(_repositoryLocation);
    IPath _removeLastSegments = _path.removeLastSegments(1);
    IPath base = _removeLastSegments.setDevice(null);
    String _fileName = this.getFileName();
    IPath filePath = base.append(_fileName);
    File _file = filePath.toFile();
    return _file.getAbsolutePath();
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
      case SnapshotPackage.SNAPSHOT_ENTRY__PARENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParent((SnapshotGroup)otherEnd, msgs);
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
      case SnapshotPackage.SNAPSHOT_ENTRY__PARENT:
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
      case SnapshotPackage.SNAPSHOT_ENTRY__PARENT:
        return eInternalContainer().eInverseRemove(this, SnapshotPackage.SNAPSHOT_GROUP__ENTRIES, SnapshotGroup.class, msgs);
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
      case SnapshotPackage.SNAPSHOT_ENTRY__PARENT:
        return getParent();
      case SnapshotPackage.SNAPSHOT_ENTRY__TAKEN_TIME:
        return getTakenTime();
      case SnapshotPackage.SNAPSHOT_ENTRY__FILE_NAME:
        return getFileName();
      case SnapshotPackage.SNAPSHOT_ENTRY__ABSOULTE_FILE_PATH:
        return getAbsoulteFilePath();
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
      case SnapshotPackage.SNAPSHOT_ENTRY__PARENT:
        setParent((SnapshotGroup)newValue);
        return;
      case SnapshotPackage.SNAPSHOT_ENTRY__TAKEN_TIME:
        setTakenTime((Date)newValue);
        return;
      case SnapshotPackage.SNAPSHOT_ENTRY__FILE_NAME:
        setFileName((String)newValue);
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
      case SnapshotPackage.SNAPSHOT_ENTRY__PARENT:
        setParent((SnapshotGroup)null);
        return;
      case SnapshotPackage.SNAPSHOT_ENTRY__TAKEN_TIME:
        setTakenTime(TAKEN_TIME_EDEFAULT);
        return;
      case SnapshotPackage.SNAPSHOT_ENTRY__FILE_NAME:
        setFileName(FILE_NAME_EDEFAULT);
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
      case SnapshotPackage.SNAPSHOT_ENTRY__PARENT:
        return getParent() != null;
      case SnapshotPackage.SNAPSHOT_ENTRY__TAKEN_TIME:
        return TAKEN_TIME_EDEFAULT == null ? takenTime != null : !TAKEN_TIME_EDEFAULT.equals(takenTime);
      case SnapshotPackage.SNAPSHOT_ENTRY__FILE_NAME:
        return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
      case SnapshotPackage.SNAPSHOT_ENTRY__ABSOULTE_FILE_PATH:
        return ABSOULTE_FILE_PATH_EDEFAULT == null ? getAbsoulteFilePath() != null : !ABSOULTE_FILE_PATH_EDEFAULT.equals(getAbsoulteFilePath());
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
    result.append(" (takenTime: ");
    result.append(takenTime);
    result.append(", fileName: ");
    result.append(fileName);
    result.append(')');
    return result.toString();
  }

} //SnapshotEntryImpl
