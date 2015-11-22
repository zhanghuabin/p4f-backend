(ns p4f.resources.home
  (:require [taoensso.timbre :as log]
            [hiccup.page :refer [html5 include-css]]))



(defn home-page
  []
  (log/debug "access home page")
  (html5
    [:head
     [:title "Play for fun"]
     (include-css "/css/style.css")]
    [:body
     [:h1 "Hello, World!!!"]]))
