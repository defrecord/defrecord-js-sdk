(defproject logger "0.1.0-SNAPSHOT"
  :description "defrecord JavaScript SDK for site owners"
  :url "http://defrecord.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.40"]
                 [org.clojure/core.async "0.2.374"]
                 [clj-time "0.11.0"]
                 [clj-yaml "0.4.0"]
                 [defun "0.2.0"]
                 [figwheel "0.5.2"]
                 [incanter "1.9.0"]
                 [lumberjack "0.1.0"]
                 [prismatic/dommy "1.1.0"]
                 ]
  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-figwheel "0.5.1"]
            [s3-wagon-private "1.2.0"]
            ]
  :source-paths ["src"]
  :repositories [["releases" {:url "s3p://defrecord/releases/" :creds :gpg}]]
  :clean-targets ^{:protect false} ["resources/public/js/compiled"]
  :essthree {:deploy {:type       :directory
                      :bucket     "defrecord.assets"
                      :local-root "resources/public/js/compiled/"
                      :aws-creds {:access-key-id "access-key-id"
                                  :secret-access-key "secret-access-key"}}}
  :cljsbuild {
              :builds [{:id "dev"
              :source-paths ["src"]
              :compiler {:output-to "resources/public/js/compiled/defrecord.logger.js"
                         :output-dir "resources/public/js/compiled/out"
                         :optimizations :none
                         :main logger.core
                         :asset-path "js/compiled/out"
                         :source-map true
                         :source-map-timestamp true
                         :cache-analysis true }}
             {:id "min"
              :source-paths ["src"]
              :compiler {:output-to "resources/public/js/compiled/defrecord.logger.min.js"
                         :main logger.core
                         :optimizations :advanced
                         :pretty-print false}}]}
  :figwheel {
             :http-server-root "public" ;; default and assumes "resources"
             :server-port 3449 ;; default
             :css-dirs ["resources/public/css"] ;; watch and update CSS
             })
