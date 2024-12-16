import java.io.Serializable;

public class A implements Serializable {
    private int a=10;
    private int b=20;

    public A() {
        System.out.println("Inside default constructor of A class");
    }

    public int getA() {
        System.out.println("Returning a value");
        return a;
    }

    public void setA(int a) {
        System.out.println("Setting a value");
        this.a = a;
    }

    public int getB() {
        System.out.println("Returning b value");
        return b;
    }

    public void setB(int b) {
        System.out.println("Setting b value");
        this.b = b;
    }
}
