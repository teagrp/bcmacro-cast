(defrule exp31-1 {:Func [{:name "assert"}] 
                  :Parm [#nest @{:kind "Binop" :op "+"}]}
"exp31-1")
(defrule exp31-2 {:Func [{:name "assert"}] 
                  :Parm [#nest @{:kind "Binop" :op "-"}]}
"exp31-2")
(defrule exp31-3 {:Func [{:name "assert"}]
                  :Parm [#nest @{:kind "Binop" :op "*"}]}
"exp31-3")
(defrule exp31-4 {:Func [{:name  "assert"}]
                  :Parm [#nest @{:kind "Binop" :op "/"}]}
"exp31-4")
(defrule exp31-5 {:Func [{:name  "assert"}]
                  :Parm [#nest @{:kind "Binop" :op "%"}]}
"exp31-5")
(defrule exp31-6 {:Func [{:name  "assert"}]
                  :Parm [#nest @{:kind "Unop" :op "++"}]}
"exp31-6")
(defrule exp31-7 {:Func [{:name  "assert"}]
                  :Parm [#nest @{:kind "Unop" :op "--"}]}
"exp31-7")
(defrule exp31-8 {:Func [{:name  "assert"}]
                  :Parm [#nest @{:kind "Binop" :op "&"}]}
"exp31-8")
(defrule exp31-9 {:Func [{:name  "assert"}]
                  :Parm [#nest @{:kind "Binop" :op "|"}]}
"exp31-9")
(defrule exp31-10 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "^"}]}
"exp31-10")
(defrule exp31-11 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Unop" :op "~"}]}
"exp31-11")
(defrule exp31-12 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "<<"}]}
"exp31-12")
(defrule exp31-13 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op ">>"}]}
"exp31-13")
(defrule exp31-14 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "="}]}
"exp31-14")
(defrule exp31-15 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "+="}]}
"exp31-15")
(defrule exp31-16 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "-="}]}
"exp31-16")
(defrule exp31-17 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "*="}]}
"exp31-17")
(defrule exp31-18 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "/="}]}
"exp31-18")
(defrule exp31-19 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "%="}]}
"exp31-19")
(defrule exp31-20 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "&="}]}
"exp31-20")
(defrule exp31-21 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "|="}]}
"exp31-21")
(defrule exp31-22 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "^="}]}
"exp31-22")
(defrule exp31-23 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op "<<="}]}
"exp31-23")
(defrule exp31-24 {:Func [{:name  "assert"}]
                   :Parm [#nest @{:kind "Binop" :op ">>="}]}
"exp31-24")

