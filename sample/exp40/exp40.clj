  (defrule exp40a @{:kind "Binop" :op "=" 
                    :LHS {:type [{:kind "Pointer-type" :Pointee {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}}}]}
                    :RHS {:HS {:type [{:kind "Pointer-type" :Pointee {:kind "Char-type"}}]}}}
    "Very badA!!!")
  
  
  (defrule exp40b @{:type [{:const "true"} ...]}
  "Very badB!!!")
