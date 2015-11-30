(ns p4f.routes.social
  (:require [p4f.resources.social :refer [dice]]
            [compojure.core :refer [ANY]]))



(def social-routes
  (ANY "/api/social/dice" [] (dice)))
