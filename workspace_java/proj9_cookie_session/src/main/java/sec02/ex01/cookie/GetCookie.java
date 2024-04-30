package sec02.ex01.cookie;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class GetCookie extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8;");
		
		// 없으면 null
		Cookie[] cookies = request.getCookies();
		System.out.println(cookies);
		
		boolean key2_chk=false;
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				Cookie c = cookies[i];
				
				System.out.println("쿠키 이름 : "+c.getName());
				System.out.println("쿠키 값 : "+c.getValue());
				
				String name = c.getName();
				if("key".equals(name)) {
					response.getWriter().println("key로 저장된 쿠키의 값 : "+ c.getValue());
				}

				
				if("key2".equals(name)) {
					String han = URLDecoder.decode(c.getValue());
					System.out.println("디코딩된 han : "+ han);
					response.getWriter().println("key2로 저장된 쿠키의 값 : "+ han);
					key2_chk=true;
				}
			}
		}
		
		// "key" 이름을 가진 쿠키가 있는지 없었는지 출력?
		
		// 쿠키 중에 이름이 "key2"인게 있었으면
		// 안보여주고 없었으면 보여주고
		if(!key2_chk) {
			response.getWriter().println("<div style='border:1px solid red;'>팝업표시</div>");
		}
		
	}
}
