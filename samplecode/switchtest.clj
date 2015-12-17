
[{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [1 29]
 :Parm []
 :body [{:kind "Var" :name "x" :scope "local" :type {:kind "Int-type"} :line [2 2]
 :init {:kind "IntegerLiteral" :value "5" :type {:kind "Int-type"} :line [2 2]}}
{:kind "Var" :name "y" :scope "local" :type {:kind "Int-type"} :line [3 3]
 :init {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [3 3]}}
{:kind "While" :line [4 26]
 :condition {:kind "Binop" :op "!=" :line [4 4]
 :LHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [4 4]}
 :RHS {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [4 4]}}
 :body [{:kind "Switch" :line [5 25]
 :condition {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [5 5]}
 :body [{:kind "Var" :name "kokoro" :scope "local" :type {:kind "Int-type"} :line [6 6]}
{:kind "Binop" :op "=" :line [9 9] :label [{:kind "Case" :line [7 9] :value {:kind "IntegerLabel" :value "0" :type {:kind "Int-type"} :line [7 7]}}{:kind "Case" :line [8 9] :value {:kind "IntegerLabel" :value "1" :type {:kind "Int-type"} :line [8 8]}}]
 :LHS {:kind "DRE" :name "y" :scope "local" :type {:kind "Int-type"} :line [9 9]}
 :RHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [9 9]}}
{:kind "Unop" :op "--" :line [10 10] :HS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [10 10]}}
{:kind "Break" :line [11 11]}
{:kind "Binop" :op "=" :line [13 13] :label [{:kind "Case" :line [12 13] :value {:kind "IntegerLabel" :value "2" :type {:kind "Int-type"} :line [12 12]}}]
 :LHS {:kind "DRE" :name "y" :scope "local" :type {:kind "Int-type"} :line [13 13]}
 :RHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [13 13]}}
{:kind "Unop" :op "++" :line [14 14] :HS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [14 14]}}
{:kind "Continue" :line [15 15]}
{:kind "Binop" :op "=" :line [19 19] :label [{:kind "Case" :line [16 19] :value {:kind "IntegerLabel" :value "3" :type {:kind "Int-type"} :line [16 16]}}{:kind "Case" :line [17 19] :value {:kind "IntegerLabel" :value "4" :type {:kind "Int-type"} :line [17 17]}}{:kind "Case" :line [18 19] :value {:kind "IntegerLabel" :value "5" :type {:kind "Int-type"} :line [18 18]}}]
 :LHS {:kind "DRE" :name "y" :scope "local" :type {:kind "Int-type"} :line [19 19]}
 :RHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [19 19]}}
{:kind "Unop" :op "++" :line [20 20] :HS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [20 20]}}
{:kind "Break" :line [21 21]}
{:kind "Binop" :op "=" :line [24 24] :label [{:kind "Case" :line [22 24] :value {:kind "IntegerLabel" :value "6" :type {:kind "Int-type"} :line [22 22]}}{:kind "Default" :line [23 24]}]
 :LHS {:kind "DRE" :name "x" :scope "local" :type {:kind "Int-type"} :line [24 24]}
 :RHS {:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [24 24]}}]}]}
{:kind "Ret" :line [28 28] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [28 28]}}]}] 

