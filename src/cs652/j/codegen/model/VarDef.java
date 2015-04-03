package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class VarDef extends OutputModelObject{
    public TypeSpec typeSpec;
    public String varName;

    public VarDef(String varName){
        this.varName = varName;
    }
}
