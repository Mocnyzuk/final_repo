package pl.accenture.oop;

public class Ship extends Vehicle implements Sailing {

    @Override
    public double getFuelNeeds() {
        return 30;
    }

    @Override
    public double getDistance() {
        return 300;
    }

    @Override
    public void dock() {
        System.out.println("Docking");
    }

    @Override
    public void stop() {
        System.out.println("The boat stops");
    }

}