package src.java.learning.numeric.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamExample {
    public static void main(String[] args) {
        // Print numbers from 1 to 10
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
        
        // Print all even numbers from 1 to 10
        List<Integer> evenList = IntStream.rangeClosed(1, 10).filter(value -> value % 2 == 0).boxed().collect(Collectors.toList());
        System.out.println(evenList);

        long count = IntStream.rangeClosed(1, 10).filter(value -> value % 2 == 0).count();
        System.out.println("Event number of digits: "+count);

        // Convert an array of integers into Ins=tStream and find sum, max, min etc
        int[] array = {1,2,3,4,5,6,7,8,9};

        int sum = IntStream.of(array).sum();
        OptionalDouble average = IntStream.of(array).average();
        if (average.isPresent()) {
            Double avg = average.getAsDouble();
        }

        // Converting normal stream to IntStream
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();
        IntStream intStream = stream.mapToInt(Integer::intValue);

        // Converting intstream to stream of strings, double long etc

        int[] numbers = {1,2,3,4,5};

        IntStream.of(numbers)
                .mapToObj(Integer::toString)
                .forEach(System.out::print);

        IntStream.of(numbers)
                .mapToObj(num-> " "+num)
                .forEach(System.out::print);

        IntStream.of(numbers)
                .mapToDouble(Math::sqrt)
                .forEach(System.out::println);

        IntStream.of(numbers)
                .mapToLong(num-> (long) Math.pow(num,2))
                .forEach(System.out::println);

    }
}
