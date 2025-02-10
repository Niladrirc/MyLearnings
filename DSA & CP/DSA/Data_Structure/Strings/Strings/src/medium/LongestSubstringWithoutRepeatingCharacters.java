package medium;

import java.util.HashSet;
import java.util.Set;

/*
        Given a string s, find the length of the longest substring without repeating characters.
            Example 1:
                Input: s = "abcabcbb"
                Output: 3
                Explanation: The answer is "abc", with the length of 3.

            Example 2:
                Input: s = "bbbbb"
                Output: 1
                Explanation: The answer is "b", with the length of 1.

            Example 3:
                Input: s = "pwwkew"
                Output: 3
                Explanation: The answer is "wke", with the length of 3.

        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
        Constraints:
            0 <= s.length <= 5 * 104
            s consists of English letters, digits, symbols and spaces.
 */

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
