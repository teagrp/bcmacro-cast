(do 
  (defrule plus-assign {:Func [{:name "assert"}] 
                        :Parm [#nest @{:kind "Unop" :op "++"}]}
  `("Very bad!!! exp31"))
  (defrule minus-assign {:Func [{:name "assert"}] 
                         :Parm [#nest @{:kind "Unop" :op "--"}]}
  `("Very bad!!! exp31"))
)
