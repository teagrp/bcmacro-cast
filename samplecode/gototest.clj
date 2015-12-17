
[{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [2 13]
 :Parm []
 :body [{:kind "Var" :name "x" :scope "local" :type {:kind "Int-type"} :line [3 3]
 :init {:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [3 3]}}
{:kind "Var" :name "y" :scope "local" :type {:kind "Int-type"} :line [4 4]
 :init {:kind "IntegerLiteral" :value "200" :type {:kind "Int-type"} :line [4 4]}}
{:kind "Binop" :op "=" :line [9 9] :label [{:kind "Label" :line [6 9] :name "lavel0"}{:kind "Label" :line [7 9] :name "lavel1"}{:kind "Label" :line [8 9] :name "lavel2"}]
 :LHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [9 9]}
 :RHS {:kind "Binop" :op "+" :line [9 9]
 :LHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [9 9]}
 :RHS {:kind "DRE" :name "y" :scope "local" :type {:kind "Int-type"} :line [9 9]}}}
{:kind "If" :line [10 10]
 :condition {:kind "Binop" :op "<" :line [10 10]
 :LHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [10 10]}
 :RHS {:kind "IntegerLiteral" :value "500" :type {:kind "Int-type"} :line [10 10]}}
 :then [{:kind "Goto" :line [10 10] :goto "lavel1"}]}
{:kind "Ret" :line [12 12] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [12 12]}}]}] 

