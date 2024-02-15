package hgp.lang.genCompile.langblocks;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public abstract class BlockClassBase extends
Statement {
    List<BlockCommand> blockCommands = new ArrayList<>();
    public BlockClassBase(Token token, boolean openBlock, String name) {
        super(token, name);
        this.openBlock = openBlock;
    }

    private boolean openBlock = true;


    public boolean isOpenBlock() {
        return openBlock;
    }

    public void setOpenBlockClosed() {
        this.openBlock = false;
    }

    public List<BlockCommand> blockCommands() {
        return blockCommands;
    }

    public BlockClassBase setBlockCommands(List<BlockCommand> blockCommands) {
        this.blockCommands = blockCommands;
        return this;
    }

    public BlockClassBase addBlockCommand(BlockCommand blockCommands) {
        this.blockCommands.add(blockCommands);
        return this;
    }

    public static class BlockCommand {
        private final Token theToken;

        private Integer resultType;

        private List<Integer> paramTypes = new ArrayList<>();

        private final ActionType actionType;

        public BlockCommand(ActionType actionType, Token theToken) {
            this.actionType = actionType;
            this.theToken = theToken;
        }

        public Token theToken() {
            return theToken;
        }



        public Integer resultType() {
            return resultType;
        }

        public BlockCommand setResultType(Integer resultType) {
            this.resultType = resultType;
            return this;
        }

        public List<Integer> paramTypes() {
            return paramTypes;
        }

        public BlockCommand setParamTypes(List<Integer> paramTypes) {
            this.paramTypes = paramTypes;
            return this;
        }

        public ActionType actionType() {
            return actionType;
        }


    }

    public enum ActionType {
        NONE,
        STATEMENT,
        BLOCK,
        EXPRESSION,
        ASSIGN,
        FUNCALL,
        PROCCALL,





        ;
    }

}
