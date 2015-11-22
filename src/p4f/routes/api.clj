(ns p4f.routes.api
  (:require [p4f.resources.api.social :refer [dice]]
            [compojure.core :refer [ANY]]))



(def api-routes
  (ANY "/api/social/dice" [] (dice)))
