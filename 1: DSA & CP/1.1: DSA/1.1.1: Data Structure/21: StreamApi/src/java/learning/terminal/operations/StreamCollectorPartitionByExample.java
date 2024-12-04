package src.java.learning.terminal.operations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorPartitionByExample {
    /**
     * It returns a Map whose key is always a Boolean
     * It takes a predicate as argument i.e. a condition and partitions a list based on that partitions
     * then is returns a map of 2 lists
     *  1. that satisfy the condition
     *  2. that doesn't satisfy it
     * @param args
     */
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> evenOddPartition = list.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println("Even numbers: "+evenOddPartition.get(true));
        System.out.println("Odd numbers: "+evenOddPartition.get(false));

        // Partition fruits based on length of word

        List<String> fruits = Arrays.asList("Apple", "Pomegranate", "Banana", "Water melon", "Cumumber", "Mango");
        Map<Boolean, List<String>> fruitLengths = fruits.stream().collect(Collectors.partitioningBy(value -> value.length() > 5));

        System.out.println("Fruits with length greater than 5 are: "+fruitLengths.get(true));
    }
}
