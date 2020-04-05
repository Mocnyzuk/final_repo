package pl.accenture.streamAPI;

import pl.accenture.streamAPI.model.Bodybuilder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.maxBy;

/***
 * StreamApi comparator practise
 */
public class StreamComparator {

    Optional<Integer> findMinimum(List<Integer> numbers) {

        return numbers.stream()
                .min(Integer::compareTo);
    }

    Optional<Double> findMaximum(List<Double> doubles) {
        return doubles.stream()
                .collect(maxBy(Double::compareTo));
    }

    Optional<String> findLastInAlphabet(List<String> lastNames) {
        return lastNames.stream()
                .max(String::compareTo);
    }

    List<String> treesAlpha(List<String> trees) {
        return trees.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    List<String> treesReversed(List<String> trees) {
        return trees.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    List<String> treesShortToLong(List<String> trees) {
        return trees.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    Comparator<Bodybuilder> builderByNameLiftAge
            = Comparator.comparingInt(Bodybuilder::getLift).reversed()
            .thenComparing(Comparator.comparingInt(Bodybuilder::getAge))
            .thenComparing(Comparator.comparing(Bodybuilder::getName));

    Bodybuilder[] sortBodybuilders(Bodybuilder[] bodybuilders) {
        return Arrays.stream(bodybuilders)
                .sorted(builderByNameLiftAge)
                .toArray(Bodybuilder[]::new);
    }
}

