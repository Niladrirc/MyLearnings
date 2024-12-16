import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Basic {
    public static void main(String[] args) throws Exception {
        B b = new B();
        FileOutputStream fos = new FileOutputStream("./A.json");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(b);

        FileInputStream fis = new FileInputStream("./A.json");
        ObjectInputStream ois = new ObjectInputStream(fis);
        B b1 = (B) ois.readObject();

        System.out.println(b1.getAObject().getA() + " ... "+b1.getAObject().getB());
    }
}
