(ns astgrep.ast)

(def ast 
  '[[{:kind Func  :name "memcpy" :type "void *"}
     {:kind Parm  :name "__dest" :type "void *restrict"}
     {:kind Parm  :name "__src" :type "const void *restrict"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "memmove" :type "void *"}
     {:kind Parm  :name "__dest" :type "void *"}
     {:kind Parm  :name "__src" :type "const void *"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "memccpy" :type "void *"}
     {:kind Parm  :name "__dest" :type "void *restrict"}
     {:kind Parm  :name "__src" :type "const void *restrict"}
     {:kind Parm  :name "__c" :type "int"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "memset" :type "void *"}
     {:kind Parm  :name "__s" :type "void *"}
     {:kind Parm  :name "__c" :type "int"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "memcmp" :type "int"}
     {:kind Parm  :name "__s1" :type "const void *"}
     {:kind Parm  :name "__s2" :type "const void *"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "memchr" :type "void *"}
     {:kind Parm  :name "__s" :type "const void *"}
     {:kind Parm  :name "__c" :type "int"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "strcpy" :type "char *"}
     {:kind Parm  :name "__dest" :type "char *restrict"}
     {:kind Parm  :name "__src" :type "const char *restrict"}]
    [{:kind Func  :name "strncpy" :type "char *"}
     {:kind Parm  :name "__dest" :type "char *restrict"}
     {:kind Parm  :name "__src" :type "const char *restrict"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "strcat" :type "char *"}
     {:kind Parm  :name "__dest" :type "char *restrict"}
     {:kind Parm  :name "__src" :type "const char *restrict"}]
    [{:kind Func  :name "strncat" :type "char *"}
     {:kind Parm  :name "__dest" :type "char *restrict"}
     {:kind Parm  :name "__src" :type "const char *restrict"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "strcmp" :type "int"}
     {:kind Parm  :name "__s1" :type "const char *"}
     {:kind Parm  :name "__s2" :type "const char *"}]
    [{:kind Func  :name "strncmp" :type "int"}
     {:kind Parm  :name "__s1" :type "const char *"}
     {:kind Parm  :name "__s2" :type "const char *"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "strcoll" :type "int"}
     {:kind Parm  :name "__s1" :type "const char *"}
     {:kind Parm  :name "__s2" :type "const char *"}]
    [{:kind Func  :name "strxfrm" :type "unsigned long"}
     {:kind Parm  :name "__dest" :type "char *restrict"}
     {:kind Parm  :name "__src" :type "const char *restrict"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Struct  :name"__locale_struct"}
     [{:kind Struct  :name"__locale_data"}]
     [{:kind Field  :name "__locales" :scope member :type "struct __locale_data *[13]"}
      [{:kind "INT" :value "13"}]]
     [{:kind Field  :name "__ctype_b" :scope member :type "const unsigned short *"}]
     [{:kind Field  :name "__ctype_tolower" :scope member :type "const int *"}]
     [{:kind Field  :name "__ctype_toupper" :scope member :type "const int *"}]
     [{:kind Field  :name "__names" :scope member :type "const char *[13]"}
      [{:kind "INT" :value "13"}]]]
    [{:kind Func  :name "strcoll_l" :type "int"}
     {:kind Parm  :name "__s1" :type "const char *"}
     {:kind Parm  :name "__s2" :type "const char *"}
     {:kind Parm  :name "__l" :type "__locale_t"}]
    [{:kind Func  :name "strxfrm_l" :type "size_t"}
     {:kind Parm  :name "__dest" :type "char *"}
     {:kind Parm  :name "__src" :type "const char *"}
     {:kind Parm  :name "__n" :type "size_t"}
     {:kind Parm  :name "__l" :type "__locale_t"}]
    [{:kind Func  :name "strdup" :type "char *"}
     {:kind Parm  :name "__s" :type "const char *"}]
    [{:kind Func  :name "strndup" :type "char *"}
     {:kind Parm  :name "__string" :type "const char *"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "strchr" :type "char *"}
     {:kind Parm  :name "__s" :type "const char *"}
     {:kind Parm  :name "__c" :type "int"}]
    [{:kind Func  :name "strrchr" :type "char *"}
     {:kind Parm  :name "__s" :type "const char *"}
     {:kind Parm  :name "__c" :type "int"}]
    [{:kind Func  :name "strcspn" :type "unsigned long"}
     {:kind Parm  :name "__s" :type "const char *"}
     {:kind Parm  :name "__reject" :type "const char *"}]
    [{:kind Func  :name "strspn" :type "unsigned long"}
     {:kind Parm  :name "__s" :type "const char *"}
     {:kind Parm  :name "__accept" :type "const char *"}]
    [{:kind Func  :name "strpbrk" :type "char *"}
     {:kind Parm  :name "__s" :type "const char *"}
     {:kind Parm  :name "__accept" :type "const char *"}]
    [{:kind Func  :name "strstr" :type "char *"}
     {:kind Parm  :name "__haystack" :type "const char *"}
     {:kind Parm  :name "__needle" :type "const char *"}]
    [{:kind Func  :name "strtok" :type "char *"}
     {:kind Parm  :name "__s" :type "char *restrict"}
     {:kind Parm  :name "__delim" :type "const char *restrict"}]
    [{:kind Func  :name "__strtok_r" :type "char *"}
     {:kind Parm  :name "__s" :type "char *restrict"}
     {:kind Parm  :name "__delim" :type "const char *restrict"}
     {:kind Parm  :name "__save_ptr" :type "char **restrict"}]
    [{:kind Func  :name "strtok_r" :type "char *"}
     {:kind Parm  :name "__s" :type "char *restrict"}
     {:kind Parm  :name "__delim" :type "const char *restrict"}
     {:kind Parm  :name "__save_ptr" :type "char **restrict"}]
    [{:kind Func  :name "strlen" :type "unsigned long"}
     {:kind Parm  :name "__s" :type "const char *"}]
    [{:kind Func  :name "strnlen" :type "size_t"}
     {:kind Parm  :name "__string" :type "const char *"}
     {:kind Parm  :name "__maxlen" :type "size_t"}]
    [{:kind Func  :name "strerror" :type "char *"}
     {:kind Parm  :name "__errnum" :type "int"}]
    [{:kind Func  :name "strerror_r" :type "int"}
     {:kind Parm  :name "__errnum" :type "int"}
     {:kind Parm  :name "__buf" :type "char *"}
     {:kind Parm  :name "__buflen" :type "size_t"}]
    [{:kind Func  :name "strerror_l" :type "char *"}
     {:kind Parm  :name "__errnum" :type "int"}
     {:kind Parm  :name "__l" :type "__locale_t"}]
    [{:kind Func  :name "__bzero" :type "void"}
     {:kind Parm  :name "__s" :type "void *"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "bcopy" :type "void"}
     {:kind Parm  :name "__src" :type "const void *"}
     {:kind Parm  :name "__dest" :type "void *"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "bzero" :type "void"}
     {:kind Parm  :name "__s" :type "void *"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "bcmp" :type "int"}
     {:kind Parm  :name "__s1" :type "const void *"}
     {:kind Parm  :name "__s2" :type "const void *"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "index" :type "char *"}
     {:kind Parm  :name "__s" :type "const char *"}
     {:kind Parm  :name "__c" :type "int"}]
    [{:kind Func  :name "rindex" :type "char *"}
     {:kind Parm  :name "__s" :type "const char *"}
     {:kind Parm  :name "__c" :type "int"}]
    [{:kind Func  :name "ffs" :type "int"}
     {:kind Parm  :name "__i" :type "int"}]
    [{:kind Func  :name "strcasecmp" :type "int"}
     {:kind Parm  :name "__s1" :type "const char *"}
     {:kind Parm  :name "__s2" :type "const char *"}]
    [{:kind Func  :name "strncasecmp" :type "int"}
     {:kind Parm  :name "__s1" :type "const char *"}
     {:kind Parm  :name "__s2" :type "const char *"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "strsep" :type "char *"}
     {:kind Parm  :name "__stringp" :type "char **restrict"}
     {:kind Parm  :name "__delim" :type "const char *restrict"}]
    [{:kind Func  :name "strsignal" :type "char *"}
     {:kind Parm  :name "__sig" :type "int"}]
    [{:kind Func  :name "__stpcpy" :type "char *"}
     {:kind Parm  :name "__dest" :type "char *restrict"}
     {:kind Parm  :name "__src" :type "const char *restrict"}]
    [{:kind Func  :name "stpcpy" :type "char *"}
     {:kind Parm  :name "__dest" :type "char *restrict"}
     {:kind Parm  :name "__src" :type "const char *restrict"}]
    [{:kind Func  :name "__stpncpy" :type "char *"}
     {:kind Parm  :name "__dest" :type "char *restrict"}
     {:kind Parm  :name "__src" :type "const char *restrict"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "stpncpy" :type "char *"}
     {:kind Parm  :name "__dest" :type "char *restrict"}
     {:kind Parm  :name "__src" :type "const char *restrict"}
     {:kind Parm  :name "__n" :type "size_t"}]
    [{:kind Func  :name "escape_absolute_uri" :type "void"}
     {:kind Parm  :name "uri" :type "char *"}
     {:kind Parm  :name "scheme" :type "int"}
     [{:kind Var :name cp :scope "local" :type"int"}]
     [{:kind Var :name c :scope "local" :type"int"}]
     [{:kind Var :name token :scope "local" :type"char *[11]"}
      [{:kind "Binop" :op "+"}
       [{:kind "INT" :value "10"}]
       [{:kind "INT" :value "1"}]]]
     [{:kind "If"}
      [{:kind "Binop" :op "||"}
       [{:kind "Binop" :op "=="}
        [{:kind "DRE" :name "scheme" :scope "local" :type "int"}]
        [{:kind "INT" :value "0"}]]
       [{:kind "Binop" :op "<"}
        [[{:kind "DRE" :name "strlen" :type"unsigned long (const char *)"}]
         [{:kind "DRE" :name "uri" :scope "local" :type "char *"}]]
        [{:kind "DRE" :name "scheme" :scope "local" :type "int"}]]]
      [{:kind "Then"}
       [{:kind "Ret" :type "void"}]]]
     [{:kind "Binop" :op "="}
      [{:kind "DRE" :name "cp" :scope "local" :type "int"}]
      [{:kind "DRE" :name "scheme" :scope "local" :type "int"}]]
     [{:kind "If"}
      [{:kind "Binop" :op "=="}
       [[{:kind "DRE" :name "uri" :scope "local" :type "char *"}]
        [{:kind "Index"}
         [{:kind "Binop" :op "-"}
          [{:kind "DRE" :name "cp" :scope "local" :type "int"}]
          [{:kind "INT" :value "1"}]]]]
       [{:kind "CHAR" :value "/"}]]
      [{:kind "Then"}
       [{:kind "While" :order 1}
        [{:kind "Binop" :op "&&"}
         [{:kind "Binop" :op "!="}
          [[{:kind "DRE" :name "uri" :scope "local" :type "char *"}]
           [{:kind "Index"}
            [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]]
          [{:kind "CHAR" :value " "}]]
         [{:kind "Binop" :op "!="}
          [[{:kind "DRE" :name "uri" :scope "local" :type "char *"}]
           [{:kind "Index"}
            [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]]
          [{:kind "CHAR" :value "/"}]]]
        [{:kind "Unop" :op "++"}
         [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]]
       [{:kind "If"}
        [{:kind "Binop" :op "||"}
         [{:kind "Binop" :op "=="}
          [[{:kind "DRE" :name "uri" :scope "local" :type "char *"}]
           [{:kind "Index"}
            [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]]
          [{:kind "CHAR" :value " "}]]
         [{:kind "Binop" :op "=="}
          [[{:kind "DRE" :name "uri" :scope "local" :type "char *"}]
           [{:kind "Index"}
            [{:kind "Binop" :op "+"}
             [{:kind "DRE" :name "cp" :scope "local" :type "int"}]
             [{:kind "INT" :value "1"}]]]]
          [{:kind "CHAR" :value " "}]]]
        [{:kind "Then"}
         [{:kind "Ret" :type "void"}]]]
       [{:kind "Unop" :op "++"}
        [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]
       [{:kind "Binop" :op "="}
        [{:kind "DRE" :name "scheme" :scope "local" :type "int"}]
        [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]
       [{:kind "If"}
        [{:kind "Binop" :op "=="}
         [[{:kind "DRE" :name "strncmp" :type"int (const char *, const char *, unsigned long)"}]
          [{:kind "DRE" :name "uri" :scope "local" :type "char *"}]
          [{:kind "STRING" :value "ldap://"}]
          [{:kind "INT" :value "7"}]]
         [{:kind "INT" :value "0"}]]
        [{:kind "Then"}
         [{:kind "Binop" :op "="}
          [{:kind "DRE" :name "c" :scope "local" :type "int"}]
          [{:kind "INT" :value "0"}]]
         [{:kind "Binop" :op "="}
          [[{:kind "DRE" :name "token" :scope "local" :type "char *[11]"}]
           [{:kind "Index"}
            [{:kind "INT" :value "0"}]]]
          [{:kind "DRE" :name "uri" :scope "local" :type "char *"}]]

         [{:kind "While" :order 2
           :condition [{:kind "Binop" :op "&&" :note "condition"}
                       [{:kind "Binop" :op "!="}
                        [[{:kind "DRE" :name "uri" :scope "local" :type "char *"}]
                         [{:kind "Index"}
                          [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]]
                        [{:kind "CHAR" :value " "}]]
                       [{:kind "Binop" :op "<"}
                        [{:kind "DRE" :name "c" :scope "local" :type "int"}]
                        [{:kind "Binop" :op "+"}
                         [{:kind "INT" :value "10"}]
                         [{:kind "INT" :value "1"}]]]]
          :body [[{:kind "If" :note "body1"}
                  [{:kind "Binop" :op "=="}
                   [[{:kind "DRE" :name "uri" :scope "local" :type "char *"}]
                    [{:kind "Index"}
                     [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]]
                   [{:kind "CHAR" :value "?"}]]
                  [{:kind "Then"}
                   [{:kind "Unop" :op "++"}
                    [{:kind "DRE" :name "c" :scope "local" :type "int"}]]
                   [{:kind "Label" :name"VULN"}
                    [{:kind "Binop" :op "="}
                     [[{:kind "DRE" :name "token" :scope "local" :type "char *[11]"}]
                      [{:kind "Index"}
                       [{:kind "DRE" :name "c" :scope "local" :type "int"}]]]
                     [{:kind "Binop" :op "+"}
                      [{:kind "Binop" :op "+"}
                       [{:kind "DRE" :name "uri" :scope "local" :type "char *"}]
                       [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]
                      [{:kind "INT" :value "1"}]]]]
                   [{:kind "Binop" :op "="}
                    [[{:kind "DRE" :name "uri" :scope "local" :type "char *"}]
                     [{:kind "Index"}
                      [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]]
                    [{:kind "CHAR" :value " "}]]]]
          
                 [{:kind "Unop" :op "++" :note "body2"}
                  [{:kind "DRE" :name "cp" :scope "local" :type "int"}]]]}]]]
       [{:kind "Ret" :type "void"}]]]]
    [{:kind Func  :name "main" :type "int"}
     [{:kind Var :name uri :scope "local" :type"char [20]"}
      [{:kind "INT" :value "20"}]]
     [{:kind Var :name scheme :scope "local" :type"int"}]
     [{:kind "Binop" :op "="}
      [[{:kind "DRE" :name "uri" :scope "local" :type "char [20]"}]
       [{:kind "Index"}
        [{:kind "Binop" :op "-"}
         [{:kind "INT" :value "20"}]
         [{:kind "INT" :value "1"}]]]]
      [{:kind "CHAR" :value " "}]]
     [{:kind "Binop" :op "="}
      [{:kind "DRE" :name "scheme" :scope "local" :type "int"}]
      [{:kind "Binop" :op "+"}
       [{:kind "INT" :value "7"}]
       [{:kind "INT" :value "2"}]]]
     [[{:kind "DRE" :name "escape_absolute_uri" :type"void (char *, int)"}]
      [{:kind "DRE" :name "uri" :scope "local" :type "char [20]"}]
      [{:kind "DRE" :name "scheme" :scope "local" :type "int"}]]
     [{:kind "Ret" :type "int"}
      [{:kind "INT" :value "0"}]]]])
