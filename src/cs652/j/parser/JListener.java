// Generated from /Users/Shuai/Dropbox/cs652/syuanivy-vtable/src/cs652/j/parser/J.g4 by ANTLR 4.5

package cs652.j.parser;
import org.antlr.symbols.*;
import cs652.j.semantics.*; // You will need these for stuff in "returns" clauses

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
	 * Enter a parse tree produced by {@link JParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(@NotNull JParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(@NotNull JParser.VariableDeclaratorIdContext ctx);
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
	 * Enter a parse tree produced by {@link JParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(@NotNull JParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(@NotNull JParser.VariableDeclarationContext ctx);
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
	 * Enter a parse tree produced by {@link JParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(@NotNull JParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(@NotNull JParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull JParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull JParser.StatementContext ctx);
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
	 * Enter a parse tree produced by {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull JParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull JParser.ExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link JParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull JParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull JParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link JParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull JParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull JParser.LiteralContext ctx);
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
}