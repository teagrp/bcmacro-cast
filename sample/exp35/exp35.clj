(defrule plus-assign @{:kind "Unop" :op "++" 
                       :HS {:kind "ArrayRef" 
                            :Array [{:kind "Field" :scope "member" }]}
                      }
  `("Very bad!!! exp35") )
(defrule exp35 @{:kind "Unop" :op "++"
                 :type [{:kind "Int-type"}]
                 :loc-begin ["/home/ayato/exp35-2/exp35.c" 9 16]
                 :loc-end ["/home/ayato/exp35-2/exp35.c" 9 35]
                 :HS {:kind "ArrayRef" :type [{:kind "Int-type"}]
                      :loc-begin ["/home/ayato/exp35-2/exp35.c" 9 19] :loc-end ["/home/ayato/exp35-2/exp35.c" 9 34]
                      :Array [{:kind "Field" :name "a" :scope "member"
                               :type [{:kind "Array-type" :ArraySize "6"
                                       :type {:kind "Int-type"}}
                                      {:kind "Pointer-type" :Pointee {:kind "Int-type"}}]
                               :loc-begin ["/home/ayato/exp35-2/exp35.c" 1 12]
                               :loc-end ["/home/ayato/exp35-2/exp35.c" 1 19]}]
                      :Index {:kind "IntegerLiteral" :value 0
                              :type [{:kind "Int-type"}]
                              :loc-begin ["/home/ayato/exp35-2/exp35.c" 9 33]
                              :loc-end ["/home/ayato/exp35-2/exp35.c" 9 33]
                              }}
)
