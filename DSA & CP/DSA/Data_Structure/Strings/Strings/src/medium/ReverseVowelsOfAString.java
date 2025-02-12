package medium;

import java.util.HashMap;
import java.util.Map;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String s = "IceCreAm";
//        String reverse = reverseVowels(s);
        Object o1 = new Object();
        System.out.println(o1.hashCode());

        Student s1 = new Student(1, "S1");
        Student s2 = new Student(1, "S2");

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s1));

        HashMap<Student, Integer> map = new HashMap<>();
        map.put(s1, 1);
        map.put(s1, 1);
        map.put(new Student(1, "S1"), 1);
        map.put(new Student(1, "S1"), 1);

        System.out.println(map.keySet());

//        System.out.println(reverse);
    }

//    private static String reverseVowels(String s) {
//
//    }
}

class Student {
    private final int rollNo;
    private final String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return 111;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public String toString() {
        return "Student: [rollNo: " + rollNo + ", name: "+name+"]";
    }
}
