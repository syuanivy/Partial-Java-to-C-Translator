package cs652.j.codegen.model;

import cs652.j.parser.JParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class MethodCall extends Expr{ //a.b.c.foo()
    @ModelElement public FuncName funcName;//T_foo
    @ModelElement public ObjectTypeSpec recType;// receiver type
    @ModelElement public VarRef receiver; //a.b.c
    @ModelElement public List<Expr> args = new ArrayList<Expr>();//a.b.c, arg1,arg2...
    @ModelElement public FuncPtrType funcPtrType = new FuncPtrType() ; //argTypes:c type, arg1 type...

}
