(defproject commit-graph "0.1.0-SNAPSHOT"
  :description "Commit graph"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [org.clojure/data.json "0.2.6"]
                 [ring/ring-defaults "0.2.1"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler commit-graph.web/application}
  :main commit-graph.web
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]
                        [org.clojure/java.jdbc "0.6.1"]
                        [org.postgresql/postgresql "9.4-1201-jdbc41"]]}})
