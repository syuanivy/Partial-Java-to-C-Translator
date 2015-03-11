package org.antlr.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

public class FunctionSymbol extends SymbolWithScope implements TypedSymbol {
	protected  ParserRuleContext tree;
	protected  Type retType;

	public FunctionSymbol(String name, ParserRuleContext tree) {
		super(name);
		this.tree = tree;
	}

	@Override
	public Type getType() {
		return retType;
	}

	@Override
	public void setType(Type type) {
		retType = type;
	}
}
