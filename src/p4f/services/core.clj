(ns p4f.services.core
  (:require [p4f.repo.core :as repo]
            [taoensso.timbre :as log]
            [selmer.parser :as parser]
            [environ.core :refer [env]]))


(defn init
  "init will be called once when
   app is deployed as a servlet on
   an app server such as Tomcat
   put any initialization code here"
  []

  (if (env :dev) (parser/cache-off!))
  (repo/connect!)
  (log/info (str
              "\n-=[backend started successfully"
              (when (env :dev) " using the development profile")
              "]=-")))

(defn destroy
  "destroy will be called when your application
   shuts down, put any clean up code here"
  []
  (log/info "backend is shutting down...")
  (repo/disconnect!)
  (log/info "shutdown complete!"))
