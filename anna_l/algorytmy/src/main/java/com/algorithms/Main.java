package com.algorithms;

public class Main {

    public static void main(String[] args) {
        int[] arrayToSort = {15, 78, 31, 2, 13, 5, 56, 123, 2, 3, 4};

        Sort.sort(arrayToSort);
        for (int i : arrayToSort) {
            System.out.println(i);
        }
    }
}