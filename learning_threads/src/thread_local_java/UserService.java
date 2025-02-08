package thread_local_java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserService {
    public static void main(String[] args) {
        new Thread(() -> {
            String date = getDateOfBirth(100);
            System.out.println(date);
        }).start();

        new Thread(() -> {
            String date = getDateOfBirth(100);
            System.out.println(date);
        }).start();


    }

    public static String getDateOfBirth(int id) {
        Date time = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(time);
    }
}
