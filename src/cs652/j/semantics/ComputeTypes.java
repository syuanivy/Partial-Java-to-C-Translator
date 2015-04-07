package cs652.j.semantics;

import cs652.j.parser.JParser;
import org.antlr.symbols.GlobalScope;
import org.antlr.symbols.Scope;
import org.antlr.symbols.Symbol;
import org.antlr.symbols.Type;
import org.antlr.symbols.TypedSymbol;
import org.antlr.v4.runtime.misc.NotNull;



public class ComputeTypes extends SetScopes {
    public static final Type JPrimitive_String = new JPrimitiveType("String");

    public ComputeTypes(GlobalScope globals) {
        globals.define((Symbol)JPrimitive_String);
        pushScope(globals);
    }

    @Override
    public void exitMethodCalExpr(@NotNull JParser.MethodCalExprContext ctx) {
        ctx.expressionType = ctx.expression().expressionType;
    }

    @Override
    public void exitNewExpr(@NotNull JParser.NewExprContext ctx) {
        ctx.expressionType = (JClass) currentScope.resolve(ctx.creator().type().getText());
    }

    @Override
    public void exitDotExpr(@NotNull JParser.DotExprContext ctx) {
        JClass c = (JClass) ctx.expression().expressionType;
        if(c != null) {
            String name = ctx.dotID.getText();
            Symbol id = c.resolve(name);
            TypedSymbol t = (TypedSymbol) id;
            ctx.expressionType = t.getType();
        }
    }

    //this, int, float, string, Identifier, null
    @Override
    public void exitThisExpr(@NotNull JParser.ThisExprContext ctx) {
        JClass c = getThisClass(currentScope);
        ctx.expressionType = c;
    }

    @Override
    public void exitIntLiteralExpr(@NotNull JParser.IntLiteralExprContext ctx) {
        ctx.expressionType = JPrimitive_INT;
    }

    @Override
    public void exitFloatLiteralExpr(@NotNull JParser.FloatLiteralExprContext ctx) {
        ctx.expressionType = JPrimitive_FLOAT;
    }

    @Override
    public void exitStringLiteralExpr(@NotNull JParser.StringLiteralExprContext ctx) {
        ctx.expressionType = JPrimitive_String;
    }

    @Override
    public void exitNullExpr(@NotNull JParser.NullExprContext ctx) {
        ctx.expressionType = JPrimitive_VOID;
    }

    @Override
    public void exitIdentifierExpr(@NotNull JParser.IdentifierExprContext ctx) {
        Symbol s = currentScope.resolve(ctx.Identifier().getText());
        if(s != null)
            ctx.expressionType = ((TypedSymbol)s).getType();
    }

    public JClass getThisClass(Scope s){
        while(s != null){
            if(s instanceof JClass)
                return (JClass) s;
            s = s.getEnclosingScope();
        }
        return null;
    }
}

