import java.util.Comparator;

public class Comparators {

    static Comparator<Flower> orderByColor = Comparator.comparing(Flower::getColor);
    static Comparator<Flower> orderByPlace = Comparator.comparing(Flower::getPlace);
    static Comparator<Flower> orderByLength = Comparator.comparing(Flower::getLength);

}