package src.java.learning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Mango", "Guava");

        String collectedString = fruits.stream().collect(Collectors.joining(","));
        System.out.println(collectedString);
    }
}
