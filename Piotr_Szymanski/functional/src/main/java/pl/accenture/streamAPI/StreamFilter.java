package pl.accenture.streamAPI;

import pl.accenture.streamAPI.model.Cat;
import pl.accenture.streamAPI.model.Friend;
import pl.accenture.streamAPI.model.Fruit;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFilter {

    List<String> filterFirstLetter(List<String> list, String letter) {
        return list.stream()
                .filter(element -> element.startsWith(letter))
                .map(element -> element.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
    }

    Predicate<Friend> isAvailableOnSaturday = friend -> friend.getDay().equals("Saturday");
    Predicate<Friend> isPartyReady = friend -> friend.getActivity().equals("Party");

    List<String> partyWithFriends(List<Friend> friends) {
        return friends.stream()
                .filter(isAvailableOnSaturday
                        .and(isPartyReady))
                .map(friend -> friend.getName())
                .collect(Collectors.toList());
    }

    String findNiceSoftCat(List<Cat> cats) {
        return cats.stream()
                .filter(cat -> cat.isNice()
                        && cat.isSoft())
                .map(cat -> cat.getBreed())
                .findFirst()
                .orElse("No such cat");
    }

    List<String> moviesToUpper(List<String> movies) {
        return movies.stream()
                .filter(Objects::nonNull)
                .map(movie -> movie.toUpperCase())
                .collect(Collectors.toList());
    }

    List<String> printYellowFruits(List<Fruit> fruits) {
        return fruits.parallelStream()
                .filter(fruit -> fruit.getColor() == Color.yellow)
                .map(fruit -> fruit.getName())
                .collect(Collectors.toList());
    }

    List<String> findShortWords(List<String> words, int maxLength, String firstLetter) {
        return words.stream()
                .filter(word -> word.length() < maxLength
                        && word.startsWith(firstLetter))
                .collect(Collectors.toList());
    }

    List<Integer> findLargerThan100(List<Integer> nums, int multiplier) {
        return nums.stream()
                .map(element -> element * multiplier)
                .filter(element -> element > 100)
                .collect(Collectors.toList());
    }

}