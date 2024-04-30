package sec03.ex01.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Boolean login = (Boolean) request.getSession().getAttribute("login");
//		if(login == null || login !=true) {
//			response.sendRedirect("login.html");
//		}
		response.getWriter().println("<h1>민수와 우리들의 비밀공간♥</h1>");
	}
}
