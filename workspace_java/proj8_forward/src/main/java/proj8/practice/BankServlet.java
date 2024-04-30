package proj8.practice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bank")
public class BankServlet extends HttpServlet {
	BankClass bank = new BankClass(0,"실로은행");
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8;");

		request.setAttribute("getResult", bank.getResult());
		
		request.getRequestDispatcher("bank.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("dps") != null) {
			String dpsValue = request.getParameter("dps");
//			System.out.println(dpsValue);
			bank.deposit(dpsValue);
//			System.out.println("잔액은 "+bank.getResult()+"입니다");
		} 
		
		if(request.getParameter("pm") != null) {
			String pmValue = request.getParameter("pm");
//			System.out.println(pmValue);
			bank.payment(pmValue);
			
		}
		response.sendRedirect("bank");
	
		
	}
}
