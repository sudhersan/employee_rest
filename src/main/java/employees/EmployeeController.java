package employees;

import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@RestController
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
 
       
    JdbcTemplate jdbcTemplate;
    
    @Autowired
	public EmployeeController(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}    
    
    
    private final String sql_select_empid = "select a.emp_no, a.first_name, a.last_name , d.dept_name , c.salary\r\n" + 
    								  "from employees a, dept_emp b, salaries c, departments d\r\n" + 
    								  "where \r\n" + 
    								  "a.emp_no = b.emp_no and \r\n" + 
    								  "b.dept_no  = d.dept_no and \r\n" + 
    								  "a.emp_no = c.emp_no and \r\n" + 
    								  "b.to_date = \"9999-01-01\" and\r\n" + 
    								  "a.emp_no = ?;";
    
    private final String sql_select_emp = "select emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees limit 10;";
    		
    
    
	@Autowired
	Environment environment;

	@Value("${spring.datasource.url}")
	private static String url;
	
	@Value("${spring.datasource.username}")
	private static String username;
	
	@Value("${spring.datasource.password}")
	private static String password;

    
        
    @GetMapping("/employees")
    public ResponseEntity<?> get( @RequestHeader("Authorization") String bearer_token){
	String token_all = bearer_token.replace("Bearer ","");
	Integer all = -1;
	Boolean chk_all = token_all != null && EmployeeAuth.EmpAuth().get(token_all) == all ? true : false;	

	if (chk_all) {
		List<Employees> AllEmployee = jdbcTemplate.query(sql_select_emp , new EmployeesMapper());
		return new ResponseEntity<List<Employees>>(AllEmployee,HttpStatus.OK);
	}
	else {
		logger.error("Invalid Token");
		return new ResponseEntity<String>("Invalid Token",HttpStatus.NOT_FOUND);
	}
}
    
    @GetMapping("/employees/{emp_no}")
    public ResponseEntity<?> get(@PathVariable Integer emp_no, @RequestHeader("Authorization") String bearer_token) {
   
    	String token = bearer_token.replace("Bearer ","");
   	
    	if(EmployeeAuth.EmpAuth().containsKey(token)) {
    		if(EmployeeAuth.EmpAuth().get(token).equals(emp_no)) {
        		List<Result> result = jdbcTemplate.query(sql_select_empid , new Object[] {emp_no} , new ResultMapper());
        		return new ResponseEntity<List<Result>>(result,HttpStatus.OK);
    		}
    		else {
    			logger.error("Invalid Emp ID :" + emp_no);
    			return new ResponseEntity<String>("Invalid EmpId",HttpStatus.NOT_FOUND);
    		}
    	}
    	else {
    		logger.error("Invalid Token");
    		return new ResponseEntity<String>("Invalid Token",HttpStatus.NOT_FOUND);
    	}
    	
   	   }    
}