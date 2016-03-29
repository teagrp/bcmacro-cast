(defrule exp31-inc {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Unop" :op "++"}]}
  "EXP31-C: violation")
(defrule exp31-dec {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Unop" :op "--"}]}
  "EXP31-C: violation")
(defrule exp31-assign {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op "="}]}
  "EXP31-C: violation")
(defrule exp31-plus {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op "+="}]}
  "EXP31-C: violation")
(defrule exp31-minus {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op "-="}]}
  "EXP31-C: violation")
(defrule exp31-mul {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op "*="}]}
  "EXP31-C: violation")
(defrule exp31-div {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op "/="}]}
  "EXP31-C: violation")
(defrule exp31-mod {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op "%="}]}
  "EXP31-C: violation")
(defrule exp31-and {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op "&="}]}
  "EXP31-C: violation")
(defrule exp31-or {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op "|="}]}
  "EXP31-C: violation")
(defrule exp31-xor {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op "^="}]}
  "EXP31-C: violation")
(defrule exp31-lshift {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op "<<="}]}
  "EXP31-C: violation")
(defrule exp31-rshift {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "Binop" :op ">>="}]}
  "EXP31-C: violation")
