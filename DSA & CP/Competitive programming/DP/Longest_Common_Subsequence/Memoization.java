package Longest_Common_Subsequence;

import java.util.Arrays;
import java.util.Scanner;

public class Memoization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter String1: ");
        String s1 = scanner.nextLine();

        System.out.print("Enter String2: ");
        String s2 = scanner.nextLine();

        int[][] memo = new int[s1.length()+1][s2.length()+1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        int n= findLCS(s1, s2, s1.length(), s2.length(), memo);

        System.out.println("Longest Common Subsequence: " + n);
    }

    private static int findLCS(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (memo[m][n] != -1) {
            return memo[m][n];
        } else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = 1 + findLCS(s1, s2, m-1, n-1, memo);
        } else {
            return memo[m][n] = Math.max(findLCS(s1, s2, m-1, n, memo), findLCS(s1, s2, m, n-1, memo));
        }
    }
}
