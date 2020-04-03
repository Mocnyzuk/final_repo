package algorithm;

import algorithm.sort.BubbleSorter;

import java.util.Arrays;

public class Sorter {

    public static void main(String[] args) {

        int[] arrayForSorting = ArrayGenerator.deliverRandomArray(15);
        System.out.println("Array before sorting:");
        showTheElements(arrayForSorting);
        BubbleSorter.sort(arrayForSorting);
        System.out.println("Array after sorting:");
        showTheElements(arrayForSorting);
    }

    private static void showTheElements(int[] arrayToBeProcessed) {
        Arrays.stream(arrayToBeProcessed).forEach(System.out::println);
    }
}
