
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UrlTest
 */

// /* 이 표시는 어떤걸로들어와도 url이 포함되면 모두 선택
@WebServlet("/url/*")
// url여러가지의 값을 줄땐 아래와 같이 사용한다
//@WebServlet(urlPatterns={"/url/a","/url/b"})
public class UrlTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8080/proj5_filter/url/abc/123?num=12&name=asdf
		
		// url : uniform resorce
		// 요청 url
        StringBuffer url = request.getRequestURL();
        System.out.println("getRequestURL : "+ url);

        // 서버 주소를 제외한 주소
        String uri = request.getRequestURI();
        System.out.println("getRequestURI : "+ uri);

        // 어플리케이션(컨텍스트) 경로
        String ctxPath = request.getContextPath();
        System.out.println("getContextPath : "+ ctxPath);

        // 서블릿 경로
        String srvParh = request.getServletPath();
        System.out.println("getServletPath : "+ srvParh);

        // 요청 파라메터(쿼리 스트링)
        String qs = request.getQueryString();
        System.out.println("getQueryString : "+ qs);

	}

}
