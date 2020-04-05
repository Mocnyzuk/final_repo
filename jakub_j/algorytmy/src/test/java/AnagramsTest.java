import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    @Test
    @DisplayName("Short alphabetical String test should return true")
    void shouldReturnTrue() {
        //given
        String s1 = "abcdefgh";
        String s2 = "hgfedcba";
        //when
        boolean result = Anagrams.isAnagram(s1, s2);
        //then
        assertTrue(result);
    }
    @Test
    @DisplayName("Short alphabetical String test should return false")
    void shouldReturnFalse() {
        //given
        String s1 = "abcddefgh";
        String s2 = "hgfedfcba";
        //when
        boolean result = Anagrams.isAnagram(s1, s2);
        //then
        assertFalse(result);
    }
    @Test
    @DisplayName("Long String test should return true")
    void shouldReturnTrue2() {
        //given
        String s1 = "aaaaaaaaaaaaaaaaafaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaafaaaaaaaaa";
        //when
        boolean result = Anagrams.isAnagram(s1, s2);
        //then
        assertTrue(result);
    }
    @Test
    @DisplayName("Very long String test should return false")
    void shouldReturnFalse2() {
        //given
        String s1 = "aaaaaaaaaaaaaaaaafaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaafaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //when
        boolean result = Anagrams.isAnagram(s1, s2);
        //then
        assertFalse(result);
    }
    @Test
    @DisplayName("Empty String test should return true")
    void shouldReturnFalse22() {
        //given
        String s1 = "";
        String s2 = "";
        //when
        boolean result = Anagrams.isAnagram(s1, s2);
        //then
        assertTrue(result);
    }
    @Test
    @DisplayName("The anagram String is empty test should return false")
    void shouldReturnEmptyAnagram() {
        //given
        String s1 = "a";
        String s2 = "";
        //when
        boolean result = Anagrams.isAnagram(s1, s2);
        //then
        assertFalse(result);
    }
    @Test
    @DisplayName("The base String is empty test should return false")
    void shouldReturnEmptyBase() {
        //given
        String s1 = "";
        String s2 = "a";
        //when
        boolean result = Anagrams.isAnagram(s1, s2);
        //then
        assertFalse(result);
    }
    @Test
    @DisplayName("The base String is empty test should return false")
    void shouldReturnFalseOnNull() {
        //given
        String s1 = null;
        String s2 = "a";
        //when
        boolean result = Anagrams.isAnagram(s1, s2);
        //then
        assertFalse(result);
    }
}