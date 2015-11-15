(ns p4f.resources.api.social
  (:require [p4f.services.social :refer [roll]]
            [liberator.core :refer [defresource]]))



(defn- wrap-response-body
  [body]
  {::response {::body body}})


(defresource dice
  ^{:doc "骰子"}
  []
  :available-media-types #{"application/json"}
  :allowed-methods [:post]

  :post!
  (fn [context]
    (let [params  (get-in context [:request :params])
          text    (:text params)]
      (wrap-response-body
        {::roll-result  (roll)
         ::message      text})))

  :handle-created
  (fn [context]
    (let [response-body (get-in context [::response ::body])]
      response-body)))

