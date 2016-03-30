(ns astgrep.debug
  (:require [instaparse.core :as insta])
  (:gen-class))

#_(def my-parser
  (insta/parser
   "sentence = word
     vector = '[' atom (whitespace atom)* ']'
     atom = word | number | str
     word = #'[a-zA-Z]+'
     number = #'[0-9]+'
     str = '\"' #'[^\"]*' '\"'
     paren = '(' | ')'
     bracket = '[' | ']'
     brace = '{' | '}'
     whitespace = #'\\s+'
   "
   ))

(def my-parser
  (insta/parser
   "sentence = <whitespace>? atom (<whitespace>? atom)* <whitespace>?
     whitespace = (#'\\s+' | ';' #'[^\n]*' '\n' | ',')*
     atom = word | number | str | vector | map
          | seq | key | special | readmacro | '\\'' atom | '@' atom
     str = '\"' #'[^\"]*' '\"'
     word = #'([:./_^?*+a-zA-Z0-9]|-)+'
     key = ':' word
     vector = '[' <whitespace>? (atom (<whitespace>? atom)*)? <whitespace>? ']'
     seq = '(' <whitespace>? (atom (<whitespace>? atom)*)? <whitespace>? ')'
     map = '{' <whitespace>? (kv (<whitespace>? kv)*)? <whitespace>? '}'
     kv = key <whitespace>? atom
     number = #'([0-9./]|-)+'
     special = '&'
     readmacro = '#' word
   "
   ))
 
(defn read-str-from-file [fname]
  (let [rdr (java.io.BufferedReader.
             (java.io.FileReader. (clojure.java.io/file fname)))
        ]
    (binding [*in* rdr]
      (loop [s (read-line)
             buf (StringBuilder.)]
        (if s
          (recur (read-line) (.append (.append buf s) "\n"))
          (.toString buf))))))

(defn main [fname]
  (let [s (read-str-from-file fname)]
    (my-parser s)))


