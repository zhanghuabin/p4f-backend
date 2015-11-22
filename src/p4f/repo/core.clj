(ns p4f.repo.core
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [monger.operators :refer :all]
            [environ.core :refer [env]]))



(defonce db (atom nil))

(defn connect!
  "连接mongodb"
  []
  (reset! db (->
               (:database-url env)
               mg/connect-via-uri
               :conn)))

(defn disconnect! []
  (when-let [conn @db]
    (mg/disconnect conn)
    (reset! db nil)))
