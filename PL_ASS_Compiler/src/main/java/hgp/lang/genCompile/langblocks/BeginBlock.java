package hgp.lang.genCompile.langblocks;

import org.antlr.v4.runtime.Token;

public class BeginBlock extends BlockClassBase {

    public BeginBlock(Token token, boolean openBlock, String name) {
        super(token, openBlock, name);
    }
}
