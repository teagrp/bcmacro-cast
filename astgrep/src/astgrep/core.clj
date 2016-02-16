(ns astgrep.core
  (:use [clojure.java.shell :as shell]
        bcmacro.core astgrep.rule)
  (:gen-class))

;; main function
(defn -main
  "args: rule-file [src-file]
    If src-file is not specified, it reads from stdin."
  [& args]
  (let [rule-file (first args)
        src-file (second args)

        rule-rdr (java.io.PushbackReader.
                  (clojure.java.io/reader rule-file))
        src-rdr (java.io.PushbackReader.
                 (clojure.java.io/reader (or src-file System/in)))]
    #_(println "src-rdr:" src-rdr)
    (let [ast (cond
                (or (.endsWith src-file ".c")
                    (.endsWith src-file ".cpp"))
                (let [cmd ["../bin/astprint " src-file " --"]]
                  (read-string
                   (:out (apply shell/sh cmd))))
                
                (or (nil? src-file)
                    (.endsWith src-file ".ast")
                    (.endsWith src-file ".out"))
                (read src-rdr)
                :else (throw (Exception. "src-file not supported.")))]
      #_(println "ast:" ast)
      #_(println "rule:" (read rule-rdr))
      (binding [*ns* (create-ns 'astgrep.rule)]
        #_(eval '(defrule plus-assign @{:kind "Binop" :op "+="}
                   "Very bad!!!"))
        #_(eval (read rule-rdr))
        (try (loop []
               (eval (read rule-rdr))
               (recur))
             (catch RuntimeException e
               (when-not (.startsWith (.getMessage e) "EOF")
                 (throw e))))
        (when-let [rule-vars (get-rule-vars *ns*)]
          (bcexpand-all rule-vars ast)
          nil)))))

#_(-main "src/astgrep/sample_rule.clj"
         "../samplecode/floatloop.out")
