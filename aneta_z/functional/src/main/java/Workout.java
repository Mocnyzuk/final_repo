import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Workout {
    private String name;
    private Duration duration;
    private Trainer trainer;

    static Comparator<Workout> sortByWorkoutsName = Comparator.comparing(Workout::getName);
    static Comparator<Workout> sortByDuration = Comparator.comparing(Workout::getDuration);

    static List<Workout> showAllWorkouts(List<Workout> workouts) {
        System.out.println("All available workouts sorted by name in an ascending way:");
        List<Workout> allWorkouts = workouts
                .stream()
                .sorted(sortByWorkoutsName)
                .collect(Collectors
                        .toList());

        allWorkouts.forEach(System.out::println);
        System.out.println();
        return allWorkouts;
    }

    static List<Workout> showWorkoutsByNames(List<Workout> workouts) {
        System.out.println("All available workouts sorted by workout's name, trainer's name and trainee's name:");
        List<Workout> workoutsByName = workouts
                .stream()
                .sorted(sortByWorkoutsName
                        .thenComparing(Trainer
                                .sortByTrainersName)
                        .thenComparing(Trainee
                                .sortByTraineesName))
                .collect(Collectors
                        .toList());

        workoutsByName.forEach(System.out::println);
        System.out.println();
        return workoutsByName;
    }

    static List<Workout> showWorkoutsByDurationDesc(List<Workout> workouts) {
        System.out.println("All available workouts sorted by duration in a descending way:");
        List<Workout> workoutsByDuration = workouts
                .stream()
                .sorted(sortByDuration
                        .thenComparing(Workout
                                .sortByDuration
                                .reversed()))
                .collect(Collectors
                        .toList());

        workoutsByDuration.forEach(System.out::println);
        System.out.println();
        return workoutsByDuration;
    }
}