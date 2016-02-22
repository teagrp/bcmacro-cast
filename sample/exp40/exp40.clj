(do
  (defrule exp40a @{:kind "Binop" :op "="  :loc-begin loc
                    :LHS {:type [{:kind "Pointer-type" :Pointee {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}}}]}
                    :RHS {:HS {:type [{:kind "Pointer-type" :Pointee {:kind "Char-type"}}]}}}
    `("Very badA!!!" ~loc))
  
  
  (defrule exp40b @{:type [{:const "true"} ...] :loc-begin loc}
  `("Very badB!!!" ~loc)))
