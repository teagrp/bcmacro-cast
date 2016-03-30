%{
#include <stdio.h>
%}

%union {
  int i;
  char *s;
}

%token<i> CONSTANT
%token<s> IDENTIFIER STRING KEYWORD

%error-verbose

%%
toplevel: main { printf("DONE\n"); } 

main:
    | atom main
    ;

atom: IDENTIFIER
    | CONSTANT
    | STRING
    | KEYWORD
    | vector
    | list
    | map
    | '\'' atom
    ;

vector: '[' seq ']'
      ;

list: '(' seq ')'
    ;

seq:
   | atom seq
   ;

map: '{' kvseq '}'
   ;

kvseq:
     | KEYWORD atom kvseq
     ;

%%
extern int yylineno;

int yyerror(char *s) {
  fprintf(stderr, "%d: %s\n", yylineno, s);
  return 0;
}

main() {
  yyparse();
}
