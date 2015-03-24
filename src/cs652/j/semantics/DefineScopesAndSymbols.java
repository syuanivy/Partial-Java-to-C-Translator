package cs652.j.semantics;

import cs652.j.parser.JBaseListener;
import cs652.j.parser.JParser;
import org.antlr.symbols.*;
import org.antlr.v4.runtime.misc.NotNull;

public class DefineScopesAndSymbols extends JBaseListener {
	public Scope currentScope;

	public DefineScopesAndSymbols(GlobalScope globals) {
		currentScope = globals;
	}

    @Override
    public void enterFile(@NotNull JParser.FileContext ctx) {
        GlobalScope g = new GlobalScope(null);
        ctx.scope = g;
        pushScope(g);
    }

    @Override
    public void exitFile(@NotNull JParser.FileContext ctx) {
        popScope();
    }

    @Override
    public void enterClassDeclaration(@NotNull JParser.ClassDeclarationContext ctx)  {
        JClass f = new FunctionSymbol(ctx..getText(), ctx);
        f.setEnclosingScope(currentScope);
        currentScope.define(f);
        ctx.scope = f;
        pushScope(f);
    }

    @Override
    public void exitFunc(@NotNull JParser.FuncContext ctx) {
        popScope();
    }

    @Override
    public void enterBlock(@NotNull JParser.BlockContext ctx) {
        LocalScope l = new LocalScope(currentScope);
        ctx.scope = l;
        pushScope(l);
    }

    @Override
    public void exitBlock(@NotNull JParser.BlockContext ctx) {
        popScope();
    }

    @Override
    public void enterVar(@NotNull JParser.VarContext ctx) {
        VariableSymbol v = new VariableSymbol(currentScope, ctx.ID().getText());
        currentScope.define(v);
    }

    @Override
    public void enterArg(@NotNull JParser.ArgContext ctx) {
        VariableSymbol v = new VariableSymbol(currentScope, ctx.ID().getText());
        currentScope.define(v);
    }

    private void pushScope(Scope s) {
        currentScope = s;
        System.out.println("entering: "+currentScope.getScopeName()+":"+s);
    }

    private void popScope() {
        System.out.println("leaving: "+currentScope.getScopeName()+":"+currentScope);
        currentScope = currentScope.getEnclosingScope();
    }
}

