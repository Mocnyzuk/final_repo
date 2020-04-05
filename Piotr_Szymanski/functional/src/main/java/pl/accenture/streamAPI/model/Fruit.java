package pl.accenture.streamAPI.model;

import java.awt.*;

public class Fruit {
    String name;
    Color color;

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Fruit(String name, Color color) {
        this.name = name;
        this.color = color;
    }
}