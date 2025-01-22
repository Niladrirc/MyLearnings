package src.medium;

import java.util.Arrays;

public class StringSortingBasic {
    public static void main(String[] args) {
        String str = "penelope lives in hawaii";
        String[] result = solution(str);
        System.out.println(Arrays.toString(result));
    }

    private static String[] solution(String str) {
        String[] strArray = str.split(" ");
        int[] diff = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            diff[i] = getVowelConsonantDifference(strArray[i]);
        }

        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray.length-1-i; j++) {

                if (diff[j] > diff[j+1] ||
                        (diff[j] == diff[j+1] && (strArray[j].compareTo(strArray[j+1]) > 0))) {

                    String tempStr = strArray[j];
                    strArray[j] = strArray[j+1];
                    strArray[j+1] = tempStr;

                    int tempInt = diff[j];
                    diff[j] = diff[j+1];
                    diff[j+1] = tempInt;
                }
            }
        }
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
