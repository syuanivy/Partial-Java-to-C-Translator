// Generated from /Users/Shuai/Dropbox/cs652/syuanivy-vtable/src/cs652/j/parser/J.g4 by ANTLR 4.5

package cs652.j.parser;
import cs652.j.semantics.*; // You will need these for stuff in "returns" clauses
import org.antlr.symbols.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JParser}.
 */
public interface JListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(@NotNull JParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull JParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(@NotNull JParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(@NotNull JParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(@NotNull JParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(@NotNull JParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull JParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull JParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(@NotNull JParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(@NotNull JParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(@NotNull JParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(@NotNull JParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(@NotNull JParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(@NotNull JParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(@NotNull JParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(@NotNull JParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(@NotNull JParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(@NotNull JParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(@NotNull JParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(@NotNull JParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(@NotNull JParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(@NotNull JParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(@NotNull JParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(@NotNull JParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(@NotNull JParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(@NotNull JParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(@NotNull JParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(@NotNull JParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(@NotNull JParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(@NotNull JParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(@NotNull JParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(@NotNull JParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull JParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull JParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(@NotNull JParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(@NotNull JParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(@NotNull JParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(@NotNull JParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(@NotNull JParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(@NotNull JParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(@NotNull JParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(@NotNull JParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull JParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull JParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(@NotNull JParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(@NotNull JParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(@NotNull JParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(@NotNull JParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStat(@NotNull JParser.EmptyStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStat(@NotNull JParser.EmptyStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(@NotNull JParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(@NotNull JParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(@NotNull JParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(@NotNull JParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStat(@NotNull JParser.AssignStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStat(@NotNull JParser.AssignStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(@NotNull JParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(@NotNull JParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(@NotNull JParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(@NotNull JParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatLiteralExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteralExpr(@NotNull JParser.FloatLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatLiteralExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteralExpr(@NotNull JParser.FloatLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(@NotNull JParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(@NotNull JParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLiteralExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteralExpr(@NotNull JParser.IntLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLiteralExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteralExpr(@NotNull JParser.IntLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpr(@NotNull JParser.NullExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpr(@NotNull JParser.NullExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDotExpr(@NotNull JParser.DotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDotExpr(@NotNull JParser.DotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCalExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodCalExpr(@NotNull JParser.MethodCalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCalExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodCalExpr(@NotNull JParser.MethodCalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(@NotNull JParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(@NotNull JParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteralExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteralExpr(@NotNull JParser.StringLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteralExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteralExpr(@NotNull JParser.StringLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(@NotNull JParser.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(@NotNull JParser.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(@NotNull JParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(@NotNull JParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(@NotNull JParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(@NotNull JParser.CreatorContext ctx);
}