package hgp.lang.runtime;

import bytecode.addon.MethodsInvoker;
import javassist.CtClass;
import javassist.bytecode.Bytecode;

import java.util.List;

import static bytecinit.InitByteC.getByteCode;
import static bytecinit.InitByteC.getClassPool;
import static bytecode.addon.MethodsInvoker.funInvoke;

public class LambdaFun implements ILambdaFun {
// TODO: add environment feature
    private Object result;
    private final List<CtClass> paramTypes;
    private final List<Object> paramValues;

    private final CtClass returnType;

    public LambdaFun(CtClass returnType, List<CtClass> paramTypes, List<Object> paramValues) {
        this.returnType = returnType;
        this.paramTypes = paramTypes;
        this.paramValues = paramValues;
    }

    @Override
    public ILambdaFun invoke(CtClass returnType, List<CtClass> paramTypes, List<Object> parmValues) {
        CtClass caller = getClassPool().makeClass(this.getClass().getCanonicalName());
        funInvoke(caller, "funBody", MethodsInvoker.InvocationTypes.STATIC,
                returnType, parmValues, paramTypes.toArray(new CtClass[0]));
        return this;
    }

    @Override
    public Object getReturnValue() {
        return result;
    }

    public static void funBody(CtClass returnType, Object... parms) {
        LambdaFun.theCode(getByteCode());
        getByteCode().addReturn(returnType);
    }

    public static void theCode(Bytecode thisByteCode) {

    }
}
