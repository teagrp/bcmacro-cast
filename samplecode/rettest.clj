
[{:kind "Var" :name "x" :scope "global" :type {:kind "Int-type"} :line [1 1]
 :init {:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [1 1]}}
{:kind "Funcdef" :name "sum" :type {:kind "Int-type"} :line [3 5]
 :Parm [{:kind "Parm" :name "a" :type {:kind "Int-type"} :line [3 3]}
{:kind "Parm" :name "b" :type {:kind "Int-type"} :line [3 3]}]
 :body [{:kind "Ret" :line [4 4] :value {:kind "Binop" :op "+" :line [4 4]
 :LHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [4 4]}
 :RHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [4 4]}}}]}
{:kind "Funcdef" :name "summer" :type {:kind "Void-type"} :line [7 10]
 :Parm []
 :body [{:kind "FuncCall" :line [8 8] :type {:kind "Int-type"}
 :Func {:kind "DRE" :name "sum" :line [8 8]}
 :Parm [{:kind "DRE" :name "x" :scope "global" :type {:kind "Int-type"} :line [8 8]}
{:kind "DRE" :name "x" :scope "global" :type {:kind "Int-type"} :line [8 8]}]}
{:kind "Ret" :line [9 9]}]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [12 20]
 :Parm []
 :body [{:kind "Var" :name "y" :scope "local" :type {:kind "Int-type"} :line [13 13]}
{:kind "For" :line [14 16]
 :init [{:kind "Binop" :op "=" :line [14 14]
 :LHS {:kind "DRE" :name "y" :scope "local" :type {:kind "Int-type"} :line [14 14]}
 :RHS {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [14 14]}}]
 :condition {:kind "Binop" :op "<" :line [14 14]
 :LHS {:kind "DRE" :name "y" :scope "local" :type {:kind "Int-type"} :line [14 14]}
 :RHS {:kind "IntegerLiteral" :value "10" :type {:kind "Int-type"} :line [14 14]}}
 :update [{:kind "Unop" :op "++" :line [14 14] :HS {:kind "DRE" :name "y" :scope "local" :type {:kind "Int-type"} :line [14 14]}}]
 :body [{:kind "FuncCall" :line [15 15] :type {:kind "Int-type"}
 :Func {:kind "DRE" :name "sum" :line [15 15]}
 :Parm [{:kind "DRE" :name "x" :scope "global" :type {:kind "Int-type"} :line [15 15]}
{:kind "DRE" :name "y" :scope "local" :type {:kind "Int-type"} :line [15 15]}]}]}
{:kind "Ret" :line [19 19] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [19 19]}}]}] 

