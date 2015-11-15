(defproject p4f-backend "1.0.0"
  :description "The backend services of Play4Fun"
  :url "http://github.com/zhanghuabin/p4f"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [hiccup "1.0.5"]
                 [cheshire "5.5.0"]
                 [com.fasterxml.jackson.core/jackson-core "2.6.3"]
                 [com.fasterxml.jackson.dataformat/jackson-dataformat-smile "2.6.3"]
                 [com.fasterxml.jackson.dataformat/jackson-dataformat-cbor "2.6.3"]
                 [liberator "0.13"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [metosin/ring-swagger-ui "2.1.3-2"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.slf4j/slf4j-api "1.7.12"]
                 [org.slf4j/jul-to-slf4j "1.7.12"]
                 [org.slf4j/jcl-over-slf4j "1.7.12"]
                 [org.slf4j/log4j-over-slf4j "1.7.12"]
                 [ch.qos.logback/logback-classic "1.1.3"]
                 [org.codehaus.groovy/groovy-all "2.4.5" :classifier "indy"]]

  :plugins [[lein-ring "0.9.7"]
            [lein-ancient "0.6.8"]]

  :profiles     {:uberjar {:aot :all}
                 :dev {:dependencies [[ring/ring-devel "1.4.0"]
                                      [ring-mock "0.1.5"]]
                       :ring {:auto-reload? true :stacktraces? true}}}

  :min-lein-version   "2.5.0"
  ;:source-paths       ["src/main/clojure"]
  ;:test-paths         ["src/test/clojure"]
  ;:resource-paths     ["src/main/resources"]
  ;:war-resource-paths ["src/main/resources"]
  ;:java-source-paths  ["src/main/java"]

  :javac-options      ["-source" "1.8" "-target" "1.8"]
  :jvm-opts ^:replace ["-server"
                       "-Xms1g"
                       "-Xmx1g"
                       "-XX:+UseG1GC"]

  :ring {:handler org.github.zhanghuabin.pf.routes/app})
