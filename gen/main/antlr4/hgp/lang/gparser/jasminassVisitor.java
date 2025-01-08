// Generated from /Users/hglabplh/IdeaProjects/H.G.P.PL1-Pascal-Ass-Lang/src/main/antlr4/hgp/lang/gparser/jasminass.g4 by ANTLR 4.13.1
package main.antlr4.hgp.lang.gparser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link jasminassParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface jasminassVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link jasminassParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(jasminassParser.ProgContext ctx);
}