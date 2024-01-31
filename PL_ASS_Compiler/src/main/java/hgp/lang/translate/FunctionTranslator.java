package hgp.lang.translate;

import hgp.lang.genCompile.langblocks.FunctionBlock;

import java.util.Objects;

public class FunctionTranslator implements TranslatorIfc {
    private final FunctionBlock funBlock;

    public FunctionTranslator(FunctionBlock funBlock) {
        this.funBlock = funBlock;
    }

    public Integer compile() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FunctionTranslator that = (FunctionTranslator) o;
        return Objects.equals(funBlock, that.funBlock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funBlock);
    }
}
