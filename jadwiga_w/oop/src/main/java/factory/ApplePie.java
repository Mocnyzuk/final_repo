package factory;

public class ApplePie implements Cake {


    private double kilogramsOfApples;

    ApplePie(double kilogramsOfApples) {
        this.kilogramsOfApples = kilogramsOfApples;
    }

    public ApplePie(){
    }

    public double calculateNumberOfServings(int numberOfHungryPeople) {
        return  Math.floor(numberOfHungryPeople*kilogramsOfApples);
    }

    public void bake() {
        System.out.println("Look like you need a lot of apples :) ");


    }
}
