package practice.ex01;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec01.ex01.jdbc.part.EmpDAO;
import sec01.ex01.jdbc.part.EmpDTO;
import sec02.ex01.dbcd.DbcpDAO;

@WebServlet("/practice")
public class PracticeServlet extends HttpServlet {
	PracticeDAO practiceDAO = new PracticeDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
		List emp = practiceDAO.listEmp();
		request.setAttribute("emp", emp);
//		jsp에 사용하기전에 출력용으로 사용함
//		그대로 for문 jsp에 이식
//		for (int i = 0; i < emp.size(); i++) {
//			EmpDTO empDTO = (EmpDTO) emp.get(i);			
//			int empno = empDTO.getEmpno();
//			String ename = empDTO.getEname();
//			String job = empDTO.getJob();
//			int mgr = empDTO.getMgr();
//			Date hiredate = empDTO.getHiredate();	
//			int sal = empDTO.getSal();
//			int comm= empDTO.getComm();
//			int deptno= empDTO.getDeptno();
//			System.out.println("empno : "+empno);
//		}

		request.getRequestDispatcher("practice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		where문
		String in_empno = request.getParameter("insert_empno");
		List empinsert = practiceDAO.processRequest(request, in_empno);
		request.setAttribute("empinsert", empinsert);

		
	}

}
