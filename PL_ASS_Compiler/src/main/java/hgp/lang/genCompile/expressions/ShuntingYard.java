package hgp.lang.genCompile.expressions;

import static hgp.lang.gparser.pl_pas_assParser.*;

import hgp.lang.runtime.calculationandtypes.RuntimeExpression;
import hgp.lang.runtime.calculationandtypes.StackToken;
import org.antlr.v4.runtime.Token;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ShuntingYard {

    private final List<Token
            > tokenList;

    public ShuntingYard(Expression expression) {
        this.tokenList = expression.getTokenList();
        this.tokenList.stream().map(Token::getType).toList();
    }


    public List<RuntimeExpression> parse() {
        List<RuntimeExpression> output = new ArrayList<>();
        Deque<Token> opStack = new ArrayDeque<>();


        List<Token> tokens = this.tokenList;

        output.add(addTypeInformation(StackToken.DataTypeId.INTEGER));
        for (Token token : tokens) {
            if (token.getType() == NUM_INT) {
                output.add(reallyAddToOutput(token));
           /* } else if (token instanceof FunctionToken) {
                Call call = new Call((FunctionToken) token);
                callStack.push(call);
                opStack.push(token); */
          /*  } else if (token.getType() == COMMA) {
                closeParenthesesGroup(opStack, output);

                incrementPeekFunctionArgumentCount(callStack);*/
            } else if (isType(token.getType(), StackToken.TokenType.MATH_TOKEN)) {
                processOperator(token, opStack, output);
            } else if (token.getType() == LPAREN) {
                opStack.push(token);
            } else if (token.getType() == RPAREN) {
                closeParenthesesGroup(opStack, output);
                opStack.pop();


                //processFunctionClosure(opStack, callStack, output);
            }
        }

        while (!opStack.isEmpty()) {
            Token token = opStack.pop();
            if (token.getType() == LPAREN) {
                throw new IllegalStateException("Mismatched parentheses!");
            } else {
                output.add(reallyAddToOutput(token));
            }

        }


        return output;
    }

    /**
     * Make fit
     *
     * @param outToken
     * @return
     */
    private RuntimeExpression reallyAddToOutput(Token outToken) {
        StackToken.Token internTok = getRuntimeToken(outToken.getType());
        StackToken.TokenType type = internTok.getType();

        if (type.equals(StackToken.TokenType.MATH_TOKEN)) {
            return new RuntimeExpression(internTok, null);
        } else if (type.equals(StackToken.TokenType.VALUE_TOKEN)) {
            Number theValue = null;
            switch (outToken.getType()) {
                case NUM_INT -> theValue = Integer.valueOf(outToken.getText());
                case NUM_REAL -> theValue = Double.valueOf(outToken.getText());


            }


            return new RuntimeExpression(internTok, theValue);// value ???
        } else {
            return new RuntimeExpression(internTok, null);
        }


    }

    private RuntimeExpression addTypeInformation(StackToken.DataTypeId typeId) {
        return new RuntimeExpression(StackToken.Token.TYPE_TOKEN, typeId);
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    private boolean isType(Integer code, StackToken.TokenType searchedType) {
        TokenMap token = TokenMap.getTokMapByCode(code);
        if (!token.equals(TokenMap.NOP_TOK)) {
            StackToken.TokenType type = token.getTokType();
            return type.equals(searchedType);
        }
        return false;
    }

    private StackToken.OperatorAssociativity getLeftRight(Integer code) {
        return TokenMap.getTokMapByCode(code).getLeftRight();
    }

    private StackToken.Token getRuntimeToken(Integer code) {
        return TokenMap.getTokMapByCode(code).getInternTok();
    }

    private Integer getPrecedenceFor(Integer code) {
        TokenMap token = TokenMap.getTokMapByCode(code);
        if (!token.equals(TokenMap.NOP_TOK)) {
            StackToken.CommandCode tokCode =
                    token.getInternTok().getCode();
            return StackToken.OperatorPrecedence.getPrecedenceFor(tokCode);
        }
        return -1;
    }

    /**
     * Pops back to the place where the parenthesis was found. Left parenthesis is not popped from
     * the stack.
     *
     * @param opStack operators stack
     * @param output  output token list
     */
    private void closeParenthesesGroup(Deque<Token> opStack, List<RuntimeExpression> output) {
        Token token = opStack.peek();
        if (token != null) {
            while (token.getType() != LPAREN) {
                Token toWrite = opStack.pop();
                output.add(reallyAddToOutput(toWrite));
                if (opStack.isEmpty()) {
                    throw new IllegalStateException("Missing left parenthesis");
                }
                token = opStack.peek();
                if (token == null) {
                    break;
                }
            }
        }

    }

    /**
     * When the call stack is not empty, increment argument list for the last element on the call stack.
     * @param callStack stack containing information about functions
     */
  /*  private void incrementPeekFunctionArgumentCount(Deque<Call> callStack) throws SyntaxException {
        if(!callStack.isEmpty()) {
            callStack.peek().incArgumentCount();
        } else {
            throw new IllegalStateException("No function found. Comma used in the wrong place.");
        }
    } */

    /**
     * Standard Shunting-yard algorithm for processing (math) operators.
     *
     * @param operator current operator
     * @param opStack  operators stack
     * @param output   output token list
     */
    private void processOperator(Token opToken, Deque<Token> opStack,
                                 List<RuntimeExpression> output) {
        Integer token = opToken.getType();
        Integer actPrecedence = getPrecedenceFor(token);
        Token topToken = opStack.peek();
        if (topToken != null) {
            while (isType(topToken.getType(), StackToken.TokenType.MATH_TOKEN)) {

                // Token topOperator =  opStack.peek();
                Integer topPrecedence = getPrecedenceFor(topToken.getType());

                if (topPrecedence > actPrecedence ||
                        (getLeftRight(token)
                                .equals(StackToken.OperatorAssociativity.LEFT) &&
                                topPrecedence.equals(actPrecedence))) {
                    Token toWrite = opStack.pop();
                    output.add(reallyAddToOutput(toWrite));
                } else {
                    break;
                }
                topToken = opStack.peek();
                if (topToken == null) {
                    break;
                }
            }
        }
        opStack.push(opToken);

    }


}
