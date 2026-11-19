package com.drummachine;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class DrumSoundTest {

  @Test
  void testAllDrumSoundsExist() {

    String[] sounds = {"kick.wav", "snare.wav", "hihat.wav", "clap.wav", "tom.wav", "cymbal.wav"};

    for (String sound : sounds) {
      assertNotNull(
          DrumMachineApp.class.getResource("/sounds/" + sound), "Missing drum sound: " + sound);
    }
  }
}
