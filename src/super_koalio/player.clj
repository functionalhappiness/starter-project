(ns super-koalio.player
  (:require [play-clj.core :refer :all]))

(defn move-sideways []
  (cond
    (key-pressed? :dpad-left) -14
    (key-pressed? :dpad-right) 14
    :else 0))
