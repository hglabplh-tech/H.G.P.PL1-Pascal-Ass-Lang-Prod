package hgp.lang.genCompile;

public class BlockClassBase {



    private boolean openBlock = true;
    public BlockClassBase() {

    }

    public boolean isOpenBlock() {
        return openBlock;
    }

    public void setOpenBlockClosed() {
        this.openBlock = false;
    }

}