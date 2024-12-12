package dao_layer;

import com.google.inject.Inject;

import java.sql.*;

public class DepartmentDAO {
    private final Department department;

    @Inject
    public DepartmentDAO(Department department) {
        this.department = department;
    }

    public Department getDepartment(String departmentId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "Machine@123");
            PreparedStatement st = conn.prepareStatement("SELECT * from `departments` where `dept_no`=?");
            st.setString(1, departmentId);

            ResultSet rs = st.executeQuery();
            rs.next();
            department.setDepartmentId(rs.getString(1));
            department.setDepartmentName(rs.getString(2));

            return department;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
