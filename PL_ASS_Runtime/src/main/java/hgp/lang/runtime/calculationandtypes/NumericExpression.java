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

    public  static class ComplexExpression extends Expression {
        private List<Expression> simpleExpressions = new ArrayList<>();

        private CommandCode listConnectCmd = CommandCode.ADD;

        private  SimpleExpression simpleExpression;



        public ComplexExpression() {

        }

        public List<Expression> getSimpleExpressions() {
            return simpleExpressions;
        }

        public CommandCode getListConnectCmd() {
            return listConnectCmd;
        }

        public SimpleExpression getSimpleExpression() {
            return simpleExpression;
        }



        public Builder newBuilder(NumericExpression.Builder parent) {
            return new Builder(parent);
        }

        public static class Builder {
            private NumericExpression.Builder parent;
            private ComplexExpression instance = new ComplexExpression();
            public Builder (NumericExpression.Builder parent) {
                this.parent = parent;
            }

            public Builder setSimpleExpressions(List<Expression> simpleExprs) {
                this.instance.simpleExpressions = simpleExprs;
                return this;
            }

            public Builder setListConnectCmd(CommandCode op) {
                this.instance.listConnectCmd = op;
                return this;
            }

            public Builder addSimpleExpression(Expression expression) {
                this.instance.simpleExpressions.add(expression);
                return this;
            }

            public Builder setSimpleExpression(SimpleExpression simpleExpr) {
                this.instance.simpleExpression = simpleExpr;
                return this;
            }



            ComplexExpression buildit () {
                return this.instance;
            }


            public  NumericExpression.Builder end() {
                return this.parent;
            }
        }
    }

    public  static class SimpleExpression extends Expression{

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

        public static class Builder {
            private NumericExpression.Builder parent;

            private SimpleExpression instance = new SimpleExpression();
            public Builder (NumericExpression.Builder parent) {
                this.parent = parent;
            }

            public Builder setOpcode (CommandCode operation) {
                this.instance.opCode = operation;
                return this;
            }
            public Builder setDataTypeId (DataTypeId resType) {
                this.instance.resultType = resType;
                return this;
            }
            public Builder setFirstValue(Number value) {
                this.instance.firstVal = value;
                return this;
            }
            public Builder setSecondValue(Number value) {
                this.instance.secondVal = value;
                return this;
            }

            SimpleExpression buildit () {
                return this.instance;
            }

            public  NumericExpression.Builder end() {
                return this.parent;
            }
        }
    }

    public static class Builder {


        private ComplexExpression.Builder complex;

        private SimpleExpression.Builder simple;

        public Builder() {

        }

        public ComplexExpression.Builder buildComplex() {
            this.complex = new ComplexExpression.Builder(this);
            return this.complex;
        }

        public  SimpleExpression.Builder buildSimple() {
            this.simple = new SimpleExpression.Builder(this);
            return this.simple;
        }

        public NumericExpression build() {
            NumericExpression thisInst = new NumericExpression();
            thisInst.simpleExpression = simple.buildit();
            thisInst.expression = complex.buildit();// implement this
            return null;
        }

    }
}
