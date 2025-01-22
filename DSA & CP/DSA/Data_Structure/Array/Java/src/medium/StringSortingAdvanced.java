package src.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * UBER test question
 */

public class StringSortingAdvanced {
    public static void main(String[] args) {
        String str = "aabb ccpp aaap a";
        String[] result = solution(str);
        System.out.println(Arrays.toString(result));
    }

    private static String[] solution(String str) {
        String[] strArray = str.split(" ");

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int diff1 = getVowelConsonantDifference(o1);
                int diff2 = getVowelConsonantDifference(o2);

                return Integer.compare(diff1, diff2);
            }
        };

        Arrays.sort(strArray, comparator);

        return strArray;
    }

    private static int getVowelConsonantDifference(String s) {
        int vowels = 0, consonants = 0;
        String vowelSet = "aeiouAEIOU";

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowelSet.indexOf(c) != -1) vowels++;
                else consonants++;
            }
        }
        return Math.abs(vowels-consonants);
    }

}
