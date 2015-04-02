package cs652.j.codegen;

import cs652.j.codegen.model.*;
import cs652.j.parser.JBaseVisitor;
import cs652.j.parser.JParser;
import cs652.j.semantics.JClass;
import cs652.j.semantics.JField;
import org.antlr.symbols.Scope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator extends JBaseVisitor<OutputModelObject> {
	public STGroup templates;
	public String fileName;

	public Scope currentScope;
	public JClass currentClass;

	public CodeGenerator(String fileName) {
		this.fileName = fileName;
		templates = new STGroupFile("cs652/j/templates/C.stg");
	}

	public CFile generate(ParserRuleContext tree) {
		CFile file = (CFile)visit(tree);
		return file;
	}

    @Override
    public OutputModelObject visitFile(@NotNull JParser.FileContext ctx) {
        CFile file = new CFile(fileName);
        for(JParser.ClassDeclarationContext c: ctx.classDeclaration()){
            file.classes.add((ClassDef)visitClassDeclaration(c));
        }

        file.main = (MainMethod) visitMain(ctx.main());
        return file;
    }

    @Override
    public OutputModelObject visitClassDeclaration(@NotNull JParser.ClassDeclarationContext ctx) {
        ClassDef c = new ClassDef(ctx.Identifier().getText());
        if(ctx.type() != null)
            c.setSuperClass(ctx.type().getText());
        List<JParser.ClassBodyDeclarationContext> bodies = ctx.classBody().classBodyDeclaration();
        for(JParser.ClassBodyDeclarationContext member: bodies ){
            JParser.FieldDeclarationContext field = member.memberDeclaration().fieldDeclaration();
            JParser.MethodDeclarationContext method = member.memberDeclaration().methodDeclaration();
            if(field != null)
                c.fields.add((VarDef)visitFieldDeclaration(field));
            else
                c.methods.add((MethodDef)visitMethodDeclaration(method));
        }
        return c;
    }

    @Override
    public OutputModelObject visitFieldDeclaration(@NotNull JParser.FieldDeclarationContext ctx) {
        VarDef varDef = new VarDef(ctx.type().getText(), ctx.variableDeclarator().Identifier().getText());
        return varDef;
    }

    @Override
    public OutputModelObject visitMethodDeclaration(@NotNull JParser.MethodDeclarationContext ctx) {
        MethodDef method = new MethodDef(ctx.type().getText(), ctx.Identifier().getText());
        for(JParser.FormalParameterContext par : ctx.formalParameters().formalParameterList().formalParameter()){
            method.parameters.add(new VarDef(par.type().getText(), par.variableDeclarator().Identifier().getText()));
        }
        method.body = (Block) visitBlock(ctx.methodBody().block());
        return method;
    }

    @Override
    public OutputModelObject visitMain(@NotNull JParser.MainContext ctx) {
        MainMethod main = new MainMethod();
        List<JParser.BlockStatementContext> blockStatements = ctx.blockStatement();
        for(JParser.BlockStatementContext stat : blockStatements){
            main.statements.add((Stat) visitBlockStatement(stat));
        }
        return main;
    }

    @Override
    public OutputModelObject visitLocalVariableDeclaration(@NotNull JParser.LocalVariableDeclarationContext ctx) {
        VarDef varDef = new VarDef(ctx.type().getText(), ctx.variableDeclarator().Identifier().getText());
        return varDef;
    }

    @Override
    public OutputModelObject visitBlockStat(@NotNull JParser.BlockStatContext ctx) {
        Block block  = new Block();
        List<JParser.BlockStatementContext> blockstats = new ArrayList<JParser.BlockStatementContext>();
        for(JParser.BlockStatementContext bs : blockstats)
            block.statements.add((Stat)visitBlockStatement(bs));
        return block;
    }

    @Override
    public OutputModelObject visitBlock(@NotNull JParser.BlockContext ctx) {
        Block block  = new Block();
        List<JParser.BlockStatementContext> blockstats = new ArrayList<JParser.BlockStatementContext>();
        for(JParser.BlockStatementContext bs : blockstats)
            block.statements.add((Stat)visitBlockStatement(bs));
        return block;
    }

    @Override
    public OutputModelObject visitBlockStatement(@NotNull JParser.BlockStatementContext ctx) {

        JParser.LocalVariableDeclarationStatementContext localVarStat = ctx.localVariableDeclarationStatement();
        if(localVarStat != null)
            return visitLocalVariableDeclaration(localVarStat.localVariableDeclaration());
        else{
            JParser.StatementContext s = ctx.statement();
            return visit(s);
        }
    }

    @Override
    public OutputModelObject visitIfStat(@NotNull JParser.IfStatContext ctx) {
        if(ctx.elseStat == null){
            IfStat ifStat = new IfStat();
            ifStat.condition = (Expr) visitParExpression(ctx.ifCond);
            ifStat.statement = (Stat) visit(ctx.ifStat);
            return ifStat;
        }else{
            IfElseStat ifElseStat = new IfElseStat();
            ifElseStat.condition = (Expr) visitParExpression(ctx.ifCond);
            ifElseStat.statement = (Stat) visit(ctx.ifStat);
            ifElseStat.elseStatement = (Stat) visit(ctx.elseStat);
            return ifElseStat;
        }
    }

    @Override
    public OutputModelObject visitWhileStat(@NotNull JParser.WhileStatContext ctx) {
        WhileStat whileStat = new WhileStat();
        whileStat.condition = (Expr) visitParExpression(ctx.whileCond);
        whileStat.statement = (Stat) visit(ctx.whileStat);
        return whileStat;
    }

    @Override
    public OutputModelObject visitReturnStat(@NotNull JParser.ReturnStatContext ctx) {
        ReturnStat returnStat = new ReturnStat();
        returnStat.expr = (Expr) visit(ctx.retExp);
        return returnStat;
    }

    @Override
    public OutputModelObject visitPrintStat(@NotNull JParser.PrintStatContext ctx) {
        //String only
        if(ctx.expressionList() == null){
            PrintStringStat printStringStat = new PrintStringStat(ctx.StringLiteral().getText());
            return printStringStat;
        }//String and arguments
        else{
            PrintStat printStat = new PrintStat(ctx.StringLiteral().getText());
            List<JParser.ExpressionContext> exprs= ctx.expressionList().expression();
            for(JParser.ExpressionContext arg : exprs){
                printStat.args.add((Expr) visit(arg));
            }
            return printStat;
        }
    }

    @Override
    public OutputModelObject visitStatExpr(@NotNull JParser.StatExprContext ctx) {
        return visit(ctx.statementExpression().expression());
    }

    @Override
    public OutputModelObject visitAssignStat(@NotNull JParser.AssignStatContext ctx) {
        AssignStat assignStat = new AssignStat();
        assignStat.left = (Expr) visit(ctx.left);
        assignStat.right = (Expr) visit(ctx.right);
        return assignStat;
    }
}
