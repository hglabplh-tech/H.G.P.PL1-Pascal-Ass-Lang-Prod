package hgp.lang.runtime.calculationandtypes;

import clojure.lang.IFn;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class StackMachine {

    MathProcess process = new MathProcess();

    public final Number[] machineRegs = new Number[30];

    public final Stack<StackToken> machineStack = new Stack<>();

    public final Queue<Number> machineQueue = new SynchronousQueue<>();

    public StackMachine() {
        Arrays.fill(machineRegs, 0);
        machineQueue.clear();
        machineStack.clear();
    }

    public StackToken pushToStackAndExecute(StackToken.CommandCode token, Number firstoperand,
                                  Number secondoperand, StackToken.DataTypeId theDatasType) {
        StackToken stackToken = new StackToken(secondoperand, theDatasType, token);
        this.machineStack.push(stackToken);
        stackToken = new StackToken(firstoperand, theDatasType, token);
        this.machineStack.push(stackToken);
        stackToken = new StackToken(0, StackToken.DataTypeId.COMMAND_CODE, token);
        this.machineStack.push(stackToken);
        process.executeCommandFromStack();
        stackToken = machineStack.pop();
        return stackToken;
    }

    public void popStackToReg(int regNo) {
        StackToken value = machineStack.pop();
        machineRegs[regNo] = value.getValue();
    }


    public void elementToReg(int regNo) {
        Number value = machineQueue.element();
        machineRegs[regNo] = value;
    }

    public Number addRegToQueue(int regNo) {
        Number value = machineRegs[regNo];
        machineQueue.add(value);
        return value;
    }


    public Number sourceToTargetReg(int sourceNo, int targetNo) {
        machineRegs[targetNo] = machineRegs[sourceNo];
        return machineRegs[targetNo];
    }

    public void swapRegs(int sourceNo, int targetNo) {
        Number valueSource = machineRegs[sourceNo];
        Number valueTarget = machineRegs[targetNo];
        machineRegs[targetNo] = valueSource;
        machineRegs[sourceNo] = valueTarget;
    }


    public class MathProcess {


        public MathProcess() {

        }

        public void executeCommandFromStack() {
            StackToken stackToken = machineStack.pop();
            StackToken.CommandCode code = stackToken.getOperation();
            stackToken = machineStack.pop();
            Number firstValue = stackToken.getValue();
            StackToken.DataTypeId firstType = stackToken.getType();
            stackToken = machineStack.pop();
            Number secondValue = stackToken.getValue();
            StackToken.DataTypeId secondType = stackToken.getType();
            if (firstType.equals(secondType)) {
                Number result = callByDatatypeCmd(firstType, code, firstValue,
                        secondValue);
             StackToken resultToken = new StackToken(result, firstType,
                     StackToken.CommandCode.NOP);
             machineStack.push(resultToken);
            }

        }

        public Number callByDatatypeCmd(StackToken.DataTypeId datatype,
                                        StackToken.CommandCode cmd,
                                        Number firstValue, Number secondValue) {

            switch (datatype) {
                case INTEGER -> {
                    Integer firstInt = (Integer)firstValue;
                    Integer secondInt = (Integer) secondValue;
                    switch (cmd) {
                        case MUL:
                            return multiply(firstInt, secondInt);
                        case ADD:
                            return add(firstInt, secondInt);
                        case DIVIDE:
                            return divide(firstInt, secondInt);
                        case SUBTRACT:
                            return sub(firstInt, secondInt);
                    }
                }
                case LONG -> {
                    Long firstLong = (Long)firstValue;
                    Long secondLong = (Long) secondValue;
                    switch (cmd) {
                        case MUL:
                            return multiply(firstLong, secondLong);
                        case ADD:
                            return add(firstLong, secondLong);
                        case DIVIDE:
                            return divide(firstLong, secondLong);
                        case SUBTRACT:
                            return sub(firstLong, secondLong);
                    }
                }
                case FLOAT -> {
                    Float firstFloat = (Float) firstValue;
                    Float secondFloat = (Float) secondValue;
                    switch (cmd) {
                        case MUL:
                            return multiply(firstFloat, secondFloat);
                        case ADD:
                            return add(firstFloat, secondFloat);
                        case DIVIDE:
                            return divide(firstFloat, secondFloat);
                        case SUBTRACT:
                            return sub(firstFloat, secondFloat);
                    }
                }
                case DOUBLE -> {
                    Double firstDouble = (Double) firstValue;
                    Double secondDouble = (Double) secondValue;
                    switch (cmd) {
                        case MUL:
                            return multiply(firstDouble, secondDouble);
                        case ADD:
                            return add(firstDouble, secondDouble);
                        case DIVIDE:
                            return divide(firstDouble, secondDouble);
                        case SUBTRACT:
                            return sub(firstDouble, secondDouble);
                    }
                }



            }
            return Integer.valueOf(0);
        }


            // multiply
            public Long multiply (Long op1, Long op2){
                return (op1 * op2);
            }

            public Integer multiply (Integer op1, Integer op2){
                return (op1 * op2);
            }

            public Float multiply (Float op1, Float op2){
                return (op1 * op2);
            }

            public Double multiply (Double op1, Double op2){
                return (op1 * op2);
            }

            public Long divide (Long op1, Long op2){
                return (op1 / op2);
            }

            public Integer divide (Integer op1, Integer op2){
                return (op1 / op2);
            }

            public Float divide (Float op1, Float op2){
                return (op1 / op2);
            }

            public Double divide (Double op1, Double op2){
                return (op1 / op2);
            }

            public Long add (Long op1, Long op2){
                return (op1 + op2);
            }

            public Integer add (Integer op1, Integer op2){
                return (op1 + op2);
            }

            public Float add (Float op1, Float op2){
                return (op1 + op2);
            }

            public Double add (Double op1, Double op2){
                return (op1 + op2);
            }


            public Long sub (Long op1, Long op2){
                return (op1 - op2);
            }

            public Integer sub (Integer op1, Integer op2){
                return (op1 - op2);
            }

            public Float sub (Float op1, Float op2){
                return (op1 - op2);
            }

            public Double sub (Double op1, Double op2){
                return (op1 - op2);
            }


            // next 2 basic -> minus / divide

            // then we will take the operands from stack and push the result back


        }
    }
