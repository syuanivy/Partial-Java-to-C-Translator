package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class VarDef extends OutputModelObject{
    public String typeName;
    public String varName;

    public VarDef(String typeName, String varName){
        this.typeName = typeName;
        this.varName = varName;
    }
}
