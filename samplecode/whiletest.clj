
[{:kind "Var" :name "x" :scope "global" :type {:kind "Int-type"} :line [2 2]
 :init {:kind "IntegerLiteral" :value "10" :type {:kind "Int-type"} :line [2 2]}}
{:kind "Var" :name "y" :scope "global" :type {:kind "Int-type"} :line [3 3]
 :init {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [3 3]}}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [5 18]
 :Parm []
 :body [{:kind "Var" :name "sum" :scope "local" :type {:kind "Double-type"} :line [6 6]}
{:kind "While" :line [7 11]
 :condition {:kind "Binop" :op ">" :line [7 7]
 :LHS {:kind "DRE" :name "x" :scope "global" :type {:kind "Int-type"} :line [7 7]}
 :RHS {:kind "IntegerLiteral" :value "5" :type {:kind "Int-type"} :line [7 7]}}
 :body [{:kind "Binop" :op "=" :line [8 8]
 :LHS {:kind "DRE" :name "sum" :scope "local" :type {:kind "Double-type"} :line [8 8]}
 :RHS {:kind "Binop" :op "+" :line [8 8]
 :LHS {:kind "DRE" :name "x" :scope "global" :type {:kind "Int-type"} :line [8 8]}
 :RHS {:kind "DRE" :name "y" :scope "global" :type {:kind "Int-type"} :line [8 8]}}}
{:kind "Unop" :op "++" :line [9 9] :HS {:kind "DRE" :name "y" :scope "global" :type {:kind "Int-type"} :line [9 9]}}
{:kind "Unop" :op "--" :line [10 10] :HS {:kind "DRE" :name "x" :scope "global" :type {:kind "Int-type"} :line [10 10]}}]}
{:kind "Do" :line [13 15]
 :condition {:kind "Binop" :op "!=" :line [15 15]
 :LHS {:kind "DRE" :name "sum" :scope "local" :type {:kind "Double-type"} :line [15 15]}
 :RHS {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [15 15]}}
 :body [{:kind "Unop" :op "--" :line [14 14] :HS {:kind "DRE" :name "sum" :scope "local" :type {:kind "Double-type"} :line [14 14]}}]}
{:kind "Ret" :line [17 17] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [17 17]}}]}] 

