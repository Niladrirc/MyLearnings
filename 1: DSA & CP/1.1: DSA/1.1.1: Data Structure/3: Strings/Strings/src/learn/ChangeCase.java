package learn;

public class ChangeCase {
    public static void main(String[] args) {
        StringBuffer str1 = "Hello World";
        System.out.println("Original String: " + str1);

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch += 32;
            } else if (ch >= 'a' && ch <= 'z') {
                ch -= 32;
            }
        }

        System.out.println("Changed String: " + str1);
    }
}
