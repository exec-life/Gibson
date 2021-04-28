(ns gibson.routes
  (:require [gibson.handler :as handler]
            [gibson.middleware :as mw]))

(defroutes app-routes
  (GET "/" [] "Hello World!")
  (route/not-found "Not Found"))