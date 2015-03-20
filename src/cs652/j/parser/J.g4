grammar J;

@header {
package cs652.j.parser;
import cs652.j.semantics.*; // You will need these for stuff in "returns" clauses
import org.antlr.symbols.*;
}

file returns [GlobalScope scope]
    : classDeclaration* main EOF;

classDeclaration:COMMENT;
main:LINE_COMMENT;



COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;
LINE_COMMENT : '//' ~'\n'* '\n' -> channel(HIDDEN) ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
