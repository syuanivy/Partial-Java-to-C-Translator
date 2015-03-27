package cs652.j.semantics;

import org.antlr.symbols.Scope;
import org.antlr.symbols.Symbol;
import org.antlr.symbols.Type;

/**
 * Created by Shuai on 3/26/15.
 */
public class JClassType implements Symbol, Type{
    protected  String name;
    public JClassType(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Scope getScope() {
        return null;
    }

    @Override
    public void setScope(Scope scope) {

    }

    @Override
    public int getInsertionOrderNumber() {
        return 0;
    }

    @Override
    public void setInsertionOrderNumber(int i) {

    }

    @Override
    public String getFullyQualifiedName(String scopePathSeparator) {
        return null;
    }
}
