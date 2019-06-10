(ns game.core
  (:require [play-clj.core :refer :all]
            [play-clj.ui :refer :all]
            [play-clj.g2d :refer :all]))

; first task
(defn create-player [texture-path]
  ; use resource to create texture
  ; add coordinates to texture
  )

(defn pull-player-down
  [entities]
  (def y-val (get (first entities) :y))
  (when (> y-val 0)
    (update (first entities) :y - 5)))

(defn move [screen entities]
  (cond
    (key-pressed? :space) (update (first entities) :y + 70)
    (key-pressed? :w) (update (first entities) :y + 70)
    (key-pressed? :a) (update (first entities) :x - 20)
    (key-pressed? :s) (update (first entities) :y - 20)
    (key-pressed? :d) (update (first entities) :x + 20)))

(defn prepare-stage [screen entities player-texture-path]
  (update! screen :renderer (stage))
  (create-player player-texture-path))

(defscreen main-screen
           :on-show
           (fn [screen entities]
             (update! screen :renderer (stage))
             (create-player "droid-white.png"))

           :on-render
           (fn [screen entities]
             (clear!)
             (render! screen entities)
             (pull-player-down entities))

           :on-key-down
           move)

(defgame game-game
         :on-create
         (fn [this]
           (set-screen! this main-screen)))
