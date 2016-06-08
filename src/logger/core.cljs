(ns ^:figwheel-always logger.core
  (:require
   [om.core :as om]
   [om.dom :as dom]
   [dommy.core :as dommy :refer-macros [sel sel1]]))

(enable-console-print!)

(println "logger.core")

(defonce app-state (atom {:url "http://p.wal.sh/defrecord"}))

(defn click-handler [e]
  (js/console.log "Logged")
  (dommy/append!
   (sel1 :body)
   (dommy/set-attr!
    (dommy/create-element :img)
    "src"
    "http://p.wal.sh/defrecord/1x1-event.gif")))

(defn event-logger [msg]
  (js/console.log (str "Logged event: " msg))
  (dommy/append!
   (sel1 :body)
   (dommy/set-attr!
    (dommy/create-element :img)
    "src"
    (str
     "http://p.wal.sh/defrecord/1x1-event.gif?"
     msg))))

(defn logger [msg]
  (js/console.log "logger")
  (dommy/append!
   (sel1 :body)
   (-> (dommy/create-element :button)
       (dommy/add-class! :logger)
       (dommy/set-text! "Log")))
  (dommy/listen! (sel1 ".logger") :click click-handler))

(defn poll-logger []
  (def poller
    (.setTimeout js/window #(event-logger (str (.now js/Date) "-polled")) 1000)))

(defn scroll-logger []
  (dommy/listen! (sel1 :body) :scroll event-handler))

(defn main []
  (js/console.log "main")
  (dommy/append!
   (sel1 :body)
   (dommy/set-attr!
    (dommy/create-element :img)
    "src"
    "http://p.wal.sh/defrecord/1x1-load.gif"))
  (logger)
  (poll-logger))

(defn sidebar [_]
  (reify
    om/IRender
    (render [_]
      (dom/ul nil ""))))

(defn sidebar-item [_]
  (reify
    om/IRender
    (render [_]
      (dom/li nil ""))))

(defn log-header [_]
  (reify
    om/IRender
    (render [_]
      (dom/h1 nil "Logs"))))

(defn log-item [data owner]
  (reify
    om/IRender
    (render [this]
      (dom/p nil (:text data)))))

(main)
