package streamAPI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import streamAPI.models.Bike;
import streamAPI.models.Person;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("generatePeople: should return list below")
    void generatePeople() {
        var list = List.of(
                new Person("Ala", "Kowalska", new Bike("romet", 14)),
                new Person("Bogdan", "Bogdanowicz", new Bike("cross", 16)),
                new Person("Bena", "Nowak", new Bike("romet", 18)),
                new Person("Adam", "Bogdanowicz", new Bike("romet", 12)),
                new Person("Zenek", "Jakiś", new Bike("cube", 10)),
                new Person("Ania", "Bednarek", new Bike("trekk", 16))
        );

        assertEquals(list, Main.generatePeople());
    }

    @Test
    @DisplayName("filterAndSort1: should return list below")
    void filterAndSort1() {
        var list = List.of(
                new Person("Bogdan", "Bogdanowicz", new Bike("cross", 16)),
                new Person("Zenek", "Jakiś", new Bike("cube", 10)),
                new Person("Ala", "Kowalska", new Bike("romet", 14)),
                new Person("Bena", "Nowak", new Bike("romet", 18)),
                new Person("Ania", "Bednarek", new Bike("trekk", 16))
        );

        assertEquals(list, Main.filterAndSort1(Main.generatePeople()));
    }

    @Test
    @DisplayName("filterAndSort2: should return list below")
    void filterAndSort2() {
        var list = List.of(
                new Person("Ania", "Bednarek", new Bike("trekk", 16)),
                new Person("Bogdan", "Bogdanowicz", new Bike("cross", 16)),
                new Person("Ala", "Kowalska", new Bike("romet", 14))
        );

        assertEquals(list, Main.filterAndSort2(Main.generatePeople()));
    }

    @Test
    @DisplayName("filterAndSort3: should return list below")
    void filterAndSort3() {
        var list = List.of(new Person("Ala", "Kowalska", new Bike("romet", 14)),
                new Person("Ania", "Bednarek", new Bike("trekk", 16)),
                new Person("Bogdan", "Bogdanowicz", new Bike("cross", 16)),
                new Person("Zenek", "Jakiś", new Bike("cube", 10))
        );

        assertEquals(list, Main.filterAndSort3(Main.generatePeople()));
    }

}