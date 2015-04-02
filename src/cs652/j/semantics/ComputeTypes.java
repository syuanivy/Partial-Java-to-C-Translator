package cs652.j.semantics;

import cs652.j.JTran;
import cs652.j.parser.JParser;
import org.antlr.symbols.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public class ComputeTypes extends SetScopes {
    public static final Type JPrimitive_String = new JPrimitiveType("String");

    public ComputeTypes(GlobalScope globals) {
        globals.define((Symbol)JPrimitive_String);
        pushScope(globals);
    }

    @Override
    public void exitExpression(@NotNull JParser.ExpressionContext ctx) {

        //if expression is primary
        if(ctx.primary() != null){
            //this
            if(ctx.primary().getText().equals("this")){
                JClass c = getThisClass(currentScope);
                ctx.expressionType = c;
                System.out.println("\"this\" resolved to be " + c.getName());
            }

            //literal
            else if(ctx.primary().literal() != null){
                if(ctx.primary().literal().IntegerLiteral() != null){
                    ctx.expressionType = JPrimitive_INT;
                    System.out.println(ctx.primary().literal().IntegerLiteral().getText()+
                            " resolved to be " +
                            JPrimitive_INT.getName());

                }
                if(ctx.primary().literal().FloatPointLiteral() != null){
                    ctx.expressionType = JPrimitive_FLOAT;
                    System.out.println(ctx.primary().literal().FloatPointLiteral().getText()+" resolved to be " + JPrimitive_FLOAT.getName());
                }

                if(ctx.primary().literal().StringLiteral() != null){
                    ctx.expressionType = JPrimitive_String;
                    System.out.println(ctx.primary().literal().StringLiteral().getText()+" resolved to be " + JPrimitive_String.getName());
                }

                if(ctx.primary().literal().getText().equals("null")){
                    ctx.expressionType = JPrimitive_VOID;
                    System.out.println("\"null\" resolved to be " + JPrimitive_VOID);
                }

            }

            //Identifier
            else if(ctx.primary().Identifier() != null){
                Symbol s = currentScope.resolve(ctx.primary().Identifier().getText());
                if(s != null){
                    ctx.expressionType = ((TypedSymbol)s).getType();
                    System.out.println(ctx.primary().Identifier().getText()+" resolved to be " +   ((TypedSymbol)s).getType().getName());
                }

            }
        }
        //if expression is a.xxx dot expression
        else if(ctx.dotExpr != null){

            JClass c = (JClass) ctx.dotExpr.expressionType;
            if(c != null) {
                String name = ctx.dotID.getText();
                Symbol id = c.resolve(name);
                TypedSymbol t = (TypedSymbol) id;
                ctx.expressionType = t.getType();
                System.out.println(ctx.dotExpr.getText()+ "." + ctx.dotID.getText() + " resolved to be " + t.getType().getName());
            }

        }

        //if expression is a method call
        else if(ctx.methodCallExpr != null){
            ctx.expressionType = ctx.methodCallExpr.expressionType;
        }

        //if expression is creator
        else if(ctx.newExpr != null){
            ctx.expressionType = (JClass) currentScope.resolve(ctx.newExpr.getText());
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

