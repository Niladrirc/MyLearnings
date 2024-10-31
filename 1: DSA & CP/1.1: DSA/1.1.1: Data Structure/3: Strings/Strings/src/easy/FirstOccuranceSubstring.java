package easy;

public class FirstOccuranceSubstring {
    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "leeto";


        int firstOccurrence = strStr(haystack, needle);

        if (firstOccurrence != -1) {
            System.out.println("First occurrence is " + firstOccurrence);
        } else {
            System.out.println("First occurrence is null");
        }
    }

    private static int strStr(String haystack, String needle) {
        int firstOccurrence = -1;
        StringBuilder newHaystack = new StringBuilder(haystack);

        StringBuilder newNeedle = new StringBuilder(needle);

        firstOccurrence = newHaystack.indexOf(String.valueOf(newNeedle));

        return firstOccurrence;
    }
}
