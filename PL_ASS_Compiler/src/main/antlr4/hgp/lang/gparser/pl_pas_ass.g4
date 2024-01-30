
/*
BSD License

Copyright (c) 2013, Tom Everett
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the name of Tom Everett nor the names of its contributors
   may be used to endorse or promote products derived from this software
   without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
/*
Adapted from pascal.g by  Hakki Dogusan, Piet Schoutteten and Marton Papp
*/

// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSemicolons hanging, alignColons hanging


grammar pl_pas_ass;



options {

    language=Java;
    caseInsensitive = true;
}


program
    : programHeading (INTERFACE)? theblocks DOT EOF
    ;

theblocks
: (block
| progClassBlock
)
;


programHeading
    : PROGRAM identifier (LPAREN identifierList RPAREN)? SEMICOLON
    | UNIT identifier SEMICOLON
    ;

identifier
    : IDENT
    ;

block
    : (
        labelDeclarationPart
        | constantDefinitionPart
        | typeDefinitionPart
        | variableDeclarationPart
        | procedureAndFunctionDeclarationPart
        | usesUnitsPart
        | IMPLEMENTATION

    )* compoundStatement
    ;

progClassBlock
    : (classDeclarationPart
       interfaceDeclarationPart)
    ;

classBlock
     : (
       memberVariableDeclarationPart
        | methodDeclaration
        | classDeclarationPart
        | IMPLEMENTATION
     )
     ;

ifcBlock
     : (
           methodType
        | memberType
        | IMPLEMENTATION
     )
     ;


classDeclarationPart
    : modifier CLASS identifier clModDecl classBlock
    ;

interfaceDeclarationPart
    : CLASSINTERFACE identifier clModDecl ifcBlock
    ;


classModifier
      : EXTENDS
      | IMPLEMENTS
      ;

clModDecl
       : classModifier identifier
       ;

modifier
     : PRIVATE
        | PUBLIC
        | STATIC
        ;

usesUnitsPart
    : USES identifierList SEMICOLON
    ;

labelDeclarationPart
    : LABEL label (COMMA label)* SEMICOLON
    ;

label
    : unsignedInteger
    ;

constantDefinitionPart
    : CONST (constantDefinition SEMICOLON)+
    ;

constantDefinition
    : identifier EQUAL constant
    ;

constantChr
    : CHR LPAREN unsignedInteger RPAREN
    ;

constant
    : unsignedNumber
    | sign unsignedNumber
    | identifier
    | sign identifier
    | string
    | constantChr
    ;

unsignedNumber
    : unsignedInteger
    | unsignedReal
    ;

unsignedInteger
    : NUM_INT
    ;

unsignedReal
    : NUM_REAL
    ;

sign
    : PLUS
    | MINUS
    ;

bool_
    : TRUE
    | FALSE
    ;

string
    : STRING_LITERAL
    ;

typeDefinitionPart
    : TYPE (typeDefinition SEMICOLON)+
    ;

memberType
    : MEMBER identifier typeDefinition SEMICOLON
    ;

typeDefinition
    : identifier EQUAL (type_ | functionType | procedureType)
    ;

functionType
    : FUNCTION identifier (formalParameterList)? COLON resultType
    ;

methodType
    : FUNCTION identifier (formalParameterList)? COLON resultType
    ;

lambdaTopLevelType
     : DEFINE identifier (formalParameterList)? RESULTPTR resultType
     ;

procedureType
    : PROCEDURE (formalParameterList)?
    ;

type_
    : simpleType
    | structuredType
    | pointerType
    ;

simpleType
    : scalarType
    | subrangeType
    | typeIdentifier
    | stringtype
    ;

scalarType
    : LPAREN identifierList RPAREN
    ;

subrangeType
    : constant DOTDOT constant
    ;

typeIdentifier
    : identifier
    | (CHAR | BOOLEAN | INTEGER | REAL | STRING)
    ;

structuredType
    : PACKED unpackedStructuredType
    | unpackedStructuredType
    ;

unpackedStructuredType
    : arrayType
    | recordType
    | setType
    | fileType
    | lambdaType
    ;

stringtype
    : STRING LBRACK (identifier | unsignedNumber) RBRACK
    ;

arrayType
    : ARRAY LBRACK typeList RBRACK OF componentType
    | ARRAY LBRACK2 typeList RBRACK2 OF componentType
    ;

typeList
    : indexType (COMMA indexType)*
    ;

indexType
    : simpleType
    ;

componentType
    : type_
    ;

recordType
    : RECORD fieldList? END
    ;

fieldList
    : fixedPart (SEMICOLON variantPart)?
    | variantPart
    ;

fixedPart
    : recordSection (SEMICOLON recordSection)*
    ;

recordSection
    : identifierList COLON type_
    ;

variantPart
    : CASE tag OF variant (SEMICOLON variant)*
    ;

tag
    : identifier COLON typeIdentifier
    | typeIdentifier
    ;

variant
    : constList COLON LPAREN fieldList RPAREN
    ;

setType
    : SET OF baseType
    ;

baseType
    : simpleType
    ;

