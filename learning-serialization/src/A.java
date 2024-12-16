import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.*;

public class A implements Serializable {

    private int a=10;
    private int b=20;

    public A() {
        System.out.println("Inside non-parametrized constructor of A class");
    }

    public int getA() {
        System.out.println("Returning a value");
        return a;
    }

//    public void setA(int a) {
//        System.out.println("Setting a value");
//        this.a = a;
//    }

    public int getB() {
        System.out.println("Returning b value");
        return b;
    }

    public void setB(int b) {
        System.out.println("Setting b value");
        this.b = b;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        int c = a+20;
        oos.writeInt(c);
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        int c = ois.readInt();
        System.out.println("Custom value c = "+c);
    }
}
