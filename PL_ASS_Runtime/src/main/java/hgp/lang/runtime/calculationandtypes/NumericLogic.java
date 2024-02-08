package hgp.lang.runtime.calculationandtypes;

import hgp.lang.runtime.calculationandtypes.StackToken.DataTypeId;

import java.util.*;


import static hgp.lang.runtime.calculationandtypes.StackToken.*;

/**
 * This class contains the logic to calculate simple terms as well as complex terms+
 * A simple term will be something like x = 9 + 8 only two operands and one operator.
 * a complex term will be something like x = 10 - 8 * (9 * (y +3) / 4) / 6
 */
public class NumericLogic {

    private final StackMachine machine;


    private final Queue<Object> parmQueue = new ArrayDeque<>();


    private static Map<Token, Integer> operatorPrecedence = new HashMap<>();



    static {
        operatorPrecedence.put(Token.MUL_TOKEN, 10);
        operatorPrecedence.put(Token.DIVIDE_TOKEN, 9);
        operatorPrecedence.put(Token.MODULO_TOKEN, 7);
        operatorPrecedence.put(Token.ADD_TOKEN ,5);
        operatorPrecedence.put(Token.SUBTRACT_TOKEN, 3);
        ;

    }

    public NumericLogic() {
        machine = new StackMachine();
    }


    public Result calculateTerm(List<RuntimeExpression> expressions) {
        this.parmQueue.clear();
        for (RuntimeExpression expression : expressions) {
            System.out.println(expression.getToken().getCode());
        }
        return this.calculateByPrecedence(expressions);
    }

    private void computeExpression(Token token, DataTypeId type) {
        ReadParams params = readParams(token, type);
        StackToken result = this.getMachine()
                .pushToStackAndExecute(token.getCode(), params.firstValue(),
                        params.secValue(), params.typeId());
        parmQueue.add(result.getValue());

    }

    private ReadParams readParams(Token token, DataTypeId typeId) {

        Number firstValue = (Number) parmQueue.remove();
        Number secValue = (Number) parmQueue.remove();

        ReadParams result = new ReadParams(typeId, firstValue, secValue);
        return result;
    }

    private record ReadParams(DataTypeId typeId, Number firstValue, Number secValue) {
    }


    public Result calculateByPrecedence(List<RuntimeExpression> expressionList) {
        DataTypeId type = DataTypeId.INTEGER;
        Integer counter = 0;
        for (RuntimeExpression theExpr : expressionList) {
            if (counter == 0) {
                type = (DataTypeId)theExpr.getValue();
                counter++;
            }
            Token token = theExpr.getToken();
            if (token.getType().equals(TokenType.MATH_TOKEN)) {
                computeExpression(token, type);
            } else if (token.equals(Token.CONST_VALUE_TOKEN)) {
                Number value = (Number)theExpr.getValue();
                parmQueue.add(value);
            }


        }
        Number theValue = (Number)parmQueue.remove();
        return new Result(type, theValue);
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

        @Override
        public String toString() {
            return "Result{" +
                    "typeId=" + typeId +
                    ", theValue=" + theValue +
                    '}';
        }
    }


}
