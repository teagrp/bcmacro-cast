(defrule exp35-1 @{:kind "Unop" 
                   :op "++" 
                   :HS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-1")
(defrule exp35-2 @{:kind "Unop" 
                   :op "--" 
                   :HS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-2")
(defrule exp35-3 @{:kind "Binop" 
                   :op "+" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-3")
(defrule exp35-4 @{:kind "Binop" 
                   :op "-" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-4")
(defrule exp35-5 @{:kind "Binop" 
                   :op "*" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-5")
(defrule exp35-6 @{:kind "Binop" 
                   :op "/" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-6")
(defrule exp35-7 @{:kind "Binop" 
                   :op "%" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-7")
(defrule exp35-8 @{:kind "Binop" 
                   :op "&" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-8")
(defrule exp35-9 @{:kind "Binop" 
                   :op "|" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-9")
(defrule exp35-10 @{:kind "Binop" 
                   :op "^" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-10")
(defrule exp35-11 @{:kind "Unop" 
                   :op "~" 
                   :HS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-11")
(defrule exp35-12 @{:kind "Binop" 
                   :op "<<" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-12")
(defrule exp35-13 @{:kind "Binop" 
                   :op ">>" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-13")
(defrule exp35-14 @{:kind "Binop" 
                   :op "=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-14")
(defrule exp35-15 @{:kind "Binop" 
                   :op "+=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-15")
(defrule exp35-16 @{:kind "Binop" 
                   :op "-=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-16")
(defrule exp35-17 @{:kind "Binop" 
                   :op "*=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-17")
(defrule exp35-18 @{:kind "Binop" 
                   :op "/=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-18")
(defrule exp35-19 @{:kind "Binop" 
                   :op "%=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-19")
(defrule exp35-20 @{:kind "Binop" 
                   :op "&=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-20")
(defrule exp35-21 @{:kind "Binop" 
                   :op "|=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-21")
(defrule exp35-22 @{:kind "Binop" 
                   :op "^=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-22")
(defrule exp35-23 @{:kind "Binop" 
                   :op "<<=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-23")
(defrule exp35-24 @{:kind "Binop" 
                   :op ">>=" 
                   :LHS {:Array[{:struct{:kind "FuncCall"}}]}
                  }
  "exp35-24")

