
[{:kind "Funcdef" :name "abc" :type {:kind "Int-type"} :line [1 3]
 :Parm [{:kind "Parm" :name "a" :type {:kind "Int-type"} :line [1 1]}
{:kind "Parm" :name "b" :type {:kind "Int-type"} :line [1 1]}
{:kind "Parm" :name "c" :type {:kind "Int-type"} :line [1 1]}]
 :body [{:kind "Ret" :line [2 2] :value {:kind "Binop" :op "-" :line [2 2]
 :LHS {:kind "Binop" :op "+" :line [2 2]
 :LHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [2 2]}
 :RHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [2 2]}}
 :RHS {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [2 2]}}}]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [5 9]
 :Parm []
 :body [{:kind "FuncCall" :line [6 6] :type {:kind "Int-type"}
 :Func {:kind "DRE" :name "abc" :line [6 6]}
 :Parm [{:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "50" :type {:kind "Int-type"} :line [6 6]}{:kind "IntegerLiteral" :value "120" :type {:kind "Int-type"} :line [6 6]}]}
{:kind "Ret" :line [8 8] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [8 8]}}]}] 

