package hgp.lang.runtime.calculationandtypes;

public class Expression {

    private final StackToken.CommandCode theConnectOperation;

    private final StackToken.DataTypeId typeId;

    public Expression(StackToken.CommandCode theConnectOperation, StackToken.DataTypeId typeId) {
        this.theConnectOperation = theConnectOperation;
        this.typeId = typeId;
    }

    public StackToken.CommandCode getTheConnectOperation() {
        return theConnectOperation;
    }

    public StackToken.DataTypeId getTypeId() {
        return typeId;
    }
}
