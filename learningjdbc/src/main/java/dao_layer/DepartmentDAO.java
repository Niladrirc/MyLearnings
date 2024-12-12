package dao_layer;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class DepartmentDAO {
    private final Department department;

    @Inject
    public DepartmentDAO(Department department) {
        this.department = department;
    }

    public Department getDepartment(String departmentId) {
        try {
            String query = "SELECT * from `departments` where `dept_no`=?";
            Connection conn = getConnection();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, departmentId);
            ResultSet rs = st.executeQuery();
            rs.next();
            department.setDepartmentId(rs.getString(1));
            department.setDepartmentName(rs.getString(2));
            st.close(); conn.close();
            return department;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addDepartment(Department dept) {
        String query = "INSERT INTO `departments` (dept_no, dept_name) VALUES (?, ?);";
        int affectedRows;
        try {
            Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, dept.getDepartmentId());
            pst.setString(2, dept.getDepartmentName());

            affectedRows = pst.executeUpdate();
            log.info("{} rows affected", affectedRows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return affectedRows;
    }

    private Connection getConnection() {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "Machine@123");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
