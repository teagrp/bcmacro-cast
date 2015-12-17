
[{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [2 15]
 :Parm []
 :body [{:kind "Var" :name "a" :scope "local" :type {:kind "Int-type"} :line [3 3]}
{:kind "Var" :name "b" :scope "local" :type {:kind "Int-type"} :line [3 3]}
{:kind "Var" :name "c" :scope "local" :type {:kind "Int-type"} :line [3 3]}
{:kind "Binop" :op "=" :line [5 5]
 :LHS {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [5 5]}
 :RHS {:kind "IntegerLiteral" :value "20" :type {:kind "Int-type"} :line [5 5]}}
{:kind "For" :line [6 8]
 :init [{:kind "Binop" :op "," :line [6 6]
 :LHS {:kind "Binop" :op "=" :line [6 6]
 :LHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [6 6]}
 :RHS {:kind "IntegerLiteral" :value "10" :type {:kind "Int-type"} :line [6 6]}}
 :RHS {:kind "Binop" :op "=" :line [6 6]
 :LHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [6 6]}
 :RHS {:kind "IntegerLiteral" :value "50" :type {:kind "Int-type"} :line [6 6]}}}]
 :condition {:kind "Binop" :op "<=" :line [6 6]
 :LHS {:kind "Binop" :op "+" :line [6 6]
 :LHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [6 6]}
 :RHS {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [6 6]}}
 :RHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [6 6]}}
 :update [{:kind "Binop" :op "," :line [6 6]
 :LHS {:kind "Unop" :op "++" :line [6 6] :HS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [6 6]}}
 :RHS {:kind "Unop" :op "++" :line [6 6] :HS {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [6 6]}}}]
 :body [{:kind "Binop" :op "=" :line [7 7]
 :LHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [7 7]}
 :RHS {:kind "Binop" :op "+" :line [7 7]
 :LHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [7 7]}
 :RHS {:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [7 7]}}}]}
{:kind "Binop" :op "=" :line [9 9]
 :LHS {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [9 9]}
 :RHS {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [9 9]}}
{:kind "For" :line [10 12]
 :init [{:kind "Binop" :op "=" :line [10 10]
 :LHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [10 10]}
 :RHS {:kind "IntegerLiteral" :value "50" :type {:kind "Int-type"} :line [10 10]}}]
 :condition {:kind "Binop" :op "<" :line [10 10]
 :LHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [10 10]}
 :RHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [10 10]}}
 :update [{:kind "Unop" :op "++" :line [10 10] :HS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [10 10]}}]
 :body [{:kind "Unop" :op "++" :line [11 11] :HS {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [11 11]}}]}
{:kind "Ret" :line [14 14] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [14 14]}}]}] 

