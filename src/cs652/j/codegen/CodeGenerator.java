package cs652.j.codegen;

import com.sun.codemodel.internal.ClassType;
import cs652.j.JTran;
import cs652.j.codegen.model.*;
import cs652.j.parser.JBaseVisitor;
import cs652.j.parser.JParser;
import cs652.j.semantics.*;
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
	public JClass currentClass = null;

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
        method.parameters.get(0).typeSpec = new PrimitiveTypeSpec(receiverClass); //cheat too make *this, it's actually ObjectTypeSpec
        popScope();
        return method;
    }
    @Override
    public OutputModelObject visitMethodDeclaration(@NotNull JParser.MethodDeclarationContext ctx) {
        MethodDef method = new MethodDef(ctx.Identifier().getText());
        method.retType = (TypeSpec) visitType(ctx.type());
        method.slot = new VarRef(String.valueOf(ctx.scope.getSlotNumber()));
        method.body = (Block) visitBlock(ctx.methodBody().block());
        ParaDef thisPara = new ParaDef("*this");
        method.parameters.add(thisPara);
        if(ctx.formalParameters().formalParameterList() == null)
            return method;
        for(JParser.FormalParameterContext par : ctx.formalParameters().formalParameterList().formalParameter()){
            ParaDef p = new ParaDef(par.variableDeclarator().Identifier().getText());
            p.typeSpec = (TypeSpec) visitType(par.type());
            method.parameters.add(p);
        }
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
        for(JParser.BlockStatementContext bs : blockStatements){
            if(visitBlockStatement(bs) instanceof VarDef){
                if(main.declarations == null)
                    main.declarations = new ArrayList<>();
                main.declarations.add((VarDef) visitBlockStatement(bs));

            } else
                main.statements.add((Stat)visitBlockStatement(bs));
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
        return visit(ctx.block());
    }

    @Override
    public OutputModelObject visitBlock(@NotNull JParser.BlockContext ctx) {
        pushScope(ctx.scope);
        Block block  = new Block();
        List<JParser.BlockStatementContext> blockstats = new ArrayList<JParser.BlockStatementContext>();
        for(JParser.BlockStatementContext bs : ctx.blockStatement()){
            if(visitBlockStatement(bs) instanceof VarDef){
                if(block.declarations == null)
                    block.declarations = new ArrayList<>();
                block.declarations.add((VarDef) visitBlockStatement(bs));
            } else
                block.statements.add((Stat)visitBlockStatement(bs));
        }
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
            ifStat.condition = (Expr) visit(ctx.parExpression().expression());
            ifStat.statement = (Stat) visit(ctx.ifStat);
            return ifStat;
        }else{
            IfElseStat ifElseStat = new IfElseStat();
            ifElseStat.condition = (Expr) visit(ctx.parExpression().expression());
            ifElseStat.statement = (Stat) visit(ctx.ifStat);
            ifElseStat.elseStatement = (Stat) visit(ctx.elseStat);
            return ifElseStat;
        }
    }

    @Override
    public OutputModelObject visitWhileStat(@NotNull JParser.WhileStatContext ctx) {
        WhileStat whileStat = new WhileStat();
        whileStat.condition = (Expr) visit(ctx.parExpression().expression());
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

        if(ctx.left.expressionType instanceof JClass
            && !ctx.left.expressionType.getName().equals(ctx.right.expressionType.getName())){
            TypeCast c = new TypeCast(new ObjectTypeSpec(ctx.left.expressionType.getName()));
            c.expr = (Expr) visit(ctx.right);
            assignStat.right = c;
        }
        else
            assignStat.right = (Expr) visit(ctx.right);
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
            if(currentScope.resolve(ctx.primary().Identifier().getText()) instanceof  JField){
                FieldRef field = new FieldRef(ctx.primary().Identifier().getText());
                field.entity = new VarRef("this");
                return field;
            }
            return new VarRef(ctx.primary().Identifier().getText());
        }
        return super.visitPrimaryExpr(ctx);
    }

    @Override
    public OutputModelObject visitDotExpr(@NotNull JParser.DotExprContext ctx) {
        if(ctx.dotID == null)
            return null;
        FieldRef fieldRef = new FieldRef(ctx.dotID.getText());
        //a.b  entity = varRef a
        if(visit(ctx.expression()) instanceof VarRef)
            fieldRef.entity = (VarRef)visit(ctx.expression());
        else if(visit(ctx.expression()) instanceof ThisRef)
            fieldRef.entity = new VarRef("this");
        //a.b.   c-->varField entity = FieldRef a.b
        else
            fieldRef.entity = (FieldRef) visit(ctx.expression());
        return fieldRef;
    }

    @Override
    public OutputModelObject visitMethodCalExpr(@NotNull JParser.MethodCalExprContext ctx) {
        MethodCall call = new MethodCall();
        /*find functionName, receiver object and receiver type.*/
        //"foo()", a method call within another method declaration, implicit receiver "this"
        if(ctx.expression() instanceof JParser.PrimaryExprContext){//foo
            String f =((VarRef)visit(ctx.expression())).varRef; //"foo"
            call.receiver = new ThisRef(); //this
            call.recType = typeOfThis(); //T
            call.funcName = new FuncName(f); //foo
        // "a.b.c.foo()", a method call with explicit receiver object
        }else if (ctx.expression() instanceof JParser.DotExprContext){ //a.b.c.foo
            FieldRef callExpr = (FieldRef) visit(ctx.expression()) ; //a.b.c->entity, foo->varRef
            call.funcName = new FuncName(callExpr.varRef); //foo
            Type rec = ((JParser.DotExprContext) ctx.expression()).expression().expressionType;//type of a.b.c
            call.recType = (ObjectTypeSpec)getTypeSpec(rec);//T
            call.receiver = callExpr.entity; //a.b.c
        }
        call.funcName.className = call.recType.typeName; //T_foo
        call.funcPtrType.retType  = getTypeSpec(ctx.expressionType); //type of a.b.c.foo()

        /*Handle "this", Add the receiver and receiver type to args and funcPtrType.argTypes*/
        //add "this" to args
        TypeCast thisArg = new TypeCast(call.recType);
        thisArg.expr = call.receiver;
        call.args.add(thisArg);
        //add "this" type to argTypes and casts
        call.funcPtrType.argTypes.add(call.recType);

        if(ctx.expressionList() == null)
            return call;

        //find arg/parameter types and typecasts if objectType
        findArgTypes(call);
        findArgs(ctx,call);
        return call;
    }

    private void findArgs(JParser.MethodCalExprContext ctx, MethodCall call) {
        for(JParser.ExpressionContext arg : ctx.expressionList().expression()){
            Expr a = (Expr)visit(arg);
            TypeSpec t = getTypeSpec(arg.expressionType);
            if(t instanceof ObjectTypeSpec){
                TypeCast c = new TypeCast(t);
                c.expr = a;
                call.args.add(c);
            }else
                call.args.add(a);
        }
    }

    private void findArgTypes(MethodCall call) {
        //resolve method to find all parameter types, add to argTypes
        JClass c = (JClass) currentScope.resolve(call.recType.typeName); //T
        JMethod m = (JMethod)c.getSymbol(call.funcName.methodName);
        List<? extends Symbol> parameters = m.getSymbols(); //all JArgs
        for(Symbol p : parameters) {
            TypeSpec t = getTypeSpec(((JArg) p).getType());
            call.funcPtrType.argTypes.add(t);
        }
    }

    public ObjectTypeSpec typeOfThis(){
        String name = getThisClass(currentScope).getName();
        return new ObjectTypeSpec(name);
    }


    public TypeSpec getTypeSpec(Type type){
        if(type instanceof JPrimitiveType)
            return new PrimitiveTypeSpec(type.getName());
        else
            return new ObjectTypeSpec(type.getName());
    }


    @Override
    public OutputModelObject visitNewExpr(@NotNull JParser.NewExprContext ctx) {
        CtorCall ctor = new CtorCall(ctx.creator().type().getText());
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
    private JClass getThisClass(Scope s){
        while(s != null){
            if(s instanceof JClass)
                return (JClass) s;
            s = s.getEnclosingScope();
        }
        return null;
    }
}
