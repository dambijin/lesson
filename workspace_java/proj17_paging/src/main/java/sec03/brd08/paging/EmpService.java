package sec03.brd08.paging;

import java.util.List;

public class EmpService {
	
	List<EmpDTO> listEmp(){
		EmpDAO empDAO = new EmpDAO();
		List list = empDAO.selectEmp();
		
		return list;
		
	}
	
}
