package pl.accenture.oop.factoryPattern.elements;

public class Car extends Vehicle {

    @Override
    public double getFuelNeeds() {
        return 7;
    }

    @Override
    public double getDistance() {
        return 30;
    }

}
