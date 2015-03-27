package cs652.j.semantics;

import org.antlr.symbols.ClassSymbol;
import org.antlr.symbols.FunctionSymbol;
import org.antlr.symbols.MethodSymbol;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Shuai on 3/21/15.
 */
public class JClass extends ClassSymbol{

    public JClass(String name, ParserRuleContext tree) {
        super(name, tree);
    }

}

