package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class FieldRef extends VarRef{
    @ModelElement public FieldRef entity;

    public FieldRef(String varField){
        super(varField);
    }

}
