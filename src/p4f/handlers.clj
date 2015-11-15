(ns p4f.handlers
  (:require [compojure.handler :refer [site]]
            [compojure.route :refer [resources]]
            [p4f.routes.api :refer :all]
            [p4f.routes.error :refer :all]
            [p4f.routes.home :refer :all])
  (:use compojure.core
        [hiccup.middleware :only (wrap-base-url)]))

;(defresource my-res
;  [name]
;  :available-media-types #{"application/json"}
;  :allowed-methods [:get]
;  :handle-ok (generate-string
;               {:text (str "hello, " name "!")}))
;
;(defresource roll
;  []
;  :available-media-types #{"application/json"}
;  :allowed-methods [:post]
;  :post! (fn [{{{:keys [text]} :params} :request :as ctx}]
;           {:roll-result (rand) :text text})
;  :handle-created (fn [ctx]
;                    (generate-string
;                      (->> (map #(do {% (% ctx)}) '(:roll-result :text))
;                           (into {})))))
;
;(defroutes main-routes
;           (GET "/" [] (index-page))
;           (ANY "/res" []  resource)
;           (ANY "/my-res/:name" [name] (my-res name))
;           (ANY "/roll" [] (roll))
;           (r/resources "/") ;{:root "web"}
;           (r/not-found (not-found-page)))


(defroutes main-routes
  (resources "/")
  api-routes
  home-routes
  error-routes) ;{:root "web"})

(def app
  (-> (site main-routes)
      (wrap-base-url)))
