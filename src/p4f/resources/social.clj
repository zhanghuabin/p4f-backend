(ns p4f.resources.social
  (:require [p4f.services.social :refer [roll]]
            [p4f.utils.resource :refer [wrap-response-body unwrap-context]]
            [liberator.core :refer [defresource]]))



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
    (unwrap-context context)))

