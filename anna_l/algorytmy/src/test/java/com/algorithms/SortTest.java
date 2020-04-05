package com.algorithms;

import org.junit.jupiter.api.Test;

import static com.algorithms.Sort.sort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SortTest {

    @Test
    void shouldReturnNullWhenGivenEmptyArray() {
        assertNull(sort(new int[0]));
    }

    @Test
    void shouldReturnNullWhenGivenNull() {
        assertNull(sort(null));
    }

    @Test
    void shouldSortArray() {
        int[] input = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1};
        int[] expectedArray = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expectedArray, sort(input));
    }

    @Test
    void shouldSortSortedArray() {
        int[] input = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedArray = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expectedArray, sort(input));
    }
}