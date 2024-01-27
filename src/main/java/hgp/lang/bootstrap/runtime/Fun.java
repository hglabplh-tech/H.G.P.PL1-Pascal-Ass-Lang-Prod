package hgp.lang.bootstrap.runtime;

import clojure.lang.Obj;

import java.util.*;
import java.util.function.Function;

public class Fun {

    /**
     * The stack environment for this call
      */
    public final FunCallStack stack;
    /**
     * This is the stack during the call
     */
    public final Function<Stack<Object>, Integer> funToCall;

    /**
     * Create this class to call a function with stack
     * @param thisFun the function to get called
     */
    public Fun(Function<Stack<Object>, Integer> thisFun) {
        this.stack = new FunCallStack();
        this.funToCall = thisFun;

    }

    /**
     *
     * @param currentEnv the current environment of the application
     * @param params the function call parameters
     * @return theee rturn of the function which is getting called
     */
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
