package pl.accenture.oop;

public class Plane extends Vehicle implements Flying {

    @Override
    public void takeOff() {
        System.out.println("Planes takes off");
    }

    @Override
    public void land() {
        System.out.println("Plane lands");
    }

    @Override
    public void callAirControl() {
        System.out.println("Calling air control");
    }

    @Override
    public double getFuelNeeds() {
        return 100;
    }

    @Override
    public double getDistance() {
        return 3000;
    }

    @Override
    public void stop() {
        System.out.println("Plane stops");
    }

    @Override
    public void go() {
        System.out.println("Plane goes");
    }

}
