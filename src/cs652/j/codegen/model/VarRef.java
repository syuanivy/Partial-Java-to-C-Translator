package cs652.j.codegen.model;

import org.antlr.symbols.VariableSymbol;

/**
 * Created by Shuai on 3/27/15.
 */
public class VarRef extends Expr{
    public String varRef;
    public VarRef(){}
    public VarRef(String varRef){
        this.varRef = varRef;
    }
}
