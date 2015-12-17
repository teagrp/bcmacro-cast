
[{:kind "Funcdef" :name "abc" :type {:kind "Void-type"} :line [1 5]
 :Parm []
 :body [{:kind "Var" :name "a" :scope "local" :type {:kind "Int-type"} :line [2 2]}
{:kind "Var" :name "b" :scope "local" :type {:kind "Int-type"} :line [2 2]}
{:kind "Var" :name "c" :scope "local" :type {:kind "Int-type"} :line [2 2]}
{:kind "Var" :name "sum" :scope "local" :type {:kind "Int-type"} :line [3 3]}
{:kind "Binop" :op "=" :line [4 4]
 :LHS {:kind "DRE" :name "sum" :scope "local" :type {:kind "Int-type"} :line [4 4]}
 :RHS {:kind "Binop" :op "-" :line [4 4]
 :LHS {:kind "Binop" :op "+" :line [4 4]
 :LHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Int-type"} :line [4 4]}
 :RHS {:kind "DRE" :name "b" :scope "local" :type {:kind "Int-type"} :line [4 4]}}
 :RHS {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [4 4]}}}]}] 

