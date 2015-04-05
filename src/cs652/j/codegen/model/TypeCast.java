package cs652.j.codegen.model;

import java.time.Year;

/**
 * Created by Shuai on 3/27/15.
 */
public class TypeCast extends Expr{
    @ModelElement public TypeSpec castTypeSpec;
    @ModelElement public Expr expr;
    public TypeCast(TypeSpec typeSpec){
        this.castTypeSpec = typeSpec;
    }
}
