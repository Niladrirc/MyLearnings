package easy;

import java.util.*;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";

        if (isIsomorphic(s, t))
            System.out.println(s +" and "+t+" are isomorphic");
        else
            System.out.println(s +" and "+t+" are not isomorphic");
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (mapST.containsKey(sChar) && !mapTS.containsKey(tChar)) {
                return false;
            } else if (mapTS.containsKey(tChar) && !mapST.containsKey(sChar)) {
                return false;
            } else if (mapST.containsKey(sChar) && mapTS.containsKey(tChar)) {
                if ((mapST.get(sChar) != tChar) && (mapTS.get(tChar) != sChar)) {
                    return false;
                }
            } else {
                mapST.put(s.charAt(i), t.charAt(i));
                mapTS.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
