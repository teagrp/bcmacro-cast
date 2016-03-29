(defrule exp36-v @{:type [x ... {:Pointee {:kind "Void-type"}} ...]}
  "exp36-v")

(defrule
  exp36-cs
  @{:type
    [...
     {:Pointee {:kind "Char-type"}}
     ...
     {:Pointee {:kind "Short-type"}}
     ...]}
  "exp36-cs")
(defrule
  exp36-cus
  @{:type
    [...
     {:Pointee {:kind "Char-type"}}
     ...
     {:Pointee {:kind "UnsignedShort-type"}}
     ...]}
  "exp36-cus")
(defrule
  exp36-ci
  @{:type
    [...
     {:Pointee {:kind "Char-type"}}
     ...
     {:Pointee {:kind "Int-type"}}
     ...]}
  "exp36-ci")
(defrule
  exp36-cui
  @{:type
    [...
     {:Pointee {:kind "Char-type"}}
     ...
     {:Pointee {:kind "UnsignedInt-type"}}
     ...]}
  "exp36-cui")
(defrule
  exp36-cl
  @{:type
    [...
     {:Pointee {:kind "Char-type"}}
     ...
     {:Pointee {:kind "Long-type"}}
     ...]}
  "exp36-cl")
(defrule
  exp36-cul
  @{:type
    [...
     {:Pointee {:kind "Char-type"}}
     ...
     {:Pointee {:kind "UnsignedLong-type"}}
     ...]}
  "exp36-cul")
(defrule
  exp36-cf
  @{:type
    [...
     {:Pointee {:kind "Char-type"}}
     ...
     {:Pointee {:kind "Float-type"}}
     ...]}
  "exp36-cf")
(defrule
  exp36-cd
  @{:type
    [...
     {:Pointee {:kind "Char-type"}}
     ...
     {:Pointee {:kind "Double-type"}}
     ...]}
  "exp36-cd")
(defrule
  exp36-cld
  @{:type
    [...
     {:Pointee {:kind "Char-type"}}
     ...
     {:Pointee {:kind "LongDouble-type"}}
     ...]}
  "exp36-cld")
(defrule
  exp36-ucs
  @{:type
    [...
     {:Pointee {:kind "UnsignedChar-type"}}
     ...
     {:Pointee {:kind "Short-type"}}
     ...]}
  "exp36-ucs")
(defrule
  exp36-ucus
  @{:type
    [...
     {:Pointee {:kind "UnsignedChar-type"}}
     ...
     {:Pointee {:kind "UnsignedShort-type"}}
     ...]}
  "exp36-ucus")
(defrule
  exp36-uci
  @{:type
    [...
     {:Pointee {:kind "UnsignedChar-type"}}
     ...
     {:Pointee {:kind "Int-type"}}
     ...]}
  "exp36-uci")
(defrule
  exp36-ucui
  @{:type
    [...
     {:Pointee {:kind "UnsignedChar-type"}}
     ...
     {:Pointee {:kind "UnsignedInt-type"}}
     ...]}
  "exp36-ucui")
(defrule
  exp36-ucl
  @{:type
    [...
     {:Pointee {:kind "UnsignedChar-type"}}
     ...
     {:Pointee {:kind "Long-type"}}
     ...]}
  "exp36-ucl")
(defrule
  exp36-ucul
  @{:type
    [...
     {:Pointee {:kind "UnsignedChar-type"}}
     ...
     {:Pointee {:kind "UnsignedLong-type"}}
     ...]}
  "exp36-ucul")
(defrule
  exp36-ucf
  @{:type
    [...
     {:Pointee {:kind "UnsignedChar-type"}}
     ...
     {:Pointee {:kind "Float-type"}}
     ...]}
  "exp36-ucf")
(defrule
  exp36-ucd
  @{:type
    [...
     {:Pointee {:kind "UnsignedChar-type"}}
     ...
     {:Pointee {:kind "Double-type"}}
     ...]}
  "exp36-ucd")
(defrule
  exp36-ucld
  @{:type
    [...
     {:Pointee {:kind "UnsignedChar-type"}}
     ...
     {:Pointee {:kind "LongDouble-type"}}
     ...]}
  "exp36-ucld")
(defrule
  exp36-si
  @{:type
    [...
     {:Pointee {:kind "Short-type"}}
     ...
     {:Pointee {:kind "Int-type"}}
     ...]}
  "exp36-si")
(defrule
  exp36-sui
  @{:type
    [...
     {:Pointee {:kind "Short-type"}}
     ...
     {:Pointee {:kind "UnsignedInt-type"}}
     ...]}
  "exp36-sui")
(defrule
  exp36-sl
  @{:type
    [...
     {:Pointee {:kind "Short-type"}}
     ...
     {:Pointee {:kind "Long-type"}}
     ...]}
  "exp36-sl")
(defrule
  exp36-sul
  @{:type
    [...
     {:Pointee {:kind "Short-type"}}
     ...
     {:Pointee {:kind "UnsignedLong-type"}}
     ...]}
  "exp36-sul")
(defrule
  exp36-sf
  @{:type
    [...
     {:Pointee {:kind "Short-type"}}
     ...
     {:Pointee {:kind "Float-type"}}
     ...]}
  "exp36-sf")
