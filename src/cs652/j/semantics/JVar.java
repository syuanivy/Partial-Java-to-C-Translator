package cs652.j.semantics;

import org.antlr.symbols.Scope;
import org.antlr.symbols.VariableSymbol;

/**
 * Created by Shuai on 3/21/15.
 */
public class JVar extends VariableSymbol {
    public JVar(Scope scope, String name) {
        super(scope, name);
    }
}
