import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {

    @Test
    void showAllWorkouts() {
        //given
        List<Workout> workoutsToTest = List.of(
                new Workout("FullBodyWorkout", Duration.ofMinutes(30),
                        new Trainer("John", 30, new Trainee("Mark", 40))),
                new Workout("Pilates", Duration.ofMinutes(60),
                        new Trainer("Jack", 40, new Trainee("Yvonne", 20))),
                new Workout("Yoga", Duration.ofMinutes(45),
                        new Trainer("Mariah", 25, new Trainee("Pablo", 65))));

        List<Workout> expectedWorkouts = List.of(
                new Workout("FullBodyWorkout", Duration.ofMinutes(30),
                        new Trainer("John", 30, new Trainee("Mark", 40))),
                new Workout("Pilates", Duration.ofMinutes(60),
                        new Trainer("Jack", 40, new Trainee("Yvonne", 20))),
                new Workout("Yoga", Duration.ofMinutes(45),
                        new Trainer("Mariah", 25, new Trainee("Pablo", 65))));

        //when
        List<Workout> actualWorkouts = Workout.showAllWorkouts(workoutsToTest);

        //then
        assertEquals(expectedWorkouts, actualWorkouts);
    }

    @Test
    void showWorkoutsByNames() {
        //given
        List<Workout> workoutsToTest = List.of(
                new Workout("Pilates", Duration.ofMinutes(30),
                        new Trainer("John", 30, new Trainee("Mark", 40))),
                new Workout("Yoga", Duration.ofMinutes(45),
                        new Trainer("Mariah", 25, new Trainee("Pablo", 65))),
                new Workout("Pilates", Duration.ofMinutes(60),
                        new Trainer("John", 40, new Trainee("Yvonne", 20))));

        List<Workout> expectedWorkouts = List.of(
                new Workout("Pilates", Duration.ofMinutes(30),
                        new Trainer("John", 30, new Trainee("Mark", 40))),
                new Workout("Pilates", Duration.ofMinutes(60),
                        new Trainer("John", 40, new Trainee("Yvonne", 20))),
                new Workout("Yoga", Duration.ofMinutes(45),
                        new Trainer("Mariah", 25, new Trainee("Pablo", 65))));

        //when
        List<Workout> actualWorkouts = Workout.showWorkoutsByNames(workoutsToTest);

        //then
        assertEquals(expectedWorkouts, actualWorkouts);
    }

    @Test
    void showWorkoutsByDurationDesc() {
        //given
        List<Workout> workoutsToTest = List.of(
                new Workout("FullBodyWorkout", Duration.ofMinutes(30),
                        new Trainer("John", 25, new Trainee("Mark", 40))),
                new Workout("Pilates", Duration.ofMinutes(45),
                        new Trainer("Jack", 25, new Trainee("Yvonne", 20))),
                new Workout("Yoga", Duration.ofMinutes(40),
                        new Trainer("Mariah", 25, new Trainee("Pablo", 65))));

        List<Workout> expectedWorkouts = List.of(
                new Workout("FullBodyWorkout", Duration.ofMinutes(30),
                        new Trainer("John", 25, new Trainee("Mark", 40))),
                new Workout("Yoga", Duration.ofMinutes(40),
                        new Trainer("Mariah", 25, new Trainee("Pablo", 65))),
                new Workout("Pilates", Duration.ofMinutes(45),
                        new Trainer("Jack", 25, new Trainee("Yvonne", 20))));

        //when
        List<Workout> actualWorkouts = Workout.showWorkoutsByDurationDesc(workoutsToTest);

        //then
        assertEquals(expectedWorkouts, actualWorkouts);
    }
}
