(do
  (defrule plus-assign @{:kind "Binop" :op "+="}
    "Very bad!!!")

  (defrule exp45 @{:condition {:kind "Binop" :op "="} :loc-begin loc} 
    `("very very bad" ~loc)))
