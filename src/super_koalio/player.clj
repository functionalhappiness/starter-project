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
  ; :dpad-up -> 55
  ; all other cases 0
  )

(defn create []
  ; return a map with attributes
  )
