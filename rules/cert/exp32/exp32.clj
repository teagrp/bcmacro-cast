;; volatile T* => T*
(defrule exp32-ptr
  @{:type [{:Pointee {:volatile "true"}} ...
           {:Pointee (t :when (= (t :volatile) nil))}]}
  "Cast from volatile pointer to non-volatile pointer")

;; T** => volatile T**
(defrule exp32-ptrptr
  @{:type [{:Pointee {:Pointee (t :when (= (t :volatile) nil))}} ...
	  	  {:Pointee {:Pointee {:volatile "true"}}}]}
  "Cast from non-volatile pointer pointer to volatile pointer pointer")

