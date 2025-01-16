package Longest_Common_Subsequence;

import java.util.Scanner;

/**
 * The idea is to compare the last characters of s1 and s2. While comparing the strings s1 and s2 two cases arise:
 * 1. Match : Make the recursion call for the remaining strings (strings of lengths m-1 and n-1) and add 1 to result.
 * 2. Do not Match : Make two recursive calls.
 *      First for lengths m-1 and n, and second for m and n-1.
 *      Take the maximum of two results.
 *
 * Base case : If any of the strings become empty, we return 0.
 */
public class NaiveApproach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter String1: ");
        String s1 = scanner.nextLine();

        System.out.print("Enter String2: ");
        String s2 = scanner.nextLine();

        int n= findLCS(s1, s2);

        System.out.println("Longest Common Subsequence: " + n);
    }

    private static int findLCS(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }

        if (s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)) {
            return 1+findLCS(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1));
        } else {
            return Math.max(findLCS(s1.substring(0, s1.length()-1), s2), findLCS(s1, s2.substring(0, s2.length()-1)));
        }
    }
}
