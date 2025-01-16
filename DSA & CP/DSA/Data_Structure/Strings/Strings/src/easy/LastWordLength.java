package easy;

public class LastWordLength {
    public static void main(String[] args) {
        String s = "a";

        System.out.println("Last Word length: "+ lengthOfLastWord(s));
    }

    private static int lengthOfLastWord(String s) {
        int i = 0, count = 0;
        for (i=s.length()-1; i>=0 ; i--) {
            if (s.charAt(i) != ' '){
                break;
            }
        }
        while (i >= 0){
            if (s.charAt(i) == ' '){
                break;
            }
            count++;
            i--;
        }
        return count;
    }
}
