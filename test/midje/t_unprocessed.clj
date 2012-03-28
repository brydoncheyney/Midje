;; -*- indent-tabs-mode: nil -*-

(ns midje.t-unprocessed
  (:use midje.sweet
        midje.test-util))


;; Tool creators can hook into the maps generated by the Midje compilation process

(unfinished foo)
(defn-call-countable noop-fn [& args] :do-nothing)
(binding [midje.unprocessed/*expect-checking-fn* noop-fn]
  (fact :ignored => :ignored
    (provided
      (foo) => :bar)))
(fact @noop-fn-count => 1)