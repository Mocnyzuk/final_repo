package pl.accenture.streamAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pl.accenture.streamAPI.model.Bodybuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Stream Comparator Test")
class StreamComparatorTest {

    private StreamComparator comparator = new StreamComparator();
    List<Integer> numbers1;
    List<Integer> numbers2;
    List<Integer> numbers3;
    List<Double> doubles1;
    List<Double> doubles2;
    List<Double> doubles3;
    List<String> lastNames1;
    List<String> lastNames2;
    List<String> lastNames3;
    List<String> trees1;
    List<String> trees2;
    List<String> trees3;
    Bodybuilder[] bodybuilders1;
    Bodybuilder[] bodybuilders2;
    Bodybuilder[] bodybuilders3;


    @BeforeEach
    void initializeLists() {
        numbers1 = Arrays.asList(55, 7, -5, 14);
        numbers2 = Arrays.asList(4, 4, 4);
        numbers3 = Arrays.asList(2, 5, 6, 2, 9);

        doubles1 = Arrays.asList(6.5, 14.3, 9.1, 77.2);
        doubles2 = Arrays.asList(-6.2, -8.9, -13.3, -5.0);
        doubles3 = Arrays.asList(0.0);

        lastNames1 = Arrays.asList("Jones", "Smith", "Adams", "Wayne", "O'Connor");
        lastNames2 = Arrays.asList("Jones", "Jonas", "James");
        lastNames3 = Arrays.asList("Spears");

        trees1 = Arrays.asList("Pine", "Aspen", "Sequoia", "Chestnut", "Maple", "Oak");
        trees2 = Arrays.asList("Lemon tree", "Apple tree", "Olive tree");
        trees3 = Arrays.asList();

        bodybuilders1 = new Bodybuilder[] {
                (new Bodybuilder("Mike", 144, 23)),
                (new Bodybuilder("Greg", 132, 27)),
                (new Bodybuilder("Alexandra", 78, 29)),
                (new Bodybuilder("Andy", 156, 31)),
                (new Bodybuilder("Lisa", 78, 19)),
                (new Bodybuilder("Peter", 144, 23)),
        };

        bodybuilders2 = new Bodybuilder[] {
                (new Bodybuilder("John", 177, 19)),
                (new Bodybuilder("Josh", 178, 20)),
                (new Bodybuilder("Lena", 64, 18)),
        };

        bodybuilders3 = new Bodybuilder[]{};
    }

    @Nested
    @DisplayName("findMinimum")
    class FindMinimum {

        @Test
        @DisplayName("should return -5 for {55, 7, -5, 14}")
        void findMinimum_5() {
            assertEquals(Optional.of(-5), comparator.findMinimum(numbers1));
        }

        @Test
        @DisplayName("should return 4 for {4, 4, 4}")
        void findMinimum_4() {
            assertEquals(Optional.of(4), comparator.findMinimum(numbers2));
        }

        @Test
        @DisplayName("should return 2 for {2, 5, 6, 2, 9}")
        void findMinimum_2() {
            assertEquals(Optional.of(2), comparator.findMinimum(numbers3));
        }
    }

    @Nested
    @DisplayName("findMaximum")
    class FindMaximum {

        @Test
        @DisplayName("should return 77.2 for {6.5, 14.3, 9.1, 77.2}")
        void findMaximum_772() {
            assertEquals(Optional.of(77.2), comparator.findMaximum(doubles1));
        }

        @Test
        @DisplayName("should return -5.0 for {-6.2, -8.9, -13.3, -5.0}")
        void findMaximum_5() {
            assertEquals(Optional.of(-5.0), comparator.findMaximum(doubles2));
        }

        @Test
        @DisplayName("should return 0.0 for {0.0}")
        void findMaximum_0() {
            assertEquals(Optional.of(0.0), comparator.findMaximum(doubles3));
        }

    }

    @Nested
    @DisplayName("findLastInAlphabet")
    class FindLastInAlphabet {

        @Test
        @DisplayName("should return \"Wayne\" for {\"Jones\", \"Smith\", \"Adams\", \"Wayne\", \"O'Connor\"}")
        void findLastInAlphabet_Wayne() {
            assertEquals(Optional.of("Wayne"), comparator.findLastInAlphabet(lastNames1));
        }

        @Test
        @DisplayName("should return \"Jones\" for {\"Jones\", \"Jonas\", \"James\"}")
        void findLastInAlphabet_Jones() {
            assertEquals(Optional.of("Jones"), comparator.findLastInAlphabet(lastNames2));
        }

        @Test
        @DisplayName("should return \"Spears\" for {\"Spears\"}")
        void findLastInAlphabet_Spears() {
            assertEquals(Optional.of("Spears"), comparator.findLastInAlphabet(lastNames3));
        }
    }

    @Nested
    @DisplayName("treesAlpha")
    class TreesAlpha {

