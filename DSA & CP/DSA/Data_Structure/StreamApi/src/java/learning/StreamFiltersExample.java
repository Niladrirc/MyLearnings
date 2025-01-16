package src.java.learning;

import java.util.Arrays;
import java.util.List;

public class StreamFiltersExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter all even numbers
        List<Integer> eventList = numbers.stream()
                .filter(num -> num % 2 == 0)
                .toList();

        System.out.println(eventList);

        // Filter all the elements > 5
        List<Integer> greaterThan5 = numbers.stream()
                .filter(num -> num > 5)
                .toList();

        System.out.println(greaterThan5);

        // Filter all numbers those are divisible by 3 and greater than 7
        List<Integer> divBy3AndGreaterThan7 = numbers.stream()
                .filter(num -> (num % 3 == 0 && num > 7))
                .toList();
        System.out.println(divBy3AndGreaterThan7);
    }
}
