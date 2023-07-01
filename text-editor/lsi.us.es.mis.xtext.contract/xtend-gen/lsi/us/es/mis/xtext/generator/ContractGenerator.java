package lsi.us.es.mis.xtext.generator;

import javax.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

@SuppressWarnings("all")
public class ContractGenerator extends AbstractGenerator {
  @Inject
  private SolidityGenerator genSol;
  
  @Inject
  private HyperledgerGenerator genHyper;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.genSol.doGenerate(resource, fsa, context);
    this.genHyper.doGenerate(resource, fsa, context);
  }
}
