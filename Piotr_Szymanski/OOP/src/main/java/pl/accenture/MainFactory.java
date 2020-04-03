package pl.accenture;

import pl.accenture.oop.*;

public class MainFactory {

    public static void main(String[] args) {

    }

    // Factory design pattern
    public Vehicle chooseVehicle(int speed, int cargo ) {
        if (cargo > 1000) {
            return new Ship();
        } else if (speed > 300 && cargo > 300) {
            return new Plane();
        } else if (speed < 300 && cargo < 10) {
            return new RaceCar();
        } else {
            return new Car();
        }
    }
}
