package hgp.lang.genCompile;


import hgp.lang.gparser.pl_pas_assLexer;
import hgp.lang.gparser.pl_pas_assParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class TestLangListener {


    @Test
    public void simpleTest() {
        try {
            ANTLRInputStream input =
                    new ANTLRInputStream(
                            getResourceByPath("/resources/basics/helloworld.pas"));
            pl_pas_assLexer lexer = new pl_pas_assLexer((input));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            pl_pas_assParser parser = new pl_pas_assParser(tokens);
            ParseTree tree = parser.initialValue();
            ParseTreeWalker walker = new ParseTreeWalker();
            ParseLangTestListener listener = new ParseLangTestListener();
            walker.walk(listener, tree);

            System.out.println("...finished...");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static InputStream getResourceByPath(String path) {
        InputStream stream = TestLangListener.class.getResourceAsStream(path);
        if (stream == null) {
        }
        return stream;

    }

}
