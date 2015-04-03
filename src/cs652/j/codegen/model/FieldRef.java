package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class FieldRef extends Expr{
    public Expr entity;
    public VarRef varField;

    public FieldRef(String varField){
        this.varField = new VarRef(varField);
    }

}
