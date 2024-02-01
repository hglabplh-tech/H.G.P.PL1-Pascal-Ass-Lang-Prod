package hgp.lang.genCompile.langblocks;

import org.antlr.v4.runtime.Token;

public class BlockClassBase extends
Statement{

    public BlockClassBase(Token token, boolean openBlock) {
        super(token);
        this.openBlock = openBlock;
    }

    private boolean openBlock = true;


    public boolean isOpenBlock() {
        return openBlock;
    }

    public void setOpenBlockClosed() {
        this.openBlock = false;
    }

}
