(ns astgrep.test
  (:use bcmacro.core))

; 古いバージョンでのみ動く
(defbcmacro assign ^:vk @[{"Binop" :kind, "=" :op} 
                          [a [{"Index" :kind} ...]] 
                          z]
  (println `(found ~a ~z))
  0)

; 古いバージョンでのみ動く
(defbcmacro while-assign2 ^:vk @[{"While" :kind}
                                 c
                                 (... :as l)]
  (println `(found ~l))
  0)

; 古いバージョンでのみ動く
(defbcmacro while-assign ^:vk [{"While" :kind}
                               condition
                               ...
                               #nest @[{"Binop" :kind, "=" :op} 
                                       [a [{"Index" :kind} ...]] 
                                       z] 
                               ...]
  (println `(found ~a ~z))
  0)

; 古いバージョンでのみ動く
(defbcmacro while-assign3 ^:vk [{"While" :kind}
                                condition
                                ...
                                may-inc
                                ...
                                #nest @[{"Binop" :kind, "=" :op} 
                                        [a [{"Index" :kind} ...]] 
                                        z] 
                                ...]
  (println may-inc)
  (letbcmacro [(search-inc ^:vk [... #nest [@{"Unop" :kind "++" :op} ...]]
                 (println `(found)))]
              (bcexpand-1 [search-inc] may-inc) 
              0))

; 最終版 ; 古いバージョンでのみ動く
(defbcmacro while-assign4 ^:vk [{"While" :kind}
                                condition
                                ...
                                #nest [... 
                                       [{"Unop" :kind "++" :op} (... :as m)]  ; ここに #nest を使えない. 変数で受けると必ず()に最も近いものに束縛されてしまう
                                       ...
                                       #nest @([{"Binop" :kind, "=" :op} 
                                                [a [{"Index" :kind} [{c :name}]]] 
                                                z] :as arr)
                                       ...]
                                ...]
  (letbcmacro [(condi ^:vk [... #nest [@{"Binop" :kind "<" :op}
                                       ... [{~c :name}] ...] ...]
                      (println :condi c arr)
                      0)]
              (bcexpand-1 [condi] condition) 
              0))

; astprint が出力する AST を変更して、こんな感じで書けるようにしたい
; 古いバージョンでのみ動く
(defbcmacro while-assign5 ^:vk {"While" :kind
                                condition :condition
                                [...
                                 #nest
                                 [... 
                                  [{"Unop" :kind "++" :op} (... :as m)]
                                  ...
                                  #nest @([{"Binop" :kind, "=" :op} 
                                           [a [{"Index" :kind} [{c :name}]]] 
                                           z ]:as arr)
                                  ...]
                                 ...] :body}
  (letbcmacro [(justc @"c"
                      (println :condi c arr)
                      0)
               (condi ^:vk [...
                            #nest [@{"Binop" :kind "<" :op}
                                   ... [{~c :name}] ...]
                            ...]
                      (bcexpand-1 [justc] c))]
              (bcexpand-1 [condi] condition) 
              0))


; bcmacro が改良されてこんな感じで書けるようになるといいなあ
; 古いバージョンでのみ動く
#_(defbcmacro while-assigna {"While" :kind
                           condition :condition
                           [...
                            #nest [(... :as may-inc)
                                   #nest @ [{"Binop" :kind, "=" :op} 
                                                  [a [{"Index" :kind} [{c :name}]]] 
                                                  z :as arr] :as target
                                   ...]
                            ...] :body}

  ;(println )
  (letbcmacro [(condi [... #nest [@ {"Binop" :kind "<" :op} :as target ... [{~c :name}] ...] ...]
                      ;(println :condi c arr)
                      (my-warn "array boundary error" target)
                      (with-stop-mark target))
               (search-inc (@ {"Unop" :kind "++" :op 
                                     {"DRE" :kind ~c :name} :operand} :as target)
                           (bcexpand-1 [condi] condition)
                           (with-stop-mark target))] 
              (expand-1 [search-inc] may-inc))
    (with-stop-mark target))

(defn my-warn [msg target]
  (println msg ":" (:file target) ":" (:line target)))

; 古いバージョンでのみ動く
(defbcmacro while-assign-simple ^:vk [{"While" :kind}
                                      c
                                      ...
                                      #nest @"Binop" 
                                      ... ]
  (println `(found ~c))
  0)

; 古いバージョンでのみ動く
(defbcmacro for-loop ^:vk [@{"For" :kind
                             [... {"Binop" :kind "," :op} ...] :init
                             }]
  (println :FOR-LOOP)
  0)

; 古いバージョンでのみ動く
(defbcmacro jobject-find1 ^:vk [... 
                                [@{[[{"Binop" :kind "=" :op}
                                     [{"global" :scope "jobject" :type}]
                                     [{"local" :scope "jobject" :type}]]
                                    ...] :body}]]
  (println :FINDOUT)
  0)

; 古いバージョンでのみ動く
(defbcmacro jobject-find2 ^:vk [[@{"Binop" :kind "=" :op}
                                 [{"global" :scope "jobject" :type}]
                                 [{"local" :scope "jobject" :type}]]
                                ...]
  (println :FINDOUT)
  0)

; 最新版
(defbcmacro jobject-find3 ^:vk [@{"Binop" :kind "=" :op
                                  {"global" :scope
                                   {"jobject" :typename} :type} :LHS
                                  {"local" :scope
                                   {"jobject" :typename} :type} :RHS}
                                ...]
  (println :FINDOUT)
  0)

(defbcmacro jobject-find4 ^:vk @{"Binop" :kind "=" :op
                                 {(scope :when (not= scope "local")) :scope}
                                 :LHS
                                 {"local" :scope
                                  {"jobject" :typename} :type} :RHS}

  (println :Found))

(defbcmacro jobject-find5 ^:vk @{"Binop" :kind "=" :op
                                 { {"jobject" :typename} :type} :LHS
                                 {"local" :scope
                                  {"jobject" :typename} :type} :RHS}
  (println :FINDOUT))

;(bcexpand-all [jobject-find5] jnijobject)
