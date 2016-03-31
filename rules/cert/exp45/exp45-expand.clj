(defrule exp45-if {:kind "If" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-if-comma
  {:kind "If" :condition @{:kind "Binop" :op ","
                                :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-if-condop2
  {:kind "If" :condition @{:kind "Conditionalop"
                                :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-if-condop3
  {:kind "If" :condition @{:kind "Conditionalop"
                                :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-switch {:kind "Switch" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-switch-comma
  {:kind "Switch" :condition @{:kind "Binop" :op ","
                                :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-switch-condop2
  {:kind "Switch" :condition @{:kind "Conditionalop"
                                :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-switch-condop3
  {:kind "Switch" :condition @{:kind "Conditionalop"
                                :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-for {:kind "For" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-for-comma
  {:kind "For" :condition @{:kind "Binop" :op ","
                                :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-for-condop2
  {:kind "For" :condition @{:kind "Conditionalop"
                                :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-for-condop3
  {:kind "For" :condition @{:kind "Conditionalop"
                                :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-while {:kind "While" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-while-comma
  {:kind "While" :condition @{:kind "Binop" :op ","
                                :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-while-condop2
  {:kind "While" :condition @{:kind "Conditionalop"
                                :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-while-condop3
  {:kind "While" :condition @{:kind "Conditionalop"
                                :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-dowhile {:kind "Do" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-dowhile-comma
  {:kind "Do" :condition @{:kind "Binop" :op ","
                                :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-dowhile-condop2
  {:kind "Do" :condition @{:kind "Conditionalop"
                                :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-dowhile-condop3
  {:kind "Do" :condition @{:kind "Conditionalop"
                                :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logor-l {:kind "Binop" :op "||" :LHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-logor-comma-l
  {:kind "Binop" :op "||" :LHS @{:kind "Binop" :op ","
                                    :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logor-condop2-l
  {:kind "Binop" :op "||" :LHS @{:kind "Conditionalop"
                                    :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logor-condop3-l
  {:kind "Binop" :op "||" :LHS @{:kind "Conditionalop"
                                    :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")

(defrule exp45-logor-r {:kind "Binop" :op "||" :RHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-logor-comma-r
  {:kind "Binop" :op "||" :RHS @{:kind "Binop" :op ","
                                      :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logor-condop2-r
  {:kind "Binop" :op "||" :RHS @{:kind "Conditionalop"
                                    :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logor-condop3-r
  {:kind "Binop" :op "||" :RHS @{:kind "Conditionalop"
                                    :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logand-l {:kind "Binop" :op "&&" :LHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-logand-comma-l
  {:kind "Binop" :op "&&" :LHS @{:kind "Binop" :op ","
                                    :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logand-condop2-l
  {:kind "Binop" :op "&&" :LHS @{:kind "Conditionalop"
                                    :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logand-condop3-l
  {:kind "Binop" :op "&&" :LHS @{:kind "Conditionalop"
                                    :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")

(defrule exp45-logand-r {:kind "Binop" :op "&&" :RHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-logand-comma-r
  {:kind "Binop" :op "&&" :RHS @{:kind "Binop" :op ","
                                      :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logand-condop2-r
  {:kind "Binop" :op "&&" :RHS @{:kind "Conditionalop"
                                    :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logand-condop3-r
  {:kind "Binop" :op "&&" :RHS @{:kind "Conditionalop"
                                    :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
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
