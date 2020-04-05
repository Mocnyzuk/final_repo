package pl.accenture.streamAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Stream Collector Test")
class StreamCollectorTest {

    private StreamCollector collector = new StreamCollector();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Map<Integer, Set<String>> carMap1;
    private Map<Integer, Set<String>> carMap2;
    private Map<Integer, Set<String>> carMap3;
    private List<String> testCars1;
    private List<String> testCars2;
    private List<String> testCars3;
    private List<String> jobs1;
    private List<String> jobs2;
    private Integer[] positiveNumbers1;
    private Integer[] positiveNumbers2;
    private Integer[] positiveNumbers3;
    private Integer[] negativeNumbers1;
    private Integer[] negativeNumbers2;
    private Integer[] negativeNumbers3;
    private List<String> values1;
    private List<String> values2;
    private List<String> values3;
    private List<String> drinks1;
    private List<String> drinks2;
    private List<String> drinks3;


    @BeforeEach
    void createAndInitializeTestData() {

        System.setOut(new PrintStream(outContent));

        carMap1 = new HashMap<>();
        carMap2 = new HashMap<>();
        carMap3 = new HashMap<>();

        Set<String> cars1 = new HashSet<>();
        Set<String> cars2 = new HashSet<>();
        Set<String> cars3 = new HashSet<>();
        Set<String> cars4 = new HashSet<>();
        cars1.add("Seat");
        cars1.add("Audi");
        cars1.add("Fiat");
        cars1.add("Ford");
        cars2.add("Skoda");
        cars2.add("Honda");
        cars3.add("Subaru");
        cars3.add("Toyota");
        cars4.add("Ferrari");
        carMap1.put(Integer.valueOf(4), cars1);
        carMap1.put(Integer.valueOf(5), cars2);
        carMap1.put(Integer.valueOf(6), cars3);
        carMap1.put(Integer.valueOf(7), cars4);

        Set<String> cars11 = new HashSet<>();
        Set<String> cars22 = new HashSet<>();
        Set<String> cars33 = new HashSet<>();
        cars22.add("Maserati");
        cars33.add("Mitsubishi");
        cars11.add("Porsche");
        cars11.add("Ferrari");
        cars22.add("Mercedes");

        carMap2.put(Integer.valueOf(7), cars11);
        carMap2.put(Integer.valueOf(8), cars22);
        carMap2.put(Integer.valueOf(10), cars33);

        testCars1 = Arrays.asList("Fiat", "Ford", "Ferrari", "Seat", "Subaru", "Audi", "Skoda", "Toyota", "Honda");
        testCars2 = Arrays.asList("Mitsubishi", "Porsche", "Mercedes", "Ferrari", "Maserati");
        testCars3 = Arrays.asList();

        jobs1 = Arrays.asList("Teacher", "Architect", "Driver", "Nurse", "Waitress", "Doctor", "Manager");
        jobs2 = Arrays.asList();

        positiveNumbers1 = new Integer[] {3, 4, 9, 5, 6, 10};
        negativeNumbers1 = new Integer[] {-2, -4, -7, -15, -8};

        positiveNumbers2 = new Integer[] {3, 5, 7};
        negativeNumbers2 = new Integer[] {-17, -5};

        positiveNumbers3 = new Integer[] {};
        negativeNumbers3 = new Integer[] {};

        values1 = Arrays.asList("5.2", "1.1", "0.3", "2");
        values2 = Arrays.asList("0.6");
        values3 = Arrays.asList();

        drinks1 = Arrays.asList("Margharita", "Cuba Libre", "Mojito", "Long Island Ice Tea");
        drinks2 = Arrays.asList("Tequila Sunrise");
        drinks3 = Arrays.asList();

    }


    @Nested
    @DisplayName("booksWithoutDuplicates")
    class BooksWithoutDuplicates {

