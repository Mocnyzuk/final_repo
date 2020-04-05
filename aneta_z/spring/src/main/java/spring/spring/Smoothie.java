package spring.spring;

import org.springframework.data.annotation.Id;

public class Smoothie {
    @Id
    public String id;
    public String name;
    public String size;

    public Smoothie() {
    }

    public Smoothie(String name, String size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Smoothie " + name + " " + size;
    }
}
