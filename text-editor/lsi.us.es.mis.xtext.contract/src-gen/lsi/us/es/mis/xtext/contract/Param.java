/**
 * generated by Xtext 2.25.0
 */
package lsi.us.es.mis.xtext.contract;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lsi.us.es.mis.xtext.contract.Param#getName <em>Name</em>}</li>
 *   <li>{@link lsi.us.es.mis.xtext.contract.Param#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see lsi.us.es.mis.xtext.contract.ContractPackage#getParam()
 * @model
 * @generated
 */
public interface Param extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see lsi.us.es.mis.xtext.contract.ContractPackage#getParam_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link lsi.us.es.mis.xtext.contract.Param#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link lsi.us.es.mis.xtext.contract.DataType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see lsi.us.es.mis.xtext.contract.DataType
   * @see #setType(DataType)
   * @see lsi.us.es.mis.xtext.contract.ContractPackage#getParam_Type()
   * @model
   * @generated
   */
  DataType getType();

  /**
   * Sets the value of the '{@link lsi.us.es.mis.xtext.contract.Param#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see lsi.us.es.mis.xtext.contract.DataType
   * @see #getType()
   * @generated
   */
  void setType(DataType value);

} // Param
