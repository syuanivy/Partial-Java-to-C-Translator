package cs652.j.codegen.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class MethodDef extends OutputModelObject{
    @ModelElement public TypeSpec retType;
    @ModelElement public FuncName methodName;//T_foo
    @ModelElement public VarRef receiver; // the receiver class
    @ModelElement public List<ParaDef> parameters = new ArrayList<ParaDef>();
    @ModelElement public Block body = new Block();
    @ModelElement public VarRef slot;// the index among all methods of the class

    public MethodDef(){}
    public MethodDef(String name){
        this.methodName = new FuncName(name);
    }

}
