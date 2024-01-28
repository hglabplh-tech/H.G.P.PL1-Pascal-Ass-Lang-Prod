package hgp.lang.genCompile;


import hgp.lang.gparser.pl_pas_assBaseVisitor;
import hgp.lang.gparser.pl_pas_assParser;
import hgp.lang.gparser.pl_pas_assVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TestLangVisitor<T> extends pl_pas_assBaseVisitor<T>
        implements pl_pas_assVisitor<T> {

    

    public T visitProgram(pl_pas_assParser.ProgramContext ctx) {
        System.err.println(ctx.programHeading()
                .identifier().IDENT().getSymbol());
        return null;
    }

    
    public T visitTheblocks(pl_pas_assParser.TheblocksContext ctx) {
        System.err.println(ctx.block().compoundStatement().statements());
        return null;
    }

    
    public T visitProgramHeading(pl_pas_assParser.ProgramHeadingContext ctx) {
        return null;
    }

    
    public T visitIdentifier(pl_pas_assParser.IdentifierContext ctx) {
        return null;
    }

    
    public T visitBlock(pl_pas_assParser.BlockContext ctx) {
        return null;
    }

    
    public T visitProgClassBlock(pl_pas_assParser.ProgClassBlockContext ctx) {
        return null;
    }

    
    public T visitClassBlock(pl_pas_assParser.ClassBlockContext ctx) {
        return null;
    }

    
    public T visitIfcBlock(pl_pas_assParser.IfcBlockContext ctx) {
        return null;
    }

    
    public T visitClassDeclarationPart(pl_pas_assParser.ClassDeclarationPartContext ctx) {
        return null;
    }

    
    public T visitInterfaceDeclarationPart(pl_pas_assParser.InterfaceDeclarationPartContext ctx) {
        return null;
    }

    
    public T visitClassModifier(pl_pas_assParser.ClassModifierContext ctx) {
        return null;
    }

    
    public T visitClModDecl(pl_pas_assParser.ClModDeclContext ctx) {
        return null;
    }

    
    public T visitModifier(pl_pas_assParser.ModifierContext ctx) {
        return null;
    }

    
    public T visitUsesUnitsPart(pl_pas_assParser.UsesUnitsPartContext ctx) {
        return null;
    }

    
    public T visitLabelDeclarationPart(pl_pas_assParser.LabelDeclarationPartContext ctx) {
        return null;
    }

    
    public T visitLabel(pl_pas_assParser.LabelContext ctx) {
        return null;
    }

    
    public T visitConstantDefinitionPart(pl_pas_assParser.ConstantDefinitionPartContext ctx) {
        return null;
    }

    
    public T visitConstantDefinition(pl_pas_assParser.ConstantDefinitionContext ctx) {
        return null;
    }

    
    public T visitConstantChr(pl_pas_assParser.ConstantChrContext ctx) {
        return null;
    }

    
    public T visitConstant(pl_pas_assParser.ConstantContext ctx) {
        return null;
    }

    
    public T visitUnsignedNumber(pl_pas_assParser.UnsignedNumberContext ctx) {
        return null;
    }

    
    public T visitUnsignedInteger(pl_pas_assParser.UnsignedIntegerContext ctx) {
        return null;
    }

    
    public T visitUnsignedReal(pl_pas_assParser.UnsignedRealContext ctx) {
        return null;
    }

    
    public T visitSign(pl_pas_assParser.SignContext ctx) {
        return null;
    }

    
    public T visitBool_(pl_pas_assParser.Bool_Context ctx) {
        return null;
    }

    
    public T visitString(pl_pas_assParser.StringContext ctx) {
        return null;
    }

    
    public T visitTypeDefinitionPart(pl_pas_assParser.TypeDefinitionPartContext ctx) {
        return null;
    }

    
    public T visitMemberType(pl_pas_assParser.MemberTypeContext ctx) {
        return null;
    }

    
    public T visitTypeDefinition(pl_pas_assParser.TypeDefinitionContext ctx) {
        return null;
    }

    
    public T visitFunctionType(pl_pas_assParser.FunctionTypeContext ctx) {
        return null;
    }

    
    public T visitMethodType(pl_pas_assParser.MethodTypeContext ctx) {
        return null;
    }

    
    public T visitLambdaTopLevelType(pl_pas_assParser.LambdaTopLevelTypeContext ctx) {
        return null;
    }

    
    public T visitProcedureType(pl_pas_assParser.ProcedureTypeContext ctx) {
        return null;
    }

    
    public T visitType_(pl_pas_assParser.Type_Context ctx) {
        return null;
    }

    
    public T visitSimpleType(pl_pas_assParser.SimpleTypeContext ctx) {
        return null;
    }

    
    public T visitScalarType(pl_pas_assParser.ScalarTypeContext ctx) {
        return null;
    }

    
    public T visitSubrangeType(pl_pas_assParser.SubrangeTypeContext ctx) {
        return null;
    }

    
    public T visitTypeIdentifier(pl_pas_assParser.TypeIdentifierContext ctx) {
        return null;
    }

    
    public T visitStructuredType(pl_pas_assParser.StructuredTypeContext ctx) {
        return null;
    }

    
    public T visitUnpackedStructuredType(pl_pas_assParser.UnpackedStructuredTypeContext ctx) {
        return null;
    }

    
    public T visitStringtype(pl_pas_assParser.StringtypeContext ctx) {
        return null;
    }

    
    public T visitArrayType(pl_pas_assParser.ArrayTypeContext ctx) {
        return null;
    }

    
    public T visitTypeList(pl_pas_assParser.TypeListContext ctx) {
        return null;
    }

    
    public T visitIndexType(pl_pas_assParser.IndexTypeContext ctx) {
        return null;
    }

    
    public T visitComponentType(pl_pas_assParser.ComponentTypeContext ctx) {
        return null;
    }

    
    public T visitRecordType(pl_pas_assParser.RecordTypeContext ctx) {
        return null;
    }

    
    public T visitFieldList(pl_pas_assParser.FieldListContext ctx) {
        return null;
    }

    
    public T visitFixedPart(pl_pas_assParser.FixedPartContext ctx) {
        return null;
    }

    
    public T visitRecordSection(pl_pas_assParser.RecordSectionContext ctx) {
        return null;
    }

    
    public T visitVariantPart(pl_pas_assParser.VariantPartContext ctx) {
        return null;
    }

    
    public T visitTag(pl_pas_assParser.TagContext ctx) {
        return null;
    }

    
    public T visitVariant(pl_pas_assParser.VariantContext ctx) {
        return null;
    }

    
    public T visitSetType(pl_pas_assParser.SetTypeContext ctx) {
        return null;
    }

    
    public T visitBaseType(pl_pas_assParser.BaseTypeContext ctx) {
        return null;
    }

    
    public T visitFileType(pl_pas_assParser.FileTypeContext ctx) {
        return null;
    }

    
    public T visitLambdaType(pl_pas_assParser.LambdaTypeContext ctx) {
        return null;
    }

    
    public T visitPointerType(pl_pas_assParser.PointerTypeContext ctx) {
        return null;
    }

    
    public T visitVariableDeclarationPart(pl_pas_assParser.VariableDeclarationPartContext ctx) {
        return null;
    }

    
    public T visitMemberVariableDeclarationPart(pl_pas_assParser.MemberVariableDeclarationPartContext ctx) {
        return null;
    }

    
    public T visitVariableDeclaration(pl_pas_assParser.VariableDeclarationContext ctx) {
        return null;
    }

    
    public T visitProcedureAndFunctionDeclarationPart(pl_pas_assParser.ProcedureAndFunctionDeclarationPartContext ctx) {
        return null;
    }

    
    public T visitProcedureOrFunctionDeclaration(pl_pas_assParser.ProcedureOrFunctionDeclarationContext ctx) {
        return null;
    }

    
    public T visitProcedureDeclaration(pl_pas_assParser.ProcedureDeclarationContext ctx) {
        return null;
    }

    
    public T visitFormalParameterList(pl_pas_assParser.FormalParameterListContext ctx) {
        return null;
    }

    
    public T visitFormalParameterSection(pl_pas_assParser.FormalParameterSectionContext ctx) {
        return null;
    }

    
    public T visitParameterGroup(pl_pas_assParser.ParameterGroupContext ctx) {
        return null;
    }

    
    public T visitIdentifierList(pl_pas_assParser.IdentifierListContext ctx) {
        return null;
    }

    
    public T visitConstList(pl_pas_assParser.ConstListContext ctx) {
        return null;
    }

    
    public T visitFunctionDeclaration(pl_pas_assParser.FunctionDeclarationContext ctx) {
        return null;
    }

    
    public T visitAssblock(pl_pas_assParser.AssblockContext ctx) {
        return null;
    }

    
    public T visitAssFunDeclaration(pl_pas_assParser.AssFunDeclarationContext ctx) {
        return null;
    }

    
    public T visitLambdaDeclaration(pl_pas_assParser.LambdaDeclarationContext ctx) {
        return null;
    }

    
    public T visitMethodDeclaration(pl_pas_assParser.MethodDeclarationContext ctx) {
        return null;
    }

    
    public T visitResultType(pl_pas_assParser.ResultTypeContext ctx) {
        return null;
    }

    
    public T visitStatement(pl_pas_assParser.StatementContext ctx) {
        return null;
    }

    
    public T visitUnlabelledStatement(pl_pas_assParser.UnlabelledStatementContext ctx) {
        return null;
    }

    
    public T visitSimpleStatement(pl_pas_assParser.SimpleStatementContext ctx) {
        return null;
    }

    
    public T visitAssignmentStatement(pl_pas_assParser.AssignmentStatementContext ctx) {
        return null;
    }

    
    public T visitVariable(pl_pas_assParser.VariableContext ctx) {
        return null;
    }

    
    public T visitExpression(pl_pas_assParser.ExpressionContext ctx) {
        return null;
    }

    
    public T visitRelationaloperator(pl_pas_assParser.RelationaloperatorContext ctx) {
        return null;
    }

    
    public T visitSimpleExpression(pl_pas_assParser.SimpleExpressionContext ctx) {
        return null;
    }

    
    public T visitAdditiveoperator(pl_pas_assParser.AdditiveoperatorContext ctx) {
        return null;
    }

    
    public T visitTerm(pl_pas_assParser.TermContext ctx) {
        return null;
    }

    
    public T visitMultiplicativeoperator(pl_pas_assParser.MultiplicativeoperatorContext ctx) {
        return null;
    }

    
    public T visitSignedFactor(pl_pas_assParser.SignedFactorContext ctx) {
        return null;
    }

    
    public T visitFactor(pl_pas_assParser.FactorContext ctx) {
        return null;
    }

    
    public T visitUnsignedConstant(pl_pas_assParser.UnsignedConstantContext ctx) {
        return null;
    }

    
    public T visitFunctionDesignator(pl_pas_assParser.FunctionDesignatorContext ctx) {
        return null;
    }

    
    public T visitParameterList(pl_pas_assParser.ParameterListContext ctx) {
        return null;
    }

    
    public T visitSet_(pl_pas_assParser.Set_Context ctx) {
        return null;
    }

    
    public T visitElementList(pl_pas_assParser.ElementListContext ctx) {
        return null;
    }

    
    public T visitElement(pl_pas_assParser.ElementContext ctx) {
        return null;
    }

    
    public T visitProcedureStatement(pl_pas_assParser.ProcedureStatementContext ctx) {
        return null;
    }

    
    public T visitActualParameter(pl_pas_assParser.ActualParameterContext ctx) {
        return null;
    }

    
    public T visitParameterwidth(pl_pas_assParser.ParameterwidthContext ctx) {
        return null;
    }

    
    public T visitGotoStatement(pl_pas_assParser.GotoStatementContext ctx) {
        return null;
    }

    
    public T visitEmptyStatement_(pl_pas_assParser.EmptyStatement_Context ctx) {
        return null;
    }

    
    public T visitEmpty_(pl_pas_assParser.Empty_Context ctx) {
        return null;
    }

    
    public T visitStructuredStatement(pl_pas_assParser.StructuredStatementContext ctx) {
        return null;
    }

    
    public T visitCompoundStatement(pl_pas_assParser.CompoundStatementContext ctx) {
        return null;
    }

    
    public T visitStatements(pl_pas_assParser.StatementsContext ctx) {
        return null;
    }

    
    public T visitConditionalStatement(pl_pas_assParser.ConditionalStatementContext ctx) {
        return null;
    }

    
    public T visitIfStatement(pl_pas_assParser.IfStatementContext ctx) {
        return null;
    }

    
    public T visitCaseStatement(pl_pas_assParser.CaseStatementContext ctx) {
        return null;
    }

    
    public T visitCaseListElement(pl_pas_assParser.CaseListElementContext ctx) {
        return null;
    }

    
    public T visitRepetetiveStatement(pl_pas_assParser.RepetetiveStatementContext ctx) {
        return null;
    }

    
    public T visitWhileStatement(pl_pas_assParser.WhileStatementContext ctx) {
        return null;
    }

    
    public T visitRepeatStatement(pl_pas_assParser.RepeatStatementContext ctx) {
        return null;
    }

    
    public T visitForStatement(pl_pas_assParser.ForStatementContext ctx) {
        return null;
    }

    
    public T visitForList(pl_pas_assParser.ForListContext ctx) {
        return null;
    }

    
    public T visitInitialValue(pl_pas_assParser.InitialValueContext ctx) {
        return null;
    }

    
    public T visitFinalValue(pl_pas_assParser.FinalValueContext ctx) {
        return null;
    }

    
    public T visitWithStatement(pl_pas_assParser.WithStatementContext ctx) {
        return null;
    }

    
    public T visitRecordVariableList(pl_pas_assParser.RecordVariableListContext ctx) {
        return null;
    }

    
    public T visit(ParseTree parseTree) {
        super.visit(parseTree);

        return null;
    }

    
    public T visitChildren(RuleNode ruleNode) {
        return super.visitChildren(ruleNode);
    }

    
    public T visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    
    public T visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
