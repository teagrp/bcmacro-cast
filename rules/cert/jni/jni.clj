(defrule jni1 @{:kind "Binop" :op "=" :loc-begin loc
                :LHS {:scope "global"}
                :RHS {:scope "local"}}
  `("Very Bad JNI1!!" ~loc))
