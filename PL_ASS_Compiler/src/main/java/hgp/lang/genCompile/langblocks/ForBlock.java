package hgp.lang.genCompile.langblocks;

import org.antlr.v4.runtime.Token;

import java.io.Serial;
import java.io.Serializable;

public class ForBlock extends BlockClassBase implements Serializable, AutoCloseable {
    public ForBlock(Token token, boolean openBlock, String name) {
        super(token, openBlock, name);
    }

    @Override
    public void close() throws Exception {

    }
}
