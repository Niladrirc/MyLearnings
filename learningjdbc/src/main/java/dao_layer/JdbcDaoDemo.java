package dao_layer;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import dao_layer.guice.DAOModule;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
public class JdbcDaoDemo {
    private final DepartmentDAO deptAccessObj;

    @Inject
    public JdbcDaoDemo(DepartmentDAO deptAccessObj) {
        this.deptAccessObj = deptAccessObj;
    }

    public static void main(String[] args) throws Exception {
        Injector injector = Guice.createInjector(new DAOModule());
        JdbcDaoDemo demoApp = injector.getInstance(JdbcDaoDemo.class);
        demoApp.run();
    }

    private void run() {
        Department dept = deptAccessObj.getDepartment("d009");
        log.info("DepartmentID: [{}] | DepartmentName: [{}]", dept.getDepartmentId(), dept.getDepartmentName());

        Department newDept = new Department("d010", "Engineering");
        deptAccessObj.addDepartment(newDept);

        
    }
}
