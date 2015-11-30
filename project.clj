;; Constants

(def p4f-backend-version "0.0.1-SNAPSHOT")

;(def slf4j-version "1.7.13")
(def jackson-version "2.6.3")



;; Project

(defproject p4f-backend p4f-backend-version
  :description "The backend services of Play4Fun"
  :url "http://github.com/zhanghuabin/p4f"


  ;; plugins
  :plugins [[lein-ring "0.9.7"]
            [lein-ancient "0.6.8"]
            [lein-environ "1.0.1"]]


  ;; dependencies
  :dependencies [[org.clojure/clojure "1.7.0"]
                 ;; clojure
                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.clojure/clojurescript "1.7.170"
                  :exclusions [org.clojure/tools.reader]]
                 [org.clojure/core.async "0.2.374"]
                 [org.clojure/tools.reader "0.10.0"]
                 ;[org.clojure/tools.logging "0.3.1"]
                 [environ "1.0.1"]
                 ;; db ====>
                 [korma "0.4.2"]
                 [org.clojure/java.jdbc "0.4.2"]
                 ;; <==== db
                 ;; ring ====>
                 [ring "1.4.0"
                  :exclusions [ring/ring-jetty-adapter]]
                 [cc.qbits/jet "0.7.1"]
                 ;; <==== ring
                 ;; compojure
                 [compojure "1.4.0"]
                 ;; ring middleware ====>
                 [ring/ring-defaults "0.1.5"]
                 [ring-ttl-session "0.3.0"]
                 [metosin/ring-middleware-format "0.6.0"]
                 [metosin/ring-swagger-ui "2.1.3-4"]
                 [lib-noir "0.9.9"]
                 [prone "0.8.2"]
                 [selmer "0.9.5"]
                 ;; <==== ring middleware
                 ;; liberator
                 [liberator "0.14.0"]
                 ;; monger: a mongodb dsl
                 [com.novemberain/monger "3.0.1"]
                 ;; hiccup: an html dsl
                 [hiccup "1.0.5"]
                 ;; cheshire: json
                 [cheshire "5.5.0"]
                 [com.fasterxml.jackson.core/jackson-core ~jackson-version :scope "runtime"]
                 [com.fasterxml.jackson.dataformat/jackson-dataformat-smile ~jackson-version :scope "runtime"]
                 [com.fasterxml.jackson.dataformat/jackson-dataformat-cbor ~jackson-version :scope "runtime"]
                 ;; timbre
                 [com.taoensso/timbre "4.1.4"]]
                 ;; slf4j
                 ;[org.slf4j/slf4j-api ~slf4j-version :scope "runtime"]
                 ;[org.slf4j/jul-to-slf4j ~slf4j-version :scope "runtime"]
                 ;[org.slf4j/jcl-over-slf4j ~slf4j-version :scope "runtime"]
                 ;[org.slf4j/log4j-over-slf4j ~slf4j-version :scope "runtime"]
                 ;[com.fzakaria/slf4j-timbre "0.2.1"]
                 ;; logback
                 ;[ch.qos.logback/logback-classic "1.1.3" :scope "runtime"]
                 ;[org.codehaus.groovy/groovy-all "2.4.5" :classifier "indy" :scope "runtime"]

  ;; lein & jvm
  :min-lein-version   "2.5.0"
  ;:repl-options       {:timeout 120000}
  :javac-options      ["-source" "1.8" "-target" "1.8"]
  :jvm-opts ^:replace ["-server"
                       "-Xms2g"
                       "-Xmx2g"
                       "-XX:+UseG1GC"]
  :main p4f.core


  ;; profiles
  :profiles
  {:uberjar {:env {:production true}
             :aot :all}
   :dev  [:project/dev :profiles/dev]
   :test [:project/test :profiles/test]
   :project/dev {:dependencies [[ring/ring-devel "1.4.0"]
                                [ring-mock "0.1.5"]]
                 :ring {:auto-reload? true
                         :stacktraces? true}
                 :env {:dev        true
                       :port       8080}}

   :project/test {:env {:test       true
                        :port       9090}}
   :profiles/dev {}
   :profiles/test {}})
