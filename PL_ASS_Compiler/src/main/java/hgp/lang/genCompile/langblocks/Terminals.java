package hgp.lang.genCompile.langblocks;

import org.antlr.v4.runtime.Token;

public class Terminals extends SimpleStatement  {

    private final String text;
    private final Integer type;
    private final Integer line;



    public Terminals(Token tok, String name,String text, Integer type, Integer line) {
        super(tok, name);
        this.text = text;
        this.line = line;
        this.type = type;

    }

    public String getText() {
        return text;
    }

    public Integer getType() {
        return type;
    }

    public Integer getLine() {
        return line;
    }
}
