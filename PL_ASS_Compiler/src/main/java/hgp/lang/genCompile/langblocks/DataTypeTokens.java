package hgp.lang.genCompile.langblocks;

public class DataTypeTokens
{


    public enum DataTypeTok {
        NONE(0),
        LPAREN(57),
        RPAREN(58),
        LBRACK(59),
        RBRACK(61),
        ASSIGN(46),
        CHAR(6),
        RECORD(32),
        REAL(31),
        BOOLEAN(4),
        INTEGER(21),
        PACKED(28),
        VAR(39),
        PLUS(42),
        MINUS(43),
        STAR(44),
        RESULTPTR(48),
        EQUAL(51),
        NOT_EQUAL(52),
        LT(53),
        LE(54),
        GE(55),
        GT(56),
        POINTER(63),
        STRING(72),
        NUM_INT(94),
        NUM_REAL(95),
        EOL(96),
        IDENT(91),
        TRUE(74),
        FALSE(75),
        STRING_LITERAL(92),
        ASS_STRING(93),
        LAMBDA(86),
        DIV(9),
        NIL(24),
        NOT(25),
        ;

        private final Integer token;
        DataTypeTok(Integer token) {
            this.token = token;
        }

        public Integer getToken() {
            return token;
        }

        public static DataTypeTok getByToken(Integer token) {
            for (DataTypeTok actTok :DataTypeTok.values()) {
                if (actTok.getToken().equals(token)) {
                    return actTok;
                }
            }
            return NONE;
        }
    }

}
