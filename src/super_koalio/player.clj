(ns super-koalio.player
  (:require [play-clj.core :refer :all]))

(defn move-sideways []
  (cond
    (key-pressed? :dpad-left) -14
    (key-pressed? :dpad-right) 14
    :else 0))

(defn jump [{:keys [can-jump?]}]
  (cond
    (and can-jump? (key-pressed? :dpad-up)) 56
    :else 0))
