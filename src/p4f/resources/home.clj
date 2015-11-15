(ns p4f.resources.home
  (:require [clojure.tools.logging :as log]
            [hiccup.page :refer [html5 include-css]]
            [liberator.core :refer [defresource]]))


(defn home-page
  []
  (log/debug "access home page")
  (html5
    [:head
     [:title "Play for fun"]
     (include-css "/css/style.css")]
    [:body
     [:h1 "Hello, World!!!"]]))
