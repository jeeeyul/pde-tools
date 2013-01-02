/**
 */
package net.jeeeyul.pdetools.model.pdetools.impl;

import java.util.Collection;

import net.jeeeyul.pdetools.model.pdetools.CommandEvent;
import net.jeeeyul.pdetools.model.pdetools.CommandExecutionType;
import net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jface.resource.ImageDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl#getCommandId <em>Command Id</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl#getImageDescriptor <em>Image Descriptor</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl#getTime <em>Time</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl#getType <em>Type</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.impl.CommandEventImpl#getException <em>Exception</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommandEventImpl extends MinimalEObjectImpl.Container implements CommandEvent {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<CommandEvent> children;

	/**
	 * The default value of the '{@link #getCommandId() <em>Command Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandId()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMAND_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommandId() <em>Command Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommandId()
	 * @generated
	 * @ordered
	 */
	protected String commandId = COMMAND_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getImageDescriptor() <em>Image Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageDescriptor()
	 * @generated
	 * @ordered
	 */
	protected static final ImageDescriptor IMAGE_DESCRIPTOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImageDescriptor() <em>Image Descriptor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImageDescriptor()
	 * @generated
	 * @ordered
	 */
	protected ImageDescriptor imageDescriptor = IMAGE_DESCRIPTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected long time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final CommandExecutionType TYPE_EDEFAULT = CommandExecutionType.EXECUTING;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected CommandExecutionType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected static final Exception EXCEPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getException() <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getException()
	 * @generated
	 * @ordered
	 */
	protected Exception exception = EXCEPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommandEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PdetoolsPackage.Literals.COMMAND_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommandEvent> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<CommandEvent>(CommandEvent.class, this,
					PdetoolsPackage.COMMAND_EVENT__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommandId() {
		return commandId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommandId(String newCommandId) {
		String oldCommandId = commandId;
		commandId = newCommandId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdetoolsPackage.COMMAND_EVENT__COMMAND_ID,
					oldCommandId, commandId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdetoolsPackage.COMMAND_EVENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageDescriptor getImageDescriptor() {
		return imageDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImageDescriptor(ImageDescriptor newImageDescriptor) {
		ImageDescriptor oldImageDescriptor = imageDescriptor;
		imageDescriptor = newImageDescriptor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdetoolsPackage.COMMAND_EVENT__IMAGE_DESCRIPTOR,
					oldImageDescriptor, imageDescriptor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(long newTime) {
		long oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdetoolsPackage.COMMAND_EVENT__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandExecutionType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(CommandExecutionType newType) {
		CommandExecutionType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdetoolsPackage.COMMAND_EVENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setException(Exception newException) {
		Exception oldException = exception;
		exception = newException;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PdetoolsPackage.COMMAND_EVENT__EXCEPTION,
					oldException, exception));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PdetoolsPackage.COMMAND_EVENT__CHILDREN:
				return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
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
			case PdetoolsPackage.COMMAND_EVENT__CHILDREN:
				return getChildren();
			case PdetoolsPackage.COMMAND_EVENT__COMMAND_ID:
				return getCommandId();
			case PdetoolsPackage.COMMAND_EVENT__NAME:
				return getName();
			case PdetoolsPackage.COMMAND_EVENT__IMAGE_DESCRIPTOR:
				return getImageDescriptor();
			case PdetoolsPackage.COMMAND_EVENT__TIME:
				return getTime();
			case PdetoolsPackage.COMMAND_EVENT__TYPE:
				return getType();
			case PdetoolsPackage.COMMAND_EVENT__EXCEPTION:
				return getException();
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
			case PdetoolsPackage.COMMAND_EVENT__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends CommandEvent>) newValue);
				return;
			case PdetoolsPackage.COMMAND_EVENT__COMMAND_ID:
				setCommandId((String) newValue);
				return;
			case PdetoolsPackage.COMMAND_EVENT__NAME:
				setName((String) newValue);
				return;
			case PdetoolsPackage.COMMAND_EVENT__IMAGE_DESCRIPTOR:
				setImageDescriptor((ImageDescriptor) newValue);
				return;
			case PdetoolsPackage.COMMAND_EVENT__TIME:
				setTime((Long) newValue);
				return;
			case PdetoolsPackage.COMMAND_EVENT__TYPE:
				setType((CommandExecutionType) newValue);
				return;
			case PdetoolsPackage.COMMAND_EVENT__EXCEPTION:
				setException((Exception) newValue);
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
			case PdetoolsPackage.COMMAND_EVENT__CHILDREN:
				getChildren().clear();
				return;
			case PdetoolsPackage.COMMAND_EVENT__COMMAND_ID:
				setCommandId(COMMAND_ID_EDEFAULT);
				return;
			case PdetoolsPackage.COMMAND_EVENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PdetoolsPackage.COMMAND_EVENT__IMAGE_DESCRIPTOR:
				setImageDescriptor(IMAGE_DESCRIPTOR_EDEFAULT);
				return;
			case PdetoolsPackage.COMMAND_EVENT__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case PdetoolsPackage.COMMAND_EVENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case PdetoolsPackage.COMMAND_EVENT__EXCEPTION:
				setException(EXCEPTION_EDEFAULT);
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
			case PdetoolsPackage.COMMAND_EVENT__CHILDREN:
				return children != null && !children.isEmpty();
			case PdetoolsPackage.COMMAND_EVENT__COMMAND_ID:
				return COMMAND_ID_EDEFAULT == null ? commandId != null : !COMMAND_ID_EDEFAULT.equals(commandId);
			case PdetoolsPackage.COMMAND_EVENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PdetoolsPackage.COMMAND_EVENT__IMAGE_DESCRIPTOR:
				return IMAGE_DESCRIPTOR_EDEFAULT == null ? imageDescriptor != null : !IMAGE_DESCRIPTOR_EDEFAULT
						.equals(imageDescriptor);
			case PdetoolsPackage.COMMAND_EVENT__TIME:
				return time != TIME_EDEFAULT;
			case PdetoolsPackage.COMMAND_EVENT__TYPE:
				return type != TYPE_EDEFAULT;
			case PdetoolsPackage.COMMAND_EVENT__EXCEPTION:
				return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
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
		result.append(" (commandId: ");
		result.append(commandId);
		result.append(", name: ");
		result.append(name);
		result.append(", imageDescriptor: ");
		result.append(imageDescriptor);
		result.append(", time: ");
		result.append(time);
		result.append(", type: ");
		result.append(type);
		result.append(", exception: ");
		result.append(exception);
		result.append(')');
		return result.toString();
	}

} //CommandEventImpl
