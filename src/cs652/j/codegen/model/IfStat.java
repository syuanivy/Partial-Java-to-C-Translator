package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class IfStat extends Stat{
    @ModelElement public Expr condition;
    @ModelElement public Stat statement;
}
