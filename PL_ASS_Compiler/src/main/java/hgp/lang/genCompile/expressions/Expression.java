package hgp.lang.genCompile.expressions;

import hgp.lang.executor.Binding;
import hgp.lang.executor.CodeStep;
import hgp.lang.executor.StepRunner;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Expression extends CodeStep implements StepRunner {

    private List<TerminalNode> nodes = new ArrayList<>();
    public Expression(Binding parent) {
        super(parent);
    }

    public List<TerminalNode> getNodes() {
        return nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(nodes, that.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }

    public List<Token> getTokenList () {
        return this.getNodes().stream().map(TerminalNode::getSymbol).toList();
    }

    @Override
    public String toString() {
        StringBuffer theBuffer = new StringBuffer();
        this.getNodes().stream().forEach(e -> theBuffer.append(e.getSymbol().getText()));
        this.getNodes().stream().forEach(e -> theBuffer.append(e.getSymbol().getType() + ","));
        return "Expression{" +
                "nodes=" + nodes +
                "buffer content= " +
                theBuffer.toString() +
                '}';
    }

    @Override
    public Binding getBinding() {
        return getParentBinding();
    }

    @Override
    public CodeStep call() throws Exception {
        return null;
    }
}
