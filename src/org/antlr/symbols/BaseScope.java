package org.antlr.symbols;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BaseScope implements Scope {
	protected Scope enclosingScope; // null if global (outermost) scope

	protected  Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();

	public BaseScope() { }

	public BaseScope(Scope enclosingScope) { setEnclosingScope(enclosingScope);	}


	@Override
	public Symbol getSymbol(String name) {
		return symbols.get(name);
	}

	@Override
	public void setEnclosingScope(Scope enclosingScope) {
		this.enclosingScope = enclosingScope;
	}

	@Override
	public List<Scope> getNestedScopes() {
		List<? extends Symbol> scopes = Utils.filter(getSymbols(), s -> s instanceof Scope);
		return (List)scopes; // force it to cast
	}

	@Override
	public Symbol resolve(String name) {
		Symbol s = symbols.get(name);
		if ( s!=null ) {
			return s;
		}
		// if not here, check any enclosing scope
		Scope parent = getParentScope();
		if ( parent != null ) return parent.resolve(name);
		return null; // not found
	}

	public void define(Symbol sym) throws IllegalArgumentException {
//		System.out.println("def "+sym.getName());
		if ( symbols.containsKey(sym.getName()) ) {
			throw new IllegalArgumentException("duplicate symbol "+sym.getName());
		}
		sym.setScope(this);
		sym.setInsertionOrderNumber(symbols.size()); // set to insertion position from 0
		symbols.put(sym.getName(), sym);
	}

	public Scope getParentScope() { return getEnclosingScope(); }
	public List<Scope> getParentScopes() {
		return new ArrayList<Scope>() {{add(getParentScope());}};
	}
	public Scope getEnclosingScope() { return enclosingScope; }

	/** Walk up enclosingScope until we find topmost. Note this is
	 *  enclosing scope not necessarily parent.
	 */

	@Override
	public List<Scope> getEnclosingPathToRoot() {
		List<Scope> scopes = new ArrayList<>();
		Scope s = this;
		while ( s.getEnclosingScope()!=null ) {
			scopes.add(s);
			s = s.getEnclosingScope();
		}
		return scopes;
	}

	@Override
	public List<? extends Symbol> getSymbols() {
		Collection<Symbol> values = symbols.values();
		if ( values instanceof List ) {
			return (List<Symbol>)values;
		}
		return new ArrayList<>(values);
	}

	public List<? extends Symbol> getAllSymbols() {
		List<Symbol> syms = new ArrayList<>();
		syms.addAll(getSymbols());
		for (Symbol s : symbols.values()) {
			if ( s instanceof Scope ) {
				Scope scope = (Scope)s;
				syms.addAll(scope.getAllSymbols());
			}
		}
		return syms;
	}

	@Override
	public int getNumberOfSymbols() {
		return symbols.size();
	}

	@Override
	public Set<String> getSymbolNames() {
		return symbols.keySet();
	}

	public String toString() { return symbols.keySet().toString(); }

}
