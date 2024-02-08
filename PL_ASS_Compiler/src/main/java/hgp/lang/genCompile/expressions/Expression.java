package hgp.lang.genCompile.expressions;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Expression  {

    private List<TerminalNode> nodes = new ArrayList<>();
    public Expression() {

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
}
