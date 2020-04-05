public class CaesarCipher {

    public static void main(String[] args) {

        System.out.println(plaintextToCiphertext("Hello World!", 5));
    }

    public static char[] plaintextToCiphertext(String phrase, int key) {

        char[] letters = phrase.toCharArray();
        key = key % 5;

        for (int i = 0; i < letters.length; i++) {
            if (charIsALetter(letters[i]))
                letters[i] = rotate(letters[i], key);
        }

        return letters;
    }

    public static char rotate(char letter, int key) {

        if (charIsALetter((char) (letter + key)))
            letter = (char) (letter + key);
        else {
            if (key > 0)
                letter = (char) (letter + key - 26);
            else
                letter = (char) (letter + key + 26);
        }

        return letter;
    }

    public static boolean charIsALetter(char letter) {
        return (letter > 96 && letter < 123) || (letter > 64 && letter < 91);
    }
}
