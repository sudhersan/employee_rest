import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import employees.Application;
import employees.EmployeeController;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(EmployeeController.class)
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class EmployeeControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void employeeNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/100004").header("Authorization" , "2d8bbc22-0106-40c3-819f-0cebacffbc19"))
        	   .andExpect(status().isOk());
    }

}
