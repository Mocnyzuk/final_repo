package com.algorithms;

public class Sort {
    private static int[] input;

    public static int[] sort(int[] arrayToSort) {
        if (arrayToSort == null || arrayToSort.length == 0) {
            return null;
        }
        input = arrayToSort;
        quickSort(input, 0, arrayToSort.length - 1);
        return input;
    }

    private static void quickSort(int[] input, int lowerIndex, int higherIndex) {
        int index = partition(input, lowerIndex, higherIndex);
        if (lowerIndex < index - 1) {
            quickSort(input, lowerIndex, index - 1);
        }
        if (index < higherIndex) {
            quickSort(input, index, higherIndex);
        }
    }

    private static int partition(int[] input, int lowerIndex, int higherIndex) {
        int pivot = input[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (lowerIndex <= higherIndex) {
            while (input[lowerIndex] < pivot) {
                lowerIndex++;
            }
            while (input[higherIndex] > pivot) {
                higherIndex--;
            }
            if (lowerIndex <= higherIndex) {
                swap(lowerIndex, higherIndex);
                lowerIndex++;
                higherIndex--;
            }
        }
        return lowerIndex;
    }

    private static void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}