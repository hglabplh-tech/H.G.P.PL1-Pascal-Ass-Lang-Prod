package hgp.lang.genCompile;


import clojure.lang.Symbol;
import hgp.lang.genCompile.langblocks.BeginBlock;
import hgp.lang.genCompile.langblocks.Terminals;
import hgp.lang.gparser.pl_pas_assBaseListener;
import hgp.lang.gparser.pl_pas_assListener;
import hgp.lang.gparser.pl_pas_assParser;
import hgp.lang.gparser.pl_pas_assParser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class PlPasAssLangListener extends pl_pas_assBaseListener
        implements pl_pas_assListener {

    private final CummulationThread collector;

    public PlPasAssLangListener(CummulationThread collector) {
        this.collector = collector;
    }

    @Override
    public void enterProgram(pl_pas_assParser.ProgramContext ctx) {
        ctx.programHeading().identifier().IDENT().getSymbol();
    }

    @Override
    public void exitProgram(pl_pas_assParser.ProgramContext ctx) {

    }

    @Override
    public void enterTheblocks(pl_pas_assParser.TheblocksContext ctx) {

        List<StatementContext> statements =
                ctx.block().compoundStatement().statements().statement();
        for (StatementContext stmt : statements) {
            stmt.unlabelledStatement().simpleStatement();
        }



    }

    @Override
    public void exitTheblocks(pl_pas_assParser.TheblocksContext ctx) {

    }

    @Override
    public void enterProgramHeading(pl_pas_assParser.ProgramHeadingContext ctx) {

    }

    @Override
    public void exitProgramHeading(pl_pas_assParser.ProgramHeadingContext ctx) {

    }

    @Override
    public void enterIdentifier(pl_pas_assParser.IdentifierContext ctx) {

    }

    @Override
    public void exitIdentifier(pl_pas_assParser.IdentifierContext ctx) {

    }

    @Override
    public void enterBlock(pl_pas_assParser.BlockContext ctx) {

    }

    @Override
    public void exitBlock(pl_pas_assParser.BlockContext ctx) {

    }

    @Override
    public void enterProgClassBlock(pl_pas_assParser.ProgClassBlockContext ctx) {

    }

    @Override
    public void exitProgClassBlock(pl_pas_assParser.ProgClassBlockContext ctx) {

    }

    @Override
    public void enterClassBlock(pl_pas_assParser.ClassBlockContext ctx) {

    }

    @Override
    public void exitClassBlock(pl_pas_assParser.ClassBlockContext ctx) {

    }

    @Override
    public void enterIfcBlock(pl_pas_assParser.IfcBlockContext ctx) {

    }

    @Override
    public void exitIfcBlock(pl_pas_assParser.IfcBlockContext ctx) {

    }

    @Override
    public void enterClassDeclarationPart(pl_pas_assParser.ClassDeclarationPartContext ctx) {

    }

    @Override
    public void exitClassDeclarationPart(pl_pas_assParser.ClassDeclarationPartContext ctx) {

    }

    @Override
    public void enterInterfaceDeclarationPart(pl_pas_assParser.InterfaceDeclarationPartContext ctx) {

    }

    @Override
    public void exitInterfaceDeclarationPart(pl_pas_assParser.InterfaceDeclarationPartContext ctx) {

    }

    @Override
    public void enterClassModifier(pl_pas_assParser.ClassModifierContext ctx) {

    }

    @Override
    public void exitClassModifier(pl_pas_assParser.ClassModifierContext ctx) {

    }

    @Override
    public void enterClModDecl(pl_pas_assParser.ClModDeclContext ctx) {

    }

    @Override
    public void exitClModDecl(pl_pas_assParser.ClModDeclContext ctx) {

    }

    @Override
    public void enterModifier(pl_pas_assParser.ModifierContext ctx) {

    }

    @Override
    public void exitModifier(pl_pas_assParser.ModifierContext ctx) {

    }

    @Override
    public void enterUsesUnitsPart(pl_pas_assParser.UsesUnitsPartContext ctx) {

    }

    @Override
    public void exitUsesUnitsPart(pl_pas_assParser.UsesUnitsPartContext ctx) {

    }

    @Override
    public void enterLabelDeclarationPart(pl_pas_assParser.LabelDeclarationPartContext ctx) {

    }

    @Override
    public void exitLabelDeclarationPart(pl_pas_assParser.LabelDeclarationPartContext ctx) {

    }

    @Override
    public void enterLabel(pl_pas_assParser.LabelContext ctx) {

    }

    @Override
    public void exitLabel(pl_pas_assParser.LabelContext ctx) {

    }

    @Override
    public void enterConstantDefinitionPart(pl_pas_assParser.ConstantDefinitionPartContext ctx) {

    }

    @Override
    public void exitConstantDefinitionPart(pl_pas_assParser.ConstantDefinitionPartContext ctx) {

    }

    @Override
    public void enterConstantDefinition(pl_pas_assParser.ConstantDefinitionContext ctx) {

    }

    @Override
    public void exitConstantDefinition(pl_pas_assParser.ConstantDefinitionContext ctx) {

    }

    @Override
    public void enterConstantChr(pl_pas_assParser.ConstantChrContext ctx) {

    }

    @Override
    public void exitConstantChr(pl_pas_assParser.ConstantChrContext ctx) {

    }

    @Override
    public void enterConstant(pl_pas_assParser.ConstantContext ctx) {

    }

    @Override
    public void exitConstant(pl_pas_assParser.ConstantContext ctx) {

    }

    @Override
    public void enterUnsignedNumber(pl_pas_assParser.UnsignedNumberContext ctx) {

    }

    @Override
    public void exitUnsignedNumber(pl_pas_assParser.UnsignedNumberContext ctx) {

    }

    @Override
    public void enterUnsignedInteger(pl_pas_assParser.UnsignedIntegerContext ctx) {

    }

    @Override
    public void exitUnsignedInteger(pl_pas_assParser.UnsignedIntegerContext ctx) {

    }

    @Override
    public void enterUnsignedReal(pl_pas_assParser.UnsignedRealContext ctx) {

    }

    @Override
    public void exitUnsignedReal(pl_pas_assParser.UnsignedRealContext ctx) {

    }

    @Override
    public void enterSign(pl_pas_assParser.SignContext ctx) {

    }

    @Override
    public void exitSign(pl_pas_assParser.SignContext ctx) {

    }

    @Override
    public void enterBool_(pl_pas_assParser.Bool_Context ctx) {

    }

    @Override
    public void exitBool_(pl_pas_assParser.Bool_Context ctx) {

    }

    @Override
    public void enterString(pl_pas_assParser.StringContext ctx) {

    }

    @Override
    public void exitString(pl_pas_assParser.StringContext ctx) {

    }

    @Override
    public void enterTypeDefinitionPart(pl_pas_assParser.TypeDefinitionPartContext ctx) {

    }

    @Override
    public void exitTypeDefinitionPart(pl_pas_assParser.TypeDefinitionPartContext ctx) {

    }

    @Override
    public void enterMemberType(pl_pas_assParser.MemberTypeContext ctx) {

    }

    @Override
    public void exitMemberType(pl_pas_assParser.MemberTypeContext ctx) {

    }

    @Override
    public void enterTypeDefinition(pl_pas_assParser.TypeDefinitionContext ctx) {

    }

    @Override
    public void exitTypeDefinition(pl_pas_assParser.TypeDefinitionContext ctx) {

    }

    @Override
    public void enterFunctionType(pl_pas_assParser.FunctionTypeContext ctx) {

    }

    @Override
    public void exitFunctionType(pl_pas_assParser.FunctionTypeContext ctx) {
        FormalParameterListContext listCtx = ctx.formalParameterList();
        if (listCtx != null) {
            List<FormalParameterSectionContext> formalParmList =
                    listCtx.formalParameterSection();
            for (FormalParameterSectionContext sectionCtx : formalParmList) {
                TerminalNode fun = sectionCtx.FUNCTION();
                TerminalNode var = sectionCtx.VAR();
                TerminalNode lambda = sectionCtx.LAMBDA();


                traceSectionCtx(sectionCtx);
                if (fun != null) {
                    fun.getSymbol().getType();
                }
                if (var != null) {
                    var.getSymbol().getType();

                }
                if (lambda != null) {
                    lambda.getSymbol().getType();
                }
            }
        }

    }


    @Override
    public void enterMethodType(pl_pas_assParser.MethodTypeContext ctx) {

    }

    @Override
    public void exitMethodType(pl_pas_assParser.MethodTypeContext ctx) {

    }

    @Override
    public void enterLambdaTopLevelType(pl_pas_assParser.LambdaTopLevelTypeContext ctx) {

    }

    @Override
    public void exitLambdaTopLevelType(pl_pas_assParser.LambdaTopLevelTypeContext ctx) {

    }

    @Override
    public void enterProcedureType(pl_pas_assParser.ProcedureTypeContext ctx) {

    }

    @Override
    public void exitProcedureType(pl_pas_assParser.ProcedureTypeContext ctx) {

    }

    @Override
    public void enterType_(pl_pas_assParser.Type_Context ctx) {

    }

    @Override
    public void exitType_(pl_pas_assParser.Type_Context ctx) {

    }

    @Override
    public void enterSimpleType(pl_pas_assParser.SimpleTypeContext ctx) {

    }

    @Override
    public void exitSimpleType(pl_pas_assParser.SimpleTypeContext ctx) {

    }

    @Override
    public void enterScalarType(pl_pas_assParser.ScalarTypeContext ctx) {

    }

    @Override
    public void exitScalarType(pl_pas_assParser.ScalarTypeContext ctx) {

    }

    @Override
    public void enterSubrangeType(pl_pas_assParser.SubrangeTypeContext ctx) {

    }

    @Override
    public void exitSubrangeType(pl_pas_assParser.SubrangeTypeContext ctx) {

    }

    @Override
    public void enterTypeIdentifier(pl_pas_assParser.TypeIdentifierContext ctx) {

    }

    @Override
    public void exitTypeIdentifier(pl_pas_assParser.TypeIdentifierContext ctx) {

    }

    @Override
    public void enterStructuredType(pl_pas_assParser.StructuredTypeContext ctx) {

    }

    @Override
    public void exitStructuredType(pl_pas_assParser.StructuredTypeContext ctx) {

    }

    @Override
    public void enterUnpackedStructuredType(pl_pas_assParser.UnpackedStructuredTypeContext ctx) {

    }

    @Override
    public void exitUnpackedStructuredType(pl_pas_assParser.UnpackedStructuredTypeContext ctx) {

    }

    @Override
    public void enterStringtype(pl_pas_assParser.StringtypeContext ctx) {

    }

    @Override
    public void exitStringtype(pl_pas_assParser.StringtypeContext ctx) {

    }

    @Override
    public void enterArrayType(pl_pas_assParser.ArrayTypeContext ctx) {

    }

    @Override
    public void exitArrayType(pl_pas_assParser.ArrayTypeContext ctx) {

    }

    @Override
    public void enterTypeList(pl_pas_assParser.TypeListContext ctx) {

    }

    @Override
    public void exitTypeList(pl_pas_assParser.TypeListContext ctx) {

    }

    @Override
    public void enterIndexType(pl_pas_assParser.IndexTypeContext ctx) {

    }

    @Override
    public void exitIndexType(pl_pas_assParser.IndexTypeContext ctx) {

    }

    @Override
    public void enterComponentType(pl_pas_assParser.ComponentTypeContext ctx) {

    }

    @Override
    public void exitComponentType(pl_pas_assParser.ComponentTypeContext ctx) {

    }

    @Override
    public void enterRecordType(pl_pas_assParser.RecordTypeContext ctx) {

    }

    @Override
    public void exitRecordType(pl_pas_assParser.RecordTypeContext ctx) {

    }

    @Override
    public void enterFieldList(pl_pas_assParser.FieldListContext ctx) {

    }

    @Override
    public void exitFieldList(pl_pas_assParser.FieldListContext ctx) {

    }

    @Override
    public void enterFixedPart(pl_pas_assParser.FixedPartContext ctx) {

    }

    @Override
    public void exitFixedPart(pl_pas_assParser.FixedPartContext ctx) {

    }

    @Override
    public void enterRecordSection(pl_pas_assParser.RecordSectionContext ctx) {

    }

    @Override
    public void exitRecordSection(pl_pas_assParser.RecordSectionContext ctx) {

    }

    @Override
    public void enterVariantPart(pl_pas_assParser.VariantPartContext ctx) {

    }

    @Override
    public void exitVariantPart(pl_pas_assParser.VariantPartContext ctx) {

    }

    @Override
    public void enterTag(pl_pas_assParser.TagContext ctx) {

    }

    @Override
    public void exitTag(pl_pas_assParser.TagContext ctx) {

    }

    @Override
    public void enterVariant(pl_pas_assParser.VariantContext ctx) {

    }

    @Override
    public void exitVariant(pl_pas_assParser.VariantContext ctx) {

    }

    @Override
    public void enterSetType(pl_pas_assParser.SetTypeContext ctx) {

    }

    @Override
    public void exitSetType(pl_pas_assParser.SetTypeContext ctx) {

    }

    @Override
    public void enterBaseType(pl_pas_assParser.BaseTypeContext ctx) {

    }

    @Override
    public void exitBaseType(pl_pas_assParser.BaseTypeContext ctx) {

    }

    @Override
    public void enterFileType(pl_pas_assParser.FileTypeContext ctx) {

    }

    @Override
    public void exitFileType(pl_pas_assParser.FileTypeContext ctx) {

    }

    @Override
    public void enterLambdaType(pl_pas_assParser.LambdaTypeContext ctx) {

    }

    @Override
    public void exitLambdaType(pl_pas_assParser.LambdaTypeContext ctx) {

    }

    @Override
    public void enterPointerType(pl_pas_assParser.PointerTypeContext ctx) {

    }

    @Override
    public void exitPointerType(pl_pas_assParser.PointerTypeContext ctx) {

    }

    @Override
    public void enterVariableDeclarationPart(pl_pas_assParser.VariableDeclarationPartContext ctx) {

    }

    @Override
    public void exitVariableDeclarationPart(pl_pas_assParser.VariableDeclarationPartContext ctx) {

    }

    @Override
    public void enterMemberVariableDeclarationPart(pl_pas_assParser.MemberVariableDeclarationPartContext ctx) {

    }

    @Override
    public void exitMemberVariableDeclarationPart(pl_pas_assParser.MemberVariableDeclarationPartContext ctx) {

    }

    @Override
    public void enterVariableDeclaration(pl_pas_assParser.VariableDeclarationContext ctx) {

    }

    @Override
    public void exitVariableDeclaration(pl_pas_assParser.VariableDeclarationContext ctx) {
        TerminalNode colon = ctx.COLON();
        if (colon != null) {
            Token colonTok = colon.getSymbol();
            System.out.println("colon Token: " + colonTok.getType() + " " +
            colonTok.getLine() + " " +
            colonTok.getText() + "\n");
        }
        IdentifierListContext idListCtx = ctx.identifierList();
        if (idListCtx != null) {
            List<IdentifierContext> idList = idListCtx.identifier();
            for (IdentifierContext id :idList) {
                if (id.IDENT() != null) {
                    Token idTok = id.IDENT().getSymbol();
                    if (idTok != null) {
                        System.out.println("ID Token: " + idTok.getType() + " " +
                                idTok.getLine() + " " +
                                idTok.getText() + "\n");
                    }
                }
            }
        }
        Type_Context typeCtx = ctx.type_();
        if (typeCtx != null) {
            PointerTypeContext pTypeCtx = typeCtx.pointerType();
            if (pTypeCtx != null) {
                TypeIdentifierContext typeIdCtx = pTypeCtx.typeIdentifier();
                TerminalNode real = typeIdCtx.REAL();
                TerminalNode string = typeIdCtx.STRING();
                TerminalNode bool = typeIdCtx.BOOLEAN();
                TerminalNode intVal = typeIdCtx.INTEGER();
                if (real != null) {
                        Token realTok = real.getSymbol();
                    System.out.println("Real Token: " + realTok.getType() + " "
                            + realTok.getLine() + " " + realTok.getText() + "\n");
                }
                if (string != null) {
                    Token strTok = string.getSymbol();
                    System.out.println("String Token: " + strTok.getType() + " "
                            + strTok.getLine() + " " + strTok.getText() + "\n");
                }
                if (bool != null) {
                    Token boolTok = string.getSymbol();
                    System.out.println("Integer Token: " + boolTok.getType() + " "
                            + boolTok.getLine() + " " + boolTok.getText() + "\n");

                }

                if (intVal != null) {
                    Token intTok = string.getSymbol();
                    System.out.println("Integer Token: " + intTok.getType() + " "
                            + intTok.getLine() + " " + intTok.getText() + "\n");
                }

            }
        }
    }

    @Override
    public void enterProcedureAndFunctionDeclarationPart(pl_pas_assParser.ProcedureAndFunctionDeclarationPartContext ctx) {

    }

    @Override
    public void exitProcedureAndFunctionDeclarationPart(pl_pas_assParser.ProcedureAndFunctionDeclarationPartContext ctx) {

    }

    @Override
    public void enterProcedureOrFunctionDeclaration(pl_pas_assParser.ProcedureOrFunctionDeclarationContext ctx) {

    }

    @Override
    public void exitProcedureOrFunctionDeclaration(pl_pas_assParser.ProcedureOrFunctionDeclarationContext ctx) {

    }

    @Override
    public void enterProcedureDeclaration(pl_pas_assParser.ProcedureDeclarationContext ctx) {

    }

    @Override
    public void exitProcedureDeclaration(pl_pas_assParser.ProcedureDeclarationContext ctx) {

    }

    @Override
    public void enterFormalParameterList(FormalParameterListContext ctx) {

    }

    @Override
    public void exitFormalParameterList(FormalParameterListContext ctx) {

    }

    @Override
    public void enterFormalParameterSection(FormalParameterSectionContext ctx) {

    }

    @Override
    public void exitFormalParameterSection(FormalParameterSectionContext ctx) {

    }

    @Override
    public void enterParameterGroup(pl_pas_assParser.ParameterGroupContext ctx) {

    }

    @Override
    public void exitParameterGroup(pl_pas_assParser.ParameterGroupContext ctx) {

    }

    @Override
    public void enterIdentifierList(pl_pas_assParser.IdentifierListContext ctx) {

    }

    @Override
    public void exitIdentifierList(pl_pas_assParser.IdentifierListContext ctx) {

    }

    @Override
    public void enterConstList(pl_pas_assParser.ConstListContext ctx) {

    }

    @Override
    public void exitConstList(pl_pas_assParser.ConstListContext ctx) {

    }

    @Override
    public void enterFunctionDeclaration(pl_pas_assParser.FunctionDeclarationContext ctx) {
        String funName = ctx.FUNCTION().getSymbol().getText();
        Integer type = ctx.FUNCTION().getSymbol().getType();
        Integer lineNo = ctx.FUNCTION().getSymbol().getLine();
        FormalParameterListContext formalParms =
                ctx.formalParameterList();
        List<FormalParameterSectionContext> formalParmsSection =
                formalParms.formalParameterSection();
        for (FormalParameterSectionContext sectionContext : formalParmsSection) {
            TerminalNode funNode = sectionContext.FUNCTION();
            if (funNode != null) {
                Integer parmLineNo = funNode.getSymbol().getLine();
                Integer parmType = funNode.getSymbol().getType();
                String parmName = funNode.getSymbol().getText();
            }

        }
        List<StatementContext> statements =
                ctx.block().compoundStatement()
                        .statements().statement();
        for (StatementContext stmtContext : statements) {
            stmtContext.unlabelledStatement().structuredStatement();
        }
    }

    @Override
    public void exitFunctionDeclaration(pl_pas_assParser.FunctionDeclarationContext ctx) {
        FormalParameterListContext listCtx = ctx.formalParameterList();
        if (listCtx != null) {
            List<FormalParameterSectionContext> formalParmList =
                    listCtx.formalParameterSection();
            for (FormalParameterSectionContext sectionCtx : formalParmList) {
                TerminalNode fun = sectionCtx.FUNCTION();
                TerminalNode assFun = sectionCtx.ASSFUN();
                TerminalNode procedure = sectionCtx.PROCEDURE();
                TerminalNode var = sectionCtx.VAR();
                TerminalNode lambda = sectionCtx.LAMBDA();
                traceSectionCtx(sectionCtx);
                if (fun != null) {
                    fun.getSymbol().getType();
                }
                if (var != null) {
                    var.getSymbol().getType();
                }
                if (lambda != null) {
                    lambda.getSymbol().getType();
                }
                if (assFun != null) {
                    assFun.getSymbol().getType();
                }
                if (procedure != null) {
                    procedure.getSymbol().getType();
                }
            }
        }


    }

    @Override
    public void enterAssblock(pl_pas_assParser.AssblockContext ctx) {

    }

    @Override
    public void exitAssblock(pl_pas_assParser.AssblockContext ctx) {

    }

    @Override
    public void enterAssFunDeclaration(pl_pas_assParser.AssFunDeclarationContext ctx) {

    }

    @Override
    public void exitAssFunDeclaration(pl_pas_assParser.AssFunDeclarationContext ctx) {

    }

    @Override
    public void enterLambdaDeclaration(pl_pas_assParser.LambdaDeclarationContext ctx) {

    }

    @Override
    public void exitLambdaDeclaration(pl_pas_assParser.LambdaDeclarationContext ctx) {

    }

    @Override
    public void enterMethodDeclaration(pl_pas_assParser.MethodDeclarationContext ctx) {

    }

    @Override
    public void exitMethodDeclaration(pl_pas_assParser.MethodDeclarationContext ctx) {

    }

    @Override
    public void enterResultType(pl_pas_assParser.ResultTypeContext ctx) {
        TypeIdentifierContext resultTypeCtx = ctx.typeIdentifier();
        if (resultTypeCtx != null) {
            IdentifierContext idCtx = resultTypeCtx.identifier();
            if (idCtx != null) {
                Token idSymbol = idCtx.IDENT().getSymbol();
            }
        }
    }

    @Override
    public void exitResultType(pl_pas_assParser.ResultTypeContext ctx) {

    }

    @Override
    public void enterStatement(StatementContext ctx) {

    }

    @Override
    public void exitStatement(StatementContext ctx) {

    }

    @Override
    public void enterUnlabelledStatement(pl_pas_assParser.UnlabelledStatementContext ctx) {

    }

    @Override
    public void exitUnlabelledStatement(pl_pas_assParser.UnlabelledStatementContext ctx) {

    }

    @Override
    public void enterSimpleStatement(pl_pas_assParser.SimpleStatementContext ctx) {

    }

    @Override
    public void exitSimpleStatement(pl_pas_assParser.SimpleStatementContext ctx) {

    }

    @Override
    public void enterAssignmentStatement(pl_pas_assParser.AssignmentStatementContext ctx) {
            ctx.ASSIGN().getSymbol().getText();
        ctx.ASSIGN().getSymbol().getType();
        ctx.ASSIGN().getSymbol().getLine();
        ExpressionContext expr = ctx.expression();
        if (expr != null) {
            List<SimpleExpressionContext> simpleList = expr.simpleExpression();
            if (simpleList != null) {
                for (SimpleExpressionContext simpleCtx : simpleList) {
                    AdditiveoperatorContext add = simpleCtx.additiveoperator();
                    simpleCtx.simpleExpression();
                    if (simpleList != null) {
                        for (SimpleExpressionContext simpleCtx2 : simpleList) {
                            AdditiveoperatorContext add2 = simpleCtx.additiveoperator();
                            simpleCtx2.simpleExpression();
                        }
                }
            }
        }
            List<ExpressionContext> exprList = expr.expression();
            if (exprList != null) {
                for (ExpressionContext expressionCtx : exprList) {
                    expressionCtx.simpleExpression();
                    if (simpleList != null) {
                        for (SimpleExpressionContext simpleCtx2 : simpleList) {
                            List<ExpressionContext> expr2 = expressionCtx.expression();
                            expressionCtx.simpleExpression();
                        }
                    }
            }




    }}}

    @Override
    public void exitAssignmentStatement(pl_pas_assParser.AssignmentStatementContext ctx) {
        ctx.ASSIGN().getSymbol().getText();
        ctx.ASSIGN().getSymbol().getType();
        ctx.ASSIGN().getSymbol().getLine();
    }

    @Override
    public void enterVariable(pl_pas_assParser.VariableContext ctx) {
        workOnVarContext(ctx);
    }

    private static void workOnVarContext(VariableContext ctx) {
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
        }
        else if (rBrack != null) {
            for (TerminalNode terNode : rBrack) {
                Integer type = terNode.getSymbol().getType();
                System.out.println("RightBracket Terminal Node List Element type: " + type);
            }
        }
        else if (lBrack2 != null) {
            for (TerminalNode terNode : lBrack2) {
                Integer type = terNode.getSymbol().getType();
                System.out.println("LeftBracket2 Terminal Node List Element type: " + type);
            }
        }
        else if (rBrack2 != null) {
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

    @Override
    public void exitVariable(pl_pas_assParser.VariableContext ctx) {
        workOnVarContext(ctx);
    }

    @Override
    public void enterExpression(pl_pas_assParser.ExpressionContext ctx) {

    }

    @Override
    public void exitExpression(pl_pas_assParser.ExpressionContext ctx) {

    }

    @Override
    public void enterRelationaloperator(pl_pas_assParser.RelationaloperatorContext ctx) {

    }

    @Override
    public void exitRelationaloperator(pl_pas_assParser.RelationaloperatorContext ctx) {

    }

    @Override
    public void enterSimpleExpression(SimpleExpressionContext ctx) {

    }

    @Override
    public void exitSimpleExpression(SimpleExpressionContext ctx) {

    }

    @Override
    public void enterAdditiveoperator(pl_pas_assParser.AdditiveoperatorContext ctx) {

    }

    @Override
    public void exitAdditiveoperator(pl_pas_assParser.AdditiveoperatorContext ctx) {

    }

    @Override
    public void enterTerm(pl_pas_assParser.TermContext ctx) {

    }

    @Override
    public void exitTerm(pl_pas_assParser.TermContext ctx) {

    }

    @Override
    public void enterMultiplicativeoperator(pl_pas_assParser.MultiplicativeoperatorContext ctx) {

    }

    @Override
    public void exitMultiplicativeoperator(pl_pas_assParser.MultiplicativeoperatorContext ctx) {

    }

    @Override
    public void enterSignedFactor(pl_pas_assParser.SignedFactorContext ctx) {

    }

    @Override
    public void exitSignedFactor(pl_pas_assParser.SignedFactorContext ctx) {

    }

    @Override
    public void enterFactor(pl_pas_assParser.FactorContext ctx) {

    }

    @Override
    public void exitFactor(pl_pas_assParser.FactorContext ctx) {

    }

    @Override
    public void enterUnsignedConstant(pl_pas_assParser.UnsignedConstantContext ctx) {

    }

    @Override
    public void exitUnsignedConstant(pl_pas_assParser.UnsignedConstantContext ctx) {

    }

    @Override
    public void enterFunctionDesignator(pl_pas_assParser.FunctionDesignatorContext ctx) {
        List<ActualParameterContext> actParmList =
                ctx.parameterList().actualParameter();
        ExpressionContext exprCtx = ctx.parameterList().actualParameter(0).expression();
        for (ActualParameterContext parmCtx : actParmList) {
            List<SimpleExpressionContext> simpleExprList =
                    parmCtx.expression().simpleExpression();


        }
    }

    @Override
    public void exitFunctionDesignator(pl_pas_assParser.FunctionDesignatorContext ctx) {

    }

    @Override
    public void enterParameterList(pl_pas_assParser.ParameterListContext ctx) {

    }

    @Override
    public void exitParameterList(pl_pas_assParser.ParameterListContext ctx) {

    }

    @Override
    public void enterSet_(pl_pas_assParser.Set_Context ctx) {

    }

    @Override
    public void exitSet_(pl_pas_assParser.Set_Context ctx) {

    }

    @Override
    public void enterElementList(pl_pas_assParser.ElementListContext ctx) {

    }

    @Override
    public void exitElementList(pl_pas_assParser.ElementListContext ctx) {

    }

    @Override
    public void enterElement(pl_pas_assParser.ElementContext ctx) {

    }

    @Override
    public void exitElement(pl_pas_assParser.ElementContext ctx) {

    }

    @Override
    public void enterProcedureStatement(pl_pas_assParser.ProcedureStatementContext ctx) {

    }

    @Override
    public void exitProcedureStatement(pl_pas_assParser.ProcedureStatementContext ctx) {

    }

    @Override
    public void enterActualParameter(ActualParameterContext ctx) {

    }

    @Override
    public void exitActualParameter(ActualParameterContext ctx) {

    }

    @Override
    public void enterParameterwidth(pl_pas_assParser.ParameterwidthContext ctx) {

    }

    @Override
    public void exitParameterwidth(pl_pas_assParser.ParameterwidthContext ctx) {

    }

    @Override
    public void enterGotoStatement(pl_pas_assParser.GotoStatementContext ctx) {

    }

    @Override
    public void exitGotoStatement(pl_pas_assParser.GotoStatementContext ctx) {

    }

    @Override
    public void enterEmptyStatement_(pl_pas_assParser.EmptyStatement_Context ctx) {

    }

    @Override
    public void exitEmptyStatement_(pl_pas_assParser.EmptyStatement_Context ctx) {

    }

    @Override
    public void enterEmpty_(pl_pas_assParser.Empty_Context ctx) {

    }

    @Override
    public void exitEmpty_(pl_pas_assParser.Empty_Context ctx) {

    }

    @Override
    public void enterStructuredStatement(pl_pas_assParser.StructuredStatementContext ctx) {

    }

    @Override
    public void exitStructuredStatement(pl_pas_assParser.StructuredStatementContext ctx) {

    }

    @Override
    public void enterCompoundStatement(pl_pas_assParser.CompoundStatementContext ctx) {

    }

    @Override
    public void exitCompoundStatement(pl_pas_assParser.CompoundStatementContext ctx) {

    }

    @Override
    public void enterStatements(pl_pas_assParser.StatementsContext ctx) {

    }

    @Override
    public void exitStatements(pl_pas_assParser.StatementsContext ctx) {

    }

    @Override
    public void enterConditionalStatement(pl_pas_assParser.ConditionalStatementContext ctx) {

    }

    @Override
    public void exitConditionalStatement(pl_pas_assParser.ConditionalStatementContext ctx) {

    }

    @Override
    public void enterIfStatement(pl_pas_assParser.IfStatementContext ctx) {

    }

    @Override
    public void exitIfStatement(pl_pas_assParser.IfStatementContext ctx) {

    }

    @Override
    public void enterCaseStatement(pl_pas_assParser.CaseStatementContext ctx) {

    }

    @Override
    public void exitCaseStatement(pl_pas_assParser.CaseStatementContext ctx) {

    }

    @Override
    public void enterCaseListElement(pl_pas_assParser.CaseListElementContext ctx) {

    }

    @Override
    public void exitCaseListElement(pl_pas_assParser.CaseListElementContext ctx) {

    }

    @Override
    public void enterRepetetiveStatement(pl_pas_assParser.RepetetiveStatementContext ctx) {

    }

    @Override
    public void exitRepetetiveStatement(pl_pas_assParser.RepetetiveStatementContext ctx) {

    }

    @Override
    public void enterWhileStatement(pl_pas_assParser.WhileStatementContext ctx) {

    }

    @Override
    public void exitWhileStatement(pl_pas_assParser.WhileStatementContext ctx) {

    }

    @Override
    public void enterRepeatStatement(pl_pas_assParser.RepeatStatementContext ctx) {

    }

    @Override
    public void exitRepeatStatement(pl_pas_assParser.RepeatStatementContext ctx) {

    }

    @Override
    public void enterForStatement(pl_pas_assParser.ForStatementContext ctx) {

    }

    @Override
    public void exitForStatement(pl_pas_assParser.ForStatementContext ctx) {


    }

    @Override
    public void enterForList(pl_pas_assParser.ForListContext ctx) {
        pl_pas_assParser.ExpressionContext expCFinal = ctx.finalValue().expression();
        pl_pas_assParser.ExpressionContext expCInit = ctx.initialValue().expression();
        expCInit.simpleExpression().get(0);
    }

    @Override
    public void exitForList(pl_pas_assParser.ForListContext ctx) {

    }

    @Override
    public void enterInitialValue(pl_pas_assParser.InitialValueContext ctx) {

    }

    @Override
    public void exitInitialValue(pl_pas_assParser.InitialValueContext ctx) {

    }

    @Override
    public void enterFinalValue(pl_pas_assParser.FinalValueContext ctx) {

    }

    @Override
    public void exitFinalValue(pl_pas_assParser.FinalValueContext ctx) {

    }

    @Override
    public void enterWithStatement(pl_pas_assParser.WithStatementContext ctx) {

    }

    @Override
    public void exitWithStatement(pl_pas_assParser.WithStatementContext ctx) {

    }

    @Override
    public void enterRecordVariableList(pl_pas_assParser.RecordVariableListContext ctx) {

    }

    @Override
    public void exitRecordVariableList(pl_pas_assParser.RecordVariableListContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

        Token tok = terminalNode.getSymbol();
        Terminals terminal = new Terminals(tok, tok.getText(), tok.getType(), tok.getLine()
        );
        Symbol sym = Symbol.create("terminal");
        collector.addBlockClass(sym, terminal);
    }


    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    private static void traceSectionCtx(FormalParameterSectionContext sectionCtx) {
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
                    }  else if (typeCtx.INTEGER() != null) {
                        theType = typeCtx.INTEGER();
                    }  else if (typeCtx.STRING() != null) {
                        theType = typeCtx.STRING();
                    }
                    if (theType != null) {
                        Token symbol = theType.getSymbol();
                        Integer idType = symbol.getType();
                        String idText =  symbol.getText();
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
}
