package cs652.j.codegen;

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
        ClassDef c = new ClassDef(ctx.Identifier().getText());
        pushScope(ctx.scope);

        //inherit fields from parents
        for(FieldSymbol f : ctx.scope.getFields()){
            VarDef p = new VarDef(f.getName());
            p.typeSpec = getTypeSpec(f.getType());
            c.fields.add(p);
        }
        //get all methods from the current class
        for (JParser.ClassBodyDeclarationContext b : ctx.classBody().classBodyDeclaration()){
            JParser.MethodDeclarationContext m = b.memberDeclaration().methodDeclaration();
            if(m != null)
                c.methods.add((MethodDef)visitMethodDeclarationHelper(m, c.className));
        }
        //get define and vtable info, define use current class and vtable use enclosing class
        Define[] defs = new Define[ctx.scope.getNumberOfVisibleMethods()];
        FuncName[] vRefs = new FuncName[ctx.scope.getNumberOfVisibleMethods()];
        for(MethodSymbol m : ctx.scope.getVisibleMethods()){

            Define def = new Define(m.getName());
            def.className = c.className;
            def.slot = m.getSlotNumber();

            FuncName v = new FuncName(m.getName());
            v.className = m.getEnclosingScope().getScopeName();
            defs[def.slot] = def;
            vRefs[def.slot] = v;
        }
        for(int i = 0; i< defs.length; i++){
            c.define.add(defs[i]);
            c.vtable.add(vRefs[i]);
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
        method.methodName.className = receiverClass;
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
    public OutputModelObject visitExprStat(@NotNull JParser.ExprStatContext ctx) {
        return new ExprStat((Expr)visit(ctx.statementExpression().expression()));
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
    public OutputModelObject visitThisExpr(@NotNull JParser.ThisExprContext ctx) {
        return new ThisRef();
    }

    @Override
    public OutputModelObject visitIntLiteralExpr(@NotNull JParser.IntLiteralExprContext ctx) {
        return new LiteralRef(ctx.IntegerLiteral().getText());
    }

    @Override
    public OutputModelObject visitFloatLiteralExpr(@NotNull JParser.FloatLiteralExprContext ctx) {
        return new LiteralRef(ctx.FloatPointLiteral().getText());
    }

    @Override
    public OutputModelObject visitIdentifierExpr(@NotNull JParser.IdentifierExprContext ctx) {
        String s = ctx.Identifier().getText();
        if(currentScope.resolve(s) instanceof  JField){
            FieldRef fieldRef = new FieldRef(s);
            fieldRef.entity = new ThisRef();
            return  fieldRef;
        }
        return new VarRef(ctx.Identifier().getText());
    }

    @Override
    public OutputModelObject visitNullExpr(@NotNull JParser.NullExprContext ctx) {
        return new NullRef();
    }

    @Override
    public OutputModelObject visitDotExpr(@NotNull JParser.DotExprContext ctx) {
        FieldRef fieldRef = new FieldRef(ctx.dotID.getText());
        fieldRef.entity = (Expr)visit(ctx.expression());
        //a.b  entity = varRef a
        if(visit(ctx.expression()) instanceof VarRef)
            fieldRef.entity = (VarRef)visit(ctx.expression());
        else if(visit(ctx.expression()) instanceof ThisRef)
            fieldRef.entity = new ThisRef();
        //a.b. c  varField entity = FieldRef a.b
        else
            fieldRef.entity = (FieldRef) visit(ctx.expression());
        return fieldRef;
    }

    @Override
    public OutputModelObject visitMethodCalExpr(@NotNull JParser.MethodCalExprContext ctx) {
        MethodCall call = new MethodCall();
        /*find functionName, receiver object and receiver type.*/
        //"foo()", a method call within another method declaration, implicit receiver "this"
        if(ctx.expression() instanceof JParser.IdentifierExprContext){//foo
            String f =((VarRef)visit(ctx.expression())).varRef; //"foo"
            call.receiver = new ThisRef(); //this
            JClass c = getThisClass(currentScope);
            JMethod m = (JMethod) c.resolve(f);
            call.recType = new ObjectTypeSpec(m.getEnclosingScope().getScopeName()); //T
            call.funcName = new FuncName(f); //foo
            call.funcName.className = c.getName();
        // "a.b.c.foo()", a method call with explicit receiver object
        }else if (ctx.expression() instanceof JParser.DotExprContext){ //a.b.c.foo
            FieldRef callExpr = (FieldRef) visit(ctx.expression()) ; //a.b.c->entity, foo->varRef
            call.funcName = new FuncName(callExpr.varRef); //foo
            Type rec = ((JParser.DotExprContext) ctx.expression()).expression().expressionType;//type of a.b.c
            JClass current = (JClass) currentScope.resolve(rec.getName()); //resolve c type
            JMethod m = (JMethod) current.resolve(call.funcName.methodName); //resolve method from c type
            String r = m.getEnclosingScope().getScopeName();// get its enclosing scope name
            call.recType = new ObjectTypeSpec(r);//receiver type of the method
            call.receiver = callExpr.entity; //a.b.c
            call.funcName.className = rec.getName(); //T_foo
        }
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
            if(t instanceof ObjectTypeSpec && !(arg instanceof JParser.NewExprContext)){
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

    private TypeSpec getTypeSpec(Type type){
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
    }

    private void popScope() {
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
