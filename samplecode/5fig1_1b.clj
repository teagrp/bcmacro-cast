
[{:kind "Funcdef" :name "main" :type {:kind "Void-type"} :line [1 11]
 :Parm []
 :body [{:kind "Var" :name "input" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Char-type"}} :line [2 2]}
{:kind "Var" :name "buf" :scope "local" :type {:kind "Array-type" :ArraySize "9" :type {:kind "Char-type"}} :line [2 2]}
{:kind "Var" :name "src" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [2 2]}
{:kind "Var" :name "dest" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [2 2]}
{:kind "Binop" :op "=" :line [4 4]
 :LHS {:kind "ArrayRef" :line [4 4]
 :Array {:kind "DRE" :name "input" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Char-type"}} :line [4 4]}
 :Index {:kind "IntegerLiteral" :value "8" :type {:kind "Int-type"} :line [4 4]}}
 :RHS {:kind "CharacterLiteral" :value "0" :character " " :type {:kind "Int-type"} :line [4 4]}}
{:kind "Binop" :op "=" :line [6 6]
 :LHS {:kind "DRE" :name "dest" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [6 6]}
 :RHS {:kind "DRE" :name "buf" :scope "local" :type {:kind "Array-type" :ArraySize "9" :type {:kind "Char-type"}} :line [6 6]}}
{:kind "Binop" :op "=" :line [7 7]
 :LHS {:kind "DRE" :name "src" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [7 7]}
 :RHS {:kind "DRE" :name "input" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Char-type"}} :line [7 7]}}
{:kind "While" :line [8 10]
 :condition {:kind "Unop" :op "*" :line [8 8] :HS {:kind "DRE" :name "src" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [8 8]}}
 :body [{:kind "Binop" :op "=" :line [9 9] :label [{:kind "Label" :line [9 9] :name "VULN"}]
 :LHS {:kind "Unop" :op "*" :line [9 9] :HS {:kind "Unop" :op "++" :line [9 9] :HS {:kind "DRE" :name "dest" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [9 9]}}}
 :RHS {:kind "Unop" :op "*" :line [9 9] :HS {:kind "Unop" :op "++" :line [9 9] :HS {:kind "DRE" :name "src" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [9 9]}}}}]}]}] 

