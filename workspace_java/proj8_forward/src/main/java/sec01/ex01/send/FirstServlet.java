package sec01.ex01.send;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first/next")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/first doGet");
		
//		바로 second로 이동
//		response.sendRedirect("second");
		
//		/second : 찾을 수 없음 (주소 : http://localhost:8080/second)
//		주소에서 proj8을 찾을 수없음
//		response.sendRedirect("/second");
		
//		바로 second로 이동
//		response.sendRedirect("/proj8_forward/second");
		
//		프로젝트 Path (컨텍스트 path) 만 가져옴
		response.sendRedirect(request.getContextPath()+"/second");
//		response.sendRedirect("http://www.naver.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/first doPost");
		response.getWriter().println("/first doPost");
		
		response.sendRedirect(request.getContextPath()+"/second");
	}

}
