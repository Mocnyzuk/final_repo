package pl.accenture.streamAPI;

import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/***
 * StreamAPI collector training
 */
public class StreamCollector {


    List<String> booksWithoutDuplicates(List<String> books) {
        return books.stream()
                .distinct()
                .collect(toList());
    }

    Map<Integer, Set<String>> groupCars(List<String> cars) {
        return cars.stream()
                .collect(groupingBy(String::length, toSet()));
    }

    Map<Boolean, List<String>> divideJobs(List<String> jobs) {
        return jobs.stream()
                .collect(partitioningBy(j -> j.charAt(j.length()-1) == 'r'));
    }

    Long numberOfEven(Integer[] nums1, Integer[] nums2) {
        return Stream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .filter(element -> element % 2 == 0)
                .count();
    }

    Double sumOfDoubles(List<String> nums) {
        return nums.stream()
                .mapToDouble(element -> Double.parseDouble(element))
                .sum();
    }

    Integer print1to5() {
        return Stream.iterate(1, n -> n + 1)
                .limit(5)
                .map(element -> {
                    System.out.println(element);
                    return element;
                })
                .reduce(0, (element1 , element2) -> element1 + element2);
    }

    Integer totalLetters(List<String> words) {
        return words.stream()
                .mapToInt(element -> element.length())
                .sum();
    }

}