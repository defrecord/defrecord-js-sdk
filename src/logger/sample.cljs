(ns ^:figwheel-always logger.sample
    (:require [dommy.core
]
              ))

(enable-console-print!)

(println "logger.sample")

;; Lumberjack
(use 'lumberjack.core)
(use 'lumberjack.nginx)
(use 'lumberjack.visualization)
(def logs (nginx-logs ["data/nginx/access.log"]))
(view-time-series logs :by timestamp-minute :grouping-name "minute")
(map :timestamp logs)

;; Incanter
(view (histogram (sample-normal 1000)))

;; Time
(require '[clj-time.core :as t])
(t/date-time 1986 10 14 4 3 27 456)
