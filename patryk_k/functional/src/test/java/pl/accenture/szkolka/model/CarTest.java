package pl.accenture.szkolka.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static List<Car> carList;

    @BeforeAll
    static void setUpCollection(){
        carList = List.of(
                new Car("Audi","A3", new Engine("Combustion", "V8"), LocalDate.of(2018,1,1)),
                new Car("Audi", "A4", new Engine("Combustion", "V6"), LocalDate.of(2008,1,1)),
                new Car("Tesla", "Roadster", new Engine("Electric", "AA3"), LocalDate.of(2018,1,1)),
                new Car("Mazda", "MX-30", new Engine("Electric", "T8A"), LocalDate.of(2018,1,1)),
                new Car("Ford", "GT", new Engine("Combustion", "V8"), LocalDate.of(2003,1,1))
        );
    }

    @Test
    void shouldReturnBrandStartOn(){
        //given
        List<Car> cars = List.copyOf(carList);
        //when
        List<Car> resultList = cars.stream()
                .filter(Car.brandStartOn("A"))
                .collect(Collectors.toList());
        //then
        assertEquals(2, resultList.size());
    }

    @Test
    void shouldReturnCarProducedAfter(){
        //given
        List<Car> cars = List.copyOf(carList);
        //when
        List<Car> resultList = cars.stream()
                .filter(Car.carProducedAfter(LocalDate.of(2010,1,1)))
                .collect(Collectors.toList());
        //then
        assertEquals(3, resultList.size());
    }

    @Test
    void shouldReturnEngineTypeIs(){
        //given
        List<Car> cars = List.copyOf(carList);
        //when
        List<Car> resultList = cars.stream()
                .filter(Car.engineTypeIs("Electric"))
                .collect(Collectors.toList());
        //then
        assertEquals(2,resultList.size());
    }

    @Test
    void shouldReturnSortedListByBrand(){
        //given
        List<Car> cars = List.copyOf(carList);
        List<Car> sortedList = List.of(
                new Car("Audi","A3", new Engine("Combustion", "V8"), LocalDate.of(2018,1,1)),
                new Car("Audi", "A4", new Engine("Combustion", "V6"), LocalDate.of(2008,1,1)),
                new Car("Ford", "GT", new Engine("Combustion", "V8"), LocalDate.of(2003,1,1)),
                new Car("Mazda", "MX-30", new Engine("Electric", "T8A"), LocalDate.of(2018,1,1)),
                new Car("Tesla", "Roadster", new Engine("Electric", "AA3"), LocalDate.of(2018,1,1))
        );
        //when
        List<Car> resultList = cars.stream()
                .sorted(Car.sortByBrand())
                .collect(Collectors.toList());
        //then
        assertIterableEquals(sortedList,resultList);
    }

    @Test
    void shouldReturnSortedListByProductionDate(){
        //given
        List<Car> cars = List.copyOf(carList);
        List<Car> sortedList = List.of(
                new Car("Ford", "GT", new Engine("Combustion", "V8"), LocalDate.of(2003,1,1)),
                new Car("Audi", "A4", new Engine("Combustion", "V6"), LocalDate.of(2008,1,1)),
                new Car("Audi","A3", new Engine("Combustion", "V8"), LocalDate.of(2018,1,1)),
                new Car("Tesla", "Roadster", new Engine("Electric", "AA3"), LocalDate.of(2018,1,1)),
                new Car("Mazda", "MX-30", new Engine("Electric", "T8A"), LocalDate.of(2018,1,1))
                );
        //when
        List<Car> resultList = cars.stream()
                .sorted(Car.sortByProductionDate())
                .collect(Collectors.toList());
        //then
        assertIterableEquals(sortedList, resultList);
    }

    @Test
    void shouldReturnSortedListByEngineType(){
        //given
        List<Car> cars = List.copyOf(carList);
        List<Car> sortedList = List.of(
                new Car("Audi","A3", new Engine("Combustion", "V8"), LocalDate.of(2018,1,1)),
                new Car("Audi", "A4", new Engine("Combustion", "V6"), LocalDate.of(2008,1,1)),
                new Car("Ford", "GT", new Engine("Combustion", "V8"), LocalDate.of(2003,1,1)),
                new Car("Tesla", "Roadster", new Engine("Electric", "AA3"), LocalDate.of(2018,1,1)),
                new Car("Mazda", "MX-30", new Engine("Electric", "T8A"), LocalDate.of(2018,1,1))
        );
        //when
        List<Car> resultList = cars.stream()
                .sorted(Car.sortByEngineType())
                .collect(Collectors.toList());
        //then
        assertIterableEquals(sortedList, resultList);
    }
}





















