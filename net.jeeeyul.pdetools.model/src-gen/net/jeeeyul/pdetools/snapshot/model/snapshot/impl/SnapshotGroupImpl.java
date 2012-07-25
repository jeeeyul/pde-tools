/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot.impl;

import java.util.Collection;
import java.util.Date;

import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotEntry;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotGroup;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotRepository;

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
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotGroupImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotGroupImpl#getDate <em>Date</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotGroupImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SnapshotGroupImpl extends MinimalEObjectImpl.Container implements SnapshotGroup
{
  /**
   * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDate()
   * @generated
   * @ordered
   */
  protected static final Date DATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDate()
   * @generated
   * @ordered
   */
  protected Date date = DATE_EDEFAULT;

  /**
   * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntries()
   * @generated
   * @ordered
   */
  protected EList<SnapshotEntry> entries;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SnapshotGroupImpl()
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
    return SnapshotPackage.Literals.SNAPSHOT_GROUP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SnapshotRepository getParent()
  {
    if (eContainerFeatureID() != SnapshotPackage.SNAPSHOT_GROUP__PARENT) return null;
    return (SnapshotRepository)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(SnapshotRepository newParent, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParent, SnapshotPackage.SNAPSHOT_GROUP__PARENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(SnapshotRepository newParent)
  {
    if (newParent != eInternalContainer() || (eContainerFeatureID() != SnapshotPackage.SNAPSHOT_GROUP__PARENT && newParent != null))
    {
      if (EcoreUtil.isAncestor(this, newParent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, SnapshotPackage.SNAPSHOT_REPOSITORY__GROUPS, SnapshotRepository.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_GROUP__PARENT, newParent, newParent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Date getDate()
  {
    return date;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDate(Date newDate)
  {
    Date oldDate = date;
    date = newDate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_GROUP__DATE, oldDate, date));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SnapshotEntry> getEntries()
  {
    if (entries == null)
    {
      entries = new EObjectContainmentWithInverseEList<SnapshotEntry>(SnapshotEntry.class, this, SnapshotPackage.SNAPSHOT_GROUP__ENTRIES, SnapshotPackage.SNAPSHOT_ENTRY__PARENT);
    }
    return entries;
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
      case SnapshotPackage.SNAPSHOT_GROUP__PARENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParent((SnapshotRepository)otherEnd, msgs);
      case SnapshotPackage.SNAPSHOT_GROUP__ENTRIES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getEntries()).basicAdd(otherEnd, msgs);
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
      case SnapshotPackage.SNAPSHOT_GROUP__PARENT:
        return basicSetParent(null, msgs);
      case SnapshotPackage.SNAPSHOT_GROUP__ENTRIES:
        return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
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
      case SnapshotPackage.SNAPSHOT_GROUP__PARENT:
        return eInternalContainer().eInverseRemove(this, SnapshotPackage.SNAPSHOT_REPOSITORY__GROUPS, SnapshotRepository.class, msgs);
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
      case SnapshotPackage.SNAPSHOT_GROUP__PARENT:
        return getParent();
      case SnapshotPackage.SNAPSHOT_GROUP__DATE:
        return getDate();
      case SnapshotPackage.SNAPSHOT_GROUP__ENTRIES:
        return getEntries();
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
      case SnapshotPackage.SNAPSHOT_GROUP__PARENT:
        setParent((SnapshotRepository)newValue);
        return;
      case SnapshotPackage.SNAPSHOT_GROUP__DATE:
        setDate((Date)newValue);
        return;
      case SnapshotPackage.SNAPSHOT_GROUP__ENTRIES:
        getEntries().clear();
        getEntries().addAll((Collection<? extends SnapshotEntry>)newValue);
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
      case SnapshotPackage.SNAPSHOT_GROUP__PARENT:
        setParent((SnapshotRepository)null);
        return;
      case SnapshotPackage.SNAPSHOT_GROUP__DATE:
        setDate(DATE_EDEFAULT);
        return;
      case SnapshotPackage.SNAPSHOT_GROUP__ENTRIES:
        getEntries().clear();
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
      case SnapshotPackage.SNAPSHOT_GROUP__PARENT:
        return getParent() != null;
      case SnapshotPackage.SNAPSHOT_GROUP__DATE:
        return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
      case SnapshotPackage.SNAPSHOT_GROUP__ENTRIES:
        return entries != null && !entries.isEmpty();
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
    result.append(" (date: ");
    result.append(date);
    result.append(')');
    return result.toString();
  }

} //SnapshotGroupImpl
