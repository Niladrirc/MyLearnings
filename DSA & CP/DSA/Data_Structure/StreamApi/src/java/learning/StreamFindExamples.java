package src.java.learning;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamFindExamples {
    /**
     * Are of 2 types: findAny(), findFirst()
     * these are terminal operations.
     * they return optional data
     */
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);

        // Find any 1 prime number
        Optional<Integer> anyPrime = list.stream()
                .filter(num -> {
                    for (int i = 2; i < num; i++) {
                        if (num%i == 0) return false;
                    }
                    return true;
                })
                .findAny();
        anyPrime.ifPresent(System.out::println);

        // Find the 1st prime digit
        Optional<Integer> firstPrime = list.stream()
                .filter(StreamFindExamples ::isPrime)
                .findFirst();
        firstPrime.ifPresent(value -> System.out.println("First prime digit: "+value));
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(divisor -> num % divisor == 0);
    }
}
