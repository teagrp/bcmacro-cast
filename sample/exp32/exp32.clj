(defrule exp32 @{:kind "Binop" 
                 :op "=" 
                 :LHS {:kind "DRE" 
                       :type [{:kind "Pointer-type" 
                               :Pointee {:kind "Pointer-type" 
                                         :Pointee {:volatile "true"}}}]} 
                       :RHS {:kind "Unop" 
                             :type [{:kind "Pointer-type" 
                                     :Pointee {:kind "Pointer-type" :Pointee {}}} 
                                    {:kind "Pointer-type" 
                                     :Pointee {:kind "Pointer-type" :Pointee {}}} 
                                    {:kind "Pointer-type" :Pointee {:kind "Pointer-type"}}]}} 
"Very bad!!! exp32" )
