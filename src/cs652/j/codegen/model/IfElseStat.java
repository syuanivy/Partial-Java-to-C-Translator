package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class IfElseStat extends IfStat {
    @ModelElement public Stat elseStatement;

    public IfElseStat() {
        super();
    }
}
