package org.zerock.w1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParServlet
 */
@WebServlet("/param")
public class ParServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		들어오는 한글 깨짐 방지
		request.setCharacterEncoding("UTF-8");

//		내보내는 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");

//		브라우저에서 보낸 값을 확보

//		key에 해당하는 값이 없으면 null
		String key = request.getParameter("key");
		System.out.println("key : " + key);
		String id = request.getParameter("id");
		System.out.println("id : " + id);

//		input에 값이 없으면 ""이게 오는거고, null은 아니다.
		PrintWriter out = response.getWriter();
		out.println("key : [" + key + "]");
		out.println("<br>");
		out.println("id : [" + id + "]");
		out.println("<br>");

//		키 game이 여러개인 경우
//		getParameter는 첫번째 값 하나만 가져옴
		String game = request.getParameter("game");
		System.out.println("game : " + game);
		out.println("game 단독 : [" + game + "]<br>");

		String[] games = request.getParameterValues("game");
//		for (String g : games) {
//			System.out.println("game : " + g);
//			out.println("game 반복 : [" + g + "]<br>");
//		}
		if(games != null) {
			for (String g : games) {
				System.out.println("game : " + g);
				out.println("game 반복 : [" + g + "]<br>");
			}
		}else {
			out.println("선택한 게임이 없습니다.<br>");
		}
		
		Enumeration en = request.getParameterNames();
		while(en.hasMoreElements()) { // 다음 요소가 있는가?
			String name= (String) en.nextElement(); // 다음 요소 가져오기
			System.out.println("name : "+name);
			
			String[] values = request.getParameterValues(name);
			if(values != null) {
				for(String g : values) {
					System.out.println("values : "+g);
					out.println("values : [" + g + "]<br>");
				}
			} else {
				out.println("선택한 게임이 없습니다.<br>");
			}
		}

	}

}
