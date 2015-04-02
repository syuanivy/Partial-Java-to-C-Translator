grammar J;

@header {
package cs652.j.parser;
import cs652.j.semantics.*; // You will need these for stuff in "returns" clauses
import org.antlr.symbols.*;
}

// file: classDeclaration, main
file returns [GlobalScope scope]
    : classDeclaration* main EOF;

classDeclaration returns [JClass scope]
    :   'class' Identifier
        ('extends' type)?
        classBody
    ;

main
    :blockStatement*
    ;

//classDeclaration: type, classBody
//type: classType and primitiveType
type
    :   classType
    |   primitiveType
    ;

classType
    :   Identifier
    ;

primitiveType
    :   'int'
    |   'float'
    |   'void'
    ;
//classBody: classBodyDeclaration*: ; or memberDeclaration( field or method)
classBody
    :   '{' classBodyDeclaration* '}'
    ;

classBodyDeclaration
    :   ';'
    |   memberDeclaration
    ;

memberDeclaration
    :   fieldDeclaration
    |   methodDeclaration
    ;
//field
fieldDeclaration
    :   type variableDeclarator ';'
    ;

variableDeclarator
    :   Identifier
    ;
//method
methodDeclaration returns [JMethod scope]
    :   type Identifier formalParameters
        (   methodBody
        |   ';'
        )
    ;
//parameters
formalParameters
    : '(' formalParameterList? ')'
    ;

formalParameterList
    :  formalParameter (',' formalParameter)*
    ;

formalParameter
    :   type variableDeclarator
    ;
//methodBody
methodBody
    :   block
    ;

// STATEMENTS / BLOCKS

block returns [Scope scope]
    :   '{' blockStatement* '}'
    ;
//blockStatement: localVar Declaration statement, or other statement
blockStatement
    :   localVariableDeclarationStatement
    |   statement
    ;

localVariableDeclarationStatement
    :    localVariableDeclaration ';'
    ;

localVariableDeclaration
    :   type variableDeclarator
    ;
//statement
statement
    :   block
    |   'if' parExpression statement ('else' statement)?
    |   'while' parExpression statement
    |   'return' expression? ';'
    |   ';'
    |   'printf(' StringLiteral (',' expressionList )? ')' ';'
    |   statementExpression ';'
    |   expression '=' expression ';'
    ;

// EXPRESSIONS

parExpression
    :   '(' expression ')'
    ;


statementExpression
    :   expression
    ;
//expression
expression returns [Type expressionType]
    :   primary
    |   dotExpr = expression '.' dotID = Identifier
    |   methodCallExpr = expression '(' expressionList? ')'
    |   newExpr = 'new' creator
    ;
expressionList
    :   expression (',' expression)*
    ;

primary
    :   'this'
    |   literal
    |   Identifier
    ;

creator
    : type '('')';


literal
    :   IntegerLiteral
    |   FloatPointLiteral
    |   StringLiteral
    |   'null'
    ;

//LEXER
// §3.9 Keywords

CLASS         : 'class';
ELSE          : 'else';
EXTENDS       : 'extends';
FLOAT         : 'float';
IF            : 'if';
INT           : 'int';
NEW           : 'new';
RETURN        : 'return';
THIS          : 'this';
VOID          : 'void';
WHILE         : 'while';



// §3.10.1 Integer Literals

IntegerLiteral
    :   DecimalIntegerLiteral
    ;

fragment
DecimalIntegerLiteral
    :   DecimalNumeral
    ;

fragment
DecimalNumeral
    :   '0'
    |   NonZeroDigit Digits?
    ;

fragment
Digits
    :   Digit*
    ;

fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;

fragment
NonZeroDigit
    :   [1-9]
    ;


// §3.10.2 Floating-Point Literals

FloatPointLiteral
    :   IntegerLiteral '.' Digits
    ;

// §3.10.5 String Literals
StringLiteral
    :   '"' StringCharacters? '"'
    ;
fragment
StringCharacters
    :   StringCharacter+
    ;
fragment
StringCharacter
    :   ~["]  // how is that allowing one escape?
    ;


// §3.10.7 The Null Literal

NullLiteral
    :   'null'
    ;

// §3.11 Separators

LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
SEMI            : ';';
COMMA           : ',';
DOT             : '.';

// §3.12 Operators

ASSIGN          : '=';


// §3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
    :   JavaLetter JavaLetterOrDigit*
    ;

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0xFF
    | '_'
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0xFF
    |   '_';


COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
