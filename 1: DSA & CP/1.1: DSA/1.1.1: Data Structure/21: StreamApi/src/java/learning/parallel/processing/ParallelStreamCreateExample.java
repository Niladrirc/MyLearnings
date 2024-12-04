package src.java.learning.parallel.processing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamCreateExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        list.stream().parallel().forEach(System.out::println);

        list.parallelStream().forEach(System.out::println);
    }
}
