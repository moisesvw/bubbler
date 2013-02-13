(ns bubbler.core
  (:import [javax.swing JFrame JTextArea JLabel]
           [java.awt.event KeyListener]
           [java.awt BorderLayout]))

(use 'bubbler.keyboard)

(defn GUI-Music [fn-process-pressed fn-process-released]

  (let [frame (JFrame. "Music Window")
        label-area (JLabel. "Consola")
        text-area (JTextArea.)]

    (doto text-area
      (.addKeyListener
        (proxy [KeyListener] []
          (keyPressed [e]
            (let [key (.toString (.getKeyChar e))]
              (.setText label-area key)
              (fn-process-pressed  key)
            ))
          (keyReleased [e]
            (let [key (.toString (.getKeyChar e))]
              (fn-process-released key)
            ))
          (keyTyped [e]))))

    (doto frame
      (.setSize 400 400)
      (.add text-area BorderLayout/CENTER)
      (.add label-area BorderLayout/NORTH)
      (.setDefaultCloseOperation JFrame/EXIT_ON_CLOSE)
      (.setVisible true))
  ))

(defn process-pressed  [key]
  (println key "pressed")
  (keyboard-sound key (+ 1000 (rand-int 10000))))

(defn process-released [key]
  (println key "released"))

; (System/currentTimeMillis)
(GUI-Music process-pressed process-released)
