package hgp.lang.genCompile;


import genbytecj.generator.model.metamodel.expressions.constants.Constant;
import hgp.lang.gparser.pl_pas_assBaseVisitor;
import hgp.lang.gparser.pl_pas_assParser;
import hgp.lang.gparser.pl_pas_assParser.*;
import hgp.lang.gparser.pl_pas_assVisitor;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class PlPasAssLangVisitor<T> extends pl_pas_assBaseVisitor
        implements pl_pas_assVisitor {
    @Override
    public T visitProgram(pl_pas_assParser.ProgramContext ctx) {
        ctx.programHeading().identifier().IDENT().getSymbol();
        return null;
    }

    @Override
    public T visitTheblocks(pl_pas_assParser.TheblocksContext ctx) {
        List<pl_pas_assParser.StatementContext> statements =
                ctx.block().compoundStatement().statements().statement();
        for (pl_pas_assParser.StatementContext stmt : statements) {
            stmt.unlabelledStatement().simpleStatement();
        }

        visitChildren((RuleNode) ctx.getChild(0));
        return null;
    }

    @Override
    public T visitProgramHeading(pl_pas_assParser.ProgramHeadingContext ctx) {
        ctx.identifier().IDENT().getSymbol();
    return null;
    }

    @Override
    public T visitIdentifier(IdentifierContext ctx) {
        return null;
    }

    @Override
    public T visitBlock(pl_pas_assParser.BlockContext ctx) {
        List<pl_pas_assParser.StatementContext> statements =
                ctx.compoundStatement().statements().statement();
        for (pl_pas_assParser.StatementContext stmt : statements) {
            ctx.accept(this);
            stmt.unlabelledStatement().simpleStatement();
        }
        return null;
    }

    @Override
    public T visitProgClassBlock(pl_pas_assParser.ProgClassBlockContext ctx) {
        return null;
    }

    @Override
    public T visitClassBlock(pl_pas_assParser.ClassBlockContext ctx) {
        return null;
    }

    @Override
    public T visitIfcBlock(pl_pas_assParser.IfcBlockContext ctx) {
        return null;
    }

    @Override
    public T visitClassDeclarationPart(pl_pas_assParser.ClassDeclarationPartContext ctx) {
        return null;
    }

    @Override
    public T visitInterfaceDeclarationPart(pl_pas_assParser.InterfaceDeclarationPartContext ctx) {
        return null;
    }

    @Override
    public T visitClassModifier(pl_pas_assParser.ClassModifierContext ctx) {
        return null;
    }

    @Override
    public T visitClModDecl(pl_pas_assParser.ClModDeclContext ctx) {
        return null;
    }

    @Override
    public T visitModifier(pl_pas_assParser.ModifierContext ctx) {
        return null;
    }

    @Override
    public T visitUsesUnitsPart(pl_pas_assParser.UsesUnitsPartContext ctx) {
        TerminalNode uses = ctx.USES();
        if (uses != null) {
            return (T)genPVCFromToken(uses.getSymbol());
        }
        return null;
    }

    public PrivateVisitContext genPVCFromToken(Token theToken) {
        //type
        Integer type = theToken.getType();
        // name
        String text = theToken.getText();
        //location
        Integer sourceLin = theToken.getLine();
        Integer sourceCol = theToken.getCharPositionInLine();
        return new PrivateVisitContext(theToken, type, text, sourceLin, sourceCol);
    }

    @Override
    public T visitLabelDeclarationPart(pl_pas_assParser.LabelDeclarationPartContext ctx) {
        TerminalNode label = ctx.LABEL();
        PrivateVisitContext pVCTX = null;
        if (label != null) {
            pVCTX = genPVCFromToken(label.getSymbol());
        }
        return (T)pVCTX;
    }

    @Override
    public T visitLabel(LabelContext ctx) {
        UnsignedIntegerContext intCtx = ctx.unsignedInteger();
        PrivateVisitContext pVCTX = null;
        if (intCtx != null) {
            TerminalNode theNode = intCtx.NUM_INT();
            if (theNode != null) {
                Token nodeToken = theNode.getSymbol();
                pVCTX = genPVCFromToken(nodeToken);
            }
        }
        return (T)pVCTX;
    }

    @Override
    public T visitConstantDefinitionPart(pl_pas_assParser.ConstantDefinitionPartContext ctx) {
        PrivateVisitContext pVCTX = null; // look for tat EQUAL element
        TerminalNode theNode = ctx.CONST();
        if (theNode != null) {
            if (theNode != null) {
                Token nodeToken = theNode.getSymbol();
                pVCTX = genPVCFromToken(nodeToken);
            }
            if (pVCTX != null) {
                List <ConstantDefinitionContext> cDContext =
                        ctx.constantDefinition();
                for (ConstantDefinitionContext context : cDContext) {
                    if (context.constant() != null) {
                        ConstantContext constContext =
                                context.constant();
                        IdentifierContext idContext =
                                constContext.identifier();
                        if (idContext != null) {
                            TerminalNode idNode = idContext.IDENT();
                            pVCTX.getBuilder().addToTerminalNodes(idNode);
                        }
                        ConstantChrContext chrCtx = constContext.constantChr();
                        if (chrCtx != null) {
                            TerminalNode chrNode = chrCtx.CHR();
                            UnsignedIntegerContext uintContext =
                                    chrCtx.unsignedInteger();
                            TerminalNode uintTermNode = uintContext.NUM_INT();
                            pVCTX.getBuilder().addToTerminalNodes(uintTermNode);
                        }
                    }
                }
            }
         }

        return (T)pVCTX;
    }

    @Override
    public T visitConstantDefinition(ConstantDefinitionContext ctx) {

        return null;
    }

    @Override
    public T visitConstantChr(pl_pas_assParser.ConstantChrContext ctx) {
        return (T)genPVCFromToken(ctx.CHR().getSymbol());
    }

    @Override
    public T visitConstant(ConstantContext ctx) {
        ConstantChrContext chrCtx = ctx.constantChr();
        if (chrCtx != null) {
            return (T)genPVCFromToken(chrCtx.CHR().getSymbol());
        }
        return null;
    }

    @Override
    public T visitUnsignedNumber(pl_pas_assParser.UnsignedNumberContext ctx) {
        return (T)genPVCFromToken(ctx.unsignedInteger().NUM_INT().getSymbol());

    }

    @Override
    public T visitUnsignedInteger(UnsignedIntegerContext ctx) {
        return (T)genPVCFromToken(ctx.NUM_INT().getSymbol());
    }

    @Override
    public T visitUnsignedReal(pl_pas_assParser.UnsignedRealContext ctx) {
        return (T)genPVCFromToken(ctx.NUM_REAL().getSymbol());
    }

    @Override
    public T visitSign(pl_pas_assParser.SignContext ctx) {
        if (ctx.PLUS() != null) {
            return (T)genPVCFromToken(ctx.PLUS().getSymbol());
        } else if (ctx.MINUS() != null) {
            return (T)genPVCFromToken(ctx.MINUS().getSymbol());
        }
       return null;
    }

    @Override
    public T visitBool_(pl_pas_assParser.Bool_Context ctx) {
        if (ctx.TRUE() != null) {
            return (T)genPVCFromToken(ctx.TRUE().getSymbol());
        } else if (ctx.FALSE() != null) {
            return (T)genPVCFromToken(ctx.FALSE().getSymbol());
        }
        return null;
    }

    @Override
    public T visitString(pl_pas_assParser.StringContext ctx) {
        return null;
    }

    @Override
    public T visitTypeDefinitionPart(pl_pas_assParser.TypeDefinitionPartContext ctx) {
        List<TypeDefinitionContext> ctxTypeDef = ctx.typeDefinition();
        if (ctxTypeDef != null ) {
            for (TypeDefinitionContext  defCtx : ctxTypeDef) {
                PointerTypeContext ptrCtx = defCtx.type_().pointerType();
                SimpleTypeContext simpleCtx = defCtx.type_().simpleType();
                StructuredTypeContext structType = defCtx.type_().structuredType();

            }

        }
        return null;
    }

    @Override
    public T visitMemberType(pl_pas_assParser.MemberTypeContext ctx) {
        return null;
    }

    @Override
    public T visitTypeDefinition(pl_pas_assParser.TypeDefinitionContext ctx) {
        PointerTypeContext ptrCtx = ctx.type_().pointerType();
        SimpleTypeContext simpleCtx = ctx.type_().simpleType();
        StructuredTypeContext structType = ctx.type_().structuredType();

        return null;
    }

    @Override
    public T visitFunctionType(pl_pas_assParser.FunctionTypeContext ctx) {
        Token funToken = ctx.FUNCTION().getSymbol();
        List<FormalParameterSectionContext> formalList =
                ctx.formalParameterList().formalParameterSection();
        for (FormalParameterSectionContext sectCtx: formalList) {
            TerminalNode funNode = sectCtx.FUNCTION();
            TerminalNode assNode = sectCtx.ASSFUN();
            TerminalNode varNode = sectCtx.VAR();
            TerminalNode lambdaNode = sectCtx.LAMBDA();
            TerminalNode procNode  = sectCtx.PROCEDURE();

        }
        return null;
    }

    @Override
    public T visitMethodType(pl_pas_assParser.MethodTypeContext ctx) {
        return null;
    }

    @Override
    public T visitLambdaTopLevelType(pl_pas_assParser.LambdaTopLevelTypeContext ctx) {
        return null;
    }

    @Override
    public T visitProcedureType(pl_pas_assParser.ProcedureTypeContext ctx) {
        return null;
    }

    @Override
    public T visitType_(pl_pas_assParser.Type_Context ctx) {
        return null;
    }

    @Override
    public T visitSimpleType(pl_pas_assParser.SimpleTypeContext ctx) {
        return null;
    }

    @Override
    public T visitScalarType(pl_pas_assParser.ScalarTypeContext ctx) {
        return null;
    }

    @Override
    public T visitSubrangeType(pl_pas_assParser.SubrangeTypeContext ctx) {
        return null;
    }

    @Override
    public T visitTypeIdentifier(pl_pas_assParser.TypeIdentifierContext ctx) {
        return null;
    }

    @Override
    public T visitStructuredType(pl_pas_assParser.StructuredTypeContext ctx) {
        return null;
    }

    @Override
    public T visitUnpackedStructuredType(pl_pas_assParser.UnpackedStructuredTypeContext ctx) {
        return null;
    }

    @Override
    public T visitStringtype(pl_pas_assParser.StringtypeContext ctx) {
        return null;
    }

    @Override
    public T visitArrayType(pl_pas_assParser.ArrayTypeContext ctx) {
        return null;
    }

    @Override
    public T visitTypeList(pl_pas_assParser.TypeListContext ctx) {
        return null;
    }

    @Override
    public T visitIndexType(pl_pas_assParser.IndexTypeContext ctx) {
        return null;
    }

    @Override
    public T visitComponentType(pl_pas_assParser.ComponentTypeContext ctx) {
        return null;
    }

    @Override
    public T visitRecordType(pl_pas_assParser.RecordTypeContext ctx) {
        return null;
    }

    @Override
    public T visitFieldList(pl_pas_assParser.FieldListContext ctx) {
        return null;
    }

    @Override
    public T visitFixedPart(pl_pas_assParser.FixedPartContext ctx) {
        return null;
    }

    @Override
    public T visitRecordSection(pl_pas_assParser.RecordSectionContext ctx) {
        return null;
    }

    @Override
    public T visitVariantPart(pl_pas_assParser.VariantPartContext ctx) {
        return null;
    }

    @Override
    public T visitTag(pl_pas_assParser.TagContext ctx) {
        return null;
    }

    @Override
    public T visitVariant(pl_pas_assParser.VariantContext ctx) {
        return null;
    }

    @Override
    public T visitSetType(pl_pas_assParser.SetTypeContext ctx) {
        return null;
    }

    @Override
    public T visitBaseType(pl_pas_assParser.BaseTypeContext ctx) {
        return null;
    }

    @Override
    public T visitFileType(pl_pas_assParser.FileTypeContext ctx) {
        return null;
    }

    @Override
    public T visitLambdaType(pl_pas_assParser.LambdaTypeContext ctx) {
        return null;
    }

    @Override
    public T visitPointerType(pl_pas_assParser.PointerTypeContext ctx) {
        return null;
    }

    @Override
    public T visitVariableDeclarationPart(pl_pas_assParser.VariableDeclarationPartContext ctx) {
        return null;
    }

    @Override
    public T visitMemberVariableDeclarationPart(pl_pas_assParser.MemberVariableDeclarationPartContext ctx) {
        return null;
    }

    @Override
    public T visitVariableDeclaration(pl_pas_assParser.VariableDeclarationContext ctx) {
        return null;
    }

    @Override
    public T visitProcedureAndFunctionDeclarationPart(pl_pas_assParser.ProcedureAndFunctionDeclarationPartContext ctx) {
        return null;
    }

    @Override
    public T visitProcedureOrFunctionDeclaration(pl_pas_assParser.ProcedureOrFunctionDeclarationContext ctx) {
        return null;
    }

    @Override
    public T visitProcedureDeclaration(pl_pas_assParser.ProcedureDeclarationContext ctx) {
        return null;
    }

    @Override
    public T visitFormalParameterList(pl_pas_assParser.FormalParameterListContext ctx) {
        return null;
    }

    @Override
    public T visitFormalParameterSection(pl_pas_assParser.FormalParameterSectionContext ctx) {
        return null;
    }

    @Override
    public T visitParameterGroup(pl_pas_assParser.ParameterGroupContext ctx) {
        return null;
    }

    @Override
    public T visitIdentifierList(pl_pas_assParser.IdentifierListContext ctx) {
        return null;
    }

    @Override
    public T visitConstList(pl_pas_assParser.ConstListContext ctx) {
        return null;
    }

    @Override
    public T visitFunctionDeclaration(pl_pas_assParser.FunctionDeclarationContext ctx) {
        return null;
    }

    @Override
    public T visitAssblock(pl_pas_assParser.AssblockContext ctx) {
        return null;
    }

    @Override
    public T visitAssFunDeclaration(pl_pas_assParser.AssFunDeclarationContext ctx) {
        return null;
    }

    @Override
    public T visitLambdaDeclaration(pl_pas_assParser.LambdaDeclarationContext ctx) {
        return null;
    }

    @Override
    public T visitMethodDeclaration(pl_pas_assParser.MethodDeclarationContext ctx) {
        return null;
    }

    @Override
    public T visitResultType(pl_pas_assParser.ResultTypeContext ctx) {
        return null;
    }

    @Override
    public T visitStatement(pl_pas_assParser.StatementContext ctx) {
        return null;
    }

    @Override
    public T visitUnlabelledStatement(pl_pas_assParser.UnlabelledStatementContext ctx) {
        return null;
    }

    @Override
    public T visitSimpleStatement(pl_pas_assParser.SimpleStatementContext ctx) {
        return null;
    }

    @Override
    public T visitAssignmentStatement(pl_pas_assParser.AssignmentStatementContext ctx) {
        return null;
    }

    @Override
    public T visitVariable(pl_pas_assParser.VariableContext ctx) {
        return null;
    }

    @Override
    public T visitExpression(pl_pas_assParser.ExpressionContext ctx) {
        return null;
    }

    @Override
    public T visitRelationaloperator(pl_pas_assParser.RelationaloperatorContext ctx) {
        return null;
    }

    @Override
    public T visitSimpleExpression(pl_pas_assParser.SimpleExpressionContext ctx) {
        return null;
    }

    @Override
    public T visitAdditiveoperator(pl_pas_assParser.AdditiveoperatorContext ctx) {
        return null;
    }

    @Override
    public T visitTerm(pl_pas_assParser.TermContext ctx) {
        return null;
    }

    @Override
    public T visitMultiplicativeoperator(pl_pas_assParser.MultiplicativeoperatorContext ctx) {
        return null;
    }

    @Override
    public T visitSignedFactor(pl_pas_assParser.SignedFactorContext ctx) {
        return null;
    }

    @Override
    public T visitFactor(pl_pas_assParser.FactorContext ctx) {
        return null;
    }

    @Override
    public T visitUnsignedConstant(pl_pas_assParser.UnsignedConstantContext ctx) {
        return null;
    }

    @Override
    public T visitFunctionDesignator(pl_pas_assParser.FunctionDesignatorContext ctx) {
        return null;
    }

    @Override
    public T visitParameterList(pl_pas_assParser.ParameterListContext ctx) {
        return null;
    }

    @Override
    public T visitSet_(pl_pas_assParser.Set_Context ctx) {
        return null;
    }

    @Override
    public T visitElementList(pl_pas_assParser.ElementListContext ctx) {
        return null;
    }

    @Override
    public T visitElement(pl_pas_assParser.ElementContext ctx) {
        return null;
    }

    @Override
    public T visitProcedureStatement(pl_pas_assParser.ProcedureStatementContext ctx) {
        return null;
    }

    @Override
    public T visitActualParameter(pl_pas_assParser.ActualParameterContext ctx) {
        return null;
    }

    @Override
    public T visitParameterwidth(pl_pas_assParser.ParameterwidthContext ctx) {
        return null;
    }

    @Override
    public T visitGotoStatement(pl_pas_assParser.GotoStatementContext ctx) {
        return null;
    }

    @Override
    public T visitEmptyStatement_(pl_pas_assParser.EmptyStatement_Context ctx) {
        return null;
    }

    @Override
    public T visitEmpty_(pl_pas_assParser.Empty_Context ctx) {
        return null;
    }

    @Override
    public T visitStructuredStatement(pl_pas_assParser.StructuredStatementContext ctx) {
        return null;
    }

    @Override
    public T visitCompoundStatement(pl_pas_assParser.CompoundStatementContext ctx) {
        return null;
    }

    @Override
    public T visitStatements(pl_pas_assParser.StatementsContext ctx) {
        return null;
    }

    @Override
    public T visitConditionalStatement(pl_pas_assParser.ConditionalStatementContext ctx) {
        return null;
    }

    @Override
    public T visitIfStatement(pl_pas_assParser.IfStatementContext ctx) {
        return null;
    }

    @Override
    public T visitCaseStatement(pl_pas_assParser.CaseStatementContext ctx) {
        return null;
    }

    @Override
    public T visitCaseListElement(pl_pas_assParser.CaseListElementContext ctx) {
        return null;
    }

    @Override
    public T visitRepetetiveStatement(pl_pas_assParser.RepetetiveStatementContext ctx) {
        return null;
    }

    @Override
    public T visitWhileStatement(pl_pas_assParser.WhileStatementContext ctx) {
        return null;
    }

    @Override
    public T visitRepeatStatement(pl_pas_assParser.RepeatStatementContext ctx) {
        return null;
    }

    @Override
    public T visitForStatement(pl_pas_assParser.ForStatementContext ctx) {
        ctx.FOR().getSymbol();
        ctx.DO().getSymbol();
        ctx.statement().unlabelledStatement().simpleStatement().assignmentStatement();
        ctx.statement().unlabelledStatement().simpleStatement()
                .procedureStatement().parameterList().actualParameter();
        return null;
    }

    @Override
    public T visitForList(pl_pas_assParser.ForListContext ctx) {
        pl_pas_assParser.ExpressionContext expCFinal = ctx.finalValue().expression();
        pl_pas_assParser.ExpressionContext expCInit = ctx.initialValue().expression();
        expCInit.simpleExpression().get(0);
        return null;
    }

    @Override
    public T visitInitialValue(pl_pas_assParser.InitialValueContext ctx) {
        return null;
    }

    @Override
    public T visitFinalValue(pl_pas_assParser.FinalValueContext ctx) {
        return null;
    }

    @Override
    public T visitWithStatement(pl_pas_assParser.WithStatementContext ctx) {
        return null;
    }

    @Override
    public T visitRecordVariableList(pl_pas_assParser.RecordVariableListContext ctx) {
        ctx.variable().get(0).AT().getSymbol();
        return null;
    }

    @Override
    public T visit(ParseTree parseTree) {
        super.visit(parseTree);
        return null;
    }

    @Override
    public T visitChildren(RuleNode ruleNode) {
        T result = this.defaultResultPub();
        int n = ruleNode.getChildCount();

        for(int i = 0; i < n && this.shouldVisitNextChild(ruleNode, result); ++i) {
            ParseTree c = ruleNode.getChild(i);
            T childResult = (T) c.accept(this);
            result = this.aggregateResultPub(result, childResult);
            if (c instanceof RuleNode) {
               // result = visitChildren((RuleNode) c);
            }

        }

        return result;

    }

    protected T defaultResultPub() {
        return null;
    }

    protected T aggregateResultPub(T aggregate, T nextResult) {
        return nextResult;
    }

    protected boolean shouldVisitNextChildPub(RuleNode node, T currentResult) {
        return true;
    }

    @Override
    public T visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public T visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
