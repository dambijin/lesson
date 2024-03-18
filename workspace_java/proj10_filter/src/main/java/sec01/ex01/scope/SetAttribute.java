package sec01.ex01.scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		
		// 바인딩 : 묶는다
		// 세션 생성
		// 3개 다 가방이 다르다
		ctx.setAttribute("context", "context에 바인딩");
		
		session.setAttribute("session", "session에 바인딩");
		
		request.setAttribute("request", "request에 바인딩");
		
		System.out.println("바인딩 완료");
	}


}
