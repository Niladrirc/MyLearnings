package creationalDesignPatterns.singleton.serialization_test;

import java.io.*;

public class SerializedSingletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        SerializedSingleton instanceTwo = null;

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        // deserialize
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("filename.ser"));
        instanceTwo = (SerializedSingleton) in.readObject();
        in.close();


        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }
}
