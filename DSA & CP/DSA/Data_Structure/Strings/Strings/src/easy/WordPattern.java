package easy;

import java.util.HashMap;
import java.util.Objects;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        if (wordPattern(pattern, s))
            System.out.println("String \"" + s + "\" matches pattern \"" + pattern + "\"");
        else
            System.out.println("String \"" + s + "\" does not match pattern \"" + pattern + "\"");
    }

    private static boolean wordPattern(String pattern, String s) {
        int i=0;
        String[] words = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();

        if (pattern.length() != words.length)
            return false;

        for (Character c : pattern.toCharArray()) {
            if (map.containsKey(c)) {
                if (!Objects.equals(map.get(c), words[i]))
                    return false;
            } else if (map.containsValue(words[i])) {
                return false;
            } else {
                map.put(c, words[i]);
            }
            i++;
        }

        return true;
    }
}
