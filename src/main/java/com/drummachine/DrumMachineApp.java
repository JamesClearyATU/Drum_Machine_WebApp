package com.drummachine;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/** A Java Swing drum machine with six playable sound pads. */
public class DrumMachineApp {
  private static final Logger LOGGER = Logger.getLogger(DrumMachineApp.class.getName());

  private static void playSound(String fileName) {
    try {
      var soundUrl = DrumMachineApp.class.getResource("/sounds/" + fileName);

      if (soundUrl == null) {
        LOGGER.warning("Sound not found: " + fileName);
        return;
      }

      try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundUrl)) {

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.addLineListener(event -> {
          if (event.getType() == LineEvent.Type.STOP) {
            clip.close();
          }
        });

        clip.start();
      }

    } catch (Exception e) {
      LOGGER.log(Level.SEVERE, "Error playing sound: " + fileName, e);
    }
  }

  public static void main(String[] args) {

    LOGGER.setLevel(Level.FINE);

    ConsoleHandler consoleHandler = new ConsoleHandler();
    consoleHandler.setLevel(Level.FINE);

    LOGGER.setUseParentHandlers(false);
    LOGGER.addHandler(consoleHandler);

    try {
      FileHandler fileHandler = new FileHandler("drum-machine.log", true);
      fileHandler.setLevel(Level.FINE);
      fileHandler.setFormatter(new SimpleFormatter());

      LOGGER.addHandler(fileHandler);
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "Could not create log file", e);
    }

    SwingUtilities.invokeLater(() -> {

      // Create the main window
      JFrame frame = new JFrame("Drum Machine App");
      frame.setSize(600, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout(10, 10));

      // App title
      JLabel title = new JLabel("Drum Machine", SwingConstants.CENTER);
      title.setFont(new Font("Arial", Font.BOLD, 24));
      frame.add(title, BorderLayout.NORTH);

      // Area for the drum pads
      JPanel drumPanel = new JPanel(new GridLayout(2, 3, 10, 10));
      drumPanel.setBorder(BorderFactory.createTitledBorder("Drum Pads"));

      // Names of the drum pads
      String[] padNames = {"Kick", "Snare", "Hi-Hat", "Clap", "Tom", "Cymbal"};
      JLabel lastSoundLabel = new JLabel("Last Sound: None", SwingConstants.CENTER);

      // Create a button for each drum pad
      for (String padName : padNames) {
        JButton padButton = new JButton(padName);

        padButton.addActionListener(e -> {
          String soundFile = padName.toLowerCase().replace("-", "") + ".wav";

          LOGGER.fine("Drum pad played: " + padName);

          playSound(soundFile);
          lastSoundLabel.setText("Last Sound: " + padName);
        });

        drumPanel.add(padButton);
      }

      frame.add(drumPanel, BorderLayout.CENTER);

      // Display and controls area
      JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
      bottomPanel.add(lastSoundLabel);
      bottomPanel.add(new JLabel("Controls coming soon", SwingConstants.CENTER));
      frame.add(bottomPanel, BorderLayout.SOUTH);

      // Show the window
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      LOGGER.info("Drum Machine App started successfully");
    });
  }
}
