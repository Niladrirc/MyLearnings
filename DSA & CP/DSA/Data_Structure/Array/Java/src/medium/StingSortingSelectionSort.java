package src.medium;

import java.util.Arrays;

public class StingSortingSelectionSort {
    public static void main(String[] args) {
//        String str = "aabb ccpp aaap a";
        String str = "penelope lives in hawaii";
        String[] result = selectionSort(str);
        System.out.println(Arrays.toString(result));
    }

    private static String[] selectionSort(String str) {
        String[] strings = str.split(" ");

        for (int i = 0; i < strings.length; i++) {
            int j = i, k = i;

            while (j < strings.length) {
                if (getVowelConsonantsDiff(strings[j]) < getVowelConsonantsDiff(strings[k]) ||
                        (getVowelConsonantsDiff(strings[j]) == getVowelConsonantsDiff(strings[k]) &&
                                strings[j].compareTo(strings[i]) < 0)) {
                    k = j;
                }
                j++;
            }

            // swap i & k
            if (i != k) {
                String temp = strings[i];
                strings[i] = strings[k];
                strings[k] = temp;
            }
        }

        return strings;
    }

    public static int getVowelConsonantsDiff(String s) {
        int vowels=0, consonants = 0;
        String vowelSet = "aeiouAEIOU";

        for (int i = 0; i < s.length(); i++) {
            if (vowelSet.indexOf(s.charAt(i)) == -1) {
                consonants++;
            } else {
                vowels++;
            }
        }

        return Math.abs(vowels-consonants);
    }
}
