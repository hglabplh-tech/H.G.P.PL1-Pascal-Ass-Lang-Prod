package hgp.lang.runtime.calculationandtypes;

import hgp.lang.runtime.calculationandtypes.StackToken.DataTypeId;

import java.util.List;

/**
 * This class contains the logic to calculate simple terms as well as complex terms+
 * A simple term will be something like x = 9 + 8 only two operands and one operator.
 * a complex term will be something like x = 10 - 8 * (9 * (y +3) / 4) / 6
 */
public class NumericLogic {

    private final StackMachine machine;

    public NumericLogic() {
        machine = new StackMachine();
    }


    public Result calculateTerm(NumericExpression expression) {
        NumericExpression.ComplexExpression complex = expression.getExpression();
        NumericExpression.SimpleExpression simple = expression.getSimpleExpression();
        Result theResult = null;
        if (complex != null) {
            theResult = calculateComplexExpression(complex);
        } else if (simple != null) {
            theResult = computeSimpleExpression(simple);

        }
        return theResult;
    }

    private Result computeSimpleExpression(NumericExpression.SimpleExpression simple) {
        Result theResult;
        StackToken result = this.getMachine()
                .pushToStackAndExecute(simple.getOpCode(), simple.getFirstVal(),
                        simple.getSecondVal(), simple.getResultType());
        theResult = new Result(result.getType(), result.getValue());
        return theResult;
    }

    private Result calculateComplexExpression(NumericExpression.ComplexExpression complex) {
        Result result = null;
        NumericExpression.SimpleExpression simpleExpr = complex.getSimpleExpression();
        List<Expression> simpleExprList = complex.getSimpleExpressions();
        if  (simpleExprList != null && !simpleExprList.isEmpty()) {
            Result prevResult = new Result(simpleExprList.get(0).getTypeId(), 0); // change this
            for (Expression theExpr : simpleExprList) {
                if (theExpr instanceof NumericExpression.SimpleExpression) {
                    NumericExpression.SimpleExpression expression =
                            (NumericExpression.SimpleExpression)theExpr;
                    result = this.computeSimpleExpression(expression);
                    NumericExpression.SimpleExpression connectExpr =
                            new NumericExpression.SimpleExpression(expression.getTheConnectOperation(),
                                    expression.getOpCode(), expression.getResultType(),
                                    prevResult.getTheValue(), result.getTheValue());
                    result = this.computeSimpleExpression(connectExpr);
                    prevResult = result;
                } else if (theExpr instanceof NumericExpression.ComplexExpression) {
                    NumericExpression.ComplexExpression expression =
                            (NumericExpression.ComplexExpression)theExpr;
                        result = this.calculateComplexExpression(expression);
                    // here also will be more logic
                }

            }
        }
        if (simpleExpr != null) {
            result =  this.computeSimpleExpression(simpleExpr);
        }
        return result;
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