        @Test
        @DisplayName("should return [\"Romeo\", \"Hamlet\", \"Macbeth\", \"Otello\"] " +
                "for [\"Romeo\", \"Hamlet\", \"Macbeth\", \"Hamlet\", \"Romeo\", \"Hamlet\", \"Otello\"]")
        void booksWithoutDuplicates() {
            // Given
            List<String> books1 = Arrays.asList("Romeo", "Hamlet", "Macbeth", "Hamlet", "Romeo", "Hamlet", "Otello");
            StreamCollector collector = new StreamCollector();
            // When
            List<String> outcome = collector.booksWithoutDuplicates(books1);
            // Then
            assertEquals(Arrays.asList("Romeo", "Hamlet", "Macbeth", "Otello"), outcome);
        }

        @Test
        @DisplayName("should return \"Romeo\", \"Macbeth\" for [\"Romeo\", \"Romeo\", \"Macbeth\", \"Macbeth\"]")
        void booksWithoutDuplicates_smallList() {
            // Given
            List<String> books2 = Arrays.asList("Romeo", "Romeo", "Macbeth", "Macbeth");
            StreamCollector collector = new StreamCollector();
            // When
            List<String> outcome = collector.booksWithoutDuplicates(books2);
            // Then
            assertEquals(Arrays.asList("Romeo", "Macbeth"), outcome);
        }

        @Test
        @DisplayName("should return empty for []")
        void booksWithoutDuplicates_empty() {
            // Given
            List<String> books3 = Arrays.asList();
            StreamCollector collector = new StreamCollector();
            // When
            List<String> outcome = collector.booksWithoutDuplicates(books3);
            // Then
            assertEquals(0, outcome.size());
        }
    }

    @Nested
    @DisplayName("groupCars")
    class GroupCars {

        private boolean areEqual(Map<Integer, Set<String>> first, Map<Integer, Set<String>> second) {
            if (first.size() != second.size()) {
                return false;
            }

            return first.entrySet().stream()
                    .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
        }

        @Test
        @DisplayName("should return 4=[Seat, Audi, Fiat, Ford], 5=[Skoda, Honda], 6=[Subaru, Toyota], 7=[Ferrari] " +
                "for \"Fiat\", \"Ford\", \"Ferrari\", \"Seat\", \"Subaru\", \"Audi\", \"Skoda\", \"Toyota\", \"Honda\"")
        void groupCars() {
            // Given
            StreamCollector collector = new StreamCollector();
            // When

            // Then
            assertTrue(areEqual(carMap1, collector.groupCars(testCars1)));
        }

        @Test
        @DisplayName("should return 7=[Porsche, Ferrari] 8=[Mercedes, Maserati], 11=[Mitsubishi")
        void groupCars_sportCars() {
            // Given

            // When

            // Then
            assertTrue(areEqual(carMap2, collector.groupCars(testCars2)));
        }

        @Test
        @DisplayName("should return 7=[Porsche, Ferrari] 8=[Mercedes, Maserati], 11=[Mitsubishi")
        void groupCars_emptyList() {
            // Given

            // When

            // Then
            assertEquals(0, collector.groupCars(testCars3).size());
        }

    }

    @Nested
    @DisplayName("divideJobs")
    class DivideJobs {

        @Test
        @DisplayName("should return \"Teacher\", \"Driver\", \"Doctor\", \"Manager\" " +
                "for ending with R \"Teacher\", \"Architect\", \"Driver\", \"Nurse\", \"Waitress\", \"Doctor\", \"Manager\"")
        void divideJobs_true() {
            // Given

            // When

            // Then
            assertEquals(Arrays.asList("Teacher", "Driver", "Doctor", "Manager"), collector.divideJobs(jobs1).get(true));
        }

        @Test
        @DisplayName("should return \"Architect\", \"Nurse\", \"Waitress\" " +
                "for not ending with R \"Teacher\", \"Architect\", \"Driver\", \"Nurse\", \"Waitress\", \"Doctor\", \"Manager\"")
        void divideJobs_false() {
            // Given

            // When

            // Then
            assertEquals(Arrays.asList("Architect", "Nurse", "Waitress"), collector.divideJobs(jobs1).get(false));
        }

