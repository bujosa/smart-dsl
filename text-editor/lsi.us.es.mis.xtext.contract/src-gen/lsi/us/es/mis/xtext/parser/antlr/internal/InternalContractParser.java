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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Contract'", "'{'", "'version:'", "'}'", "'modifiable'", "'method'", "'('", "','", "')'", "'stateMutability:'", "'->'", "'description:'", "'event'", "'integer'", "'string'", "'boolean'", "'address'", "'array'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
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
    // InternalContract.g:72:1: ruleContract returns [EObject current=null] : (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'version:' ( (lv_version_4_0= RULE_STRING ) ) ( ( (lv_attributes_5_0= ruleAttribute ) ) | ( (lv_events_6_0= ruleEvent ) ) | ( (lv_methods_7_0= ruleMethod ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_version_4_0=null;
        Token otherlv_8=null;
        EObject lv_attributes_5_0 = null;

        EObject lv_events_6_0 = null;

        EObject lv_methods_7_0 = null;



        	enterRule();

        try {
            // InternalContract.g:78:2: ( (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'version:' ( (lv_version_4_0= RULE_STRING ) ) ( ( (lv_attributes_5_0= ruleAttribute ) ) | ( (lv_events_6_0= ruleEvent ) ) | ( (lv_methods_7_0= ruleMethod ) ) )* otherlv_8= '}' ) )
            // InternalContract.g:79:2: (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'version:' ( (lv_version_4_0= RULE_STRING ) ) ( ( (lv_attributes_5_0= ruleAttribute ) ) | ( (lv_events_6_0= ruleEvent ) ) | ( (lv_methods_7_0= ruleMethod ) ) )* otherlv_8= '}' )
            {
            // InternalContract.g:79:2: (otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'version:' ( (lv_version_4_0= RULE_STRING ) ) ( ( (lv_attributes_5_0= ruleAttribute ) ) | ( (lv_events_6_0= ruleEvent ) ) | ( (lv_methods_7_0= ruleMethod ) ) )* otherlv_8= '}' )
            // InternalContract.g:80:3: otherlv_0= 'Contract' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'version:' ( (lv_version_4_0= RULE_STRING ) ) ( ( (lv_attributes_5_0= ruleAttribute ) ) | ( (lv_events_6_0= ruleEvent ) ) | ( (lv_methods_7_0= ruleMethod ) ) )* otherlv_8= '}'
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

            // InternalContract.g:128:3: ( ( (lv_attributes_5_0= ruleAttribute ) ) | ( (lv_events_6_0= ruleEvent ) ) | ( (lv_methods_7_0= ruleMethod ) ) )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case RULE_ID:
                case 15:
                    {
                    alt1=1;
                    }
                    break;
                case 23:
                    {
                    alt1=2;
                    }
                    break;
                case 16:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // InternalContract.g:129:4: ( (lv_attributes_5_0= ruleAttribute ) )
            	    {
            	    // InternalContract.g:129:4: ( (lv_attributes_5_0= ruleAttribute ) )
            	    // InternalContract.g:130:5: (lv_attributes_5_0= ruleAttribute )
            	    {
            	    // InternalContract.g:130:5: (lv_attributes_5_0= ruleAttribute )
            	    // InternalContract.g:131:6: lv_attributes_5_0= ruleAttribute
            	    {

            	    						newCompositeNode(grammarAccess.getContractAccess().getAttributesAttributeParserRuleCall_5_0_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_attributes_5_0=ruleAttribute();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContractRule());
            	    						}
            	    						add(
            	    							current,
            	    							"attributes",
            	    							lv_attributes_5_0,
            	    							"lsi.us.es.mis.xtext.Contract.Attribute");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalContract.g:149:4: ( (lv_events_6_0= ruleEvent ) )
            	    {
            	    // InternalContract.g:149:4: ( (lv_events_6_0= ruleEvent ) )
            	    // InternalContract.g:150:5: (lv_events_6_0= ruleEvent )
            	    {
            	    // InternalContract.g:150:5: (lv_events_6_0= ruleEvent )
            	    // InternalContract.g:151:6: lv_events_6_0= ruleEvent
            	    {

            	    						newCompositeNode(grammarAccess.getContractAccess().getEventsEventParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_events_6_0=ruleEvent();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContractRule());
            	    						}
            	    						add(
            	    							current,
            	    							"events",
            	    							lv_events_6_0,
            	    							"lsi.us.es.mis.xtext.Contract.Event");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalContract.g:169:4: ( (lv_methods_7_0= ruleMethod ) )
            	    {
            	    // InternalContract.g:169:4: ( (lv_methods_7_0= ruleMethod ) )
            	    // InternalContract.g:170:5: (lv_methods_7_0= ruleMethod )
            	    {
            	    // InternalContract.g:170:5: (lv_methods_7_0= ruleMethod )
            	    // InternalContract.g:171:6: lv_methods_7_0= ruleMethod
            	    {

            	    						newCompositeNode(grammarAccess.getContractAccess().getMethodsMethodParserRuleCall_5_2_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_methods_7_0=ruleMethod();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContractRule());
            	    						}
            	    						add(
            	    							current,
            	    							"methods",
            	    							lv_methods_7_0,
            	    							"lsi.us.es.mis.xtext.Contract.Method");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_8=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getContractAccess().getRightCurlyBracketKeyword_6());
            		

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
    // InternalContract.g:197:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalContract.g:197:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalContract.g:198:2: iv_ruleAttribute= ruleAttribute EOF
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
    // InternalContract.g:204:1: ruleAttribute returns [EObject current=null] : ( ( (lv_modifiable_0_0= 'modifiable' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleDataType ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_modifiable_0_0=null;
        Token lv_name_1_0=null;
        Enumerator lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalContract.g:210:2: ( ( ( (lv_modifiable_0_0= 'modifiable' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleDataType ) ) ) )
            // InternalContract.g:211:2: ( ( (lv_modifiable_0_0= 'modifiable' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleDataType ) ) )
            {
            // InternalContract.g:211:2: ( ( (lv_modifiable_0_0= 'modifiable' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleDataType ) ) )
            // InternalContract.g:212:3: ( (lv_modifiable_0_0= 'modifiable' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleDataType ) )
            {
            // InternalContract.g:212:3: ( (lv_modifiable_0_0= 'modifiable' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalContract.g:213:4: (lv_modifiable_0_0= 'modifiable' )
                    {
                    // InternalContract.g:213:4: (lv_modifiable_0_0= 'modifiable' )
                    // InternalContract.g:214:5: lv_modifiable_0_0= 'modifiable'
                    {
                    lv_modifiable_0_0=(Token)match(input,15,FOLLOW_3); 

                    					newLeafNode(lv_modifiable_0_0, grammarAccess.getAttributeAccess().getModifiableModifiableKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getAttributeRule());
                    					}
                    					setWithLastConsumed(current, "modifiable", lv_modifiable_0_0 != null, "modifiable");
                    				

                    }


                    }
                    break;

            }

            // InternalContract.g:226:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:227:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:227:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:228:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            // InternalContract.g:244:3: ( (lv_type_2_0= ruleDataType ) )
            // InternalContract.g:245:4: (lv_type_2_0= ruleDataType )
            {
            // InternalContract.g:245:4: (lv_type_2_0= ruleDataType )
            // InternalContract.g:246:5: lv_type_2_0= ruleDataType
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


    // $ANTLR start "entryRuleMethod"
    // InternalContract.g:267:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // InternalContract.g:267:47: (iv_ruleMethod= ruleMethod EOF )
            // InternalContract.g:268:2: iv_ruleMethod= ruleMethod EOF
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
    // InternalContract.g:274:1: ruleMethod returns [EObject current=null] : (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )? otherlv_9= '->' ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )? otherlv_13= '{' (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) ;
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
        Token otherlv_16=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_outputs_10_0 = null;

        EObject lv_outputs_12_0 = null;



        	enterRule();

        try {
            // InternalContract.g:280:2: ( (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )? otherlv_9= '->' ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )? otherlv_13= '{' (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )? otherlv_16= '}' ) )
            // InternalContract.g:281:2: (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )? otherlv_9= '->' ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )? otherlv_13= '{' (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            {
            // InternalContract.g:281:2: (otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )? otherlv_9= '->' ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )? otherlv_13= '{' (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )? otherlv_16= '}' )
            // InternalContract.g:282:3: otherlv_0= 'method' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )? otherlv_9= '->' ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )? otherlv_13= '{' (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )? otherlv_16= '}'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMethodAccess().getMethodKeyword_0());
            		
            // InternalContract.g:286:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:287:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:287:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:288:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2());
            		
            // InternalContract.g:308:3: ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalContract.g:309:4: ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    {
                    // InternalContract.g:309:4: ( (lv_params_3_0= ruleParam ) )
                    // InternalContract.g:310:5: (lv_params_3_0= ruleParam )
                    {
                    // InternalContract.g:310:5: (lv_params_3_0= ruleParam )
                    // InternalContract.g:311:6: lv_params_3_0= ruleParam
                    {

                    						newCompositeNode(grammarAccess.getMethodAccess().getParamsParamParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    // InternalContract.g:328:4: (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==18) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalContract.g:329:5: otherlv_4= ',' ( (lv_params_5_0= ruleParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,18,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalContract.g:333:5: ( (lv_params_5_0= ruleParam ) )
                    	    // InternalContract.g:334:6: (lv_params_5_0= ruleParam )
                    	    {
                    	    // InternalContract.g:334:6: (lv_params_5_0= ruleParam )
                    	    // InternalContract.g:335:7: lv_params_5_0= ruleParam
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodAccess().getParamsParamParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
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
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FOLLOW_12); 

            			newLeafNode(otherlv_6, grammarAccess.getMethodAccess().getRightParenthesisKeyword_4());
            		
            // InternalContract.g:358:3: (otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalContract.g:359:4: otherlv_7= 'stateMutability:' ( (lv_statemutability_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getMethodAccess().getStateMutabilityKeyword_5_0());
                    			
                    // InternalContract.g:363:4: ( (lv_statemutability_8_0= RULE_STRING ) )
                    // InternalContract.g:364:5: (lv_statemutability_8_0= RULE_STRING )
                    {
                    // InternalContract.g:364:5: (lv_statemutability_8_0= RULE_STRING )
                    // InternalContract.g:365:6: lv_statemutability_8_0= RULE_STRING
                    {
                    lv_statemutability_8_0=(Token)match(input,RULE_STRING,FOLLOW_13); 

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

            otherlv_9=(Token)match(input,21,FOLLOW_14); 

            			newLeafNode(otherlv_9, grammarAccess.getMethodAccess().getHyphenMinusGreaterThanSignKeyword_6());
            		
            // InternalContract.g:386:3: ( ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalContract.g:387:4: ( (lv_outputs_10_0= ruleOutput ) ) (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )*
                    {
                    // InternalContract.g:387:4: ( (lv_outputs_10_0= ruleOutput ) )
                    // InternalContract.g:388:5: (lv_outputs_10_0= ruleOutput )
                    {
                    // InternalContract.g:388:5: (lv_outputs_10_0= ruleOutput )
                    // InternalContract.g:389:6: lv_outputs_10_0= ruleOutput
                    {

                    						newCompositeNode(grammarAccess.getMethodAccess().getOutputsOutputParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_15);
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

                    // InternalContract.g:406:4: (otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==18) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalContract.g:407:5: otherlv_11= ',' ( (lv_outputs_12_0= ruleOutput ) )
                    	    {
                    	    otherlv_11=(Token)match(input,18,FOLLOW_3); 

                    	    					newLeafNode(otherlv_11, grammarAccess.getMethodAccess().getCommaKeyword_7_1_0());
                    	    				
                    	    // InternalContract.g:411:5: ( (lv_outputs_12_0= ruleOutput ) )
                    	    // InternalContract.g:412:6: (lv_outputs_12_0= ruleOutput )
                    	    {
                    	    // InternalContract.g:412:6: (lv_outputs_12_0= ruleOutput )
                    	    // InternalContract.g:413:7: lv_outputs_12_0= ruleOutput
                    	    {

                    	    							newCompositeNode(grammarAccess.getMethodAccess().getOutputsOutputParserRuleCall_7_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_15);
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
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_13, grammarAccess.getMethodAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalContract.g:436:3: (otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalContract.g:437:4: otherlv_14= 'description:' ( (lv_description_15_0= RULE_STRING ) )
                    {
                    otherlv_14=(Token)match(input,22,FOLLOW_6); 

                    				newLeafNode(otherlv_14, grammarAccess.getMethodAccess().getDescriptionKeyword_9_0());
                    			
                    // InternalContract.g:441:4: ( (lv_description_15_0= RULE_STRING ) )
                    // InternalContract.g:442:5: (lv_description_15_0= RULE_STRING )
                    {
                    // InternalContract.g:442:5: (lv_description_15_0= RULE_STRING )
                    // InternalContract.g:443:6: lv_description_15_0= RULE_STRING
                    {
                    lv_description_15_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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

            otherlv_16=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getMethodAccess().getRightCurlyBracketKeyword_10());
            		

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
    // InternalContract.g:468:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalContract.g:468:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalContract.g:469:2: iv_ruleEvent= ruleEvent EOF
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
    // InternalContract.g:475:1: ruleEvent returns [EObject current=null] : (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) otherlv_10= '}' ) ;
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
            // InternalContract.g:481:2: ( (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) otherlv_10= '}' ) )
            // InternalContract.g:482:2: (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) otherlv_10= '}' )
            {
            // InternalContract.g:482:2: (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) otherlv_10= '}' )
            // InternalContract.g:483:3: otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= 'description:' ( (lv_description_9_0= RULE_STRING ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEventAccess().getEventKeyword_0());
            		
            // InternalContract.g:487:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalContract.g:488:4: (lv_name_1_0= RULE_ID )
            {
            // InternalContract.g:488:4: (lv_name_1_0= RULE_ID )
            // InternalContract.g:489:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); 

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

            otherlv_2=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getEventAccess().getLeftParenthesisKeyword_2());
            		
            // InternalContract.g:509:3: ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalContract.g:510:4: ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    {
                    // InternalContract.g:510:4: ( (lv_params_3_0= ruleParam ) )
                    // InternalContract.g:511:5: (lv_params_3_0= ruleParam )
                    {
                    // InternalContract.g:511:5: (lv_params_3_0= ruleParam )
                    // InternalContract.g:512:6: lv_params_3_0= ruleParam
                    {

                    						newCompositeNode(grammarAccess.getEventAccess().getParamsParamParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_11);
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

                    // InternalContract.g:529:4: (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==18) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalContract.g:530:5: otherlv_4= ',' ( (lv_params_5_0= ruleParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,18,FOLLOW_3); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getEventAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalContract.g:534:5: ( (lv_params_5_0= ruleParam ) )
                    	    // InternalContract.g:535:6: (lv_params_5_0= ruleParam )
                    	    {
                    	    // InternalContract.g:535:6: (lv_params_5_0= ruleParam )
                    	    // InternalContract.g:536:7: lv_params_5_0= ruleParam
                    	    {

                    	    							newCompositeNode(grammarAccess.getEventAccess().getParamsParamParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_11);
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
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getEventAccess().getRightParenthesisKeyword_4());
            		
            otherlv_7=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_7, grammarAccess.getEventAccess().getLeftCurlyBracketKeyword_5());
            		
            otherlv_8=(Token)match(input,22,FOLLOW_6); 

            			newLeafNode(otherlv_8, grammarAccess.getEventAccess().getDescriptionKeyword_6());
            		
            // InternalContract.g:567:3: ( (lv_description_9_0= RULE_STRING ) )
            // InternalContract.g:568:4: (lv_description_9_0= RULE_STRING )
            {
            // InternalContract.g:568:4: (lv_description_9_0= RULE_STRING )
            // InternalContract.g:569:5: lv_description_9_0= RULE_STRING
            {
            lv_description_9_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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

            otherlv_10=(Token)match(input,14,FOLLOW_2); 

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
    // InternalContract.g:593:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // InternalContract.g:593:46: (iv_ruleParam= ruleParam EOF )
            // InternalContract.g:594:2: iv_ruleParam= ruleParam EOF
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
    // InternalContract.g:600:1: ruleParam returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Enumerator lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalContract.g:606:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) ) )
            // InternalContract.g:607:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) )
            {
            // InternalContract.g:607:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) )
            // InternalContract.g:608:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) )
            {
            // InternalContract.g:608:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalContract.g:609:4: (lv_name_0_0= RULE_ID )
            {
            // InternalContract.g:609:4: (lv_name_0_0= RULE_ID )
            // InternalContract.g:610:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            // InternalContract.g:626:3: ( (lv_type_1_0= ruleDataType ) )
            // InternalContract.g:627:4: (lv_type_1_0= ruleDataType )
            {
            // InternalContract.g:627:4: (lv_type_1_0= ruleDataType )
            // InternalContract.g:628:5: lv_type_1_0= ruleDataType
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
    // InternalContract.g:649:1: entryRuleOutput returns [EObject current=null] : iv_ruleOutput= ruleOutput EOF ;
    public final EObject entryRuleOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutput = null;


        try {
            // InternalContract.g:649:47: (iv_ruleOutput= ruleOutput EOF )
            // InternalContract.g:650:2: iv_ruleOutput= ruleOutput EOF
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
    // InternalContract.g:656:1: ruleOutput returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) ) ;
    public final EObject ruleOutput() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Enumerator lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalContract.g:662:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) ) )
            // InternalContract.g:663:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) )
            {
            // InternalContract.g:663:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) ) )
            // InternalContract.g:664:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleDataType ) )
            {
            // InternalContract.g:664:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalContract.g:665:4: (lv_name_0_0= RULE_ID )
            {
            // InternalContract.g:665:4: (lv_name_0_0= RULE_ID )
            // InternalContract.g:666:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

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

            // InternalContract.g:682:3: ( (lv_type_1_0= ruleDataType ) )
            // InternalContract.g:683:4: (lv_type_1_0= ruleDataType )
            {
            // InternalContract.g:683:4: (lv_type_1_0= ruleDataType )
            // InternalContract.g:684:5: lv_type_1_0= ruleDataType
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


    // $ANTLR start "ruleDataType"
    // InternalContract.g:705:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'string' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'address' ) | (enumLiteral_4= 'array' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalContract.g:711:2: ( ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'string' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'address' ) | (enumLiteral_4= 'array' ) ) )
            // InternalContract.g:712:2: ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'string' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'address' ) | (enumLiteral_4= 'array' ) )
            {
            // InternalContract.g:712:2: ( (enumLiteral_0= 'integer' ) | (enumLiteral_1= 'string' ) | (enumLiteral_2= 'boolean' ) | (enumLiteral_3= 'address' ) | (enumLiteral_4= 'array' ) )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt11=1;
                }
                break;
            case 25:
                {
                alt11=2;
                }
                break;
            case 26:
                {
                alt11=3;
                }
                break;
            case 27:
                {
                alt11=4;
                }
                break;
            case 28:
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalContract.g:713:3: (enumLiteral_0= 'integer' )
                    {
                    // InternalContract.g:713:3: (enumLiteral_0= 'integer' )
                    // InternalContract.g:714:4: enumLiteral_0= 'integer'
                    {
                    enumLiteral_0=(Token)match(input,24,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getINTEGEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getINTEGEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalContract.g:721:3: (enumLiteral_1= 'string' )
                    {
                    // InternalContract.g:721:3: (enumLiteral_1= 'string' )
                    // InternalContract.g:722:4: enumLiteral_1= 'string'
                    {
                    enumLiteral_1=(Token)match(input,25,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getSTRINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getSTRINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalContract.g:729:3: (enumLiteral_2= 'boolean' )
                    {
                    // InternalContract.g:729:3: (enumLiteral_2= 'boolean' )
                    // InternalContract.g:730:4: enumLiteral_2= 'boolean'
                    {
                    enumLiteral_2=(Token)match(input,26,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getBOOLEANEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getBOOLEANEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalContract.g:737:3: (enumLiteral_3= 'address' )
                    {
                    // InternalContract.g:737:3: (enumLiteral_3= 'address' )
                    // InternalContract.g:738:4: enumLiteral_3= 'address'
                    {
                    enumLiteral_3=(Token)match(input,27,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getADDRESSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getADDRESSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalContract.g:745:3: (enumLiteral_4= 'array' )
                    {
                    // InternalContract.g:745:3: (enumLiteral_4= 'array' )
                    // InternalContract.g:746:4: enumLiteral_4= 'array'
                    {
                    enumLiteral_4=(Token)match(input,28,FOLLOW_2); 

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
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000081C010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000001F000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400000L});

}