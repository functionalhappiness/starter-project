(ns game.core.core_test
  (:require [clojure.test :refer :all]
            [game.core :as core]
            [play-clj.core :as pcore]))

(deftest move-player-test
  (testing "should move player up"
    (with-redefs [pcore/key-pressed? (fn [button]
                                       (= :space button))]
      (is (= {:y 70}
             (core/move "screen" [{:y 0}])))))
  )
