(defrule exp-44-inc
  {:kind "SizeOf"
   :argument #nest #use @{:kind "Unop" :op "++"}}
  "exp-44 (++)")
(defrule exp-44-inc-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "Unop" :op "++"}}}
  "exp-44 (++) t")
(defrule exp-44-dec
  {:kind "SizeOf"
   :argument #nest #use @{:kind "Unop" :op "--"}}
  "exp-44 (--)")
(defrule exp-44-dec-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "Unop" :op "--"}}}
  "exp-44 (--) t")
(defrule exp-44-=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op "="}}
  "exp-44 (=)")
(defrule exp-44-=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op "="}}}
  "exp-44 (=) t")
(defrule exp-44-+=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op "+="}}
  "exp-44 (+=)")
(defrule exp-44-+=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op "+="}}}
  "exp-44 (+=) t")
(defrule exp-44--=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op "-="}}
  "exp-44 (-=)")
(defrule exp-44--=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op "-="}}}
  "exp-44 (-=) t")
(defrule exp-44-*=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op "*="}}
  "exp-44 (*=)")
(defrule exp-44-*=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op "*="}}}
  "exp-44 (*=) t")
(defrule exp-44-div=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op "/="}}
  "exp-44 (/=)")
(defrule exp-44-div=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op "/="}}}
  "exp-44 (/=) t")
(defrule exp-44-%=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op "%="}}
  "exp-44 (%=)")
(defrule exp-44-%=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op "%="}}}
  "exp-44 (%=) t")
(defrule exp-44-&=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op "&="}}
  "exp-44 (&=)")
(defrule exp-44-&=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op "&="}}}
  "exp-44 (&=) t")
(defrule exp-44-or=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op "|="}}
  "exp-44 (|=)")
(defrule exp-44-or=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op "|="}}}
  "exp-44 (|=) t")
(defrule exp-44-xor=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op "^="}}
  "exp-44 (^=)")
(defrule exp-44-xor=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op "^="}}}
  "exp-44 (^=) t")
(defrule exp-44-<<=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op "<<="}}
  "exp-44 (<<=)")
(defrule exp-44-<<=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op "<<="}}}
  "exp-44 (<<=) t")
(defrule exp-44->>=
  {:kind "SizeOf"
   :argument #nest #use @{:kind "BinOp" :op ">>="}}
  "exp-44 (>>=)")
(defrule exp-44->>=-t
  {:kind "SizeOf"
   :argument-type #nest {:array-size
                        #nest #use @{:kind "BinOp" :op ">>="}}}
  "exp-44 (>>=) t")
