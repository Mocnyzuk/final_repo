package pl.accenture.streamAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.accenture.streamAPI.model.Bird;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Stream Match Test")
class StreamMatchTest {

    private StreamMatch streamMatch = new StreamMatch();
    private List<Integer> nums1;
    private List<Integer> nums2;
    private List<Integer> nums3;
    private List<Integer> nums4;
    private List<String> guests1;
    private List<String> guests2;
    private List<String> guests3;
    private List<Bird> birds = new ArrayList<>();

    @BeforeEach
    void initializeLists() {
        nums1 = Arrays.asList(13, 4, -3, 19, 16, 9, 10, 2);
        nums2 = Arrays.asList(55, 7, 5, 14);
        nums3 = Arrays.asList();
        nums4 = Arrays.asList(0, 12, 888);

        guests1 = Arrays.asList("Robert Fox", "Jen Fisher", "James Finn", "Harry Fabray", "Nick Forbes");
        guests2 = Arrays.asList("Kate Darren", "Allan Smith", "Jen Lynch");
        guests3 = Arrays.asList("Bob Fix");

        birds.add(new Bird("Ostrich", new String[] {"Africa"},
                new String[] {"grey", "black"}, "cluck", false));
        birds.add(new Bird("Chickadee", new String[] {"North America"},
                new String[] {"grey", "white", "yellow"}, "sing", true));
        birds.add(new Bird("Toucan", new String[] {"North America", "South America"},
                new String[] {"white", "black", "orange", "green"}, "croak", true));
        birds.add(new Bird("Swift", new String[] {"Europe", "Australia", "North America", "South America", "Africa", "Asia"},
                new String[] {"grey", "white"}, "scream", true));
        birds.add(new Bird("Roadrunner", new String[] {"North America"},
                new String[] {"grey", "brown"}, "coo", true));
        birds.add(new Bird("Raven", new String[] {"North America", "Europe", "Asia", "Africa"},
                new String[] {"black"}, "croak", true));
    }

    @Nested
    @DisplayName("divisibleBy3")
    class DivisibleBy3 {

        @Test
        @DisplayName("should return false for {55, 7, 5, 14}")
        void divisibleBy3_false() {
            assertFalse(streamMatch.divisibleBy3(nums2));
        }

        @Test
        @DisplayName("should return true for {13, 4, -3, 19, 16, 9, 10, 2}")
        void divisibleBy3_true() {
            assertTrue(streamMatch.divisibleBy3(nums1));
        }

        @Test
        @DisplayName("should return false for {}")
        void divisibleBy3_falseEmpty() {
            assertFalse(streamMatch.divisibleBy3(nums3));
        }
    }

    @Nested
    @DisplayName("allPositive")
    class AllPositive {

        @Test
        @DisplayName("should return false for {13, 4, -3, 19, 16, 9, 10, 2}")
        void allPositive_false() {
            assertFalse(streamMatch.allPositive(nums1));
        }

        @Test
        @DisplayName("should return true for {55, 7, 5, 14}")
        void allPositive_true_55_7_5_14() {
            assertTrue(streamMatch.allPositive(nums2));
        }

        @Test
        @DisplayName("should return true for {0, 12, 888}")
        void allPositive_true_0_12_888() {
            assertFalse(streamMatch.allPositive(nums4));
        }
    }

    @Nested
    @DisplayName("noneMoreThan100")
    class NoneMoreThan100 {

        @Test
        @DisplayName("should return false for {55, 7, 5, 14}")
        void noneMoreThan100_false() {
            assertFalse(streamMatch.noneMoreThan100(nums2));
        }

        @Test
        @DisplayName("should return true for {13, 4, -3, 19, 16, 9, 10, 2}")
        void noneMoreThan100_true() {
            assertTrue(streamMatch.noneMoreThan100(nums1));
        }

        @Test
        @DisplayName("should return true for {}")
        void noneMoreThan100_trueEmpty() {
            assertTrue(streamMatch.noneMoreThan100(nums3));
        }
    }

    @Nested
    @DisplayName("allStartWithF")
    class AllStartWithF {

        @Test
        @DisplayName("should return false for \"Kate Darren\", \"Allan Smith\", \"Jen Lynch\"")
        void allStartWithF_false() {
            assertFalse(streamMatch.allStartWithF(guests2));
        }

        @Test
        @DisplayName("should return true for \"Robert Fox\", \"Jen Fisher\", \"James Finn\", \"Harry Fabray\", \"Nick Forbes\"")
        void allStartWithF_true() {
            assertTrue(streamMatch.allStartWithF(guests1));
        }

        @Test
        @DisplayName("should return true for \"Bob Fix\"")
        void allStartWithF_true_BobFix() {
            assertTrue(streamMatch.allStartWithF(guests3));
        }
    }

    @Nested
    @DisplayName("blackFlyingBirds")
    class BlackFlyingBirds {

        @Test
        @DisplayName("should return list size 2")
        void blackFlyingBirds_size_2() {
            assertEquals(2, streamMatch.blackFlyingBirds(birds).size());
        }

        @Test
        @DisplayName("should contain toucan")
        void blackFlyingBirds_toucan() {
            assertTrue(streamMatch.blackFlyingBirds(birds).contains(birds.get(2)));
        }

        @Test
        @DisplayName("should contain raven")
        void blackFlyingBirds_raven() {
            assertTrue(streamMatch.blackFlyingBirds(birds).contains(birds.get(5)));
        }

    }

    @Nested
    @DisplayName("notBlackFromNorthAmerica")
    class NotBlackFromNorthAmerica {

        @Test
        @DisplayName("should return list size 3")
        void notBlackFromNorthAmerica_size() {
            assertEquals(3, streamMatch.notBlackFromNorthAmerica(birds).size());
        }

        @Test
        @DisplayName("should contain chickadee")
        void blackFlyingBirds_chickadee() {
            assertTrue(streamMatch.notBlackFromNorthAmerica(birds).contains(birds.get(1)));
        }

        @Test
        @DisplayName("should contain swift")
        void blackFlyingBirds_swift() {
            assertTrue(streamMatch.notBlackFromNorthAmerica(birds).contains(birds.get(3)));
        }

        @Test
        @DisplayName("should contain roadrunner")
        void blackFlyingBirds_roadrunner() {
            assertTrue(streamMatch.notBlackFromNorthAmerica(birds).contains(birds.get(4)));
        }

    }

    @Nested
    @DisplayName("fliesAndClucksOrScreams")
    class FliesAndClucksOrScreams {

        @Test
        @DisplayName("should return list size 1")
        void fliesAndClucksOrScreams_size_1() {
            assertEquals(1, streamMatch.fliesAndClucksOrScreams(birds).size());
        }

        @Test
        @DisplayName("should contain swift")
        void fliesAndClucksOrScreams_swift() {
            assertTrue(streamMatch.fliesAndClucksOrScreams(birds).contains(birds.get(3)));
        }


        @Test
        @DisplayName("should not contain toucan")
        void fliesAndClucksOrScreams_notToucan() {
            assertFalse(streamMatch.fliesAndClucksOrScreams(birds).contains(birds.get(2)));
        }

    }



}
