package cs652.j.semantics;

import cs652.j.parser.JParser;
import org.antlr.symbols.GlobalScope;
import org.antlr.symbols.Symbol;
import org.antlr.symbols.Type;
import org.antlr.symbols.TypedSymbol;
import org.antlr.symbols.VariableSymbol;

public class ComputeTypes extends SetScopes {
	public static final Type JINT_TYPE = new JPrimitiveType("int");
	public static final Type JFLOAT_TYPE = new JPrimitiveType("int");
	public static final Type JSTRING_TYPE = new JPrimitiveType("string");
	public static final Type JVOID_TYPE = new JPrimitiveType("void");

	public ComputeTypes(GlobalScope globals) {
		this.currentScope = globals;
	}

}

