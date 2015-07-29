#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys

elem_list = [-2]

def get_cursor_id(cursor, cursor_list = []):
    if cursor is None:
        return None

    for i,c in enumerate(cursor_list):
        if cursor == c:
            return i
    cursor_list.append(cursor)
    return len(cursor_list) - 1

def get_info(node, depth=0, pid=-1):
    #ID を取得
    idd = get_cursor_id(node)
    [sys.stdout.write("  ") for i in range(0, depth)]
    sys.stdout.write("(")
    expression_print(node)
    sys.stdout.write("\n")
    children = [get_info(c, depth+1)
                for c in node.get_children()]
    [sys.stdout.write("  ") for i in range(0, depth)]
    sys.stdout.write(")\n")

    
def expression_print(node):
    sys.stdout.write(str(content_print(node)))
    '''
    global elem_list
    level = depth
    if num > -1:
        if depth + 1 >= len(elem_list):
            elem_list.append(elem)
        else: 
            elem_list[depth] += elem
    
    #S-expressionを出力
    if num > -1:
        if elem > 2:
            sys.stdout.write("\n")
        
        while level > 0:
            sys.stdout.write("　")
            level = level - 1
            
        sys.stdout.write("(" + str(content_print(node)))
        
        if elem >= 2 and str(node.kind.name) != "COMPOUND_STMT":
            sys.stdout.write("\n")

        if elem == 0:
            sys.stdout.write(")")
            while elem_list[depth] ==  0:
                depth -= 1
                elem_list[depth] -= 1;
                if elem_list[depth] == 0:
                    sys.stdout.write(")")
            sys.stdout.write("\n")
       '''     
    
def content_print(node):
    to = node.get_tokens()
    string = ""
    if str(node.kind.name) == "FUNCTION_DECL":
        string = string + "Func " + node.get_usr() #str(node.result_type.kind.spelling)
        if str(node.result_type.kind.spelling) == "Pointer":
            string =  string.replace("Pointer", "(Pointer")
            string = string + " (" + str(node.result_type.get_pointee().kind.spelling)
        if "Unexposed" in string:
            string =  string.replace("Unexposed", "Record")
        string = string + " " + node.displayname + " "
    elif str(node.kind.name) == "DECL_STMT":
        string = string + "Decl "
    elif str(node.kind.name) == "VAR_DECL":
        string = string + "Var " + node.displayname + " " + str(node.type.kind.spelling) 
        if str(node.type.kind.spelling) == "Pointer":
            string = string.replace("Pointer", "(Pointer")
            string = string + " (" + str(node.type.get_pointee().kind.spelling) + " " 
        if "Unexposed" in string:
            string =  string.replace("Unexposed", "Record")
    elif "LITERAL" in str(node.kind.name):
        string = string + "Const " + to.next().spelling
    elif str(node.kind.name) == "COMPOUND_STMT":
        string = string + ""
    elif str(node.kind.name) == "BINARY_OPERATOR":
        binary = to.next()
        string = string + str(node.kind.name) + " "
    elif str(node.kind.name) == "DECL_REF_EXPR":
        string = string + str(node.kind.name) + " " + node.spelling
    else:
        string = string + str(node.kind.name)

    return string

def main():
    from clang.cindex import Index

    from optparse import OptionParser, OptionGroup

    global opts
    
    
    #オプションの解析
    parser = OptionParser("usage: %prog [options] {filename} [clang-args*]")
    parser.disable_interspersed_args()
    (opts, args) = parser.parse_args()
    
    if len(args) == 0:
        parser.error('invalid number arguments')
    
    #インデックスを作成
    index = Index.create()
    #コードの解析
    tu = index.parse(None, args)
    if not tu:
        parser.error("unable to load input")
    
    get_info(tu.cursor)
    
main()
