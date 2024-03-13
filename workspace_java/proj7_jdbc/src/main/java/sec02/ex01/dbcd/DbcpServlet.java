package sec02.ex01.dbcd;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec01.ex01.jdbc.part.EmpDTO;

@WebServlet("/dbcp")
public class DbcpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
		DbcpDAO dbcpDAO = new DbcpDAO();
		dbcpDAO.listEmp();
		
		String command = request.getParameter("command");
		if(command ==null) {
			List list =dbcpDAO.listEmp();
			System.out.println("총 개수 : "+list.size());
			
			for (int i = 0; i < list.size(); i++) {
				EmpDTO empDTO = (EmpDTO) list.get(i);
				int empno = empDTO.getEmpno();
				String ename = empDTO.getEname();
				int sal = empDTO.getSal();
				response.getWriter().println("<div>empno : " + empno + "/ ename : " + ename + "/ sal : "+sal +"</div>");
			}
			return;
		} else if("insert".equals(command)){
			String empnoStr = request.getParameter("empno");
			String ename = request.getParameter("ename");
			String salStr = request.getParameter("sal");
			String deptnoStr = request.getParameter("deptno");
			
			EmpDTO empDTO =new EmpDTO();
			int empno = Integer.parseInt(empnoStr);
			empDTO.setEmpno(empno);
			
			int result=dbcpDAO.insertEmp2(empnoStr, ename,salStr,deptnoStr);
			System.out.println("insert 결과 : "+result);
		}
		
	
	}

}
