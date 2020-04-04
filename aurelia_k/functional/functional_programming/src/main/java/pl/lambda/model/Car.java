package pl.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.*;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Vehicle {
    private Owner owner;
    private int dateOfProduction;

    private static final Logger LOG = getLogger("pl.lambda.model.Car");

    public void start() {
        LOG.info("Car starting...");
    }


    public List<Car> createCars() {
        final List<Owner> owners = getOwners();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(new Car(owners.get(i), 2009));
            cars.add(new Car(owners.get(i), 1999));

        }
        return cars;
    }

    private List<Owner> getOwners() {
        return List.of(
                new Owner("Jan", "Kowalski"),
                new Owner("Jan", "Badaj"),
                new Owner("Jan", "Katk"),
                new Owner("Jan", "Jdbsa"),
                new Owner("Jan", "Ojkda")
        );
    }

    static Predicate<Car> getCarsWithOwnersLastNameStartK = vehicle -> vehicle.getOwner().getLastName().toUpperCase().startsWith("K");
}
