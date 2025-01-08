package hgp.lang.genCompile.expressions;

import hgp.lang.gparser.pl_pas_assParser;
import hgp.lang.types.ArrayType;
import hgp.lang.types.StringType;
import hgp.lang.types.SubrangeType;
import hgp.lang.types.TypeRegistry;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

import static hgp.lang.gparser.pl_pas_assParser.*;

public class ExpressionsToObjects {
    public static ValTypeResult handleConstantCtx(ConstantContext constantCtx) {
        String value = null;
        String name = null;
        Integer type = 0;
        IdentifierContext identCtx = constantCtx.identifier();
        if (identCtx != null) {
            name = identCtx.IDENT().getSymbol().getText();
        }


        ConstantChrContext ctxChrContext = constantCtx.constantChr();
        UnsignedNumberContext unsignedCtx = constantCtx.unsignedNumber();
        StringContext strCtx = constantCtx.string();
        if (ctxChrContext != null) {
            UnsignedIntegerContext uintCtx =
                    ctxChrContext.unsignedInteger();
            TerminalNode chrNode = ctxChrContext.CHR();
            if (uintCtx != null) {
                value = uintCtx.NUM_INT().getSymbol().getText();
                type = uintCtx.NUM_INT().getSymbol().getType();
            }
            if (chrNode != null) {
                value = chrNode.getSymbol().getText();
                type = chrNode.getSymbol().getType();
            }
        }
        if (unsignedCtx != null) {
            UnsignedIntegerContext uintCtx = unsignedCtx.unsignedInteger();
            UnsignedRealContext realCtx = unsignedCtx.unsignedReal();
            if (uintCtx != null) {
                value = uintCtx.NUM_INT().getSymbol().getText();
                type = uintCtx.NUM_INT().getSymbol().getType();
            }
            if (realCtx != null) {
                value = realCtx.NUM_REAL().getSymbol().getText();
                type = realCtx.NUM_REAL().getSymbol().getType();
            }
        }
        if (strCtx != null) {
            TerminalNode strLiteralNode = strCtx.STRING_LITERAL();
            if (strLiteralNode != null) {
                value = strLiteralNode.getSymbol().getText();
                type = strLiteralNode.getSymbol().getType();
            }
        }
        ValTypeResult result = new ValTypeResult(value, type, null);
        return result;
    }

    public static ValTypeResult handleSimpleExpression(List<SimpleExpressionContext> expressionList) {
            for (SimpleExpressionContext simpleExpr : expressionList) {
                TermContext termCtx = simpleExpr.term();
                if (termCtx != null) {
                    MultiplicativeoperatorContext multCtx = termCtx.multiplicativeoperator();
                    if (multCtx != null) {
                        TerminalNode slashNode = multCtx.SLASH();
                        TerminalNode andNode = multCtx.AND();
                        TerminalNode starNode = multCtx.STAR();
                        TerminalNode divNode = multCtx.DIV();
                        TerminalNode modNode = multCtx.MOD();
                        if (slashNode != null) {

                        }
                        if (andNode != null) {

                        }
                        if (starNode != null) {

                        }
                        if (divNode != null) {

                        }
                        if (modNode != null) {

                        }
                    }
                    SignedFactorContext sfactCtx = termCtx.signedFactor();
                    if (sfactCtx != null) {
                        sfactCtx.MINUS();
                        sfactCtx.PLUS();
                        FactorContext factCtx = sfactCtx.factor();
                        if (factCtx != null) {
                            Set_Context setCtx = factCtx.set_();
                            if (setCtx != null) {
                                ElementListContext elemListCtx = setCtx.elementList();
                                if (elemListCtx != null) {
                                    for (ElementContext elemCtx : elemListCtx.element()){
                                        List<ExpressionContext> exprCtx = elemCtx.expression();

                                    }
                                }
                            }

                        }
                    }
                    termCtx = termCtx.term();

                     // rcursion of term build own method
                }
                simpleExpr.simpleExpression(); // recursion
            }

            return null;
    }

