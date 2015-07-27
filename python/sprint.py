#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys

total = 0
count = 0
elem_list = []

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

    #標準出力へ出力
    elem = [a 
             for a in node.get_children()]
    expression_print(node, depth, pid, len(elem))

    #要素の子を取得
    children = [get_info(c, depth+1, idd)
                for c in node.get_children()]
    
def expression_print(node, depth, num, elem):
    global total, count
    global elem_list
    level = depth
    if depth + 1 >= len(elem_list):
        elem_list.append(elem)
    else: 
        elem_list[depth + 1] += elem
    '''    
    print depth 
    print elem_list
    '''
    #S-expressionを出力
    if num > -1:
        if elem > 2:
            sys.stdout.write("\n")
            count = 0

        while level > 0:
            sys.stdout.write("　")
            level = level - 1

        total = total + 1
        count = count + 1
        sys.stdout.write(str(elem) + "(" + str(node.kind).lstrip("CursorKind.") + "/" + str(node.spelling) + "  ")

        if elem >= 2:
            count = 0
            sys.stdout.write("\n")

        if elem == 0:
            total = total - count
            while count > 0:
                sys.stdout.write(")")
                count -= 1
                
            sys.stdout.write("\n")
            
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
