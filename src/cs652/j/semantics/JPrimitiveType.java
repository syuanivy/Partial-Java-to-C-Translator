package cs652.j.semantics;

import org.antlr.symbols.PrimitiveType;
import org.antlr.symbols.Scope;
import org.antlr.symbols.Symbol;

/**
 * Created by Shuai on 3/19/15.
 */
public class JPrimitiveType extends PrimitiveType implements Symbol {


    public JPrimitiveType(String name) {
        super(name);
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