    public static ValTypeResult handleRelationaloperatorContextNodes(
            List<RelationaloperatorContext> relOpCtxList) {
        if(relOpCtxList != null) {
            for (RelationaloperatorContext relOpCtx : relOpCtxList) {
                TerminalNode geNode = relOpCtx.GE();
                TerminalNode gtNode = relOpCtx.GT();
                TerminalNode inNode = relOpCtx.IN();
                TerminalNode eqNode = relOpCtx.EQUAL();
                TerminalNode leNode = relOpCtx.LE();
                TerminalNode ltNode = relOpCtx.LT();
                TerminalNode neqNode = relOpCtx.NOT_EQUAL();

                if (geNode != null) {

                }
                if (gtNode != null) {

                }
                if (inNode != null) {

                }
                if (eqNode != null) {

                }
                if (neqNode != null) {

                }
                if (leNode != null) {

                }
                if (ltNode != null) {

                }




            }
        }
        return null;
    }

    public static ValTypeResult handleSimpleType(SimpleTypeContext simpleType, String typeName) {

        ValTypeResult overall = null;
        String value = null;
        Integer type = null;

        StringtypeContext strCtx = simpleType.stringtype();

        TypeIdentifierContext idTypeContext= simpleType.typeIdentifier();

        if (idTypeContext != null) {
            IdentifierContext idContex = idTypeContext.identifier();
            Token identToken = idContex.IDENT().getSymbol();

            overall = new ValTypeResult(null,  identToken.getType(), typeName);
            return overall;
        }

        if (strCtx != null) {
            TerminalNode stringNode = strCtx.STRING();
            TerminalNode lBrack = strCtx.LBRACK();
            TerminalNode rBrack = strCtx.RBRACK();
            UnsignedNumberContext unsigned = strCtx.unsignedNumber();
            if (unsigned != null) {
                UnsignedRealContext unsignedRealCtx =
                        unsigned.unsignedReal();
                UnsignedIntegerContext unsignedIntCtx =
                        unsigned.unsignedInteger();
                if (unsignedRealCtx != null) {
                    String nameOrNum =
                            unsignedRealCtx.NUM_REAL().getSymbol().getText();
                }
                if (unsignedIntCtx != null) {
                    String nameOrNum =
                            unsignedIntCtx.NUM_INT().getSymbol().getText();
                }
            }
        }
        TypeIdentifierContext typeIdCtx = simpleType.typeIdentifier();
        ScalarTypeContext scalarCtx = simpleType.scalarType();
        SubrangeTypeContext subrangeCtx = simpleType.subrangeType();
        StringtypeContext stringCtx = simpleType.stringtype();
        String theName = null;
        Integer theType = 0;
        if (stringCtx != null) {
            List<ValTypeResult> results = new ArrayList<>();
            UnsignedNumberContext unsigned = stringCtx.unsignedNumber();
            TerminalNode stringNode  = stringCtx.STRING();
            IdentifierContext strIdCtx = stringCtx.identifier();
            StringType.ParmType pType = StringType.ParmType.CONST;
            if (strIdCtx != null) {
                TerminalNode ident = strIdCtx.IDENT();
                if (ident != null) {
                    Token identTok = ident.getSymbol();
                    theName = identTok.getText();
                    theType = identTok.getType();
                    ValTypeResult res = new ValTypeResult(null, theType, theName);
                    results.add(res);
                    pType = StringType.ParmType.IDENT;
                }
            }
            if (stringNode != null) {
                Token stringTok = stringNode.getSymbol();
                theName = stringTok.getText();
                theType = stringTok.getType();

            }

            if (unsigned != null) {
                UnsignedRealContext realCtx = unsigned.unsignedReal();
                UnsignedIntegerContext uintCtx = unsigned.unsignedInteger();
                String text = null;
                Integer strType = null;
                if (realCtx != null) {
                    text = realCtx.NUM_REAL().getSymbol().getText();
                    strType = realCtx.NUM_REAL().getSymbol().getType();
                }
                if (uintCtx != null) {
                    strType = uintCtx.NUM_INT().getSymbol().getType();
                    text = uintCtx.NUM_INT().getSymbol().getText();
                }
                overall = new ValTypeResult(text, strType,null);

                ValTypeResult res = new ValTypeResult(text, strType, null);
                results.add(res);
                pType = StringType.ParmType.CONST;
            }
            String parmValue = null;
            if (pType.equals(StringType.ParmType.IDENT)) {
                parmValue = results.get(0).name;
            } else  if (pType.equals(StringType.ParmType.CONST)) {
                parmValue = results.get(0).value;
            }
            StringType strType = new StringType(typeName,
                    parmValue, pType);
            TypeRegistry.addUserType(typeName, strType);
        }
        if (scalarCtx != null) {
            IdentifierListContext idListCtx = scalarCtx.identifierList();
            if (idListCtx != null) {
                List<IdentifierContext> idCtxList =
                        idListCtx.identifier();
                for (IdentifierContext idContext : idCtxList) {
                    theName = idContext.IDENT().getSymbol().getText();
                    theType = idContext.IDENT().getSymbol().getType();

                }

            }
        }
        if (subrangeCtx != null) {
            List<ConstantContext> constCtxList =
                    subrangeCtx.constant();
            if (constCtxList != null) {
                List<ConstantContext> constantListCtx = subrangeCtx.constant();
                TerminalNode dotDot = subrangeCtx.DOTDOT();
                if (dotDot != null) {
                    Token dotDotTok = dotDot.getSymbol();
                    Integer dotType = dotDotTok.getType();
                    String dotText = dotDotTok.getText();
                    overall = new ValTypeResult(null, dotType, dotText);
                }
                if (constantListCtx != null) {
                    for (ConstantContext constantCtx : constantListCtx) {
                        if(constantCtx.identifier() != null) {
                            typeName = constantCtx.identifier().getText();
                        }
                        if (constantCtx.constantChr() != null) {
                            ConstantChrContext constChrCtx = constantCtx.constantChr();
                            if (constChrCtx.CHR() != null) {
                                TerminalNode CHRNode =  constChrCtx.CHR();
                                CHRNode.getSymbol().getType();
                            }

                        }
                    }
                }
                List<ValTypeResult> rangeList = new ArrayList<>();
                for (ConstantContext constCtx : constCtxList) {

                    ValTypeResult result = handleConstantCtx(constCtx);
                    rangeList.add(result);
                    System.out.println(result);
                }
                SubrangeType.RANGEDef<Integer> rangeDef = new SubrangeType.RANGEDef<Integer>(
                        Integer.valueOf(rangeList.get(0).value),
                        Integer.valueOf(rangeList.get(1).value), rangeList.get(0).type);
                SubrangeType<Integer> rangeType = new SubrangeType<Integer>(typeName, rangeDef);
                TypeRegistry.addUserType(typeName, rangeType);
                System.out.println(rangeType);
            }
        }
        if (typeIdCtx != null) {
            TerminalNode charNode = typeIdCtx.CHAR();
            TerminalNode realNode = typeIdCtx.REAL();
            TerminalNode intNode = typeIdCtx.INTEGER();
            TerminalNode strNode = typeIdCtx.STRING();
            TerminalNode boolNode = typeIdCtx.BOOLEAN();
            if (charNode != null) {
                overall = new ValTypeResult(null, charNode.getSymbol().getType(),
                        charNode.getSymbol().getText());
            }
            if (realNode != null) {
                overall = new ValTypeResult(null, realNode.getSymbol().getType(),
                        realNode.getSymbol().getText());
            }
            if (intNode != null) {
                overall = new ValTypeResult(null, intNode.getSymbol().getType(),
                        intNode.getSymbol().getText());
            }
            if (strNode != null) {
                overall = new ValTypeResult(null, strNode.getSymbol().getType(),
                        strNode.getSymbol().getText());
            }
            if (boolNode != null) {
                overall = new ValTypeResult(null, boolNode.getSymbol().getType(),
                        boolNode.getSymbol().getText());
            }
        }
        return overall;
    }

