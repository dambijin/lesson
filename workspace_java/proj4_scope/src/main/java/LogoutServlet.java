
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// invalidate : 세션을 완전 삭제하기
		session.invalidate();
		System.out.println("로그 아웃 성공");
		
		// invalidate 호출 후에 아직은 남아있지만 사용은 못함
//		System.out.println("isLogon : "+session.getAttribute("isLogon"));
		// sendRedirect 로그인 페이지로
		

	}

}
