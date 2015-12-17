
[{:kind "Var" :name "a" :scope "global" :type {:kind "Int-type"} :line [3 3]}
{:kind "Var" :name "b" :scope "global" :type {:kind "Int-type"} :line [4 4]}
{:kind "Var" :name "c" :scope "global" :type {:kind "UnsignedInt-type"} :line [5 5]}
{:kind "Var" :name "d" :scope "global" :type {:kind "Long-type"} :line [6 6]}
{:kind "Var" :name "e" :scope "global" :type {:kind "Long-type"} :line [7 7]}
{:kind "Var" :name "f" :scope "global" :type {:kind "UnsignedLong-type"} :line [8 8]}
{:kind "Var" :name "g" :scope "global" :type {:kind "LongLong-type"} :line [9 9]}
{:kind "Var" :name "h" :scope "global" :type {:kind "LongLong-type"} :line [10 10]}
{:kind "Var" :name "i" :scope "global" :type {:kind "UnsigndLongLong-type"} :line [11 11]}
{:kind "Var" :name "j" :scope "global" :type {:kind "Short-type"} :line [12 12]}
{:kind "Var" :name "k" :scope "global" :type {:kind "Short-type"} :line [13 13]}
{:kind "Var" :name "l" :scope "global" :type {:kind "UnsignedShort-type"} :line [14 14]}
{:kind "Var" :name "m" :scope "global" :type {:kind "Double-type"} :line [16 16]}
{:kind "Var" :name "n" :scope "global" :type {:kind "Float-type"} :line [17 17]}
{:kind "Var" :name "o" :scope "global" :type {:kind "Char-type"} :line [19 19]}
{:kind "Var" :name "p" :scope "global" :type {:kind "SignedChar-type"} :line [20 20]}
{:kind "Var" :name "q" :scope "global" :type {:kind "UnsignedChar-type"} :line [21 21]}
{:kind "Var" :name "r" :scope "global" :type {:kind "LongDouble-type"} :line [23 23]}
{:kind "Var" :name "s" :scope "global" :type {:kind "Bool-type"} :line [31 25]}
{:kind "Var" :name "t" :scope "global" :type {:kind "Array-type" :ArraySize "100" :type {:kind "Int-type"}} :line [27 27]}
{:kind "Var" :name "u" :scope "global" :type {:kind "Pointer-type" :Pointee {:kind "Int-type"}} :line [28 28]}
{:kind "Var" :name "y" :scope "global" :type {:kind "Array-type" :ArraySize "21" :type {:kind "Array-type" :ArraySize "31" :type {:kind "Int-type"}}} :line [30 30]}
{:kind "Var" :name "z" :scope "global" :type {:kind "Array-type" :ArraySize "31" :type {:kind "Pointer-type" :Pointee {:kind "Int-type"}}} :line [31 31]}
{:kind "Var" :name "aa" :scope "global" :type {:kind "Pointer-type" :Pointee {:kind "Array-type" :ArraySize "31" :type {:kind "Int-type"}}} :line [32 32]}
{:kind "Var" :name "ab" :scope "global" :type {:kind "Array-type" :ArraySize "91" :type {:kind "Pointer-type" :Pointee {:kind "Pointer-type" :Pointee {:kind "Int-type"}}}} :line [33 33]}
{:kind "Uniondef" :name "" :line [35 41]
 :Member [{:kind "Field" :name "word" :scope "member" :type {:kind "UnsignedShort-type"} :line [36 36]}
{:kind "Field" :name "lohi" :scope "member" :type {:kind "Strucure-type" :name ""
 :member[{:kind "Field" :name "lo" :scope "member" :type {:kind "UnsignedChar-type"} :line [38 38]}
{:kind "Field" :name "hi" :scope "member" :type {:kind "UnsignedChar-type"} :line [39 39]}]} :line [37 40]}]}
{:kind "Structdef" :name "_person" :line [43 47]
 :Member [{:kind "Field" :name "name" :scope "member" :type {:kind "Array-type" :ArraySize "50" :type {:kind "Char-type"}} :line [44 44]}
{:kind "Field" :name "phone" :scope "member" :type {:kind "Array-type" :ArraySize "50" :type {:kind "Char-type"}} :line [45 45]}
{:kind "Field" :name "next" :scope "member" :type {:kind "Pointer-type" :Pointee {:kind "Strucure-type" :name "_person"}} :line [46 46]}]}
{:kind "Var" :name "ac" :scope "global" :type {:kind "Int-type" :const "true"} :line [49 49]}
{:kind "Var" :name "ad" :scope "global" :type {:kind "Double-type" :volatile "true"} :line [50 50]}
{:kind "Var" :name "ae" :scope "global" :type {:kind "Pointer-type" :const "true" :Pointee {:kind "Int-type" :const "true"}} :line [52 52]}
{:kind "Var" :name "af" :scope "global" :type {:kind "Pointer-type" :Pointee {:kind "Int-type" :const "true"}} :line [53 53]}
{:kind "Var" :name "ag" :scope "global" :type {:kind "Pointer-type" :Pointee {:kind "Int-type" :const "true"}} :line [54 54]}
{:kind "Var" :name "ah" :scope "global" :Static "true" :type {:kind "Int-type"} :line [56 56]}
{:kind "Var" :name "shinya" :scope "global" :type {:kind "Typedef-type" :typename "NAKAMURA" :type {:kind "Pointer-type" :Pointee {:kind "Int-type" :const "true"}}} :line [59 59]}
{:kind "Var" :name "ak" :scope "global" :Extern "true" :type {:kind "Int-type"} :line [61 61]}
{:kind "Var" :name "al" :scope "global" :Static "true" :type {:kind "Int-type"} :line [62 62]}
{:kind "Var" :name "an" :scope "global" :Static "true" :type {:kind "Int-type" :const "true"} :line [63 63]}
{:kind "Var" :name "ao" :scope "global" :type {:kind "Int-type" :volatile "true"} :line [64 64]}
{:kind "Funcdef" :name "func" :Static "true" :type {:kind "Int-type"} :line [66 70]
 :Parm [{:kind "Parm" :name "number1" :type {:kind "Int-type"} :line [66 66]}
{:kind "Parm" :name "number2" :type {:kind "Int-type"} :line [66 66]}]
 :body [{:kind "Var" :name "sum" :scope "local" :type {:kind "Int-type"} :line [67 67]}
{:kind "Binop" :op "=" :line [68 68]
 :LHS {:kind "DRE" :name "sum" :scope "local" :type {:kind "Int-type"} :line [68 68]}
 :RHS {:kind "Binop" :op "+" :line [68 68]
 :LHS {:kind "DRE" :name "number1" :scope "local" :type {:kind "Int-type"} :line [68 68]}
 :RHS {:kind "DRE" :name "number2" :scope "local" :type {:kind "Int-type"} :line [68 68]}}}
{:kind "Ret" :line [69 69] :value {:kind "DRE" :name "sum" :scope "local" :type {:kind "Int-type"} :line [69 69]}}]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [72 85]
 :Parm []
 :body [{:kind "Var" :name "ap" :scope "local" :Extern "true" :type {:kind "Int-type"} :line [73 73]}
{:kind "Var" :name "am" :scope "local" :Static "true" :type {:kind "Int-type"} :line [74 74]}
{:kind "Var" :name "ai" :scope "local" :Auto "true" :type {:kind "Int-type"} :line [75 75]}
{:kind "Var" :name "aj" :scope "local" :Register "true" :type {:kind "Int-type"} :line [76 76]}
{:kind "Var" :name "w" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Typedef-type" :typename "person" :type {:kind "Strucure-type" :name "_person"}}} :line [77 77]}
{:kind "Var" :name "x" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Typedef-type" :typename "person" :type {:kind "Strucure-type" :name "_person"}}} :line [77 77]}
{:kind "Var" :name "array1" :scope "local" :type {:kind "Array-type" :ArraySize "11" :type {:kind "Int-type"}} :line [79 79]}
{:kind "Binop" :op "=" :line [80 80]
 :LHS {:kind "DRE" :name "ah" :scope "global" :Static "true" :type {:kind "Int-type"} :line [80 80]}
 :RHS {:kind "IntegerLiteral" :value "22" :type {:kind "Int-type"} :line [80 80]}}
{:kind "Var" :name "array" :scope "local" :type {:kind "Array-type" :ArraySizeExpression {:kind "DRE" :name "ah" :scope "global" :Static "true" :type {:kind "Int-type"} :line [81 81]} :type {:kind "Int-type"}} :line [81 81]}
{:kind "FuncCall" :line [83 83] :type {:kind "Int-type"}
 :Func {:kind "DRE" :name "func" :Static "true" :line [83 83]}
 :Parm [{:kind "IntegerLiteral" :value "17320508" :type {:kind "Int-type"} :line [83 83]}{:kind "IntegerLiteral" :value "141421356" :type {:kind "Int-type"} :line [83 83]}]}
{:kind "Ret" :line [84 84] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [84 84]}}]}] 

