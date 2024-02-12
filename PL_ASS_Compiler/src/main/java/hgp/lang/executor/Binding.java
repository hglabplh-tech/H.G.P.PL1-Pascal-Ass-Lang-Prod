package hgp.lang.executor;

import clojure.lang.Symbol;
import hgp.lang.genCompile.expressions.VarDeclare;
import hgp.lang.utils.Tuple;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

import static hgp.lang.gparser.pl_pas_assParser.*;

public class Binding {

    private Binding parent;
    private final Map<String, VariableReference> bindingVarPool = new HashMap<>();

    public Binding() {
        this(null);
    }

    public Binding(Binding parent) {
        this.parent = parent;

    }

    public Binding getParent() {
        return parent;
    }

    public Map<String, VariableReference> getBindingVarPool() {
        return bindingVarPool;
    }

    public void addNewVarReference(VarDeclare varDeclaration, Object... params) {
        Integer dataType = varDeclaration.getTypeNode().getSymbol().getType();
        VariableReference reference = new VariableReference(
                dataType, allocByType(dataType, params));
        getBindingVarPool().put(varDeclaration.getName(), reference);
    }

    public VariableReference getFromPool (String key) {
        return getBindingVarPool().get(key);
    }

    public void changeINPool (String name,VariableReference newRef) {
        getBindingVarPool().put(name, newRef);
    }

    private Object allocByType (Integer type, Object... params) {
        switch (type) {
            case REAL:
                return Double.valueOf((String)params[0]);
            case INTEGER:
                return Integer.valueOf((String)params[0]);
            case BOOLEAN:
                return Boolean.valueOf(((Boolean)params[0]).booleanValue());
            case STRING:
                return new StringBuffer();
            case STRING_LITERAL:
                return (String)params[0];


        }
        return null;
    }


}
