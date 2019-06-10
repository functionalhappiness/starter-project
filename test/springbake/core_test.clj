(ns springbake.core_test
  (:require [clojure.test :refer :all]
            [springbake.core :as core]
            [play-clj.core :as pcore]))

(deftest move-player-test
  (testing "should move player up"
    (with-redefs [pcore/key-pressed? (fn [button]
                                       (= :space button))]
      (is (= {:y 70}
             (core/move "screen" [{:y 0}])))))
  )

(deftest prepare-stage-test
  (testing "should add stage as renderer"
    (let [call-atom (atom 0)]
      (with-redefs [pcore/stage (constantly "stage")
                    pcore/update! (fn [screen keyword stage]
                                    (is (= "screen" screen))
                                    (is (= :renderer keyword))
                                    (is (= "stage" stage)))
                    core/create-player (fn [texture-path]
                                         (swap! call-atom inc)
                                         (is (= "test.png" texture-path)))]


        (is (core/prepare-stage "screen" [] "test.png"))

        (is (= 1
               @call-atom))
        ))))
