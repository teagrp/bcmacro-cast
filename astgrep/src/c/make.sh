#!/bin/sh
bison -d ast_check.y
flex ast_check.l
gcc -O2 -o ast_checker ast_check.tab.c lex.yy.c
