package src.learn;

public class Learning {
    public static void main(String[] args) {
        CircularListADT circularList = new CircularListADT();
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        circularList.display();

        circularList.remove(2);
        circularList.display();

    }
}
