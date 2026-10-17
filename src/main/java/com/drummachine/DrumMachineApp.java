package main.java.com.drummachine;

import javax.swing.*;
import java.awt.*;


public class DrumMachineApp 
{
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

            // Create a button for each drum pad
            for (String padName : padNames) {
                JButton padButton = new JButton(padName);

                padButton.addActionListener(e ->
                    System.out.println(padName + " pad clicked")
                );

                drumPanel.add(padButton);
            }

            frame.add(drumPanel, BorderLayout.CENTER);

            // Display and controls area
            JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
            bottomPanel.add(new JLabel("Last Sound: None", SwingConstants.CENTER));
            bottomPanel.add(new JLabel("Controls coming soon", SwingConstants.CENTER));
            frame.add(bottomPanel, BorderLayout.SOUTH);

            // Show the window
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
