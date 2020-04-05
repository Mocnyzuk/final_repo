import java.util.function.Predicate;

public class Predicates {

    static Predicate<Flower> tallerThan1 = flower -> flower.getLength() > 1;
    static Predicate<Flower> atLeastTwoLeafs = flower -> flower.getNumberOfLeafs() >= 2;
    static Predicate<Flower> nameStartWithG = flower -> flower.getName().toLowerCase().startsWith("g");
    static Predicate<Flower> isInPot = flower -> flower.getPlace().equals(Place.POT);

}