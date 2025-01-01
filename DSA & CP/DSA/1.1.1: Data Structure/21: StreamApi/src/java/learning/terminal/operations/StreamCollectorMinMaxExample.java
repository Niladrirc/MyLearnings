package src.java.learning.terminal.operations;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCollectorMinMaxExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 7, 1, 2);

        Optional<Integer> minValue = numbers.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        minValue.ifPresent(value -> System.out.println("Min: "+ value));

        // Getting max value
        Optional<Integer> first = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .findFirst();
        first.ifPresent(value-> System.out.println("Max: "+value));
    }
}
