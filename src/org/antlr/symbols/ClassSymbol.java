package org.antlr.symbols;

import cs652.j.codegen.model.VarDef;
import cs652.j.semantics.JClass;
import cs652.j.semantics.JField;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ClassSymbol extends DataAggregateSymbol {
	protected String superClassName; // null if this is Object
	protected int nextFreeMethodSlot = 0; // next slot to allocate

	public ClassSymbol(String name, ParserRuleContext tree) {
		super(name, tree);
	}

	public ClassSymbol(String name) {
		super(name);
	}

	@Override
	public Scope getParentScope() {
		if ( superClassName!=null ) {
			Symbol superClass = getEnclosingScope().resolve(superClassName);
			if (superClass instanceof ClassSymbol) {
				return (Scope) superClass; // parent is not enclosing scope for classes
			}
		}
		return super.getEnclosingScope();
	}

	public void setSuperClass(String superClassName) {
		this.superClassName = superClassName;
		nextFreeMethodSlot = getNumberOfVisibleMethods();
	}

	public void setSlotNumber(Symbol sym) {
		if ( sym instanceof MethodSymbol) {
			MethodSymbol msym = (MethodSymbol)sym;
			// handle inheritance. If not found in this scope, check superclass
			// if any.
			Scope parentScope = getParentScope();
			if ( parentScope instanceof DataAggregateSymbol ) {
				MethodSymbol superMethodSym =
					((DataAggregateSymbol)parentScope).resolveMethod(sym.getName());
				if ( superMethodSym!=null ) {
					msym.slot = superMethodSym.slot;
				}
			}
			if ( msym.slot==-1 ) {
				msym.slot = nextFreeMethodSlot++;
			}
		}
		else {
			super.setSlotNumber(sym);
		}
//		System.out.println(sym.getName()+" is slot "+((MemberSymbol) sym).getSlotNumber());
	}

	public Set<MethodSymbol> getVisibleMethods() {
		Set<MethodSymbol> methods = new LinkedHashSet<>();
		if ( getParentScope() instanceof JClass ) {
			JClass parentScope = (JClass)getParentScope();
			methods.addAll(parentScope.getVisibleMethods());
		}
		for (MemberSymbol s : getSymbols()) {
			if ( s instanceof MethodSymbol ) {
				if ( methods.contains(s) ) {
					methods.remove(s); // override method from superclass
				}
				methods.add((MethodSymbol)s);
			}
		}
		return methods;
	}

	public int getNumberOfVisibleMethods() {
		int n = 0;
		if ( getParentScope() instanceof JClass ) {
			JClass parentScope = (JClass)getParentScope();
			n += parentScope.getNumberOfVisibleMethods();
		}
		for (MemberSymbol s : getSymbols()) {
			if ( s instanceof MethodSymbol ) {
				n++;
			}
		}
		return n;
	}

    public Set<FieldSymbol> getFields(){
        Set<FieldSymbol> fields = new LinkedHashSet<>();
        if(getParentScope() instanceof JClass){
            JClass parentScope = (JClass)getParentScope();
            fields.addAll(parentScope.getFields());
        }

        for (MemberSymbol s : getSymbols()) {
            if ( s instanceof FieldSymbol )
                fields.add((FieldSymbol)s);
        }
        return fields;
    }

	@Override
	public String toString() {
		return name+":"+super.toString();
	}
}
