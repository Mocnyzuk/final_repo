import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherTest {

    @Test
    void helloWorldToCiphertext() {

        //given
        final String phrase = "Hello World!";
        int key = 5;

        //when
        final String result = "Mjqqt Btwqi!";

        //then
        assertEquals(result, String.valueOf(CaesarCipher.plaintextToCiphertext(phrase, key)));
    }

    @Test
    void charIsALetter() {

        //given
        char character = '4';

        //then
        boolean result = CaesarCipher.charIsALetter(character);

        //then
        assertFalse(result);
    }

}