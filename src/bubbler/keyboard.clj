(ns bubbler.keyboard)
(use 'overtone.live)

; metronomo
; (def Grave 40-43)
; (def Largo 44-47)
; (def Larghetto 48-51)
; (def Adagio 52-54)
; (def Andante 55-65)
; (def Andantino 66-69)
; (def Moderato 70-95)
; (def Allegretto 96-112)
; (def Allegro 113-120)
; (def Vivace 121-140)
; (def Presto 141-175)
; (def Prestissimo 176-208)

(definst saw-wave [freq 440 attack 0.01 sustain 0.4 release 0.1 vol 0.4]
  (* (env-gen (lin-env attack sustain release) 1 1 0 1 FREE)
     (saw freq)
     vol))

(defn note->hz [music-note]
      (midi->hz (note music-note)))

(defn saw2 [music-note]
      (saw-wave (midi->hz (note music-note))))

(defn play-chord [a-chord]
  (doseq [note a-chord] (saw2 note)))

(defn chord-progression-time [bias note scale]
  (let [time (now)]
    (at (+ bias time) (play-chord (chord note scale)))))

(defn keyboard-sound [key time]
  (cond
  (= key "q")  (chord-progression-time time :C4 :minor)
  (= key "w")  (chord-progression-time time :C3 :minor)
  (= key "e")  (chord-progression-time time :C2 :minor)
  (= key "r")  (chord-progression-time time :C7 :minor)
  (= key "t")  (chord-progression-time time :G4 :minor)
  (= key "y")  (chord-progression-time time :G3 :minor)
  (= key "u")  (chord-progression-time time :G1 :minor)
  (= key "i")  (chord-progression-time time :G7 :minor)
  (= key "o")  (chord-progression-time time :A1 :minor)
  (= key "p")  (chord-progression-time time :A2 :minor)
  (= key "a")  (chord-progression-time time :A3 :minor)
  (= key "s")  (chord-progression-time time :A4 :minor)
  (= key "d")  (chord-progression-time time :A6 :minor)
  (= key "f")  (chord-progression-time time :A6 :minor)
  (= key "g")  (chord-progression-time time :A7 :major)
  (= key "h")  (chord-progression-time time :C4 :major)
  (= key "j")  (chord-progression-time time :C4 :major)
  (= key "k")  (chord-progression-time time :C4 :major)
  (= key "l")  (chord-progression-time time :C4 :major)
  (= key "z")  (chord-progression-time time :C4 :major)
  (= key "x")  (chord-progression-time time :C4 :major)
  (= key "c")  (chord-progression-time time :C4 :major)
  (= key "v")  (chord-progression-time time :C4 :major)
  (= key "b")  (chord-progression-time time :C4 :major)
  (= key "n")  (chord-progression-time time :C4 :major)
  (= key "m")  (chord-progression-time time :C4 :major)
  (= key "{")  (chord-progression-time time :C4 :major)
  (= key "}")  (chord-progression-time time :C4 :major)
  (= key "[")  (chord-progression-time time :C4 :major)
  (= key "]")  (chord-progression-time time :C4 :major)
  (= key "=")  (chord-progression-time time :Eb1 :minor)
  (= key ">")  (chord-progression-time time :Eb2 :minor)
  (= key ":")  (chord-progression-time time :Eb3 :minor)
  (= key "/")  (chord-progression-time time :Eb4 :minor)
  (= key "+")  (chord-progression-time time :Eb5 :minor)
  (= key "*")  (chord-progression-time time :Eb6 :minor)
  (= key "#")  (chord-progression-time time :Eb7 :minor)
  (= key "@")  (chord-progression-time time :Eb1 :minor)
  (= key "!")  (chord-progression-time time :Eb2 :minor)
  (= key "?")  (chord-progression-time time :Db1 :minor)
  (= key "'")  (chord-progression-time time :Db2 :minor)
  (= key "\"") (chord-progression-time time :Db3 :minor)
  (= key "-")  (chord-progression-time time :Db4 :minor)
  (= key "(")  (chord-progression-time time :Db5 :minor)
  (= key ")")  (chord-progression-time time :Db6 :minor)
  (= key "&")  (chord-progression-time time :C4 :minor)
  (= key "|")  (chord-progression-time time :C4 :minor)))