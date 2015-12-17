
[{:kind "Var" :name "x" :scope "global" :type {:kind "Int-type"} :line [1 1]}
{:kind "Funcdef" :name "func" :type {:kind "Int-type"} :line [3 7]
 :Parm [{:kind "Parm" :name "a" :type {:kind "Int-type"} :line [3 3]}]
 :body [{:kind "Binop" :op "=" :line [4 4]
 :LHS {:kind "DRE" :name "x" :scope "global" :type {:kind "Int-type"} :line [4 4]}
 :RHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [4 4]}}
{:kind "Ret" :line [6 6] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [6 6]}}]}
{:kind "Funcdef" :name "function" :type {:kind "Int-type"} :line [9 12]
 :Parm [{:kind "Parm" :name "a" :type {:kind "Int-type"} :line [9 9]}
{:kind "Parm" :name "b" :type {:kind "Int-type"} :line [9 9]}]
 :body [{:kind "Binop" :op "=" :line [10 10]
 :LHS {:kind "DRE" :name "x" :scope "global" :type {:kind "Int-type"} :line [10 10]}
 :RHS {:kind "Binop" :op "+" :line [10 10]
 :LHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [10 10]}
 :RHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [10 10]}}}
{:kind "Ret" :line [11 11] :value {:kind "DRE" :name "x" :scope "global" :type {:kind "Int-type"} :line [11 11]}}]}
{:kind "Funcdef" :name "funcsion" :type {:kind "Int-type"} :line [14 16]
 :Parm [{:kind "Parm" :name "str" :type {:kind "Char-type"} :line [14 14]}]
 :body [{:kind "Ret" :line [15 15] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [15 15]}}]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [18 26]
 :Parm []
 :body [{:kind "Var" :name "s" :scope "local" :type {:kind "Int-type"} :line [19 19]
 :init {:kind "IntegerLiteral" :value "10" :type {:kind "Int-type"} :line [19 19]}}
{:kind "Var" :name "t" :scope "local" :type {:kind "Int-type"} :line [19 19]
 :init {:kind "IntegerLiteral" :value "50" :type {:kind "Int-type"} :line [19 19]}}
{:kind "Binop" :op "=" :line [21 21]
 :LHS {:kind "DRE" :name "s" :scope "local" :type {:kind "Int-type"} :line [21 21]}
 :RHS {:kind "FuncCall" :line [21 21] :type {:kind "Int-type"}
 :Func {:kind "DRE" :name "function" :line [21 21]}
 :Parm [{:kind "DRE" :name "s" :scope "local" :type {:kind "Int-type"} :line [21 21]}
{:kind "DRE" :name "t" :scope "local" :type {:kind "Int-type"} :line [21 21]}]}}
{:kind "Binop" :op "=" :line [22 22]
 :LHS {:kind "DRE" :name "s" :scope "local" :type {:kind "Int-type"} :line [22 22]}
 :RHS {:kind "Binop" :op "+" :line [22 22]
 :LHS {:kind "DRE" :name "s" :scope "local" :type {:kind "Int-type"} :line [22 22]}
 :RHS {:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [22 22]}}}
{:kind "FuncCall" :line [23 23] :type {:kind "Int-type"}
 :Func {:kind "DRE" :name "func" :line [23 23]}
 :Parm [{:kind "DRE" :name "s" :scope "local" :type {:kind "Int-type"} :line [23 23]}]}
{:kind "Ret" :line [25 25] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [25 25]}}]}] 

