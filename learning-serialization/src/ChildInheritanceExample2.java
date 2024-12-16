import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ChildInheritanceExample2 {
    public static void main(String[] args) throws Exception {
        C c = new C();

        FileOutputStream fos = new FileOutputStream("./A.json");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(c);

        FileInputStream fis = new FileInputStream("./A.json");
        ObjectInputStream ois = new ObjectInputStream(fis);
        C c1 = (C) ois.readObject();

        System.out.println(c1.getA() + " ... "+c1.getB());
    }
}
