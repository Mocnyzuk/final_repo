public class Algorithm {

    /**
     * Method that looks for a highest multiple of 10 in both given arrays
     *
     * @param firstArray  one of the array to use in the addition
     * @param secondArray second of the array to use in the addition
     * @return result of the addition of the two highest multiple of 10 from two arrays
     */
    public static int addHighestMultipleOf10(int[] firstArray, int[] secondArray) {

        return getHighestMultipleOf10(firstArray) + getHighestMultipleOf10(secondArray);


    }

    private static int getHighestMultipleOf10(int[] arrayToCheck) {
        int maxMultiple = 0;
        for (int number : arrayToCheck) {
            if (number > maxMultiple && number % 10 == 0) maxMultiple = number;
        }
        return maxMultiple;
    }

    /**
     * Given an array of positive ints, return a new array of length "count" containing the first even numbers
     * from the original array.
     *
     * @param numbers original array we want to take even from
     * @param count   number of even numbers that should be returned.
     * @return a new array of length "count" containing the first even numbers from the original array.
     */
    public static int[] copyEvens(int[] numbers, int count) throws Exception {

        if (count > numbers.length)
            throw new IllegalArgumentException("the array is not long enough to contain " + count + "even numbers.");
        else {
            int[] evenNumbers = new int[count];
            int number;
            int counter = 0;
            for (int i = 0; i < numbers.length; i++) {
                if ((number = numbers[i]) % 2 == 0) {
                    evenNumbers[counter] = number;
                    counter++;
                }
                if (counter == count) break;
            }
            if (counter != count)
                throw new IllegalArgumentException("Not enough even numbers in the given array.");
            else
                return evenNumbers;
        }


    }
}
