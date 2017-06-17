(ns commit-graph.web
  (:require [compojure.core :refer [defroutes]]
            [ring.adapter.jetty :as ring]
            [ring.util.response :refer [response]]
            [ring.middleware.json :refer [wrap-json-response]]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [commit-graph.models.commit :as model]
            [commit-graph.controllers.commits :as commits]
            [commit-graph.models.migration :as schema])
  (:gen-class))

(defn handler [request]
  (response (model/all)))

(def application (wrap-json-response handler site-defaults))

(defn start [port]
  (ring/run-jetty application {:port port
                               :join? false}))

(defn -main []
  (schema/migrate)
  (let [port (Integer. (or (System/getenv "PORT") "8080"))]
    (start port)))

;; (ns commit-graph.handler)

;; (require '[ring.middleware.json :refer [wrap-json-response]]
;;          '[ring.util.response :refer [response]])

;; (def app
;;   (wrap-json-response handler))
;; (defn handler
;;   commits/routes
;;   (route/resources "/"))

