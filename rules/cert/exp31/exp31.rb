#!/usr/bin/ruby

[["inc", "Unop", "++"],
 ["dec", "Unop", "--"],
 ["assign", "Binop", "="],
 ["plus", "Binop", "+="],
 ["minus", "Binop", "-="],
 ["mul", "Binop", "*="],
 ["div", "Binop", "/="],
 ["mod", "Binop", "%="],
 ["and", "Binop", "&="],
 ["or", "Binop", "|="],
 ["xor", "Binop", "^="],
 ["lshift", "Binop", "<<="],
 ["rshift", "Binop", ">>="]].each do |name, kind, op|
  print <<END
(defrule exp31-#{name} {:Func [{:name  "assert"}]
                        :Parm [#nest @{:kind "#{kind}" :op "#{op}"}]}
  "EXP31-C: violation")
END
end

