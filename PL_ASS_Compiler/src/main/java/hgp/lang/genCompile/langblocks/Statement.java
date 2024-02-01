package hgp.lang.genCompile.langblocks;

import org.antlr.v4.runtime.Token;

public abstract class Statement {

    private final Token token;

    public Statement(Token token) {
        this.token = token;
    }
}
