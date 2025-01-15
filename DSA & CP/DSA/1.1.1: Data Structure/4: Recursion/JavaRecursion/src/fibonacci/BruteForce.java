package fibonacci;

import java.util.Scanner;

public class BruteForce {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fibonacci limit: ");
        int n = sc.nextInt();

        int[] fibArray = new int[n+1];
        fib(fibArray, n);

        for (int element : fibArray) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    private static int fib(int[] fibArray, int n) {
        if (n <= 1) {
            fibArray[n] = n;
            return n;
        } else {
            fibArray[n] = fib(fibArray, n-1) + fib(fibArray, n-2);
            return fibArray[n];
        }
    }
}
