import java.util.Scanner;

public class FactorialCalculator {

    public static void countFactorialMenu() {
        System.out.println("Type a positive number:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        if (number <= 0) {
            System.out.println("The number is negative or equals '0'.");
            countFactorialMenu();
        } else System.out.printf("Factorial of %d is %d%n", number, countFactorial(number));
    }

    //This method counts factorial number of given integer positive number
    public static int countFactorial(int number) {

        int result = 1;

        for (int i = 1; i <= number; i++) {
            result = result * i;

        }
        return result;
    }

}

