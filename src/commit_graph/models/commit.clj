(ns commit-graph.models.commit
  (:require [clojure.java.jdbc :as sql]))

(extend-type java.sql.Timestamp
  json/JSONWriter
  (-write [date out]
    (json/-write (str date) out)))

(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/commit_graph"))

(defn all []
  (sql/query spec ["select * from commits"]))

(defn create []
  (sql/insert! spec :commits {:message "They see me flooding"}))
