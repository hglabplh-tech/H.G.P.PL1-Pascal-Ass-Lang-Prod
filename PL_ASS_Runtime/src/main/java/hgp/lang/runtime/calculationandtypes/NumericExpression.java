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



        private  SimpleExpression simpleExpression;



        public ComplexExpression(CommandCode connectOp, DataTypeId typeId) {
            super(connectOp, typeId);
        }

        public List<Expression> getSimpleExpressions() {
            return simpleExpressions;
        }



        public SimpleExpression getSimpleExpression() {
            return simpleExpression;
        }



        public Builder newBuilder(NumericExpression.Builder parent,
                                  CommandCode connectOp, DataTypeId typeId) {
            return new Builder(parent, connectOp, typeId);
        }

        public static class Builder {
            private NumericExpression.Builder parent;
            private ComplexExpression instance;
            public Builder (NumericExpression.Builder parent,
                            CommandCode connectOp, DataTypeId typeId) {
                instance = new ComplexExpression(connectOp, typeId);
                this.parent = parent;
            }

            public Builder setSimpleExpressions(List<Expression> simpleExprs) {
                this.instance.simpleExpressions = simpleExprs;
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



        public SimpleExpression (CommandCode connectOp, DataTypeId typeId) {
            super(connectOp, typeId);
        }
        public SimpleExpression (CommandCode connectOp, CommandCode opCode, DataTypeId resultType,
                                 Number firstVal, Number secondVal) {
            this(connectOp, resultType);
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

        public Builder newBuilder(NumericExpression.Builder parent,
                                  CommandCode connectOp, DataTypeId typeId) {
            return new Builder(parent, connectOp, typeId);
        }

        public static class Builder {
            private NumericExpression.Builder parent;

            private SimpleExpression instance;
            public Builder (NumericExpression.Builder parent, CommandCode connectOp, DataTypeId typeId) {
                instance = new SimpleExpression(connectOp, typeId);
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

        public ComplexExpression.Builder buildComplex(CommandCode connectOp, DataTypeId typeId) {
            this.complex = new ComplexExpression.Builder(this, connectOp, typeId);
            return this.complex;
        }

        public  SimpleExpression.Builder buildSimple(CommandCode connectOp, DataTypeId typeId) {
            this.simple = new SimpleExpression.Builder(this, connectOp, typeId);
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
