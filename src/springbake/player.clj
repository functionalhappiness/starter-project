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

(defn is-key-pressed? [key-name]
  `(pcore/key-pressed? key-name))

(defn move [screen entities]
  ; :w -> up
  ; :a -> left
  ; :s -> down
  ; :d -> right
  ; (is-key-pressed? ...)
  ; first element of entities is the player
  ; change the coordinates (x, y) of the player
  )
