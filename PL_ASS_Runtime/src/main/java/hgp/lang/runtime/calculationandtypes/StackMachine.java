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

    public StackToken pushToStack(StackToken.CommandCode token, Number firstoperand,
                                  Number secondoperand, StackToken.DataTypeId theDatasType) {
        StackToken stackToken= new StackToken(secondoperand, theDatasType, token);
        this.machineStack.push(stackToken);
        stackToken = new StackToken(firstoperand, theDatasType, token);
        this.machineStack.push(stackToken);
        stackToken = new StackToken(0, StackToken.DataTypeId.COMMAND_CODE, token);
        this.machineStack.push(stackToken);
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


    public static class MathProcess {


        public MathProcess() {

        }


        // multiply
        public Long multiply(Long op1, Long op2) {
            return (op1 * op2);
        }

        public Integer multiply(Integer op1, Integer op2) {
            return (op1 * op2);
        }

        public Float multiply(Float op1, Float op2) {
            return (op1 * op2);
        }

        public Double multiply(Double op1, Double op2) {
            return (op1 * op2);
        }

        public Long divide(Long op1, Long op2) {
            return (op1 / op2);
        }

        public Integer divide(Integer op1, Integer op2) {
            return (op1 / op2);
        }

        public Float divide(Float op1, Float op2) {
            return (op1 / op2);
        }

        public Double divide(Double op1, Double op2) {
            return (op1 / op2);
        }

        public Long add(Long op1, Long op2) {
            return (op1 + op2);
        }

        public Integer add(Integer op1, Integer op2) {
            return (op1 + op2);
        }

        public Float add(Float op1, Float op2) {
            return (op1 + op2);
        }

        public Double add(Double op1, Double op2) {
            return (op1 + op2);
        }


        public Long sub(Long op1, Long op2) {
            return (op1 - op2);
        }

        public Integer sub(Integer op1, Integer op2) {
            return (op1 - op2);
        }

        public Float sub(Float op1, Float op2) {
            return (op1 - op2);
        }

        public Double sub(Double op1, Double op2) {
            return (op1 - op2);
        }


        // next 2 basic -> minus / divide

        // then we will take the operands from stack and push the result back


    }
}
