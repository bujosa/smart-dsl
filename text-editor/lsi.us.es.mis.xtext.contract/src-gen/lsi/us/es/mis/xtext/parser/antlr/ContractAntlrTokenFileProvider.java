/*
 * generated by Xtext 2.25.0
 */
package lsi.us.es.mis.xtext.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ContractAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("lsi/us/es/mis/xtext/parser/antlr/internal/InternalContract.tokens");
	}
}
