(ns ^:figwheel-always logger.core
  (:require
   [dommy.core :as dommy :refer-macros [sel sel1]]))

(enable-console-print!)

(println "logger.core")

(defonce app-state (atom {:url "http://p.wal.sh/defrecord"}))

(defn logger []
  (js/console.log "logger")
  (dommy/append!
   (sel1 :body)
   (-> (dommy/create-element :div)
       (dommy/set-text! "Log")))
  (dommy/append!
   (sel1 :body)
   (-> (dommy/create-element :img)
       (dommy/set-attr! "src" "http://p.wal.sh/defrecord/1x1-event.gif"))))

(defn main []
  (js/console.log "main")
  (dommy/append!
   (sel1 :body)
   (-> (dommy/create-element :img)
       (dommy/set-attr! "src" "http://p.wal.sh/defrecord/1x1-load.gif")))
  (logger))

(main)
