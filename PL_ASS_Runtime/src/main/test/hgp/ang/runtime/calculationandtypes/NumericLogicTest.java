package hgp.ang.runtime.calculationandtypes;

import hgp.lang.runtime.calculationandtypes.RuntimeExpression;
import hgp.lang.runtime.calculationandtypes.NumericLogic;
import hgp.lang.runtime.calculationandtypes.StackToken;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NumericLogicTest {
    @Test
    public void testSimpleExpression() {
        List<RuntimeExpression> exprList = Arrays.asList(
                new RuntimeExpression(StackToken.Token.TYPE_TOKEN, StackToken.DataTypeId.INTEGER),
                new RuntimeExpression(StackToken.Token.CONST_VALUE_TOKEN, Integer.valueOf(9)),
                new RuntimeExpression(StackToken.Token.CONST_VALUE_TOKEN, Integer.valueOf(73)),
                new RuntimeExpression(StackToken.Token.ADD_TOKEN, null),
                new RuntimeExpression(StackToken.Token.CONST_VALUE_TOKEN, Integer.valueOf(6)),
                new RuntimeExpression(StackToken.Token.SUBTRACT_TOKEN, null));



        NumericLogic numLog = new NumericLogic();
        numLog.calculateTerm(exprList);

    }
}
