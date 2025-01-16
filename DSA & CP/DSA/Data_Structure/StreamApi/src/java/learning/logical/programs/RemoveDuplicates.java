package src.java.learning.logical.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Apple", "Mango", "Mango", "mango", "Guava");
        fruits.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key));

        //Easier methods

        fruits.stream()
                .collect(Collectors.toSet()).forEach(System.out::println);

        new HashSet<>(fruits).forEach(System.out::println);

        List<String> uniqueFruits = fruits.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueFruits);
    }
}
