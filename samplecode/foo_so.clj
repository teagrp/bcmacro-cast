
[{:kind "Funcdef" :name "foo" :type {:kind "Int-type"} :line [1 6]
 :Parm []
 :body [{:kind "Var" :name "val_1" :scope "local" :type {:kind "Int-type"} :line [2 2]
 :init {:kind "IntegerLiteral" :value "11" :type {:kind "Int-type"} :line [2 2]}}
{:kind "Var" :name "val_2" :scope "local" :type {:kind "Int-type"} :line [3 3]
 :init {:kind "IntegerLiteral" :value "2" :type {:kind "Int-type"} :line [3 3]}}
{:kind "Ret" :line [5 5] :value {:kind "Binop" :op "+" :line [5 5]
 :LHS {:kind "DRE" :name "val_1" :scope "local" :type {:kind "Int-type"} :line [5 5]}
 :RHS {:kind "DRE" :name "val_2" :scope "local" :type {:kind "Int-type"} :line [5 5]}}}]}] 

