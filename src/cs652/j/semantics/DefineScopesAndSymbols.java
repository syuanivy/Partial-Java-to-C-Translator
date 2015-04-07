package cs652.j.semantics;

import cs652.j.parser.JBaseListener;
import cs652.j.parser.JParser;
import org.antlr.symbols.*;
import org.antlr.v4.runtime.misc.NotNull;

public class DefineScopesAndSymbols extends JBaseListener {
	public Scope currentScope;

    public static final Type JPrimitive_INT = new JPrimitiveType("int");
    public static final Type JPrimitive_FLOAT = new JPrimitiveType("float");
    public static final Type JPrimitive_VOID = new JPrimitiveType("void");
    public static final JMethod JMethod_Printf = new JMethod("printf",null);


	public DefineScopesAndSymbols(GlobalScope globals) {
		pushScope(globals);
        PredefinedScope predefinedScope = new PredefinedScope();
        predefinedScope.define((Symbol)JPrimitive_INT);
        predefinedScope.define((Symbol)JPrimitive_FLOAT);
        predefinedScope.define((Symbol)JPrimitive_VOID);
        JMethod_Printf.setType(JPrimitive_VOID);
        predefinedScope.define(JMethod_Printf);
        currentScope.setEnclosingScope(predefinedScope);
	}

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
        JClass c = new JClass(ctx.Identifier().getText(), ctx);
        c.setEnclosingScope(currentScope);
        currentScope.define(c);
        ctx.scope = c;
        pushScope(c);
        //set super if c extends other classes
        if(ctx.type() != null)
            c.setSuperClass(ctx.type().getText());

    }

    @Override
    public void exitClassDeclaration(@NotNull JParser.ClassDeclarationContext ctx) {
        popScope();
    }

    @Override
    public void enterFormalParameter(@NotNull JParser.FormalParameterContext ctx){
        JArg arg = new JArg(currentScope, ctx.variableDeclarator().Identifier().getText());
        Type argT = (Type) currentScope.resolve(ctx.type().getText());
        arg.setType(argT);
        currentScope.define(arg);
    }

    @Override
    public void enterFieldDeclaration(@NotNull JParser.FieldDeclarationContext ctx){
        JField field = new JField(currentScope, ctx.variableDeclarator().Identifier().getText());
        Type fieldT = (Type) currentScope.resolve(ctx.type().getText());
        field.setType(fieldT);
        currentScope.define(field);
    }

    @Override public void enterMethodDeclaration(@NotNull JParser.MethodDeclarationContext ctx) {
        JMethod m = new JMethod(ctx.Identifier().getText(), ctx);
        ctx.scope = m;
        m.setEnclosingScope(currentScope);
        currentScope.define(m);
        //resolve return type of the method
        Type retT;
        if(ctx.type() != null)
            retT = (Type)currentScope.resolve(ctx.type().getText());
        else
            retT = (Type)currentScope.resolve("void");
        m.setType(retT);

        pushScope(m);
    }

    @Override
    public void exitMethodDeclaration(@NotNull JParser.MethodDeclarationContext ctx) {
        popScope();
    }

    @Override
    public void enterBlock(@NotNull JParser.BlockContext ctx) {
        LocalScope l = new LocalScope(currentScope);//set current as enclosing
        ctx.scope = l;
        pushScope(l);
    }

    @Override
    public void exitBlock(@NotNull JParser.BlockContext ctx) {
        popScope();
    }

    @Override
    public void enterLocalVariableDeclaration(@NotNull JParser.LocalVariableDeclarationContext ctx){
        JVar var = new JVar(currentScope, ctx.variableDeclarator().Identifier().getText());
        Type varT = (Type) currentScope.resolve(ctx.type().getText());
        var.setType(varT);
        currentScope.define(var);
    }

    private void pushScope(Scope s) {
        currentScope = s;
    }

    private void popScope() {
        currentScope = currentScope.getEnclosingScope();
    }
}

