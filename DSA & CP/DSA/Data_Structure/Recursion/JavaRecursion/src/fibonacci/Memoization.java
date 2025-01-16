package fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Memoization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fibonacci limit: ");
        int n = sc.nextInt();

        int[] fibArray = new int[n];
        Arrays.fill(fibArray, -1);
        fib(fibArray, n-1);

        for (int element : fibArray) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    private static int fib(int[] fibArray, int i) {
        if (i <= 1) {
            fibArray[i] = i;
            return i;
        }

        if (fibArray[i] != -1)
            return fibArray[i];

        fibArray[i] = fib(fibArray, i-1) + fib(fibArray, i-2);
        return fibArray[i];
    }
}
