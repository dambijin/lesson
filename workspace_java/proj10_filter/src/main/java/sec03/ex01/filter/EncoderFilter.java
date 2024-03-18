package sec03.ex01.filter;

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

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*")
public class EncoderFilter extends HttpFilter implements Filter {

	public EncoderFilter() {
		super();
		System.out.println("필터 생성");
	}

	public void destroy() {
		System.out.println("필터 소멸");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		/*
		 * 여기는 서블릿 실행 전
		 */
		System.out.println("실행 전");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// 원래 적은 주소
		// http://localhost:8080/proj10_filter/login?user_name=민수&user_pw=한글
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		StringBuffer sb = req.getRequestURL();
		String url = sb.toString();
		System.out.println("getReqURL : " + url);

		String uri = req.getRequestURI();
		System.out.println("getReqURI : " + uri);

		String ctxpath = req.getContextPath();
		System.out.println("getReqPath : " + ctxpath);

		String spath = req.getServletPath();
		System.out.println("getServletPath : " + spath);

		String q = req.getQueryString();
		System.out.println("getqPath : " + q);

		// isExclude 메소드 사용함
		// spath = req.getServletPath()
		if (isExclude(req.getServletPath())) {
			System.out.println("걍 가던길 가셈");
			// 자원에 접근
			chain.doFilter(request, response);
		} else {

			Boolean login = (Boolean) req.getSession().getAttribute("login");
			if (login == null || login != true) {
				resp.sendRedirect("login.html");
			} else {
				// 자원에 접근
				chain.doFilter(request, response);
			}
		}

		// 서블릿 실행 후
		System.out.println("실행 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("필터 init 실행");
	}
	
	private boolean isExclude(String servletPath) {
		// indexOf : "a b c d e".indexOf("d") == 3
		// indexOf : "a b c d e".indexOf("a") == 0
		// indexOf : "a b c d e".indexOf("de") == 3
		// indexOf : "a b c d e".indexOf("h") == -1
		// indexOf : 글씨가 어디에 포함 되어있느냐 아니냐를 따짐		
		if (servletPath.indexOf("login.html") != -1
		 || servletPath.indexOf("/login") != -1	) {
			return true;
		}else {
			return false;
		}
		
	}

}
