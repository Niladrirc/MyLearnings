import java.io.Serializable;

public class C extends A implements Serializable {
    public C() {
        super(5);
        System.out.println("Inside non-parametrized constructor of child class C");
    }
}
