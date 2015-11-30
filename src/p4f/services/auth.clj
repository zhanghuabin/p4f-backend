(ns p4f.services.auth
  (:require [noir.session :as session]
            [taoensso.timbre :as log]))


(defn signup
  [id password password-retype]
  (if (= password password-retype)
    (do
      (session/put! :user id)
      {:status :ok})
    (do
      (log/debug "密码输入不一致")
      {:status :error :message "密码输入不一致"})))
