(ns springbake.player-test
  (:require [clojure.test :refer :all]
            [springbake.player :as player]))

(deftest create-test
  (testing "should call texture and add coordinates"
    (with-redefs [player/create-texture (fn [texture-path]
                                          (is (= "foo" texture-path))
                                          {:player texture-path})]
      (is (= {:player "foo"
              :height 48
              :width  48
              :x      0
              :y      50}
             (player/create "foo"))))))

;(deftest move-test
;  (let [entities [{:x 0 :y 0}]]
;    (testing "should move player up"
;      (with-redefs [player/is-key-pressed? (fn [key] (= :w key))]
;        (is (= {:x 0 :y 20}
;               (player/move {} entities)))))
;
;    (testing "should move player down"
;      (with-redefs [player/is-key-pressed? (fn [key] (= :s key))]
;        (is (= {:x 0 :y -20}
;               (player/move {} entities)))))
;
;    (testing "should move player left"
;      (with-redefs [player/is-key-pressed? (fn [key] (= :a key))]
;        (is (= {:x -20 :y 0}
;               (player/move {} entities)))))
;
;    (testing "should move player right"
;      (with-redefs [player/is-key-pressed? (fn [key] (= :d key))]
;        (is (= {:x 20 :y 0}
;               (player/move {} entities)))))))
