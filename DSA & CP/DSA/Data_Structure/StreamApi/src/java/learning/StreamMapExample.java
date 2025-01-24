package src.java.learning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Square each number
        List<Integer> collectedNumbers = numbers.stream().map(num -> num*num).toList();

        System.out.println(collectedNumbers);

        List<String> fruits = Arrays.asList("Apple", "Banana", "Mango", "Guave");

        //Get length of each fruit
        List<Integer> fruitLengths = fruits.stream()
                .map(String::length)
                .toList();

        System.out.println(fruitLengths);
    }
}
