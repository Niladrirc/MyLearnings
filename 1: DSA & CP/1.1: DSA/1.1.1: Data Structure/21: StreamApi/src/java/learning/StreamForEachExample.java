package src.java.learning;

import java.util.Arrays;
import java.util.List;

public class StreamForEachExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        // Using Lambda expression
        numbers.stream().forEach(num -> System.out.println(num));

        System.out.println();

        //Using method reference
        numbers.stream().forEach(System.out::println);

        // Multiply each number by a constant
        numbers.forEach(num -> System.out.println(num * 2));
    }
}
