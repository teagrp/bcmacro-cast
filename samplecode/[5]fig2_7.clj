
[
{:kind "Funcdef" :name "memcpy" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [46 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [46 46]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Void-type" :const "true"}} :line [46 46]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [47 47]}]
 :body []}
{:kind "Funcdef" :name "memmove" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [50 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [50 50]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Void-type" :const "true"}} :line [50 50]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [50 50]}]
 :body []}{:kind "Funcdef" :name "memccpy" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [58 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [58 58]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Void-type" :const "true"}} :line [58 58]}
{:kind "Parm" :name "__c" :type {:kind "Int-type"} :line [59 59]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [59 59]}]
 :body []}
{:kind "Funcdef" :name "memset" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [66 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [66 66]}
{:kind "Parm" :name "__c" :type {:kind "Int-type"} :line [66 66]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [66 66]}]
 :body []}
{:kind "Funcdef" :name "memcmp" :Extern "true" :type {:kind "Int-type"} :line [69 286]
 :Parm [{:kind "Parm" :name "__s1" :type {:kind "Pointer-type" :Pointee {:kind "Void-type" :const "true"}} :line [69 69]}
{:kind "Parm" :name "__s2" :type {:kind "Pointer-type" :Pointee {:kind "Void-type" :const "true"}} :line [69 69]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [69 69]}]
 :body []}
{:kind "Funcdef" :name "memchr" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [96 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Void-type" :const "true"}} :line [96 96]}
{:kind "Parm" :name "__c" :type {:kind "Int-type"} :line [96 96]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [96 96]}]
 :body []}
{:kind "Funcdef" :name "strcpy" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [129 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [129 129]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [129 129]}]
 :body []}
{:kind "Funcdef" :name "strncpy" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [132 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [132 132]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [133 133]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [133 133]}]
 :body []}
{:kind "Funcdef" :name "strcat" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [137 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [137 137]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [137 137]}]
 :body []}
{:kind "Funcdef" :name "strncat" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [140 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [140 140]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [140 140]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [141 141]}]
 :body []}
{:kind "Funcdef" :name "strcmp" :Extern "true" :type {:kind "Int-type"} :line [144 286]
 :Parm [{:kind "Parm" :name "__s1" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [144 144]}
{:kind "Parm" :name "__s2" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [144 144]}]
 :body []}
{:kind "Funcdef" :name "strncmp" :Extern "true" :type {:kind "Int-type"} :line [147 286]
 :Parm [{:kind "Parm" :name "__s1" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [147 147]}
{:kind "Parm" :name "__s2" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [147 147]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [147 147]}]
 :body []}{:kind "Funcdef" :name "strcoll" :Extern "true" :type {:kind "Int-type"} :line [151 286]
 :Parm [{:kind "Parm" :name "__s1" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [151 151]}
{:kind "Parm" :name "__s2" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [151 151]}]
 :body []}
{:kind "Funcdef" :name "strxfrm" :Extern "true" :type {:kind "UnsignedLong-type"} :line [154 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [154 154]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [155 155]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [155 155]}]
 :body []}{:kind "Structdef" :name "__locale_struct" :line [27 39]
 :Member [{:kind "Field" :name "__locales" :scope "member" :type {:kind "Array-type" :ArraySize "13" :type {:kind "Pointer-type" :Pointee {:kind "Strucure-type" :name "__locale_data"}}} :line [30 30]}
{:kind "Field" :name "__ctype_b" :scope "member" :type {:kind "Pointer-type" :Pointee {:kind "UnsignedShort-type" :const "true"}} :line [33 33]}
{:kind "Field" :name "__ctype_tolower" :scope "member" :type {:kind "Pointer-type" :Pointee {:kind "Int-type" :const "true"}} :line [34 34]}
{:kind "Field" :name "__ctype_toupper" :scope "member" :type {:kind "Pointer-type" :Pointee {:kind "Int-type" :const "true"}} :line [35 35]}
{:kind "Field" :name "__names" :scope "member" :type {:kind "Array-type" :ArraySize "13" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}}} :line [38 38]}]}
{:kind "Funcdef" :name "strcoll_l" :Extern "true" :type {:kind "Int-type"} :line [166 286]
 :Parm [{:kind "Parm" :name "__s1" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [166 166]}
{:kind "Parm" :name "__s2" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [166 166]}
{:kind "Parm" :name "__l" :type {:kind "Typedef-type" :typename "__locale_t" :type {:kind "Pointer-type" :Pointee {:kind "Strucure-type" :name "__locale_struct"}}} :line [166 166]}]
 :body []}{:kind "Funcdef" :name "strxfrm_l" :Extern "true" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [169 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [169 169]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [169 169]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [169 169]}
{:kind "Parm" :name "__l" :type {:kind "Typedef-type" :typename "__locale_t" :type {:kind "Pointer-type" :Pointee {:kind "Strucure-type" :name "__locale_struct"}}} :line [170 170]}]
 :body []}
{:kind "Funcdef" :name "strdup" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [176 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [176 176]}]
 :body []}
{:kind "Funcdef" :name "strndup" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [184 286]
 :Parm [{:kind "Parm" :name "__string" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [184 184]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [184 184]}]
 :body []}
{:kind "Funcdef" :name "strchr" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [236 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [236 236]}
{:kind "Parm" :name "__c" :type {:kind "Int-type"} :line [236 236]}]
 :body []}
{:kind "Funcdef" :name "strrchr" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [263 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [263 263]}
{:kind "Parm" :name "__c" :type {:kind "Int-type"} :line [263 263]}]
 :body []}
{:kind "Funcdef" :name "strcspn" :Extern "true" :type {:kind "UnsignedLong-type"} :line [285 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [285 285]}
{:kind "Parm" :name "__reject" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [285 285]}]
 :body []}
{:kind "Funcdef" :name "strspn" :Extern "true" :type {:kind "UnsignedLong-type"} :line [289 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [289 289]}
{:kind "Parm" :name "__accept" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [289 289]}]
 :body []}
{:kind "Funcdef" :name "strpbrk" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [315 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [315 315]}
{:kind "Parm" :name "__accept" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [315 315]}]
 :body []}
{:kind "Funcdef" :name "strstr" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [342 286]
 :Parm [{:kind "Parm" :name "__haystack" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [342 342]}
{:kind "Parm" :name "__needle" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [342 342]}]
 :body []}
{:kind "Funcdef" :name "strtok" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [348 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [348 348]}
{:kind "Parm" :name "__delim" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [348 348]}]
 :body []}{:kind "Funcdef" :name "__strtok_r" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [354 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [354 354]}
{:kind "Parm" :name "__delim" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [355 355]}
{:kind "Parm" :name "__save_ptr" :type {:kind "Pointer-type" :Pointee {:kind "Pointer-type" :Pointee {:kind "Char-type"}}} :line [356 356]}]
 :body []}{:kind "Funcdef" :name "strtok_r" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [359 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [359 359]}
{:kind "Parm" :name "__delim" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [359 359]}
{:kind "Parm" :name "__save_ptr" :type {:kind "Pointer-type" :Pointee {:kind "Pointer-type" :Pointee {:kind "Char-type"}}} :line [360 360]}]
 :body []}
{:kind "Funcdef" :name "strlen" :Extern "true" :type {:kind "UnsignedLong-type"} :line [399 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [399 399]}]
 :body []}{:kind "Funcdef" :name "strnlen" :Extern "true" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [406 286]
 :Parm [{:kind "Parm" :name "__string" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [406 406]}
{:kind "Parm" :name "__maxlen" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [406 406]}]
 :body []}
{:kind "Funcdef" :name "strerror" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [413 55]
 :Parm [{:kind "Parm" :name "__errnum" :type {:kind "Int-type"} :line [413 413]}]
 :body []}{:kind "Funcdef" :name "strerror_r" :Extern "true" :type {:kind "Int-type"} :line [427 286]
 :Parm [{:kind "Parm" :name "__errnum" :type {:kind "Int-type"} :line [428 428]}
{:kind "Parm" :name "__buf" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [428 428]}
{:kind "Parm" :name "__buflen" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [428 428]}]
 :body []}{:kind "Funcdef" :name "strerror_l" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [445 55]
 :Parm [{:kind "Parm" :name "__errnum" :type {:kind "Int-type"} :line [445 445]}
{:kind "Parm" :name "__l" :type {:kind "Typedef-type" :typename "__locale_t" :type {:kind "Pointer-type" :Pointee {:kind "Strucure-type" :name "__locale_struct"}}} :line [445 445]}]
 :body []}{:kind "Funcdef" :name "__bzero" :Extern "true" :type {:kind "Void-type"} :line [451 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [451 451]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [451 451]}]
 :body []}{:kind "Funcdef" :name "bcopy" :Extern "true" :type {:kind "Void-type"} :line [455 286]
 :Parm [{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Void-type" :const "true"}} :line [455 455]}
{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [455 455]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [455 455]}]
 :body []}
{:kind "Funcdef" :name "bzero" :Extern "true" :type {:kind "Void-type"} :line [459 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Void-type"}} :line [459 459]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [459 459]}]
 :body []}{:kind "Funcdef" :name "bcmp" :Extern "true" :type {:kind "Int-type"} :line [462 286]
 :Parm [{:kind "Parm" :name "__s1" :type {:kind "Pointer-type" :Pointee {:kind "Void-type" :const "true"}} :line [462 462]}
{:kind "Parm" :name "__s2" :type {:kind "Pointer-type" :Pointee {:kind "Void-type" :const "true"}} :line [462 462]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [462 462]}]
 :body []}
{:kind "Funcdef" :name "index" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [489 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [489 489]}
{:kind "Parm" :name "__c" :type {:kind "Int-type"} :line [489 489]}]
 :body []}
{:kind "Funcdef" :name "rindex" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [517 286]
 :Parm [{:kind "Parm" :name "__s" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [517 517]}
{:kind "Parm" :name "__c" :type {:kind "Int-type"} :line [517 517]}]
 :body []}{:kind "Funcdef" :name "ffs" :Extern "true" :type {:kind "Int-type"} :line [523 523]
 :Parm [{:kind "Parm" :name "__i" :type {:kind "Int-type"} :line [523 523]}]
 :body []}
{:kind "Funcdef" :name "strcasecmp" :Extern "true" :type {:kind "Int-type"} :line [534 286]
 :Parm [{:kind "Parm" :name "__s1" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [534 534]}
{:kind "Parm" :name "__s2" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [534 534]}]
 :body []}
{:kind "Funcdef" :name "strncasecmp" :Extern "true" :type {:kind "Int-type"} :line [538 286]
 :Parm [{:kind "Parm" :name "__s1" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [538 538]}
{:kind "Parm" :name "__s2" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [538 538]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [538 538]}]
 :body []}{:kind "Funcdef" :name "strsep" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [557 286]
 :Parm [{:kind "Parm" :name "__stringp" :type {:kind "Pointer-type" :Pointee {:kind "Pointer-type" :Pointee {:kind "Char-type"}}} :line [557 557]}
{:kind "Parm" :name "__delim" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [558 558]}]
 :body []}{:kind "Funcdef" :name "strsignal" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [564 55]
 :Parm [{:kind "Parm" :name "__sig" :type {:kind "Int-type"} :line [564 564]}]
 :body []}{:kind "Funcdef" :name "__stpcpy" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [567 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [567 567]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [567 567]}]
 :body []}
{:kind "Funcdef" :name "stpcpy" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [569 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [569 569]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [569 569]}]
 :body []}{:kind "Funcdef" :name "__stpncpy" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [574 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [574 574]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [575 575]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [575 575]}]
 :body []}
{:kind "Funcdef" :name "stpncpy" :Extern "true" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [577 286]
 :Parm [{:kind "Parm" :name "__dest" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [577 577]}
{:kind "Parm" :name "__src" :type {:kind "Pointer-type" :Pointee {:kind "Char-type" :const "true"}} :line [578 578]}
{:kind "Parm" :name "__n" :type {:kind "Typedef-type" :typename "size_t" :type {:kind "UnsignedLong-type"}} :line [578 578]}]
 :body []}{:kind "Funcdef" :name "escape_absolute_uri" :type {:kind "Void-type"} :line [10 36]
 :Parm [{:kind "Parm" :name "uri" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [10 10]}
{:kind "Parm" :name "scheme" :type {:kind "Int-type"} :line [10 10]}]
 :body [{:kind "Var" :name "cp" :scope "local" :type {:kind "Int-type"} :line [11 11]}
{:kind "Var" :name "c" :scope "local" :type {:kind "Int-type"} :line [11 11]}
{:kind "Var" :name "token" :scope "local" :type {:kind "Array-type" :ArraySize "26" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}}} :line [12 12]}
{:kind "If" :line [13 14]
 :condition {:kind "Binop" :op "||" :line [13 13]
 :LHS {:kind "Binop" :op "==" :line [13 13]
 :LHS {:kind "DRE" :name "scheme" :scope "local" :type {:kind "Int-type"} :line [13 13]}
 :RHS {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [13 13]}}
 :RHS {:kind "Binop" :op "<" :line [13 13]
 :LHS {:kind "FuncCall" :line [13 13] :type {:kind "UnsignedLong-type"}
 :Func {:kind "DRE" :name "strlen" :Extern "true" :line [13 13]}
 :Parm [{:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [13 13]}]}
 :RHS {:kind "DRE" :name "scheme" :scope "local" :type {:kind "Int-type"} :line [13 13]}}}
 :then [{:kind "Ret" :line [14 14]}]}
{:kind "Binop" :op "=" :line [15 15]
 :LHS {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [15 15]}
 :RHS {:kind "DRE" :name "scheme" :scope "local" :type {:kind "Int-type"} :line [15 15]}}
{:kind "If" :line [16 35]
 :condition {:kind "Binop" :op "==" :line [16 16]
 :LHS {:kind "ArrayRef" :line [16 16]
 :Array {:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [16 16]}
 :Index {:kind "Binop" :op "-" :line [16 16]
 :LHS {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [16 16]}
 :RHS {:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [16 16]}}}
 :RHS {:kind "CharacterLiteral" :value "47" :character "/" :type {:kind "Int-type"} :line [16 16]}}
 :then [{:kind "While" :line [17 18]
 :condition {:kind "Binop" :op "&&" :line [17 17]
 :LHS {:kind "Binop" :op "!=" :line [17 3]
 :LHS {:kind "ArrayRef" :line [17 17]
 :Array {:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [17 17]}
 :Index {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [17 17]}}
 :RHS {:kind "CharacterLiteral" :value "0" :character " " :type {:kind "Int-type"} :line [3 3]}}
 :RHS {:kind "Binop" :op "!=" :line [17 17]
 :LHS {:kind "ArrayRef" :line [17 17]
 :Array {:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [17 17]}
 :Index {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [17 17]}}
 :RHS {:kind "CharacterLiteral" :value "47" :character "/" :type {:kind "Int-type"} :line [17 17]}}}
 :body [{:kind "Unop" :op "++" :line [18 18] :HS {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [18 18]}}]}
{:kind "If" :line [19 20]
 :condition {:kind "Binop" :op "||" :line [19 3]
 :LHS {:kind "Binop" :op "==" :line [19 3]
 :LHS {:kind "ArrayRef" :line [19 19]
 :Array {:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [19 19]}
 :Index {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [19 19]}}
 :RHS {:kind "CharacterLiteral" :value "0" :character " " :type {:kind "Int-type"} :line [3 3]}}
 :RHS {:kind "Binop" :op "==" :line [19 3]
 :LHS {:kind "ArrayRef" :line [19 19]
 :Array {:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [19 19]}
 :Index {:kind "Binop" :op "+" :line [19 19]
 :LHS {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [19 19]}
 :RHS {:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [19 19]}}}
 :RHS {:kind "CharacterLiteral" :value "0" :character " " :type {:kind "Int-type"} :line [3 3]}}}
 :then [{:kind "Ret" :line [20 20]}]}
{:kind "Unop" :op "++" :line [21 21] :HS {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [21 21]}}
{:kind "Binop" :op "=" :line [21 21]
 :LHS {:kind "DRE" :name "scheme" :scope "local" :type {:kind "Int-type"} :line [21 21]}
 :RHS {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [21 21]}}
{:kind "If" :line [22 33]
 :condition {:kind "Binop" :op "==" :line [22 22]
 :LHS {:kind "FuncCall" :line [22 22] :type {:kind "Int-type"}
 :Func {:kind "DRE" :name "strncmp" :Extern "true" :line [22 22]}
 :Parm [{:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [22 22]}
{:kind "StringLiteral" :value "ldap://" :type {:kind "Array-type" :ArraySize "8" :type {:kind "Char-type"}} :line [4 4]}{:kind "IntegerLiteral" :value "7" :type {:kind "Int-type"} :line [8 8]}]}
 :RHS {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [22 22]}}
 :then [{:kind "Binop" :op "=" :line [23 23]
 :LHS {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [23 23]}
 :RHS {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [23 23]}}
{:kind "Binop" :op "=" :line [24 24]
 :LHS {:kind "ArrayRef" :line [24 24]
 :Array {:kind "DRE" :name "token" :scope "local" :type {:kind "Array-type" :ArraySize "26" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}}} :line [24 24]}
 :Index {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [24 24]}}
 :RHS {:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [24 24]}}
{:kind "While" :line [25 32]
 :condition {:kind "Binop" :op "&&" :line [25 5]
 :LHS {:kind "Binop" :op "!=" :line [25 3]
 :LHS {:kind "ArrayRef" :line [25 25]
 :Array {:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [25 25]}
 :Index {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [25 25]}}
 :RHS {:kind "CharacterLiteral" :value "0" :character " " :type {:kind "Int-type"} :line [3 3]}}
 :RHS {:kind "Binop" :op "<" :line [25 5]
 :LHS {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [25 25]}
 :RHS {:kind "Binop" :op "+" :line [6 5]
 :LHS {:kind "IntegerLiteral" :value "25" :type {:kind "Int-type"} :line [6 6]}
 :RHS {:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [5 5]}}}}
 :body [{:kind "If" :line [26 30]
 :condition {:kind "Binop" :op "==" :line [26 26]
 :LHS {:kind "ArrayRef" :line [26 26]
 :Array {:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [26 26]}
 :Index {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [26 26]}}
 :RHS {:kind "CharacterLiteral" :value "63" :character "?" :type {:kind "Int-type"} :line [26 26]}}
 :then [{:kind "Unop" :op "++" :line [27 27] :HS {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [27 27]}}
{:kind "Binop" :op "=" :line [28 28] :label [{:kind "Label" :line [28 28] :name "VULN"}]
 :LHS {:kind "ArrayRef" :line [28 28]
 :Array {:kind "DRE" :name "token" :scope "local" :type {:kind "Array-type" :ArraySize "26" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}}} :line [28 28]}
 :Index {:kind "DRE" :name "c" :scope "local" :type {:kind "Int-type"} :line [28 28]}}
 :RHS {:kind "Binop" :op "+" :line [28 28]
 :LHS {:kind "Binop" :op "+" :line [28 28]
 :LHS {:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [28 28]}
 :RHS {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [28 28]}}
 :RHS {:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [28 28]}}}
{:kind "Binop" :op "=" :line [29 3]
 :LHS {:kind "ArrayRef" :line [29 29]
 :Array {:kind "DRE" :name "uri" :scope "local" :type {:kind "Pointer-type" :Pointee {:kind "Char-type"}} :line [29 29]}
 :Index {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [29 29]}}
 :RHS {:kind "CharacterLiteral" :value "0" :character " " :type {:kind "Int-type"} :line [3 3]}}]}
{:kind "Unop" :op "++" :line [31 31] :HS {:kind "DRE" :name "cp" :scope "local" :type {:kind "Int-type"} :line [31 31]}}]}]}
{:kind "Ret" :line [34 34]}]}]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [37 44]
 :Parm []
 :body [{:kind "Var" :name "uri" :scope "local" :type {:kind "Array-type" :ArraySize "20" :type {:kind "Char-type"}} :line [38 38]}
{:kind "Var" :name "scheme" :scope "local" :type {:kind "Int-type"} :line [39 39]}
{:kind "Binop" :op "=" :line [40 3]
 :LHS {:kind "ArrayRef" :line [40 40]
 :Array {:kind "DRE" :name "uri" :scope "local" :type {:kind "Array-type" :ArraySize "20" :type {:kind "Char-type"}} :line [40 40]}
 :Index {:kind "Binop" :op "-" :line [7 40]
 :LHS {:kind "IntegerLiteral" :value "20" :type {:kind "Int-type"} :line [7 7]}
 :RHS {:kind "IntegerLiteral" :value "1" :type {:kind "Int-type"} :line [40 40]}}}
 :RHS {:kind "CharacterLiteral" :value "0" :character " " :type {:kind "Int-type"} :line [3 3]}}
{:kind "Binop" :op "=" :line [41 41]
 :LHS {:kind "DRE" :name "scheme" :scope "local" :type {:kind "Int-type"} :line [41 41]}
 :RHS {:kind "Binop" :op "+" :line [8 41]
 :LHS {:kind "IntegerLiteral" :value "7" :type {:kind "Int-type"} :line [8 8]}
 :RHS {:kind "IntegerLiteral" :value "2" :type {:kind "Int-type"} :line [41 41]}}}
{:kind "FuncCall" :line [42 42] :type {:kind "Void-type"}
 :Func {:kind "DRE" :name "escape_absolute_uri" :line [42 42]}
 :Parm [{:kind "DRE" :name "uri" :scope "local" :type {:kind "Array-type" :ArraySize "20" :type {:kind "Char-type"}} :line [42 42]}
{:kind "DRE" :name "scheme" :scope "local" :type {:kind "Int-type"} :line [42 42]}]}
{:kind "Ret" :line [43 43] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [43 43]}}]}] 

