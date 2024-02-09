package hgp.lang.genCompile.expressions;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Assignment {

    private final TerminalNode target;

    private Expression source = new Expression();

    public Assignment(TerminalNode target) {
        this.target = target;

    }

    public TerminalNode getTarget() {
        return target;
    }

    public Expression getSource() {
        return source;
    }
}
