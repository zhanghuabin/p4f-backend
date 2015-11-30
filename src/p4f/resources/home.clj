(ns p4f.resources.home
  (:require [taoensso.timbre :as log]
            [hiccup.page :refer [html5 include-css]]
            [liberator.core :refer [defresource]]))



(defn- make-home-page
  []
  (log/debug "access home page")
  (html5
    [:head
     [:title "Play for fun"]
     (include-css "/css/style.css")]
    [:body
     [:h1 "Hello, World!!!"]]))

(defresource home-page
  ^{:doc "注册签约"}
  []
  :allowed-methods [:get]
  :available-media-types #{"text/html"}

  :handle-ok
  (fn [_]
   (make-home-page)))
