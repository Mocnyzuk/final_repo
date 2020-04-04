package streamAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Comparator;
import java.util.function.Predicate;

@AllArgsConstructor
@ToString
@Data
public class Person {
    String name, lastName;
    Bike bike;

    public static Predicate<Person> nameIsZenekPredicate = p -> p.name.toLowerCase().equals("zenek");
    public static Predicate<Person> bikeFrameSizeBiggerThan12Predicate = p -> p.bike.getFrameSize() > 12;
    public static Predicate<Person> brandStartsWithCPredicate = p -> p.bike.getBrand().toLowerCase().startsWith("c");
    public static Predicate<Person> lastNameLengthBiggerThan5Predicate = p -> p.getLastName().length() > 5;

    public static Comparator<Person> sortByBrand = Comparator.comparing(p -> p.bike.getBrand());
    public static Comparator<Person> sortByLastName = Comparator.comparing(Person::getLastName);
    public static Comparator<Person> sortByName = Comparator.comparing(Person::getName);
}