(defrule
  exp36-sd
  @{:type
    [...
     {:Pointee {:kind "Short-type"}}
     ...
     {:Pointee {:kind "Double-type"}}
     ...]}
  "exp36-sd")
(defrule
  exp36-sld
  @{:type
    [...
     {:Pointee {:kind "Short-type"}}
     ...
     {:Pointee {:kind "LongDouble-type"}}
     ...]}
  "exp36-sld")
(defrule
  exp36-usi
  @{:type
    [...
     {:Pointee {:kind "UnsignedShort-type"}}
     ...
     {:Pointee {:kind "Int-type"}}
     ...]}
  "exp36-usi")
(defrule
  exp36-usui
  @{:type
    [...
     {:Pointee {:kind "UnsignedShort-type"}}
     ...
     {:Pointee {:kind "UnsignedInt-type"}}
     ...]}
  "exp36-usui")
(defrule
  exp36-usl
  @{:type
    [...
     {:Pointee {:kind "UnsignedShort-type"}}
     ...
     {:Pointee {:kind "Long-type"}}
     ...]}
  "exp36-usl")
(defrule
  exp36-usul
  @{:type
    [...
     {:Pointee {:kind "UnsignedShort-type"}}
     ...
     {:Pointee {:kind "UnsignedLong-type"}}
     ...]}
  "exp36-usul")
(defrule
  exp36-usf
  @{:type
    [...
     {:Pointee {:kind "UnsignedShort-type"}}
     ...
     {:Pointee {:kind "Float-type"}}
     ...]}
  "exp36-usf")
(defrule
  exp36-usd
  @{:type
    [...
     {:Pointee {:kind "UnsignedShort-type"}}
     ...
     {:Pointee {:kind "Double-type"}}
     ...]}
  "exp36-usd")
(defrule
  exp36-usld
  @{:type
    [...
     {:Pointee {:kind "UnsignedShort-type"}}
     ...
     {:Pointee {:kind "LongDouble-type"}}
     ...]}
  "exp36-usld")
(defrule
  exp36-il
  @{:type
    [...
     {:Pointee {:kind "Int-type"}}
     ...
     {:Pointee {:kind "Long-type"}}
     ...]}
  "exp36-il")
(defrule
  exp36-iul
  @{:type
    [...
     {:Pointee {:kind "Int-type"}}
     ...
     {:Pointee {:kind "UnsignedLong-type"}}
     ...]}
  "exp36-iul")
(defrule
  exp36-id
  @{:type
    [...
     {:Pointee {:kind "Int-type"}}
     ...
     {:Pointee {:kind "Double-type"}}
     ...]}
  "exp36-id")
(defrule
  exp36-ild
  @{:type
    [...
     {:Pointee {:kind "Int-type"}}
     ...
     {:Pointee {:kind "LongDouble-type"}}
     ...]}
  "exp36-ild")
(defrule
  exp36-uil
  @{:type
    [...
     {:Pointee {:kind "UnsignedInt-type"}}
     ...
     {:Pointee {:kind "Long-type"}}
     ...]}
  "exp36-uil")
(defrule
  exp36-uiul
  @{:type
    [...
     {:Pointee {:kind "UnsignedInt-type"}}
     ...
     {:Pointee {:kind "UnsignedLong-type"}}
     ...]}
  "exp36-uiul")
(defrule
  exp36-uid
  @{:type
    [...
     {:Pointee {:kind "UnsignedInt-type"}}
     ...
     {:Pointee {:kind "Double-type"}}
     ...]}
  "exp36-uid")
(defrule
  exp36-uild
  @{:type
    [...
     {:Pointee {:kind "UnsignedInt-type"}}
     ...
     {:Pointee {:kind "LongDouble-type"}}
     ...]}
  "exp36-uild")
(defrule
  exp36-ld
  @{:type
    [...
     {:Pointee {:kind "Long-type"}}
     ...
     {:Pointee {:kind "Double-type"}}
     ...]}
  "exp36-ld")
(defrule
  exp36-lld
  @{:type
    [...
     {:Pointee {:kind "Long-type"}}
     ...
     {:Pointee {:kind "LongDouble-type"}}
     ...]}
  "exp36-lld")
(defrule
  exp36-uld
  @{:type
    [...
     {:Pointee {:kind "UnsignedLong-type"}}
     ...
     {:Pointee {:kind "Double-type"}}
     ...]}
  "exp36-uld")
(defrule
  exp36-ulld
  @{:type
    [...
     {:Pointee {:kind "UnsignedLong-type"}}
     ...
     {:Pointee {:kind "LongDouble-type"}}
     ...]}
  "exp36-ulld")
(defrule
  exp36-fd
  @{:type
    [...
     {:Pointee {:kind "Float-type"}}
     ...
     {:Pointee {:kind "Double-type"}}
     ...]}
  "exp36-fd")
(defrule
  exp36-fld
  @{:type
    [...
     {:Pointee {:kind "Float-type"}}
     ...
     {:Pointee {:kind "LongDouble-type"}}
     ...]}
  "exp36-fld")
(defrule
  exp36-dld
  @{:type
    [...
     {:Pointee {:kind "Double-type"}}
     ...
     {:Pointee {:kind "LongDouble-type"}}
     ...]}
  "exp36-dld")
