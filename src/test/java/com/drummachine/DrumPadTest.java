
package com.drummachine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DrumPadTest {

    @Test
    void testPadName() {
        DrumPad pad = new DrumPad("Kick", "kick.wav");
        assertEquals("Kick", pad.getName());
    }

    @Test
    void testSoundFile() {
        DrumPad pad = new DrumPad("Snare", "snare.wav");
        assertEquals("snare.wav", pad.getSoundFile());
    }

    @Test
    void testPadHasSound() {
        DrumPad pad = new DrumPad("Hi-Hat", "hihat.wav");
        assertTrue(pad.hasSound());
    }

    @Test
    void testPadWithoutSound() {
        DrumPad pad = new DrumPad("Clap", "");
        assertFalse(pad.hasSound());
    }
}