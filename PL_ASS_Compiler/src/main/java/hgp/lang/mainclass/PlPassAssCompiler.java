package hgp.lang.mainclass;


import hgp.lang.genCompile.CummulationThread;
import hgp.lang.genCompile.PlPasAssLangListener;
import hgp.lang.genCompile.PlPasAssLangVisitor;
import hgp.lang.gparser.pl_pas_assLexer;
import hgp.lang.gparser.pl_pas_assParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.RuleNode;


import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.*;

public class PlPassAssCompiler {

    public final CummulationThread collector;
    public PlPassAssCompiler(CummulationThread collector) {
        this.collector = collector;
        init();
    }

    private void init() {

    }


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
            CummulationThread collector = new CummulationThread();
            ExecutorService service = Executors.newFixedThreadPool(2);
            service.submit(collector);
            PlPasAssLangVisitor visitor = new PlPasAssLangVisitor();
            Object o = visitor.visit(tree);
            visitor.visitChildren((RuleNode)tree
            );
            //ParseTreeWalker walker = ParseTreeWalker.DEFAULT;
            //walker.walk(new PlPasAssLangListener(collector), tree);
            PlPassAssCompiler compiler = new PlPassAssCompiler(collector);
            service.shutdown();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
