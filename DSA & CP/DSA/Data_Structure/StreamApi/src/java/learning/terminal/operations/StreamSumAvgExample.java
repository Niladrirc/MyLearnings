package src.java.learning.terminal.operations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamSumAvgExample {
    /**
     * These are terminal operations
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        
        // Without terminal operations using reduce
        Optional<Integer> reduce = list.stream()
                .reduce(Integer::sum);

        // With terminal operations
        Integer sum = list.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sum);

        //Finding average
        Double avg = list.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(avg);
    }
}
