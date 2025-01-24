package medium;

import java.util.HashMap;
import java.util.Map;

public class BaseConversion {
    public static void main(String[] args) {
        int data = baseConversion("A", 11);
        System.out.println(data);
    }

    public static int baseConversion(String num, int base) {
        int sum = 0, index = 0;
        Map<Character, Integer> digitEquivalent = getDigitEquivalent();
        for (int i = num.length()-1; i >= 0 ; i--) {
            char digit = num.charAt(i);
            int intDigit = digitEquivalent.get(digit);
            if (intDigit >= base)
                return -1;
            if (index == 0)
                sum += intDigit;
            else
                sum += (int) (Math.pow(base, index)*intDigit);
            index++;
        }
        return sum;
    }

    private static Map<Character, Integer> getDigitEquivalent() {
        Map<Character, Integer> digitMap = new HashMap<>();

        digitMap.put('0', 0);
        digitMap.put('1', 1);
        digitMap.put('2', 2);
        digitMap.put('3', 3);
        digitMap.put('4', 4);
        digitMap.put('5', 5);
        digitMap.put('6', 6);
        digitMap.put('7', 7);
        digitMap.put('8', 8);
        digitMap.put('9', 9);
        digitMap.put('A', 10);
        digitMap.put('B', 11);
        digitMap.put('C', 12);
        digitMap.put('D', 13);
        digitMap.put('E', 14);
        digitMap.put('F', 15);

        return digitMap;
    }
}