fileType
    : FILE OF type_
    | FILE
    ;

lambdaType
       : LAMBDA
       ;

pointerType
    : POINTER typeIdentifier
    ;

variableDeclarationPart
    : VAR variableDeclaration (SEMICOLON variableDeclaration)* SEMICOLON
    ;

memberVariableDeclarationPart
    : MEMBER modifier variableDeclaration (SEMICOLON variableDeclaration)* SEMICOLON
    ;



variableDeclaration
    : identifierList COLON type_
    ;


procedureAndFunctionDeclarationPart
    : procedureOrFunctionDeclaration SEMICOLON
    ;

procedureOrFunctionDeclaration
    : procedureDeclaration
    | lambdaDeclaration
    | functionDeclaration
    | assFunDeclaration
    ;

procedureDeclaration
    : PROCEDURE identifier (formalParameterList)? SEMICOLON block
    ;



formalParameterList
    : LPAREN formalParameterSection (SEMICOLON formalParameterSection)* RPAREN
    ;

formalParameterSection
    : parameterGroup
    | VAR parameterGroup
    | FUNCTION parameterGroup
    | PROCEDURE parameterGroup
    | LAMBDA parameterGroup
    | ASSFUN parameterGroup
    ;

parameterGroup
    : identifierList COLON typeIdentifier
    ;

identifierList
    : identifier (COMMA identifier)*
    ;

constList
    : constant (COMMA constant)*
    ;

functionDeclaration
    : FUNCTION identifier (formalParameterList)? COLON resultType SEMICOLON block
    ;

assblock
    :LBRACK ASS_STRING RBRACK;

assFunDeclaration
    : ASSFUN identifier (formalParameterList)? COLON resultType SEMICOLON assblock
    ;

lambdaDeclaration
    : ANONYMOUS (formalParameterList)?  RESULTPTR resultType SEMICOLON block
    ;


methodDeclaration
     : METHOD  modifier identifier (formalParameterList)? SEMICOLON block
     ;

resultType
    : typeIdentifier
    ;

statement
    : label COLON unlabelledStatement
    | unlabelledStatement
    ;

unlabelledStatement
    : simpleStatement
    | structuredStatement
    ;

simpleStatement
    : assignmentStatement
    | procedureStatement
    | gotoStatement
    | emptyStatement_
    ;

assignmentStatement
    : variable ASSIGN expression
    ;

variable
    : (AT identifier | identifier) (
        LBRACK expression (COMMA expression)* RBRACK
        | LBRACK2 expression (COMMA expression)* RBRACK2
        | DOT identifier
        | POINTER
        | LAMBDA
    )*
    ;

expression
    : (lambdaDeclaration
              | simpleExpression (relationaloperator expression)?)*
    ;

relationaloperator
    : EQUAL
    | NOT_EQUAL
    | LT
    | LE
    | GE
    | GT
    | IN
    ;

simpleExpression
    : term (additiveoperator simpleExpression)?
    ;

additiveoperator
    : PLUS
    | MINUS
    | OR
    ;

term
    : signedFactor (multiplicativeoperator term)?
    ;

multiplicativeoperator
    : STAR
    | SLASH
    | DIV
    | MOD
    | AND
    ;

signedFactor
    : (PLUS | MINUS)? factor
    ;

factor
    : variable
    | LPAREN expression RPAREN
    | functionDesignator
    | unsignedConstant
    | set_
    | NOT factor
    | bool_
    ;

unsignedConstant
    : unsignedNumber
    | constantChr
    | string
    | NIL
    ;

functionDesignator
    : identifier LPAREN parameterList RPAREN
    ;

parameterList
    : actualParameter (COMMA actualParameter)*
    ;

set_
    : LBRACK elementList RBRACK
    | LBRACK2 elementList RBRACK2
    ;

elementList
    : element (COMMA element)*
    |
    ;

element
    : expression (DOTDOT expression)?
    ;

procedureStatement
    : identifier (LPAREN parameterList RPAREN)?
    ;

actualParameter
    : expression parameterwidth*
    ;

parameterwidth
    : COLON expression
    ;

gotoStatement
    : GOTO label
    ;

emptyStatement_
    :
    ;

empty_
    :
    /* empty */
    ;

structuredStatement
    : compoundStatement
    | conditionalStatement
    | repetetiveStatement
    | withStatement
    ;

compoundStatement
    : BEGIN  statements END
    ;

statements
    : statement (SEMICOLON statement)*
    ;

conditionalStatement
    : ifStatement
    | caseStatement
    ;

ifStatement
    : IF expression THEN statement (: ELSE statement)?
    ;

caseStatement
    : CASE expression OF caseListElement (SEMICOLON caseListElement)* (SEMICOLON ELSE statements)? END
    ;

caseListElement
    : constList COLON statement
    ;

repetetiveStatement
    : whileStatement
    | repeatStatement
    | forStatement
    ;

whileStatement
    : WHILE expression DO statement
    ;

repeatStatement
    : REPEAT statements UNTIL expression
    ;

forStatement
    : FOR identifier ASSIGN forList DO statement
    ;

