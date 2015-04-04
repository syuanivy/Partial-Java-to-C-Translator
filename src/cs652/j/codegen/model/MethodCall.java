package cs652.j.codegen.model;

import cs652.j.parser.JParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class MethodCall extends Expr{
    @ModelElement public FuncName funcName;
    @ModelElement public Expr receiver; //the receiving object
    @ModelElement public List<Expr> args = new ArrayList<Expr>();
    @ModelElement public FuncPtrType funcPtrType = new FuncPtrType() ;

}
