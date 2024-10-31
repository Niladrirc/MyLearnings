package learn;

import java.util.HashSet;
import java.util.Set;

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

    public int wordsCount() {
        int count = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && str.charAt(i - 1) != ' ') {
                count++;
            }
        }
        return count+1;
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
}
