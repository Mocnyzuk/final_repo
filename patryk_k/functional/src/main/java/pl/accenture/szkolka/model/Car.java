package pl.accenture.szkolka.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Car {

    private String brand;
    private String model;
    private Engine engine;
    private LocalDate productionDate;

    public static Predicate<Car> brandStartOn(String startOn) {
        return c -> c.getBrand().startsWith(startOn);
    }
    public static Predicate<Car> carProducedAfter(LocalDate date){
        return c -> c.getProductionDate().isAfter(date);
    }
    public static Predicate<Car> engineTypeIs(String type){
        return c -> c.engine.getType().equals(type);
    }

    public static Comparator<Car> sortByBrand(){
        return Comparator.comparing(Car::getBrand);
    }
    public static Comparator<Car> sortByProductionDate(){
        return Comparator.comparing(Car::getProductionDate);
    }
    public static Comparator<Car> sortByEngineType(){
        return Comparator.comparing(c -> c.getEngine().getType());
    }
}
