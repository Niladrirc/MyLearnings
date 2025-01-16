package src.java.learning.terminal.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectorJoinExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Mango", "Orange", "Banana");

        String collectedString = fruits.stream()
                .collect(Collectors.joining(" "));

        System.out.println(collectedString);

        //Easier method
        String joinedString = String.join(" ", fruits);
        System.out.println(joinedString );
    }
}
