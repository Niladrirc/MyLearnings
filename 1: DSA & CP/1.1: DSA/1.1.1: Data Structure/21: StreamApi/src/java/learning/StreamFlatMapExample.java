package src.java.learning;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    public static void main(String[] args) {
        // To be used for more complex structures like list of list etc

        List<List<Integer>> numberList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        Set<Integer> collectedSet = numberList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toSet());

        System.out.println(collectedSet);
    }
}