        @Test
        @DisplayName("should return {\"Aspen\", \"Chestnut\", \"Maple\", \"Oak\", \"Pine\", \"Sequoia\"}" +
                "\nfor {\"Pine\", \"Aspen\", \"Sequoia\", \"Chestnut\", \"Maple\", \"Oak\"}")
        void treesAlpha_sorted() {
            assertEquals(Arrays.asList("Aspen", "Chestnut", "Maple", "Oak", "Pine", "Sequoia"), comparator.treesAlpha(trees1));
        }

        @Test
        @DisplayName("should return \"Apple tree\", \"Lemon tree\", \"Olive tree\" for {\"Lemon tree\", \"Apple tree\", \"Olive tree\"}")
        void treesAlpha_sorted_smallList() {
            assertEquals(Arrays.asList("Apple tree", "Lemon tree", "Olive tree"), comparator.treesAlpha(trees2));
        }

        @Test
        @DisplayName("should return {} for {}")
        void treesAlpha_sorted_empty() {
            assertEquals(0, comparator.treesAlpha(trees3).size());
        }
    }

    @Nested
    @DisplayName("treesReversed")
    class TreesReversed {

        @Test
        @DisplayName("should return {\"Sequoia\", \"Pine\", \"Oak\", \"Maple\", \"Chestnut\", \"Aspen\"}" +
                "\nfor {\"Pine\", \"Aspen\", \"Sequoia\", \"Chestnut\", \"Maple\", \"Oak\"}")
        void treesReversed_sorted() {
            assertEquals(Arrays.asList("Sequoia", "Pine", "Oak", "Maple", "Chestnut", "Aspen"), comparator.treesReversed(trees1));
        }

        @Test
        @DisplayName("should return \"Olive tree\", \"Lemon tree\", \"Apple tree\" for {\"Lemon tree\", \"Apple tree\", \"Olive tree\"}")
        void treesReversed_sorted_smallList() {
            assertEquals(Arrays.asList("Olive tree", "Lemon tree", "Apple tree"), comparator.treesReversed(trees2));
        }

        @Test
        @DisplayName("should return {} for {}")
        void treesReversed_sorted_empty() {
            assertEquals(0, comparator.treesReversed(trees3).size());
        }
    }

    @Nested
    @DisplayName("treesShortToLong")
    class TreesShortToLong {

        @Test
        @DisplayName("should return {\"Oak\", \"Pine\", \"Aspen\", \"Maple\", \"Sequoia\", \"Chestnut\"}" +
                "\nfor {\"Pine\", \"Aspen\", \"Sequoia\", \"Chestnut\", \"Maple\", \"Oak\"}")
        void treesShortToLong_sorted() {
            assertEquals(Arrays.asList("Oak", "Pine", "Aspen", "Maple", "Sequoia", "Chestnut"), comparator.treesShortToLong(trees1));
        }

        @Test
        @DisplayName("should return \"Apple tree\", \"Lemon tree\", \"Olive tree\" for {\"Lemon tree\", \"Apple tree\", \"Olive tree\"}")
        void treesShortToLong_sorted_smallList() {
            assertEquals(Arrays.asList("Lemon tree", "Apple tree", "Olive tree"), comparator.treesShortToLong(trees2));
        }

        @Test
        @DisplayName("should return {} for {}")
        void treesShortToLong_sorted_empty() {
            assertEquals(0, comparator.treesShortToLong(trees3).size());
        }
    }

    @Nested
    @DisplayName("sortBodybuilders")
    class SortBodybuilders {

        private String separator = "\n";
        @Test
        @DisplayName("should return {Andy, Mike, Peter, Greg, Lisa, Aleksandra}")
        void sortBodybuilders_1() {
            assertEquals("[" + separator +
                    "{Andy, lift=156, age=31}, " + separator +
                    "{Mike, lift=144, age=23}, " + separator +
                    "{Peter, lift=144, age=23}, " + separator +
                    "{Greg, lift=132, age=27}, " + separator +
                    "{Lisa, lift=78, age=19}, " + separator +
                    "{Alexandra, lift=78, age=29}]", Arrays.toString(comparator.sortBodybuilders(bodybuilders1)));
        }

        @Test
        @DisplayName("should return {Josh, John, Lena}")
        void sortBodybuilders_2() {
            assertEquals("[" + separator +
                    "{Josh, lift=178, age=20}, " + separator +
                    "{John, lift=177, age=19}, " + separator +
                    "{Lena, lift=64, age=18}]", Arrays.toString(comparator.sortBodybuilders(bodybuilders2)));
        }

        @Test
        @DisplayName("should return empty for empty list")
        void sortBodybuilders_3() {
            String[] array = {};
            assertEquals(Arrays.toString(array), Arrays.toString(comparator.sortBodybuilders(bodybuilders3)));
        }
    }

}
