package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
 */
public class FilterOddEven {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1,2,3,4,5,6,7,8,9);

//        filterOddEventWithStreams(input);
        
        filterOddEvenWithoutStreams(input);
    }

    private static IListFilter oddFilter() {
        return (list) -> {
            List<Integer> result = new ArrayList<>();
            for (Integer value : list) {
                if (value % 2 != 0)
                    result.add(value);
            }
            return result;
        };
    }

    private static IListFilter evenFilter() {
        return (list) -> {
            List<Integer> result = new ArrayList<>();
            for (Integer value : list) {
                if (value % 2 == 0)
                    result.add(value);
            }
            return result;
        };
    }

    private static void filterOddEvenWithoutStreams(List<Integer> input) {
        List<Integer> evenList = FilterOddEven.evenFilter().result(input);
        List<Integer> oddList = FilterOddEven.oddFilter().result(input);
        System.out.println("Odd list: " + oddList);
        System.out.println("Even list: " + evenList);
    }

    private static void filterOddEventWithStreams(List<Integer> input) {
        List<Integer> oddList = input.stream().filter(data -> data%2 != 0).toList();
        List<Integer> evenList = input.stream().filter(data -> data%2 == 0).toList();
        System.out.println("Odd list: " + oddList);
        System.out.println("Even list: " + evenList);
    }
}

@FunctionalInterface
interface IListFilter {
    List<Integer> result(List<Integer> input);
}
