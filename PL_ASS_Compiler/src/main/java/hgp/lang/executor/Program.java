package hgp.lang.executor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Program extends CodeStep implements StepRunner
{


    private List<CodeStep> topLevelCode = new ArrayList<>();

    private Binding mainBinding = new Binding();


    public Program() {
        super(null);
    }

    protected Program(Binding parent) {
        super(parent);
    }

    public List<CodeStep> topLevelCode() {
        return topLevelCode;
    }

    public Program setTopLevelCode(List<CodeStep> topLevelCode) {
        this.topLevelCode = topLevelCode;
        return this;
    }

    public Program addCodeStep(CodeStep codeStep) {
        this.topLevelCode.add(codeStep);
        return this;
    }

    @Override
    public Binding getBinding() {
        return this.mainBinding;
    }






    @Override
    public CodeStep call() throws Exception {
        this.setParentBinding(new Binding());
        Iterator<CodeStep> iter = topLevelCode.iterator();
        while (iter.hasNext()) {

        }
        return null;
    }
}
