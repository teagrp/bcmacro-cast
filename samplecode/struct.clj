
[{:kind "Structdef" :name "dekinai" :line [1 7]
 :Member [{:kind "Field" :name "name" :scope "member" :type {:kind "Array-type" :ArraySize "20" :type {:kind "Char-type"}} :line [2 2]}
{:kind "Field" :name "sex" :scope "member" :type {:kind "Char-type"} :line [3 3]}
{:kind "Field" :name "age" :scope "member" :type {:kind "Int-type"} :line [4 4]}
{:kind "Field" :name "height" :scope "member" :type {:kind "Double-type"} :line [5 5]}
{:kind "Field" :name "weight" :scope "member" :type {:kind "Double-type"} :line [6 6]}]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [10 18]
 :Parm []
 :body [{:kind "Var" :name "p" :scope "local" :type {:kind "Typedef-type" :typename "person_t" :type {:kind "Strucure-type" :name "dekinai"}} :line [11 11]
 :init [
{:kind "StringLiteral" :value "Tom" :type {:kind "Array-type" :ArraySize "20" :type {:kind "Char-type"}} :line [11 11]}{:kind "CharacterLiteral" :value "77" :character "M" :type {:kind "Int-type"} :line [11 11]}{:kind "IntegerLiteral" :value "19" :type {:kind "Int-type"} :line [11 11]}
{:kind "FloatingLiteral" :value "1.752000e+02" :type {:kind "Double-type"} :line [11 11]}
{:kind "FloatingLiteral" :value "6.950000e+01" :type {:kind "Double-type"} :line [11 11]}]}
{:kind "Unop" :op "++" :line [13 13] :HS 
{:kind "DRE" :name "p" :scope "local" :type {:kind "Typedef-type" :typename "person_t" :type {:kind "Strucure-type" :name "dekinai"}} :line [13 13]}}{:kind "Binop" :op "+=" :line [14 14]
 :LHS 
{:kind "DRE" :name "p" :scope "local" :type {:kind "Typedef-type" :typename "person_t" :type {:kind "Strucure-type" :name "dekinai"}} :line [14 14]}
 :RHS {:kind "FloatingLiteral" :value "7.000000e-01" :type {:kind "Double-type"} :line [14 14]}}{:kind "Binop" :op "-=" :line [15 15]
 :LHS 
{:kind "DRE" :name "p" :scope "local" :type {:kind "Typedef-type" :typename "person_t" :type {:kind "Strucure-type" :name "dekinai"}} :line [15 15]}
 :RHS {:kind "FloatingLiteral" :value "1.500000e+00" :type {:kind "Double-type"} :line [15 15]}}
{:kind "Ret" :line [17 17] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [17 17]}}]}] 

