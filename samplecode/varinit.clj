
[{:kind "Var" :name "x" :scope "global" :type {:kind "Int-type"} :line [1 1]
 :init {:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [1 1]}}
{:kind "Var" :name "y" :scope "global" :type {:kind "Double-type"} :line [2 2]
 :init {:kind "FloatingLiteral" :value "5.000000e+01" :type {:kind "Double-type"} :line [2 2]}}
{:kind "Var" :name "c" :scope "global" :type {:kind "Char-type"} :line [3 3]
 :init {:kind "CharacterLiteral" :value "67" :character "C" :type {:kind "Int-type"} :line [3 3]}}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [5 15]
 :Parm []
 :body [{:kind "Var" :name "z" :scope "local" :type {:kind "Int-type"} :line [6 6]}
{:kind "Var" :name "a" :scope "local" :type {:kind "Double-type"} :line [7 7]}
{:kind "Var" :name "d" :scope "local" :type {:kind "Char-type"} :line [8 8]}
{:kind "Binop" :op "=" :line [10 10]
 :LHS {:kind "DRE" :name "z" :scope "local" :type {:kind "Int-type"} :line [10 10]}
 :RHS {:kind "IntegerLiteral" :value "500" :type {:kind "Int-type"} :line [10 10]}}
{:kind "Binop" :op "=" :line [11 11]
 :LHS {:kind "DRE" :name "a" :scope "local" :type {:kind "Double-type"} :line [11 11]}
 :RHS {:kind "FloatingLiteral" :value "1.000000e+02" :type {:kind "Double-type"} :line [11 11]}}
{:kind "Binop" :op "=" :line [12 12]
 :LHS {:kind "DRE" :name "d" :scope "local" :type {:kind "Char-type"} :line [12 12]}
 :RHS {:kind "CharacterLiteral" :value "100" :character "d" :type {:kind "Int-type"} :line [12 12]}}
{:kind "Ret" :line [14 14] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [14 14]}}]}] 

