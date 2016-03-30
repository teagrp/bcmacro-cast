(ns astgrep.rule
  (:use bcmacro.core)
  (:gen-class))

;; defrule

(defn trans [pat sf sl sc]
  (if (and (seq? pat) (= 'clojure.core/deref (first (seq pat))))
    `(clojure.core/deref ~(assoc (second pat) :loc-begin [sf sl sc]))
    (cond (vector? pat)
          (mapv #(trans % sf sl sc) pat)
          (map? pat)
          (into {} (map (fn [[k p]] [k (trans p sf sl sc)])
                        pat))
          :else pat)))

(defmacro defrule [name pat msg]
  (let [sf (gensym) sl (gensym) sc (gensym)]
    `(defbcmacro ~name ~(trans pat sf sl sc)
       (when (or ~sf ~sl ~sc)
         (print (str ~sf ":" ~sl ":" ~sc ": ")))
       (println ~msg))))

(defn get-rule-vars [ns]
  (filter (comp :bcmacro meta) (vals (ns-interns *ns*))))
