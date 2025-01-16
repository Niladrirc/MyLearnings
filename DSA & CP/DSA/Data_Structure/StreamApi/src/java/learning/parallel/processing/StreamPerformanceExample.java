package src.java.learning.parallel.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamPerformanceExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            numbers.add(i);
        }

        //Print factorial of each number
        long t1 = System.nanoTime();
        long longStream = numbers.stream().mapToLong(StreamPerformanceExample::fact).sum();
        long t2 = System.nanoTime();
        System.out.println("Time to calculate factorial: "+(t2-t1));

        t1 = System.nanoTime();
        long longStream1 = numbers.stream().parallel().mapToLong(StreamPerformanceExample::fact).sum();
        t2 = System.nanoTime();
        System.out.println("Time to calculate factorial parallel: "+(t2-t1));

    }

    private static long fact(int n) {
        if (n == 0) return 1;
        int fact = 1;
        for (int i = n; i >= 1; i--) {
            fact *= i;
        }

        return fact;
    }
}
