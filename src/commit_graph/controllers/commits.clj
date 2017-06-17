(ns commit-graph.controllers.commits
  (:require [compojure.core :refer [defroutes GET POST]]
            [clojure.string :as str]
            [ring.util.response :as ring]
            [commit-graph.models.commit :as model]))

;; decide how to build json with sql
;; (defn index []
;;   ())

(defroutes routes
  (GET  "/x" [] (:foo "bar")))
