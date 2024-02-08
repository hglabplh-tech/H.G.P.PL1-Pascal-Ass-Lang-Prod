package hgp.lang.genCompile.expressions;


import genbytecj.generator.model.metamodel.expressions.Expression;
import hgp.lang.gparser.pl_pas_assParser;
import hgp.lang.runtime.calculationandtypes.StackToken;

import static hgp.lang.gparser.pl_pas_assParser.*;
import static hgp.lang.runtime.calculationandtypes.StackToken.*;

public enum TokenMap {
    ADD_TOK(PLUS, Token.ADD_TOKEN, TokenType.MATH_TOKEN, OperatorAssociativity.LEFT),
    SUB_TOK(MINUS, Token.SUBTRACT_TOKEN, TokenType.MATH_TOKEN, OperatorAssociativity.LEFT),
    MUL_TOK(STAR, Token.MUL_TOKEN, TokenType.MATH_TOKEN, OperatorAssociativity.LEFT),
    DIV_TOK(SLASH, Token.DIVIDE_TOKEN, TokenType.MATH_TOKEN, OperatorAssociativity.LEFT),
    NUM_INT_TOK(NUM_INT, Token.CONST_VALUE_TOKEN, TokenType.VALUE_TOKEN, OperatorAssociativity.NOT_APPLICABLE),
    LPAREN_TOK(LPAREN, Token.LPAREN_TOKEN, TokenType.SPECIAL_TOKEN, OperatorAssociativity.NOT_APPLICABLE),
    RPAREN_TOK(RPAREN, Token.RPAREN_TOKEN, TokenType.SPECIAL_TOKEN, OperatorAssociativity.NOT_APPLICABLE),
    NOP_TOK(-1, Token.TYPE_TOKEN, TokenType.SPECIAL_TOKEN, OperatorAssociativity.NOT_APPLICABLE)
    ;

    private final Integer code;
    private final Token internTok;
    private final TokenType tokType;

    private final OperatorAssociativity leftRight;

    TokenMap(Integer code, Token internTok, TokenType tokType, OperatorAssociativity leftRight) {
        this.code = code;
        this.internTok = internTok;
        this.tokType = tokType;
        this.leftRight = leftRight;
    }

    public Integer getCode() {
        return code;
    }

    public Token getInternTok() {
        return internTok;
    }

    public TokenType getTokType() {
        return tokType;
    }

    public OperatorAssociativity getLeftRight() {
        return leftRight;
    }

    public static TokenMap getTokMapByCode(Integer theCode) {
        for (TokenMap tokMap: TokenMap.values()) {
            if (theCode.equals(tokMap.getCode())) {
                return tokMap;
            }
        }
        return NOP_TOK;
    }
}
