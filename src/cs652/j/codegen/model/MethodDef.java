package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class MethodDef extends OutputModelObject{
    public String retType;
    public String methodName;
    @ModelElement public List<VarDef> parameters = new ArrayList<VarDef>();
    @ModelElement public Block body = new Block();

    public MethodDef(){}
    public MethodDef(String ret, String name){
        this.retType = ret;
        this.methodName = name;
    }

}
