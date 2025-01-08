// Generated from /Users/hglabplh/IdeaProjects/H.G.P.PL1-Pascal-Ass-Lang/src/main/antlr4/hgp/lang/gparser/jasminass.g4 by ANTLR 4.13.1
package main.antlr4.hgp.lang.gparser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link jasminassParser}.
 */
public interface jasminassListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link jasminassParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(jasminassParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link jasminassParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(jasminassParser.ProgContext ctx);
}