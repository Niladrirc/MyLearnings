package learn;

import java.util.*;

class StringADT {
    private String str = "";
    private final Set<Character> vowels = new HashSet<Character>();

    public StringADT() {
    }

    public StringADT(String str) {
        this.str = str;
        this.setVowelsSet();
    }

    private void setVowelsSet() {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int letterCount() {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'z') {
                count++;
            }
        }
        return count;
    }

    public int letterCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'z') {
                count++;
            }
        }
        return count;
    }

    public int wordsCount() {
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && str.charAt(i - 1) != ' ') {
                count++;
            }
        }
        return count+1;
    }

    public int wordsCount(String s) {
        String[] words = s.split(" ");
        int count = 0;
        for (String word : words) {
            count++;
        }

        return count;
    }

    public int vowelCount() {
        int count = 0;
        if (vowels.isEmpty()) {
            this.setVowelsSet();
        }
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.charAt(i)))
                count++;
        }
        return count;
    }

    public int vowelCount(String str) {
        int count = 0;
        if (vowels.isEmpty()) {
            this.setVowelsSet();
        }
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.charAt(i)))
                count++;
        }
        return count;
    }

    public int uniqueVowelCount() {
        int count = 0;
        if (vowels.isEmpty()) {
            this.setVowelsSet();
        }
        Set<Character> encounteredVowelSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.charAt(i)) && !encounteredVowelSet.contains(str.charAt(i))) {
                encounteredVowelSet.add(str.charAt(i));
                count++;
            }
        }
        return count;
    }

    public int uniqueVowelCount(String str) {
        int count = 0;
        if (vowels.isEmpty()) {
            this.setVowelsSet();
        }
        Set<Character> encounteredVowelSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.charAt(i)) && !encounteredVowelSet.contains(str.charAt(i))) {
                encounteredVowelSet.add(str.charAt(i));
                count++;
            }
        }
        return count;
    }

    public boolean isPalindrome() {
        StringBuilder newStr = new StringBuilder();
        newStr.append(str);
        newStr.reverse();
        return str.contentEquals(newStr);
    }

    public boolean isPalindrome(String str) {
        StringBuilder newStr = new StringBuilder();
        newStr.append(str);
        newStr.reverse();
        return str.contentEquals(newStr);
    }

    public boolean isValidPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                newStr.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String reversedStr = new StringBuilder(newStr).reverse().toString();
        return newStr.toString().equals(reversedStr);
    }

    public void findDuplicates() {
        Map<Character, Integer> repeatLetterCount = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (repeatLetterCount.containsKey(ch)) {
                repeatLetterCount.put(ch, repeatLetterCount.get(ch) + 1);
            } else {
                repeatLetterCount.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : repeatLetterCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Letter " + entry.getKey() + " occurred " + entry.getValue() + " times");
            }
        }
    }

    public void findDuplicates(String s) {
        Map<Character, Integer> repeatLetterCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (repeatLetterCount.containsKey(ch)) {
                repeatLetterCount.put(ch, repeatLetterCount.get(ch) + 1);
            } else {
                repeatLetterCount.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : repeatLetterCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Letter " + entry.getKey() + " occurred " + entry.getValue() + " times");
            }
        }
    }
}
