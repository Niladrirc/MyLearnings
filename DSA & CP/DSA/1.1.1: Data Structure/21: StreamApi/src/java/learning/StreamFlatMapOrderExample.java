package src.java.learning;

import java.util.Arrays;
import java.util.List;

class Order {
    private String orderId;
    private List<String> orderItems;

    public Order(String orderId, List<String> orderItems) {
        this.orderId = orderId;
        this.orderItems = orderItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<String> getOrderItems() {
        return orderItems;
    }
}
public class StreamFlatMapOrderExample {
    public static void main(String[] args) {
        List<Order> orderList = Arrays.asList(
                new Order("1001", Arrays.asList("Item1", "Item2", "Item3")),
                new Order("1002", Arrays.asList("Item4", "Item5", "Item6")),
                new Order("1003", Arrays.asList("Item7", "Item8"))
        );

        List<String> orderItemList = orderList.stream()
                .flatMap(order -> order.getOrderItems().stream())
                .toList();

        System.out.println(orderItemList);
    }
}
