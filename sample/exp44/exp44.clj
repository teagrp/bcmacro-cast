(do
  (defrule exp44a @{:kind "SizeOf" :loc-begin loc
                    :Argument {:kind "Unop" :op "++"}}
    `("Very badA!!!" ~loc))
  
  
  (defrule exp44b {:kind "SizeOf" :loc-begin loc
                   :ArgumentType [
                                  #nest @{:kind "Unop" :op "++"} 
                                  ]}
    `("Very badB!!!" ~loc)))
