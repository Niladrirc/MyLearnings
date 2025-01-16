package src.java.learning.logical.programs;

import java.util.OptionalInt;
import java.util.Random;

public class GenerateRandomNumbers {
    public static void main(String[] args) {
        Random random = new Random();
        OptionalInt any = random.ints(10, 0, 10).findAny();
        if (any.isPresent())
            System.out.println(any.getAsInt());
    }
}