    public static void handleStructType(StructuredTypeContext structType, String typeName) {
        UnpackedStructuredTypeContext unpackCtx =
                structType.unpackedStructuredType();
        if (unpackCtx != null) {
            handleUnpacked(unpackCtx, typeName);
        }
    }

    public static void handleUnpacked(UnpackedStructuredTypeContext unpackCtx,
                                      String typeName) {
        ArrayTypeContext arrCtx = unpackCtx.arrayType();
        SetTypeContext setCtx = unpackCtx.setType();
        FileTypeContext fileCtx = unpackCtx.fileType();

        String elementTypeName = null;
        Token idTok = null;
        if (arrCtx != null) {
            ComponentTypeContext compType = arrCtx.componentType();
            Type_Context typeCtx = compType.type_();

            if (typeCtx != null) {

                PointerTypeContext pointerCtx =
                        typeCtx.pointerType();
                StructuredTypeContext structCtx =
                        typeCtx.structuredType();
                SimpleTypeContext simpleTCtx = typeCtx.simpleType();
                if (simpleTCtx != null) {
                    TypeIdentifierContext typeIdContext =
                            simpleTCtx.typeIdentifier();
                    if (typeIdContext != null) {
                        IdentifierContext idContext =
                                typeIdContext.identifier();
                        if (idContext != null) {
                            Token typeIdentifierTok =
                                    idContext.IDENT().getSymbol();
                            elementTypeName =
                                    typeIdentifierTok.getText();
                        }
                    }
                    ValTypeResult result =
                handleSimpleType(simpleTCtx, typeName);

                }
                if (pointerCtx != null) {
                    TerminalNode pointerNode = pointerCtx.POINTER();
                    Token pointerTok = pointerNode.getSymbol();

                }
            }
            TypeListContext typeList = arrCtx.typeList();
            ValTypeResult result = null;
            typeCtx = compType.type_();

            if (typeList != null) {
                List<IndexTypeContext> idxTypeList = typeList.indexType();
                for (IndexTypeContext indexType : idxTypeList) {
                    SimpleTypeContext simpleType = indexType.simpleType();
                    IdentifierContext idContext = simpleType.typeIdentifier().identifier();
                    idTok = idContext.IDENT().getSymbol();
                    if (simpleType != null) {
                        result = handleSimpleType(simpleType, typeName);
                    }
                }
            }

            TypeListContext typeListCtx = arrCtx.typeList();
            List<Token> idTokenList = new ArrayList<>();
            if (typeListCtx != null) {
                List<IndexTypeContext> idxTypeList = typeListCtx.indexType();
                for (IndexTypeContext indexType : idxTypeList) {
                    SimpleTypeContext simpleType = indexType.simpleType();
                    if (simpleType != null) {
                        TypeIdentifierContext typeIdContext =
                                simpleType.typeIdentifier();
                        if (typeIdContext != null) {
                            IdentifierContext idCtx = typeIdContext.identifier();
                            if (idCtx != null) {
                                idTok = idCtx.IDENT().getSymbol();
                                idTokenList.add(idTok);
                            }
                        }
                    }

                }
            }
            ArrayType arrayType = new ArrayType(typeName);

            ArrayType.ADefinition arrayDef = arrayType.theTypeDef()
                    .setaElementType(elementTypeName);
            for (Token idToken: idTokenList) {
                arrayDef = arrayDef.addaIndexType(idToken.getText());
            }
            TypeRegistry.addUserType(typeName,arrayType);

        }
    }

