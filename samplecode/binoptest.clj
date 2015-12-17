
[{:kind "Var" :name "a" :scope "global" :type {:kind "Int-type"} :line [1 1]
 :init {:kind "IntegerLiteral" :value "10" :type {:kind "Int-type"} :line [1 1]}}
{:kind "Var" :name "b" :scope "global" :type {:kind "Int-type"} :line [2 2]
 :init {:kind "IntegerLiteral" :value "200" :type {:kind "Int-type"} :line [2 2]}}
{:kind "Var" :name "c" :scope "global" :type {:kind "Int-type"} :line [3 3]
 :init {:kind "IntegerLiteral" :value "500" :type {:kind "Int-type"} :line [3 3]}}
{:kind "Funcdef" :name "sum" :type {:kind "Int-type"} :line [4 8]
 :Parm []
 :body [{:kind "Ret" :line [6 6] :value {:kind "Binop" :op "+" :line [6 6]
 :LHS {:kind "Binop" :op "+" :line [6 6]
 :LHS {:kind "DRE" :name "a" :scope "global" :type {:kind "Int-type"} :line [6 6]}
 :RHS {:kind "DRE" :name "b" :scope "global" :type {:kind "Int-type"} :line [6 6]}}
 :RHS {:kind "DRE" :name "c" :scope "global" :type {:kind "Int-type"} :line [6 6]}}}]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [10 17]
 :Parm []
 :body [{:kind "Var" :name "x" :scope "local" :type {:kind "Int-type"} :line [11 11]
 :init {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [11 11]}}
{:kind "While" :line [12 14]
 :condition {:kind "Binop" :op "<" :line [12 12]
 :LHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [12 12]}
 :RHS {:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [12 12]}}
 :body [{:kind "Binop" :op "+=" :line [13 13]
 :LHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [13 13]}
 :RHS {:kind "DRE" :name "a" :scope "global" :type {:kind "Int-type"} :line [13 13]}}]}
{:kind "Ret" :line [16 16] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [16 16]}}]}] 

