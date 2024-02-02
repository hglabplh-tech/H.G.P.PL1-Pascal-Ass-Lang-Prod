package hgp.lang.runtime.calculationandtypes;

import java.util.Objects;

public class StackToken
{

    /** the value
     *
     */
    private final Number value;

    private final DataTypeId type;

    private final CommandCode operation;


    public StackToken(Number value, DataTypeId type, CommandCode operation) {
        this.value = value;
        this.type = type;
        this.operation = operation;
    }

    public Number getValue() {
        return value;
    }

    public DataTypeId getType() {
        return type;
    }

    public CommandCode getOperation() {
        return operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackToken that = (StackToken) o;
        return Objects.equals(value, that.value) && type == that.type && operation == that.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type, operation);
    }

    public enum CommandCode {
        NOP,
        ADD,
        SUBTRACT,
        DIVIDE,
        MUL,
        MODULO,
        SQRT
        ;


    }

    public enum DataTypeId {
        COMMAND_CODE,
        FLOAT,
        DOUBLE,
        INTEGER,
        LONG,
        BYTE,
        SHORT
        ;
    }
}
