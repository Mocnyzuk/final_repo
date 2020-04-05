package pl.accenture.streamAPI.model;

public class Bodybuilder {
    String name;
    int lift;
    int age;

    public String getName() {
        return name;
    }

    public int getLift() {
        return lift;
    }

    public int getAge() {
        return age;
    }

    public Bodybuilder(String name, int lift, int age) {
        this.name = name;
        this.lift = lift;
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n{" + name +
                ", lift=" + lift +
                ", age=" + age +
                "}";
    }
}
