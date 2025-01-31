package calender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyCalendarTwo {
    List<List<Integer>> bookings;
    List<List<Integer>> doubleBookings;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (List<Integer> booking : doubleBookings) {
            int x = Math.max(booking.get(0), startTime);
            int y = Math.min(booking.get(1), endTime);
            if (x < y) {
                return false;
            }
        }
        // Check if can be added to double booking list
        for (List<Integer> interval: bookings) {
            int x = Math.max(interval.get(0), startTime);
            int y = Math.min(interval.get(1), endTime);
            if (x < y) {
                doubleBookings.add(Arrays.asList(x, y));
            }
        }
        bookings.add(Arrays.asList(startTime, endTime));
        return true;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        MyCalendarTwo obj = new MyCalendarTwo();
        System.out.println(obj.book(10,20));
        System.out.println(obj.book(50,60));
        System.out.println(obj.book(10,40));
        System.out.println(obj.book(5,15));
        System.out.println(obj.book(5,10));
        System.out.println(obj.book(25,55));
    }
}

