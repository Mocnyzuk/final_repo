package factory;

public class Cheesecake implements Cake {

    public Cheesecake() {
    }

    public double calculateNumberOfServings(int numberOfHungryPeople) {
        if (numberOfHungryPeople > 2) {
            return 1;
        } else return 2;
    }

    public void bake() {
        System.out.println("Remember! A real cheesecake can be made only in the oven :)");
    }
}
