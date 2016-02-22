(do 
  (defrule plus-assign @{:Func [{:name "assert"}] 
                         :Parm [{:LHS {:kind "Unop" :op "++" :loc-begin loc}}]}
  `("Very bad!!! exp31" ~loc))
  (defrule minus-assign @{:Func [{:name "assert"}] 
                         :Parm [{:LHS {:kind "Unop" :op "--" :loc-begin loc}}]}
  `("Very bad!!! exp31" ~loc))
)
