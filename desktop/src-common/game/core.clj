(ns game.core
  (:require [play-clj.core :refer :all]
            [play-clj.ui :refer :all]
            [play-clj.g2d :refer :all]))

; first task
(defn create-player
  [texture-name]
  (assoc (texture texture-name) :x 0 :y 50
                                :width 48 :height 48))

(defn pull-player-down
  [entities]
  (def y-val (get (first entities) :y))
  (when (> y-val 0)
    (update (first entities) :y - 5)))

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
           (fn [screen entities]
             (println "Key pressed: " (screen :key))
             (cond
               (key-pressed? :space) (update (first entities) :y + 70)
               (key-pressed? :w) (update (first entities) :y + 70)
               (key-pressed? :a) (update (first entities) :x - 20)
               (key-pressed? :s) (update (first entities) :y - 20)
               (key-pressed? :d) (update (first entities) :x + 20))))


(defgame game-game
         :on-create
         (fn [this]
           (set-screen! this main-screen)))