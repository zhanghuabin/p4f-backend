(ns p4f.handlers
  (:require [compojure.handler :refer [site]]
            [compojure.route :refer [resources]]
            [p4f.routes.api :refer :all]
            [p4f.routes.error :refer :all]
            [p4f.routes.home :refer :all])
  (:use compojure.core
        [hiccup.middleware :only (wrap-base-url)]))



(defroutes main-routes
  (resources "/") ;{:root "web"})
  home-routes
  api-routes
  error-routes)


(def app
  (->
    (site main-routes)
    (wrap-base-url)))
