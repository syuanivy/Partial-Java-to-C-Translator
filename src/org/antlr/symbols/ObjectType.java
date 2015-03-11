package org.antlr.symbols;

public class ObjectType implements Type {
	protected ClassSymbol classSymbol;

	public ObjectType(ClassSymbol classSymbol) {
		this.classSymbol = classSymbol;
	}

	public ClassSymbol getClassSymbol() {
		return classSymbol;
	}

	@Override
	public String getName() {
		return classSymbol.getName();
	}

	@Override
	public String toString() {
		return classSymbol.toString();
	}
}