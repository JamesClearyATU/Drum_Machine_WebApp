
package com.drummachine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrumPadNameTest {

    @Test
    void testDifferentPadNames() {
        DrumPad kick = new DrumPad("Kick", "kick.wav");
        DrumPad snare = new DrumPad("Snare", "snare.wav");

        assertEquals("Kick", kick.getName());
        assertEquals("Snare", snare.getName());
    }
}