forList
    : initialValue (TO | DOWNTO) finalValue
    ;

initialValue
    : expression
    ;

finalValue
    : expression
    ;

withStatement
    : WITH recordVariableList DO statement
    ;

recordVariableList
    : variable (COMMA variable)*
    ;



AND
    : 'AND'
    ;

ARRAY
    : 'ARRAY'
    ;

BEGIN
    : 'BEGIN'
    ;

BOOLEAN
    : 'BOOLEAN'
    ;

CASE
    : 'CASE'
    ;

CHAR
    : 'CHAR'
    ;

CHR
    : 'CHR'
    ;

CONST
    : 'CONST'
    ;

DIV
    : 'DIV'
    ;

DO
    : 'DO'
    ;

DOWNTO
    : 'DOWNTO'
    ;

ELSE
    : 'ELSE'
    ;

END
    : 'END'
    ;

FILE
    : 'FILE'
    ;

FOR
    : 'FOR'
    ;

FUNCTION
    : 'FUNCTION'
    ;

ASSFUN
    : 'ASSFUN'
    ;

GOTO
    : 'GOTO'
    ;

IF
    : 'IF'
    ;

IN
    : 'IN'
    ;

INTEGER
    : 'INTEGER'
    ;

LABEL
    : 'LABEL'
    ;

MOD
    : 'MOD'
    ;

NIL
    : 'NIL'
    ;

NOT
    : 'NOT'
    ;

OF
    : 'OF'
    ;

OR
    : 'OR'
    ;

PACKED
    : 'PACKED'
    ;

PROCEDURE
    : 'PROCEDURE'
    ;

PROGRAM
    : 'PROGRAM'
    ;

REAL
    : 'REAL'
    ;

RECORD
    : 'RECORD'
    ;

REPEAT
    : 'REPEAT'
    ;

SET
    : 'SET'
    ;

THEN
    : 'THEN'
    ;

TO
    : 'TO'
    ;

TYPE
    : 'TYPE'
    ;

UNTIL
    : 'UNTIL'
    ;

VAR
    : 'VAR'
    ;

WHILE
    : 'WHILE'
    ;

WITH
    : 'WITH'
    ;

PLUS
    : '+'
    ;

MINUS
    : '-'
    ;

STAR
    : '*'
    ;

SLASH
    : '/'
    ;

ASSIGN
    : ':='
    ;

COMMA
    : ','
    ;
RESULTPTR
    : '->'
    ;

SEMICOLON
    : ';'
    ;

COLON
    : ':'
    ;

EQUAL
    : '='
    ;

NOT_EQUAL
    : '<>'
    ;

LT
    : '<'
    ;

LE
    : '<='
    ;

GE
    : '>='
    ;

GT
    : '>'
    ;

LPAREN
    : '('
    ;

RPAREN
    : ')'
    ;

LBRACK
    : '['
    ;

LBRACK2
    : '(.'
    ;

RBRACK
    : ']'
    ;

RBRACK2
    : '.)'
    ;

POINTER
    : '^'
    ;

AT
    : '@'
    ;

DOT
    : '.'
    ;

DOTDOT
    : '..'
    ;

LCURLY
    : '{'
    ;

RCURLY
    : '}'
    ;

UNIT
    : 'UNIT'
    ;

INTERFACE
    : 'INTERFACE'
    ;

USES
    : 'USES'
    ;

STRING
    : 'STRING'
    ;

IMPLEMENTATION
    : 'IMPLEMENTATION'
    ;

TRUE
    : 'TRUE'
    ;

FALSE
    : 'FALSE'
    ;

CLASS
    : 'CLASS'
    ;
CLASSINTERFACE
     : 'CLASSINTERFACE'
     ;

PUBLIC
    : 'PUBLIC'
    ;

PRIVATE
    : 'PRIVATE'
    ;

STATIC
    : 'STATIC'
    ;

METHOD
    : 'METHOD'
    ;

MEMBER
     : 'MEMBER'
     ;

IMPLEMENTS
     : 'IMPLEMENTS'
     ;

 EXTENDS
     : 'EXTENDS'
     ;

DEFINE
    : 'DEFINE'
    ;

LAMBDA
    : 'LAMBDA'
    ;

ANONYMOUS
    : 'ANONYMOUS'
    ;


WS
    : [ \t\r\n] -> skip
    ;

COMMENT_1
    : '(*' .*? '*)' -> skip
    ;

COMMENT_2
    : '{' .*? '}' -> skip
    ;

IDENT
    : ('A' .. 'Z') ('A' .. 'Z' | '0' .. '9' | '_')*
    ;

STRING_LITERAL
   : '\''.*?'\''  //: '\'' ('\'\'' | ~ ('\''))* '\''
    ;

ASS_STRING
    : .*?
    ;

NUM_INT
    : ('0' .. '9')+
    ;

NUM_REAL
    : ('0' .. '9')+ (('.' ('0' .. '9')+ (EXPONENT)?)? | EXPONENT)
    ;

fragment EXPONENT
    : ('E') ('+' | '-')? ('0' .. '9')+
    ;

EOL
: [\n]
;