(ns online.harrigan.cotlin.main
  (:import
   [online.harrigan.cotlin ApplicationKt]
   [online.harrigan.cotlin Application]
   [online.harrigan.cotlin Pet]
   [online.harrigan.cotlin Vocalise]))

(defn ^:private pet
  [name]
  (Pet. name)) ;; Pet is a Kotlin data class.

(defn ^:private vocalise
  []
  (reify Vocalise
    (bark [this]
      "Woof!")))

(defn ^:private say-something
  []
  (.. (Application.) (saySomething "how much is that doggy in the window?")))

(defn ^:private do-it
  []
  (println "Hello Clojure World!")
  (ApplicationKt/main)
  (let [biscuit (pet "Biscuit")]
    (println (str "Good Boy " (.getName biscuit)))
    (println (str "Woof " (.bark (vocalise))))
    (println (say-something))))

(defn -main
  [& _]
  (do-it))
