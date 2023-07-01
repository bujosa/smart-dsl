/**
 * generated by Xtext 2.25.0
 */
package lsi.us.es.mis.xtext.generator;

import lsi.us.es.mis.xtext.contract.Contract;
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
public class FireflyInterfaceGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    Contract contract = ((Contract) _head);
    String _name = contract.getName();
    String _plus = (_name + ".json");
    fsa.generateFile(_plus, this.toFireflyInterface(contract));
  }
  
  public String toFireflyInterface(final Contract contract) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field schema is undefined for the type Param"
      + "\nThe method or field schema is undefined for the type Param"
      + "\nThe method or field schema is undefined for the type Param"
      + "\nThe method or field schema is undefined for the type Param"
      + "\nThe method or field returns is undefined for the type Method"
      + "\nThe method or field returns is undefined for the type Method"
      + "\nThe method or field returns is undefined for the type Method"
      + "\nThe method or field returns is undefined for the type Method"
      + "\nThe method or field returns is undefined for the type Method"
      + "\ntype cannot be resolved"
      + "\ndetails cannot be resolved"
      + "\ntype cannot be resolved"
      + "\n?: cannot be resolved"
      + "\ndetails cannot be resolved"
      + "\ninternalType cannot be resolved"
      + "\n?: cannot be resolved"
      + "\ndetails cannot be resolved"
      + "\nindexed cannot be resolved"
      + "\n?: cannot be resolved"
      + "\ntype cannot be resolved"
      + "\nschema cannot be resolved"
      + "\ntype cannot be resolved"
      + "\nschema cannot be resolved"
      + "\ndetails cannot be resolved"
      + "\ntype cannot be resolved"
      + "\n?: cannot be resolved"
      + "\nschema cannot be resolved"
      + "\ndetails cannot be resolved"
      + "\ninternalType cannot be resolved"
      + "\n?: cannot be resolved"
      + "\nschema cannot be resolved"
      + "\ndetails cannot be resolved"
      + "\nindexed cannot be resolved"
      + "\n?: cannot be resolved");
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
