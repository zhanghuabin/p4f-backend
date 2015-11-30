(ns p4f.resources.auth
  (:require [p4f.services.auth :as auth]
            [p4f.utils.resource :refer [wrap-response-body unwrap-context]]
            [hiccup.page :refer [html5 include-css]]
            [hiccup.form :refer :all]
            [liberator.core :refer [defresource]]
            [taoensso.timbre :as log]))



(defn- signup-page
  []
  (log/debug "signup page")
  (html5
    [:head
     [:title "Sign up"]
     (include-css "/css/style.css")]
    [:body
     [:h1 "Sign up"]
     [:br]
     (form-to
       [:post "/signup"]
       (label "id-label" "user id")
       (text-field "id")
       [:br]
       (label "password" "password")
       (password-field "password")
       [:br]
       (label "password-retype" "retype password")
       (password-field "password-retype")
       [:br]
       (submit-button "create account"))]))



(defresource signup
  ^{:doc "注册签约"}
  []

  :allowed-methods
  [:get :post]

  :available-media-types
  ["application/json" "text/html"]

  :post!
  (fn [context]
    (let [params  (get-in context [:request :params])
          {:keys [id password password-retype]} params]
      (wrap-response-body
        (auth/signup id password password-retype))))

  :handle-created
  (fn [context]
    (unwrap-context context))

  :handle-ok
  (fn [_]
    (signup-page)))


