import java.util.Arrays;

public class Algorithms {

    public static int findSecondLargest(int[] arr) {
        int top1 = arr[0];
        int top2 = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > top1) {
                top2 = top1;
                top1 = arr[i];
            } else if (arr[i] > top2) {
                top2 = arr[i];
            }

        }

        return top2;
    }

    //return sum of given int values
    //but if one of the values is the same as another of the values,
    //it does not count towards the sum
    public static int loneSum(int a, int b, int c) {
        int result = a + b + c;

        if (a == b && a == c)
            return 0;

        if (a == b)
            result -= b * 2;

        if (a == c || b == c)
            result -= c * 2;

        return result;
    }

    //return true if difference between small and medium is the same
    //as the difference between medium and large
    public static boolean evenlySpaced(int a, int b, int c) {
        int[] tab = {a, b, c};
        Arrays.sort(tab);

        return tab[1] - tab[0] == tab[2] - tab[1];
    }


}
