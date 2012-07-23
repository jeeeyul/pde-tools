/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;

import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipHistory;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardEntry;
import net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.xtext.xbase.lib.Conversions;

import com.google.common.base.Objects;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getUsingCount <em>Using Count</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getLastUsedTime <em>Last Used Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getTextContent <em>Text Content</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getRtfContent <em>Rtf Content</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getTakenTime <em>Taken Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getImageData <em>Image Data</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.clipboard.model.clipboard.impl.ClipboardEntryImpl#getPartId <em>Part Id</em>}</li>
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
   * The default value of the '{@link #getLastUsedTime() <em>Last Used Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastUsedTime()
   * @generated
   * @ordered
   */
  protected static final Date LAST_USED_TIME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLastUsedTime() <em>Last Used Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastUsedTime()
   * @generated
   * @ordered
   */
  protected Date lastUsedTime = LAST_USED_TIME_EDEFAULT;

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
   * The default value of the '{@link #getImageData() <em>Image Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImageData()
   * @generated
   * @ordered
   */
  protected static final ImageData IMAGE_DATA_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImageData() <em>Image Data</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImageData()
   * @generated
   * @ordered
   */
  protected ImageData imageData = IMAGE_DATA_EDEFAULT;

  /**
   * The default value of the '{@link #getPartId() <em>Part Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartId()
   * @generated
   * @ordered
   */
  protected static final String PART_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPartId() <em>Part Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartId()
   * @generated
   * @ordered
   */
  protected String partId = PART_ID_EDEFAULT;

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
  public Date getLastUsedTime()
  {
    return lastUsedTime;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLastUsedTime(Date newLastUsedTime)
  {
    Date oldLastUsedTime = lastUsedTime;
    lastUsedTime = newLastUsedTime;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClipboardPackage.CLIPBOARD_ENTRY__LAST_USED_TIME, oldLastUsedTime, lastUsedTime));
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
  public ImageData getImageData()
  {
    return imageData;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImageData(ImageData newImageData)
  {
    ImageData oldImageData = imageData;
    imageData = newImageData;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClipboardPackage.CLIPBOARD_ENTRY__IMAGE_DATA, oldImageData, imageData));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPartId()
  {
    return partId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartId(String newPartId)
  {
    String oldPartId = partId;
    partId = newPartId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClipboardPackage.CLIPBOARD_ENTRY__PART_ID, oldPartId, partId));
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
  public void transferTo(Clipboard clipboard)
  {
    ArrayList<Transfer> _arrayList = new ArrayList<Transfer>();
    ArrayList<Transfer> transferList = _arrayList;
    ArrayList<Object> _arrayList_1 = new ArrayList<Object>();
    ArrayList<Object> dataList = _arrayList_1;
    ClipboardEntry _this = this;
    String _textContent = _this.getTextContent();
    boolean _notEquals = (!Objects.equal(_textContent, null));
    if (_notEquals)
    {
      TextTransfer _instance = TextTransfer.getInstance();
      transferList.add(_instance);
      ClipboardEntry _this_1 = this;
      String _textContent_1 = _this_1.getTextContent();
      dataList.add(_textContent_1);
    }
    ClipboardEntry _this_2 = this;
    String _rtfContent = _this_2.getRtfContent();
    boolean _notEquals_1 = (!Objects.equal(_rtfContent, null));
    if (_notEquals_1)
    {
      RTFTransfer _instance_1 = RTFTransfer.getInstance();
      transferList.add(_instance_1);
      ClipboardEntry _this_3 = this;
      String _rtfContent_1 = _this_3.getRtfContent();
      dataList.add(_rtfContent_1);
    }
    final ArrayList<Object> _converted_dataList = (ArrayList<Object>)dataList;
    final ArrayList<Transfer> _converted_transferList = (ArrayList<Transfer>)transferList;
    clipboard.setContents(((Object[])Conversions.unwrapArray(_converted_dataList, Object.class)), ((Transfer[])Conversions.unwrapArray(_converted_transferList, Transfer.class)));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void increaseUsing()
  {
    ClipboardEntry _this = this;
    ClipboardEntry _this_1 = this;
    int _usingCount = _this_1.getUsingCount();
    int _plus = (_usingCount + 1);
    _this.setUsingCount(_plus);
    ClipboardEntry _this_2 = this;
    Date _date = new Date();
    _this_2.setLastUsedTime(_date);
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
      case ClipboardPackage.CLIPBOARD_ENTRY__LAST_USED_TIME:
        return getLastUsedTime();
      case ClipboardPackage.CLIPBOARD_ENTRY__TEXT_CONTENT:
        return getTextContent();
      case ClipboardPackage.CLIPBOARD_ENTRY__RTF_CONTENT:
        return getRtfContent();
      case ClipboardPackage.CLIPBOARD_ENTRY__TAKEN_TIME:
        return getTakenTime();
      case ClipboardPackage.CLIPBOARD_ENTRY__IMAGE_DATA:
        return getImageData();
      case ClipboardPackage.CLIPBOARD_ENTRY__PART_ID:
        return getPartId();
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
      case ClipboardPackage.CLIPBOARD_ENTRY__LAST_USED_TIME:
        setLastUsedTime((Date)newValue);
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
      case ClipboardPackage.CLIPBOARD_ENTRY__IMAGE_DATA:
        setImageData((ImageData)newValue);
        return;
      case ClipboardPackage.CLIPBOARD_ENTRY__PART_ID:
        setPartId((String)newValue);
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
      case ClipboardPackage.CLIPBOARD_ENTRY__LAST_USED_TIME:
        setLastUsedTime(LAST_USED_TIME_EDEFAULT);
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
      case ClipboardPackage.CLIPBOARD_ENTRY__IMAGE_DATA:
        setImageData(IMAGE_DATA_EDEFAULT);
        return;
      case ClipboardPackage.CLIPBOARD_ENTRY__PART_ID:
        setPartId(PART_ID_EDEFAULT);
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
      case ClipboardPackage.CLIPBOARD_ENTRY__LAST_USED_TIME:
        return LAST_USED_TIME_EDEFAULT == null ? lastUsedTime != null : !LAST_USED_TIME_EDEFAULT.equals(lastUsedTime);
      case ClipboardPackage.CLIPBOARD_ENTRY__TEXT_CONTENT:
        return TEXT_CONTENT_EDEFAULT == null ? textContent != null : !TEXT_CONTENT_EDEFAULT.equals(textContent);
      case ClipboardPackage.CLIPBOARD_ENTRY__RTF_CONTENT:
        return RTF_CONTENT_EDEFAULT == null ? rtfContent != null : !RTF_CONTENT_EDEFAULT.equals(rtfContent);
      case ClipboardPackage.CLIPBOARD_ENTRY__TAKEN_TIME:
        return TAKEN_TIME_EDEFAULT == null ? takenTime != null : !TAKEN_TIME_EDEFAULT.equals(takenTime);
      case ClipboardPackage.CLIPBOARD_ENTRY__IMAGE_DATA:
        return IMAGE_DATA_EDEFAULT == null ? imageData != null : !IMAGE_DATA_EDEFAULT.equals(imageData);
      case ClipboardPackage.CLIPBOARD_ENTRY__PART_ID:
        return PART_ID_EDEFAULT == null ? partId != null : !PART_ID_EDEFAULT.equals(partId);
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
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
  {
    switch (operationID)
    {
      case ClipboardPackage.CLIPBOARD_ENTRY___TRANSFER_TO__CLIPBOARD:
        transferTo((Clipboard)arguments.get(0));
        return null;
      case ClipboardPackage.CLIPBOARD_ENTRY___INCREASE_USING:
        increaseUsing();
        return null;
    }
    return super.eInvoke(operationID, arguments);
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
    result.append(", lastUsedTime: ");
    result.append(lastUsedTime);
    result.append(", textContent: ");
    result.append(textContent);
    result.append(", rtfContent: ");
    result.append(rtfContent);
    result.append(", takenTime: ");
    result.append(takenTime);
    result.append(", imageData: ");
    result.append(imageData);
    result.append(", partId: ");
    result.append(partId);
    result.append(')');
    return result.toString();
  }

} //ClipboardEntryImpl
