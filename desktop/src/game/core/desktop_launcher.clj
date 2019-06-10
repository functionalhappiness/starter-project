(ns game.core.desktop-launcher
  (:require [game.core :refer :all])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication]
           [org.lwjgl.input Keyboard])
  (:gen-class))

(defn -main
  []
  (LwjglApplication. game-game "game" 800 600)
  (Keyboard/enableRepeatEvents true))
