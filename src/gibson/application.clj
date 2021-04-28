(ns gibson.application
  (:require [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [gibson.routes :as routes]))

(def app
  (wrap-defaults routes/app-routes api-defaults))