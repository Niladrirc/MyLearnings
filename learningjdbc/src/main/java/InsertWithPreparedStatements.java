import employee.Employee;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class InsertWithPreparedStatements {
    public static void main(String[] args) {
        Employee emp = new Employee();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/employees";
            String userName = "root";
            String pass = "Machine@123";
            emp.setEmp_no(1);
            emp.setBirth_date(new Date(686452380L));
            emp.setFirstName("Niladri");
            emp.setLastName("Ray Choudhury");
            emp.setGender('M');
            emp.setHireDate(new Date(System.currentTimeMillis()/1000));

            String sql = "INSERT INTO `employees` (emp_no, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";

            Connection conn = DriverManager.getConnection(url, userName, pass);
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, emp.getEmp_no());
            pst.setDate(2, emp.getBirth_date());
            pst.setString(3, emp.getFirstName());
            pst.setString(4, emp.getLastName());
            pst.setString(5, String.valueOf(emp.getGender()));
            pst.setDate(6, emp.getHireDate());

            int affectedRows = pst.executeUpdate();

            log.info("{} row/s affected", affectedRows);
            pst.close(); conn.close();
        } catch (ClassNotFoundException e) {
            log.error("Driver class not found.", e);
        } catch (SQLException e) {
            log.error("Error is db connection: ", e);
        }
    }
}
