(defrule exp32-1 @{:type [{:Pointee {}} ... {:Pointee {:Pointee {:volatile "true"}}}]}
  "exp32-1")

(defrule exp32-2 @{:type [{:Pointee {:volatile "true"}} ... {:Pointee {}}]}
  "exp32-2")
