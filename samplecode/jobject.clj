
[{:kind "Var" :name "x" :scope "global" :type {:kind "Typedef-type" :typename "jobject" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}}} :line [4 4]}
{:kind "Funcdef" :name "f" :type {:kind "Int-type"} :line [6 10]
 :Parm [{:kind "Parm" :name "obj" :type {:kind "Typedef-type" :typename "jobject" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}}} :line [6 6]}]
 :body [{:kind "Binop" :op "=" :line [7 7]
 :LHS {:kind "DRE" :name "x" :scope "global" :type {:kind "Typedef-type" :typename "jobject" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}}} :line [7 7]}
 :RHS {:kind "DRE" :name "obj" :scope "local" :type {:kind "Typedef-type" :typename "jobject" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}}} :line [7 7]}}
{:kind "Ret" :line [9 9] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [9 9]}}]}] 

