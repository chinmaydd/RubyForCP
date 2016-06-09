;; Problem 2
(ns clj.p2)

; (def fibs
;     (lazy-cat [0 1] (map + fibs (rest fibs))))
; Optimized solution
(defn fibs []
    (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(defn soln
    "Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms."
    [n]
    (reduce + (filter even? (take-while #(< % n) fibs))))

(soln 4000000)