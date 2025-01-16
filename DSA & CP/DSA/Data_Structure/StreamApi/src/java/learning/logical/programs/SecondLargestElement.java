package src.java.learning.logical.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] array = {1,2,4,6,23,2,9, 23};

        Optional<Integer> first = Arrays.stream(array)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(2)
                .findFirst();

        first.ifPresent(System.out::println);

    }
}
