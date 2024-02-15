package hgp.lang.genCompile.langblocks;

import org.antlr.v4.runtime.Token;

import java.io.Serializable;

public class SubExpression extends Statement implements Serializable, AutoCloseable {
    public SubExpression(Token token, String name) {
        super(token, name);
    }

    @Override
    public void close() throws Exception {

    }
}
