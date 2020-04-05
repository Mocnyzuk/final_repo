package pl.accenture.streamAPI.model;

import java.util.Arrays;

public class Bird {
    String name;
    String[] habitat;
    String[] colors;
    String sound;
    public boolean canFly;

    public String getName() {
        return name;
    }

    public String[] getHabitat() {
        return habitat;
    }

    public String[] getColors() {
        return colors;
    }

    public String getSound() {
        return sound;
    }

    public boolean canFly() {
        return canFly;
    }

    public Bird(String name, String[] habitat, String[] colors, String sound, boolean canFly) {
        this.name = name;
        this.habitat = habitat;
        this.colors = colors;
        this.sound = sound;
        this.canFly = canFly;
    }

    @Override
    public String toString() {
        return  "\n{" + name + '\'' +
                ", habitat=" + Arrays.toString(habitat) +
                ", colors=" + Arrays.toString(colors) +
                ", sound='" + sound + '\'' +
                ", canFly=" + canFly +
                "}";
    }
}
