package pl.accenture.streamAPI.model;

public class Cat {
    String breed;
    boolean soft;
    boolean nice;

    public String getBreed() {
        return breed;
    }

    public boolean isSoft() {
        return soft;
    }

    public boolean isNice() {
        return nice;
    }

    public Cat(String breed, boolean soft, boolean nice) {
        this.breed = breed;
        this.soft = soft;
        this.nice = nice;
    }
}