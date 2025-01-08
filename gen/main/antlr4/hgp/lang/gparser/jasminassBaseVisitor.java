// Generated from /Users/hglabplh/IdeaProjects/H.G.P.PL1-Pascal-Ass-Lang/src/main/antlr4/hgp/lang/gparser/jasminass.g4 by ANTLR 4.13.1
package main.antlr4.hgp.lang.gparser;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link jasminassVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
@SuppressWarnings("CheckReturnValue")
public class jasminassBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements jasminassVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProg(jasminassParser.ProgContext ctx) { return visitChildren(ctx); }
}