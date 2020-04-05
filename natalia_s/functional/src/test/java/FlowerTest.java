import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {

    final private List<Flower> flowersList = List.of(
            new Flower("Aconite", "yellow", Place.GARDEN, 0.3, 20),
            new Flower("Globe_Thistle", "blue", Place.POT, 3, 0),
            new Flower("Impatiens", "pink", Place.POT, 1, 15),
            new Flower("Sea_Lavender", "violet", Place.VASE, 0.5, 3),
            new Flower("Solomon's Seal", "green", Place.GARDEN, 4, 10),
            new Flower("Verbena", "violet", Place.GARDEN, 0.9, 0),
            new Flower("Gaillardia", "yellow", Place.POT, 1.2, 2),
            new Flower("Gaura", "pink", Place.POT, 3.5, 3)
    );

    @Test
    @DisplayName("flowersList -> flowers taller than 1 ")
    void flowersPredicates() {
        //given flowersList

        //when
        final List<Flower> flowers_exp = List.of(
                new Flower("Globe_Thistle", "blue", Place.POT, 3, 0),
                new Flower("Impatiens", "pink", Place.POT, 1, 15),
                new Flower("Gaillardia", "yellow", Place.POT, 1.2, 2),
                new Flower("Gaura", "pink", Place.POT, 3.5, 3)
        );

        //then
        assertEquals(flowers_exp, flowersList.stream()
                .filter(Predicates.isInPot)
                .collect(Collectors.toList()));
    }

    @Test
    @DisplayName("flowerList -> order by color than by length")
    void flowersComparators() {

        //given flowersList

        //when
        final List<Flower> flowers_exp = List.of(
                new Flower("Globe_Thistle", "blue", Place.POT, 3, 0),
                new Flower("Solomon's Seal", "green", Place.GARDEN, 4, 10),
                new Flower("Impatiens", "pink", Place.POT, 1, 15),
                new Flower("Gaura", "pink", Place.POT, 3.5, 3),
                new Flower("Sea_Lavender", "violet", Place.VASE, 0.5, 3),
                new Flower("Verbena", "violet", Place.GARDEN, 0.9, 0),
                new Flower("Aconite", "yellow", Place.GARDEN, 0.3, 20),
                new Flower("Gaillardia", "yellow", Place.POT, 1.2, 2)

        );

        //then
        assertEquals(flowers_exp, flowersList.stream()
                .sorted(Comparators.orderByColor.thenComparing(Comparators.orderByLength))
                .collect(Collectors.toList()));

    }

    @Test
    @DisplayName("flowersList -> name start with 'G', is in pot and order by length reversed")
    void flowerPredicatesAndComparators() {
        //given flowerList

        //when
        final List<Flower> flowers_exp = List.of(
                new Flower("Gaura", "pink", Place.POT, 3.5, 3),
                new Flower("Globe_Thistle", "blue", Place.POT, 3, 0),
                new Flower("Gaillardia", "yellow", Place.POT, 1.2, 2)
        );

        //then
        assertEquals(flowers_exp, flowersList.stream()
                .filter(Predicates.nameStartWithG.and(Predicates.isInPot))
                .sorted(Comparators.orderByLength.reversed())
                .collect(Collectors.toList()));

    }

}