/**
 */
package net.jeeeyul.pdetools.model.pdetools;

import org.eclipse.core.resources.IFile;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ImageFile#getParent <em>Parent</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.ImageFile#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getImageFile()
 * @model
 * @generated
 */
public interface ImageFile extends FieldNameOwner {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.jeeeyul.pdetools.model.pdetools.Palette#getImageFiles <em>Image Files</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Palette)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getImageFile_Parent()
	 * @see net.jeeeyul.pdetools.model.pdetools.Palette#getImageFiles
	 * @model opposite="imageFiles" transient="false"
	 * @generated
	 */
	Palette getParent();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ImageFile#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Palette value);

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * 워크스페이스 상의 실제 IFile
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(IFile)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getImageFile_File()
	 * @model unique="false" id="true" dataType="net.jeeeyul.pdetools.model.pdetools.IFile"
	 * @generated
	 */
	IFile getFile();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.ImageFile#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(IFile value);

} // ImageFile
