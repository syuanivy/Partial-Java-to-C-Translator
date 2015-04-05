package cs652.j.codegen.model;

/**
 * Created by Shuai on 4/5/15.
 */
public class ExprStat extends Stat {
    @ModelElement public Expr expr;
    public ExprStat(Expr expr){
        this.expr = expr;
    }
}
