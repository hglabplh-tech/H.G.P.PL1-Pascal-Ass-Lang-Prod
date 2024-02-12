package hgp.lang.executor;

public abstract class CodeStep {

    private Binding parentBinding;

    protected CodeStep(Binding parent) {
        this.parentBinding = parent;
    }
    public Binding getParentBinding() {
        return parentBinding;
    }

    public CodeStep setParentBinding(Binding parentBinding) {
        this.parentBinding = parentBinding;
        return this;
    }
}
