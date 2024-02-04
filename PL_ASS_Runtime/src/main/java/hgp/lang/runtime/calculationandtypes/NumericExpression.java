package hgp.lang.runtime.calculationandtypes;

import hgp.lang.runtime.calculationandtypes.StackToken.CommandCode;

import java.util.ArrayList;
import java.util.List;

import static hgp.lang.runtime.calculationandtypes.StackToken.*;

public class NumericExpression {

    private ComplexExpression expression = null;

    private SimpleExpression simpleExpression = null;



    public ComplexExpression getExpression() {
        return expression;
    }

    public SimpleExpression getSimpleExpression() {
        return simpleExpression;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public  class ComplexExpression {
        private List<SimpleExpression> simpleExpressions = new ArrayList<>();

        private  SimpleExpression simpleExpression;

        private ComplexExpression recurExpression;

        public ComplexExpression() {

        }

        public List<SimpleExpression> getSimpleExpressions() {
            return simpleExpressions;
        }

        public SimpleExpression getSimpleExpression() {
            return simpleExpression;
        }

        public ComplexExpression getRecurExpression() {
            return recurExpression;
        }

        public Builder newBuilder(NumericExpression.Builder parent) {
            return new Builder(parent);
        }

        public class Builder {
            private NumericExpression.Builder parent;
            public Builder (NumericExpression.Builder parent) {
                this.parent = parent;
            }

            public Builder setSimpleExpressions(List<SimpleExpression> simpleExprs) {
                simpleExpressions = simpleExprs;
                return this;
            }

            public Builder addSimpleExpression(SimpleExpression expression) {
                simpleExpressions.add(expression);
                return this;
            }

            public Builder setSimpleExpression(SimpleExpression simpleExpr) {
                simpleExpression = simpleExpr;
                return this;
            }

            public Builder setRecurComplex(ComplexExpression expression) {
                recurExpression = expression;
                return this;
            }


            public  NumericExpression.Builder end() {
                return this.parent;
            }
        }
    }

    public  class SimpleExpression {

        private CommandCode opCode;
        private DataTypeId resultType;
        private Number firstVal;
        private Number secondVal;

        public SimpleExpression () {
        }
        public SimpleExpression (CommandCode opCode, DataTypeId resultType,
                                 Number firstVal, Number secondVal) {
            this.opCode = opCode;
            this.resultType = resultType;
            this.firstVal = firstVal;
            this.secondVal = secondVal;
        }

        public CommandCode getOpCode() {
            return opCode;
        }

        public DataTypeId getResultType() {
            return resultType;
        }

        public Number getFirstVal() {
            return firstVal;
        }

        public Number getSecondVal() {
            return secondVal;
        }

        public Builder newBuilder(NumericExpression.Builder parent) {
            return new Builder(parent);
        }

        public class Builder {
            private NumericExpression.Builder parent;
            public Builder (NumericExpression.Builder parent) {
                this.parent = parent;
            }

            public Builder setOpcode (CommandCode operation) {
                opCode = operation;
                return this;
            }
            public Builder setDataTypeId (DataTypeId resType) {
                resultType = resType;
                return this;
            }
            public Builder setFirstValue(Number value) {
                firstVal = value;
                return this;
            }
            public Builder setSecondValue(Number value) {
                secondVal = value;
                return this;
            }

            public  NumericExpression.Builder end() {
                return this.parent;
            }
        }
    }

    public class Builder {




        public Builder() {

        }

        public ComplexExpression.Builder buildComplex() {
            return new ComplexExpression().newBuilder(this);
        }

        public  SimpleExpression.Builder buildSimple() {
            return new SimpleExpression().newBuilder(this);
        }

        public NumericExpression build() { // implement this
            return null;
        }

    }
}
