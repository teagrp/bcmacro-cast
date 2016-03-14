(defrule exp40-1 @{:type [{:Pointee {}} ... {:Pointee {:Pointee {:const "true"}}}]} 
  "exp40-1")
  
(defrule exp40-2 @{:type [ ... {:Pointee {:const "true"}} ... {:Pointee {}}]}
  "exp40-2")
