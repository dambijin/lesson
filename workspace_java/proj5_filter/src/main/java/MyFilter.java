
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/*")
public class MyFilter extends HttpFilter implements Filter {

//    public MyFilter() {
//        super();
//    }

	// 필터가 파괴될 때
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("doFilter 실행");
		// 반복해야 할 작업
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		// 필터는 항상 경량화가 필요
		// 테스트를 위해 잠깐하는건 가능
		long start = System.currentTimeMillis();

		if (request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) request;
			String url = req.getRequestURI();
			System.out.println("요청 url : " + url);

			if (url.indexOf("login.jsp") != -1 || url.indexOf("/logout") != -1 || url.indexOf("/asset/") != -1
					|| url.indexOf("join.do") != -1) {
				// 그냥 통과
				chain.doFilter(request, response);
			} else {
				HttpSession session = req.getSession();

				String isLogon = (String) session.getAttribute("isLogon");
				if ("OK".equals(isLogon)) {
					// 로그인 했다면
					chain.doFilter(request, response);
				} else {
					// 로그인을 안했다면
					HttpServletResponse resp = (HttpServletResponse) response;
					resp.sendRedirect("login.jsp");
				}

			}
		}
		// 서블릿 등의 동작
//		chain.doFilter(request, response);

		long end = System.currentTimeMillis();
		System.out.println("걸린시간[ms] :" + (end - start));
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
