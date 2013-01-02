/**
 */
package net.jeeeyul.pdetools.model.pdetools;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage
 * @generated
 */
public interface PdetoolsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PdetoolsFactory eINSTANCE = net.jeeeyul.pdetools.model.pdetools.impl.PdetoolsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Clipboard Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clipboard Element</em>'.
	 * @generated
	 */
	ClipboardElement createClipboardElement();

	/**
	 * Returns a new object of class '<em>Clip History</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clip History</em>'.
	 * @generated
	 */
	ClipHistory createClipHistory();

	/**
	 * Returns a new object of class '<em>Clipboard Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clipboard Entry</em>'.
	 * @generated
	 */
	ClipboardEntry createClipboardEntry();

	/**
	 * Returns a new object of class '<em>Text Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Range</em>'.
	 * @generated
	 */
	TextRange createTextRange();

	/**
	 * Returns a new object of class '<em>Java Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Info</em>'.
	 * @generated
	 */
	JavaInfo createJavaInfo();

	/**
	 * Returns a new object of class '<em>Palette</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Palette</em>'.
	 * @generated
	 */
	Palette createPalette();

	/**
	 * Returns a new object of class '<em>Image File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image File</em>'.
	 * @generated
	 */
	ImageFile createImageFile();

	/**
	 * Returns a new object of class '<em>Snapshot Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snapshot Repository</em>'.
	 * @generated
	 */
	SnapshotRepository createSnapshotRepository();

	/**
	 * Returns a new object of class '<em>Snapshot Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snapshot Group</em>'.
	 * @generated
	 */
	SnapshotGroup createSnapshotGroup();

	/**
	 * Returns a new object of class '<em>Snapshot Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snapshot Entry</em>'.
	 * @generated
	 */
	SnapshotEntry createSnapshotEntry();

	/**
	 * Returns a new object of class '<em>Shell Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shell Info</em>'.
	 * @generated
	 */
	ShellInfo createShellInfo();

	/**
	 * Returns a new object of class '<em>Command History</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command History</em>'.
	 * @generated
	 */
	CommandHistory createCommandHistory();

	/**
	 * Returns a new object of class '<em>Command Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command Event</em>'.
	 * @generated
	 */
	CommandEvent createCommandEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PdetoolsPackage getPdetoolsPackage();

} //PdetoolsFactory
