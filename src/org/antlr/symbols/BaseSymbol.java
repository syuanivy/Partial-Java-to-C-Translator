package org.antlr.symbols;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Collections;
import java.util.List;

public class BaseSymbol implements Symbol {
	protected final String name;   	// All symbols at least have a name
	protected Type type;
	protected Scope scope;      	// All symbols know what scope contains them.
	protected TerminalNode idNode;	// points at ID node in tree, in the AST?
	protected int lexicalOrder; 	// order seen or insertion order from 0; compilers often need this

	public BaseSymbol(String name) { this.name = name; }
	public BaseSymbol(Scope scope, String name) {
		this(name);
		this.scope = scope;
	}
	@Override public String getName() { return name; }
	@Override public Scope getScope() { return scope; }
	@Override public void setScope(Scope scope) { this.scope = scope; }

	public Type getType() { return type; }
	public void setType(Type type) { this.type = type; }

	@Override
	public boolean equals(Object obj) {
		if ( !(obj instanceof Symbol) ) {
			return false;
		}
        if ( obj==this ) {
			return true;
		}
		return name.equals(((Symbol)obj).getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public int getInsertionOrderNumber() {
		return lexicalOrder;
	}

	@Override
	public void setInsertionOrderNumber(int i) {
		this.lexicalOrder = i;
	}

	@Override
	public String getFullyQualifiedName(String scopePathSeparator) {
		List<Scope> path = scope.getEnclosingPathToRoot();
		Collections.reverse(path);
		String qualifier = Utils.joinScopeNames(path, scopePathSeparator);
		return qualifier + scopePathSeparator + name;
	}

	public String toString() {
		String s = "";
		if ( scope!=null ) s = scope.getScopeName()+".";
		if ( type!=null ) return '<'+s+getName()+"."+type+'>';
		return s+getName();
	}
}