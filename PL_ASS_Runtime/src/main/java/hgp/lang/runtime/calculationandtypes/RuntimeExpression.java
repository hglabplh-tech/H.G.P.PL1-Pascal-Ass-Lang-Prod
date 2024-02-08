package hgp.lang.runtime.calculationandtypes;

public class RuntimeExpression {

    private final StackToken.Token token;

    private final Object value;

    private final ValHolder holder;

    public RuntimeExpression(StackToken.Token token, Object value) {
        this.token = token;
        this.value = value;
        holder = new ValHolder(value);
    }

    public StackToken.Token getToken() {
        return token;
    }

    public Object getValue() {
        return value;
    }

    public  class ValHolder {
        private final Object value;

        public ValHolder(Object value) {
            this.value = value;
        }

        public  Object getValue() {
            return  value;
        }
    }
}
