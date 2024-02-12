package hgp.lang.executor;

public class VariableReference {
    private final Integer varType;

    private final Object value;


    public VariableReference(Integer varType, Object value) {
        this.varType = varType;
        this.value = value;
    }

    public Integer varType() {
        return varType;
    }

    public Object value() {
        return value;
    }
}
