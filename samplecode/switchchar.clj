
[{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [1 24]
 :Parm []
 :body [{:kind "Var" :name "x" :scope "local" :type {:kind "Char-type"} :line [2 2]
 :init {:kind "CharacterLiteral" :value "97" :character "a" :type {:kind "Int-type"} :line [2 2]}}
{:kind "Var" :name "y" :scope "local" :type {:kind "Char-type"} :line [3 3]
 :init {:kind "CharacterLiteral" :value "98" :character "b" :type {:kind "Int-type"} :line [3 3]}}
{:kind "While" :line [4 21]
 :condition {:kind "Binop" :op "!=" :line [4 4]
 :LHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Char-type"} :line [4 4]}
 :RHS {:kind "DRE" :name "y" :scope "local" :type {:kind "Char-type"} :line [4 4]}}
 :body [{:kind "Switch" :line [5 20]
 :condition {:kind "DRE" :name "x" :scope "local" :type {:kind "Char-type"} :line [5 5]}
 :body [{:kind "Binop" :op "=" :line [8 8] :label [{:kind "Case" :line [6 8] :value {:kind "CharacterLabel" :value "119" :character "w" :type {:kind "Int-type"} :line [6 6]}}{:kind "Case" :line [7 8] :value {:kind "CharacterLabel" :value "122" :character "z" :type {:kind "Int-type"} :line [7 7]}}]
 :LHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Char-type"} :line [8 8]}
 :RHS {:kind "DRE" :name "y" :scope "local" :type {:kind "Char-type"} :line [8 8]}}
{:kind "Break" :line [9 9]}
{:kind "Binop" :op "=" :line [11 11] :label [{:kind "Case" :line [10 11] :value {:kind "CharacterLabel" :value "102" :character "f" :type {:kind "Int-type"} :line [10 10]}}]
 :LHS {:kind "DRE" :name "y" :scope "local" :type {:kind "Char-type"} :line [11 11]}
 :RHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Char-type"} :line [11 11]}}
{:kind "Continue" :line [12 12]}
{:kind "Binop" :op "=" :line [16 16] :label [{:kind "Case" :line [13 16] :value {:kind "CharacterLabel" :value "103" :character "g" :type {:kind "Int-type"} :line [13 13]}}{:kind "Case" :line [14 16] :value {:kind "CharacterLabel" :value "104" :character "h" :type {:kind "Int-type"} :line [14 14]}}{:kind "Case" :line [15 16] :value {:kind "CharacterLabel" :value "121" :character "y" :type {:kind "Int-type"} :line [15 15]}}]
 :LHS {:kind "DRE" :name "y" :scope "local" :type {:kind "Char-type"} :line [16 16]}
 :RHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Char-type"} :line [16 16]}}
{:kind "Break" :line [17 17]}
{:kind "Binop" :op "=" :line [19 19] :label [{:kind "Default" :line [18 19]}]
 :LHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Char-type"} :line [19 19]}
 :RHS {:kind "CharacterLiteral" :value "122" :character "z" :type {:kind "Int-type"} :line [19 19]}}]}]}
{:kind "Ret" :line [23 23] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [23 23]}}]}] 

