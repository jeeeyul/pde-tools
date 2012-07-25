/**
 */
package net.jeeeyul.pdetools.snapshot.model.snapshot.impl;

import net.jeeeyul.pdetools.snapshot.model.snapshot.ShellInfo;
import net.jeeeyul.pdetools.snapshot.model.snapshot.SnapshotPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.swt.graphics.ImageData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shell Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.ShellInfoImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.ShellInfoImpl#getShellStyle <em>Shell Style</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.snapshot.model.snapshot.impl.ShellInfoImpl#getShellTitle <em>Shell Title</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ShellInfoImpl extends MinimalEObjectImpl.Container implements ShellInfo
{
  /**
   * The default value of the '{@link #getIcon() <em>Icon</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIcon()
   * @generated
   * @ordered
   */
  protected static final ImageData ICON_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIcon()
   * @generated
   * @ordered
   */
  protected ImageData icon = ICON_EDEFAULT;

  /**
   * The default value of the '{@link #getShellStyle() <em>Shell Style</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShellStyle()
   * @generated
   * @ordered
   */
  protected static final int SHELL_STYLE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getShellStyle() <em>Shell Style</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShellStyle()
   * @generated
   * @ordered
   */
  protected int shellStyle = SHELL_STYLE_EDEFAULT;

  /**
   * The default value of the '{@link #getShellTitle() <em>Shell Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShellTitle()
   * @generated
   * @ordered
   */
  protected static final String SHELL_TITLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getShellTitle() <em>Shell Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getShellTitle()
   * @generated
   * @ordered
   */
  protected String shellTitle = SHELL_TITLE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ShellInfoImpl()
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
    return SnapshotPackage.Literals.SHELL_INFO;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImageData getIcon()
  {
    return icon;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIcon(ImageData newIcon)
  {
    ImageData oldIcon = icon;
    icon = newIcon;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SHELL_INFO__ICON, oldIcon, icon));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getShellStyle()
  {
    return shellStyle;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShellStyle(int newShellStyle)
  {
    int oldShellStyle = shellStyle;
    shellStyle = newShellStyle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SHELL_INFO__SHELL_STYLE, oldShellStyle, shellStyle));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getShellTitle()
  {
    return shellTitle;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setShellTitle(String newShellTitle)
  {
    String oldShellTitle = shellTitle;
    shellTitle = newShellTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SnapshotPackage.SHELL_INFO__SHELL_TITLE, oldShellTitle, shellTitle));
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
      case SnapshotPackage.SHELL_INFO__ICON:
        return getIcon();
      case SnapshotPackage.SHELL_INFO__SHELL_STYLE:
        return getShellStyle();
      case SnapshotPackage.SHELL_INFO__SHELL_TITLE:
        return getShellTitle();
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
      case SnapshotPackage.SHELL_INFO__ICON:
        setIcon((ImageData)newValue);
        return;
      case SnapshotPackage.SHELL_INFO__SHELL_STYLE:
        setShellStyle((Integer)newValue);
        return;
      case SnapshotPackage.SHELL_INFO__SHELL_TITLE:
        setShellTitle((String)newValue);
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
      case SnapshotPackage.SHELL_INFO__ICON:
        setIcon(ICON_EDEFAULT);
        return;
      case SnapshotPackage.SHELL_INFO__SHELL_STYLE:
        setShellStyle(SHELL_STYLE_EDEFAULT);
        return;
      case SnapshotPackage.SHELL_INFO__SHELL_TITLE:
        setShellTitle(SHELL_TITLE_EDEFAULT);
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
      case SnapshotPackage.SHELL_INFO__ICON:
        return ICON_EDEFAULT == null ? icon != null : !ICON_EDEFAULT.equals(icon);
      case SnapshotPackage.SHELL_INFO__SHELL_STYLE:
        return shellStyle != SHELL_STYLE_EDEFAULT;
      case SnapshotPackage.SHELL_INFO__SHELL_TITLE:
        return SHELL_TITLE_EDEFAULT == null ? shellTitle != null : !SHELL_TITLE_EDEFAULT.equals(shellTitle);
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
    result.append(" (icon: ");
    result.append(icon);
    result.append(", shellStyle: ");
    result.append(shellStyle);
    result.append(", shellTitle: ");
    result.append(shellTitle);
    result.append(')');
    return result.toString();
  }

} //ShellInfoImpl
