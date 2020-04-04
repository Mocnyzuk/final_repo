package pl.lambda.model;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        List<Car> cars = car.createCars();


        cars.stream()
                .filter(Car.getCarsWithOwnersLastNameStartK)
                .filter(car2 -> car2.getDateOfProduction() > 2000)
                .forEach(System.out::println);


    }


}
