import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Trainee {
    private String name;
    private int age;

    static Comparator<Workout> sortByTraineesName = Comparator.comparing(t -> t.getTrainer().getTrainee().getName());
}