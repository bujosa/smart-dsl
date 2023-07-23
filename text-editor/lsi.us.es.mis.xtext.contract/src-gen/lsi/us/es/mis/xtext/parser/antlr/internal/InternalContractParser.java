package lsi.us.es.mis.xtext.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import lsi.us.es.mis.xtext.services.ContractGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContractParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Contract'", "'{'", "'version:'", "'hasReceive'", "'ownership'", "'}'", "'modifiable'", "'Modifier'", "'('", "','", "')'", "'message:'", "'validation:'", "'method'", "'stateMutability:'", "'->'", "'description:'", "'modifiers:'", "'events:'", "'event'", "'mapping'", "'fromType'", "'toType'", "'integer'", "'string'", "'boolean'", "'address'", "'array'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalContractParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContractParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContractParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContract.g"; }



     	private ContractGrammarAccess grammarAccess;

        public InternalContractParser(TokenStream input, ContractGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Contract";
       	}

       	@Override
       	protected ContractGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleContract"
    // InternalContract.g:65:1: entryRuleContract returns [EObject current=null] : iv_ruleContract= ruleContract EOF ;
    public final EObject entryRuleContract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContract = null;


        try {
            // InternalContract.g:65:49: (iv_ruleContract= ruleContract EOF )
            // InternalContract.g:66:2: iv_ruleContract= ruleContract EOF
            {
             newCompositeNode(grammarAccess.getContractRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContract=ruleContract();

            state._fsp--;

             current =iv_ruleContract; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContract"


    // $ANTLR start "ruleContract"
    // InternalContract.g:72:1: ruleContract returns [EObject current=null] : (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'version:' ( (lv_version_4_0= RULE_STRING ) ) ( (lv_hasReceive_5_0= 'hasReceive' ) )? ( (lv_ownership_6_0= 'ownership' ) )? ( ( (lv_attributes_7_0= ruleAttribute ) ) | ( (lv_events_8_0= ruleEvent ) ) | ( (lv_methods_9_0= ruleMethod ) ) | ( (lv_modifiers_10_0= ruleModifier ) ) | ( (lv_mappings_11_0= ruleMappingDeclaration ) ) )* otherlv_12= '}' ) ;
    public final EObject ruleContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_version_4_0=null;
        Token lv_hasReceive_5_0=null;
        Token lv_ownership_6_0=null;
        Token otherlv_12=null;
        EObject lv_attributes_7_0 = null;

        EObject lv_events_8_0 = null;

        EObject lv_methods_9_0 = null;

        EObject lv_modifiers_10_0 = null;

        EObject lv_mappings_11_0 = null;



        	enterRule();

        try {
            // InternalContract.g:78:2: ( (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'version:' ( (lv_version_4_0= RULE_STRING ) ) ( (lv_hasReceive_5_0= 'hasReceive' ) )? ( (lv_ownership_6_0= 'ownership' ) )? ( ( (lv_attributes_7_0= ruleAttribute ) ) | ( (lv_events_8_0= ruleEvent ) ) | ( (lv_methods_9_0= ruleMethod ) ) | ( (lv_modifiers_10_0= ruleModifier ) ) | ( (lv_mappings_11_0= ruleMappingDeclaration ) ) )* otherlv_12= '}' ) )
            // InternalContract.g:79:2: (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'version:' ( (lv_version_4_0= RULE_STRING ) ) ( (lv_hasReceive_5_0= 'hasReceive' ) )? ( (lv_ownership_6_0= 'ownership' ) )? ( ( (lv_attributes_7_0= ruleAttribute ) ) | ( (lv_events_8_0= ruleEvent ) ) | ( (lv_methods_9_0= ruleMethod ) ) | ( (lv_modifiers_10_0= ruleModifier ) ) | ( (lv_mappings_11_0= ruleMappingDeclaration ) ) )* otherlv_12= '}' )
            {
            // InternalContract.g:79:2: (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'version:' ( (lv_version_4_0= RULE_STRING ) ) ( (lv_hasReceive_5_0= 'hasReceive' ) )? ( (lv_ownership_6_0= 'ownership' ) )? ( ( (lv_attributes_7_0= ruleAttribute ) ) | ( (lv_events_8_0= ruleEvent ) ) | ( (lv_methods_9_0= ruleMethod ) ) | ( (lv_modifiers_10_0= ruleModifier ) ) | ( (lv_mappings_11_0= ruleMappingDeclaration ) ) )* otherlv_12= '}' )
            // InternalContract.g:80:3: otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'version:' ( (lv_version_4_0= RULE_STRING ) ) ( (lv_hasReceive_5_0= 'hasReceive' ) )? ( (lv_ownership_6_0= 'ownership' ) )? ( ( (lv_attributes_7_0= ruleAttribute ) ) | ( (lv_events_8_0= ruleEvent ) ) | ( (lv_methods_9_0= ruleMethod ) ) | ( (lv_modifiers_10_0= ruleModifier ) ) | ( (lv_mappings_11_0= ruleMappingDeclaration ) ) )* otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContractAccess().getContractKeyword_0());
            		
            // InternalContract.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getContractAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContractRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getContractAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getContractAccess().getVersionKeyword_3());
            		
            // InternalContract.g:110:3: ( (lv_version_4_0= RULE_STRING ) )
            // InternalContract.g:111:4: (lv_version_4_0= RULE_STRING )
            {
            // InternalContract.g:111:4: (lv_version_4_0= RULE_STRING )
            // InternalContract.g:112:5: lv_version_4_0= RULE_STRING
            {
            lv_version_4_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_version_4_0, grammarAccess.getContractAccess().getVersionSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContractRule());
            					}
            					setWithLastConsumed(
            						current,
            						"version",
            						lv_version_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalContract.g:128:3: ( (lv_hasReceive_5_0= 'hasReceive' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalContract.g:129:4: (lv_hasReceive_5_0= 'hasReceive' )
                    {
                    // InternalContract.g:129:4: (lv_hasReceive_5_0= 'hasReceive' )
                    // InternalContract.g:130:5: lv_hasReceive_5_0= 'hasReceive'
                    {
                    lv_hasReceive_5_0=(Token)match(input,14,FOLLOW_8); 

                    					newLeafNode(lv_hasReceive_5_0, grammarAccess.getContractAccess().getHasReceiveHasReceiveKeyword_5_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContractRule());
                    					}
                    					setWithLastConsumed(current, "hasReceive", lv_hasReceive_5_0 != null, "hasReceive");
                    				

                    }


                    }
                    break;

            }

            // InternalContract.g:142:3: ( (lv_ownership_6_0= 'ownership' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalContract.g:143:4: (lv_ownership_6_0= 'ownership' )
                    {
                    // InternalContract.g:143:4: (lv_ownership_6_0= 'ownership' )
                    // InternalContract.g:144:5: lv_ownership_6_0= 'ownership'
                    {
                    lv_ownership_6_0=(Token)match(input,15,FOLLOW_9); 

                    					newLeafNode(lv_ownership_6_0, grammarAccess.getContractAccess().getOwnershipOwnershipKeyword_6_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContractRule());
                    					}
                    					setWithLastConsumed(current, "ownership", lv_ownership_6_0 != null, "ownership");
                    				

                    }


                    }
                    break;

            }

            // InternalContract.g:156:3: ( ( (lv_attributes_7_0= ruleAttribute ) ) | ( (lv_events_8_0= ruleEvent ) ) | ( (lv_methods_9_0= ruleMethod ) ) | ( (lv_modifiers_10_0= ruleModifier ) ) | ( (lv_mappings_11_0= ruleMappingDeclaration ) ) )*
            loop3:
            do {
                int alt3=6;
                switch ( input.LA(1) ) {
                case RULE_ID:
                case 17:
                    {
                    alt3=1;
                    }
                    break;
                case 30:
                    {
                    alt3=2;
                    }
                    break;
                case 24:
                    {
                    alt3=3;
                    }
                    break;
                case 18:
                    {
                    alt3=4;
                    }
                    break;
                case 31:
                    {
                    alt3=5;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // InternalContract.g:157:4: ( (lv_attributes_7_0= ruleAttribute ) )
            	    {
            	    // InternalContract.g:157:4: ( (lv_attributes_7_0= ruleAttribute ) )
            	    // InternalContract.g:158:5: (lv_attributes_7_0= ruleAttribute )
            	    {
            	    // InternalContract.g:158:5: (lv_attributes_7_0= ruleAttribute )
            	    // InternalContract.g:159:6: lv_attributes_7_0= ruleAttribute
            	    {

            	    						newCompositeNode(grammarAccess.getContractAccess().getAttributesAttributeParserRuleCall_7_0_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_attributes_7_0=ruleAttribute();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContractRule());
            	    						}
            	    						add(
            	    							current,
            	    							"attributes",
            	    							lv_attributes_7_0,
            	    							"lsi.us.es.mis.xtext.Contract.Attribute");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalContract.g:177:4: ( (lv_events_8_0= ruleEvent ) )
            	    {
            	    // InternalContract.g:177:4: ( (lv_events_8_0= ruleEvent ) )
            	    // InternalContract.g:178:5: (lv_events_8_0= ruleEvent )
            	    {
            	    // InternalContract.g:178:5: (lv_events_8_0= ruleEvent )
            	    // InternalContract.g:179:6: lv_events_8_0= ruleEvent
            	    {

            	    						newCompositeNode(grammarAccess.getContractAccess().getEventsEventParserRuleCall_7_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_events_8_0=ruleEvent();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContractRule());
            	    						}
            	    						add(
            	    							current,
            	    							"events",
            	    							lv_events_8_0,
            	    							"lsi.us.es.mis.xtext.Contract.Event");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalContract.g:197:4: ( (lv_methods_9_0= ruleMethod ) )
            	    {
            	    // InternalContract.g:197:4: ( (lv_methods_9_0= ruleMethod ) )
            	    // InternalContract.g:198:5: (lv_methods_9_0= ruleMethod )
            	    {
            	    // InternalContract.g:198:5: (lv_methods_9_0= ruleMethod )
            	    // InternalContract.g:199:6: lv_methods_9_0= ruleMethod
            	    {

            	    						newCompositeNode(grammarAccess.getContractAccess().getMethodsMethodParserRuleCall_7_2_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_methods_9_0=ruleMethod();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContractRule());
            	    						}
            	    						add(
            	    							current,
            	    							"methods",
            	    							lv_methods_9_0,
            	    							"lsi.us.es.mis.xtext.Contract.Method");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalContract.g:217:4: ( (lv_modifiers_10_0= ruleModifier ) )
            	    {
            	    // InternalContract.g:217:4: ( (lv_modifiers_10_0= ruleModifier ) )
            	    // InternalContract.g:218:5: (lv_modifiers_10_0= ruleModifier )
            	    {
            	    // InternalContract.g:218:5: (lv_modifiers_10_0= ruleModifier )
            	    // InternalContract.g:219:6: lv_modifiers_10_0= ruleModifier
            	    {

            	    						newCompositeNode(grammarAccess.getContractAccess().getModifiersModifierParserRuleCall_7_3_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_modifiers_10_0=ruleModifier();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContractRule());
            	    						}
            	    						add(
            	    							current,
            	    							"modifiers",
            	    							lv_modifiers_10_0,
            	    							"lsi.us.es.mis.xtext.Contract.Modifier");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalContract.g:237:4: ( (lv_mappings_11_0= ruleMappingDeclaration ) )
            	    {
            	    // InternalContract.g:237:4: ( (lv_mappings_11_0= ruleMappingDeclaration ) )
            	    // InternalContract.g:238:5: (lv_mappings_11_0= ruleMappingDeclaration )
            	    {
            	    // InternalContract.g:238:5: (lv_mappings_11_0= ruleMappingDeclaration )
            	    // InternalContract.g:239:6: lv_mappings_11_0= ruleMappingDeclaration
            	    {

            	    						newCompositeNode(grammarAccess.getContractAccess().getMappingsMappingDeclarationParserRuleCall_7_4_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_mappings_11_0=ruleMappingDeclaration();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContractRule());
            	    						}
            	    						add(
            	    							current,
            	    							"mappings",
            	    							lv_mappings_11_0,
            	    							"lsi.us.es.mis.xtext.Contract.MappingDeclaration");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_12=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getContractAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContract"


    // $ANTLR start "entryRuleAttribute"
    // InternalContract.g:265:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalContract.g:265:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalContract.g:266:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalContract.g:272:1: ruleAttribute returns [EObject current=null] : ( ( (lv_modifiable_0_0= 'modifiable' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleDataType ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_modifiable_0_0=null;
        Token lv_name_1_0=null;
        Enumerator lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalContract.g:278:2: ( ( ( (lv_modifiable_0_0= 'modifiable' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleDataType ) ) ) )
            // InternalContract.g:279:2: ( ( (lv_modifiable_0_0= 'modifiable' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleDataType ) ) )
            {
            // InternalContract.g:279:2: ( ( (lv_modifiable_0_0= 'modifiable' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleDataType ) ) )
            // InternalContract.g:280:3: ( (lv_modifiable_0_0= 'modifiable' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleDataType ) )
            {
            // InternalContract.g:280:3: ( (lv_modifiable_0_0= 'modifiable' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalContract.g:281:4: (lv_modifiable_0_0= 'modifiable' )
                    {
                    // InternalContract.g:281:4: (lv_modifiable_0_0= 'modifiable' )
                    // InternalContract.g:282:5: lv_modifiable_0_0= 'modifiable'
                    {
                    lv_modifiable_0_0=(Token)match(input,17,FOLLOW_3); 

                    					newLeafNode(lv_modifiable_0_0, grammarAccess.getAttributeAccess().getModifiableModifiableKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "modifiable", lv_modifiable_0_0 != null, "modifiable");
                    				

                    }


                    }
                    break;

            }

            // InternalContract.g:294:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:295:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:295:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:296:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_1_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalContract.g:312:3: ( (lv_type_2_0= ruleDataType ) )
            // InternalContract.g:313:4: (lv_type_2_0= ruleDataType )
            {
            // InternalContract.g:313:4: (lv_type_2_0= ruleDataType )
            // InternalContract.g:314:5: lv_type_2_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getAttributeAccess().getTypeDataTypeEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_2_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAttributeRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"lsi.us.es.mis.xtext.Contract.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleModifier"
    // InternalContract.g:335:1: entryRuleModifier returns [EObject current=null] : iv_ruleModifier= ruleModifier EOF ;
    public final EObject entryRuleModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifier = null;


        try {
            // InternalContract.g:335:49: (iv_ruleModifier= ruleModifier EOF )
            // InternalContract.g:336:2: iv_ruleModifier= ruleModifier EOF
            {
             newCompositeNode(grammarAccess.getModifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModifier=ruleModifier();

            state._fsp--;

             current =iv_ruleModifier; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifier"


    // $ANTLR start "ruleModifier"
    // InternalContract.g:342:1: ruleModifier returns [EObject current=null] : (otherlv_0= 'Modifier' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'message:' ( (lv_message_9_0= RULE_STRING ) ) otherlv_10= 'validation:' ( (lv_validation_11_0= RULE_STRING ) ) otherlv_12= '}' ) ;
    public final EObject ruleModifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_message_9_0=null;
        Token otherlv_10=null;
        Token lv_validation_11_0=null;
        Token otherlv_12=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;



        	enterRule();

        try {
            // InternalContract.g:348:2: ( (otherlv_0= 'Modifier' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'message:' ( (lv_message_9_0= RULE_STRING ) ) otherlv_10= 'validation:' ( (lv_validation_11_0= RULE_STRING ) ) otherlv_12= '}' ) )
            // InternalContract.g:349:2: (otherlv_0= 'Modifier' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'message:' ( (lv_message_9_0= RULE_STRING ) ) otherlv_10= 'validation:' ( (lv_validation_11_0= RULE_STRING ) ) otherlv_12= '}' )
            {
            // InternalContract.g:349:2: (otherlv_0= 'Modifier' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'message:' ( (lv_message_9_0= RULE_STRING ) ) otherlv_10= 'validation:' ( (lv_validation_11_0= RULE_STRING ) ) otherlv_12= '}' )
            // InternalContract.g:350:3: otherlv_0= 'Modifier' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'message:' ( (lv_message_9_0= RULE_STRING ) ) otherlv_10= 'validation:' ( (lv_validation_11_0= RULE_STRING ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getModifierAccess().getModifierKeyword_0());
            		
            // InternalContract.g:354:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:355:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:355:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:356:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getModifierAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModifierRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getModifierAccess().getLeftParenthesisKeyword_2());
            		
            // InternalContract.g:376:3: ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalContract.g:377:4: ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    {
                    // InternalContract.g:377:4: ( (lv_params_3_0= ruleParam ) )
                    // InternalContract.g:378:5: (lv_params_3_0= ruleParam )
                    {
                    // InternalContract.g:378:5: (lv_params_3_0= ruleParam )
                    // InternalContract.g:379:6: lv_params_3_0= ruleParam
                    {

                    						newCompositeNode(grammarAccess.getModifierAccess().getParamsParamParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_params_3_0=ruleParam();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModifierRule());
                    						}
                    						add(
                    							current,
                    							"params",
                    							lv_params_3_0,
                    							"lsi.us.es.mis.xtext.Contract.Param");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:396:4: (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==20) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalContract.g:397:5: otherlv_4= ',' ( (lv_params_5_0= ruleParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getModifierAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalContract.g:401:5: ( (lv_params_5_0= ruleParam ) )
                    	    // InternalContract.g:402:6: (lv_params_5_0= ruleParam )
                    	    {
                    	    // InternalContract.g:402:6: (lv_params_5_0= ruleParam )
                    	    // InternalContract.g:403:7: lv_params_5_0= ruleParam
                    	    {

                    	    							newCompositeNode(grammarAccess.getModifierAccess().getParamsParamParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_params_5_0=ruleParam();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModifierRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"params",
                    	    								lv_params_5_0,
                    	    								"lsi.us.es.mis.xtext.Contract.Param");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getModifierAccess().getRightParenthesisKeyword_4());
            		
            otherlv_7=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_7, grammarAccess.getModifierAccess().getLeftCurlyBracketKeyword_5());
            		
            otherlv_8=(Token)match(input,22,FOLLOW_6); 

            			newLeafNode(otherlv_8, grammarAccess.getModifierAccess().getMessageKeyword_6());
            		
            // InternalContract.g:434:3: ( (lv_message_9_0= RULE_STRING ) )
            // InternalContract.g:435:4: (lv_message_9_0= RULE_STRING )
            {
            // InternalContract.g:435:4: (lv_message_9_0= RULE_STRING )
            // InternalContract.g:436:5: lv_message_9_0= RULE_STRING
            {
            lv_message_9_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

            					newLeafNode(lv_message_9_0, grammarAccess.getModifierAccess().getMessageSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModifierRule());
            					}
            					setWithLastConsumed(
            						current,
            						"message",
            						lv_message_9_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_10=(Token)match(input,23,FOLLOW_6); 

            			newLeafNode(otherlv_10, grammarAccess.getModifierAccess().getValidationKeyword_8());
            		
            // InternalContract.g:456:3: ( (lv_validation_11_0= RULE_STRING ) )
            // InternalContract.g:457:4: (lv_validation_11_0= RULE_STRING )
            {
            // InternalContract.g:457:4: (lv_validation_11_0= RULE_STRING )
            // InternalContract.g:458:5: lv_validation_11_0= RULE_STRING
            {
            lv_validation_11_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            					newLeafNode(lv_validation_11_0, grammarAccess.getModifierAccess().getValidationSTRINGTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModifierRule());
            					}
            					setWithLastConsumed(
            						current,
            						"validation",
            						lv_validation_11_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_12=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getModifierAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifier"


    // $ANTLR start "entryRuleMethod"
    // InternalContract.g:482:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // InternalContract.g:482:47: (iv_ruleMethod= ruleMethod EOF )
            // InternalContract.g:483:2: iv_ruleMethod= ruleMethod EOF
            {
             newCompositeNode(grammarAccess.getMethodRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethod=ruleMethod();

            state._fsp--;

             current =iv_ruleMethod; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethod"


    // $ANTLR start "ruleMethod"
    // InternalContract.g:489:1: ruleMethod returns [EObject current=null] : (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )? otherlv_9= '->' ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )? otherlv_13= '{' (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )? ( ( (lv_modifiersKeyword_16_0= 'modifiers:' ) ) ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )? ( ( (lv_eventsKeyword_20_0= 'events:' ) ) ( (otherlv_21= RULE_ID ) ) (otherlv_22= ',' ( (otherlv_23= RULE_ID ) ) )* )? otherlv_24= '}' ) ;
    public final EObject ruleMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_statemutability_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_description_15_0=null;
        Token lv_modifiersKeyword_16_0=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_eventsKeyword_20_0=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_outputs_10_0 = null;

        EObject lv_outputs_12_0 = null;



        	enterRule();

        try {
            // InternalContract.g:495:2: ( (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )? otherlv_9= '->' ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )? otherlv_13= '{' (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )? ( ( (lv_modifiersKeyword_16_0= 'modifiers:' ) ) ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )? ( ( (lv_eventsKeyword_20_0= 'events:' ) ) ( (otherlv_21= RULE_ID ) ) (otherlv_22= ',' ( (otherlv_23= RULE_ID ) ) )* )? otherlv_24= '}' ) )
            // InternalContract.g:496:2: (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )? otherlv_9= '->' ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )? otherlv_13= '{' (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )? ( ( (lv_modifiersKeyword_16_0= 'modifiers:' ) ) ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )? ( ( (lv_eventsKeyword_20_0= 'events:' ) ) ( (otherlv_21= RULE_ID ) ) (otherlv_22= ',' ( (otherlv_23= RULE_ID ) ) )* )? otherlv_24= '}' )
            {
            // InternalContract.g:496:2: (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )? otherlv_9= '->' ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )? otherlv_13= '{' (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )? ( ( (lv_modifiersKeyword_16_0= 'modifiers:' ) ) ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )? ( ( (lv_eventsKeyword_20_0= 'events:' ) ) ( (otherlv_21= RULE_ID ) ) (otherlv_22= ',' ( (otherlv_23= RULE_ID ) ) )* )? otherlv_24= '}' )
            // InternalContract.g:497:3: otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )? otherlv_9= '->' ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )? otherlv_13= '{' (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )? ( ( (lv_modifiersKeyword_16_0= 'modifiers:' ) ) ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )? ( ( (lv_eventsKeyword_20_0= 'events:' ) ) ( (otherlv_21= RULE_ID ) ) (otherlv_22= ',' ( (otherlv_23= RULE_ID ) ) )* )? otherlv_24= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMethodAccess().getMethodKeyword_0());
            		
            // InternalContract.g:501:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:502:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:502:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:503:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMethodRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2());
            		
            // InternalContract.g:523:3: ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalContract.g:524:4: ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    {
                    // InternalContract.g:524:4: ( (lv_params_3_0= ruleParam ) )
                    // InternalContract.g:525:5: (lv_params_3_0= ruleParam )
                    {
                    // InternalContract.g:525:5: (lv_params_3_0= ruleParam )
                    // InternalContract.g:526:6: lv_params_3_0= ruleParam
                    {

                    						newCompositeNode(grammarAccess.getMethodAccess().getParamsParamParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_params_3_0=ruleParam();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodRule());
                    						}
                    						add(
                    							current,
                    							"params",
                    							lv_params_3_0,
                    							"lsi.us.es.mis.xtext.Contract.Param");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:543:4: (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==20) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalContract.g:544:5: otherlv_4= ',' ( (lv_params_5_0= ruleParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalContract.g:548:5: ( (lv_params_5_0= ruleParam ) )
                    	    // InternalContract.g:549:6: (lv_params_5_0= ruleParam )
                    	    {
                    	    // InternalContract.g:549:6: (lv_params_5_0= ruleParam )
                    	    // InternalContract.g:550:7: lv_params_5_0= ruleParam
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodAccess().getParamsParamParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_params_5_0=ruleParam();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMethodRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"params",
                    	    								lv_params_5_0,
                    	    								"lsi.us.es.mis.xtext.Contract.Param");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_17); 

            			newLeafNode(otherlv_6, grammarAccess.getMethodAccess().getRightParenthesisKeyword_4());
            		
            // InternalContract.g:573:3: (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalContract.g:574:4: otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,25,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getMethodAccess().getStateMutabilityKeyword_5_0());
                    			
                    // InternalContract.g:578:4: ( (lv_statemutability_8_0= RULE_STRING ) )
                    // InternalContract.g:579:5: (lv_statemutability_8_0= RULE_STRING )
                    {
                    // InternalContract.g:579:5: (lv_statemutability_8_0= RULE_STRING )
                    // InternalContract.g:580:6: lv_statemutability_8_0= RULE_STRING
                    {
                    lv_statemutability_8_0=(Token)match(input,RULE_STRING,FOLLOW_18); 

                    						newLeafNode(lv_statemutability_8_0, grammarAccess.getMethodAccess().getStatemutabilitySTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMethodRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"statemutability",
                    							lv_statemutability_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,26,FOLLOW_19); 

            			newLeafNode(otherlv_9, grammarAccess.getMethodAccess().getHyphenMinusGreaterThanSignKeyword_6());
            		
            // InternalContract.g:601:3: ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalContract.g:602:4: ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )*
                    {
                    // InternalContract.g:602:4: ( (lv_outputs_10_0= ruleOutput ) )
                    // InternalContract.g:603:5: (lv_outputs_10_0= ruleOutput )
                    {
                    // InternalContract.g:603:5: (lv_outputs_10_0= ruleOutput )
                    // InternalContract.g:604:6: lv_outputs_10_0= ruleOutput
                    {

                    						newCompositeNode(grammarAccess.getMethodAccess().getOutputsOutputParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_outputs_10_0=ruleOutput();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodRule());
                    						}
                    						add(
                    							current,
                    							"outputs",
                    							lv_outputs_10_0,
                    							"lsi.us.es.mis.xtext.Contract.Output");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:621:4: (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==20) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalContract.g:622:5: otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) )
                    	    {
                    	    otherlv_11=(Token)match(input,20,FOLLOW_3); 

                    	    					newLeafNode(otherlv_11, grammarAccess.getMethodAccess().getCommaKeyword_7_1_0());
                    	    				
                    	    // InternalContract.g:626:5: ( (lv_outputs_12_0= ruleOutput ) )
                    	    // InternalContract.g:627:6: (lv_outputs_12_0= ruleOutput )
                    	    {
                    	    // InternalContract.g:627:6: (lv_outputs_12_0= ruleOutput )
                    	    // InternalContract.g:628:7: lv_outputs_12_0= ruleOutput
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodAccess().getOutputsOutputParserRuleCall_7_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_20);
                    	    lv_outputs_12_0=ruleOutput();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMethodRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"outputs",
                    	    								lv_outputs_12_0,
                    	    								"lsi.us.es.mis.xtext.Contract.Output");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,12,FOLLOW_21); 

            			newLeafNode(otherlv_13, grammarAccess.getMethodAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalContract.g:651:3: (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalContract.g:652:4: otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) )
                    {
                    otherlv_14=(Token)match(input,27,FOLLOW_6); 

                    				newLeafNode(otherlv_14, grammarAccess.getMethodAccess().getDescriptionKeyword_9_0());
                    			
                    // InternalContract.g:656:4: ( (lv_description_15_0= RULE_STRING ) )
                    // InternalContract.g:657:5: (lv_description_15_0= RULE_STRING )
                    {
                    // InternalContract.g:657:5: (lv_description_15_0= RULE_STRING )
                    // InternalContract.g:658:6: lv_description_15_0= RULE_STRING
                    {
                    lv_description_15_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

                    						newLeafNode(lv_description_15_0, grammarAccess.getMethodAccess().getDescriptionSTRINGTerminalRuleCall_9_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMethodRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_15_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalContract.g:675:3: ( ( (lv_modifiersKeyword_16_0= 'modifiers:' ) ) ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalContract.g:676:4: ( (lv_modifiersKeyword_16_0= 'modifiers:' ) ) ( (otherlv_17= RULE_ID ) ) (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )*
                    {
                    // InternalContract.g:676:4: ( (lv_modifiersKeyword_16_0= 'modifiers:' ) )
                    // InternalContract.g:677:5: (lv_modifiersKeyword_16_0= 'modifiers:' )
                    {
                    // InternalContract.g:677:5: (lv_modifiersKeyword_16_0= 'modifiers:' )
                    // InternalContract.g:678:6: lv_modifiersKeyword_16_0= 'modifiers:'
                    {
                    lv_modifiersKeyword_16_0=(Token)match(input,28,FOLLOW_3); 

                    						newLeafNode(lv_modifiersKeyword_16_0, grammarAccess.getMethodAccess().getModifiersKeywordModifiersKeyword_10_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMethodRule());
                    						}
                    						setWithLastConsumed(current, "modifiersKeyword", lv_modifiersKeyword_16_0, "modifiers:");
                    					

                    }


                    }

                    // InternalContract.g:690:4: ( (otherlv_17= RULE_ID ) )
                    // InternalContract.g:691:5: (otherlv_17= RULE_ID )
                    {
                    // InternalContract.g:691:5: (otherlv_17= RULE_ID )
                    // InternalContract.g:692:6: otherlv_17= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMethodRule());
                    						}
                    					
                    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_23); 

                    						newLeafNode(otherlv_17, grammarAccess.getMethodAccess().getModifiersModifierCrossReference_10_1_0());
                    					

                    }


                    }

                    // InternalContract.g:703:4: (otherlv_18= ',' ( (otherlv_19= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==20) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalContract.g:704:5: otherlv_18= ',' ( (otherlv_19= RULE_ID ) )
                    	    {
                    	    otherlv_18=(Token)match(input,20,FOLLOW_3); 

                    	    					newLeafNode(otherlv_18, grammarAccess.getMethodAccess().getCommaKeyword_10_2_0());
                    	    				
                    	    // InternalContract.g:708:5: ( (otherlv_19= RULE_ID ) )
                    	    // InternalContract.g:709:6: (otherlv_19= RULE_ID )
                    	    {
                    	    // InternalContract.g:709:6: (otherlv_19= RULE_ID )
                    	    // InternalContract.g:710:7: otherlv_19= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMethodRule());
                    	    							}
                    	    						
                    	    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_23); 

                    	    							newLeafNode(otherlv_19, grammarAccess.getMethodAccess().getModifiersModifierCrossReference_10_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalContract.g:723:3: ( ( (lv_eventsKeyword_20_0= 'events:' ) ) ( (otherlv_21= RULE_ID ) ) (otherlv_22= ',' ( (otherlv_23= RULE_ID ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==29) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalContract.g:724:4: ( (lv_eventsKeyword_20_0= 'events:' ) ) ( (otherlv_21= RULE_ID ) ) (otherlv_22= ',' ( (otherlv_23= RULE_ID ) ) )*
                    {
                    // InternalContract.g:724:4: ( (lv_eventsKeyword_20_0= 'events:' ) )
                    // InternalContract.g:725:5: (lv_eventsKeyword_20_0= 'events:' )
                    {
                    // InternalContract.g:725:5: (lv_eventsKeyword_20_0= 'events:' )
                    // InternalContract.g:726:6: lv_eventsKeyword_20_0= 'events:'
                    {
                    lv_eventsKeyword_20_0=(Token)match(input,29,FOLLOW_3); 

                    						newLeafNode(lv_eventsKeyword_20_0, grammarAccess.getMethodAccess().getEventsKeywordEventsKeyword_11_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMethodRule());
                    						}
                    						setWithLastConsumed(current, "eventsKeyword", lv_eventsKeyword_20_0, "events:");
                    					

                    }


                    }

                    // InternalContract.g:738:4: ( (otherlv_21= RULE_ID ) )
                    // InternalContract.g:739:5: (otherlv_21= RULE_ID )
                    {
                    // InternalContract.g:739:5: (otherlv_21= RULE_ID )
                    // InternalContract.g:740:6: otherlv_21= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMethodRule());
                    						}
                    					
                    otherlv_21=(Token)match(input,RULE_ID,FOLLOW_24); 

                    						newLeafNode(otherlv_21, grammarAccess.getMethodAccess().getEventsEventCrossReference_11_1_0());
                    					

                    }


                    }

                    // InternalContract.g:751:4: (otherlv_22= ',' ( (otherlv_23= RULE_ID ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==20) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalContract.g:752:5: otherlv_22= ',' ( (otherlv_23= RULE_ID ) )
                    	    {
                    	    otherlv_22=(Token)match(input,20,FOLLOW_3); 

                    	    					newLeafNode(otherlv_22, grammarAccess.getMethodAccess().getCommaKeyword_11_2_0());
                    	    				
                    	    // InternalContract.g:756:5: ( (otherlv_23= RULE_ID ) )
                    	    // InternalContract.g:757:6: (otherlv_23= RULE_ID )
                    	    {
                    	    // InternalContract.g:757:6: (otherlv_23= RULE_ID )
                    	    // InternalContract.g:758:7: otherlv_23= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getMethodRule());
                    	    							}
                    	    						
                    	    otherlv_23=(Token)match(input,RULE_ID,FOLLOW_24); 

                    	    							newLeafNode(otherlv_23, grammarAccess.getMethodAccess().getEventsEventCrossReference_11_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_24=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_24, grammarAccess.getMethodAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethod"


    // $ANTLR start "entryRuleEvent"
    // InternalContract.g:779:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalContract.g:779:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalContract.g:780:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalContract.g:786:1: ruleEvent returns [EObject current=null] : (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) otherlv_10= '}' ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_description_9_0=null;
        Token otherlv_10=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;



        	enterRule();

        try {
            // InternalContract.g:792:2: ( (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) otherlv_10= '}' ) )
            // InternalContract.g:793:2: (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) otherlv_10= '}' )
            {
            // InternalContract.g:793:2: (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) otherlv_10= '}' )
            // InternalContract.g:794:3: otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEventAccess().getEventKeyword_0());
            		
            // InternalContract.g:798:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:799:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:799:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:800:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getEventAccess().getLeftParenthesisKeyword_2());
            		
            // InternalContract.g:820:3: ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalContract.g:821:4: ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    {
                    // InternalContract.g:821:4: ( (lv_params_3_0= ruleParam ) )
                    // InternalContract.g:822:5: (lv_params_3_0= ruleParam )
                    {
                    // InternalContract.g:822:5: (lv_params_3_0= ruleParam )
                    // InternalContract.g:823:6: lv_params_3_0= ruleParam
                    {

                    						newCompositeNode(grammarAccess.getEventAccess().getParamsParamParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_params_3_0=ruleParam();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEventRule());
                    						}
                    						add(
                    							current,
                    							"params",
                    							lv_params_3_0,
                    							"lsi.us.es.mis.xtext.Contract.Param");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalContract.g:840:4: (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==20) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalContract.g:841:5: otherlv_4= ',' ( (lv_params_5_0= ruleParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getEventAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalContract.g:845:5: ( (lv_params_5_0= ruleParam ) )
                    	    // InternalContract.g:846:6: (lv_params_5_0= ruleParam )
                    	    {
                    	    // InternalContract.g:846:6: (lv_params_5_0= ruleParam )
                    	    // InternalContract.g:847:7: lv_params_5_0= ruleParam
                    	    {

                    	    							newCompositeNode(grammarAccess.getEventAccess().getParamsParamParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_params_5_0=ruleParam();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEventRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"params",
                    	    								lv_params_5_0,
                    	    								"lsi.us.es.mis.xtext.Contract.Param");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getEventAccess().getRightParenthesisKeyword_4());
            		
            otherlv_7=(Token)match(input,12,FOLLOW_25); 

            			newLeafNode(otherlv_7, grammarAccess.getEventAccess().getLeftCurlyBracketKeyword_5());
            		
            otherlv_8=(Token)match(input,27,FOLLOW_6); 

            			newLeafNode(otherlv_8, grammarAccess.getEventAccess().getDescriptionKeyword_6());
            		
            // InternalContract.g:878:3: ( (lv_description_9_0= RULE_STRING ) )
            // InternalContract.g:879:4: (lv_description_9_0= RULE_STRING )
            {
            // InternalContract.g:879:4: (lv_description_9_0= RULE_STRING )
            // InternalContract.g:880:5: lv_description_9_0= RULE_STRING
            {
            lv_description_9_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            					newLeafNode(lv_description_9_0, grammarAccess.getEventAccess().getDescriptionSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_9_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_10=(Token)match(input,16,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getEventAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleParam"
    // InternalContract.g:904:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // InternalContract.g:904:46: (iv_ruleParam= ruleParam EOF )
            // InternalContract.g:905:2: iv_ruleParam= ruleParam EOF
            {
             newCompositeNode(grammarAccess.getParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParam=ruleParam();

            state._fsp--;

             current =iv_ruleParam; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // InternalContract.g:911:1: ruleParam returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Enumerator lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalContract.g:917:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) ) )
            // InternalContract.g:918:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) )
            {
            // InternalContract.g:918:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) )
            // InternalContract.g:919:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) )
            {
            // InternalContract.g:919:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalContract.g:920:4: (lv_name_0_0= RULE_ID )
            {
            // InternalContract.g:920:4: (lv_name_0_0= RULE_ID )
            // InternalContract.g:921:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_0_0, grammarAccess.getParamAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getParamRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalContract.g:937:3: ( (lv_type_1_0= ruleDataType ) )
            // InternalContract.g:938:4: (lv_type_1_0= ruleDataType )
            {
            // InternalContract.g:938:4: (lv_type_1_0= ruleDataType )
            // InternalContract.g:939:5: lv_type_1_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getParamAccess().getTypeDataTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParamRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"lsi.us.es.mis.xtext.Contract.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleOutput"
    // InternalContract.g:960:1: entryRuleOutput returns [EObject current=null] : iv_ruleOutput= ruleOutput EOF ;
    public final EObject entryRuleOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutput = null;


        try {
            // InternalContract.g:960:47: (iv_ruleOutput= ruleOutput EOF )
            // InternalContract.g:961:2: iv_ruleOutput= ruleOutput EOF
            {
             newCompositeNode(grammarAccess.getOutputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutput=ruleOutput();

            state._fsp--;

             current =iv_ruleOutput; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutput"


    // $ANTLR start "ruleOutput"
    // InternalContract.g:967:1: ruleOutput returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) ) ;
    public final EObject ruleOutput() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Enumerator lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalContract.g:973:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) ) )
            // InternalContract.g:974:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) )
            {
            // InternalContract.g:974:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) )
            // InternalContract.g:975:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) )
            {
            // InternalContract.g:975:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalContract.g:976:4: (lv_name_0_0= RULE_ID )
            {
            // InternalContract.g:976:4: (lv_name_0_0= RULE_ID )
            // InternalContract.g:977:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            					newLeafNode(lv_name_0_0, grammarAccess.getOutputAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOutputRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalContract.g:993:3: ( (lv_type_1_0= ruleDataType ) )
            // InternalContract.g:994:4: (lv_type_1_0= ruleDataType )
            {
            // InternalContract.g:994:4: (lv_type_1_0= ruleDataType )
            // InternalContract.g:995:5: lv_type_1_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getOutputAccess().getTypeDataTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOutputRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"lsi.us.es.mis.xtext.Contract.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutput"


    // $ANTLR start "entryRuleMappingDeclaration"
    // InternalContract.g:1016:1: entryRuleMappingDeclaration returns [EObject current=null] : iv_ruleMappingDeclaration= ruleMappingDeclaration EOF ;
    public final EObject entryRuleMappingDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMappingDeclaration = null;


        try {
            // InternalContract.g:1016:59: (iv_ruleMappingDeclaration= ruleMappingDeclaration EOF )
            // InternalContract.g:1017:2: iv_ruleMappingDeclaration= ruleMappingDeclaration EOF
            {
             newCompositeNode(grammarAccess.getMappingDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMappingDeclaration=ruleMappingDeclaration();

            state._fsp--;

             current =iv_ruleMappingDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMappingDeclaration"


    // $ANTLR start "ruleMappingDeclaration"
    // InternalContract.g:1023:1: ruleMappingDeclaration returns [EObject current=null] : (otherlv_0= 'mapping' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'fromType' ( (lv_fromType_3_0= ruleDataType ) ) otherlv_4= 'toType' ( (lv_toType_5_0= ruleDataType ) ) ) ;
    public final EObject ruleMappingDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Enumerator lv_fromType_3_0 = null;

        Enumerator lv_toType_5_0 = null;



        	enterRule();

        try {
            // InternalContract.g:1029:2: ( (otherlv_0= 'mapping' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'fromType' ( (lv_fromType_3_0= ruleDataType ) ) otherlv_4= 'toType' ( (lv_toType_5_0= ruleDataType ) ) ) )
            // InternalContract.g:1030:2: (otherlv_0= 'mapping' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'fromType' ( (lv_fromType_3_0= ruleDataType ) ) otherlv_4= 'toType' ( (lv_toType_5_0= ruleDataType ) ) )
            {
            // InternalContract.g:1030:2: (otherlv_0= 'mapping' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'fromType' ( (lv_fromType_3_0= ruleDataType ) ) otherlv_4= 'toType' ( (lv_toType_5_0= ruleDataType ) ) )
            // InternalContract.g:1031:3: otherlv_0= 'mapping' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'fromType' ( (lv_fromType_3_0= ruleDataType ) ) otherlv_4= 'toType' ( (lv_toType_5_0= ruleDataType ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMappingDeclarationAccess().getMappingKeyword_0());
            		
            // InternalContract.g:1035:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:1036:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:1036:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:1037:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMappingDeclarationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMappingDeclarationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,32,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getMappingDeclarationAccess().getFromTypeKeyword_2());
            		
            // InternalContract.g:1057:3: ( (lv_fromType_3_0= ruleDataType ) )
            // InternalContract.g:1058:4: (lv_fromType_3_0= ruleDataType )
            {
            // InternalContract.g:1058:4: (lv_fromType_3_0= ruleDataType )
            // InternalContract.g:1059:5: lv_fromType_3_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getMappingDeclarationAccess().getFromTypeDataTypeEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_27);
            lv_fromType_3_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMappingDeclarationRule());
            					}
            					set(
            						current,
            						"fromType",
            						lv_fromType_3_0,
            						"lsi.us.es.mis.xtext.Contract.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getMappingDeclarationAccess().getToTypeKeyword_4());
            		
            // InternalContract.g:1080:3: ( (lv_toType_5_0= ruleDataType ) )
            // InternalContract.g:1081:4: (lv_toType_5_0= ruleDataType )
            {
            // InternalContract.g:1081:4: (lv_toType_5_0= ruleDataType )
            // InternalContract.g:1082:5: lv_toType_5_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getMappingDeclarationAccess().getToTypeDataTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_toType_5_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMappingDeclarationRule());
            					}
            					set(
            						current,
            						"toType",
            						lv_toType_5_0,
            						"lsi.us.es.mis.xtext.Contract.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMappingDeclaration"


    // $ANTLR start "ruleDataType"
    // InternalContract.g:1103:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'string' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'address' ) | (enumLiteral_4= 'array' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalContract.g:1109:2: ( ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'string' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'address' ) | (enumLiteral_4= 'array' ) ) )
            // InternalContract.g:1110:2: ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'string' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'address' ) | (enumLiteral_4= 'array' ) )
            {
            // InternalContract.g:1110:2: ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'string' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'address' ) | (enumLiteral_4= 'array' ) )
            int alt19=5;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt19=1;
                }
                break;
            case 35:
                {
                alt19=2;
                }
                break;
            case 36:
                {
                alt19=3;
                }
                break;
            case 37:
                {
                alt19=4;
                }
                break;
            case 38:
                {
                alt19=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalContract.g:1111:3: (enumLiteral_0= 'integer' )
                    {
                    // InternalContract.g:1111:3: (enumLiteral_0= 'integer' )
                    // InternalContract.g:1112:4: enumLiteral_0= 'integer'
                    {
                    enumLiteral_0=(Token)match(input,34,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getINTEGEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getINTEGEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:1119:3: (enumLiteral_1= 'string' )
                    {
                    // InternalContract.g:1119:3: (enumLiteral_1= 'string' )
                    // InternalContract.g:1120:4: enumLiteral_1= 'string'
                    {
                    enumLiteral_1=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getSTRINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getSTRINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalContract.g:1127:3: (enumLiteral_2= 'boolean' )
                    {
                    // InternalContract.g:1127:3: (enumLiteral_2= 'boolean' )
                    // InternalContract.g:1128:4: enumLiteral_2= 'boolean'
                    {
                    enumLiteral_2=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getBOOLEANEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getBOOLEANEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalContract.g:1135:3: (enumLiteral_3= 'address' )
                    {
                    // InternalContract.g:1135:3: (enumLiteral_3= 'address' )
                    // InternalContract.g:1136:4: enumLiteral_3= 'address'
                    {
                    enumLiteral_3=(Token)match(input,37,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getADDRESSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getADDRESSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalContract.g:1143:3: (enumLiteral_4= 'array' )
                    {
                    // InternalContract.g:1143:3: (enumLiteral_4= 'array' )
                    // InternalContract.g:1144:4: enumLiteral_4= 'array'
                    {
                    enumLiteral_4=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getArrayEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDataTypeAccess().getArrayEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000C107C010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000C1078010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000C1070010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000007C00000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000101000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000038010000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000030010000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020110000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200000000L});

}