package cs652.j.codegen.model;

/**
 * Created by Shuai on 3/27/15.
 */
public class LiteralRef extends Expr{
    public String literalRef;
    public LiteralRef(String literal){
        this.literalRef = literal;
    }
}
