// Generated from /Users/Shuai/Dropbox/cs652/syuanivy-vtable/src/cs652/j/parser/J.g4 by ANTLR 4.5

package cs652.j.parser;
import cs652.j.semantics.*; // You will need these for stuff in "returns" clauses
import org.antlr.symbols.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(@NotNull JParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(@NotNull JParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(@NotNull JParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull JParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#classType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(@NotNull JParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(@NotNull JParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(@NotNull JParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(@NotNull JParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#memberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaration(@NotNull JParser.MemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(@NotNull JParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(@NotNull JParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(@NotNull JParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(@NotNull JParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(@NotNull JParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(@NotNull JParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(@NotNull JParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull JParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(@NotNull JParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclarationStatement(@NotNull JParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(@NotNull JParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(@NotNull JParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(@NotNull JParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(@NotNull JParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(@NotNull JParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStat(@NotNull JParser.EmptyStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(@NotNull JParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statExpr}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatExpr(@NotNull JParser.StatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignStat}
	 * labeled alternative in {@link JParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStat(@NotNull JParser.AssignStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(@NotNull JParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#statementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementExpression(@NotNull JParser.StatementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodCarExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCarExpr(@NotNull JParser.MethodCarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(@NotNull JParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotExpr(@NotNull JParser.DotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link JParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(@NotNull JParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(@NotNull JParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(@NotNull JParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(@NotNull JParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull JParser.LiteralContext ctx);
}