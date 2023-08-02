/**
 * generated by Xtext 2.25.0
 */
package lsi.us.es.mis.xtext.generator;

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
public class HyperledgerGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    Contract contract = ((Contract) _head);
    String _name = contract.getName();
    String _plus = (_name + ".go");
    fsa.generateFile(_plus, this.toHyperledger(contract));
  }
  
  public String toHyperledger(final Contract contract) {
    final String contractName = contract.getName();
    final StringBuilder code = new StringBuilder();
    this.appendHeader(contract, code);
    this.appendAttributes(contract, code);
    this.appendAttributesMethods(contract, code);
    this.appendConstructor(contract, code);
    code.append("func main() {\n");
    code.append((("\tchaincode, err := contractapi.NewChaincode(&" + contractName) + "{})\n"));
    code.append("\tif err != nil {\n");
    code.append((("\t\tfmt.Printf(\"Error creating " + contractName) + " chaincode: %s\", err.Error())\n"));
    code.append("\t\treturn\n");
    code.append("\t}\n\n");
    code.append("\tif err := chaincode.Start(); err != nil {\n");
    code.append((("\t\tfmt.Printf(\"Error starting " + contractName) + " chaincode: %s\", err.Error())\n"));
    code.append("\t}\n");
    code.append("}\n");
    return code.toString();
  }
  
  public StringBuilder appendHeader(final Contract contract, final StringBuilder code) {
    StringBuilder _xblockexpression = null;
    {
      code.append("package main\n\n");
      code.append("import (\n");
      code.append("\t\"fmt\"\n");
      code.append("\n");
      code.append("\t\"github.com/hyperledger/fabric-contract-api-go/contractapi\"\n");
      _xblockexpression = code.append(")\n\n");
    }
    return _xblockexpression;
  }
  
  public StringBuilder appendConstructor(final Contract contract, final StringBuilder code) {
    StringBuilder _xblockexpression = null;
    {
      String _name = contract.getName();
      String _plus = ("func (sc *" + _name);
      String _plus_1 = (_plus + ") InitLedger(ctx contractapi.TransactionContextInterface) error {\n");
      code.append(_plus_1);
      code.append("\t// Inicializa los valores de los atributos\n");
      EList<Attribute> _attributes = contract.getAttributes();
      for (final Attribute attribute : _attributes) {
        {
          final String attributeName = attribute.getName();
          final String defaultValue = this.getDefaultInitialValue(attribute.getType().toString());
          String _capitalizeFirstLetter = this.capitalizeFirstLetter(attributeName);
          String _plus_2 = ("\tsc." + _capitalizeFirstLetter);
          String _plus_3 = (_plus_2 + " = ");
          String _plus_4 = (_plus_3 + defaultValue);
          String _plus_5 = (_plus_4 + "\n");
          code.append(_plus_5);
        }
      }
      code.append("\treturn nil\n");
      _xblockexpression = code.append("}\n\n");
    }
    return _xblockexpression;
  }
  
  public StringBuilder appendAttributes(final Contract contract, final StringBuilder code) {
    StringBuilder _xblockexpression = null;
    {
      String _name = contract.getName();
      String _plus = ("type " + _name);
      String _plus_1 = (_plus + " struct {\n");
      code.append(_plus_1);
      code.append("\tcontractapi.Contract\n");
      EList<Attribute> _attributes = contract.getAttributes();
      for (final Attribute attribute : _attributes) {
        {
          final String attributeName = attribute.getName();
          final String attributeType = this.getCorrectType(attribute.getType().toString());
          String _capitalizeFirstLetter = this.capitalizeFirstLetter(attributeName);
          String _plus_2 = ("\t" + _capitalizeFirstLetter);
          String _plus_3 = (_plus_2 + " ");
          String _plus_4 = (_plus_3 + attributeType);
          String _plus_5 = (_plus_4 + "\n");
          code.append(_plus_5);
        }
      }
      _xblockexpression = code.append("}\n\n");
    }
    return _xblockexpression;
  }
  
  public void appendAttributesMethods(final Contract contract, final StringBuilder code) {
    EList<Attribute> _attributes = contract.getAttributes();
    for (final Attribute attribute : _attributes) {
      {
        final String attributeName = attribute.getName();
        final String capitalizeAttributeName = this.capitalizeFirstLetter(attributeName);
        final String attributeType = this.getCorrectType(attribute.getType().toString());
        boolean _isModifiable = attribute.isModifiable();
        if (_isModifiable) {
          String _name = contract.getName();
          String _plus = ("func (sc *" + _name);
          String _plus_1 = (_plus + ") Set");
          String _plus_2 = (_plus_1 + capitalizeAttributeName);
          String _plus_3 = (_plus_2 + "(ctx contractapi.TransactionContextInterface, value ");
          String _plus_4 = (_plus_3 + attributeType);
          String _plus_5 = (_plus_4 + ") error {\n");
          code.append(_plus_5);
          String _capitalizeFirstLetter = this.capitalizeFirstLetter(attributeName);
          String _plus_6 = ("\tsc." + _capitalizeFirstLetter);
          String _plus_7 = (_plus_6 + " = value\n");
          code.append(_plus_7);
          code.append("\treturn nil\n");
          code.append("}\n\n");
        }
        String _name_1 = contract.getName();
        String _plus_8 = ("func (sc *" + _name_1);
        String _plus_9 = (_plus_8 + ") Get");
        String _plus_10 = (_plus_9 + capitalizeAttributeName);
        String _plus_11 = (_plus_10 + "(ctx contractapi.TransactionContextInterface) (");
        String _plus_12 = (_plus_11 + attributeType);
        String _plus_13 = (_plus_12 + ", error) {\n");
        code.append(_plus_13);
        String _capitalizeFirstLetter_1 = this.capitalizeFirstLetter(attributeName);
        String _plus_14 = ("\treturn sc." + _capitalizeFirstLetter_1);
        String _plus_15 = (_plus_14 + ", nil\n");
        code.append(_plus_15);
        code.append("}\n\n");
      }
    }
  }
  
  public String getDefaultInitialValue(final String dataType) {
    if (dataType != null) {
      switch (dataType) {
        case "integer":
          return "0";
        case "string":
          return "\"\"";
        case "boolean":
          return "false";
        case "address":
          return "\"\"";
        case "array":
          return "[]uint64{}";
        default:
          return "uint64";
      }
    } else {
      return "uint64";
    }
  }
  
  public String getCorrectType(final String dataType) {
    if (dataType != null) {
      switch (dataType) {
        case "integer":
          return "uint64";
        case "string":
          return "string";
        case "boolean":
          return "bool";
        case "address":
          return "string";
        case "array":
          return "uint64[]";
        default:
          return "uint64";
      }
    } else {
      return "uint64";
    }
  }
  
  public String capitalizeFirstLetter(final String str) {
    String _upperCase = str.substring(0, 1).toUpperCase();
    String _substring = str.substring(1);
    return (_upperCase + _substring);
  }
}
