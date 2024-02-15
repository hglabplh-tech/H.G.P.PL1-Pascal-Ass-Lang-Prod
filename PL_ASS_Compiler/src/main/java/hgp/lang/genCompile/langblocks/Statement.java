package hgp.lang.genCompile.langblocks;

import hgp.lang.types.USERType;
import org.antlr.v4.runtime.Token;

public abstract class Statement extends USERType {

    private final Token token;

    public Statement(Token token, String name) {
        super(name);
        this.token = token;
    }
}
