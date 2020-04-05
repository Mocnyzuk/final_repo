package io.model;

public class Jupiter implements Planet {
    private static Jupiter jupiterInstance;
    private long numberOfPeople;
    private int placeInSolarSystem;
    private Star sun;

    private Jupiter() {
        this.numberOfPeople = 0L;
        this.placeInSolarSystem = 5;
        this.sun = Star.StarBuilder.aStar("sun")
                .withBrightness(StarBrightness.YELLOW)
                .withRadius(696340000)
                .build();
    }

    public static Jupiter getInstance() {
        if (jupiterInstance == null) {
            jupiterInstance = new Jupiter();
        }
        return jupiterInstance;
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
        return String.format(showYourself, Jupiter.class.getSimpleName(), placeInSolarSystem);
    }

    @Override
    public boolean hasResidents() {
        return numberOfPeople>0;
    }
}
