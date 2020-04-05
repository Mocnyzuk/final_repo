import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Circle class with radius field and Figure interface methods implemented according to the mathematical formulas.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Circle implements Figure {
    private double radius = 0;
    public static final String CIRCLE=  "It's a circle";

    @Override
    public String introduceFigure() {
        return CIRCLE;
    }

    public double calculateArea() {
        return radius * radius * Math.PI;
    }

    public double calculateCircum() {
        return 2 * Math.PI * radius;
    }


}
