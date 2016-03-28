(defrule exp32-1 @{:type [{#nest {:volatile "true"}} ... {#nest {:volatile (volatile :when (!= volatile "true"))}}]}
  "exp32-1")

(defrule exp32-2 @{:type [{#nest {:volatile (volatile :when (!= volatile "true"))}} ... {#nest {:volatile "true"}}]}
  "exp32-2")
