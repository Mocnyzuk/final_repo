package io.model;

public class Mercury implements Planet{
    private static Mercury mercuryInstance;
    private long numberOfPeople;
    private int placeInSolarSystem;
    private Star sun;

    private Mercury() {
        this.numberOfPeople = 0L;
        this.placeInSolarSystem = 1;
        this.sun = Star.StarBuilder.aStar("sun")
                .withBrightness(StarBrightness.YELLOW)
                .withRadius(696340000)
                .build();
    }

    public static Mercury getInstance() {
        if (mercuryInstance == null) {
            mercuryInstance = new Mercury();
        }
        return mercuryInstance;
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
        return String.format(showYourself, Mercury.class.getSimpleName(), placeInSolarSystem);
    }

    @Override
    public boolean hasResidents() {
        return numberOfPeople>0;
    }
}
