(ns p4f.routes.home
  (:require [p4f.resources.home :refer [home-page]]
            [compojure.core :refer [ANY]]))



(def home-routes
  (ANY "/" [] (home-page)))
