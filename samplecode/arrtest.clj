
[{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [1 18]
 :Parm []
 :body [{:kind "Var" :name "num" :scope "local" :type {:kind "Int-type"} :line [2 2]
 :init {:kind "IntegerLiteral" :value "9" :type {:kind "Int-type"} :line [2 2]}}
{:kind "Var" :name "array" :scope "local" :type {:kind "Array-type" :ArraySizeExpression {:kind "DRE" :name "num" :scope "local" :type {:kind "Int-type"} :line [3 3]} :type {:kind "Int-type"}} :line [3 3]}
{:kind "Var" :name "arr1" :scope "local" :type {:kind "Array-type" :ArraySize "4" :type {:kind "Int-type"}} :line [4 4]
 :init [{:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [4 4]}{:kind "IntegerLiteral" :value "2" :type {:kind "Int-type"} :line [4 4]}{:kind "IntegerLiteral" :value "2" :type {:kind "Int-type"} :line [4 4]}{:kind "IntegerLiteral" :value "3" :type {:kind "Int-type"} :line [4 4]}]}
{:kind "Var" :name "arr2" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Int-type"}} :line [5 5]}
{:kind "Var" :name "arr11" :scope "local" :type {:kind "Array-type" :ArraySize "2" :type {:kind "Array-type" :ArraySize "5" :type {:kind "Int-type"}}} :line [6 6]
 :init [
[{:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "2" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "2" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "6" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "9" :type {:kind "Int-type"} :line [6 6]}]
[{:kind "IntegerLiteral" :value "3" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "4" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "6" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "7" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [6 6]}]]}
{:kind "Var" :name "arr21" :scope "local" :type {:kind "Array-type" :ArraySize "3" :type {:kind "Array-type" :ArraySize "7" :type {:kind "Int-type"}}} :line [7 7]}
{:kind "Var" :name "arr111" :scope "local" :type {:kind "Array-type" :ArraySize "4" :type {:kind "Array-type" :ArraySize "7" :type {:kind "Array-type" :ArraySize "3" :type {:kind "Int-type"}}}} :line [8 8]}
{:kind "Var" :name "a" :scope "local" :type {:kind "Int-type"} :line [9 9]}
{:kind "Var" :name "b" :scope "local" :type {:kind "Int-type"} :line [9 9]}
{:kind "Binop" :op "=" :line [12 12]
 :LHS {:kind "ArrayRef" :line [12 12]
 :Array {:kind "DRE" :name "array" :scope "local" :type {:kind "Array-type" :ArraySizeExpression {:kind "DRE" :name "num" :scope "local" :type {:kind "Int-type"} :line [3 3]} :type {:kind "Int-type"}} :line [12 12]}
 :Index {:kind "IntegerLiteral" :value "3" :type {:kind "Int-type"} :line [12 12]}}
 :RHS {:kind "IntegerLiteral" :value "1234" :type {:kind "Int-type"} :line [12 12]}}
{:kind "Binop" :op "=" :line [13 13]
 :LHS {:kind "ArrayRef" :line [13 13]
 :Array {:kind "DRE" :name "arr2" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Int-type"}} :line [13 13]}
 :Index {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [13 13]}}
 :RHS {:kind "IntegerLiteral" :value "777" :type {:kind "Int-type"} :line [13 13]}}
{:kind "Binop" :op "=" :line [14 14]
 :LHS {:kind "ArrayRef" :line [14 14]
 :Array {:kind "ArrayRef" :line [14 14]
 :Array {:kind "DRE" :name "arr21" :scope "local" :type {:kind "Array-type" :ArraySize "3" :type {:kind "Array-type" :ArraySize "7" :type {:kind "Int-type"}}} :line [14 14]}
 :Index {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [14 14]}}
 :Index {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [14 14]}}
 :RHS {:kind "IntegerLiteral" :value "345" :type {:kind "Int-type"} :line [14 14]}}
{:kind "Binop" :op "=" :line [15 15]
 :LHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [15 15]}
 :RHS {:kind "ArrayRef" :line [15 15]
 :Array {:kind "DRE" :name "arr1" :scope "local" :type {:kind "Array-type" :ArraySize "4" :type {:kind "Int-type"}} :line [15 15]}
 :Index {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [15 15]}}}
{:kind "Ret" :line [17 17] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [17 17]}}]}] 

