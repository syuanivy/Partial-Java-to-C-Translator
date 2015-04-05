package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class AssignStat extends Stat {
    @ModelElement public Expr left;
    @ModelElement public Expr right;



}
