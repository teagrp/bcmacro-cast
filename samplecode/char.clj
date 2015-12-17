
[{:kind "Var" :name "a" :scope "global" :type {:kind "Char-type"} :line [1 1]}
{:kind "Var" :name "b" :scope "global" :type {:kind "Char-type"} :line [2 2]
 :init {:kind "CharacterLiteral" :value "99" :character "c" :type {:kind "Int-type"} :line [2 2]}}
{:kind "Funcdef" :name "charactor" :type {:kind "Char-type"} :line [4 10]
 :Parm [{:kind "Parm" :name "moji" :type {:kind "Char-type"} :line [4 4]}]
 :body [{:kind "Var" :name "ans" :scope "local" :type {:kind "Char-type"} :line [5 5]}
{:kind "Binop" :op "=" :line [7 7]
 :LHS {:kind "DRE" :name "ans" :scope "local" :type {:kind "Char-type"} :line [7 7]}
 :RHS {:kind "Binop" :op "+" :line [7 7]
 :LHS {:kind "DRE" :name "moji" :scope "local" :type {:kind "Char-type"} :line [7 7]}
 :RHS {:kind "DRE" :name "b" :scope "global" :type {:kind "Char-type"} :line [7 7]}}}
{:kind "Ret" :line [9 9] :value {:kind "DRE" :name "ans" :scope "local" :type {:kind "Char-type"} :line [9 9]}}]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [12 19]
 :Parm []
 :body [{:kind "Var" :name "moji" :scope "local" :type {:kind "Char-type"} :line [14 14]}
{:kind "Binop" :op "=" :line [15 15]
 :LHS {:kind "DRE" :name "moji" :scope "local" :type {:kind "Char-type"} :line [15 15]}
 :RHS {:kind "CharacterLiteral" :value "65" :character "A" :type {:kind "Int-type"} :line [15 15]}}
{:kind "FuncCall" :line [17 17] :type {:kind "Char-type"}
 :Func {:kind "DRE" :name "charactor" :line [17 17]}
 :Parm [{:kind "DRE" :name "moji" :scope "local" :type {:kind "Char-type"} :line [17 17]}]}
{:kind "Ret" :line [18 18] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [18 18]}}]}] 

