(defrule plus-assign @{:kind "Binop" :op "+="}
  "Very bad!!!")

(defrule le @{:kind "Binop" :op "<="}
  "bad!!!")

#_(throw (RuntimeException. "foo"))
