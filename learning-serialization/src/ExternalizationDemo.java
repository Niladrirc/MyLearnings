import java.io.*;

public class ExternalizationDemo implements Externalizable {
    String s;
    int i;
    int j;

    public ExternalizationDemo() {
        System.out.println("Inside public no-args constructor");
    }

    ExternalizationDemo(String s, int i, int j) {
        this.s = s;
        this.i = i;
        this.j = j;
        System.out.println("Inside args constructor");
    }


    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeObject(s);
        out.writeInt(i);

    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        s = (String) in.readObject();
        i = in.readInt();

    }

    public static void main(String[] args) throws Exception {
        ExternalizationDemo obj1 = new ExternalizationDemo("Niladri", 2, 3);

        FileOutputStream fos = new FileOutputStream("./A.json");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj1);

        FileInputStream fis = new FileInputStream("./A.json");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ExternalizationDemo obj2 = (ExternalizationDemo) ois.readObject();
        System.out.println(obj2.s+"..."+obj2.i+"..."+obj2.j);

    }


}
