package hgp.lang.runtime;

import javassist.CtClass;

import java.util.List;

public interface ILambdaFun {


    ILambdaFun invoke (CtClass returnType, List<CtClass> paramTypes, List<Object> parmValues);

    public Object getReturnValue();
}
