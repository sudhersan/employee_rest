package employees;

import java.util.HashMap;
import java.util.Map;

public class EmployeeAuth {
	
	public static Map<String, Integer> EmpAuth() {
		Map<String, Integer> empAuth = new HashMap<>();
		empAuth.put("563b6bc4-f31a-40b2-bbd2-c475c7a375bd",100001);
		empAuth.put("a33dcad9-8d66-4b7d-890f-99d92c6491c2",100002);
		empAuth.put("c0455fe9-3106-4a7a-b347-eb4fd2c6d166",100003);
		empAuth.put("2d8bbc22-0106-40c3-819f-0cebacffbc19",100004);
		empAuth.put("6318f8ae-ff59-46a7-8e78-7599f91971f5",100005);
		empAuth.put("50a63c32-09bc-4202-b526-95d80c6bb1e2",100006);
		empAuth.put("06778cfd-db6f-49f2-af9b-13f0e14ac24f",100007);
		empAuth.put("91697fc2-4c18-42b4-bf00-2289de213d13",100008);
		empAuth.put("0fafdd17-0225-4f9d-aea0-eae6f4d8c9a0",100009);
		empAuth.put("09386208-c018-4725-859e-5ff69012b98e",100010);
		empAuth.put("e79b1c21-8013-407b-8e34-98d47af49eb2",-1);
		return empAuth;
	}

}


