package practice.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PRSession
 */
@WebServlet("/prsession")
public class PRSession extends HttpServlet {
	String id = "admin";
	String pw = "1234";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("loginpractice.jsp").forward(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usid= request.getParameter("id");
		String udpw= request.getParameter("pw");
		
		if(id.equals(usid) && pw.equals(udpw)) {
			HttpSession session = request.getSession();
			session.setAttribute("session",session);
			response.sendRedirect("mainpractice.jsp");
		}else {
			response.sendRedirect("prsession");
		}
		
		
	}

}
