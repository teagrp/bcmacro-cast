
[{:kind "Var" :name "x" :scope "global" :type {:kind "Int-type"} :line [1 1]
 :init {:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [1 1]}}
{:kind "Var" :name "y" :scope "global" :Static "true" :type {:kind "Char-type"} :line [2 2]}
{:kind "Funcdef" :name "fu" :type {:kind "Int-type"} :line [4 8]
 :Parm [{:kind "Parm" :name "a" :type {:kind "Int-type"} :line [4 4]}
{:kind "Parm" :name "b" :type {:kind "Int-type"} :line [4 4]}]
 :body [{:kind "Var" :name "sum" :scope "local" :type {:kind "Int-type"} :line [5 5]}
{:kind "Binop" :op "=" :line [6 6]
 :LHS {:kind "DRE" :name "sum" :scope "local" :type {:kind "Int-type"} :line [6 6]}
 :RHS {:kind "Binop" :op "+" :line [6 6]
 :LHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [6 6]}
 :RHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [6 6]}}}
{:kind "Ret" :line [7 7] :value {:kind "DRE" :name "sum" :scope "local" :type {:kind "Int-type"} :line [7 7]}}]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [10 15]
 :Parm []
 :body [{:kind "Var" :name "a" :scope "local" :Static "true" :type {:kind "Int-type"} :line [11 11]
 :init {:kind "IntegerLiteral" :value "50" :type {:kind "Int-type"} :line [11 11]}}
{:kind "Var" :name "b" :scope "local" :type {:kind "Int-type"} :line [12 12]
 :init {:kind "IntegerLiteral" :value "300" :type {:kind "Int-type"} :line [12 12]}}
{:kind "FuncCall" :line [13 13] :type {:kind "Int-type"}
 :Func {:kind "DRE" :name "fu" :line [13 13]}
 :Parm [{:kind "DRE" :name "a" :scope "local" :Static "true" :type {:kind "Int-type"} :line [13 13]}
{:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [13 13]}]}
{:kind "Ret" :line [14 14] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [14 14]}}]}] 

