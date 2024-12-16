import java.io.*;

public class Basic {
    public static void main(String[] args) throws Exception {
        A a = new A();
        FileOutputStream fos = new FileOutputStream("./A.json");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a);

        FileInputStream fis = new FileInputStream("./A.json");
        ObjectInputStream ois = new ObjectInputStream(fis);
        A a1 = (A) ois.readObject();

        System.out.println(a1.getA() + " ... "+a1.getB());
    }
}
