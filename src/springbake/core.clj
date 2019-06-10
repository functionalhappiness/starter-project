(ns springbake.core
  (:require [play-clj.core :refer :all]
            [play-clj.ui :refer :all]
            [play-clj.g2d :refer :all]
            [springbake.player :as player]))

(def player-sprite "droid-white.png")

(defn prepare-stage [player-texture-path screen _entities]
  (update! screen :renderer (stage))
  (player/create player-texture-path))

(defscreen main-screen
           :on-show
           (partial prepare-stage player-sprite)

           :on-render
           (fn [screen entities]
             (clear!)
             (render! screen entities))

           :on-key-down
           player/move)

(defgame springbake
         :on-create
         (fn [this]
           (set-screen! this main-screen)))
