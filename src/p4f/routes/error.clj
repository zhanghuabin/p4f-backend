(ns p4f.routes.error
  (:require [p4f.resources.error :refer [not-found-page]]
            [compojure.route :refer [not-found]]))



(def error-routes
  (not-found (not-found-page)))
