
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
 :body []}{:kind "Var" :name "x" :scope "global" :type {:kind "Int-type"} :line [3 3]
 :init {:kind "IntegerLiteral" :value "100" :type {:kind "Int-type"} :line [3 3]}}
{:kind "Var" :name "y" :scope "global" :type {:kind "Int-type"} :line [4 4]}
{:kind "Var" :name "zz" :scope "global" :type {:kind "Double-type"} :line [5 5]
 :init {:kind "FloatingLiteral" :value "1.555000e+01" :type {:kind "Double-type"} :line [5 5]}}
{:kind "Var" :name "c" :scope "global" :type {:kind "Char-type"} :line [6 6]
 :init {:kind "CharacterLiteral" :value "71" :character "G" :type {:kind "Int-type"} :line [6 6]}}
{:kind "Var" :name "s" :scope "global" :type {:kind "Array-type" :ArraySize "10" :type {:kind "Char-type"}} :line [7 7]
 :init [{:kind "CharacterLiteral" :value "78" :character "N" :type {:kind "Int-type"} :line [7 7]}{:kind "CharacterLiteral" :value "97" :character "a" :type {:kind "Int-type"} :line [7 7]}{:kind "CharacterLiteral" :value "107" :character "k" :type {:kind "Int-type"} :line [7 7]}{:kind "CharacterLiteral" :value "97" :character "a" :type {:kind "Int-type"} :line [7 7]}{:kind "CharacterLiteral" :value "109" :character "m" :type {:kind "Int-type"} :line [7 7]}{:kind "CharacterLiteral" :value "117" :character "u" :type {:kind "Int-type"} :line [7 7]}{:kind "CharacterLiteral" :value "114" :character "r" :type {:kind "Int-type"} :line [7 7]}{:kind "CharacterLiteral" :value "97" :character "a" :type {:kind "Int-type"} :line [7 7]}{:kind "CharacterLiteral" :value "33" :character "!" :type {:kind "Int-type"} :line [7 7]}{:kind "CharacterLiteral" :value "33" :character "!" :type {:kind "Int-type"} :line [7 7]}{:kind "CharacterLiteral" :value "0" :character " " :type {:kind "Int-type"} :line [7 7]}]}
{:kind "Funcdef" :name "main" :type {:kind "Int-type"} :line [9 16]
 :Parm []
 :body [{:kind "Var" :name "mx" :scope "local" :type {:kind "Int-type"} :line [10 10]
 :init {:kind "IntegerLiteral" :value "45" :type {:kind "Int-type"} :line [10 10]}}
{:kind "Binop" :op "=" :line [11 11]
 :LHS {:kind "DRE" :name "y" :scope "global" :type {:kind "Int-type"} :line [11 11]}
 :RHS {:kind "IntegerLiteral" :value "89" :type {:kind "Int-type"} :line [11 11]}}
{:kind "Var" :name "mzz" :scope "local" :type {:kind "Double-type"} :line [12 12]
 :init {:kind "FloatingLiteral" :value "7.632000e+01" :type {:kind "Double-type"} :line [12 12]}}
{:kind "Var" :name "mc" :scope "local" :type {:kind "Char-type"} :line [13 13]
 :init {:kind "CharacterLiteral" :value "76" :character "L" :type {:kind "Int-type"} :line [13 13]}}
{:kind "Ret" :line [15 15] :value {:kind "IntegerLiteral" :value "0" :type {:kind "Int-type"} :line [15 15]}}]}] 

