(ns p4f.middleware
  (:require [environ.core :refer [env]]
            [noir.session :refer [wrap-noir-session]]
            [selmer.middleware :refer [wrap-error-page]]
            [prone.middleware :refer [wrap-exceptions]]
            [ring-ttl-session.core :refer [ttl-memory-store]]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [ring.middleware.format :refer [wrap-restful-format]]))




(defn wrap-dev [handler]
  (if (env :dev)
    (-> handler
        wrap-reload
        wrap-error-page
        wrap-exceptions)
    handler))

(defn wrap-formats [handler]
  (wrap-restful-format handler {:formats [:json-kw :transit-json :transit-msgpack]}))

(defn wrap-base [handler]
  (-> handler
      wrap-dev
      wrap-formats
      (wrap-defaults
        (-> site-defaults
            (assoc-in [:security :anti-forgery] false)
            (assoc-in [:session :store] (ttl-memory-store (* 60 30)))))
      wrap-noir-session))
