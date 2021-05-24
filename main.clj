#!/usr/bin/env bb
(ns main 
  (:require [org.httpkit.server :refer [run-server]]
            [clojure.pprint :refer [pprint]]
            ))

(defn handler [{:keys [uri]}]
   (case uri
     "/dev-blog" (shell "echo hi"))
   {:status 200})

(defonce server (atom nil))
(reset! server (run-server handler {:port 9494}))

;; Prevent process from ending
@(promise)
