(ns p4f.handler
  (:require [p4f.routes.api :refer [api-routes]]
            [p4f.routes.error :refer [error-routes]]
            [p4f.routes.home :refer [home-routes]]
            [p4f.middleware :refer [wrap-base]]
            [compojure.core :refer [defroutes]]))



(defroutes app-routes
  home-routes
  api-routes
  error-routes)

(def app (wrap-base #'app-routes))
