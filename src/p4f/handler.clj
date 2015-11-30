(ns p4f.handler
  (:require [p4f.routes.social :refer [social-routes]]
            [p4f.routes.error :refer [error-routes]]
            [p4f.routes.home :refer [home-routes]]
            [p4f.routes.auth :refer [auth-routes]]
            [p4f.middleware :refer [wrap-base]]
            [compojure.core :refer [defroutes]]))



(defroutes app-routes
  home-routes
  auth-routes
  social-routes
  error-routes)

(def app (wrap-base #'app-routes))
