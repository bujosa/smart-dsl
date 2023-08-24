/*
 * generated by Xtext 2.25.0
 */
package lsi.us.es.mis.xtext.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import java.util.List
import lsi.us.es.mis.xtext.contract.Attribute
import lsi.us.es.mis.xtext.contract.Contract
import lsi.us.es.mis.xtext.contract.Validator
import lsi.us.es.mis.xtext.contract.Method
import java.util.regex.Pattern
import java.util.HashMap


/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class SolidityGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var contract = resource.contents.head as Contract
		
		fsa.generateFile(contract.name + ".sol", toSolidity(contract))
	}
	
	def toSolidity(Contract contract) {
	    var code = new StringBuilder
	    val contractName = contract.name
	    code.append("// SPDX-License-Identifier: MIT\n")
	    code.append("pragma solidity ^0.8.0;\n\n")
	    code.append("contract " + contractName + " {\n")

	    appendAttributes(contract, code)
	    
	    appendEvents(contract, code)
	    
	    appendModifiers(contract, code)
	    
	    appendConstructor(contract, code)
  
    	appendAttributeFunctions(contract.attributes, code)
    	
    	appendMethods(contract, code)
	    
	    code.append("}")
	    return code.toString
	}
	
	def appendAttributes(Contract contract, StringBuilder code) {
	    for (attribute : contract.attributes) {
	        val attributeName = attribute.name
	        val attributeType = getSolidityDataType(attribute.type.toString)
	        code.append("\t"+ attributeType + " " + attributeName +";\n")
	    }
	    
	    
	    if (contract.ownership){
			code.append("\taddress owner;\n")
		}
		
		for (datastore: contract.dataStores) {
	        val mappingName = datastore.name
	        val fromType = getSolidityDataType(datastore.fromType.toString)
	        val toType = getSolidityDataType(datastore.toType.toString)
	        code.append("\tmapping("+ fromType + " => " + toType +") public " +mappingName+";\n")
	    }
		
		if (contract.ownership || contract.attributes.length() != 0 || contract.dataStores.length() !=  0){
			code.append("\n")
		}
	}
	
	def appendConstructor(Contract contract, StringBuilder code) {
	    code.append("\tconstructor(")
	    for (attribute : contract.attributes) {
	        val attributeName = attribute.name
	        val attributeType = getSolidityDataTypeForFunction(attribute.type.toString)
	        
	        code.append(attributeType + " _" + attributeName)
	        if (attribute != contract.attributes.last) {
	            code.append(", ")
	        }
	    }
	    
	    code.append(") {\n")
	    for (attribute : contract.attributes) {
	        val attributeName = attribute.name
	        code.append("\t\t" + attributeName + " = _" + attributeName +";\n")
	    }
	    
	    if (contract.ownership){
	    	code.append("\t\t" + "owner = msg.sender;\n")
	    }
	    code.append("\t}\n\n")
	}
	
	def appendAttributeFunctions(List<Attribute> attributes, StringBuilder code) {
	    for (attribute : attributes) {
	        val attributeName = attribute.name
	        val attributeType = getSolidityDataTypeForFunction(attribute.type.toString)
	        
	        if (attribute.modifiable) {
	            code.append("\tfunction set" + capitalizeFirstLetter(attributeName)+ "("+ attributeType + " _value) public {\n")
	            code.append("\t\t"+attributeName+" = _value;\n")
	            code.append("\t}\n\n")
	        }
	        
	        code.append("\tfunction get" + capitalizeFirstLetter(attributeName)+ "() public view returns (" +attributeType +") {\n")
	        code.append("\t\treturn " + attributeName + ";\n")
	        code.append("\t}\n\n")
	    }
	}
	
	def appendEvents(Contract contract, StringBuilder code) {
		val events = contract.events
		
		appendPaymentReceivedEvent(contract, code)
		
	    for (event : events) {
	    	if (event.description !== null){
	    		code.append("\t// " + event.description + "\n")
	    	}
	        code.append("\tevent " + capitalizeFirstLetter(event.name) + "(")
	        for (param : event.params) {
	            val parameterName = param.name
	            val parameterType = getSolidityDataTypeForEvent(param.type.toString)
	            
	            code.append(parameterType + " " + parameterName)
	            if (param != event.params.last) {
	                code.append(", ")
	            }
	        }
	        
	        code.append(");\n")
	        
	        if (event == events.last){
	        	code.append("\n")
	        }
	    }
	}
	
	def appendModifiers(Contract contract, StringBuilder code) {
		for (modifier : contract.validators) {
			
			var params = ""
			
			if (modifier.params.length() == 0){
				params = "()"
			} else {
				params = "("
			}
			
			for (param: modifier.params) {
				if (param == modifier.params.last()){
					params += getSolidityDataTypeForFunction(param.type.toString) + " " + param.name + ")"
				} else {
					params += getSolidityDataTypeForFunction(param.type.toString) + " " + param.name + ", "
				}
			}
			
			code.append("\tmodifier " + modifier.name + params + " {\n")
            code.append("\t\trequire("+checkCondition(modifier, contract)+", \"" + modifier.message + "\");\n")
            code.append("\t\t_;\n")
            code.append("\t}\n\n")
		}
	}
	
	def String checkCondition(Validator validator, Contract contract){
		var condition = validator.validation
		
		val regex = "([\\w.]+)\\s*([!=<>]+)\\s*([\\w.]+)";
		val pattern = Pattern.compile(regex)
		val matcher = pattern.matcher(condition)
		
		val regex2 = "\\s*(\\w+)\\s*(==|!=)\\s*'([^']*)'"
		val pattern2 = Pattern.compile(regex2)
		val matcher2 = pattern2.matcher(condition)
		
		val hashTable = new HashMap<String, String>()
		for (param: validator.params) {
			hashTable.put(param.name, param.type.toString())
		}
		for (attribute: contract.attributes) {
			hashTable.put(attribute.name, attribute.type.toString())
		}
		
		
		if (matcher.matches) {
            var leftSide = matcher.group(1).replaceAll("\\s", "")
            var operator = matcher.group(2)
            var rightSide = matcher.group(3).replaceAll("\\s", "")
            
            if (leftSide == "from"){
            	leftSide = "msg.sender"
            } 
            
            if (rightSide == "from"){
            	rightSide = "msg.sender"
            }
            
            return leftSide +" " + operator + " "+ rightSide
        }  
        
        if (matcher2.matches){
    	    val variable = matcher2.group(1)
			val value = matcher2.group(2)
			val keyvalue = hashTable.get(variable)
			if (keyvalue == "string"){
				condition = condition.replace(variable, "keccak256(bytes("+ variable +"))")
			}
			if  (value.length() == 0){
				condition = condition.replace("''", 0.toString())
			} else {
				condition = condition.replace("'"+value+"'", "keccak256(bytes("+"\"" + value +"\"" +"))")
			}
        } 
        
        return condition
	}
	
	def appendReceiveFunction(StringBuilder code) {
	    code.append("\treceive() external payable {\n")
	    code.append("\t\temit PaymentReceived(msg.sender, msg.value);\n")
	    code.append("\t}\n\n")
	}
	
	def appendPaymentReceivedEvent(Contract contract, StringBuilder code) {
		if (contract.hasReceive){
			code.append("\tevent PaymentReceived(address sender, uint amount);\n")
	    	if (contract.events.size == 0){
	    		code.append("\n")
	    	}
		}
	}
	
	def appendMethods(Contract contract, StringBuilder code) {
		val methods = contract.methods
		
		if(contract.hasReceive){
			appendReceiveFunction(code)
		}

	    for (method : methods) {
	        code.append("\tfunction " + method.name + "(")
	        var returns = ""
	        var modifiers = ""
	        var events = ""
	        
	        for (param : method.params) {
	            val parameterName = param.name
	            val parameterType = getSolidityDataTypeForFunction(param.type.toString)
	            
	            code.append(parameterType + " " + parameterName)
	            if (param != method.params.last) {
	                code.append(", ")
	            }
	        }
	        
	        if (method.outputs.length() != 0 ) {
	        	returns += " returns ("
	        	for (output: method.outputs) {
	        		returns += getSolidityDataTypeForFunction(output.type.toString)
		        	if (output == method.outputs.last){
		        		returns += ")"
		        	} else {
		        		returns += ", "
		        	}
	        	}
	        }  
	        
	        for (modifier: method.validators){
	        	if (modifier.params.length() == 0) {
	        		modifiers  += " " + modifier.name
	        	} else {
	        		modifiers += " " +modifier.name + "("
	        		for (param: modifier.params) {
	        			modifiers += param.name
	        			if (param == modifier.params.last){
	        				modifiers += ")"
	        			}else {
	        				modifiers +=", "
	        			}
	        		}
	        	}
	        	if (modifier == method.validators.last){
	        		modifiers += " "
	        	}
	        }
	        
	        for (event: method.events){
	        	if (event.params.length() == 0) {
	        		events  += "\t\temit " + capitalizeFirstLetter(event.name) + "();\n"
	        	} else {
	        		events += "\t\temit " + capitalizeFirstLetter(event.name) + "("
	        		for (param: event.params) {
	        			var value = param.name
	        			if (value == "from") {
	        				value = "msg.sender"
	        			}
	        			events += value
	        			if (param == event.params.last){
	        				events += ");\n"
	        			}else {
	        				events +=", "
	        			}
	        		}
	        	}
	        }
	        
	        code.append(") public" + checkMutability(method) + modifiers + "" + returns +" {\n")
	        if (method.description !== null){
	        	code.append("\t\t// " + method.description + "\n")
	        }
	        code.append(checkParams(contract, method));
	       	code.append(events);
	        code.append("\t}\n\n")
	    }
	}
	
	def String checkMutability(Method method) {
		if (method.statemutability !== null){
			return " " + method.statemutability + " "
		}
		return ""
	}
	
	def String checkParams(Contract contract, Method method) {
		var params = ""
		
		val hashTable = new HashMap<String, String>()
		
		for (attribute: contract.attributes) {
			hashTable.put(attribute.name, "attribute")
		}
		
		for (param: method.params){
			var newParam = param.name.replace("_", "")
			if (param.name.contains("_")) {
				if (hashTable.containsKey(newParam)){
					params += "\t\t" + newParam + " = _"+newParam+";\n"
				}
			}
		}
		
		
		return params
	}
	
	def String getSolidityDataType(String dataType) {
	    switch (dataType) {
	        case "integer":
	            return "uint256"
	        case "string":
	            return "string"
	        case "boolean":
	            return "bool"
	        case "address":
	            return "address"
	        case "array":
	            return "uint256[]"
	        default:
	            return "uint256"
	    }
	}
	
	def String getSolidityDataTypeForFunction(String dataType) {
		switch (dataType) {
	        case "integer":
	            return "uint256"
	        case "string":
	            return "string memory"
	        case "boolean":
	            return "bool"
	        case "address":
	            return "address"
	        case "array":
	            return "uint256[]"
	        default:
	            return "uint256"
	    }
	}
	
	def String getSolidityDataTypeForEvent(String dataType) {
		switch (dataType) {
	        case "integer":
	            return "uint256"
	        case "string":
	            return "string"
	        case "boolean":
	            return "bool"
	        case "address":
	            return "address"
	        case "array":
	            return "uint256[]"
	        default:
	            return "uint256"
	    }
	}

	def String capitalizeFirstLetter(String str) {
	    return str.substring(0, 1).toUpperCase() + str.substring(1)
	}
}
