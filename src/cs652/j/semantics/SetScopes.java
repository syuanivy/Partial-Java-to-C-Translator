package cs652.j.semantics;

import cs652.j.parser.JBaseListener;
import cs652.j.parser.JParser;
import org.antlr.symbols.*;
import org.antlr.v4.runtime.misc.NotNull;

public class SetScopes extends JBaseListener{
    public Scope currentScope;

    public static final Type JPrimitive_INT = new JPrimitiveType("int");
    public static final Type JPrimitive_FLOAT = new JPrimitiveType("float");
    public static final Type JPrimitive_VOID = new JPrimitiveType("void");
    public static final JMethod JMethod_Printf = new JMethod("printf",null);
    public SetScopes(){}


    @Override
    public void enterFile(@NotNull JParser.FileContext ctx) {
        ctx.scope = (GlobalScope)currentScope;
    }

    @Override
    public void exitFile(@NotNull JParser.FileContext ctx) {
        popScope();
    }

    @Override
    public void enterClassDeclaration(@NotNull JParser.ClassDeclarationContext ctx)  {
        pushScope(ctx.scope);
    }

    @Override
    public void exitClassDeclaration(@NotNull JParser.ClassDeclarationContext ctx) {
        popScope();
    }



    @Override public void enterMethodDeclaration(@NotNull JParser.MethodDeclarationContext ctx) {
        pushScope(ctx.scope);
    }


    @Override public void exitMethodDeclaration(@NotNull JParser.MethodDeclarationContext ctx) {
        popScope();
    }

    @Override
    public void enterBlock(@NotNull JParser.BlockContext ctx) {
        pushScope(ctx.scope);
    }

    @Override
    public void exitBlock(@NotNull JParser.BlockContext ctx) {
        popScope();
    }


    protected void pushScope(Scope s) {
        currentScope = s;
        System.out.println("entering: "+currentScope.getScopeName());
    }

    protected void popScope() {
        System.out.println("leaving: "+currentScope.getScopeName());
        currentScope = currentScope.getEnclosingScope();
    }

}
