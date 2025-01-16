package easy;

public class RomanToInteger {
    public static void main(String[] args) {
        String roman = "MCMXCIM";
        System.out.println("Roman literal String: " + roman);

        System.out.println("Corresponding integer: " + romanToInt(roman));
    }

    private static int romanToInt(String s) {
        int solution = 0;
        for (int i=0; i<s.length(); i++) {
            char thisChar = s.charAt(i);
            char nextChar = ' ';
            if (i!=s.length()-1) {
                nextChar = s.charAt(i+1);
            }

            if ((nextChar == 'V' || nextChar == 'X') && thisChar == 'I') {
                solution += romanCharToInt(nextChar) - romanCharToInt(thisChar);
                i++;
            } else if ((nextChar == 'L' || nextChar == 'C') && thisChar == 'X') {
                solution += romanCharToInt(nextChar) - romanCharToInt(thisChar);
                i++;
            } else if ((nextChar == 'D' || nextChar == 'M') && thisChar == 'C') {
                solution += romanCharToInt(nextChar) - romanCharToInt(thisChar);
                i++;
            } else  {
                solution += romanCharToInt(thisChar);
            }
        }

        return solution;
    }

    private static int romanCharToInt(char romanDigit) {
        return switch (romanDigit) {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> {
                System.err.println("Invalid Roman");
                yield 0;
            }
        };
    }
}
