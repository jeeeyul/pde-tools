/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard.impl;

import java.util.Date;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage;

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
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getUsingCount <em>Using Count</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getTextContent <em>Text Content</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getRtfContent <em>Rtf Content</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getTakenTime <em>Taken Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClipboardEntryImpl extends MinimalEObjectImpl.Container implements ClipboardEntry
{
  /**
   * The default value of the '{@link #getUsingCount() <em>Using Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsingCount()
   * @generated
   * @ordered
   */
  protected static final int USING_COUNT_EDEFAULT = 0;
  /**
   * The cached value of the '{@link #getUsingCount() <em>Using Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsingCount()
   * @generated
   * @ordered
   */
  protected int usingCount = USING_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #getTextContent() <em>Text Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTextContent()
   * @generated
   * @ordered
   */
  protected static final String TEXT_CONTENT_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getTextContent() <em>Text Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTextContent()
   * @generated
   * @ordered
   */
  protected String textContent = TEXT_CONTENT_EDEFAULT;
  /**
   * The default value of the '{@link #getRtfContent() <em>Rtf Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRtfContent()
   * @generated
   * @ordered
   */
  protected static final String RTF_CONTENT_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getRtfContent() <em>Rtf Content</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRtfContent()
   * @generated
   * @ordered
   */
  protected String rtfContent = RTF_CONTENT_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClipboardEntryImpl()
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
    return ClipboardPackage.Literals.CLIPBOARD_ENTRY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getUsingCount()
  {
    return usingCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUsingCount(int newUsingCount)
  {
    int oldUsingCount = usingCount;
    usingCount = newUsingCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClipboardPackage.CLIPBOARD_ENTRY__USING_COUNT, oldUsingCount, usingCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTextContent()
  {
    return textContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTextContent(String newTextContent)
  {
    String oldTextContent = textContent;
    textContent = newTextContent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClipboardPackage.CLIPBOARD_ENTRY__TEXT_CONTENT, oldTextContent, textContent));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRtfContent()
  {
    return rtfContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRtfContent(String newRtfContent)
  {
    String oldRtfContent = rtfContent;
    rtfContent = newRtfContent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClipboardPackage.CLIPBOARD_ENTRY__RTF_CONTENT, oldRtfContent, rtfContent));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ClipboardPackage.CLIPBOARD_ENTRY__TAKEN_TIME, oldTakenTime, takenTime));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClipHistory getParent()
  {
    if (eContainerFeatureID() != ClipboardPackage.CLIPBOARD_ENTRY__PARENT) return null;
    return (ClipHistory)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetParent(ClipHistory newParent, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newParent, ClipboardPackage.CLIPBOARD_ENTRY__PARENT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParent(ClipHistory newParent)
  {
    if (newParent != eInternalContainer() || (eContainerFeatureID() != ClipboardPackage.CLIPBOARD_ENTRY__PARENT && newParent != null))
    {
      if (EcoreUtil.isAncestor(this, newParent))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newParent != null)
        msgs = ((InternalEObject)newParent).eInverseAdd(this, ClipboardPackage.CLIP_HISTORY__ENTRIES, ClipHistory.class, msgs);
      msgs = basicSetParent(newParent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClipboardPackage.CLIPBOARD_ENTRY__PARENT, newParent, newParent));
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
      case ClipboardPackage.CLIPBOARD_ENTRY__PARENT:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetParent((ClipHistory)otherEnd, msgs);
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
      case ClipboardPackage.CLIPBOARD_ENTRY__PARENT:
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
      case ClipboardPackage.CLIPBOARD_ENTRY__PARENT:
        return eInternalContainer().eInverseRemove(this, ClipboardPackage.CLIP_HISTORY__ENTRIES, ClipHistory.class, msgs);
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
      case ClipboardPackage.CLIPBOARD_ENTRY__USING_COUNT:
        return getUsingCount();
      case ClipboardPackage.CLIPBOARD_ENTRY__TEXT_CONTENT:
        return getTextContent();
      case ClipboardPackage.CLIPBOARD_ENTRY__RTF_CONTENT:
        return getRtfContent();
      case ClipboardPackage.CLIPBOARD_ENTRY__TAKEN_TIME:
        return getTakenTime();
      case ClipboardPackage.CLIPBOARD_ENTRY__PARENT:
        return getParent();
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
      case ClipboardPackage.CLIPBOARD_ENTRY__USING_COUNT:
        setUsingCount((Integer)newValue);
        return;
      case ClipboardPackage.CLIPBOARD_ENTRY__TEXT_CONTENT:
        setTextContent((String)newValue);
        return;
      case ClipboardPackage.CLIPBOARD_ENTRY__RTF_CONTENT:
        setRtfContent((String)newValue);
        return;
      case ClipboardPackage.CLIPBOARD_ENTRY__TAKEN_TIME:
        setTakenTime((Date)newValue);
        return;
      case ClipboardPackage.CLIPBOARD_ENTRY__PARENT:
        setParent((ClipHistory)newValue);
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
      case ClipboardPackage.CLIPBOARD_ENTRY__USING_COUNT:
        setUsingCount(USING_COUNT_EDEFAULT);
        return;
      case ClipboardPackage.CLIPBOARD_ENTRY__TEXT_CONTENT:
        setTextContent(TEXT_CONTENT_EDEFAULT);
        return;
      case ClipboardPackage.CLIPBOARD_ENTRY__RTF_CONTENT:
        setRtfContent(RTF_CONTENT_EDEFAULT);
        return;
      case ClipboardPackage.CLIPBOARD_ENTRY__TAKEN_TIME:
        setTakenTime(TAKEN_TIME_EDEFAULT);
        return;
      case ClipboardPackage.CLIPBOARD_ENTRY__PARENT:
        setParent((ClipHistory)null);
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
      case ClipboardPackage.CLIPBOARD_ENTRY__USING_COUNT:
        return usingCount != USING_COUNT_EDEFAULT;
      case ClipboardPackage.CLIPBOARD_ENTRY__TEXT_CONTENT:
        return TEXT_CONTENT_EDEFAULT == null ? textContent != null : !TEXT_CONTENT_EDEFAULT.equals(textContent);
      case ClipboardPackage.CLIPBOARD_ENTRY__RTF_CONTENT:
        return RTF_CONTENT_EDEFAULT == null ? rtfContent != null : !RTF_CONTENT_EDEFAULT.equals(rtfContent);
      case ClipboardPackage.CLIPBOARD_ENTRY__TAKEN_TIME:
        return TAKEN_TIME_EDEFAULT == null ? takenTime != null : !TAKEN_TIME_EDEFAULT.equals(takenTime);
      case ClipboardPackage.CLIPBOARD_ENTRY__PARENT:
        return getParent() != null;
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
    result.append(" (usingCount: ");
    result.append(usingCount);
    result.append(", textContent: ");
    result.append(textContent);
    result.append(", rtfContent: ");
    result.append(rtfContent);
    result.append(", takenTime: ");
    result.append(takenTime);
    result.append(')');
    return result.toString();
  }

} //ClipboardEntryImpl
