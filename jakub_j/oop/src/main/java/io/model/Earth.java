package io.model;

public class Earth implements Planet{
    private static Earth earthInstance;
    private long numberOfPeople;
    private int placeInSolarSystem;
    private Star sun;

    private Earth() {
        this.numberOfPeople = 8000000000L;
        this.placeInSolarSystem = 3;
        this.sun = Star.StarBuilder.aStar("sun")
                .withBrightness(StarBrightness.YELLOW)
                .withRadius(696340000)
                .build();
    }

    public static Earth getInstance() {
        if (earthInstance == null) {
            earthInstance = new Earth();
        }
        return earthInstance;
    }

    public static void setEarthInstance(Earth earthInstance) {
        Earth.earthInstance = earthInstance;
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
        return String.format(showYourself, Earth.class.getSimpleName(), placeInSolarSystem);
    }

    @Override
    public boolean hasResidents() {
        return numberOfPeople>0;
    }
}