package src.java.learning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamMatchExample {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2, -3, -5, 7, 11, 13, 17);

        // Check if all numbers are prime or not
        boolean allPrime = list.stream()
                .allMatch(StreamMatchExample::isPrime);
        if (allPrime) {
            System.out.println("All the numbers are prime");
        } else {
            System.out.println("All numbers not prime");
        }

        // Check if all numbers are positive or not
        boolean allPositive = list.stream()
                .noneMatch(num -> num < 0);
        if (allPositive) {
            System.out.println("All the numbers are positive");
        } else {
            System.out.println("All numbers not positive");
        }

        // Check if any number is positive
        boolean anyNegative = list.stream()
                .anyMatch(num -> num < 0);
        if (anyNegative) {
            System.out.println("One of the number is negative");
        } else {
            System.out.println("None of the number is negative");
        }

        // Gather all the negative numbers
        List<Integer> negativeNumbers = list.stream()
                .filter(num -> num < 0)
                .toList();
        System.out.println("Negative number list: "+negativeNumbers);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false; // 0 and 1 are not prime
        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                .noneMatch(divisor -> num % divisor == 0);
    }
}
