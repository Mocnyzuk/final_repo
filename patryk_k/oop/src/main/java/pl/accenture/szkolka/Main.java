package pl.accenture.szkolka;
import pl.accenture.szkolka.model.*;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new PublicTeacher("Karolina", "Loson", 33, false,
                        new String[]{"1B", "4C", "4A"}, "SP3"),
                new PrivateTeacher("Karol", "Nowak", 45, true,
                        new String[]{"Patryk Kania", "Wiolleta Nowak"}, new BigDecimal(85)),
                new PrimaryStudent("Tomasz", "Malina", 10, true,
                        new String[]{"Polish", "Math"}, new String[]{"Tomasz Adam", "Wojciech Malinowski"}),
                new CollegeStudent("Barbara", "Nowakowska", 23, false,
                        new String[]{"OOP", "Math"}, new String[]{"Programming", "Math"}),
                new Person("Adam", "Adamski", 20, true)
        );

        Person.printPersonList(personList);
    }
}
