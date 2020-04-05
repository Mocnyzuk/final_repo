import java.time.Duration;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Workout> workouts = List.of(
                new Workout("FullBodyWorkout", Duration.ofMinutes(30),
                        new Trainer("John", 30, new Trainee("Mark", 40))),
                new Workout("Pilates", Duration.ofMinutes(60),
                        new Trainer("Jack", 40, new Trainee("Yvonne", 20))),
                new Workout("Yoga", Duration.ofMinutes(45),
                        new Trainer("Mariah", 25, new Trainee("Pablo", 65))));

        Workout.showAllWorkouts(workouts);
        Workout.showWorkoutsByNames(workouts);
        Workout.showWorkoutsByDurationDesc(workouts);

    }
}

