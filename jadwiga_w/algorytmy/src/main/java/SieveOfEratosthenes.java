import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SieveOfEratosthenes {

    public static List<Integer> findAllPrimeNumbersUpToLimit(int limit) {
        if (limit < 2) {
            return Collections.emptyList();
        } else {
            boolean[] startArray = prepareArray(limit);
            boolean[] allMultiples = findAllMultiples(limit, startArray);

            return createListOfALlPrimes(allMultiples);
        }
    }

    private static boolean[] prepareArray(int limit) {
        boolean[] preparedArray = new boolean[limit + 1];
        Arrays.fill(preparedArray, true);
        preparedArray[0] = false;
        preparedArray[1] = false;
        return preparedArray;
    }

    private static boolean[] findAllMultiples(int limit, boolean[] startArray) {

        for (int i = 2; i < Math.sqrt(startArray.length); i++) {
            for (int j = i + i; j <= limit; j += i) {
                startArray[j] = false;
            }
        }
        return startArray;
    }

    private static List<Integer> createListOfALlPrimes(boolean[] isPrime) {
        List<Integer> listOfPrimes = new ArrayList<>();
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                listOfPrimes.add(i);
            }
        }
        return listOfPrimes;
    }


}
