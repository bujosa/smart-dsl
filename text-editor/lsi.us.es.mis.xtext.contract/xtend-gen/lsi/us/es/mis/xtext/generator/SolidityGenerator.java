/**
 * generated by Xtext 2.25.0
 */
package lsi.us.es.mis.xtext.generator;

import com.google.common.base.Objects;
import lsi.us.es.mis.xtext.contract.Attribute;
import lsi.us.es.mis.xtext.contract.Contract;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
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
    EList<Attribute> _attributes = contract.getAttributes();
    for (final Attribute attribute : _attributes) {
      {
        final String attributeName = attribute.getName();
        final String attributeType = this.getSolidityDataType(attribute.getType().toString());
        code.append((((("\t" + attributeType) + " ") + attributeName) + ";\n"));
      }
    }
    code.append("\n");
    code.append("\tconstructor(");
    EList<Attribute> _attributes_1 = contract.getAttributes();
    for (final Attribute attribute_1 : _attributes_1) {
      {
        final String attributeName = attribute_1.getName();
        final String attributeType = this.getSolidityDataTypeForFunction(attribute_1.getType().toString());
        code.append(((attributeType + " _") + attributeName));
        Attribute _last = IterableExtensions.<Attribute>last(contract.getAttributes());
        boolean _notEquals = (!Objects.equal(attribute_1, _last));
        if (_notEquals) {
          code.append(", ");
        }
      }
    }
    code.append(") {\n");
    EList<Attribute> _attributes_2 = contract.getAttributes();
    for (final Attribute attribute_2 : _attributes_2) {
      {
        final String attributeName = attribute_2.getName();
        code.append((((("\t\t" + attributeName) + " = _") + attributeName) + ";\n"));
      }
    }
    code.append("\t}\n\n");
    EList<Attribute> _attributes_3 = contract.getAttributes();
    for (final Attribute attribute_3 : _attributes_3) {
      {
        final String attributeName = attribute_3.getName();
        final String attributeType = this.getSolidityDataTypeForFunction(attribute_3.getType().toString());
        boolean _isModifiable = attribute_3.isModifiable();
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
    code.append("}");
    return code.toString();
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
  
  public String capitalizeFirstLetter(final String str) {
    String _upperCase = str.substring(0, 1).toUpperCase();
    String _substring = str.substring(1);
    return (_upperCase + _substring);
  }
}
