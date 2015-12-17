
[{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [1 10]
 :Parm []
 :body [{:kind "Var" :name "input" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Char-type"}} :line [2 2]}
{:kind "Var" :name "buf" :scope "local" :type {:kind "Array-type" :ArraySize "9" :type {:kind "Char-type"}} :line [2 2]}
{:kind "Var" :name "src" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [2 2]}
{:kind "Var" :name "dest" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [2 2]}
{:kind "Binop" :op "=" :line [4 4]
 :LHS {:kind "DRE" :name "dest" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [4 4]}
 :RHS {:kind "DRE" :name "buf" :scope "local" :type {:kind "Array-type" :ArraySize "9" :type {:kind "Char-type"}} :line [4 4]}}
{:kind "Binop" :op "=" :line [5 5]
 :LHS {:kind "DRE" :name "src" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [5 5]}
 :RHS {:kind "DRE" :name "input" :scope "local" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Char-type"}} :line [5 5]}}
{:kind "While" :line [6 8]
 :condition {:kind "Unop" :op "*" :line [6 6] :HS {:kind "DRE" :name "src" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [6 6]}}
 :body [{:kind "Binop" :op "=" :line [7 7] :label [{:kind "Label" :line [7 7] :name "VULN"}]
 :LHS {:kind "Unop" :op "*" :line [7 7] :HS {:kind "Unop" :op "++" :line [7 7] :HS {:kind "DRE" :name "dest" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [7 7]}}}
 :RHS {:kind "Unop" :op "*" :line [7 7] :HS {:kind "Unop" :op "++" :line [7 7] :HS {:kind "DRE" :name "src" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [7 7]}}}}]}
{:kind "Ret" :line [9 9] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [9 9]}}]}] 

