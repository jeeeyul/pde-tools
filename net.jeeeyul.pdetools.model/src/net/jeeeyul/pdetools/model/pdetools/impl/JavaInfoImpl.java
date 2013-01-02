/**
 */
package net.jeeeyul.pdetools.model.pdetools.impl;

import net.jeeeyul.pdetools.model.pdetools.JavaInfo;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.JavaInfoImpl#getQualifiedTypeName <em>Qualified Type Name</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.JavaInfoImpl#getEnclosingElementName <em>Enclosing Element Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaInfoImpl extends ClipboardElementImpl implements JavaInfo {
	/**
	 * The default value of the '{@link #getQualifiedTypeName() <em>Qualified Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_TYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedTypeName() <em>Qualified Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedTypeName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedTypeName = QUALIFIED_TYPE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnclosingElementName() <em>Enclosing Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnclosingElementName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENCLOSING_ELEMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnclosingElementName() <em>Enclosing Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnclosingElementName()
	 * @generated
	 * @ordered
	 */
	protected String enclosingElementName = ENCLOSING_ELEMENT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdetoolsPackage.Literals.JAVA_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedTypeName() {
		return qualifiedTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedTypeName(String newQualifiedTypeName) {
		String oldQualifiedTypeName = qualifiedTypeName;
		qualifiedTypeName = newQualifiedTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdetoolsPackage.JAVA_INFO__QUALIFIED_TYPE_NAME,
					oldQualifiedTypeName, qualifiedTypeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEnclosingElementName() {
		return enclosingElementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnclosingElementName(String newEnclosingElementName) {
		String oldEnclosingElementName = enclosingElementName;
		enclosingElementName = newEnclosingElementName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdetoolsPackage.JAVA_INFO__ENCLOSING_ELEMENT_NAME,
					oldEnclosingElementName, enclosingElementName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PdetoolsPackage.JAVA_INFO__QUALIFIED_TYPE_NAME:
				return getQualifiedTypeName();
			case PdetoolsPackage.JAVA_INFO__ENCLOSING_ELEMENT_NAME:
				return getEnclosingElementName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PdetoolsPackage.JAVA_INFO__QUALIFIED_TYPE_NAME:
				setQualifiedTypeName((String) newValue);
				return;
			case PdetoolsPackage.JAVA_INFO__ENCLOSING_ELEMENT_NAME:
				setEnclosingElementName((String) newValue);
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
			case PdetoolsPackage.JAVA_INFO__QUALIFIED_TYPE_NAME:
				setQualifiedTypeName(QUALIFIED_TYPE_NAME_EDEFAULT);
				return;
			case PdetoolsPackage.JAVA_INFO__ENCLOSING_ELEMENT_NAME:
				setEnclosingElementName(ENCLOSING_ELEMENT_NAME_EDEFAULT);
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
			case PdetoolsPackage.JAVA_INFO__QUALIFIED_TYPE_NAME:
				return QUALIFIED_TYPE_NAME_EDEFAULT == null ? qualifiedTypeName != null : !QUALIFIED_TYPE_NAME_EDEFAULT
						.equals(qualifiedTypeName);
			case PdetoolsPackage.JAVA_INFO__ENCLOSING_ELEMENT_NAME:
				return ENCLOSING_ELEMENT_NAME_EDEFAULT == null ? enclosingElementName != null
						: !ENCLOSING_ELEMENT_NAME_EDEFAULT.equals(enclosingElementName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (qualifiedTypeName: ");
		result.append(qualifiedTypeName);
		result.append(", enclosingElementName: ");
		result.append(enclosingElementName);
		result.append(')');
		return result.toString();
	}

} //JavaInfoImpl
