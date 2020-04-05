package pl.accenture.streamAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.accenture.streamAPI.model.Cat;
import pl.accenture.streamAPI.model.Friend;
import pl.accenture.streamAPI.model.Fruit;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Stream Filter Test")
class StreamFilterTest {

    private StreamFilter filter = new StreamFilter();
    private List<String> animals;
    private List<Fruit> fruits1 = new ArrayList<>();
    private List<Fruit> fruits2 = new ArrayList<>();
    private List<Fruit> fruits3 = new ArrayList<>();
    private List<Cat> cats1 = new ArrayList<>();
    private List<Cat> cats2 = new ArrayList<>();
    private List<Cat> cats3 = new ArrayList<>();
    private List<Friend> friends1 = new ArrayList<>();
    private List<Friend> friends2 = new ArrayList<>();
    private List<Friend> friends3 = new ArrayList<>();
    List<String> favoriteMovies1;
    List<String> favoriteMovies2;
    List<String> favoriteMovies3;
    List<String> cities;
    List<String> countries;
    List<Integer> numbers;

    @BeforeEach
    void initializeLists() {

        animals = Arrays.asList("penguin", "cat", "monkey", "parrot", "lion", "panda");

        friends1.add(new Friend("Adam","Saturday", "Party"));
        friends1.add(new Friend("Bob","Sunday","Bowling"));
        friends1.add(new Friend("Lola","Saturday","Climbing"));
        friends1.add(new Friend("Bella","Saturday","Party"));
        friends1.add(new Friend("Mike","Monday","Party"));
        friends1.add(new Friend("John","Saturday","Party"));

        friends2.add(new Friend("Paul", "Tuesday", "Party"));
        friends2.add(new Friend("Karina", "Saturday", "Dinner"));

        cats1.add(new Cat("Bengal", true, false));
        cats1.add(new Cat("Ragdoll", false, false));
        cats1.add(new Cat("Curl", false, false));
        cats1.add(new Cat("Sphynx", true, false));

        cats2.add(new Cat("Persian", true, true));
        cats2.add(new Cat("Siamese", true, true));

        favoriteMovies1 = Arrays.asList("Titanic", null, "TopGun", null, null, "Casablanca");
        favoriteMovies2 = Arrays.asList(null, null);
        favoriteMovies3 = Arrays.asList("avatar");

        fruits1.add(new Fruit("banana", Color.YELLOW));
        fruits1.add(new Fruit("orange", Color.ORANGE));
        fruits1.add(new Fruit("apple", Color.GREEN));
        fruits1.add(new Fruit("apricot", Color.YELLOW));
        fruits1.add(new Fruit("pineapple", Color.YELLOW));
        fruits1.add(new Fruit("pear", Color.GREEN));
        fruits1.add(new Fruit("melon", Color.YELLOW));
        fruits1.add(new Fruit("plum", Color.BLUE));
        fruits1.add(new Fruit("lemon", Color.YELLOW));

        fruits2.add(new Fruit("apple", Color.RED));
        fruits2.add(new Fruit("watermelon", Color.RED));

        cities = Arrays.asList("London", "Paris", "Louiseville", "Lisbon", "Sydney");
        countries = Arrays.asList("Peru", "Panama", "Portugal");

        numbers = Arrays.asList(13, 23, 17, 30, 27);

    }

    @Nested
    @DisplayName("filterFirstLetter")
    class FilterFirstLetter {

        @Test
        @DisplayName("should return {\"PANDA\", \"PARROT\", \"PENGUIN\"} for P {\"penguin\", \"cat\", \"monkey\", \"parrot\", \"lion\", \"panda\"}")
        void filterFirstLetter_p() {
            assertEquals(Arrays.asList("PANDA", "PARROT", "PENGUIN"), filter.filterFirstLetter(animals, "p"));
        }

        @Test
        @DisplayName("should return {\"LION\" for L {\"penguin\", \"cat\", \"monkey\", \"parrot\", \"lion\", \"panda\"}")
        void filterFirstLetter_l() {
            assertEquals(Arrays.asList("LION"), filter.filterFirstLetter(animals, "l"));
        }

        @Test
        @DisplayName("should return empty for G {\"penguin\", \"cat\", \"monkey\", \"parrot\", \"lion\", \"panda\"}")
        void filterFirstLetter_g() {
            assertEquals(0, filter.filterFirstLetter(animals, "g").size());
        }

    }

