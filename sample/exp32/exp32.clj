(defrule plus-assign @{:kind "Binop" 
                       :op "=" 
                       :type [{:kind "Pointer-type" 
                               :Pointee {:kind "Pointer-type" 
                                         :Pointee {:kind "Int-type" :volatile "true"}}}] 
                       :LHS {:kind "DRE" 
                             :type [{:kind "Pointer-type" 
                                     :Pointee {:kind "Pointer-type" 
                                               :Pointee {:kind "Int-type" :volatile "true"}}}]} 
                       :RHS {:kind "Unop" :op "&" 
                             :type [{:kind "Pointer-type" 
                                     :Pointee {:kind "Pointer-type" :Pointee {:kind "Int-type"}}} 
                                    {:kind "Pointer-type" 
                                     :Pointee {:kind "Pointer-type" :Pointee {:kind "Int-type"}}} 
                                    {:kind "Pointer-type" :Pointee {:kind "Pointer-type"}}]
                             :loc-begin loc}} 
  `("Very bad!!! exp32"~loc) )
