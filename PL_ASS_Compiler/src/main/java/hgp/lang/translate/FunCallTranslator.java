package hgp.lang.translate;

import hgp.lang.genCompile.langblocks.FunctionBlock;

import java.util.Objects;

public class FunCallTranslator implements TranslatorIfc {
    private final FunctionBlock funBlock;

    public FunCallTranslator(FunctionBlock funBlock) {
        this.funBlock = funBlock;
    }

    public Integer compile() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunCallTranslator that = (FunCallTranslator) o;
        return Objects.equals(funBlock, that.funBlock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funBlock);
    }
}
