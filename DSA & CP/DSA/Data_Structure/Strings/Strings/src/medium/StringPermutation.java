package medium;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        String s = "ABC";
        List<String> ans = findPermutation(s);

        System.out.println(ans);
    }

    private static List<String> findPermutation(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder(s);

        permute(str, 0, ans);

        return ans;
    }

    private static void permute(StringBuilder str, int index, List<String> ans) {
        // Base case
        if (index == str.length()) {
            ans.add(str.toString());
            return;
        }

        for (int i = index; i < str.length(); i++) {
            swap(str, index, i);
            permute(str, index+1, ans);
            swap(str, index, i); // this is the backtracking
        }
    }

    private static void swap(StringBuilder str, int index, int i) {
        char temp = str.charAt(index);
        str.setCharAt(index, str.charAt(i));
        str.setCharAt(i, temp);
    }
}
