package dao_layer;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.*;

@Slf4j
public class DepartmentDAO {
    private final Department department;
    private final DataSource datasource;
    private static final String URL = "jdbc:mysql://localhost:3306/employees";
    private static final String USER_NAME = "root";
    private static final String PASS = "Machine@123";

    @Inject
    public DepartmentDAO(Department department, DataSource datasource) {
        this.department = department;
        this.datasource = datasource;
    }

    public Department getDepartment(String departmentId) {
        String query = "SELECT * from `departments` where `dept_no`=?";
        try (Connection conn = datasource.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, departmentId);
            ResultSet rs = st.executeQuery();
            rs.next();
            department.setDepartmentId(rs.getString(1));
            department.setDepartmentName(rs.getString(2));
            return department;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addDepartment(Department dept) {
        String query = "INSERT INTO `departments` (dept_no, dept_name) VALUES (?, ?);";
        int affectedRows;
        try (Connection conn = datasource.getConnection();
             PreparedStatement pst = conn.prepareStatement(query);) {
            pst.setString(1, dept.getDepartmentId());
            pst.setString(2, dept.getDepartmentName());

            affectedRows = pst.executeUpdate();
            log.info("{} rows affected", affectedRows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return affectedRows;
    }

    public void deleteDepartment(String deptId) {
        String query = "DELETE FROM `departments` where dept_no=?";
        int affectedRows;
        try (Connection conn = datasource.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)){

            pst.setString(1, deptId);
            affectedRows = pst.executeUpdate();
            log.info("{} rows affected", affectedRows);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
