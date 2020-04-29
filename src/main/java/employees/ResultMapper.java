package employees;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ResultMapper implements RowMapper<Result> {

	public Result mapRow(ResultSet resultSet, int i) throws SQLException {

		Result result = new Result();
		result.setEmp_no(resultSet.getInt("emp_no"));
		result.setFirst_name(resultSet.getString("first_name"));
		result.setLast_name(resultSet.getString("last_name"));
		result.setDept_name(resultSet.getString("dept_name"));
		result.setSalary(resultSet.getInt("salary"));
		return result;
		
	}
}