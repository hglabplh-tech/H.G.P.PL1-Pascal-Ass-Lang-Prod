package hgp.lang.runtime;

import clojure.lang.Obj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FunCallStack {
    private final List<Stack<Object>> funStacks = new ArrayList<>();

    public FunCallStack() {
        funStacks.add(new Stack<Object>());
    }

    public Object peekFromTop() {
        return funStacks.get(0).peek();
    }

    public Stack<Object> getCurrentStack() {
        return funStacks.get(0);
    }

    public void pushOnTop(Object pointer) {
        funStacks.get(0).push(pointer);
    }

    public Object popFromTop() {
        return funStacks.get(0).pop();
    }
}
