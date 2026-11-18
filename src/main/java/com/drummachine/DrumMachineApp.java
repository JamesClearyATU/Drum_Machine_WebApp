package com.drummachine;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

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


public class DrumMachineApp 
{

private static void playSound(String fileName) {
    try {
        var soundURL = DrumMachineApp.class.getResource("/sounds/" + fileName);

        if (soundURL == null) {
            System.err.println("Sound not found: " + fileName);
            return;
        }

        try (AudioInputStream audioStream =
                 AudioSystem.getAudioInputStream(soundURL)) {

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
        System.err.println("Error playing sound: " + fileName);
        e.printStackTrace();
    }
}

     public static void main(String[] args) {

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
        });
    }
}
