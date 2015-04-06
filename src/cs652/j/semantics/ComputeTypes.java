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
           // System.out.println(ctx.expression().getText()+ "." + ctx.dotID.getText() + " resolved to be " + t.getType().getName());
        }
    }

	// please add alternative labels to your grammar so that you don't have to parse here in your listener

    @Override
    public void exitPrimaryExpr(@NotNull JParser.PrimaryExprContext ctx) {
        //this
        if(ctx.primary().getText().equals("this")){
            JClass c = getThisClass(currentScope);
            ctx.expressionType = c;
           // System.out.println("\"this\" resolved to be " + c.getName());
        }

        //literal
        else if(ctx.primary().literal() != null){
            if(ctx.primary().literal().IntegerLiteral() != null){
                ctx.expressionType = JPrimitive_INT;
            /*    System.out.println(ctx.primary().literal().IntegerLiteral().getText()+
                        " resolved to be " +
                        JPrimitive_INT.getName());*/

            }
            if(ctx.primary().literal().FloatPointLiteral() != null){
                ctx.expressionType = JPrimitive_FLOAT;
             //   System.out.println(ctx.primary().literal().FloatPointLiteral().getText()+" resolved to be " + JPrimitive_FLOAT.getName());
            }

            if(ctx.primary().literal().StringLiteral() != null){
                ctx.expressionType = JPrimitive_String;
             //   System.out.println(ctx.primary().literal().StringLiteral().getText()+" resolved to be " + JPrimitive_String.getName());
            }

            if(ctx.primary().literal().getText().equals("null")){
                ctx.expressionType = JPrimitive_VOID;
             //   System.out.println("\"null\" resolved to be " + JPrimitive_VOID);
            }

        }

        //Identifier
        else if(ctx.primary().Identifier() != null){
            Symbol s = currentScope.resolve(ctx.primary().Identifier().getText());
            if(s != null){
                ctx.expressionType = ((TypedSymbol)s).getType();
            //    System.out.println(ctx.primary().Identifier().getText()+" resolved to be " +   ((TypedSymbol)s).getType().getName());
            }

        }
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

