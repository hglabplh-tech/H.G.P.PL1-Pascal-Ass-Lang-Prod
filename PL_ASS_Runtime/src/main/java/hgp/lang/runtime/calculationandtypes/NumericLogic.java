package hgp.lang.runtime.calculationandtypes;

import hgp.lang.runtime.calculationandtypes.StackToken.DataTypeId;

public class NumericLogic {

    private final StackMachine machine;
    public NumericLogic () {
        machine = new StackMachine();
    }


    public Result calculateTerm (NumericExpression expression) {
        return new Result(DataTypeId.INTEGER, 0); // change this after getting logic
    }

    public StackMachine getMachine() {
        return machine;
    }

    public static class Result {
        private final DataTypeId typeId;
        private final Number theValue;

        public Result(DataTypeId typeId, Number theValue) {
            this.typeId = typeId;
            this.theValue = theValue;
        }

        public DataTypeId getTypeId() {
            return typeId;
        }

        public Number getTheValue() {
            return theValue;
        }
    }
}
