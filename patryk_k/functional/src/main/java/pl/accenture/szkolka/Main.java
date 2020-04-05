package pl.accenture.szkolka;

import pl.accenture.szkolka.model.Car;
import pl.accenture.szkolka.model.Engine;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is a simple usage of Stream API
 * Second examples are in test
 */
public class Main {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("Audi","A3", new Engine("Combustion", "V8"), LocalDate.of(2018,1,1)),
                new Car("Audi", "A4", new Engine("Combustion", "V6"), LocalDate.of(2008,1,1)),
                new Car("Ford", "GT", new Engine("Combustion", "V8"), LocalDate.of(2003,1,1)),
                new Car("Mazda", "MX-30", new Engine("Electric", "T8A"), LocalDate.of(2018,1,1)),
                new Car("Tesla", "Roadster", new Engine("Electric", "AA3"), LocalDate.of(2018,1,1))
        );

        List<String> resultList = cars.stream()
                .filter(Car.engineTypeIs("Combustion"))
                .sorted(Car.sortByBrand())
                .map(Car::getBrand)
                .distinct()
                .collect(Collectors.toList());
    }
}
