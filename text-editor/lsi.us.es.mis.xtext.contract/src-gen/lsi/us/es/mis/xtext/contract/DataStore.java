/**
 * generated by Xtext 2.25.0
 */
package lsi.us.es.mis.xtext.contract;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lsi.us.es.mis.xtext.contract.DataStore#getName <em>Name</em>}</li>
 *   <li>{@link lsi.us.es.mis.xtext.contract.DataStore#getFromType <em>From Type</em>}</li>
 *   <li>{@link lsi.us.es.mis.xtext.contract.DataStore#getToType <em>To Type</em>}</li>
 * </ul>
 *
 * @see lsi.us.es.mis.xtext.contract.ContractPackage#getDataStore()
 * @model
 * @generated
 */
public interface DataStore extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see lsi.us.es.mis.xtext.contract.ContractPackage#getDataStore_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link lsi.us.es.mis.xtext.contract.DataStore#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>From Type</b></em>' attribute.
   * The literals are from the enumeration {@link lsi.us.es.mis.xtext.contract.DataType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>From Type</em>' attribute.
   * @see lsi.us.es.mis.xtext.contract.DataType
   * @see #setFromType(DataType)
   * @see lsi.us.es.mis.xtext.contract.ContractPackage#getDataStore_FromType()
   * @model
   * @generated
   */
  DataType getFromType();

  /**
   * Sets the value of the '{@link lsi.us.es.mis.xtext.contract.DataStore#getFromType <em>From Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From Type</em>' attribute.
   * @see lsi.us.es.mis.xtext.contract.DataType
   * @see #getFromType()
   * @generated
   */
  void setFromType(DataType value);

  /**
   * Returns the value of the '<em><b>To Type</b></em>' attribute.
   * The literals are from the enumeration {@link lsi.us.es.mis.xtext.contract.DataType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Type</em>' attribute.
   * @see lsi.us.es.mis.xtext.contract.DataType
   * @see #setToType(DataType)
   * @see lsi.us.es.mis.xtext.contract.ContractPackage#getDataStore_ToType()
   * @model
   * @generated
   */
  DataType getToType();

  /**
   * Sets the value of the '{@link lsi.us.es.mis.xtext.contract.DataStore#getToType <em>To Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Type</em>' attribute.
   * @see lsi.us.es.mis.xtext.contract.DataType
   * @see #getToType()
   * @generated
   */
  void setToType(DataType value);

} // DataStore
