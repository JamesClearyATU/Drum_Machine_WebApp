package com.drummachine;

public class DrumPad {
     private String name;
    private String soundFile;

    public DrumPad(String name, String soundFile) {
        this.name = name;
        this.soundFile = soundFile;
    }

    public String getName() {
        return name;
    }

    public String getSoundFile() {
        return soundFile;
    }

    public boolean hasSound() {
        return soundFile != null && !soundFile.isEmpty();
    }
}
