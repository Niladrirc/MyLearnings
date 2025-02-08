import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student("Prapti", "Chemistry"),
                new Student("Riddhi", "Physics")
        };

        Tutor tutor = new Tutor("Teacher", students);
        System.out.println(tutor.getTutees());

        students[0].setName("Paagli");
        System.out.println(tutor.getTutees());
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
    }
}