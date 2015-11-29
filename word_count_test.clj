(ns word-count-test
  (:require [clojure.test :refer :all]
            [wordcount :refer :all]
            [midje.sweet :refer :all]))

(fact "count-one-word"
      (word-count "word") => {"word" 1})

(fact "count-one-of-each"
      (word-count "one of each") => {"one" 1 "of" 1 "each" 1})

(fact "count-multiple-occurrences"
      (word-count "one fish two fish red fish blue fish") => {"one" 1 "fish" 4 "two" 1 "red" 1 "blue" 1})

(fact "ignore-punctuation"
      (word-count "car : carpet as java : javascript!!&@$%^&") => {"car" 1, "carpet" 1 "as" 1 "java" 1 "javascript" 1})

(fact "include-numbers"
      (word-count "testing, 1, 2 testing") => {"testing" 2 "1" 1 "2" 1})

(fact "normalize-case"
      (word-count "go Go GO") => {"go" 3})

