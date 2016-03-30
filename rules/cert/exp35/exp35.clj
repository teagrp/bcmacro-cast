(defrule exp35
  {:kind "Struct"
   :struct #nest @{:kind "FuncCall"}
   :structmember {:kind "Field"
                  :type [... {:kind "Array-type"}]}}
  "exp35")
