;; Copyright 2016-2017 Boundless, http://boundlessgeo.com
;;
;; Licensed under the Apache License, Version 2.0 (the "License");
;; you may not use this file except in compliance with the License.
;; You may obtain a copy of the License at
;;
;; http://www.apache.org/licenses/LICENSE-2.0
;;
;; Unless required by applicable law or agreed to in writing, software
;; distributed under the License is distributed on an "AS IS" BASIS,
;; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
;; See the License for the specific language governing permissions and
;; limitations under the License.

(ns spacon.components.organization.core
  (:require [com.stuartsierra.component :as component]
            [spacon.db.conn :as db]
            [yesql.core :refer [defqueries]]
            [clojure.tools.logging :as log]))

(defrecord OrganizationComponent []
  component/Lifecycle
  (start [this]
    (log/debug "Starting Organization Component")
    this)
  (stop [this]
    (log/debug "Stopping Organization Component")
    this))

(defn make-organization-component []
  (->OrganizationComponent))

(defqueries "sql/organization.sql" {:connection db/db-spec})
