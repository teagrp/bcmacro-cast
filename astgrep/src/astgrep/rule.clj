(ns astgrep.rule
  (:use bcmacro.core)
  (:gen-class))

;; defrule
(defmacro defrule [name pat msg]
  `(let [~'$file nil ~'$line nil ~'$col nil]
     (defbcmacro ~name ~pat
       (when (or ~'$file ~'$line ~'$col)
         (print (str ~'$file ":" ~'$line ":" ~'$col ": ")))
       (println ~msg))))

(defn get-rule-vars [ns]
  (filter (comp :bcmacro meta) (vals (ns-interns *ns*))))
