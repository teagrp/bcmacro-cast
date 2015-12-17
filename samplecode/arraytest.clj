
[{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [1 31]
 :Parm []
 :body [{:kind "Var" :name "a" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Int-type"}} :line [2 2]}
{:kind "Var" :name "b" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Int-type"}} :line [3 12]
 :init [{:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [3 3]}{:kind "IntegerLiteral" :value "2" :type {:kind "Int-type"} :line [4 4]}{:kind "IntegerLiteral" :value "3" :type {:kind "Int-type"} :line [5 5]}{:kind "IntegerLiteral" :value "4" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "5" :type {:kind "Int-type"} :line [7 7]}{:kind "IntegerLiteral" :value "6" :type {:kind "Int-type"} :line [8 8]}{:kind "IntegerLiteral" :value "7" :type {:kind "Int-type"} :line [9 9]}{:kind "IntegerLiteral" :value "8" :type {:kind "Int-type"} :line [10 10]}{:kind "IntegerLiteral" :value "9" :type {:kind "Int-type"} :line [11 11]}{:kind "IntegerLiteral" :value "10" :type {:kind "Int-type"} :line [12 12]}]}
{:kind "Var" :name "d" :scope "local" :type {:kind "Array-type" :ArraySize "15" :type {:kind "Int-type"}} :line [13 13]}
{:kind "Var" :name "f" :scope "local" :type {:kind "Array-type" :ArraySize "15" :type {:kind "Int-type"}} :line [14 14]}
{:kind "Var" :name "c" :scope "local" :type {:kind "Array-type" :ArraySize "20" :type {:kind "Char-type"}} :line [15 15]}
{:kind "Var" :name "e" :scope "local" :type {:kind "Array-type" :ArraySize "30" :type {:kind "Char-type"}} :line [16 16]}
{:kind "Var" :name "i" :scope "local" :type {:kind "Int-type"} :line [17 17]
 :init {:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [17 17]}}
{:kind "Var" :name "p" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Int-type"}} :line [18 18]}
{:kind "Var" :name "g" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Int-type"}}} :line [19 19]}
{:kind "Binop" :op "=" :line [21 21]
 :LHS {:kind "ArrayRef" :line [21 21]
 :Array {:kind "DRE" :name "d" :scope "local" :type {:kind "Array-type" :ArraySize "15" :type {:kind "Int-type"}} :line [21 21]}
 :Index {:kind "IntegerLiteral" :value "2" :type {:kind "Int-type"} :line [21 21]}}
 :RHS {:kind "IntegerLiteral" :value "13" :type {:kind "Int-type"} :line [21 21]}}
{:kind "Binop" :op "=" :line [22 22]
 :LHS {:kind "ArrayRef" :line [22 22]
 :Array {:kind "DRE" :name "f" :scope "local" :type {:kind "Array-type" :ArraySize "15" :type {:kind "Int-type"}} :line [22 22]}
 :Index {:kind "IntegerLiteral" :value "9" :type {:kind "Int-type"} :line [22 22]}}
 :RHS {:kind "IntegerLiteral" :value "22222" :type {:kind "Int-type"} :line [22 22]}}
{:kind "For" :line [23 26]
 :init [{:kind "Binop" :op "=" :line [23 23]
 :LHS {:kind "DRE" :name "i" :scope "local" :type {:kind "Int-type"} :line [23 23]}
 :RHS {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [23 23]}}]
 :condition {:kind "Binop" :op "<" :line [23 23]
 :LHS {:kind "DRE" :name "i" :scope "local" :type {:kind "Int-type"} :line [23 23]}
 :RHS {:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [23 23]}}
 :update [{:kind "Unop" :op "++" :line [23 23] :HS {:kind "DRE" :name "i" :scope "local" :type {:kind "Int-type"} :line [23 23]}}]
 :body [{:kind "Binop" :op "=" :line [24 24]
 :LHS {:kind "ArrayRef" :line [24 24]
 :Array {:kind "DRE" :name "a" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Int-type"}} :line [24 24]}
 :Index {:kind "IntegerLiteral" :value "5" :type {:kind "Int-type"} :line [24 24]}}
 :RHS {:kind "DRE" :name "i" :scope "local" :type {:kind "Int-type"} :line [24 24]}}
{:kind "Binop" :op "=" :line [25 25]
 :LHS {:kind "ArrayRef" :line [25 25]
 :Array {:kind "DRE" :name "b" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Int-type"}} :line [25 25]}
 :Index {:kind "DRE" :name "i" :scope "local" :type {:kind "Int-type"} :line [25 25]}}
 :RHS {:kind "Binop" :op "+" :line [25 25]
 :LHS {:kind "DRE" :name "i" :scope "local" :type {:kind "Int-type"} :line [25 25]}
 :RHS {:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [25 25]}}}]}
{:kind "Binop" :op "=" :line [27 27]
 :LHS {:kind "ArrayRef" :line [27 27]
 :Array {:kind "ArrayRef" :line [27 27]
 :Array {:kind "DRE" :name "g" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Int-type"}}} :line [27 27]}
 :Index {:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [27 27]}}
 :Index {:kind "IntegerLiteral" :value "5" :type {:kind "Int-type"} :line [27 27]}}
 :RHS {:kind "IntegerLiteral" :value "11" :type {:kind "Int-type"} :line [27 27]}}
{:kind "Binop" :op "=" :line [28 28]
 :LHS {:kind "ArrayRef" :line [28 28]
 :Array {:kind "DRE" :name "d" :scope "local" :type {:kind "Array-type" :ArraySize "15" :type {:kind "Int-type"}} :line [28 28]}
 :Index {:kind "IntegerLiteral" :value "3" :type {:kind "Int-type"} :line [28 28]}}
 :RHS {:kind "ArrayRef" :line [28 28]
 :Array {:kind "DRE" :name "a" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Int-type"}} :line [28 28]}
 :Index {:kind "ArrayRef" :line [28 28]
 :Array {:kind "DRE" :name "b" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Int-type"}} :line [28 28]}
 :Index {:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [28 28]}}}}
{:kind "Ret" :line [30 30] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [30 30]}}]}] 

