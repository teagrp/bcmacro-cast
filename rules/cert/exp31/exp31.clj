(defrule exp31-1 {:Func [{:name  "assert"}]
                  :Parm [#nest @{:kind "Unop" :op "++"}]}
"exp31-1")
(defrule exp31-2 {:Func [{:name  "assert"}]
                  :Parm [#nest @{:kind "Unop" :op "--"}]}
"exp31-2")
(defrule exp31-3 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "="}]}
"exp31-3")
(defrule exp31-4 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "+="}]}
"exp31-4")
(defrule exp31-5 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "-="}]}
"exp31-5")
(defrule exp31-6 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "*="}]}
"exp31-6")
(defrule exp31-7 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "/="}]}
"exp31-7")
(defrule exp31-8 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "%="}]}
"exp31-8")
