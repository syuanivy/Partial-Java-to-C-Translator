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
    :   block                                                                        #blockStat
    |   'if' ifCond = parExpression ifStat = statement ('else' elseStat= statement)? #ifStat
    |   'while' whileCond = parExpression whileBlock = statement                     #whileStat
    |   'return' retExp = expression? ';'                                            #returnStat
    |   ';'                                                                          #emptyStat
    |   'printf(' StringLiteral (',' expressionList )? ')' ';'                       #printStat
    |   statementExpression ';'                                                      #exprStat
    |   left = expression '=' right = expression ';'                                 #assignStat
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
    :   expression '.' dotID = Identifier           #dotExpr
    |   expression '(' expressionList? ')'          #methodCalExpr
    |   'new' creator                               #newExpr
    |   IntegerLiteral                              #intLiteralExpr
    |   FloatPointLiteral                           #floatLiteralExpr
    |   StringLiteral                               #stringLiteralExpr
    |   'this'                                      #thisExpr
    |   Identifier                                  #identifierExpr
    |   'null'                                      #nullExpr
    ;

expressionList // for methodCallExpr
    :   expression (',' expression)*
    ;

creator // for newExpr
    : type '('')';


//LEXER
//Keywords

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



// Integer Literals

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


//Floating-Point Literals

FloatPointLiteral
    :   IntegerLiteral '.' Digits
    ;

//tring Literals
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

//Separators

LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
SEMI            : ';';
COMMA           : ',';
DOT             : '.';

//Operators

ASSIGN          : '=';


//Identifiers

Identifier
    :   JavaLetter JavaLetterOrDigit*
    ;

fragment
JavaLetter
    :   [a-zA-Z$_]
    | '_'
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_]
    |   '_';


COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
