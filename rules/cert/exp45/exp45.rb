#!/usr/bin/ruby

[["if", "If"],
 ["switch", "Switch"],
 ["for", "For"],
 ["while", "While"],
 ["dowhile", "Do"]].each do |name, kind|
  print <<END
(defrule exp45-#{name} {:kind "#{kind}" :condition @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-#{name}-comma
  {:kind "#{kind}" :condition @{:kind "Binop" :op ","
                                :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-#{name}-condop2
  {:kind "#{kind}" :condition @{:kind "Conditionalop"
                                :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-#{name}-condop3
  {:kind "#{kind}" :condition @{:kind "Conditionalop"
                                :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
END
end
 
[["logor", "||"],
 ["logand", "&&"]].each do |name, op|
  print <<END
(defrule exp45-#{name}-l {:kind "Binop" :op "#{op}" :LHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-#{name}-comma-l
  {:kind "Binop" :op "#{op}" :LHS @{:kind "Binop" :op ","
                                    :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-#{name}-condop2-l
  {:kind "Binop" :op "#{op}" :LHS @{:kind "Conditionalop"
                                    :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-#{name}-condop3-l
  {:kind "Binop" :op "#{op}" :LHS @{:kind "Conditionalop"
                                    :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")

(defrule exp45-#{name}-r {:kind "Binop" :op "#{op}" :RHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-#{name}-comma-r
  {:kind "Binop" :op "#{op}" :RHS @{:kind "Binop" :op ","
                                      :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-#{name}-condop2-r
  {:kind "Binop" :op "#{op}" :RHS @{:kind "Conditionalop"
                                    :operand2 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
(defrule exp45-#{name}-condop3-r
  {:kind "Binop" :op "#{op}" :RHS @{:kind "Conditionalop"
                                    :operand3 {:kind "Binop" :op "="}}}
  "EXP45-C violation")
END
end

print <<END
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
END
