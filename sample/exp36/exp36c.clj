(do
  (defrule exp361 @{:type [{:Pointee {:kind "Char-type"}} ... {:Pointee {:kind "Int-type"}}] :loc-begin loc}
    `("Very bad1!!!" ~loc))
  
  (defrule exp362 @{:type [... {:Pointee {:kind "Void-type"}}] :loc-begin loc}
    `("Very bad2!!!" ~loc))

  (defrule exp363 @{:type [{:Pointee {:kind "Char-type"}} ... {:Pointee {:kind "Short-type"}}] :loc-begin loc}
    `("Very bad3!!!" ~loc))
  
  (defrule exp364 @{:type [{:Pointee {:kind "Char-type"}} ... {:Pointee {:kind "UnsignedShot-type"}}] :loc-begin loc}
    `("Very bad4!!!" ~loc))

  (defrule exp365 @{:type [{:Pointee {:kind "Char-type"}} ... {:Pointee {:kind "Long-type"}}] :loc-begin loc}
    `("Very bad5!!!" ~loc))

  (defrule exp366 @{:type [{:Pointee {:kind "Char-type"}} ... {:Pointee {:kind "Float-type"}}] :loc-begin loc}
    `("Very bad6!!!" ~loc))

  (defrule exp367 @{:type [{:Pointee {:kind "Char-type"}} ... {:Pointee {:kind "UnsignedInt-type"}}] :loc-begin loc}
    `("Very bad7!!!" ~loc))

  (defrule exp368 @{:type [{:Pointee {:kind "Char-type"}} ... {:Pointee {:kind "UnsignedLong-type"}}] :loc-begin loc}
    `("Very bad8!!!" ~loc))

  (defrule exp369 @{:type [{:Pointee {:kind "Char-type"}} ... {:Pointee {:kind "Double-type"}}] :loc-begin loc}
    `("Very bad9!!!" ~loc))

  (defrule exp3610 @{:type [{:Pointee {:kind "Char-type"}} ... {:Pointee {:kind "LongDouble-type"}}] :loc-begin loc}
    `("Very bad10!!!" ~loc))

  (defrule exp3611 @{:type [{:Pointee {:kind "UnsignedChar-type"}} ... {:Pointee {:kind "Short-type"}}] :loc-begin loc}
    `("Very bad11!!!" ~loc))
  
  (defrule exp3612 @{:type [{:Pointee {:kind "UnsignedChar-type"}} ... {:Pointee {:kind "UnsignedShot-type"}}] :loc-begin loc}
    `("Very bad12!!!" ~loc))

  (defrule exp3613 @{:type [{:Pointee {:kind "UnsignedChar-type"}} ... {:Pointee {:kind "Int-type"}}] :loc-begin loc}
    `("Very bad13!!!" ~loc))
  
  (defrule exp3614 @{:type [{:Pointee {:kind "UnsignedChar-type"}} ... {:Pointee {:kind "Long-type"}}] :loc-begin loc}
    `("Very bad14!!!" ~loc))

  (defrule exp3615 @{:type [{:Pointee {:kind "UnsignedChar-type"}} ... {:Pointee {:kind "Float-type"}}] :loc-begin loc}
    `("Very bad15!!!" ~loc))

  (defrule exp3616 @{:type [{:Pointee {:kind "UnsignedChar-type"}} ... {:Pointee {:kind "UnsignedInt-type"}}] :loc-begin loc}
    `("Very bad16!!!" ~loc))

  (defrule exp3617 @{:type [{:Pointee {:kind "UnsignedChar-type"}} ... {:Pointee {:kind "UnsignedLong-type"}}] :loc-begin loc}
    `("Very bad17!!!" ~loc))

  (defrule exp3618 @{:type [{:Pointee {:kind "UnsignedChar-type"}} ... {:Pointee {:kind "Double-type"}}] :loc-begin loc}
    `("Very bad18!!!" ~loc))

  (defrule exp3619 @{:type [{:Pointee {:kind "UnsignedChar-type"}} ... {:Pointee {:kind "LongDouble-type"}}] :loc-begin loc}
    `("Very bad19!!!" ~loc))

  (defrule exp3620 @{:type [{:Pointee {:kind "Short-type"}} ... {:Pointee {:kind "Int-type"}}] :loc-begin loc}
    `("Very bad20!!!" ~loc))

  (defrule exp3621 @{:type [{:Pointee {:kind "Short-type"}} ... {:Pointee {:kind "Long-type"}}] :loc-begin loc}
    `("Very bad21!!!" ~loc))
  
  (defrule exp3622 @{:type [{:Pointee {:kind "Short-type"}} ... {:Pointee {:kind "Float-type"}}] :loc-begin loc}
    `("Very bad22!!!" ~loc))

  (defrule exp3623 @{:type [{:Pointee {:kind "Short-type"}} ... {:Pointee {:kind "UnsignedInt-type"}}] :loc-begin loc}
    `("Very bad23!!!" ~loc))
  
  (defrule exp3624 @{:type [{:Pointee {:kind "Short-type"}} ... {:Pointee {:kind "UnsignedLong-type"}}] :loc-begin loc}
    `("Very bad24!!!" ~loc))

  (defrule exp3625 @{:type [{:Pointee {:kind "Short-type"}} ... {:Pointee {:kind "Double-type"}}] :loc-begin loc}
    `("Very bad25!!!" ~loc))

  (defrule exp3626 @{:type [{:Pointee {:kind "Short-type"}} ... {:Pointee {:kind "LongDouble-type"}}] :loc-begin loc}
    `("Very bad26!!!" ~loc))

  (defrule exp3627 @{:type [{:Pointee {:kind "UnsignedShort-type"}} ... {:Pointee {:kind "Int-type"}}] :loc-begin loc}
    `("Very bad27!!!" ~loc))

  (defrule exp3628 @{:type [{:Pointee {:kind "UnsignedShort-type"}} ... {:Pointee {:kind "Long-type"}}] :loc-begin loc}
    `("Very bad28!!!" ~loc))

  (defrule exp3629 @{:type [{:Pointee {:kind "UnsignedShort-type"}} ... {:Pointee {:kind "Float-type"}}] :loc-begin loc}
    `("Very bad29!!!" ~loc))

  (defrule exp3630 @{:type [{:Pointee {:kind "UnsignedShort-type"}} ... {:Pointee {:kind "UnsignedInt-type"}}] :loc-begin loc}
    `("Very bad30!!!" ~loc))

  (defrule exp3631 @{:type [{:Pointee {:kind "UnsignedShort-type"}} ... {:Pointee {:kind "UnsignedLong-type"}}] :loc-begin loc}
    `("Very bad31!!!" ~loc))
  
  (defrule exp3632 @{:type [{:Pointee {:kind "UnsigendShort-type"}} ... {:Pointee {:kind "Double-type"}}] :loc-begin loc}
    `("Very bad32!!!" ~loc))

  (defrule exp3633 @{:type [{:Pointee {:kind "UnsignedShort-type"}} ... {:Pointee {:kind "LongDouble-type"}}] :loc-begin loc}
    `("Very bad33!!!" ~loc))
  
  (defrule exp3634 @{:type [{:Pointee {:kind "Int-type"}} ... {:Pointee {:kind "Double-type"}}] :loc-begin loc}
    `("Very bad34!!!" ~loc))

  (defrule exp3635 @{:type [{:Pointee {:kind "Int-type"}} ... {:Pointee {:kind "LongDouble-type"}}] :loc-begin loc}
    `("Very bad35!!!" ~loc))

  (defrule exp3636 @{:type [{:Pointee {:kind "Long-type"}} ... {:Pointee {:kind "Double-type"}}] :loc-begin loc}
    `("Very bad36!!!" ~loc))

  (defrule exp3637 @{:type [{:Pointee {:kind "Long-type"}} ... {:Pointee {:kind "LongDouble-type"}}] :loc-begin loc}
    `("Very bad37!!!" ~loc))

  (defrule exp3638 @{:type [{:Pointee {:kind "Float-type"}} ... {:Pointee {:kind "Double-type"}}] :loc-begin loc}
    `("Very bad38!!!" ~loc))

  (defrule exp3639 @{:type [{:Pointee {:kind "Float-type"}} ... {:Pointee {:kind "Double-type"}}] :loc-begin loc}
    `("Very bad39!!!" ~loc))

  (defrule exp3640 @{:type [{:Pointee {:kind "UnsignedInt-type"}} ... {:Pointee {:kind "Double-type"}}] :loc-begin loc}
    `("Very bad40!!!" ~loc))

  (defrule exp3641 @{:type [{:Pointee {:kind "UnsignedInt-type"}} ... {:Pointee {:kind "LongDouble-type"}}] :loc-begin loc}
    `("Very bad41!!!" ~loc))
  
  (defrule exp3642 @{:type [{:Pointee {:kind "UnsignedLong-type"}} ... {:Pointee {:kind "Double-type"}}] :loc-begin loc}
    `("Very bad42!!!" ~loc))

  (defrule exp3643 @{:type [{:Pointee {:kind "UnsignedLong-type"}} ... {:Pointee {:kind "LongDouble-type"}}] :loc-begin loc}
    `("Very bad43!!!" ~loc)))
