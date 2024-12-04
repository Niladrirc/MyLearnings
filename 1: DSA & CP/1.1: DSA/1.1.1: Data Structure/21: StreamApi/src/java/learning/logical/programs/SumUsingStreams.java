package src.java.learning.logical.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumUsingStreams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> sum = list.stream().reduce(Integer::sum);
        sum.ifPresent(value-> System.out.println("Sum: "+value));
    }
}
