(ns springbake.player
  (:require [play-clj.g2d :as g2d]
            [play-clj.core :as pcore]))

(defn create-texture [texture-path]
  (g2d/texture texture-path))

(defn create [texture-path]
  ; (create-texture ...)
  ; use resource to create texture
  ; add x and y coordinates to texture
  )

(defn move [screen entities]
  )
