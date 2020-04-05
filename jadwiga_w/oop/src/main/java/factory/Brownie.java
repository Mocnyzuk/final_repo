package factory;

public class Brownie implements Cake {

    private double bakingTrayArea;

    public Brownie(double bakingTrayArea) {
        this.bakingTrayArea = bakingTrayArea;
    }

    public Brownie() {
    }

    public double calculateNumberOfServings(int numberOfHungryPeople) {
        return Math.floor(bakingTrayArea/numberOfHungryPeople);
    }

    public void bake() {
        System.out.println("Cocoa is a plant, so technically brownie is a salad :)");
    }



}
