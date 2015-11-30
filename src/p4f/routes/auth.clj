(ns p4f.routes.auth
  (:require [p4f.resources.auth :refer [signup]]
            [compojure.core :refer [ANY]]))



(def auth-routes
  (ANY "/signup" [] (signup)))
