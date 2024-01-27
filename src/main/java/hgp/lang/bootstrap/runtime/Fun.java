package hgp.lang.bootstrap.runtime;

import clojure.lang.Obj;

import java.util.*;
import java.util.function.Function;

public class Fun {

    public final FunCallStack stack;
    public final Function<Stack<Object>, Integer> funToCall;
    public Fun(Function<Stack<Object>, Integer> thisFun) {
        this.stack = new FunCallStack();
        this.funToCall = thisFun;

    }

    public Object callTheFunction(Map<Integer, RibCageEnv.Address>
                                          currentEnv, Object... params) {
        this.stack.pushOnTop(currentEnv);
        Arrays.asList(params).forEach(this.stack::pushOnTop);

        // really call function
        this.funToCall.apply(stack.getCurrentStack());
        Object returnVal = this.stack.popFromTop();

        // after getting return shutdown thw stack

        for (int i = 0; i < params.length; i++) {
            this.stack.popFromTop();
        }
        this.stack.popFromTop();
        return returnVal;
    }
}
