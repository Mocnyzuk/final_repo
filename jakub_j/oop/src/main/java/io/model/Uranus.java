package io.model;

public class Uranus implements Planet{
    private static Uranus uranusInstance;
    private long numberOfPeople;
    private int placeInSolarSystem;
    private Star sun;

    private Uranus() {
        this.numberOfPeople = 0L;
        this.placeInSolarSystem = 7;
        this.sun = Star.StarBuilder.aStar("sun")
                .withBrightness(StarBrightness.YELLOW)
                .withRadius(696340000)
                .build();
    }

    public static Uranus getInstance() {
        if (uranusInstance == null) {
            uranusInstance = new Uranus();
        }
        return uranusInstance;
    }

    public long getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(long numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getPlaceInSolarSystem() {
        return placeInSolarSystem;
    }

    public void setPlaceInSolarSystem(int placeInSolarSystem) {
        this.placeInSolarSystem = placeInSolarSystem;
    }

    public Star getSun() {
        return sun;
    }

    public void setSun(Star sun) {
        this.sun = sun;
    }

    @Override
    public String tellSomethingAboutYou() {
        return String.format(showYourself, Uranus.class.getSimpleName(), placeInSolarSystem);
    }

    @Override
    public boolean hasResidents() {
        return numberOfPeople>0;
    }
}
