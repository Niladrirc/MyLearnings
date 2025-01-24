import iterators.GenericList;

import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GenericList<Integer> intList = new GenericList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);

        Iterator<Integer> iterator = intList.iterator();
        System.out.print("[");
        while (iterator.hasNext()) {
                System.out.print(iterator.next());
                if (iterator.hasNext())
                    System.out.print(", ");
        }

        System.out.print("]\n");
    }
}