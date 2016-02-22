(defrule exp31-1 {:Func [{:name "assert"}] 
                  :Parm [#nest @{:kind "Unop" :op "++"}]}
"Very bad!!! exp31-1")

(defrule exp31-2 {:Func [{:name "assert"}] 
                  :Parm [#nest @{:kind "Unop" :op "--"}]}
"Very bad!!! exp31-2")

(defrule exp31-3 {:Func [{:name "assert"}]
                  :Parm [#nest @{:kind "Binop" :op "+="}]}
"Very bad!!! exp31-3")

(defrule exp31-4 {:Func [{:name  "assert"}]
                  :Parm [#nest @{:kind "Binop" :op "-="}]}
"Very bad!!! exp31-4")
