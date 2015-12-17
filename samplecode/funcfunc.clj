
[{:kind "Funcdef" :name "sum" :type {:kind "Int-type"} :line [1 20]
 :Parm [{:kind "Parm" :name "num" :type {:kind "Int-type"} :line [1 1]}]
 :body [{:kind "Var" :name "sum" :scope "local" :type {:kind "Int-type"} :line [2 2]}
{:kind "While" :line [3 6]
 :condition {:kind "Binop" :op "!=" :line [3 3]
 :LHS {:kind "DRE" :name "num" :scope "local" :type {:kind "Int-type"} :line [3 3]}
 :RHS {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [3 3]}}
 :body [{:kind "Binop" :op "+=" :line [4 4]
 :LHS {:kind "DRE" :name "sum" :scope "local" :type {:kind "Int-type"} :line [4 4]}
 :RHS {:kind "DRE" :name "num" :scope "local" :type {:kind "Int-type"} :line [4 4]}}
{:kind "Unop" :op "--" :line [5 5] :HS {:kind "DRE" :name "num" :scope "local" :type {:kind "Int-type"} :line [5 5]}}]}
{:kind "Funcdef" :name "sumsum" :type {:kind "Int-type"} :line [8 8]
 :Parm [{:kind "Parm" :name "sum" :type {:kind "Int-type"} :line [8 8]}]
 :body []}]}{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [22 26]
 :Parm []
 :body [{:kind "Var" :name "num" :scope "local" :type {:kind "Int-type"} :line [23 23]
 :init {:kind "IntegerLiteral" :value "10" :type {:kind "Int-type"} :line [23 23]}}
{:kind "FuncCall" :line [24 24] :type {:kind "Int-type"}
 :Func {:kind "DRE" :name "sum" :line [24 24]}
 :Parm [{:kind "DRE" :name "num" :scope "local" :type {:kind "Int-type"} :line [24 24]}]}
{:kind "Ret" :line [25 25] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [25 25]}}]}] 

