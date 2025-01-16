package src.java.learning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinctCountSortedExample {
    public static void main(String[] args) {
        /**
         * 1. Distinct: used to extract the unique values
         * 2. Count: counting the number of elements
         * 3. Sorted: sort in ascending or descending orders
         */

        List<Integer> elements = Arrays.asList(5, 3, 4, 8, 3, 5, 9, 2);

        List<Integer> uniqueElements = elements.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueElements);

        long countOfUniqueElements = elements.stream()
                .distinct()
                .count();

        System.out.println("Count of distinct elements: "+ countOfUniqueElements);

        long totalCount = elements.stream()
                .count();
        System.out.println("Total nu,ber of elements: " +totalCount);

        List<Integer> sortedElements = elements.stream()
                .sorted()
                .toList();

        System.out.println("Sorted list: "+sortedElements);

        List<Integer> sortedUnique = elements.stream()
                .distinct()
                .sorted()
                .toList();
        System.out.println("Sorted distinct elements: "+sortedUnique);
    }
}
