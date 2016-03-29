(defrule exp-44-inc
  {:kind "SizeOf"
   :Argument #nest @{:kind "Unop" :op "++"}}
  "exp-44 (++)")
(defrule exp-44-inc-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Unop" :op "++"}}}
  "exp-44 (++) t")
(defrule exp-44-dec
  {:kind "SizeOf"
   :Argument #nest @{:kind "Unop" :op "--"}}
  "exp-44 (--)")
(defrule exp-44-dec-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Unop" :op "--"}}}
  "exp-44 (--) t")
(defrule exp-44-=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op "="}}
  "exp-44 (=)")
(defrule exp-44-=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op "="}}}
  "exp-44 (=) t")
(defrule exp-44-+=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op "+="}}
  "exp-44 (+=)")
(defrule exp-44-+=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op "+="}}}
  "exp-44 (+=) t")
(defrule exp-44--=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op "-="}}
  "exp-44 (-=)")
(defrule exp-44--=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op "-="}}}
  "exp-44 (-=) t")
(defrule exp-44-*=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op "*="}}
  "exp-44 (*=)")
(defrule exp-44-*=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op "*="}}}
  "exp-44 (*=) t")
(defrule exp-44-div=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op "/="}}
  "exp-44 (/=)")
(defrule exp-44-div=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op "/="}}}
  "exp-44 (/=) t")
(defrule exp-44-%=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op "%="}}
  "exp-44 (%=)")
(defrule exp-44-%=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op "%="}}}
  "exp-44 (%=) t")
(defrule exp-44-&=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op "&="}}
  "exp-44 (&=)")
(defrule exp-44-&=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op "&="}}}
  "exp-44 (&=) t")
(defrule exp-44-or=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op "|="}}
  "exp-44 (|=)")
(defrule exp-44-or=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op "|="}}}
  "exp-44 (|=) t")
(defrule exp-44-xor=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op "^="}}
  "exp-44 (^=)")
(defrule exp-44-xor=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op "^="}}}
  "exp-44 (^=) t")
(defrule exp-44-<<=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op "<<="}}
  "exp-44 (<<=)")
(defrule exp-44-<<=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op "<<="}}}
  "exp-44 (<<=) t")
(defrule exp-44->>=
  {:kind "SizeOf"
   :Argument #nest @{:kind "Binop" :op ">>="}}
  "exp-44 (>>=)")
(defrule exp-44->>=-t
  {:kind "SizeOf"
   :ArgumentType #nest {:ArraySizeExpression
                        #nest @{:kind "Binop" :op ">>="}}}
  "exp-44 (>>=) t")
