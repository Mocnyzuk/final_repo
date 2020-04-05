import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Flower {

    private String name;
    private String color;
    private Place place;
    private double length;
    private int numberOfLeafs;

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", place=" + place +
                ", length=" + length +
                ", numberOfLeafs=" + numberOfLeafs +
                '}';
    }
}