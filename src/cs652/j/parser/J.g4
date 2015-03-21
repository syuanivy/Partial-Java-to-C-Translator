grammar J;

@header {
package cs652.j.parser;
import org.antlr.symbols.*;
import cs652.j.semantics.*; // You will need these for stuff in "returns" clauses
}

file returns [GlobalScope scope]
    :   classDeclaration* main EOF
    ;

classDeclaration returns [JClass scope]
    :   'class' Identifier
        ('extends' type)?
        classBody
    ;

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

methodDeclaration returns [JMethod scope]
    :   (type|'void') Identifier formalParameters
        (   methodBody
        |   ';'
        )
    ;

methodBody
    :   block
    ;

block returns [LocalScope scope]
    :   '{' blockStatement* '}'
    ;

blockStatement
    :   variableDeclaration
    |   statement
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

main
    :   blockStatement*
    ;

variableDeclaration
    :   type Identifier ';'
    ;

fieldDeclaration
    :   type Identifier ';'
    ;

type
    :   classOrInterfaceType
    |   primitiveType
    ;

classOrInterfaceType
    :   Identifier
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
    ;

literal
    :   IntegerLiteral
    |   FloatingPointLiteral
    |   StringLiteral
    |   'null'
    ;

primitiveType
    :   'int'
    |   'float'
    ;

StringLiteral
    :   '"' StringCharacters? '"'
    ;


IntegerLiteral
    :   DecimalIntegerLiteral
    ;

DecimalIntegerLiteral
    :   DecimalNumeral
    ;

FloatingPointLiteral
    :   DecimalFloatingPointLiteral
    ;

fragment
StringCharacters
    :   StringCharacter+
    ;
fragment
StringCharacter
    :   ~["]
    ;

fragment
DecimalFloatingPointLiteral
    :   DecimalNumeral '.' Digits
    ;

fragment
DecimalNumeral
    :   '0'
    |   NonZeroDigit Digits?
    ;

fragment
NonZeroDigit
    :   [1-9]
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

Identifier
    :   JavaLetter JavaLetterOrDigit*
    ;

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0xFF
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0xFF
    |   // covers all characters above 0xFF which are not a surrogate
        ~[\u0000-\u00FF\uD800-\uDBFF]
        {Character.isJavaIdentifierPart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;