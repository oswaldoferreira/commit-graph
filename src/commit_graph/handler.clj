(ns commit-graph.handler)

(require '[ring.middleware.json :refer [wrap-json-response]]
         '[ring.util.response :refer [response]])

(defn handler [request]
  (response {:foo "bar"}))

(def app
  (wrap-json-response handler))

