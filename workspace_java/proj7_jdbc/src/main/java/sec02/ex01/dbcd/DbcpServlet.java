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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8;");

		DbcpDAO dbcpDAO = new DbcpDAO();

		String command = request.getParameter("command");
		if (command == null) {
			List list = dbcpDAO.listEmp();

			System.out.println("총 개수 : " + list.size());

			for (int i = 0; i < list.size(); i++) {
				EmpDTO empDTO = (EmpDTO) list.get(i);
				int empno = empDTO.getEmpno();
				String ename = empDTO.getEname();
				int sal = empDTO.getSal();

				response.getWriter().println("<div>empno : " + empno + ", ename : <a href='dbcp?command=detail&empno="
						+ empno + "'>" + ename + "</a>, sal : " + sal
						+ "<button type='button'><a href='dbcp?command=delete&empno=" + empno + "'>삭제</a></button></div>");
			}
			return;
		} else if ("insert".equals(command)) {
			String empnoStr = request.getParameter("empno");
			int empno = Integer.parseInt(empnoStr);
			String ename = request.getParameter("ename");
			String salStr = request.getParameter("sal");
			int sal = Integer.parseInt(salStr);
			String deptnoStr = request.getParameter("deptno");
			int deptno = Integer.parseInt(deptnoStr);

			EmpDTO empDTO = new EmpDTO();
			empDTO.setEmpno(empno);
			empDTO.setEname(ename);
			empDTO.setSal(sal);
			empDTO.setDeptno(deptno);

//			int result = dbcpDAO.insertEmp2(empnoStr, ename, salStr, deptnoStr);
			int result = dbcpDAO.insertEmp2(empDTO);
			System.out.println("insert 결과 : " + result);

			// list페이지로 이동
			response.sendRedirect("dbcp");

		} else if ("detail".equals(command)) {

			String strEmpno = request.getParameter("empno");
			int empno = Integer.parseInt(strEmpno);

			List list = dbcpDAO.listEmp(empno);
			if (list.size() == 0) {
				response.getWriter().println("<div>조회된 사원이 없습니다</div>");
			} else {
				EmpDTO dto = (EmpDTO) list.get(0);
				response.getWriter().println("<form method='get' action='dbcp'>");
				response.getWriter().println("    <div>empno  : " + dto.getEmpno() + "'</div>");
				response.getWriter().println(
						"    <div>ename  : <input type='text' name='ename' value='" + dto.getEname() + "'></div>");
				response.getWriter()
						.println("    <div>job    : <input type='text' name='job' value='" + dto.getJob() + "'></div>");
				response.getWriter()
						.println("    <div>sal    : <input type='text' name='sal' value='" + dto.getSal() + "'></div>");
				response.getWriter().println(
						"    <div>deptno : <input type='text' name='deptno' value='" + dto.getDeptno() + "'></div>");
				response.getWriter().println("    <input type='hidden' name='empno' value='" + dto.getEmpno() + "'>");
				response.getWriter().println("    <input type='hidden' name='command' value='modify'>");
				response.getWriter().println("    <input type='submit' value='수정'>");
				response.getWriter().println("    <a href='dbcp'><button type='button'>취소</button></a>");
				response.getWriter().println("</form>");
			}

		} else if ("modify".equals(command)) {

			String empnoStr = request.getParameter("empno");
			int empno = Integer.parseInt(empnoStr);
			String ename = request.getParameter("ename");
			String salStr = request.getParameter("sal");
			int sal = Integer.parseInt(salStr);
			String job = request.getParameter("job");

			EmpDTO empDTO = new EmpDTO();
			empDTO.setEmpno(empno);
			empDTO.setEname(ename);
			empDTO.setSal(sal);
			empDTO.setJob(job);

			int result = dbcpDAO.updateEmp2(empDTO);
			System.out.println("update 결과 : " + result);

			// list페이지로 이동
			response.sendRedirect("dbcp");
		} else if ("delete".equals(command)) {

			String strEmpno = request.getParameter("empno");
			int empno = Integer.parseInt(strEmpno);

			int result = dbcpDAO.deleteEmp2(empno);
			System.out.println("삭제 결과 : "+ result);
			// list페이지로 이동
			response.sendRedirect("dbcp");

		}

	}

}