    @Nested
    @DisplayName("partyWithFriends")
    class PartyWithFriends {

        @Test
        @DisplayName("should return {\"Adam\", \"Bella\", \"John\"}")
        void partyWithFriends() {
            assertEquals(Arrays.asList("Adam", "Bella", "John"), filter.partyWithFriends(friends1));
        }

        @Test
        @DisplayName("should return empty for no matching friends")
        void partyWithFriends_noParty() {
            assertEquals(0, filter.partyWithFriends(friends2).size());
        }

        @Test
        @DisplayName("should return empty for empty list")
        void partyWithFriends_emptyList() {
            assertEquals(0, filter.partyWithFriends(friends3).size());
        }
    }

    @Nested
    @DisplayName("findNiceSoftCat")
    class FindNiceSoftCat {

        @Test
        @DisplayName("should return \"No such cat\"")
        void findNiceSoftCat_noCat() {
            assertEquals("No such cat", filter.findNiceSoftCat(cats1));
        }

        @Test
        @DisplayName("should return \"Persian\"")
        void findNiceSoftCat_persian() {
            assertEquals("Persian", filter.findNiceSoftCat(cats2));
        }

        @Test
        @DisplayName("should return \"No such cat\" for empty list")
        void findNiceSoftCat_emptyList() {
            assertEquals("No such cat", filter.findNiceSoftCat(cats3));
        }
    }

    @Nested
    @DisplayName("moviesToUpper")
    class MoviesToUpper {

        @Test
        @DisplayName("should return {\"TITANIC\", \"TOPGUN\", \"CASABLANCA\"} for {\"Titanic\", null, \"TopGun\", null, null, \"Casablanca\"}")
        void moviesToUpper() {
            assertEquals(Arrays.asList("TITANIC", "TOPGUN", "CASABLANCA"), filter.moviesToUpper(favoriteMovies1));
        }

        @Test
        @DisplayName("should return nothing for {null, null}")
        void moviesToUpper_null() {
            assertEquals(0, filter.moviesToUpper(favoriteMovies2).size());
        }

        @Test
        @DisplayName("should return \"AVATAR\" for {\"avatar\"}")
        void moviesToUpper_avatar() {
            assertEquals(Arrays.asList("AVATAR"), filter.moviesToUpper(favoriteMovies3));
        }

    }

    @Nested
    @DisplayName("printYellowFruits")
    class PrintYellowFruits {

        @Test
        @DisplayName("should return \"banana\", \"apricot\", \"pineapple\", \"melon\", \"lemon\"")
        void printYellowFruits() {
            assertEquals(Arrays.asList("banana", "apricot", "pineapple", "melon", "lemon"), filter.printYellowFruits(fruits1));
        }

        @Test
        @DisplayName("should return nothing for \"apple\", \"watermelon\"")
        void printYellowFruits_noYellow() {
            assertEquals(0, filter.printYellowFruits(fruits2).size());
        }

        @Test
        @DisplayName("should return nothing for empty list")
        void printYellowFruits_emptyList() {
            assertEquals(0, filter.printYellowFruits(fruits3).size());
        }
    }

    @Nested
    @DisplayName("findShortWords")
    class findShortWords {

        @Test
        @DisplayName("should return \"London\", \"Lisbon\" for legth 7, letter L")
        void findShortWords_7_L() {
            assertEquals(Arrays.asList("London", "Lisbon"), filter.findShortWords(cities, 7, "L"));
        }

        @Test
        @DisplayName("should return \"Peru\" for legth 5, letter P")
        void findShortWords_5_P() {
            assertEquals(Arrays.asList("Peru"), filter.findShortWords(countries, 5, "P"));
        }

    }

    @Nested
    @DisplayName("findLargerThan100")
    class FindLargerThan100 {

        @Test
        @DisplayName("should return 115, 150, 135 for multiplier 5")
        void findLargerThan100_5() {
            assertEquals(Arrays.asList(115, 150, 135), filter.findLargerThan100(numbers, 5));
        }

        @Test
        @DisplayName("should return empty list for multiplier 0")
        void findLargerThan100_0() {
            assertEquals(0, filter.findLargerThan100(numbers, 0).size());
        }

        @Test
        @DisplayName("should return empty list for multiplier 1")
        void findLargerThan100_1() {
            assertEquals(0, filter.findLargerThan100(numbers, 1).size());
        }
    }
}
