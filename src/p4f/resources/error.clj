(ns p4f.resources.error
  (:require [hiccup.page :refer [html5]]))



(defn not-found-page
  []
  (html5
    [:head
     [:title "Page not found"]]
    [:body
     [:h1 "Page not found"]]))
