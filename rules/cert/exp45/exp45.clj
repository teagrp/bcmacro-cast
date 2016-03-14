(do
  (defrule exp45a @{:condition {:kind "Binop" :op "="} :loc-begin loc}
    `("Very badA!!!" ~loc))
  
  
  (defrule exp44b {:condition #nest @{:kind "Binop" :op "="} :loc-begin loc}
    `("Very badB!!!" ~loc)))
