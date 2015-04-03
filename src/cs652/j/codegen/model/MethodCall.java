package cs652.j.codegen.model;

import java.util.List;

/**
 * Created by Shuai on 3/27/15.
 */
public class MethodCall extends Expr{
    public Expr funcName;
    public List<Expr> args;
}
