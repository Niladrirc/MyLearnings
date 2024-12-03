package src.java.learning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamForEachExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        // Using Lambda expression
        numbers.stream().forEach(num -> System.out.println(num));

        System.out.println();

        //Using method reference
        numbers.stream().forEach(System.out::println);

        System.out.println();

        // Multiply each number by a constant
        numbers.forEach(num -> System.out.println(num * 2));

        System.out.println();

        Map<Integer, String> nums = new HashMap<>();
        nums.put(1, "one");
        nums.put(2, "two");
        nums.put(3, "three");
        nums.put(4, "four");
        nums.put(5, "five");

        nums.entrySet().forEach(System.out::println);
    }
}
