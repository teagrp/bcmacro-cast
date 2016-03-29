(defn ty->str [ty]
  (case ty
    char "Char"
    uchar "UnsignedChar"
    short "Short"
    ushort "UnsignedShort"
    int "Int"
    uint "UnsignedInt"
    long "Long"
    ulong "UnsignedLong"
    float "Float"
    double "Double"
    ldouble "LongDouble"
    void "Void"
    (throw (RuntimeException. (str "unknwon ty: " ty)))))

(defn ty->cap [ty]
  (case ty
    char 'c
    uchar 'uc
    short 's
    ushort 'us
    int 'i
    uint 'ui
    long 'l
    ulong 'ul
    float 'f
    double 'd
    ldouble 'ld
    void 'v
    (throw (RuntimeException. (str "unknwon ty: " ty)))))

(defn ty->ty-str [ty]
  (str (ty->str ty) "-type"))

(defn rule-name [src dst]
  (str "exp36-" (ty->cap src) (ty->cap dst)))

(defn gen-rule [p]
  (let [src (first p)
        dst (second p)]
    `(~'defrule ~(symbol (rule-name src dst))
      @{:type [... {:Pointee {:kind ~(ty->ty-str src)}} ...
               {:Pointee {:kind ~(ty->ty-str dst)}} ...]}
      ~(rule-name src dst))))

(def rules '[
             [char short]
             [char ushort]
             [char int]
             [char uint]
             [char long]
             [char ulong]
             [char float]
             [char double]
             [char ldouble]

             [uchar short]
             [uchar ushort]
             [uchar int]
             [uchar uint]
             [uchar long]
             [uchar ulong]
             [uchar float]
             [uchar double]
             [uchar ldouble]
             
             [short int]
             [short uint]
             [short long]
             [short ulong]
             [short float]
             [short double]
             [short ldouble]

             [ushort int]
             [ushort uint]
             [ushort long]
             [ushort ulong]
             [ushort float]
             [ushort double]
             [ushort ldouble]

             [int long]
             [int ulong]
             [int double]
             [int ldouble]

             [uint long]
             [uint ulong]
             [uint double]
             [uint ldouble]

             [long double]
             [long ldouble]

             [ulong double]
             [ulong ldouble]

             [float double]
             [float ldouble]

             [double ldouble]
             ])

(defn mymain []
  (map gen-rule rules))
