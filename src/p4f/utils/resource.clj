(ns p4f.utils.resource)



(defn wrap-response-body
  [body]
  {::response {::body body}})

(defn unwrap-context
  [wrapped-body]
  (get-in wrapped-body [::response ::body]))
