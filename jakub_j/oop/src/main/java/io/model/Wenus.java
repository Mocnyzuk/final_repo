package io.model;

public class Wenus implements Planet{
    private static Wenus wenusInstance;
    private long numberOfPeople;
    private int placeInSolarSystem;
    private Star sun;

    private Wenus() {
        this.numberOfPeople = 0L;
        this.placeInSolarSystem = 2;
        this.sun = Star.StarBuilder.aStar("sun")
                .withBrightness(StarBrightness.YELLOW)
                .withRadius(696340000)
                .build();
    }

    public static Wenus getInstance() {
        if (wenusInstance == null) {
            wenusInstance = new Wenus();
        }
        return wenusInstance;
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
        return String.format(Planet.showYourself, Wenus.class.getSimpleName(), placeInSolarSystem);
    }

    @Override
    public boolean hasResidents() {
        return numberOfPeople>0;
    }
}
