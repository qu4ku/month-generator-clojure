(ns month-generator.core
  (:gen-class))

; (defn -main
;   "I don't do a whole lot ... yet."
;   [& args]
;   (println "Hello, World!"))

(def one-day (apply str (repeat 18 "_  ")))

(defn generate-weekdays [first-sat]  
  (sort (concat 
          (range first-sat 32 7)
          (range (inc first-sat) 32 7))))

(defn is-weekend? [day weekdays]
  "Takes day and generated weekdays and returns proper part of a string"
  (if (some #{day} weekdays)
    "|\t"
    "\t"))

(defn generate-month [num-days first-sat month year]
  (let [weekdays (generate-weekdays first-sat)]
    (doseq [day (range 1 (inc num-days))]
      (println (apply str 
                 (format "%d.%02d.%02d" year month day) 
                 (is-weekend? day weekdays) 
                 one-day)))))

(generate-month 31 4 5 19)
