(ns ^:figwheel-always logger.core
  (:require
   [dommy.core :as dommy :refer-macros [sel1]]))

(enable-console-print!)

(println "logger.core")

;; Set up the initial logger
(defonce app-state (atom {:url "http://wal.sh/logger"}))

(def config {})

(defn send []
  (js/console.log "Logging")
  (-> (dommy/append-child (sel1 :body)
                          (-> (dommy/create-element :div)
                              (dommy/set-text! "Click me!"))))
  (-> (sel1 :script)
      (dommy/insert-after!
       (-> (dommy/create-element "img")
           (dommy/set-attr! "http://wal.sh/logger")))))
