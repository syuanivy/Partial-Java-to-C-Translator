grammar S;

@header {
package cs652.j.parser;
import cs652.j.semantics.*; // You will need these for stuff in "returns" clauses
import org.antlr.symbols.*;
}

file returns [GlobalScope scope]
    : classDeclaration* main EOF;

classDeclaration
    :   'class' Identifier
        ('extends' type)?
        classBody
    ;


main
    :blockStatement*;



classBody
    :   '{' classBodyDeclaration* '}'
    ;

classBodyDeclaration
    :   ';'
    |   memberDeclaration
    ;

memberDeclaration
    :   methodDeclaration
    |   fieldDeclaration
    ;

methodDeclaration
    :   (type|'void') Identifier formalParameters
        (   methodBody
        |   ';'
        )
    ;

fieldDeclaration
    :   type Identifier ';'
    ;

formalParameters
    :   '(' formalParameterList? ')'
    ;

formalParameterList
    :   formalParameter (',' formalParameter)*
    ;

formalParameter
    :   type variableDeclaratorId
    ;

variableDeclaratorId
    :   Identifier
    ;

methodBody
    :   block
    ;


// STATEMENTS / BLOCKS

block
    :   '{' blockStatement* '}'
    ;

blockStatement
    :   variableDeclaration
    |   statement
    ;

variableDeclaration
    :    type Identifier ';'
    ;

statement
    :   block
    |   'if' parExpression statement ('else' statement)?
    |   'while' parExpression statement
    |   'return' expression? ';'
    |   ';'
    |   statementExpression ';'
    ;

statementExpression
    :   expression
    ;

parExpression
    :   '(' expression ')'
    ;

expression returns [Type expressionType]
    :   primary
    |   dot=expression '.' dotI=Identifier
    |   method=expression '(' expressionList? ')'
    |   'new' newI=Identifier '(' ')'
    |   des=expression '=' src=expression
    ;

expressionList
    :   expression (',' expression)*
    ;

primary
    :   'this'
    |   literal
    |   Identifier
    |   primitiveType
    ;

creator
    : type '()';

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
    ;
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
