/**
 */
package net.jeeeyul.pdetools.model.pdetools.impl;

import java.util.Collection;

import net.jeeeyul.pdetools.model.pdetools.ClipHistory;
import net.jeeeyul.pdetools.model.pdetools.ClipboardEntry;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clip History</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.ClipHistoryImpl#getActiveEntry <em>Active Entry</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.ClipHistoryImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClipHistoryImpl extends ClipboardElementImpl implements ClipHistory {
	/**
	 * The cached value of the '{@link #getActiveEntry() <em>Active Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveEntry()
	 * @generated
	 * @ordered
	 */
	protected ClipboardEntry activeEntry;

	/**
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<ClipboardEntry> entries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClipHistoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdetoolsPackage.Literals.CLIP_HISTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClipboardEntry getActiveEntry() {
		if (activeEntry != null && activeEntry.eIsProxy()) {
			InternalEObject oldActiveEntry = (InternalEObject) activeEntry;
			activeEntry = (ClipboardEntry) eResolveProxy(oldActiveEntry);
			if (activeEntry != oldActiveEntry) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							PdetoolsPackage.CLIP_HISTORY__ACTIVE_ENTRY, oldActiveEntry, activeEntry));
			}
		}
		return activeEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClipboardEntry basicGetActiveEntry() {
		return activeEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveEntry(ClipboardEntry newActiveEntry) {
		ClipboardEntry oldActiveEntry = activeEntry;
		activeEntry = newActiveEntry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdetoolsPackage.CLIP_HISTORY__ACTIVE_ENTRY,
					oldActiveEntry, activeEntry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClipboardEntry> getEntries() {
		if (entries == null) {
			entries = new EObjectContainmentWithInverseEList<ClipboardEntry>(ClipboardEntry.class, this,
					PdetoolsPackage.CLIP_HISTORY__ENTRIES, PdetoolsPackage.CLIPBOARD_ENTRY__PARENT);
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PdetoolsPackage.CLIP_HISTORY__ENTRIES:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getEntries()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PdetoolsPackage.CLIP_HISTORY__ENTRIES:
				return ((InternalEList<?>) getEntries()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PdetoolsPackage.CLIP_HISTORY__ACTIVE_ENTRY:
				if (resolve)
					return getActiveEntry();
				return basicGetActiveEntry();
			case PdetoolsPackage.CLIP_HISTORY__ENTRIES:
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PdetoolsPackage.CLIP_HISTORY__ACTIVE_ENTRY:
				setActiveEntry((ClipboardEntry) newValue);
				return;
			case PdetoolsPackage.CLIP_HISTORY__ENTRIES:
				getEntries().clear();
				getEntries().addAll((Collection<? extends ClipboardEntry>) newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case PdetoolsPackage.CLIP_HISTORY__ACTIVE_ENTRY:
				setActiveEntry((ClipboardEntry) null);
				return;
			case PdetoolsPackage.CLIP_HISTORY__ENTRIES:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PdetoolsPackage.CLIP_HISTORY__ACTIVE_ENTRY:
				return activeEntry != null;
			case PdetoolsPackage.CLIP_HISTORY__ENTRIES:
				return entries != null && !entries.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClipHistoryImpl
