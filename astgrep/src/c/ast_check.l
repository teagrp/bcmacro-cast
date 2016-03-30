%option noyywrap
%option yylineno
%{
#include "ast_check.tab.h"
%}

ID              [-+*=$%&<>_/.^~!?a-zA-Z0-9]*
digit           [0-9]

%%
([ \t\n]|",")+        ; /* skip */

"'"|"{"|"}"|"("|")"|"["|"]"          return *yytext;


{digit}+        {
                  yylval.i = atoi(yytext);
                  // printf("CONST %s\n", yytext);
                  return CONSTANT;
                }

{ID}            {
                  yylval.s = strdup(yytext);
                  // printf("ID %s\n", yytext);
                  return IDENTIFIER;
                }
:{ID}           {
                  yylval.s = strdup(yytext);
                  // printf("KEY %s\n", yytext);
                  return KEYWORD;
                }

\"(\\|\\\"|[^\"])*\" {
                  yylval.s = strdup(yytext);
                  // printf("STR %s\n", yytext);
                  return STRING;
                }

.               yyerror("Error: invalid character");
%%
