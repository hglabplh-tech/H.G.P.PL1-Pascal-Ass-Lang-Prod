package hgp.lang.bootstrap.parselex;

import hgp.lang.genCompile.pl_pas_assLangListener;
import hgp.lang.gparser.pl_pas_assLexer;
import hgp.lang.gparser.pl_pas_assParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class PlPassAss {

    public static void main(String[] params) {
        try {
            ANTLRInputStream input = new ANTLRInputStream(System.in);
            pl_pas_assLexer lexer = new pl_pas_assLexer((input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            pl_pas_assParser parser = new pl_pas_assParser(tokens);
            ParseTree tree = parser.initialValue();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new pl_pas_assLangListener(), tree);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
