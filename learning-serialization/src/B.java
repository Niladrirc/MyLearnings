import java.io.Serializable;

public class B implements Serializable {
    private A a = new A();

    public B() {
        System.out.println("Inside non-parametrized constructor of B class");
    }

    public B(A a) {
        System.out.println("Inside parametrized constructor of B class");
        this.a = a;
    }

    public A getAObject() {
        return a;
    }
}
