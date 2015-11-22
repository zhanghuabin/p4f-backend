(ns p4f.core
  (:require [p4f.handler :refer [app]]
            [taoensso.timbre :as log]
            [environ.core :refer [env]]
            [qbits.jet.server :refer [run-jetty]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.stacktrace :refer [wrap-stacktrace]]))



(defonce http-server (atom nil))

(defn- parse-port [port]
  (when port
    (cond
      (string? port) (Integer/parseInt port)
      (number? port) port
      :else          (throw (Exception. (str "invalid port value: " port))))))

(defn- http-port [port]
  (parse-port (or port (env :port) 8080)))

(defn- start-http-server [port]
  (reset! http-server
          (run-jetty
            {:ring-handler  #'app
             :port          port
             :join?         false
             :auto-reload?  true})))

(defn- stop-http-server []
  (when @http-server
    (.stop @http-server)
    (reset! http-server nil)))


(defn stop-app []
  (stop-http-server))
  ;(shutdown-agents))

(defn start-app [[port]]
  (let [port (http-port port)]
    (.addShutdownHook (Runtime/getRuntime) (Thread. stop-app))
    (log/info "server is starting on port " port)
    (start-http-server port)))


(defn -main [& args]
  (start-app args))







;(defn -main [& args]
;  (run-jetty
;    (->
;      #'app
;      (wrap-reload)
;      (wrap-stacktrace))
;    {:port 8080 :join? false :auto-reload? true}))
