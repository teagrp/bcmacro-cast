(defrule plus-assign @{:loc-begin [$file $line $col]
                       :kind "Binop" :op "+="}
  "Very bad!!!")

(defrule le @{:loc-begin [$file $line $col]
              :kind "Binop" :op "<="}
  "bad!!!")

#_(throw (RuntimeException. "foo"))
