(ns build
  (:require
   [clojure.tools.build.api :as b]
   [org.corfield.build :as bb]))

(defn kotlin
  [_]
  (b/process {:command-args ["./gradlew" "clean" "build"]}))

(defn run
  [opts]
  (kotlin opts)
  (-> opts
      (bb/run-task [:run])))
