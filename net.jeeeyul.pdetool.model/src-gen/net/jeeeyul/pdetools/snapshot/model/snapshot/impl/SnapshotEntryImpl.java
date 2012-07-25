/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot.impl;

import java.io.File;

import java.util.Date;

import net.jeeeyul.pdetools.snapshot.model.snapshot.ShellInfo;
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
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotEntryImpl#getOriginalFile <em>Original File</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotEntryImpl#getRenderedFile <em>Rendered File</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotEntryImpl#getControlType <em>Control Type</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotEntryImpl#getShellInfo <em>Shell Info</em>}</li>
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
   * The default value of the '{@link #getOriginalFile() <em>Original File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOriginalFile()
   * @generated
   * @ordered
   */
  protected static final String ORIGINAL_FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOriginalFile() <em>Original File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOriginalFile()
   * @generated
   * @ordered
   */
  protected String originalFile = ORIGINAL_FILE_EDEFAULT;

  /**
   * The default value of the '{@link #getRenderedFile() <em>Rendered File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRenderedFile()
   * @generated
   * @ordered
   */
  protected static final String RENDERED_FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRenderedFile() <em>Rendered File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRenderedFile()
   * @generated
   * @ordered
   */
  protected String renderedFile = RENDERED_FILE_EDEFAULT;

  /**
   * The default value of the '{@link #getControlType() <em>Control Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getControlType()
   * @generated
   * @ordered
   */
  protected static final String CONTROL_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getControlType() <em>Control Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getControlType()
   * @generated
   * @ordered
   */
  protected String controlType = CONTROL_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getShellInfo() <em>Shell Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShellInfo()
   * @generated
   * @ordered
   */
  protected ShellInfo shellInfo;

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
  public String getOriginalFile()
  {
    return originalFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOriginalFile(String newOriginalFile)
  {
    String oldOriginalFile = originalFile;
    originalFile = newOriginalFile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_ENTRY__ORIGINAL_FILE, oldOriginalFile, originalFile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRenderedFile()
  {
    return renderedFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRenderedFile(String newRenderedFile)
  {
    String oldRenderedFile = renderedFile;
    renderedFile = newRenderedFile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_ENTRY__RENDERED_FILE, oldRenderedFile, renderedFile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getControlType()
  {
    return controlType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setControlType(String newControlType)
  {
    String oldControlType = controlType;
    controlType = newControlType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_ENTRY__CONTROL_TYPE, oldControlType, controlType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShellInfo getShellInfo()
  {
    return shellInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetShellInfo(ShellInfo newShellInfo, NotificationChain msgs)
  {
    ShellInfo oldShellInfo = shellInfo;
    shellInfo = newShellInfo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_ENTRY__SHELL_INFO, oldShellInfo, newShellInfo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShellInfo(ShellInfo newShellInfo)
  {
    if (newShellInfo != shellInfo)
    {
      NotificationChain msgs = null;
      if (shellInfo != null)
        msgs = ((InternalEObject)shellInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SnapshotPackage.SNAPSHOT_ENTRY__SHELL_INFO, null, msgs);
      if (newShellInfo != null)
        msgs = ((InternalEObject)newShellInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SnapshotPackage.SNAPSHOT_ENTRY__SHELL_INFO, null, msgs);
      msgs = basicSetShellInfo(newShellInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_ENTRY__SHELL_INFO, newShellInfo, newShellInfo));
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
    String _originalFile = this.getOriginalFile();
    IPath filePath = base.append(_originalFile);
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
      case SnapshotPackage.SNAPSHOT_ENTRY__SHELL_INFO:
        return basicSetShellInfo(null, msgs);
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
      case SnapshotPackage.SNAPSHOT_ENTRY__ORIGINAL_FILE:
        return getOriginalFile();
      case SnapshotPackage.SNAPSHOT_ENTRY__RENDERED_FILE:
        return getRenderedFile();
      case SnapshotPackage.SNAPSHOT_ENTRY__CONTROL_TYPE:
        return getControlType();
      case SnapshotPackage.SNAPSHOT_ENTRY__SHELL_INFO:
        return getShellInfo();
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
      case SnapshotPackage.SNAPSHOT_ENTRY__ORIGINAL_FILE:
        setOriginalFile((String)newValue);
        return;
      case SnapshotPackage.SNAPSHOT_ENTRY__RENDERED_FILE:
        setRenderedFile((String)newValue);
        return;
      case SnapshotPackage.SNAPSHOT_ENTRY__CONTROL_TYPE:
        setControlType((String)newValue);
        return;
      case SnapshotPackage.SNAPSHOT_ENTRY__SHELL_INFO:
        setShellInfo((ShellInfo)newValue);
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
      case SnapshotPackage.SNAPSHOT_ENTRY__ORIGINAL_FILE:
        setOriginalFile(ORIGINAL_FILE_EDEFAULT);
        return;
      case SnapshotPackage.SNAPSHOT_ENTRY__RENDERED_FILE:
        setRenderedFile(RENDERED_FILE_EDEFAULT);
        return;
      case SnapshotPackage.SNAPSHOT_ENTRY__CONTROL_TYPE:
        setControlType(CONTROL_TYPE_EDEFAULT);
        return;
      case SnapshotPackage.SNAPSHOT_ENTRY__SHELL_INFO:
        setShellInfo((ShellInfo)null);
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
      case SnapshotPackage.SNAPSHOT_ENTRY__ORIGINAL_FILE:
        return ORIGINAL_FILE_EDEFAULT == null ? originalFile != null : !ORIGINAL_FILE_EDEFAULT.equals(originalFile);
      case SnapshotPackage.SNAPSHOT_ENTRY__RENDERED_FILE:
        return RENDERED_FILE_EDEFAULT == null ? renderedFile != null : !RENDERED_FILE_EDEFAULT.equals(renderedFile);
      case SnapshotPackage.SNAPSHOT_ENTRY__CONTROL_TYPE:
        return CONTROL_TYPE_EDEFAULT == null ? controlType != null : !CONTROL_TYPE_EDEFAULT.equals(controlType);
      case SnapshotPackage.SNAPSHOT_ENTRY__SHELL_INFO:
        return shellInfo != null;
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
    result.append(", originalFile: ");
    result.append(originalFile);
    result.append(", renderedFile: ");
    result.append(renderedFile);
    result.append(", controlType: ");
    result.append(controlType);
    result.append(')');
    return result.toString();
  }

} //SnapshotEntryImpl
