import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class DemoInsertIntoDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employees";
        String username = "root";
        String pass = "Machine@123";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, pass);
            Statement st = conn.createStatement();

            int affectedRows = st.executeUpdate("INSERT INTO `employees` (emp_no, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) " +
                    "VALUES (1, DATE('1990-10-03'), 'Niladri', 'Ray Choudhury', 'M', DATE('2001-04-04'))");

            log.info("{} row/s affected", affectedRows);

            st.close(); conn.close();

        } catch (ClassNotFoundException e) {
            log.error("Driver class not found", e);
        } catch (SQLException e) {
            log.error("Error is db connection: ", e);
        }
    }
}
