(ns word-count-test
  (:require [clojure.test :refer :all]
            [wordcount :refer :all]
            [midje.sweet :refer :all]))

(future-fact "count-one-word"
      (word-count "word") => {"word" 1})

(future-fact "count-one-of-each"
      (word-count "one of each") => {"one" 1 "of" 1 "each" 1})

(future-fact "count-multiple-occurrences"
      (word-count "one fish two fish red fish blue fish") => {"one" 1 "fish" 4 "two" 1 "red" 1 "blue" 1})

(future-fact "ignore-punctuation"
      (word-count "car : carpet as java : javascript!!&@$%^&") => {"car" 1, "carpet" 1 "as" 1 "java" 1 "javascript" 1})

(future-fact "include-numbers"
      (word-count "testing, 1, 2 testing") => {"testing" 2 "1" 1 "2" 1})

(future-fact "normalize-case"
      (word-count "go Go GO") => {"go" 3})

