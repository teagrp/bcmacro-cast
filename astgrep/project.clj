(defproject astgrep "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojars.umatani/bcmacro "0.2.0-SNAPSHOT"]
                 [instaparse "1.4.1"]]
  :main ^:skip-aot astgrep.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
