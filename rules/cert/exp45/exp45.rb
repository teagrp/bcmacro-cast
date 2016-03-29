#!/usr/bin/ruby

[["if", "If"],
 ["switch", "Switch"],
 ["for", "For"],
 ["while", "While"],
 ["dowhile", "Do"]].each do |name, kind|
   print "(defrule exp45-#{name} {:kind \"#{kind}\" :condition @{:kind \"Binop\" :op \"=\"}}\n"
   print "  \"EXP45-C violation\")\n"
   print "(defrule exp45-#{name}-comma\n"
   print "  {:kind \"#{kind}\" :condition @{:kind \"Binop\" :op \",\"\n"
   print "                              :RHS {:kind \"Binop\" :op \"=\"}}}\n"
   print "  \"EXP45-C violation\")\n"
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
(defrule exp45-#{name}-r {:kind "Binop" :op "#{op}" :RHS @{:kind "Binop" :op "="}}
  "EXP45-C violation")
(defrule exp45-#{name}-comma-r
  {:kind "Binop" :op "#{op}" :RHS @{:kind "Binop" :op ","
                                      :RHS {:kind "Binop" :op "="}}}
  "EXP45-C violation")
END
end
