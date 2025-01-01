package src.easy;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};

        System.out.println("Output: " + calPoints(ops));
    }

    private static int calPoints(String[] ops) {
        List<Integer> record = new ArrayList<>();
        int sum = 0;
        for (String op : ops) {
            switch (op) {
                case "+" -> {
                    sum += (record.get(record.size() - 1) + record.get(record.size() - 2));
                    record.add(record.get(record.size() - 1) + record.get(record.size() - 2));
                }
                case "D" -> {
                    sum += record.get(record.size() - 1) * 2;
                    record.add(record.get(record.size() - 1) * 2);
                }
                case "C" -> sum -= record.remove(record.size() - 1);
                default -> {
                    sum += Integer.parseInt(op);
                    record.add(Integer.parseInt(op));
                }
            }
        }
        return sum;
    }
}
