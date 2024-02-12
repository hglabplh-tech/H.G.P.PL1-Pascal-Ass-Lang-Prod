package hgp.lang.genCompile.expressions;

import hgp.lang.executor.Program;
import hgp.lang.gparser.pl_pas_assParser;
import hgp.lang.runtime.calculationandtypes.NumericLogic;
import hgp.lang.runtime.calculationandtypes.RuntimeExpression;
import org.antlr.v4.codegen.model.TokenInfo;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShuntingYardTest {
    @Test
    public void simpleTest() {
        Program proc = new Program();
        Expression expr = new Expression(proc.getBinding());

        List<TerminalNode> terminals =  expr.getNodes();
        Token tok = new CommonToken(pl_pas_assParser.NUM_INT, "3");
        TerminalNode node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok= new CommonToken(pl_pas_assParser.STAR);
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok = new CommonToken(pl_pas_assParser.NUM_INT, "6");
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        ShuntingYard theParser = new ShuntingYard(expr);
        List<RuntimeExpression> parseResult = theParser.parse();
        NumericLogic numLogic = new NumericLogic();
        NumericLogic.Result res = numLogic.calculateTerm(parseResult);
        System.out.println(res);


    }

    @Test
    public void complexTest () {
        Program proc = new Program();
        Expression expr = new Expression(proc.getBinding());

        List<TerminalNode> terminals =  expr.getNodes();
        Token tok = new CommonToken(pl_pas_assParser.LPAREN, null);
        TerminalNode node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok = new CommonToken(pl_pas_assParser.NUM_INT, "3");
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok= new CommonToken(pl_pas_assParser.PLUS);
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok = new CommonToken(pl_pas_assParser.NUM_INT, "6");
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok = new CommonToken(pl_pas_assParser.RPAREN, null);
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok= new CommonToken(pl_pas_assParser.STAR, null);
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok = new CommonToken(pl_pas_assParser.LPAREN, null);
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok = new CommonToken(pl_pas_assParser.NUM_INT, "10");
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok= new CommonToken(pl_pas_assParser.MINUS);
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok = new CommonToken(pl_pas_assParser.NUM_INT, "3");
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok = new CommonToken(pl_pas_assParser.RPAREN, null);
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok= new CommonToken(pl_pas_assParser.SLASH);
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        tok = new CommonToken(pl_pas_assParser.NUM_INT, "2");
        node = new TerminalNodeImpl(tok);
        terminals.add(node);
        ShuntingYard theParser = new ShuntingYard(expr);
        List<RuntimeExpression> parseResult = theParser.parse();
        NumericLogic numLogic = new NumericLogic();
        NumericLogic.Result res = numLogic.calculateTerm(parseResult);
        System.out.println(res);
    }
}
