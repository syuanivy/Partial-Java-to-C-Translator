package cs652.j.semantics;

import org.antlr.symbols.MethodSymbol;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created by Shuai on 3/19/15.
 */
public class JMethod extends MethodSymbol {
    public JMethod(String name, ParserRuleContext tree) {
        super(name, tree);
    }
}
