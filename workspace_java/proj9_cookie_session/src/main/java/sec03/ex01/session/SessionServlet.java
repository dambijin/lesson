package sec03.ex01.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	
//	List list = new ArrayList();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기존 세션이 없으면 null을 return
		HttpSession session2 = request.getSession(false);
		
		// 기존 세션이 없으면 새로 만들어서 return
		HttpSession session1 = request.getSession();
	
		System.out.println("session 2 : "+session2);
		
		System.out.println("session 1 : "+session1);
		// 최초로 생성된 세션이라면 true, 기존에 생성되어 있떤 세션이라면 false
		System.out.println("session1.isNew() : "+session1.isNew());
		System.out.println("session1.getId() : "+session1.getId());
		// 세션 유지 시간
		System.out.println("session1.getMaxInactiveInterval() : "+session1.getMaxInactiveInterval());
		// 마지막에 접속한 시간이 나옴
		System.out.println("session1.getLastAccessedTime() : "+session1.getLastAccessedTime());
	
		String old_id = (String)session1.getAttribute("id");
		System.out.println("old_id : "+old_id);
		
		String id = "abcd";
		session1.setAttribute("id", id);
		
//		session1.setAttribute("마지막 유효시간","오후 12시 29분 14초");
//		String id = request.getParameter("id");
//		// DB에서 로그인 체크
//		session1.setAttribute("id",id);
//		
//		if(session1.isNew()) {
//			list.add(session1);
//		}
//		HttpSession session = (HttpSession) list.get(0);
//		String olg_id = (String) session.getAttribute("id");
	
		
		String url = response.encodeURL("session");
		System.out.println("URL : "+url);
		response.getWriter().println("<a href=''>session으로 이동</a>");
		
	}


}
