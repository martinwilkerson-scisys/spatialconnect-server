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

(ns spacon.specs.device
  (:require [clojure.spec :as s]
            [clojure.test.check.generators :as gen]))

(def non-empty-string (s/with-gen
                        (s/and string? #(> (count %) 0))
                        #(gen/fmap identity gen/string-alphanumeric)))

;;; specs about device data
(s/def ::name non-empty-string)
(s/def ::identifier non-empty-string)
(s/def ::device_info (s/with-gen map?
                       #(gen/fmap (fn [[t1 t2]]
                                    {t1 t2}) (gen/tuple gen/keyword gen/string-alphanumeric))))
(s/def ::device-spec (s/keys :req-un [::name ::identifier ::device_info]))
