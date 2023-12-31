/*
 * generated by Xtext 2.25.0
 */
package lsi.us.es.mis.xtext.serializer;

import com.google.inject.Inject;
import java.util.Set;
import lsi.us.es.mis.xtext.contract.Attribute;
import lsi.us.es.mis.xtext.contract.Contract;
import lsi.us.es.mis.xtext.contract.ContractPackage;
import lsi.us.es.mis.xtext.contract.DataStore;
import lsi.us.es.mis.xtext.contract.Event;
import lsi.us.es.mis.xtext.contract.Method;
import lsi.us.es.mis.xtext.contract.Param;
import lsi.us.es.mis.xtext.contract.Validator;
import lsi.us.es.mis.xtext.services.ContractGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ContractSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ContractGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ContractPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ContractPackage.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case ContractPackage.CONTRACT:
				sequence_Contract(context, (Contract) semanticObject); 
				return; 
			case ContractPackage.DATA_STORE:
				sequence_DataStore(context, (DataStore) semanticObject); 
				return; 
			case ContractPackage.EVENT:
				sequence_Event(context, (Event) semanticObject); 
				return; 
			case ContractPackage.METHOD:
				sequence_Method(context, (Method) semanticObject); 
				return; 
			case ContractPackage.PARAM:
				sequence_Param(context, (Param) semanticObject); 
				return; 
			case ContractPackage.VALIDATOR:
				sequence_Validator(context, (Validator) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Attribute returns Attribute
	 *
	 * Constraint:
	 *     (modifiable?='modifiable'? name=ID type=DataType)
	 */
	protected void sequence_Attribute(ISerializationContext context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Contract returns Contract
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         version=STRING 
	 *         hasReceive?='hasReceive'? 
	 *         ownership?='ownership'? 
	 *         (attributes+=Attribute | events+=Event | methods+=Method | validators+=Validator | dataStores+=DataStore)*
	 *     )
	 */
	protected void sequence_Contract(ISerializationContext context, Contract semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     DataStore returns DataStore
	 *
	 * Constraint:
	 *     (name=ID fromType=DataType toType=DataType)
	 */
	protected void sequence_DataStore(ISerializationContext context, DataStore semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.DATA_STORE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.DATA_STORE__NAME));
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.DATA_STORE__FROM_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.DATA_STORE__FROM_TYPE));
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.DATA_STORE__TO_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.DATA_STORE__TO_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDataStoreAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getDataStoreAccess().getFromTypeDataTypeEnumRuleCall_3_0(), semanticObject.getFromType());
		feeder.accept(grammarAccess.getDataStoreAccess().getToTypeDataTypeEnumRuleCall_5_0(), semanticObject.getToType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Event returns Event
	 *
	 * Constraint:
	 *     (name=ID (params+=Param params+=Param*)? description=STRING)
	 */
	protected void sequence_Event(ISerializationContext context, Event semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Method returns Method
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (params+=Param params+=Param*)? 
	 *         statemutability=STRING? 
	 *         (outputs+=Param outputs+=Param*)? 
	 *         description=STRING? 
	 *         (validators+=[Validator|ID] validators+=[Validator|ID]*)? 
	 *         (events+=[Event|ID] events+=[Event|ID]*)?
	 *     )
	 */
	protected void sequence_Method(ISerializationContext context, Method semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Param returns Param
	 *
	 * Constraint:
	 *     (name=ID type=DataType)
	 */
	protected void sequence_Param(ISerializationContext context, Param semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.PARAM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.PARAM__NAME));
			if (transientValues.isValueTransient(semanticObject, ContractPackage.Literals.PARAM__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContractPackage.Literals.PARAM__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getParamAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getParamAccess().getTypeDataTypeEnumRuleCall_1_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Validator returns Validator
	 *
	 * Constraint:
	 *     (name=ID (params+=Param params+=Param*)? message=STRING validation=STRING)
	 */
	protected void sequence_Validator(ISerializationContext context, Validator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
