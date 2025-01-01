package easy;

public class GCDOfStrings {
    public static void main(String[] args) {
        String s1 = "ABCABC";
        String s2 = "ABC";

        String stringGcd = gcdOfStrings(s1, s2);
        System.out.println("GCD String: " + stringGcd);
    }

    private static String gcdOfStrings(String str1, String str2) {
        //get gcd string length: The largest possible length for the common divisor string 𝑥 will be the GCD of the two lengths.
        int gcdLength = gcd(str1.length(), str2.length());

        //candidate string: substring of str1 of length = gcdLength
        String candidate = str1.substring(0, gcdLength);

        //Check divisibility: check if repeating the candidate string (as many times as needed) exactly forms both str1 and str2
        if (str1.equals(candidate.repeat(str1.length()/gcdLength)) && str2.equals(candidate.repeat(str2.length()/gcdLength))) {
            return candidate;
        }
        return "";

    }

    public static int gcd(int n1, int n2) {
        if (n1 == 0)
            return n2;
        return gcd(n2%n1, n1);
    }
}
