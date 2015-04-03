package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class CtorCall extends Expr{
    public String ctor;
    public CtorCall(String ctor){
        this.ctor = ctor;
    }
}
