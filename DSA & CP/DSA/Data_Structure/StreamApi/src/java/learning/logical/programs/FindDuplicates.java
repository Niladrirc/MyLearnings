package src.java.learning.logical.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 1, 5, 5);

        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

        collect.forEach((k,v)-> {
            if (v>1) {
                System.out.println("Number: "+k+" appears "+v+" times");
            }
        });

        collect = list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        collect.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(value -> System.out.println(" "+value.getKey()));


        List<String> fruits = Arrays.asList("Apple", "Banana", "Apple", "Mango", "Mango", "mango", "Guava");

        Map<String, Long> fruitFreqMap = fruits.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        Map<String, Long> duplicateFruits = fruitFreqMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(duplicateFruits);
    }
}
