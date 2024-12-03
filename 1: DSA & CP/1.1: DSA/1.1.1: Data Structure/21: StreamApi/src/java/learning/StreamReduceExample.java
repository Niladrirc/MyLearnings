package src.java.learning;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    public static void main(String[] args) {
        /**
         * Used to reduce a list to a single value like sum of all elements, max value among list, min value,
         * Product of all elements
         */

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // Sum of all elements
        Optional<Integer> sum = list.stream()
                .reduce(Integer ::sum);
        sum.ifPresent(integer -> System.out.println("Sum: " + integer));

        // Product of all elements
        Optional<Integer> prod = list.stream()
                .reduce((a, b) -> a * b);
        prod.ifPresent(value -> System.out.println("Product of all elements: "+value));


        // Max among list
        Optional<Integer> max = list.stream()
                .reduce(Integer::max);
        max.ifPresent(value -> System.out.println("Max: "+value));
    }
}
