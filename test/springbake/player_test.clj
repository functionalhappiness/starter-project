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
