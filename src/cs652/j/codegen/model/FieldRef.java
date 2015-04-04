package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class FieldRef extends Expr{
    @ModelElement public FieldRef entity;
    @ModelElement public VarRef varField;

    public FieldRef(String varField){
        this.varField = new VarRef(varField);
    }

}