    public static void recurExpression(List<ExpressionContext> exprList,
                                       List<SimpleExpressionContext> simpleList) {
        for (ExpressionContext expressionCtx : exprList) {
            List<ExpressionContext> thisExpressions = expressionCtx.expression();
            if (thisExpressions != null) {
                for (ExpressionContext expr : thisExpressions) {
                    System.err.println("expr: " + expr.toString());
                }
                recurExpression(thisExpressions, simpleList);
            }
        }
    }

    public static void workOnVarContext(VariableContext ctx) {
        List<TerminalNode> lambda = ctx.LAMBDA();
        TerminalNode atNode = ctx.AT();
        List<TerminalNode> comma = ctx.COMMA();
        List<TerminalNode> dot = ctx.DOT();
        List<TerminalNode> lBrack = ctx.LBRACK();
        List<TerminalNode> rBrack = ctx.RBRACK();
        List<TerminalNode> lBrack2 = ctx.LBRACK2();
        List<TerminalNode> rBrack2 = ctx.RBRACK2();
        List<TerminalNode> pointer = ctx.POINTER();

        if (lambda != null) {
            for (TerminalNode terNode : lambda) {
                Integer type = terNode.getSymbol().getType();
                System.out.println("Lambda Terminal Node List Element type: " + type);
            }
        } else if (atNode != null) {
            Integer type = atNode.getSymbol().getType();
            System.out.println("At Terminal Node type: " + type);
        } else if (comma != null) {
            for (TerminalNode terNode : comma) {
                Integer type = terNode.getSymbol().getType();
                System.out.println("Comma Terminal Node List Element type: " + type);
            }
        } else if (dot != null) {
            for (TerminalNode terNode : dot) {
                Integer type = terNode.getSymbol().getType();
                System.out.println("Dot Terminal Node List Element type: " + type);
            }
        } else if (lBrack != null) {
            for (TerminalNode terNode : lBrack) {
                Integer type = terNode.getSymbol().getType();
                System.out.println("LeftBracket Terminal Node List Element type: " + type);
            }
        } else if (rBrack != null) {
            for (TerminalNode terNode : rBrack) {
                Integer type = terNode.getSymbol().getType();
                System.out.println("RightBracket Terminal Node List Element type: " + type);
            }
        } else if (lBrack2 != null) {
            for (TerminalNode terNode : lBrack2) {
                Integer type = terNode.getSymbol().getType();
                System.out.println("LeftBracket2 Terminal Node List Element type: " + type);
            }
        } else if (rBrack2 != null) {
            for (TerminalNode terNode : rBrack2) {
                Integer type = terNode.getSymbol().getType();
                System.out.println("RightBracket2 Terminal Node List Element type: " + type);
            }
        } else if (pointer != null) {
            for (TerminalNode terNode : pointer) {
                Integer type = terNode.getSymbol().getType();
                System.out.println("Pointer Terminal Node List Element type: " + type);
            }
        }
    }

