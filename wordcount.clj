 (ns wordcount
  (:require [clojure.string :as str]))

 (defn remove-punctuation [words]
  (str/replace words #"\p{Punct}" ""))

 (defn word-count [words]
  (let [vector-of-words (-> words
                            (str/lower-case)
                            (remove-punctuation)
                            (str/split #"\s+"))]
   (reduce #(assoc %1 %2 (inc (%1 %2 0))) {} vector-of-words)))