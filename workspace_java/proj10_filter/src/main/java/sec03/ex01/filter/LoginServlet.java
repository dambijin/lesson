package sec03.ex01.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FilterServletPR
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8;");

		String user_name = request.getParameter("user_name");
		String user_pw = request.getParameter("user_pw");

		System.out.println("이름 : " + user_name);
		System.out.println("비밀번호 : " + user_pw);

		response.getWriter().println("이름 : " + user_name);
		response.getWriter().println("<br>비밀번호 : " + user_pw);
		
		if("admin".equals(user_name)
				&& "1234".equals(user_pw)) {
			request.getSession().setAttribute("login", true);
			response.sendRedirect("main");
		}
			

	}

}
