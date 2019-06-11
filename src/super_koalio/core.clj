(ns super-koalio.core
  (:require [play-clj.core :refer :all]
            [play-clj.g2d :refer :all]
            [play-clj.ui :refer :all]
            [super-koalio.entities :as e]
            [super-koalio.utils :as u]))

(declare super-koalio main-screen)

(defn update-screen! [screen entities]
  (doseq [{:keys [x y height me? to-destroy]} entities]
    (when me?
      (position! screen x (/ u/vertical-tiles 2))
      (when (< y (- height))
        (set-screen! super-koalio main-screen)))
    (when-let [[tile-x tile-y] to-destroy]
      (tiled-map-layer! (tiled-map-layer screen "walls")
                        :set-cell tile-x tile-y nil)))
  (map #(dissoc % :to-destroy) entities))

(defscreen main-screen
           :on-show
           (fn [screen entities]
             (->> (orthogonal-tiled-map "level1.tmx" (/ 1 16))
                  (update! screen :timeline [] :camera (orthographic) :renderer))
             (let [sheet (texture "koalio.png")
                   tiles (texture! sheet :split 18 26)
                   player-images (for [col [0 1 2 3 4]]
                                   (texture (aget tiles 0 col)))]
               (apply e/create player-images))
             )

           :on-render
           (fn [screen entities]
             (clear! 0.5 0.5 1 1)
             (some->> (map (fn [entity]
                             (->> entity
                                  (e/move screen)
                                  (e/prevent-move screen)
                                  (e/animate screen)))
                           entities)
                      (render! screen)
                      (update-screen! screen)))

           :on-resize
           (fn [{:keys [width height] :as screen} entities]
             (height! screen u/vertical-tiles)))

(defgame super-koalio
         :on-create
         (fn [this]
           (set-screen! this main-screen)))
