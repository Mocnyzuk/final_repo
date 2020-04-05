import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Flower> flowersList = List.of(
                new Flower("Aconite", "yellow", Place.GARDEN, 0.3, 20),
                new Flower("Globe_Thistle", "blue", Place.POT, 3, 0),
                new Flower("Impatiens", "pink", Place.POT, 1, 15),
                new Flower("Sea_Lavender", "violet", Place.VASE, 0.5, 3),
                new Flower("Solomon's Seal", "green", Place.GARDEN, 4, 10),
                new Flower("Verbena", "violet", Place.GARDEN, 0.9, 0),
                new Flower("Gaillardia", "yellow", Place.POT, 1.2, 2),
                new Flower("Gaura", "pink", Place.POT, 3.5, 3)
        );

        flowersList
                .stream()
                .filter(Predicates.tallerThan1.and(Predicates.atLeastTwoLeafs))
                .sorted(Comparators.orderByColor.thenComparing(Comparators.orderByPlace))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
