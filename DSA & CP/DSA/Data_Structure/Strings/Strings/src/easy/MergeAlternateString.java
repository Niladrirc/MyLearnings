package easy;

public class MergeAlternateString {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pqrst";
        String word3 = mergeAlternately(word1, word2);
        System.out.println(word3);
    }

    private static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (i <= j)
                sb.append(word1.charAt(i++));
            else {
                sb.append(word2.charAt(j++));
            }
        }

        while (i < word1.length())
            sb.append(word1.charAt(i++));
        while (j < word2.length())
            sb.append(word2.charAt(j++));

        return sb.toString();
    }
}
