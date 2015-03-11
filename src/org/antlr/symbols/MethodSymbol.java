package org.antlr.symbols;

import org.antlr.v4.runtime.ParserRuleContext;

/** A method symbol is a function of lives within an aggregate/class. */
public class MethodSymbol extends SymbolWithScope implements TypedSymbol, MemberSymbol {
	protected ParserRuleContext tree;
	protected Type retType;
	protected int slot = -1;

	public MethodSymbol(String name, ParserRuleContext tree) {
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

	@Override
	public int getSlotNumber() { return slot; }

	public String toString() { return name+":"+super.toString(); }
}
