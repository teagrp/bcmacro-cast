(defrule exp44-1 @{:kind "SizeOf"
                  :Argument {:kind "Binop" :op "+"}}
"exp44-1")
(defrule exp44-2 @{:kind "SizeOf"
                  :Argument {:kind "Binop" :op "-"}}
"exp44-2")
(defrule exp44-3 @{:kind "SizeOf"
                  :Argument {:kind "Binop" :op "*"}}
"exp44-3")
(defrule exp44-4 @{:kind "SizeOf"
                  :Argument {:kind "Binop" :op "/"}}
"exp44-4")
(defrule exp44-5 @{:kind "SizeOf"
                  :Argument {:kind "Binop" :op "%"}}
"exp44-5")
(defrule exp44-6 @{:kind "SizeOf"
                  :Argument {:kind "Unop" :op "++"}}
"exp44-6")
(defrule exp44-7 @{:kind "SizeOf"
                  :Argument {:kind "Unop" :op "--"}}
"exp44-7")
(defrule exp44-8 @{:kind "SizeOf"
                  :Argument {:kind "Binop" :op "&"}}
"exp44-8")
(defrule exp44-9 @{:kind "SizeOf"
                  :Argument {:kind "Binop" :op "|"}}
"exp44-9")
(defrule exp44-10 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "^"}}
"exp44-10")
(defrule exp44-11 @{:kind "SizeOf"
                   :Argument {:kind "Unop" :op "~"}}
"exp44-11")
(defrule exp44-12 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "<<"}}
"exp44-12")
(defrule exp44-13 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op ">>"}}
"exp44-13")
(defrule exp44-14 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "="}}
"exp44-14")
(defrule exp44-15 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "+="}}
"exp44-15")
(defrule exp44-16 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "-="}}
"exp44-16")
(defrule exp44-17 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "*="}}
"exp44-17")
(defrule exp44-18 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "/="}}
"exp44-18")
(defrule exp44-19 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "%="}}
"exp44-19")
(defrule exp44-20 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "&="}}
"exp44-20")
(defrule exp44-21 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "|="}}
"exp44-21")
(defrule exp44-22 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "^="}}
"exp44-22")
(defrule exp44-23 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op "<<="}}
"exp44-23")
(defrule exp44-24 @{:kind "SizeOf"
                   :Argument {:kind "Binop" :op ">>="}}
"exp44-24")
(defrule exp44-25 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "+"}]}
 "exp44-25")
(defrule exp44-26 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "-"}]}
 "exp44-26")
(defrule exp44-27 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "*"}]}
 "exp44-27")
(defrule exp44-28 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "/"}]}
 "exp44-28")
(defrule exp44-29 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "%"}]}
 "exp44-29")
(defrule exp44-30 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Unop" :op "++"}]}
 "exp44-30")
(defrule exp44-31 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Unop" :op "--"}]}
 "exp44-31")
(defrule exp44-32 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "&"}]}
 "exp44-32")
(defrule exp44-33 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "|"}]}
 "exp44-33")
(defrule exp44-34 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "^"}]}
 "exp44-34")
(defrule exp44-35 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Unop" :op "~"}]}
 "exp44-35")
(defrule exp44-36 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "<<"}]}
 "exp44-36")
(defrule exp44-37 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op ">>"}]}
 "exp44-37")
(defrule exp44-38 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "="}]}
 "exp44-38")
(defrule exp44-39 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "+="}]}
 "exp44-39")
(defrule exp44-40 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "-="}]}
 "exp44-40")
(defrule exp44-41 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "*="}]}
 "exp44-41")
(defrule exp44-42 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "/="}]}
 "exp44-42")
(defrule exp44-43 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "%="}]}
 "exp44-43")
(defrule exp44-44 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "&="}]}
 "exp44-44")
(defrule exp44-45 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "|="}]}
 "exp44-45")
(defrule exp44-46 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "^="}]}
 "exp44-46")
(defrule exp44-47 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op "<<="}]}
 "exp44-47")
(defrule exp44-48 {:kind "SizeOf"
                  :ArgumentType [#nest @{:kind "Binop" :op ">>="}]}
 "exp44-48")
