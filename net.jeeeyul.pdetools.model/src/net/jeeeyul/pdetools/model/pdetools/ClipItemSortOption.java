/**
 */
package net.jeeeyul.pdetools.model.pdetools;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Clip Item Sort Option</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.model.pdetools.PdetoolsPackage#getClipItemSortOption()
 * @model
 * @generated
 */
public enum ClipItemSortOption implements Enumerator {
	/**
	 * The '<em><b>CAPTURED ORDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAPTURED_ORDER_VALUE
	 * @generated
	 * @ordered
	 */
	CAPTURED_ORDER(0, "CAPTURED_ORDER", "captured-order"),

	/**
	 * The '<em><b>LAST USE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAST_USE_VALUE
	 * @generated
	 * @ordered
	 */
	LAST_USE(1, "LAST_USE", "last-use"),

	/**
	 * The '<em><b>USING COUNT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USING_COUNT_VALUE
	 * @generated
	 * @ordered
	 */
	USING_COUNT(2, "USING_COUNT", "using-count"),

	/**
	 * The '<em><b>ACTIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE(3, "ACTIVE", "active");

	/**
	 * The '<em><b>CAPTURED ORDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CAPTURED ORDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAPTURED_ORDER
	 * @model literal="captured-order"
	 * @generated
	 * @ordered
	 */
	public static final int CAPTURED_ORDER_VALUE = 0;

	/**
	 * The '<em><b>LAST USE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LAST USE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LAST_USE
	 * @model literal="last-use"
	 * @generated
	 * @ordered
	 */
	public static final int LAST_USE_VALUE = 1;

	/**
	 * The '<em><b>USING COUNT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USING COUNT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USING_COUNT
	 * @model literal="using-count"
	 * @generated
	 * @ordered
	 */
	public static final int USING_COUNT_VALUE = 2;

	/**
	 * The '<em><b>ACTIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACTIVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE
	 * @model literal="active"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_VALUE = 3;

	/**
	 * An array of all the '<em><b>Clip Item Sort Option</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ClipItemSortOption[] VALUES_ARRAY = new ClipItemSortOption[] { CAPTURED_ORDER, LAST_USE,
			USING_COUNT, ACTIVE, };

	/**
	 * A public read-only list of all the '<em><b>Clip Item Sort Option</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ClipItemSortOption> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Clip Item Sort Option</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClipItemSortOption get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ClipItemSortOption result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Clip Item Sort Option</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClipItemSortOption getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ClipItemSortOption result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Clip Item Sort Option</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClipItemSortOption get(int value) {
		switch (value) {
			case CAPTURED_ORDER_VALUE:
				return CAPTURED_ORDER;
			case LAST_USE_VALUE:
				return LAST_USE;
			case USING_COUNT_VALUE:
				return USING_COUNT;
			case ACTIVE_VALUE:
				return ACTIVE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ClipItemSortOption(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
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
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //ClipItemSortOption
