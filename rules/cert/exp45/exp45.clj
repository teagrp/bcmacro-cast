#_(defrule exp45-if {:kind "If" :condition @{:kind "Binop" :op "="}}
  "EXP45-C: assignment in condition of if statement")

#_(defrule exp45-ifcomma {:kind "If" 
                        :condition @{:kind "Binop" :op "," 
                                     :RHS {:kind "Binop" :op "="}}}
  "EXP45-C: assignment in rhs of comma operator in if statement")
#_(defrule exp45-switch {:kind "Switch" :condition @{:kind "Binop" :op "="}}
  "EXP45-C: assignment in condition of switch statement")
#_(defrule exp45-while {:kind "While" :condition @{:kind "Binop" :op "="}}
  "EXP45-C: assignment in condition of while statement")
#_(defrule exp45-for {:kind "For" :condition @{:kind "Binop" :op "="}}
  "EXP45-C: assignment in condition of for statement")
#_(defrule exp45-dowhile {:kind "Do" :condition @{:kind "Binop" :op "="}}
  "EXP45-C: assignment in condition of do-while statement")
#_(defrule exp45-logor-l {:op "||" :LHS @{:kind "Binop" :op "="}}
  "EXP45-C: assignment in lhs of logical or operator")
#_(defrule exp45-logor-r {:op "||" :RHS @{:kind "Binop" :op "="}}
  "EXP45-C: assignment in rhs of logical or operator")
#_(defrule exp45-logand-l {:op "&&" :LHS @{:kind "Binop" :op "="}}
  "EXP45-C: assignment in lhs of logical and operator")
#_(defrule exp45-logand-r {:op "&&" :RHS @{:kind "Binop" :op "="}}
  "EXP45-C: assignment in rhs of logical and operator")

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
