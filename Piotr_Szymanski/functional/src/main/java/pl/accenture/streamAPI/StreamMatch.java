package pl.accenture.streamAPI;;

import pl.accenture.streamAPI.model.Bird;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamMatch {

    boolean divisibleBy3(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(element -> element % 3 == 0);
    }

    boolean allPositive(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(element -> element > 0);
    }

    boolean noneMoreThan100(List<Integer> numbers) {
        return numbers.stream().allMatch(element -> element * 5 <= 100);
    }

    boolean allStartWithF(List<String> guests) {
        return guests.stream()
                .map(string -> string.substring(string.indexOf(" ")+1))
                .allMatch(guest -> guest.startsWith("F"));
    }

    static Predicate<Bird> isBlack = bird -> Arrays.stream(bird.getColors()).anyMatch(element -> element.equals("black"));
    static Predicate<Bird> isFromNorthAmerica = bird -> Arrays.stream(bird.getHabitat()).anyMatch(element -> element.equals("North America"));
    static Predicate<Bird> clucksOrScreams = bird -> bird.getSound().equals("scream") || bird.getSound().equals("cluck");
    static <R> Predicate<R> not(Predicate<R> predicate) {
        return predicate.negate();
    }

    List<Bird> blackFlyingBirds(List<Bird> birds) {
        return birds.stream()
                .filter(isBlack
                        .and(isFromNorthAmerica))
                .collect(Collectors.toList());
    }

    List<Bird> notBlackFromNorthAmerica(List<Bird> birds) {
        return birds.stream()
                .filter(not(isBlack)
                        .and(isFromNorthAmerica))
                .collect(Collectors.toList());
    }

    List<Bird> fliesAndClucksOrScreams(List<Bird> birds) {
        return birds.stream()
                .filter(clucksOrScreams
                        .and(bird -> bird.canFly()))
                .collect(Collectors.toList());
    }

}