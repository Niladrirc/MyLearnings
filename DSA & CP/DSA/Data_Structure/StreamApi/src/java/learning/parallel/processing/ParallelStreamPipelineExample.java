package src.java.learning.parallel.processing;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ParallelStreamPipelineExample {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};

        Arrays.stream(numbers)
                .parallel()
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .forEach(System.out::println);
    }
}
