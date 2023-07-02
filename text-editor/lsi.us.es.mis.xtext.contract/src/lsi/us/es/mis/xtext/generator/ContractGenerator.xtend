package lsi.us.es.mis.xtext.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import javax.inject.Inject


class ContractGenerator extends AbstractGenerator {

	@Inject SolidityGenerator genSol
	@Inject HyperledgerGenerator genHyper
	@Inject FireflyInterfaceGenerator genFFI
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
	    genSol.doGenerate(resource, fsa, context);
	    genHyper.doGenerate(resource, fsa, context);
	    genFFI.doGenerate(resource, fsa, context);
	}
}
/* Author: David Bujosa */