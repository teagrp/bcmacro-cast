(defmacro exp45c-stmt
  "define rule exp45"
  [kind key]
  `(do
     (defrule ~(gensym) {:kind ~kind ~key @{:kind "Binop" :op "="}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind ~kind ~key @{:kind "Binop" :op ","
                                      :RHS {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     ))

(defmacro exp45c-binop
  "define rule exp45"
  [op]
  `(do
     (defrule ~(gensym) {:kind "Binop" :op ~op :LHS @{:kind "Binop" :op "="}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind "Binop" :op ~op :LHS @{:kind "Binop" :op ","
                                                      :RHS {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind "Binop" :op ~op :RHS @{:kind "Binop" :op "="}}
       "EXP45-C violation")
     (defrule ~(gensym) {:kind "Binop" :op ~op :RHS @{:kind "Binop" :op ","
                                                      :RHS {:kind "Binop" :op "="}}}
       "EXP45-C violation")
     ))

(exp45c-stmt "If" :condition)
(exp45c-stmt "Switch" :condition)
(exp45c-stmt "For" :condition)
(exp45c-stmt "While" :condition)
(exp45c-stmt "Do" :condition)
(exp45c-binop "||")
(exp45c-binop "&&")