        @Test
        @DisplayName("should return empty for empty list")
        void divideJobs_emptyFalse() {
            // Given

            // When

            // Then
            assertEquals(0, collector.divideJobs(jobs2).get(false).size());
        }

        @Test
        @DisplayName("should return empty for empty list")
        void divideJobs_emptyTrue() {
            // Given

            // When

            // Then
            assertEquals(0, collector.divideJobs(jobs2).get(true).size());
        }
    }


    @Nested
    @DisplayName("numberOfEven")
    class NumberOfEven {

        @Test
        @DisplayName("should return 0 for {3, 5, 7} and {-17, -5}")
        void numberOfEven_0() {
            // Given

            // When

            // Then
            assertEquals(Long.valueOf(0), collector.numberOfEven(positiveNumbers2, negativeNumbers2));
        }

        @Test
        @DisplayName("should return 6 for {3, 4, 9, 5, 6, 10} and {-2, -4, -7, -15, -8}")
        void numberOfEven_6() {
            // Given

            // When

            // Then
            assertEquals(Long.valueOf(6), collector.numberOfEven(positiveNumbers1, negativeNumbers1));
        }

        @Test
        @DisplayName("should return 0 for {} and {}")
        void numberOfEven_empty() {
            // Given

            // When

            // Then
            assertEquals(Long.valueOf(0), collector.numberOfEven(positiveNumbers3, negativeNumbers3));
        }
    }

    @Nested
    @DisplayName("sumOfDoubles")
    class SumOfDoubles {

        @Test
        @DisplayName("should return 8.6 for {\"5.2\", \"1.1\", \"0.3\", \"2\"}")
        void sumOfDoubles_86() {
            // Given

            // When

            // Then
            assertEquals(Double.valueOf(8.6), collector.sumOfDoubles(values1));
        }

        @Test
        @DisplayName("should return 0.6 for {\"0.6\"}")
        void sumOfDoubles_06() {
            // Given

            // When

            // Then
            assertEquals(Double.valueOf(0.6), collector.sumOfDoubles(values2));
        }

        @Test
        @DisplayName("should return 0.0 for {}")
        void sumOfDoubles_0() {
            // Given

            // When

            // Then
            assertEquals(Double.valueOf(0.0), collector.sumOfDoubles(values3));
        }
    }

    @Nested
    @DisplayName("print1to5")
    class Print1to5 {

        @Test
        @DisplayName("should return 15")
        void print1to5_sum() {
            // Given

            // When

            // Then
            assertEquals(Integer.valueOf(15), collector.print1to5());
        }

        @Test

        @DisplayName("should print 1 2 3 4 5")
        void print1to5_print() {
            // Given
            String separator = System.lineSeparator();
            // When
            collector.print1to5();
            // Then
            assertEquals("1" + separator +  "2" + separator + "3" + separator + "4" + separator + "5" + separator, outContent.toString());
        }
    }


    @Nested
    @DisplayName("totalLetters")
    class TotalLetters {

        @Test
        @DisplayName("should return 45 for [\"Margharita\", \"Cuba Libre\", \"Mojito\", \"Long Island Ice Tea\"]")
        void totalLetters_45() {
            // Given

            // When

            // Then
            assertEquals(Integer.valueOf(45), collector.totalLetters(drinks1));
        }

        @Test
        @DisplayName("should return 15 for [\"Tequila Sunrise\"]")
        void totalLetters_15() {
            // Given

            // When

            // Then
            assertEquals(Integer.valueOf(15), collector.totalLetters(drinks2));
        }

        @Test
        @DisplayName("should return 0 for []")
        void totalLetters_0() {
            // Given

            // When

            // Then
            assertEquals(Integer.valueOf(0), collector.totalLetters(drinks3));
        }
    }

}
