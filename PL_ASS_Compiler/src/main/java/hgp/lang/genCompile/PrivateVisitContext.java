package hgp.lang.genCompile;

import hgp.lang.gparser.pl_pas_assParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class PrivateVisitContext<T> {

    private Token actToken;

    private Integer type;

    private String textOfNode;

    private Integer defLine;

    private Integer defColumn;

    private Builder builder;

    private T theValue;

    private List<TerminalNode> tNodeList = new ArrayList<>();


    public PrivateVisitContext() {

    }

    public PrivateVisitContext(Token actToken, Integer type,
                               String textOfNode,
                               Integer defLine, Integer defColumn) {
        this.actToken = actToken;
        this.type = type;
        this.textOfNode = textOfNode;
        this.defLine = defLine;
        this.defColumn = defColumn;

        this.builder = new Builder(this);
    }

    public Integer getType() {
        return type;
    }

    public String getTextOfNode() {
        return textOfNode;
    }

    public Integer getDefLine() {
        return defLine;
    }

    public Integer getDefColumn() {
        return defColumn;
    }

    public Builder getBuilder() {
        return builder;
    }

    public T getTheValue() {
        return theValue;
    }

    public Token getActToken() {
        return actToken;
    }

    public static class Builder<T> {

        private final PrivateVisitContext<T> instance;

        public Builder(PrivateVisitContext<T> instance) {
            this.instance = instance;
        }

        public PrivateVisitContext<T> setValue(T theValue) {
            instance.theValue = theValue;
            return instance;
        }

        public PrivateVisitContext<T> addToTerminalNodes(TerminalNode theNode) {
            instance.tNodeList.add(theNode);
            return instance;
        }

    }


}
