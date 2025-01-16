package Longest_Common_Subsequence;

import java.util.Arrays;

public class Tabulation {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int max = findLCS(s1, s2);

        System.out.println("Longest Common Subsequence: " + max);
    }

    private static int findLCS(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                // to fill dp[1][1] we need to analyze s1.charAt(0) & s2.charAt(0), hence
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
