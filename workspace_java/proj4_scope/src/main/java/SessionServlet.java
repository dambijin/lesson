
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * application
	 * - 같은 tomcat에 사용 가능
	 * session
	 * - 같은 브라우저에서는 계속 사용 가능
	 * request
	 * - 요청때 생겨서 응답때 사라짐
	 * page
	 * - 딱 그 jsp안에서만 사용 가능
	 * 
	 * */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 새로운 세션이면 세션을 생성해서 올려줌
		HttpSession session = request.getSession();
		
		// session.isNew() : 세션이 현재 새로 생성되었는지 아닌지 이야기 해주어야 함
		if(session.isNew()) {
			System.out.println("처음 보는 브라우저");
		} else {
			System.out.println("아까 왔던 브라우저");
		}
		// session.getId() : jsession id를 알수있따
		System.out.println(session.getId());
		
		// 새로운 세션이면 null
//		HttpSession session = request.getSession(false);
		
		String id= request.getParameter("id");
//		관리자 아이디로 로그인 했을 때 
//		if(id.equals("admin")) {
		if("admin".equals(id)) {
			session.setAttribute("isLogon", true);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
