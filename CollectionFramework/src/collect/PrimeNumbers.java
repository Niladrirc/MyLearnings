package collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int target = sc.nextInt();

        List<Integer> list1 = getUsingLambda(target);
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println("Number of prime till "+ target + " is: " + (long) list1.size());
    }

    private static List<Integer> getUsingLambda(int target) {
        List<Integer> primes = new ArrayList<>();
        Predicate<Integer> isPrime = num -> {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        };
        for (int i = 1; i <= target; i++) {
            if (isPrime.test(i)) {
                primes.add(i);
            }
        }

        return primes;
    }
}
