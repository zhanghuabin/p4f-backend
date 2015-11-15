(ns p4f.core
  (:use ring.adapter.jetty
        [p4f.handlers :only (app)]
        [ring.middleware.reload :only (wrap-reload)]
        [ring.middleware.stacktrace :only (wrap-stacktrace)]))



(defn -main [& args]
  (run-jetty
    (->
      #'app
      (wrap-reload)
      (wrap-stacktrace))
    {:port 8080 :join? false :auto-reload? true}))
