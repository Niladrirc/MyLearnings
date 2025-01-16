package fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Tabulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter fibonacci limit: ");
        int n = scanner.nextInt();

        int[] fibArray = new int[n];

        fibArray[0] = 0; fibArray[1] = 1;

        for (int i = 2; i < fibArray.length; i++) {
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
        }


        System.out.println(Arrays.toString(fibArray));
    }
}
