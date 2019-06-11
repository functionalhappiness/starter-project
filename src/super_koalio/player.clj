(ns super-koalio.player
  (:require [play-clj.core :refer :all]))

(defn move-sideways []
  ; :dpad-left -> -15
  ; :dpad-right -> 15
  ; (key-pressed? ...)
  )

(defn can-jump? [entity]
  "True when player can jump, false otherwise"
  (:can-jump? entity))

(defn jump [entity]
  (cond
    (and (can-jump? entity) (key-pressed? :dpad-up)) 56
    :else 0))

(defn create []
  {:x      20
   :y      10
   :width  1
   :height 1.5})
