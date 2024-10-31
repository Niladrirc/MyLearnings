package learn;

public class ChangeCase {
    public static void main(String[] args) {
        String str1 = "Hello World";
        System.out.println("Original String: " + str1);

        char[] ch = new char[str1.length()];
        for (int i = 0; i < str1.length(); i++) {
            ch[i] = str1.charAt(i);
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] += 32;
            } else if (ch[i] >= 'a' && ch[i] <= 'z') {
                ch[i] -= 32;
            }
        }
        String str2 = String.valueOf(ch);
        System.out.println("Changed String: " + str2);
    }
}
