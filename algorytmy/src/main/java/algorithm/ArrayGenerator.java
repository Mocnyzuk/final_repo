package algorithm;
import java.util.Random;

/**
 * ArrayGenerator delivers the array filled with random integers range from 0 to 100.
 */
public class ArrayGenerator {

    static final Random intGenerator = new Random();
    public static int[] arrayOfIntegers;

    private ArrayGenerator() {
    }

    /**
     * @param arraySize the count of elements in generated array
     * */
    public static int[] deliverRandomArray(int arraySize)
    {
        arrayOfIntegers = new int[arraySize];
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            arrayOfIntegers[i] = intGenerator.nextInt(100);
        }
        return arrayOfIntegers;
    }
}