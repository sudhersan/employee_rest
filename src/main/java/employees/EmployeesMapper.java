package employees;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeesMapper implements RowMapper<Employees> {

	public Employees mapRow(ResultSet resultSet, int i) throws SQLException {

		Employees employees = new Employees();
		employees.setEmp_no(resultSet.getInt("emp_no"));
		employees.setBirth_date(resultSet.getDate("birth_date"));
		employees.setFirst_name(resultSet.getString("first_name"));
		employees.setLast_name(resultSet.getString("last_name"));
		employees.setGender(resultSet.getString("gender"));
		employees.setHire_date(resultSet.getDate("hire_date"));
		return employees;
	}
}