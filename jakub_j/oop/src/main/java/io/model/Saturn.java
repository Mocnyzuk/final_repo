package io.model;

public class Saturn implements Planet{
    private static Saturn saturnInstance;
    private long numberOfPeople;
    private int placeInSolarSystem;
    private Star sun;

    private Saturn() {
        this.numberOfPeople = 0L;
        this.placeInSolarSystem = 6;
        this.sun = Star.StarBuilder.aStar("sun")
                .withBrightness(StarBrightness.YELLOW)
                .withRadius(696340000)
                .build();
    }

    public static Saturn getInstance() {
        if (saturnInstance == null) {
            saturnInstance = new Saturn();
        }
        return saturnInstance;
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
        return String.format(showYourself, Mars.class.getSimpleName(), placeInSolarSystem);
    }

    @Override
    public boolean hasResidents() {
        return numberOfPeople>0;
    }
}
