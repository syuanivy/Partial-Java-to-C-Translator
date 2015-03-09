package cs652.j.semantics;

import cs652.j.parser.JBaseListener;
import cs652.j.parser.JParser;
import org.antlr.symbols.GlobalScope;
import org.antlr.symbols.LocalScope;
import org.antlr.symbols.Scope;
import org.antlr.symbols.Type;
import org.antlr.symbols.VariableSymbol;

public class DefineScopesAndSymbols extends JBaseListener {
	public Scope currentScope;

	public DefineScopesAndSymbols(GlobalScope globals) {
		currentScope = globals;
	}
}
