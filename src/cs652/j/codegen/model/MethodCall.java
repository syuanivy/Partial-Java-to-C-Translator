package cs652.j.codegen.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class MethodCall extends Expr{ //a.b.c.foo()
    @ModelElement public FuncName funcName;//T_foo
    @ModelElement public ObjectTypeSpec recType;// receiver type
    @ModelElement public Expr receiver; //a.b.c, a, this
    @ModelElement public List<Expr> args = new ArrayList<>(); //<cast><arg>
    @ModelElement public FuncPtrType funcPtrType = new FuncPtrType() ; //argTypes:c type, arg1 type...

}
