import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * 7 steps to connect java app to DB.
 * 1. Import package
 * 2. Load & Register the driver (optional)
 * 3. Create a connection object of type Connection Interface from any implementing class
 * 4. Create a statement object (it can be a statement, preparedStatement or connectedStatement)
 * 5. Execute the statement using the connection object
 * 6. Process the result
 * 7. Close the connection & statement objects
 */

@Slf4j
public class Demo {

    public static void main(String[] args) {

        // Registering the driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "SELECT * FROM employees where emp_no=1;";
            String url = "jdbc:mysql://localhost:3306/employees";
            String user = "root";
            String password = "Machine@123";

            // Creating connection object
            Connection conn = DriverManager.getConnection(url, user, password);

            // Creating statement object
            Statement statement = conn.createStatement();

            // Executing the query
            ResultSet rs = statement.executeQuery(sql);

            // Process the result
            while (rs.next()) {
                log.info("Emp No: {} | Name: {} {} | DOJ: {} ",
                        rs.getInt("emp_no"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("hire_date"));
            }

            // Close the connection and statement object
            statement.close(); conn.close();

        } catch (ClassNotFoundException e) {
            log.error("Driver class not found", e);
        } catch (SQLException e) {
            log.error("Error with SQL connection", e);
        }
    }
}
