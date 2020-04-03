package pl.accenture;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class SortTest {

    @Test
    void shouldReturnBubbleSortedListOfInteger() {
        //given
        List<Integer> givenList = List.of(7,3,1,2,9,8,0,5,4,6);
        //when
        List<Integer> sortedList = Sort.bubbleSort(givenList);
        //then
        assertEquals(List.of(0,1,2,3,4,5,6,7,8,9), sortedList);
    }

    @Test
    void shouldNotReturnBubbleSortedListOfInteger() {
        //given
        List<Integer> givenList = List.of(7,3,1,2,9,8,0,5,4,6);
        //when
        List<Integer> sortedList = Sort.bubbleSort(givenList);
        //then
        assertNotEquals(List.of(7,3,1,2,9,8,0,5,4,6), sortedList);
    }

    @Test
    void shouldReturnBubbleSortedListOfString(){
        //given
        List<String> givenList = List.of("Patryk", "Dominik", "Adam", "Karolina", "Wojtek", "Sylwia");
        //when
        List<String> sortedList = Sort.bubbleSort(givenList);
        //then
        assertEquals(List.of("Adam", "Dominik", "Karolina", "Patryk", "Sylwia", "Wojtek"),sortedList);
    }

    @Test
    void shouldNotReturnBubbleSortedListOfString(){
        //given
        List<String> givenList = List.of("Patryk", "Dominik", "Adam", "Karolina", "Wojtek", "Sylwia");
        //when
        List<String> sortedList = Sort.bubbleSort(givenList);
        //then
        assertNotEquals(List.of("Patryk", "Dominik", "Adam", "Karolina", "Wojtek", "Sylwia"),sortedList);
    }
}