package src.medium;

import java.util.Arrays;
import java.util.List;

public class StringSortingInsertionSort {
    public static void main(String[] args) {
        String str = "aabb ccpp aaap a";
//        String str = "penelope lives in hawaii";
        String[] result = insertionSort(str);
        System.out.println(Arrays.toString(result));
    }

    private static String[] insertionSort(String str) {
        String[] strings = str.split(" ");
        for (int i = 1; i < strings.length; i++) {
            String pivot = strings[i];
            int pivotDiff = getVowelConsonantsDiffCount(pivot);

            int j = i - 1;
            String compStr = strings[j];
            int compDiff = getVowelConsonantsDiffCount(compStr);
            while (j >= 0 &&
                    (compDiff > pivotDiff ||
                            (compDiff == pivotDiff && compStr.compareTo(pivot) > 0))) {
                strings[j+1] = strings[j];
                j--;
                if (j >= 0) {
                    compStr = strings[j];
                    compDiff = getVowelConsonantsDiffCount(compStr);
                }
            }
            strings[j+1] = pivot;
        }
        return strings;
    }

    private static int getVowelConsonantsDiffCount(String s) {
        List<Character> vowelSet = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int vowels = 0;
        int consonants = 0;

        for (char c : s.toCharArray()) {
            if (vowelSet.contains(c)) vowels++;
            else consonants++;
        }

        return Math.abs(vowels-consonants);
    }
}
