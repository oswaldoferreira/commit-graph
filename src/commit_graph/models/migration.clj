(ns commit-graph.models.migration
  (:require [clojure.java.jdbc :as sql]
            [commit-graph.models.commit :as commit]))

(defn migrated? []
  (-> (sql/query commit/spec
                 [(str "select count(*) from information_schema.tables "
                       "where table_name='commits'")])
      first :count pos?))

(defn migrate []
  (when (not (migrated?))
    (print "Creating database structure...") (flush)
    (sql/db-do-commands commit/spec
                        (sql/create-table-ddl
                         :commits
                         [[:id :serial "PRIMARY KEY"]
                          [:message "varchar(32)"]
                          [:created_at :timestamp
                           "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"]]))
    (println " done")))
