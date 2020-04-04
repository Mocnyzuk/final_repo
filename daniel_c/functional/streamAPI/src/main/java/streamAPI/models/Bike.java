package streamAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bike {
    String brand;
    int frameSize;
}
