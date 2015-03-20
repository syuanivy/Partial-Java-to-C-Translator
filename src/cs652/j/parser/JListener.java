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
}