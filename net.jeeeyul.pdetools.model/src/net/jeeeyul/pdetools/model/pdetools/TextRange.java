/**
 */
package net.jeeeyul.pdetools.model.pdetools;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getOffset <em>Offset</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getLength <em>Length</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getStartLine <em>Start Line</em>}</li>
 *   <li>{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getEndLine <em>End Line</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getTextRange()
 * @model
 * @generated
 */
public interface TextRange extends ClipboardElement {
	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getTextRange_Offset()
	 * @model unique="false"
	 * @generated
	 */
	int getOffset();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(int)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getTextRange_Length()
	 * @model unique="false"
	 * @generated
	 */
	int getLength();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(int value);

	/**
	 * Returns the value of the '<em><b>Start Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Line</em>' attribute.
	 * @see #setStartLine(int)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getTextRange_StartLine()
	 * @model unique="false"
	 * @generated
	 */
	int getStartLine();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getStartLine <em>Start Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Line</em>' attribute.
	 * @see #getStartLine()
	 * @generated
	 */
	void setStartLine(int value);

	/**
	 * Returns the value of the '<em><b>End Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Line</em>' attribute.
	 * @see #setEndLine(int)
	 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getTextRange_EndLine()
	 * @model unique="false"
	 * @generated
	 */
	int getEndLine();

	/**
	 * Sets the value of the '{@link net.jeeeyul.pdetools.model.pdetools.TextRange#getEndLine <em>End Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Line</em>' attribute.
	 * @see #getEndLine()
	 * @generated
	 */
	void setEndLine(int value);

} // TextRange
