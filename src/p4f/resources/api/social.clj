(ns p4f.resources.api.social
  (:require [p4f.services.social :refer [roll]]
            [liberator.core :refer [defresource]]))


(defresource dice
  []
  :available-media-types #{"application/json"}
  :allowed-methods [:post]
  :post!(fn [{{{:keys [text]} :params} :request}]
           {:roll-result (roll) :message text})
  :handle-created (fn [ctx]
                    (->> (map #(do {% (% ctx)})
                              '(:roll-result :message))
                         (into {}))))