    public static void traceSectionCtx(FormalParameterSectionContext sectionCtx) {
        for (Integer count = 0; count < sectionCtx.getChildCount(); count++) {
            ParseTree childObj = sectionCtx.getChild(count);
            if (childObj instanceof ParameterGroupContext) {
                ParameterGroupContext parmGroupCtx = (ParameterGroupContext) childObj;
                TypeIdentifierContext typeCtx = parmGroupCtx.typeIdentifier();
                IdentifierListContext idList = parmGroupCtx.identifierList();
                IdentifierContext typeIdCtx = typeCtx.identifier();
                if (typeCtx != null) {
                    TerminalNode theType = null;
                    if (typeCtx.BOOLEAN() != null) {
                        theType = typeCtx.BOOLEAN();
                    } else if (typeCtx.REAL() != null) {
                        theType = typeCtx.REAL();
                    } else if (typeCtx.INTEGER() != null) {
                        theType = typeCtx.INTEGER();
                    } else if (typeCtx.STRING() != null) {
                        theType = typeCtx.STRING();
                    }
                    if (theType != null) {
                        Token symbol = theType.getSymbol();
                        Integer idType = symbol.getType();
                        String idText = symbol.getText();
                        Integer lineNo = symbol.getLine();
                        System.err.println("First ID type: " + idType
                                + " / the id Text: " + idText
                                + " / the id line number: " + lineNo);
                    }
                    if (typeIdCtx != null) {
                        TerminalNode typeIdIdent = typeIdCtx.IDENT();
                        Integer theIdType = typeIdIdent.getSymbol().getType();
                        System.err.println("Type of Return? :" + theIdType);
                    }

                }

                for (IdentifierContext idCtx : idList.identifier()) {
                    Integer idType = idCtx.IDENT().getSymbol().getType();
                    String idText = idCtx.IDENT().getSymbol().getText();
                    Integer lineNo = idCtx.IDENT().getSymbol().getLine();
                    System.err.println("ID type: " + idType
                            + " idText: " + idText
                            + " id line number: " + lineNo);
                }


            }
        }
    }

    public record ValTypeResult(String value, Integer type, String name) {
    }
}
