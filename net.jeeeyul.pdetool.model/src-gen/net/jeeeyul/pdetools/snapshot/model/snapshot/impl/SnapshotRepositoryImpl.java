/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot.impl;

import java.util.Collection;

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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotRepositoryImpl#getRepositoryLocation <em>Repository Location</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.SnapshotRepositoryImpl#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SnapshotRepositoryImpl extends MinimalEObjectImpl.Container implements SnapshotRepository
{
  /**
   * The default value of the '{@link #getRepositoryLocation() <em>Repository Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepositoryLocation()
   * @generated
   * @ordered
   */
  protected static final String REPOSITORY_LOCATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRepositoryLocation() <em>Repository Location</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepositoryLocation()
   * @generated
   * @ordered
   */
  protected String repositoryLocation = REPOSITORY_LOCATION_EDEFAULT;

  /**
   * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGroups()
   * @generated
   * @ordered
   */
  protected EList<SnapshotGroup> groups;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SnapshotRepositoryImpl()
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
    return SnapshotPackage.Literals.SNAPSHOT_REPOSITORY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRepositoryLocation()
  {
    return repositoryLocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRepositoryLocation(String newRepositoryLocation)
  {
    String oldRepositoryLocation = repositoryLocation;
    repositoryLocation = newRepositoryLocation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SNAPSHOT_REPOSITORY__REPOSITORY_LOCATION, oldRepositoryLocation, repositoryLocation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SnapshotGroup> getGroups()
  {
    if (groups == null)
    {
      groups = new EObjectContainmentWithInverseEList<SnapshotGroup>(SnapshotGroup.class, this, SnapshotPackage.SNAPSHOT_REPOSITORY__GROUPS, SnapshotPackage.SNAPSHOT_GROUP__PARENT);
    }
    return groups;
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
      case SnapshotPackage.SNAPSHOT_REPOSITORY__GROUPS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getGroups()).basicAdd(otherEnd, msgs);
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
      case SnapshotPackage.SNAPSHOT_REPOSITORY__GROUPS:
        return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case SnapshotPackage.SNAPSHOT_REPOSITORY__REPOSITORY_LOCATION:
        return getRepositoryLocation();
      case SnapshotPackage.SNAPSHOT_REPOSITORY__GROUPS:
        return getGroups();
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
      case SnapshotPackage.SNAPSHOT_REPOSITORY__REPOSITORY_LOCATION:
        setRepositoryLocation((String)newValue);
        return;
      case SnapshotPackage.SNAPSHOT_REPOSITORY__GROUPS:
        getGroups().clear();
        getGroups().addAll((Collection<? extends SnapshotGroup>)newValue);
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
      case SnapshotPackage.SNAPSHOT_REPOSITORY__REPOSITORY_LOCATION:
        setRepositoryLocation(REPOSITORY_LOCATION_EDEFAULT);
        return;
      case SnapshotPackage.SNAPSHOT_REPOSITORY__GROUPS:
        getGroups().clear();
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
      case SnapshotPackage.SNAPSHOT_REPOSITORY__REPOSITORY_LOCATION:
        return REPOSITORY_LOCATION_EDEFAULT == null ? repositoryLocation != null : !REPOSITORY_LOCATION_EDEFAULT.equals(repositoryLocation);
      case SnapshotPackage.SNAPSHOT_REPOSITORY__GROUPS:
        return groups != null && !groups.isEmpty();
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
    result.append(" (repositoryLocation: ");
    result.append(repositoryLocation);
    result.append(')');
    return result.toString();
  }

} //SnapshotRepositoryImpl
