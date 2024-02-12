package hgp.lang.executor;

import java.util.concurrent.Callable;

public interface StepRunner extends Callable<CodeStep> {

    Binding getBinding();


}
