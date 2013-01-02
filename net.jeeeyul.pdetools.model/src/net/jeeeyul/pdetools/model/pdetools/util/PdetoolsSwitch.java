/**
 */
package net.jeeeyul.pdetools.model.pdetools.util;

import net.jeeeyul.pdetools.model.pdetools.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage
 * @generated
 */
public class PdetoolsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PdetoolsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PdetoolsSwitch() {
		if (modelPackage == null) {
			modelPackage = PdetoolsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case PdetoolsPackage.CLIPBOARD_ELEMENT: {
				ClipboardElement clipboardElement = (ClipboardElement) theEObject;
				T result = caseClipboardElement(clipboardElement);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.CLIP_HISTORY: {
				ClipHistory clipHistory = (ClipHistory) theEObject;
				T result = caseClipHistory(clipHistory);
				if (result == null)
					result = caseClipboardElement(clipHistory);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.CLIPBOARD_ENTRY: {
				ClipboardEntry clipboardEntry = (ClipboardEntry) theEObject;
				T result = caseClipboardEntry(clipboardEntry);
				if (result == null)
					result = caseClipboardElement(clipboardEntry);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.TEXT_RANGE: {
				TextRange textRange = (TextRange) theEObject;
				T result = caseTextRange(textRange);
				if (result == null)
					result = caseClipboardElement(textRange);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.JAVA_INFO: {
				JavaInfo javaInfo = (JavaInfo) theEObject;
				T result = caseJavaInfo(javaInfo);
				if (result == null)
					result = caseClipboardElement(javaInfo);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.FIELD_NAME_OWNER: {
				FieldNameOwner fieldNameOwner = (FieldNameOwner) theEObject;
				T result = caseFieldNameOwner(fieldNameOwner);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.PALETTE: {
				Palette palette = (Palette) theEObject;
				T result = casePalette(palette);
				if (result == null)
					result = caseFieldNameOwner(palette);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.IMAGE_FILE: {
				ImageFile imageFile = (ImageFile) theEObject;
				T result = caseImageFile(imageFile);
				if (result == null)
					result = caseFieldNameOwner(imageFile);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.SNAPSHOT_REPOSITORY: {
				SnapshotRepository snapshotRepository = (SnapshotRepository) theEObject;
				T result = caseSnapshotRepository(snapshotRepository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.SNAPSHOT_GROUP: {
				SnapshotGroup snapshotGroup = (SnapshotGroup) theEObject;
				T result = caseSnapshotGroup(snapshotGroup);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.SNAPSHOT_ENTRY: {
				SnapshotEntry snapshotEntry = (SnapshotEntry) theEObject;
				T result = caseSnapshotEntry(snapshotEntry);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.SHELL_INFO: {
				ShellInfo shellInfo = (ShellInfo) theEObject;
				T result = caseShellInfo(shellInfo);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.COMMAND_HISTORY: {
				CommandHistory commandHistory = (CommandHistory) theEObject;
				T result = caseCommandHistory(commandHistory);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case PdetoolsPackage.COMMAND_EVENT: {
				CommandEvent commandEvent = (CommandEvent) theEObject;
				T result = caseCommandEvent(commandEvent);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clipboard Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clipboard Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClipboardElement(ClipboardElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clip History</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clip History</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClipHistory(ClipHistory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clipboard Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clipboard Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClipboardEntry(ClipboardEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextRange(TextRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaInfo(JavaInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field Name Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field Name Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFieldNameOwner(FieldNameOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Palette</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Palette</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePalette(Palette object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageFile(ImageFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snapshot Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snapshot Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnapshotRepository(SnapshotRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snapshot Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snapshot Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnapshotGroup(SnapshotGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snapshot Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snapshot Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnapshotEntry(SnapshotEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shell Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shell Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShellInfo(ShellInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command History</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command History</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandHistory(CommandHistory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandEvent(CommandEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //PdetoolsSwitch
