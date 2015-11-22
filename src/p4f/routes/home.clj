(ns p4f.routes.home
  (:require [p4f.resources.home :refer [home-page]]
            [compojure.core :refer [GET]]))



(def home-routes
  (GET "/" [] (home-page)))
