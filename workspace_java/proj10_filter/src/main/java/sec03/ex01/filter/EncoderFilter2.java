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

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*")
public class EncoderFilter2 extends HttpFilter implements Filter {
      
    public EncoderFilter2() {
        super();
        System.out.println("필터 생성");
    }

	public void destroy() {
		System.out.println("필터 소멸");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/*
		 * 여기는 서블릿 실행 전
		 */
		System.out.println("실행 전");
		
		// 서블릿 실행
		chain.doFilter(request, response);
		
		/*
		 * 여기는 서블릿 실행 후
		 */
		System.out.println("실행 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("필터 init 실행");
	}

}
