package sec03.ex01.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SecondServlet2", urlPatterns = { "/forward/second" })
public class SecondServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("forward second doGet");
		
		String id =	request.getParameter("id");
		System.out.println("id : "+ id);
		response.getWriter().println("/forward second doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("forward second doPost");
		response.getWriter().println("/forward second doPost");
	}

}
