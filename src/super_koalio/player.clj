(ns super-koalio.player
  (:require [play-clj.core :refer :all]))

(defn move-sideways []
  (cond
    (key-pressed? :dpad-left) -14
    (key-pressed? :dpad-right) 14
    :else 0))

(defn can-jump? [entity]
  "True when player can jump, false otherwise"
  (:can-jump? entity))

(defn jump [entity]
  (cond
    (and (can-jump? entity) (key-pressed? :dpad-up)) 56
    :else 0))
