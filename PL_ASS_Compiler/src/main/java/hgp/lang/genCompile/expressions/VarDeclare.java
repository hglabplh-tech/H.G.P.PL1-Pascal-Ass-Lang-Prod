package hgp.lang.genCompile.expressions;

import clojure.lang.Symbol;
import org.antlr.v4.runtime.tree.TerminalNode;

public class VarDeclare {

    private final String name;

    private final  Symbol varId;

    private  final TerminalNode typeNode;

    public VarDeclare(String name, TerminalNode typeNode) {
        this.name = name;
        this.varId = Symbol.create(name);
        this.typeNode = typeNode;
    }

    public String getName() {
        return name;
    }

    public Symbol getVarId() {
        return varId;
    }

    public TerminalNode getTypeNode() {
        return typeNode;
    }
}
