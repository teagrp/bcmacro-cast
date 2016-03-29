(defrule exp45-if {:kind "If" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-if-comma
  {:kind "If" :condition @{:kind "Binop" :op ","
                           :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-switch {:kind "Switch" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-switch-comma
  {:kind "Switch" :condition @{:kind "Binop" :op ","
                               :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-for {:kind "For" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-for-comma
  {:kind "For" :condition @{:kind "Binop" :op ","
                            :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-while {:kind "While" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-while-comma
  {:kind "While" :condition @{:kind "Binop" :op ","
                              :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-dowhile {:kind "Do" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-dowhile-comma
  {:kind "Do" :condition @{:kind "Binop" :op ","
                           :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logor-l {:kind "Binop" :op "||" :LHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-logor-comma-l
  {:kind "Binop" :op "||" :LHS @{:kind "Binop" :op ","
                                 :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logor-r {:kind "Binop" :op "||" :RHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-logor-comma-r
  {:kind "Binop" :op "||" :RHS @{:kind "Binop" :op ","
                                 :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logand-l {:kind "Binop" :op "&&" :LHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-logand-comma-l
  {:kind "Binop" :op "&&" :LHS @{:kind "Binop" :op ","
                                 :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-logand-r {:kind "Binop" :op "&&" :RHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-logand-comma-r
  {:kind "Binop" :op "&&" :RHS @{:kind "Binop" :op ","
                                 :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
