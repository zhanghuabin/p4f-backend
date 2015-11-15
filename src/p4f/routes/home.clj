(ns p4f.routes.home
  (:require [p4f.resources.home :refer [home-page]]
            [compojure.core :refer [defroutes GET]]
            [hiccup.page :refer [html5 include-css]]
            [liberator.core :refer [defresource]]))


(def home-routes
  (GET "/" [] (home-page)))
