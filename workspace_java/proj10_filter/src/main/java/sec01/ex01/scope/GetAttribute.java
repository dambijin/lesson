package sec01.ex01.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		// 없으면 null
		String strctx = (String)ctx.getAttribute("context");
		String strSession = (String)session.getAttribute("session");
		String strreq = (String)request.getAttribute("request");
		
		System.out.println("strctx : " + strctx);
		System.out.println("strSession : " + strSession);
		System.out.println("strreq : " + strreq);
	}

}
