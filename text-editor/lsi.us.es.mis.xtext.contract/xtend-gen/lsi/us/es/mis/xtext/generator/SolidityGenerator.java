/**
 * generated by Xtext 2.25.0
 */
package lsi.us.es.mis.xtext.generator;

import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lsi.us.es.mis.xtext.contract.Attribute;
import lsi.us.es.mis.xtext.contract.Contract;
import lsi.us.es.mis.xtext.contract.DataStore;
import lsi.us.es.mis.xtext.contract.Event;
import lsi.us.es.mis.xtext.contract.Method;
import lsi.us.es.mis.xtext.contract.Param;
import lsi.us.es.mis.xtext.contract.Validator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class SolidityGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    Contract contract = ((Contract) _head);
    String _name = contract.getName();
    String _plus = (_name + ".sol");
    fsa.generateFile(_plus, this.toSolidity(contract));
  }
  
  public String toSolidity(final Contract contract) {
    StringBuilder code = new StringBuilder();
    final String contractName = contract.getName();
    code.append("// SPDX-License-Identifier: MIT\n");
    code.append("pragma solidity ^0.8.0;\n\n");
    code.append((("contract " + contractName) + " {\n"));
    this.appendAttributes(contract, code);
    this.appendEvents(contract, code);
    this.appendModifiers(contract, code);
    this.appendConstructor(contract, code);
    this.appendAttributeFunctions(contract.getAttributes(), code);
    this.appendMethods(contract, code);
    code.append("}");
    return code.toString();
  }
  
  public StringBuilder appendAttributes(final Contract contract, final StringBuilder code) {
    StringBuilder _xblockexpression = null;
    {
      EList<Attribute> _attributes = contract.getAttributes();
      for (final Attribute attribute : _attributes) {
        {
          final String attributeName = attribute.getName();
          final String attributeType = this.getSolidityDataType(attribute.getType().toString());
          code.append((((("\t" + attributeType) + " ") + attributeName) + ";\n"));
        }
      }
      boolean _isOwnership = contract.isOwnership();
      if (_isOwnership) {
        code.append("\taddress owner;\n");
      }
      EList<DataStore> _dataStores = contract.getDataStores();
      for (final DataStore datastore : _dataStores) {
        {
          final String mappingName = datastore.getName();
          final String fromType = this.getSolidityDataType(datastore.getFromType().toString());
          final String toType = this.getSolidityDataType(datastore.getToType().toString());
          code.append((((((("\tmapping(" + fromType) + " => ") + toType) + ") public ") + mappingName) + ";\n"));
        }
      }
      StringBuilder _xifexpression = null;
      if (((contract.isOwnership() || (((Object[])Conversions.unwrapArray(contract.getAttributes(), Object.class)).length != 0)) || (((Object[])Conversions.unwrapArray(contract.getDataStores(), Object.class)).length != 0))) {
        _xifexpression = code.append("\n");
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public StringBuilder appendConstructor(final Contract contract, final StringBuilder code) {
    StringBuilder _xblockexpression = null;
    {
      code.append("\tconstructor(");
      EList<Attribute> _attributes = contract.getAttributes();
      for (final Attribute attribute : _attributes) {
        {
          final String attributeName = attribute.getName();
          final String attributeType = this.getSolidityDataTypeForFunction(attribute.getType().toString());
          code.append(((attributeType + " _") + attributeName));
          Attribute _last = IterableExtensions.<Attribute>last(contract.getAttributes());
          boolean _notEquals = (!Objects.equal(attribute, _last));
          if (_notEquals) {
            code.append(", ");
          }
        }
      }
      code.append(") {\n");
      EList<Attribute> _attributes_1 = contract.getAttributes();
      for (final Attribute attribute_1 : _attributes_1) {
        {
          final String attributeName = attribute_1.getName();
          code.append((((("\t\t" + attributeName) + " = _") + attributeName) + ";\n"));
        }
      }
      boolean _isOwnership = contract.isOwnership();
      if (_isOwnership) {
        code.append(("\t\t" + "owner = msg.sender;\n"));
      }
      _xblockexpression = code.append("\t}\n\n");
    }
    return _xblockexpression;
  }
  
  public void appendAttributeFunctions(final List<Attribute> attributes, final StringBuilder code) {
    for (final Attribute attribute : attributes) {
      {
        final String attributeName = attribute.getName();
        final String attributeType = this.getSolidityDataTypeForFunction(attribute.getType().toString());
        boolean _isModifiable = attribute.isModifiable();
        if (_isModifiable) {
          String _capitalizeFirstLetter = this.capitalizeFirstLetter(attributeName);
          String _plus = ("\tfunction set" + _capitalizeFirstLetter);
          String _plus_1 = (_plus + "(");
          String _plus_2 = (_plus_1 + attributeType);
          String _plus_3 = (_plus_2 + " _value) public {\n");
          code.append(_plus_3);
          code.append((("\t\t" + attributeName) + " = _value;\n"));
          code.append("\t}\n\n");
        }
        String _capitalizeFirstLetter_1 = this.capitalizeFirstLetter(attributeName);
        String _plus_4 = ("\tfunction get" + _capitalizeFirstLetter_1);
        String _plus_5 = (_plus_4 + "() public view returns (");
        String _plus_6 = (_plus_5 + attributeType);
        String _plus_7 = (_plus_6 + ") {\n");
        code.append(_plus_7);
        code.append((("\t\treturn " + attributeName) + ";\n"));
        code.append("\t}\n\n");
      }
    }
  }
  
  public void appendEvents(final Contract contract, final StringBuilder code) {
    final EList<Event> events = contract.getEvents();
    this.appendPaymentReceivedEvent(contract, code);
    for (final Event event : events) {
      {
        String _description = event.getDescription();
        boolean _tripleNotEquals = (_description != null);
        if (_tripleNotEquals) {
          String _description_1 = event.getDescription();
          String _plus = ("\t// " + _description_1);
          String _plus_1 = (_plus + "\n");
          code.append(_plus_1);
        }
        String _capitalizeFirstLetter = this.capitalizeFirstLetter(event.getName());
        String _plus_2 = ("\tevent " + _capitalizeFirstLetter);
        String _plus_3 = (_plus_2 + "(");
        code.append(_plus_3);
        EList<Param> _params = event.getParams();
        for (final Param param : _params) {
          {
            final String parameterName = param.getName();
            final String parameterType = this.getSolidityDataTypeForEvent(param.getType().toString());
            code.append(((parameterType + " ") + parameterName));
            Param _last = IterableExtensions.<Param>last(event.getParams());
            boolean _notEquals = (!Objects.equal(param, _last));
            if (_notEquals) {
              code.append(", ");
            }
          }
        }
        code.append(");\n");
        Event _last = IterableExtensions.<Event>last(events);
        boolean _equals = Objects.equal(event, _last);
        if (_equals) {
          code.append("\n");
        }
      }
    }
  }
  
  public void appendModifiers(final Contract contract, final StringBuilder code) {
    EList<Validator> _validators = contract.getValidators();
    for (final Validator modifier : _validators) {
      {
        String params = "";
        int _length = ((Object[])Conversions.unwrapArray(modifier.getParams(), Object.class)).length;
        boolean _equals = (_length == 0);
        if (_equals) {
          params = "()";
        } else {
          params = "(";
        }
        EList<Param> _params = modifier.getParams();
        for (final Param param : _params) {
          Param _last = IterableExtensions.<Param>last(modifier.getParams());
          boolean _equals_1 = Objects.equal(param, _last);
          if (_equals_1) {
            String _params_1 = params;
            String _solidityDataTypeForFunction = this.getSolidityDataTypeForFunction(param.getType().toString());
            String _plus = (_solidityDataTypeForFunction + " ");
            String _name = param.getName();
            String _plus_1 = (_plus + _name);
            String _plus_2 = (_plus_1 + ")");
            params = (_params_1 + _plus_2);
          } else {
            String _params_2 = params;
            String _solidityDataTypeForFunction_1 = this.getSolidityDataTypeForFunction(param.getType().toString());
            String _plus_3 = (_solidityDataTypeForFunction_1 + " ");
            String _name_1 = param.getName();
            String _plus_4 = (_plus_3 + _name_1);
            String _plus_5 = (_plus_4 + ", ");
            params = (_params_2 + _plus_5);
          }
        }
        String _name_2 = modifier.getName();
        String _plus_6 = ("\tmodifier " + _name_2);
        String _plus_7 = (_plus_6 + params);
        String _plus_8 = (_plus_7 + " {\n");
        code.append(_plus_8);
        String _checkCondition = this.checkCondition(modifier, contract);
        String _plus_9 = ("\t\trequire(" + _checkCondition);
        String _plus_10 = (_plus_9 + ", \"");
        String _message = modifier.getMessage();
        String _plus_11 = (_plus_10 + _message);
        String _plus_12 = (_plus_11 + "\");\n");
        code.append(_plus_12);
        code.append("\t\t_;\n");
        code.append("\t}\n\n");
      }
    }
  }
  
  public String checkCondition(final Validator validator, final Contract contract) {
    String condition = validator.getValidation();
    final String regex = "([\\w.]+)\\s*([!=<>]+)\\s*([\\w.]+)";
    final Pattern pattern = Pattern.compile(regex);
    final Matcher matcher = pattern.matcher(condition);
    final String regex2 = "\\s*([^!=]*)\\s*(==|!=)\\s*\'([^\']*)\'";
    final Pattern pattern2 = Pattern.compile(regex2);
    final Matcher matcher2 = pattern2.matcher(condition);
    final HashMap<String, String> hashTable = new HashMap<String, String>();
    EList<Param> _params = validator.getParams();
    for (final Param param : _params) {
      hashTable.put(param.getName(), param.getType().toString());
    }
    EList<Attribute> _attributes = contract.getAttributes();
    for (final Attribute attribute : _attributes) {
      hashTable.put(attribute.getName(), attribute.getType().toString());
    }
    boolean _matches = matcher.matches();
    if (_matches) {
      String leftSide = matcher.group(1).replaceAll("\\s", "");
      String operator = matcher.group(2);
      String rightSide = matcher.group(3).replaceAll("\\s", "");
      boolean _equals = Objects.equal(leftSide, "from");
      if (_equals) {
        leftSide = "msg.sender";
      }
      boolean _equals_1 = Objects.equal(rightSide, "from");
      if (_equals_1) {
        rightSide = "msg.sender";
      }
      return ((((leftSide + " ") + operator) + " ") + rightSide);
    }
    boolean _matches_1 = matcher2.matches();
    if (_matches_1) {
      final String variable = matcher2.group(1);
      final String value = matcher2.group(3);
      final String keyvalue = hashTable.get(variable);
      boolean _equals_2 = Objects.equal(keyvalue, "string");
      if (_equals_2) {
        condition = condition.replace(variable, (("keccak256(bytes(" + variable) + "))"));
      }
      EList<DataStore> _dataStores = contract.getDataStores();
      for (final DataStore mapping : _dataStores) {
        if ((condition.contains(mapping.getName()) && Objects.equal(mapping.getToType().toString(), "string"))) {
          condition = condition.replace(variable, (("keccak256(bytes(" + variable) + "))"));
        }
      }
      int _length = value.length();
      boolean _equals_3 = (_length == 0);
      if (_equals_3) {
        condition = condition.replace("\'\'", Integer.valueOf(0).toString());
      } else {
        condition = condition.replace((("\'" + value) + "\'"), (((("keccak256(bytes(" + "\"") + value) + "\"") + "))"));
      }
    }
    return condition;
  }
  
  public StringBuilder appendReceiveFunction(final StringBuilder code) {
    StringBuilder _xblockexpression = null;
    {
      code.append("\treceive() external payable {\n");
      code.append("\t\temit PaymentReceived(msg.sender, msg.value);\n");
      _xblockexpression = code.append("\t}\n\n");
    }
    return _xblockexpression;
  }
  
  public StringBuilder appendPaymentReceivedEvent(final Contract contract, final StringBuilder code) {
    StringBuilder _xifexpression = null;
    boolean _isHasReceive = contract.isHasReceive();
    if (_isHasReceive) {
      StringBuilder _xblockexpression = null;
      {
        code.append("\tevent PaymentReceived(address sender, uint amount);\n");
        StringBuilder _xifexpression_1 = null;
        int _size = contract.getEvents().size();
        boolean _equals = (_size == 0);
        if (_equals) {
          _xifexpression_1 = code.append("\n");
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public void appendMethods(final Contract contract, final StringBuilder code) {
    final EList<Method> methods = contract.getMethods();
    boolean _isHasReceive = contract.isHasReceive();
    if (_isHasReceive) {
      this.appendReceiveFunction(code);
    }
    for (final Method method : methods) {
      {
        String _name = method.getName();
        String _plus = ("\tfunction " + _name);
        String _plus_1 = (_plus + "(");
        code.append(_plus_1);
        String returns = "";
        String modifiers = "";
        String events = "";
        EList<Param> _params = method.getParams();
        for (final Param param : _params) {
          {
            final String parameterName = param.getName();
            final String parameterType = this.getSolidityDataTypeForFunction(param.getType().toString());
            code.append(((parameterType + " ") + parameterName));
            Param _last = IterableExtensions.<Param>last(method.getParams());
            boolean _notEquals = (!Objects.equal(param, _last));
            if (_notEquals) {
              code.append(", ");
            }
          }
        }
        int _length = ((Object[])Conversions.unwrapArray(method.getOutputs(), Object.class)).length;
        boolean _notEquals = (_length != 0);
        if (_notEquals) {
          String _returns = returns;
          returns = (_returns + " returns (");
          EList<Param> _outputs = method.getOutputs();
          for (final Param output : _outputs) {
            {
              String _returns_1 = returns;
              String _solidityDataTypeForFunction = this.getSolidityDataTypeForFunction(output.getType().toString());
              returns = (_returns_1 + _solidityDataTypeForFunction);
              Param _last = IterableExtensions.<Param>last(method.getOutputs());
              boolean _equals = Objects.equal(output, _last);
              if (_equals) {
                String _returns_2 = returns;
                returns = (_returns_2 + ")");
              } else {
                String _returns_3 = returns;
                returns = (_returns_3 + ", ");
              }
            }
          }
        }
        EList<Validator> _validators = method.getValidators();
        for (final Validator modifier : _validators) {
          {
            int _length_1 = ((Object[])Conversions.unwrapArray(modifier.getParams(), Object.class)).length;
            boolean _equals = (_length_1 == 0);
            if (_equals) {
              String _modifiers = modifiers;
              String _name_1 = modifier.getName();
              String _plus_2 = (" " + _name_1);
              modifiers = (_modifiers + _plus_2);
            } else {
              String _modifiers_1 = modifiers;
              String _name_2 = modifier.getName();
              String _plus_3 = (" " + _name_2);
              String _plus_4 = (_plus_3 + "(");
              modifiers = (_modifiers_1 + _plus_4);
              EList<Param> _params_1 = modifier.getParams();
              for (final Param param_1 : _params_1) {
                {
                  String _modifiers_2 = modifiers;
                  String _name_3 = param_1.getName();
                  modifiers = (_modifiers_2 + _name_3);
                  Param _last = IterableExtensions.<Param>last(modifier.getParams());
                  boolean _equals_1 = Objects.equal(param_1, _last);
                  if (_equals_1) {
                    String _modifiers_3 = modifiers;
                    modifiers = (_modifiers_3 + ")");
                  } else {
                    String _modifiers_4 = modifiers;
                    modifiers = (_modifiers_4 + ", ");
                  }
                }
              }
            }
            Validator _last = IterableExtensions.<Validator>last(method.getValidators());
            boolean _equals_1 = Objects.equal(modifier, _last);
            if (_equals_1) {
              String _modifiers_2 = modifiers;
              modifiers = (_modifiers_2 + " ");
            }
          }
        }
        EList<Event> _events = method.getEvents();
        for (final Event event : _events) {
          int _length_1 = ((Object[])Conversions.unwrapArray(event.getParams(), Object.class)).length;
          boolean _equals = (_length_1 == 0);
          if (_equals) {
            String _events_1 = events;
            String _capitalizeFirstLetter = this.capitalizeFirstLetter(event.getName());
            String _plus_2 = ("\t\temit " + _capitalizeFirstLetter);
            String _plus_3 = (_plus_2 + "();\n");
            events = (_events_1 + _plus_3);
          } else {
            String _events_2 = events;
            String _capitalizeFirstLetter_1 = this.capitalizeFirstLetter(event.getName());
            String _plus_4 = ("\t\temit " + _capitalizeFirstLetter_1);
            String _plus_5 = (_plus_4 + "(");
            events = (_events_2 + _plus_5);
            EList<Param> _params_1 = event.getParams();
            for (final Param param_1 : _params_1) {
              {
                String value = param_1.getName();
                boolean _equals_1 = Objects.equal(value, "from");
                if (_equals_1) {
                  value = "msg.sender";
                }
                String _events_3 = events;
                events = (_events_3 + value);
                Param _last = IterableExtensions.<Param>last(event.getParams());
                boolean _equals_2 = Objects.equal(param_1, _last);
                if (_equals_2) {
                  String _events_4 = events;
                  events = (_events_4 + ");\n");
                } else {
                  String _events_5 = events;
                  events = (_events_5 + ", ");
                }
              }
            }
          }
        }
        String _checkMutability = this.checkMutability(method);
        String _plus_6 = (") public" + _checkMutability);
        String _plus_7 = (_plus_6 + modifiers);
        String _plus_8 = (_plus_7 + "");
        String _plus_9 = (_plus_8 + returns);
        String _plus_10 = (_plus_9 + " {\n");
        code.append(_plus_10);
        String _description = method.getDescription();
        boolean _tripleNotEquals = (_description != null);
        if (_tripleNotEquals) {
          String _description_1 = method.getDescription();
          String _plus_11 = ("\t\t// " + _description_1);
          String _plus_12 = (_plus_11 + "\n");
          code.append(_plus_12);
        }
        code.append(this.checkParams(contract, method));
        code.append(events);
        code.append("\t}\n\n");
      }
    }
  }
  
  public String checkMutability(final Method method) {
    String _statemutability = method.getStatemutability();
    boolean _tripleNotEquals = (_statemutability != null);
    if (_tripleNotEquals) {
      String _statemutability_1 = method.getStatemutability();
      String _plus = (" " + _statemutability_1);
      return (_plus + " ");
    }
    return "";
  }
  
  public String checkParams(final Contract contract, final Method method) {
    String params = "";
    final HashMap<String, String> hashTable = new HashMap<String, String>();
    EList<Attribute> _attributes = contract.getAttributes();
    for (final Attribute attribute : _attributes) {
      hashTable.put(attribute.getName(), "attribute");
    }
    EList<Param> _params = method.getParams();
    for (final Param param : _params) {
      {
        String newParam = param.getName().replace("_", "");
        boolean _contains = param.getName().contains("_");
        if (_contains) {
          boolean _containsKey = hashTable.containsKey(newParam);
          if (_containsKey) {
            String _params_1 = params;
            params = (_params_1 + (((("\t\t" + newParam) + " = _") + newParam) + ";\n"));
          }
        }
      }
    }
    return params;
  }
  
  public String getSolidityDataType(final String dataType) {
    if (dataType != null) {
      switch (dataType) {
        case "integer":
          return "uint256";
        case "string":
          return "string";
        case "boolean":
          return "bool";
        case "address":
          return "address";
        case "array":
          return "uint256[]";
        default:
          return "uint256";
      }
    } else {
      return "uint256";
    }
  }
  
  public String getSolidityDataTypeForFunction(final String dataType) {
    if (dataType != null) {
      switch (dataType) {
        case "integer":
          return "uint256";
        case "string":
          return "string memory";
        case "boolean":
          return "bool";
        case "address":
          return "address";
        case "array":
          return "uint256[]";
        default:
          return "uint256";
      }
    } else {
      return "uint256";
    }
  }
  
  public String getSolidityDataTypeForEvent(final String dataType) {
    if (dataType != null) {
      switch (dataType) {
        case "integer":
          return "uint256";
        case "string":
          return "string";
        case "boolean":
          return "bool";
        case "address":
          return "address";
        case "array":
          return "uint256[]";
        default:
          return "uint256";
      }
    } else {
      return "uint256";
    }
  }
  
  public String capitalizeFirstLetter(final String str) {
    String _upperCase = str.substring(0, 1).toUpperCase();
    String _substring = str.substring(1);
    return (_upperCase + _substring);
  }
}
