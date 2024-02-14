package hgp.lang.genCompile.expressions;

import hgp.lang.executor.Binding;
import hgp.lang.executor.CodeStep;
import hgp.lang.executor.StepRunner;
import hgp.lang.executor.VariableReference;
import hgp.lang.runtime.calculationandtypes.NumericLogic;
import hgp.lang.runtime.calculationandtypes.RuntimeExpression;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class Assignment extends CodeStep implements StepRunner {

    private final TerminalNode target;

    private Expression source;

    public Assignment(Binding parent, TerminalNode target) {
        super(parent);
        this.target = target;
        source = new Expression(parent);
    }

    public TerminalNode getTarget() {
        return target;
    }

    public Expression getSource() {
        return source;
    }

    @Override
    public Binding getBinding() {
        return getParentBinding();
    }

    @Override
    public CodeStep call() throws Exception {
        // calculate value from expression
        if (this.getSource().getNodes().size() > 1){
            ShuntingYard theParser = new ShuntingYard(this.getSource());
            List<RuntimeExpression> parseResult = theParser.parse();
            NumericLogic numLogic = new NumericLogic();
            NumericLogic.Result res = numLogic.calculateTerm(parseResult);
            Number theValue = res.getTheValue();
            // change value in binding
            String varName = getTarget().getSymbol().getText();
            VariableReference ref = getBinding().getFromPool(varName);
            if (ref != null) {
                VariableReference newRef = new VariableReference(ref.varType(), theValue);
                getBinding().changeINPool(varName, newRef);
            }
            this.getSource().getNodes().clear();
        } else if (!this.getSource().getNodes().isEmpty()){
            TerminalNode node = this.getSource().getNodes().get(0);
            String varName = getTarget().getSymbol().getText();
            VariableReference ref = getBinding().getFromPool(varName);
            VariableReference newRef = new VariableReference(node.getSymbol().getType(),
                    node.getSymbol().getText());
            getBinding().changeINPool(varName, newRef);
            this.getSource().getNodes().clear();

        } else {
            this.getSource().getNodes().clear();
        }




        return null;
    }
}
