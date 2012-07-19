/**
 */
package net.jeeeyul.pdetools.clipboard.model.clipboard;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Sort Method</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.jeeeyul.pdetools.clipboard.model.clipboard.ClipboardPackage#getSortMethod()
 * @model
 * @generated
 */
public enum SortMethod implements Enumerator
{
  /**
   * The '<em><b>RECENTLY COLLECTED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RECENTLY_COLLECTED_VALUE
   * @generated
   * @ordered
   */
  RECENTLY_COLLECTED(0, "RECENTLY_COLLECTED", "Recently Collected"), /**
   * The '<em><b>RECENTLY USED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RECENTLY_USED_VALUE
   * @generated
   * @ordered
   */
  RECENTLY_USED(0, "RECENTLY_USED", "Recently Used"),

  /**
   * The '<em><b>MOST USED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MOST_USED_VALUE
   * @generated
   * @ordered
   */
  MOST_USED(0, "MOST_USED", "Most Used");

  /**
   * The '<em><b>RECENTLY COLLECTED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RECENTLY COLLECTED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RECENTLY_COLLECTED
   * @model literal="Recently Collected"
   * @generated
   * @ordered
   */
  public static final int RECENTLY_COLLECTED_VALUE = 0;

  /**
   * The '<em><b>RECENTLY USED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RECENTLY USED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RECENTLY_USED
   * @model literal="Recently Used"
   * @generated
   * @ordered
   */
  public static final int RECENTLY_USED_VALUE = 0;

  /**
   * The '<em><b>MOST USED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MOST USED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MOST_USED
   * @model literal="Most Used"
   * @generated
   * @ordered
   */
  public static final int MOST_USED_VALUE = 0;

  /**
   * An array of all the '<em><b>Sort Method</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final SortMethod[] VALUES_ARRAY =
    new SortMethod[]
    {
      RECENTLY_COLLECTED,
      RECENTLY_USED,
      MOST_USED,
    };

  /**
   * A public read-only list of all the '<em><b>Sort Method</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<SortMethod> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Sort Method</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SortMethod get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SortMethod result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Sort Method</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SortMethod getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SortMethod result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Sort Method</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SortMethod get(int value)
  {
    switch (value)
    {
      case RECENTLY_COLLECTED_VALUE: return RECENTLY_COLLECTED;
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
  private SortMethod(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //SortMethod
