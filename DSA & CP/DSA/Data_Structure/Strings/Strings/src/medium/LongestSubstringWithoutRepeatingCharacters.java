package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcadccb";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        int l=0, r=0;
        Set<Character> set = new HashSet<>();
        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                len = Math.max(len, r-l+1);
            } else {
                while (set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l += 1;
                }
                set.add(s.charAt(r));
            }
            r += 1;
        }
        return len;
    }
}
