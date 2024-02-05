package hgp.lang.runtime.calculationandtypes;

import clojure.lang.Obj;
import hgp.lang.runtime.calculationandtypes.StackToken.DataTypeId;

import java.util.*;

import static hgp.lang.runtime.calculationandtypes.NumericExpression.*;
import static hgp.lang.runtime.calculationandtypes.StackToken.*;

/**
 * This class contains the logic to calculate simple terms as well as complex terms+
 * A simple term will be something like x = 9 + 8 only two operands and one operator.
 * a complex term will be something like x = 10 - 8 * (9 * (y +3) / 4) / 6
 */
public class NumericLogic {

    private final StackMachine machine;

    private final Stack<PreCalc> stack = new Stack<>();


    private static Map<CommandCode, Integer> operatorPrecedence = new HashMap<>();
    static {
        operatorPrecedence.put(CommandCode.MUL, 10);
        operatorPrecedence.put(CommandCode.DIVIDE, 9);
        operatorPrecedence.put(CommandCode.MODULO, 7);
        operatorPrecedence.put(CommandCode.ADD, 5);
        operatorPrecedence.put(CommandCode.SUBTRACT, 3);
        ;

    }

    public NumericLogic() {
        machine = new StackMachine();
    }


    public Result calculateTerm(NumericExpression expression) {
        stack.clear();
        ComplexExpression complex = expression.getExpression();
        List<PreCalc> resultsList = new ArrayList<>();
        Result theResult = null;
        if (complex != null) {
            resultsList.addAll(calculateComplexExpression(complex));
        }
        return theResult;
    }

    private PreCalc computeSimpleExpression(PreCalc                                          simple) {

        StackToken result = this.getMachine()
                .pushToStackAndExecute(simple.getOpCode(), simple.getFirstValue(),
                        simple.getSecondValue(), simple.getTypeId());
        PreCalc theResult = new PreCalc(result.getOperation(), result.getType(),
                null,result.getValue());
        return theResult;
    }

    private List<PreCalc> calculateComplexExpression(ComplexExpression complex) {
        List<PreCalc> resList = new ArrayList<>();
        SimpleExpression simpleExpr = complex.getSimpleExpression();
        List<Expression> simpleExprList = complex.getSimpleExpressions();
        if  (simpleExprList != null && !simpleExprList.isEmpty()) {
            Result prevResult = new Result(simpleExprList.get(0).getTypeId(), 0); // change this
            for (Expression theExpr : simpleExprList) {
                if (theExpr instanceof SimpleExpression) {
                  resList.addAll(calculateByPrecedence(simpleExprList));
                } else if (theExpr instanceof ComplexExpression) {
                    ComplexExpression expression =
                            (ComplexExpression)theExpr;
                        this.calculateComplexExpression(expression);

                    // here also will be more logic
                }

            }
        }
        if (simpleExpr != null) {
            //result =  this.computeSimpleExpression(simpleExpr);
        }
        return resList;
    }

    public List<PreCalc> calculateByPrecedence(List<Expression> expressionList) {
        Expression  saveExpression = null;
        List<PreCalc> resList = new ArrayList<>();
        for (Expression theExpr : expressionList) {
            PreCalc preCalc = new PreCalc(theExpr.getTheConnectOperation(),
                    theExpr.getTypeId(), ((SimpleExpression)theExpr).getFirstVal(),
                    ((SimpleExpression)theExpr).getSecondVal() );
            if (saveExpression != null) {
                if (operatorPrecedence.get(theExpr.getTheConnectOperation()) >
                        operatorPrecedence.get(saveExpression.getTheConnectOperation())) {
                    resList.add(this.computeSimpleExpression(preCalc));
                } else {
                    this.stack.push(preCalc);
                }
            }
            saveExpression = theExpr;
        }
        return resList;
    }


    public StackMachine getMachine() {
        return machine;
    }

    public static class PreCalc {

        private final CommandCode opCode;
        private final DataTypeId typeId;
        private final Number firstValue;

        private final Number secondValue;

        public PreCalc(CommandCode opCode, DataTypeId typeId,
                       Number firstValue, Number secondValue) {
            this.opCode = opCode;
            this.typeId = typeId;
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }

        public CommandCode getOpCode() {
            return opCode;
        }

        public DataTypeId getTypeId() {
            return typeId;
        }

        public Number getFirstValue() {
            return firstValue;
        }

        public Number getSecondValue() {
            return secondValue;
        }
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
