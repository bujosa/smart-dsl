/*
 * generated by Xtext 2.25.0
 */
package lsi.us.es.mis.xtext.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import lsi.us.es.mis.xtext.ide.contentassist.antlr.internal.InternalContractParser;
import lsi.us.es.mis.xtext.services.ContractGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class ContractParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ContractGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ContractGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getContractAccess().getAlternatives_7(), "rule__Contract__Alternatives_7");
			builder.put(grammarAccess.getDataTypeAccess().getAlternatives(), "rule__DataType__Alternatives");
			builder.put(grammarAccess.getContractAccess().getGroup(), "rule__Contract__Group__0");
			builder.put(grammarAccess.getAttributeAccess().getGroup(), "rule__Attribute__Group__0");
			builder.put(grammarAccess.getValidatorAccess().getGroup(), "rule__Validator__Group__0");
			builder.put(grammarAccess.getValidatorAccess().getGroup_3(), "rule__Validator__Group_3__0");
			builder.put(grammarAccess.getValidatorAccess().getGroup_3_1(), "rule__Validator__Group_3_1__0");
			builder.put(grammarAccess.getMethodAccess().getGroup(), "rule__Method__Group__0");
			builder.put(grammarAccess.getMethodAccess().getGroup_3(), "rule__Method__Group_3__0");
			builder.put(grammarAccess.getMethodAccess().getGroup_3_1(), "rule__Method__Group_3_1__0");
			builder.put(grammarAccess.getMethodAccess().getGroup_5(), "rule__Method__Group_5__0");
			builder.put(grammarAccess.getMethodAccess().getGroup_7(), "rule__Method__Group_7__0");
			builder.put(grammarAccess.getMethodAccess().getGroup_7_1(), "rule__Method__Group_7_1__0");
			builder.put(grammarAccess.getMethodAccess().getGroup_9(), "rule__Method__Group_9__0");
			builder.put(grammarAccess.getMethodAccess().getGroup_10(), "rule__Method__Group_10__0");
			builder.put(grammarAccess.getMethodAccess().getGroup_10_2(), "rule__Method__Group_10_2__0");
			builder.put(grammarAccess.getMethodAccess().getGroup_11(), "rule__Method__Group_11__0");
			builder.put(grammarAccess.getMethodAccess().getGroup_11_2(), "rule__Method__Group_11_2__0");
			builder.put(grammarAccess.getEventAccess().getGroup(), "rule__Event__Group__0");
			builder.put(grammarAccess.getEventAccess().getGroup_3(), "rule__Event__Group_3__0");
			builder.put(grammarAccess.getEventAccess().getGroup_3_1(), "rule__Event__Group_3_1__0");
			builder.put(grammarAccess.getParamAccess().getGroup(), "rule__Param__Group__0");
			builder.put(grammarAccess.getDataStoreAccess().getGroup(), "rule__DataStore__Group__0");
			builder.put(grammarAccess.getContractAccess().getNameAssignment_1(), "rule__Contract__NameAssignment_1");
			builder.put(grammarAccess.getContractAccess().getVersionAssignment_4(), "rule__Contract__VersionAssignment_4");
			builder.put(grammarAccess.getContractAccess().getHasReceiveAssignment_5(), "rule__Contract__HasReceiveAssignment_5");
			builder.put(grammarAccess.getContractAccess().getOwnershipAssignment_6(), "rule__Contract__OwnershipAssignment_6");
			builder.put(grammarAccess.getContractAccess().getAttributesAssignment_7_0(), "rule__Contract__AttributesAssignment_7_0");
			builder.put(grammarAccess.getContractAccess().getEventsAssignment_7_1(), "rule__Contract__EventsAssignment_7_1");
			builder.put(grammarAccess.getContractAccess().getMethodsAssignment_7_2(), "rule__Contract__MethodsAssignment_7_2");
			builder.put(grammarAccess.getContractAccess().getValidatorsAssignment_7_3(), "rule__Contract__ValidatorsAssignment_7_3");
			builder.put(grammarAccess.getContractAccess().getDataStoresAssignment_7_4(), "rule__Contract__DataStoresAssignment_7_4");
			builder.put(grammarAccess.getAttributeAccess().getModifiableAssignment_0(), "rule__Attribute__ModifiableAssignment_0");
			builder.put(grammarAccess.getAttributeAccess().getNameAssignment_1(), "rule__Attribute__NameAssignment_1");
			builder.put(grammarAccess.getAttributeAccess().getTypeAssignment_2(), "rule__Attribute__TypeAssignment_2");
			builder.put(grammarAccess.getValidatorAccess().getNameAssignment_1(), "rule__Validator__NameAssignment_1");
			builder.put(grammarAccess.getValidatorAccess().getParamsAssignment_3_0(), "rule__Validator__ParamsAssignment_3_0");
			builder.put(grammarAccess.getValidatorAccess().getParamsAssignment_3_1_1(), "rule__Validator__ParamsAssignment_3_1_1");
			builder.put(grammarAccess.getValidatorAccess().getMessageAssignment_7(), "rule__Validator__MessageAssignment_7");
			builder.put(grammarAccess.getValidatorAccess().getValidationAssignment_9(), "rule__Validator__ValidationAssignment_9");
			builder.put(grammarAccess.getMethodAccess().getNameAssignment_1(), "rule__Method__NameAssignment_1");
			builder.put(grammarAccess.getMethodAccess().getParamsAssignment_3_0(), "rule__Method__ParamsAssignment_3_0");
			builder.put(grammarAccess.getMethodAccess().getParamsAssignment_3_1_1(), "rule__Method__ParamsAssignment_3_1_1");
			builder.put(grammarAccess.getMethodAccess().getStatemutabilityAssignment_5_1(), "rule__Method__StatemutabilityAssignment_5_1");
			builder.put(grammarAccess.getMethodAccess().getOutputsAssignment_7_0(), "rule__Method__OutputsAssignment_7_0");
			builder.put(grammarAccess.getMethodAccess().getOutputsAssignment_7_1_1(), "rule__Method__OutputsAssignment_7_1_1");
			builder.put(grammarAccess.getMethodAccess().getDescriptionAssignment_9_1(), "rule__Method__DescriptionAssignment_9_1");
			builder.put(grammarAccess.getMethodAccess().getValidatorsAssignment_10_1(), "rule__Method__ValidatorsAssignment_10_1");
			builder.put(grammarAccess.getMethodAccess().getValidatorsAssignment_10_2_1(), "rule__Method__ValidatorsAssignment_10_2_1");
			builder.put(grammarAccess.getMethodAccess().getEventsAssignment_11_1(), "rule__Method__EventsAssignment_11_1");
			builder.put(grammarAccess.getMethodAccess().getEventsAssignment_11_2_1(), "rule__Method__EventsAssignment_11_2_1");
			builder.put(grammarAccess.getEventAccess().getNameAssignment_1(), "rule__Event__NameAssignment_1");
			builder.put(grammarAccess.getEventAccess().getParamsAssignment_3_0(), "rule__Event__ParamsAssignment_3_0");
			builder.put(grammarAccess.getEventAccess().getParamsAssignment_3_1_1(), "rule__Event__ParamsAssignment_3_1_1");
			builder.put(grammarAccess.getEventAccess().getDescriptionAssignment_7(), "rule__Event__DescriptionAssignment_7");
			builder.put(grammarAccess.getParamAccess().getNameAssignment_0(), "rule__Param__NameAssignment_0");
			builder.put(grammarAccess.getParamAccess().getTypeAssignment_1(), "rule__Param__TypeAssignment_1");
			builder.put(grammarAccess.getDataStoreAccess().getNameAssignment_1(), "rule__DataStore__NameAssignment_1");
			builder.put(grammarAccess.getDataStoreAccess().getFromTypeAssignment_3(), "rule__DataStore__FromTypeAssignment_3");
			builder.put(grammarAccess.getDataStoreAccess().getToTypeAssignment_5(), "rule__DataStore__ToTypeAssignment_5");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ContractGrammarAccess grammarAccess;

	@Override
	protected InternalContractParser createParser() {
		InternalContractParser result = new InternalContractParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public ContractGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ContractGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}