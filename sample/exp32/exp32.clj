(defrule plus-assign @{:kind "Binop" 
                       :op "=" 
                       :LHS {:kind "DRE" 
                             :type [{:kind "Pointer-type" 
                                     :Pointee {:kind "Pointer-type" 
                                               :Pointee {:kind "Int-type" :volatile "true"}}}]} 
                       :RHS {:kind "Unop" 
                             :type [{:kind "Pointer-type" 
                                     :Pointee {:kind "Pointer-type" :Pointee {:kind "Int-type"}}} 
                                    {:kind "Pointer-type" 
                                     :Pointee {:kind "Pointer-type" :Pointee {:kind "Int-type"}}} 
                                    {:kind "Pointer-type" :Pointee {:kind "Pointer-type"}}]
                             }} 
  `("Very bad!!! exp32") )
