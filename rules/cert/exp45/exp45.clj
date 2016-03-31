(defmacro exp45c-stmt
  "define rule exp45"
  [kind key]
  `(do
     (defrule ~(gensym) {:kind ~kind ~key @{:kind "Binop" :op "="}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind ~kind ~key @{:kind "Binop" :op ","
                                            :RHS {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind ~kind ~key @{:kind "Conditionalop"
                                            :operand2 {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind ~kind ~key @{:kind "Conditionalop"
                                            :operand3 {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     ))

(defmacro exp45c-binop
  "define rule exp45"
  [op]
  `(do
     (defrule ~(gensym) {:kind "Binop" :op ~op :LHS @{:kind "Binop" :op "="}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind "Binop" :op ~op
                         :LHS @{:kind "Binop" :op ","
                                :RHS {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind "Binop" :op ~op
                         :LHS @{:kind "Conditionalop"
                                :operand2 {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind "Binop" :op ~op
                         :LHS @{:kind "Conditionalop"
                                :operand3 {:kind "Binop" :op "="}}}
       "EXP45-C violation")

     (defrule ~(gensym) {:kind "Binop" :op ~op :RHS @{:kind "Binop" :op "="}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind "Binop" :op ~op
                         :RHS @{:kind "Binop" :op ","
                                :RHS {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind "Binop" :op ~op
                         :RHS @{:kind "Conditionalop"
                                :operand2 {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind "Binop" :op ~op
                         :RHS @{:kind "Conditionalop"
                                :operand3 {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     ))

(exp45c-stmt "If" :condition)
(exp45c-stmt "Switch" :condition)
(exp45c-stmt "For" :condition)
(exp45c-stmt "While" :condition)
(exp45c-stmt "Do" :condition)
(exp45c-binop "||")
(exp45c-binop "&&")

(defrule exp45-condop {:kind "Conditionalop" :operand1 @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-condop-comma
  {:kind "Conditionalop" :operand1 @{:kind "Binop" :op ","
                                     :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-condop-condop2
  {:kind "Conditionalop" :operand1 @{:kind "Conditionalop"
                                     :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-condop-condop3
  {:kind "Conditionalop" :operand1 @{:kind "Conditionalop"
                                     :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")


