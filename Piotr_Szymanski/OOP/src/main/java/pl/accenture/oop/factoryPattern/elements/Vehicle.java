package pl.accenture.oop.factoryPattern.elements;

public class Vehicle {

    private String name;

    Vehicle(String name) {
        this.name = name;
    }

    Vehicle() {
        super();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public double getFuelNeeds() {
        return 7;
    }

    public double getDistance() {
        return 100;
    }

    public double calculateFuelConsumption() {
        return getDistance() / getFuelNeeds();
    }

    public void go() {
        System.out.println("The car starts going");
    }

    public void stop() {
        System.out.println("The cars stops");
    }

}