package practice;

import java.util.Scanner;

/**
 * Write a Java program to implement a lambda expression to find the sum of two integers.
 */
public class SumOfTwoIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 2 numbers of your choice: ");

        int a = sc.nextInt();

        int b = sc.nextInt();

        SumCalculator sumCalculatorExpression = (x, y) -> x+y ;

        System.out.println("Result: " + sumCalculatorExpression.sum(a, b));
    }
}


@FunctionalInterface
interface SumCalculator {
    int sum(int a, int b);
}
