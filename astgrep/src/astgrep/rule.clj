(ns astgrep.rule
  (:use bcmacro.core)
  (:gen-class))

;; defrule
(defmacro defrule [name pat msg]
  `(defbcmacro ~name ~pat
     (println "rule violation:" ~msg)))

(defn get-rule-vars [ns]
  (filter (comp :bcmacro meta) (vals (ns-interns *ns*))))
