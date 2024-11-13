package src.java.general;

import java.util.Scanner;

public class GCD {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the first number: ");
        int number1 = GCD.input.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = GCD.input.nextInt();

        int gcd = gcdI(number1, number2);

        System.out.println("\nGCD of " + number1 + " and " + number2 + " is " + gcd);
    }

    public static int gcdR(int number1, int number2) {
        if ( number1 == 0)
            return number2;
        return gcdR(number2 % number1, number1);
    }

    public static int gcdI(int number1, int number2) {
        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }
        return number1;
    }
}
