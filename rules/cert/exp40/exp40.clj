;; const T* => T*
(defrule exp40-ptr @{:type
                     [...
                      {:Pointee {:const "true"}} ...
                      {:Pointee (t :when (= (t :const) nil))} ...]}
  "Cast from const * to non-const *")

;; T** => const T**
(defrule exp40-ptrptr @{:type
                        [...
                         {:Pointee {:Pointee (t :when (= (t :const) nil))}} ...
                         {:Pointee {:Pointee {:const "true"}}} ...]}
  "Cast from non-const ** to const **")


  
