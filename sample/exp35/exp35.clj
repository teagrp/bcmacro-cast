(defrule plus-assign @{:kind "Unop" :op "++" 
                       :type [{:kind "Int-type"}] 
                       :HS {:kind "ArrayRef" 
                            :type [{:kind "Int-type"}] 
                            :Array [{:kind "Field" :scope "member" }]}
                       :loc-begin loc}
  `("Very bad!!! exp35"~loc) )
