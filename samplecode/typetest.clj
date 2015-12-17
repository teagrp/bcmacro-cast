
[{:kind "Var" :name "x" :scope "global" :type {:kind "Int-type"} :line [1 1]}
{:kind "Var" :name "y" :scope "global" :type {:kind "Double-type"} :line [2 2]}
{:kind "Var" :name "c" :scope "global" :type {:kind "Char-type"} :line [3 3]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [5 11]
 :Parm []
 :body [{:kind "Binop" :op "=" :line [6 6]
 :LHS {:kind "DRE" :name "x" :scope "global" :type {:kind "Int-type"} :line [6 6]}
 :RHS {:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [6 6]}}
{:kind "Binop" :op "=" :line [7 7]
 :LHS {:kind "DRE" :name "y" :scope "global" :type {:kind "Double-type"} :line [7 7]}
 :RHS {:kind "FloatingLiteral" :value "1.000000e+02" :type {:kind "Double-type"} :line [7 7]}}
{:kind "Binop" :op "=" :line [8 8]
 :LHS {:kind "DRE" :name "c" :scope "global" :type {:kind "Char-type"} :line [8 8]}
 :RHS {:kind "CharacterLiteral" :value "99" :character "c" :type {:kind "Int-type"} :line [8 8]}}
{:kind "Ret" :line [10 10] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [10 10]}}]}] 

