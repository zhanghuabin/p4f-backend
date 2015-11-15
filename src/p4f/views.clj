(ns p4f.views
  (:use [hiccup core page])
  (:require [clojure.tools.logging :as log]))



(defn index-page []
  (log/debug "access index page")
  (html5
    [:head
     [:title "Hello World"]
     (include-css "/css/style.css")]
    [:body
     [:h1 "Hello World!!!"]]))


(defn not-found-page []
  (html5
    [:head
     [:title "Page not found"]]
    [:body
     [:h1 "Page not found"]]))
