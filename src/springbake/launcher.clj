(ns springbake.launcher
  (:require [springbake.core :as core])
  (:import [com.badlogic.gdx.backends.lwjgl LwjglApplication]
           [org.lwjgl.input Keyboard])
  (:gen-class))

(defn -main []
  (LwjglApplication. core/springbake "Spring Bake 2019 - lets get caked" 1600 1200)
  (Keyboard/enableRepeatEvents true))
