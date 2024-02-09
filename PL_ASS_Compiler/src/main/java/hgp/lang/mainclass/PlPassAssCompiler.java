package hgp.lang.mainclass;


import clojure.lang.Symbol;
import hgp.lang.genCompile.PlPasAssLangListener;
import hgp.lang.genCompile.expressions.Expression;
import hgp.lang.genCompile.expressions.ShuntingYard;
import hgp.lang.genCompile.expressions.VarDeclare;
import hgp.lang.gparser.pl_pas_assLexer;
import hgp.lang.gparser.pl_pas_assParser;
import hgp.lang.runtime.calculationandtypes.NumericLogic;
import hgp.lang.runtime.calculationandtypes.RuntimeExpression;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class PlPassAssCompiler {


    public static void main(String[] params) {
        try {
            File theInputFile = new File(params[0]);
            if (!theInputFile.exists())
                return;
            FileInputStream inputStream = new FileInputStream(theInputFile);

            ANTLRInputStream input =
                    new ANTLRInputStream(inputStream);

            pl_pas_assLexer lexer = new pl_pas_assLexer((input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            pl_pas_assParser parser = new pl_pas_assParser(tokens);
            ParseTree tree = parser.program();


           // PlPasAssLangVisitor<PrivateVisitContext> visitor = new PlPasAssLangVisitor<>();
           // Object o = visitor.visit(tree);
            //visitor.visitChildren((RuleNode)tree );
            ParseTreeWalker walker = ParseTreeWalker.DEFAULT;
            PlPasAssLangListener langListener = new PlPasAssLangListener();
            walker.walk(langListener, tree);
            Expression result = langListener.getExpression();
            Map<String, VarDeclare> variables = langListener.getVariableDecl();
            System.out.println(result);
            ShuntingYard theParser = new ShuntingYard(result);
            List<RuntimeExpression> parseResult = theParser.parse();
            NumericLogic numLogic = new NumericLogic();
            NumericLogic.Result res = numLogic.calculateTerm(parseResult);
            System.out.println(res);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
