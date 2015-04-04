package cs652.j.codegen;

import com.sun.codemodel.internal.ClassType;
import cs652.j.JTran;
import cs652.j.codegen.model.*;
import cs652.j.parser.JBaseVisitor;
import cs652.j.parser.JParser;
import cs652.j.semantics.JClass;
import cs652.j.semantics.JField;
import cs652.j.semantics.JMethod;
import cs652.j.semantics.JVar;
import org.antlr.symbols.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator extends JBaseVisitor<OutputModelObject> {
	public STGroup templates;
	public String fileName;

	public Scope currentScope = null;
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
        pushScope(ctx.scope);
        CFile file = new CFile(fileName);
        for(JParser.ClassDeclarationContext c: ctx.classDeclaration()){
            file.classes.add((ClassDef)visitClassDeclaration(c));
        }

        file.main = (MainMethod) visitMain(ctx.main());
        popScope();
        return file;
    }

    @Override
    public OutputModelObject visitClassDeclaration(@NotNull JParser.ClassDeclarationContext ctx) {
        pushScope(ctx.scope);
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
                c.methods.add((MethodDef)visitMethodDeclarationHelper(method, ctx.Identifier().getText()));
        }
        popScope();
        return c;
    }

    @Override
    public OutputModelObject visitFieldDeclaration(@NotNull JParser.FieldDeclarationContext ctx) {
        VarDef varDef = new VarDef(ctx.variableDeclarator().Identifier().getText());
        varDef.typeSpec = (TypeSpec) visitType(ctx.type());
        return varDef;
    }

    public OutputModelObject visitMethodDeclarationHelper(@NotNull JParser.MethodDeclarationContext ctx, String receiverClass){
        pushScope(ctx.scope);
        MethodDef method = (MethodDef)visitMethodDeclaration(ctx);
        method.receiver = new VarRef(receiverClass);
        popScope();
        return method;
    }
    @Override
    public OutputModelObject visitMethodDeclaration(@NotNull JParser.MethodDeclarationContext ctx) {
        MethodDef method = new MethodDef(ctx.Identifier().getText());
        method.retType = (TypeSpec) visitType(ctx.type());
        method.slot = new VarRef(String.valueOf(ctx.scope.getSlotNumber()));
        for(JParser.FormalParameterContext par : ctx.formalParameters().formalParameterList().formalParameter()){
            VarDef p = new VarDef(par.variableDeclarator().Identifier().getText());
            p.typeSpec = (TypeSpec) visitType(ctx.type());
            method.parameters.add(p);
        }
        method.body = (Block) visitBlock(ctx.methodBody().block());
        return method;
    }

    @Override
    public OutputModelObject visitType(@NotNull JParser.TypeContext ctx) {
        if(ctx.classType() != null){
            ObjectTypeSpec objectTypeSpec = new ObjectTypeSpec(ctx.classType().getText());
            return objectTypeSpec;
        }else{
            PrimitiveTypeSpec primitiveTypeSpec = new PrimitiveTypeSpec(ctx.primitiveType().getText());
            return primitiveTypeSpec;
        }
    }

    @Override
    public OutputModelObject visitMain(@NotNull JParser.MainContext ctx) {
        MainMethod main = new MainMethod();
        List<JParser.BlockStatementContext> blockStatements = ctx.blockStatement();
        for(JParser.BlockStatementContext stat : blockStatements){
            main.statements.add( visitBlockStatement(stat));
        }
        return main;
    }

    @Override
    public OutputModelObject visitLocalVariableDeclaration(@NotNull JParser.LocalVariableDeclarationContext ctx) {
        VarDef varDef = new VarDef(ctx.variableDeclarator().Identifier().getText());
        varDef.typeSpec = (TypeSpec) visitType(ctx.type());
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
        pushScope(ctx.scope);
        Block block  = new Block();
        List<JParser.BlockStatementContext> blockstats = new ArrayList<JParser.BlockStatementContext>();
        for(JParser.BlockStatementContext bs : blockstats)
            block.statements.add((Stat)visitBlockStatement(bs));
        popScope();
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
        whileStat.block = (Block) visit(ctx.whileBlock);
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
        if(ctx.left.expressionType instanceof JClass
            && !ctx.left.expressionType.getName().equals(ctx.right.expressionType.getName()))
            assignStat.cast = new TypeCast(ctx.left.expressionType.getName());
        return assignStat;
    }

    @Override
    public OutputModelObject visitPrimaryExpr(@NotNull JParser.PrimaryExprContext ctx) {
        //this
        if(ctx.primary().getText().equals("this")){
            return new ThisRef();
        }

        //literal
        else if(ctx.primary().literal() != null){
            String literal;
            if(ctx.primary().literal().IntegerLiteral() != null)
                literal = ctx.primary().literal().IntegerLiteral().getText();
            else if(ctx.primary().literal().FloatPointLiteral() != null)
                literal = ctx.primary().literal().FloatPointLiteral().getText();
            else if(ctx.primary().literal().StringLiteral() != null)
                literal = ctx.primary().literal().StringLiteral().getText();
            else
                return new NullRef();
            return new LiteralRef(literal);
        }

        //Identifier
        else if(ctx.primary().Identifier() != null){
            return new VarRef(ctx.primary().Identifier().getText());
        }
        return super.visitPrimaryExpr(ctx);
    }

    @Override
    public OutputModelObject visitDotExpr(@NotNull JParser.DotExprContext ctx) {
        if(ctx.dotID == null)
            return null;
        FieldRef fieldRef = new FieldRef(ctx.dotID.getText());
        //a.b
        if(visit(ctx.expression()) instanceof VarRef)
            fieldRef.entity = new FieldRef(((VarRef)visit(ctx.expression())).varRef);
        //a.b.   c-->varField
        else
            fieldRef.entity = (FieldRef) visit(ctx.expression());
        return fieldRef;
    }

    @Override
    public OutputModelObject visitMethodCalExpr(@NotNull JParser.MethodCalExprContext ctx) {
        MethodCall call = new MethodCall();
        if(ctx.expression() instanceof JParser.DotExprContext){ // this is for sure
            FieldRef callExpr = (FieldRef) visit(ctx.expression()) ;
            String f = callExpr.varRef; //function name
            if(callExpr.entity.entity == null) // a.foo(), funcName = foo, receiver. varField.varRef = a
                call.receiver = new VarRef(callExpr.entity.varRef);// call.receiver is a varRef
            else                               // a.b.c.foo()
                call.receiver = callExpr.entity; //call.receiver is a FieldRef a.b.c

            call.recType = new ObjectTypeSpec(((JVar)currentScope.resolve(call.receiver.varRef)).getType().getName());
            call.funcName = new FuncName(call.recType.typeName+"_"+f);//name of the method, the D in a.b.c. D
        }

        call.funcPtrType.retType  = getTypeSpec(ctx.expressionType);

        call.funcPtrType.argTypes.add(call.recType);

        String thisArg = "(("+call.recType.typeName+" *)"+call.receiver.varRef+")";

        call.args.add(new VarRef(thisArg));


        for(JParser.ExpressionContext arg : ctx.expressionList().expression()){
            call.args.add((Expr)visit(arg));
            call.funcPtrType.argTypes.add(getTypeSpec(arg.expressionType));
        }
        return call;
    }

    public TypeSpec getTypeSpec(Type type){
        if(type instanceof PrimitiveType)
            return new PrimitiveTypeSpec(type.getName());
        else
            return new ObjectTypeSpec(type.getName());
    }

    @Override
    public OutputModelObject visitNewExpr(@NotNull JParser.NewExprContext ctx) {
        CtorCall ctor = new CtorCall(ctx.creator().getText());
        return ctor;
    }

    private void pushScope(Scope s) {
        currentScope = s;
        System.out.println("visiting: "+currentScope.getScopeName());
    }

    private void popScope() {
        System.out.println("leaving: "+currentScope.getScopeName());
        currentScope = currentScope.getEnclosingScope();
    }
}
