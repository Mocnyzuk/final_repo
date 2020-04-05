import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Trainer {
    private String name;
    private int age;
    private Trainee trainee;

    static Comparator<Workout> sortByTrainersName = Comparator.comparing(w -> w.getTrainer().getName());

}