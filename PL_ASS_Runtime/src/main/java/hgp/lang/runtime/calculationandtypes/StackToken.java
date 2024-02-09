package hgp.lang.runtime.calculationandtypes;

import org.antlr.v4.runtime.atn.StarLoopEntryState;

import java.util.*;

public class StackToken
{

    /** the value
     *
     */
    private final Number value;

    private final DataTypeId type;

    private final CommandCode operation;


    public StackToken(Number value, DataTypeId type, CommandCode operation) {
        this.value = value;
        this.type = type;
        this.operation = operation;
    }

    public Number getValue() {
        return value;
    }

    public DataTypeId getType() {
        return type;
    }

    public CommandCode getOperation() {
        return operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackToken that = (StackToken) o;
        return Objects.equals(value, that.value) && type == that.type && operation == that.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type, operation);
    }

    public enum CommandCode {
        NOP,
        NOT,
        ADD,
        SUBTRACT,
        DIVIDE,
        MUL,
        MODULO,
        START_BLOCK,
        END_BLOCK,
        TYPE,
        CONST_VALUE,
        VAR,
        IDENT,
        LPAREN,
        RPAREN,
        SQRT
        ;


    }

    public enum DataTypeId {
        COMMAND_CODE,
        FLOAT,
        DOUBLE,
        INTEGER,
        LONG,
        BYTE,
        SHORT
        ;
    }

    public enum TokenType {
        MATH_TOKEN,
        VALUE_TOKEN,
        VAR_TOKEN,
        SPECIAL_TOKEN,


        ;
    }

    public static class OperatorPrecedence {
        public static Map<Integer, List<CommandCode>>
                precedenceMap = new HashMap<>();

        static {
            precedenceMap.put(20, Arrays.asList(CommandCode.NOT));
            precedenceMap.put(15, Arrays.asList(CommandCode.MUL, CommandCode.MODULO,
                    CommandCode.DIVIDE));
            precedenceMap.put(10, Arrays.asList(CommandCode.ADD, CommandCode.SUBTRACT));
        }

        public static Integer getPrecedenceFor(CommandCode code) {
           List<Integer> keys =  precedenceMap.entrySet().stream()
                   .filter(e -> e.getValue().contains(code))
                   .map(Map.Entry::getKey)
                   .toList();
           if (keys.size() == 1) {
               return keys.get(0);
           }
           return -1;
        }
    }

    public enum OperatorAssociativity {
        NOT_APPLICABLE,
        LEFT,
        RIGHT
    }

    public enum Token {
        MUL_TOKEN(CommandCode.MUL, TokenType.MATH_TOKEN, 2,OperatorAssociativity.LEFT),
        DIVIDE_TOKEN(CommandCode.DIVIDE, TokenType.MATH_TOKEN, 2, OperatorAssociativity.LEFT),
        ADD_TOKEN(CommandCode.ADD, TokenType.MATH_TOKEN, 2, OperatorAssociativity.LEFT),
        SUBTRACT_TOKEN(CommandCode.SUBTRACT, TokenType.MATH_TOKEN, 2,  OperatorAssociativity.LEFT),
        MODULO_TOKEN(CommandCode.MODULO, TokenType.MATH_TOKEN, 2, OperatorAssociativity.LEFT),
        START_BLOCK_TOKEN(CommandCode.START_BLOCK, TokenType.SPECIAL_TOKEN, 0, OperatorAssociativity.NOT_APPLICABLE),
        END_BLOCK_TOKEN(CommandCode.END_BLOCK, TokenType.SPECIAL_TOKEN, 0, OperatorAssociativity.NOT_APPLICABLE),
        CONST_VALUE_TOKEN(CommandCode.CONST_VALUE, TokenType.VALUE_TOKEN, 1, OperatorAssociativity.NOT_APPLICABLE),
        VAR_TOKEN(CommandCode.VAR, TokenType.VALUE_TOKEN, 1,
                OperatorAssociativity.NOT_APPLICABLE),
        IDENT_TOKEN(CommandCode.IDENT, TokenType.VALUE_TOKEN, 1,
                OperatorAssociativity.NOT_APPLICABLE),
        TYPE_TOKEN(CommandCode.TYPE, TokenType.VALUE_TOKEN, 1, OperatorAssociativity.NOT_APPLICABLE),

        LPAREN_TOKEN(CommandCode.LPAREN, TokenType.SPECIAL_TOKEN, 0, OperatorAssociativity.NOT_APPLICABLE),
        RPAREN_TOKEN(CommandCode.RPAREN, TokenType.SPECIAL_TOKEN, 0, OperatorAssociativity.NOT_APPLICABLE);
        ;

        private final CommandCode code;
        private final TokenType type;
        private final Integer paramCount;

        private final OperatorAssociativity leftRight;

        Token(CommandCode code, TokenType type, Integer paramCount,  OperatorAssociativity leftRight) {
            this.code = code;
            this.type = type;
            this.paramCount = paramCount;
            this.leftRight = leftRight;
        }

        public CommandCode getCode() {
            return code;
        }

        public TokenType getType() {
            return type;
        }

        public Integer getParamCount() {
            return paramCount;
        }

        public OperatorAssociativity getLeftRight() {
            return leftRight;
        }
    }
}
