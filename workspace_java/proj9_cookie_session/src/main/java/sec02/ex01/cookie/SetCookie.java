package sec02.ex01.cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookie extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
		
		Cookie c = new Cookie("key", "value");
		// setMaxAge를 설정하지 않거나
		// 음수를 넣으면
		// 세션쿠키가 된다
		// 즉, 브라우저 메모리에만 저장된다
		// 즉2, 브라우저의 모든 탭을 끄면 사라진다
		c.setMaxAge(-1);// 초단위
		response.addCookie(c);
		
		String han = "한글";
		han = URLEncoder.encode(han, "utf-8");
		System.out.println("인코딩된 han : "+ han);
		
		Cookie c2 = new Cookie("key2", han);
		c2.setMaxAge(10);// 초단위
		response.addCookie(c2);

		System.out.println("쿠키 세팅 완료");
	}
}
