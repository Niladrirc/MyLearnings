package employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private int emp_no;
    private Date birth_date;
    private String firstName;
    private String lastName;
    private char gender;
    private Date hireDate;
}
