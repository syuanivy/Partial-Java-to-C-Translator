package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class TypeCast extends Expr{
    public String cast;
    public TypeCast (String cast){
        this.cast = cast;
    }
}
